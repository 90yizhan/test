package com.ss.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 按几率产生随机数
 * 例如：产生2-99的随机数，让2-29的几率是85%，30-59的几率是10%，60-99的几率是5%
 * 思路：将总范围[2,99]分割成子范围[2,29]/(29,59]/(59,99]，产生的数具体在哪个范围，用几率来判断。
 *      可以将子范围的几率映射成[1,100]之间的数字排好序，对应子范围顺序，就是用[1,100]中的数字表示子范围的几率，例如：85/10/5--85%/10%/5%。
 *      然后随机产生[1,100]之间的整数，该数落在哪个区间，例如：[1,85]/[86,95]/[96,100]，就采用对应的哪个子范围[2,29]/(29,59]/(59,99]产生随机数。
 *   即：用户点击让系统在1-100中随机产生一个整数值，
 *      ①这个数值在[1,85]，即<=85就是85%的几率，然后再在[2,29]中随机产生一个数额，就是这位用户得到的红包数，
 *      ②这个数值在[86,95]，即在>=86，<=95之间的数值，就是10%的几率，然后再在(29,59]中随机产生一个数额，就是这位用户得到的红包数，
 *      ③这个数值在[96,100]，即在>=96，<=100之间的数值，就是5%的几率，然后再在(59,99]中随机产生一个数额，就是这位用户得到的红包数。
 */
public class RateRandomNumberUtil {
	/**
	 * 获取随机元宝
	 * AmountOddsSetEnum 字典集中取范围
	 * @return
	 */
	public static Integer getRandomMoney() {
		// 以下这些都是要从字典类中获取
		double min = AmountOddsSetEnum.AOS_MINA.cn();
		double max = AmountOddsSetEnum.AOS_MAXA.cn();
        List<Integer> separates = new ArrayList<Integer>();
        List<Integer> percents = new ArrayList<Integer>();
        // 以下这些都是要从字典类中获取
		Integer separate1 = AmountOddsSetEnum.AOS_AS1.cn();
		Integer separate2 = AmountOddsSetEnum.AOS_AS2.cn();
		separates.add(separate1);
		separates.add(separate2);
		Integer percent1 = AmountOddsSetEnum.AOS_OP1.cn();
		Integer percent2 = AmountOddsSetEnum.AOS_OP2.cn();
		Integer percent3 = AmountOddsSetEnum.AOS_OP3.cn();
		percents.add(percent1);
		percents.add(percent2);
		percents.add(percent3);
		Double money= produceRateRandomNumber(min, max, separates, percents);
		Integer moneyYb = Integer.valueOf(String.format("%.0f",money));
		return moneyYb;
	}

    /**
     * 产生随机数
     * @param min 最小值
     * @param max 最大值
     * @return 
     */
    public static double produceRandomNumber(double min,double max){
    	Random rand = new Random(); 
        return rand.nextDouble() * (max-min) + min; // 在[min,max]区间的随机数          [0,1) （y-x）* r.nextDouble() + x    [x,y)
    }

    /**
     * 按比率产生随机数
     * @param min 最小值
     * @param max 最大值
     * @param separates 分割值   也就是例题中的 29  59  表示区间 2-29  29-59  59-99
     * @param percents 百分比   每段区间的几率  也就是例题中的85%  10%  5% 用数值表示就是85  10  5
     * @return 
     */
    public static double produceRateRandomNumber(double min,double max,List<Integer> separates,List<Integer> percents){

        if(min > max){
            throw new IllegalArgumentException("min值必须小于max值");
        }
        if(separates == null || percents==null || separates.size()==0){
            return produceRandomNumber(min,max);
        }
        if(separates.size() +1 != percents.size()){
            throw new IllegalArgumentException("分割数字的个数加1必须等于百分比个数");  // 例如：2个分割值，分成3段范围 
        }
        int totalPercent = 0;
        for(Integer p:percents){
            if(p<0 || p>100){
                throw new IllegalArgumentException("百分比必须在[0,100]之间");
            }
            totalPercent += p;
        }
        if(totalPercent != 100){
            throw new IllegalArgumentException("百分比之和必须为100");
        }
        for(Integer s:separates){
            if(s <= min || s >= max){
                throw new IllegalArgumentException("分割数值必须在(min,max)之间");
            }
        }
        int rangeCount = separates.size()+1;  // 例如：2个分割值，可以将一个数值范围分割成3段范围       rangeCount=3
        // 设计分割的每段范围
        List<Range> ranges = new ArrayList<Range>();
        int scopeMax = 0;  // 最大范围
        for(int i=0;i<rangeCount;i++){                                                     // i=0          1         2
            Range range = new Range();   
            // 范围区间左端                                                                                                                                                                       
            range.setMin(i == 0 ? min:separates.get(i-1));                                 // min=2        29        59
            // 范围区间右端                                                                                                                                                                                 
            range.setMax(i == rangeCount-1 ? max:separates.get(i));                        // max=29       59        99
            // 对应的百分比
            range.setPercent(percents.get(i));                                             // percent=85   10        5
            // 区间占比，转换为[1,100]区间的数字
            range.setPercentScopeMin(scopeMax +1);                                         // 1            86        96
            range.setPercentScopeMax(range.getPercentScopeMin() + (range.getPercent()-1)); // 1+84=85      86+9=95   96+4=100
            scopeMax = range.getPercentScopeMax();                                         // scopeMax=85  95        100
            ranges.add(range);                                                             // ranges:1-85  86-95     96-100
        }
        // 结果r
        double r = min;                                                                   // 2               
        Random rand = new Random();// 2               
        int randomInt = rand.nextInt(100) +1 ;            // [1,100]                           // [1,100] 比如：5
        for(int i=0;i<ranges.size();i++){                                                 // i=0    i=1    i=2
            Range range = ranges.get(i);                                                  // 1-85   86-95  96-100
            //判断使用哪个range产生最终的随机数
            if(range.getPercentScopeMin() <= randomInt && randomInt <= range.getPercentScopeMax()){  //  
                r = produceRandomNumber(range.getMin(),range.getMax());                              // [2,29]
                break;
            }
        }
        return r;
    }
    
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> separates = new ArrayList<Integer>();
        separates.add(29);
        separates.add(59);
        List<Integer> percents = new ArrayList<Integer>();
        percents.add(85);
        percents.add(10);
        percents.add(5);
        for(int i=0;i<100;i++) {
            double number = produceRateRandomNumber(2, 99, separates, percents);
            System.out.println(String.format("%.2f",number));
        }
    }
}


/**
 * 定义一个范围区间bean
 */
class Range{
	private double min; // 区间最小值
	private double max; // 区间最大值
	private int percent; // 百分比
	private int percentScopeMin; // 百分比转换为[1,100]的数字区间最小值
	private int percentScopeMax; // 百分比转换为[1,100]的数字区间最大值
	
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public int getPercentScopeMin() {
		return percentScopeMin;
	}
	public void setPercentScopeMin(int percentScopeMin) {
		this.percentScopeMin = percentScopeMin;
	}
	public int getPercentScopeMax() {
		return percentScopeMax;
	}
	public void setPercentScopeMax(int percentScopeMax) {
		this.percentScopeMax = percentScopeMax;
	}
    
}
