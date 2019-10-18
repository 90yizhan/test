package com.ss;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Arrangement {
	public static Map<String,int[]> map=new HashMap<String,int[]>();
	static{
		map.put("2x1",new int[]{2});
		map.put("3x1",new int[]{3});
		map.put("4x1",new int[]{4});
		map.put("5x1",new int[]{5});
		map.put("6x1",new int[]{6});
		map.put("7x1",new int[]{7});
		map.put("8x1",new int[]{8});
		map.put("9x1",new int[]{9});
		map.put("10x1",new int[]{10});
		map.put("11x1",new int[]{11});
		map.put("12x1",new int[]{12});
		map.put("13x1",new int[]{13});
		map.put("14x1",new int[]{14});
		map.put("15x1",new int[]{15});
		map.put("2x3",new int[]{2,1});
		map.put("3x4",new int[]{3,2});
		map.put("3x7",new int[]{3,2,1});
		map.put("4x5",new int[]{4,3});
		map.put("4x11",new int[]{4,3,2});
		map.put("4x15",new int[]{4,3,2,1});
        map.put("5x6",new int[]{5,4});
        map.put("5x16",new int[]{5,4,3});
        map.put("5x26",new int[]{5,4,3,2});
        map.put("5x31",new int[]{5,4,3,2,1});
        map.put("6x7",new int[]{6,5});
        map.put("6x22",new int[]{6,5,4});
        map.put("6x42",new int[]{6,5,4,3});
        map.put("6x57",new int[]{6,5,4,3,2});
        map.put("6x63",new int[]{6,5,4,3,2,1});
	}
	public static void main(String[] args) {
		List<String> li=new ArrayList<String>();
		li.add("1.81");
		li.add("1.75");
		li.add("1.2");
		li.add("4.53");
		String[] min=new String[li.size()];
		for(int i=0;i<li.size();i++){
			String[] sp=li.get(i).split(",");
			if(sp.length>1){
				min[i]=getMaxPv(sp);
			}else{
				min[i]=sp[0];
			}
		}
		List<String> list=new ArrayList<String>();
		combinationSelect(min,2,list);
		combinationSelect(min,3,list);
       
		double money=0;
		for(int i=0;i<list.size();i++){
			String[] pv=list.get(i).replaceAll("[\\[\\]]", "").replaceAll("\"", "").split(",");//当前串关的赔率数组
			StringBuilder sb=new StringBuilder();
			double j=1;
			for(String s:pv){
				sb.append(s+"×");
				j*=Double.parseDouble(s);
			}
			double mon=j*2*0.65;
			money+=mon;
			sb.append("1倍×2元×65%[返奖率]="+mon+"元");
			System.out.println(sb.toString());
		}
		System.out.println(money);
	}
	//获取最高赔率(单一玩法的)
	private static String getMaxPv(String[] pvs) {
		double i=Double.parseDouble(pvs[0]);
		for(String p:pvs){
			if(i<Double.parseDouble(p)){
				i=Double.parseDouble(p);
			}
		}
		return i+"";
	}
	private static Detail getSum(List<String> list) {
		if(list==null||list.size()==0){
			return new Detail(0,0*2);
		}
		double[] arr=new double[list.size()];//每一种串关的金额
		for(int ii=0;ii<list.size();ii++){
			String[] pv=list.get(ii).replaceAll("[\\[\\]]", "").replaceAll("\"", "").split(",");//当前串关的赔率数组
			double j=1;
			for(String s:pv){
				j*=Double.parseDouble(s);
			}
			arr[ii]=j;
		}
		int sum=list.size();
		double money=0;
			
		for(int ii=0;ii<arr.length;ii++){
			money+=arr[ii];
		}
		Detail d=new Detail(sum,money*2);
		
		return d;
	}
	private static Detail getSums(String[] min, int i) {
		List<String> list=new ArrayList<String>();
		combinationSelect(min,i,list);
		if(list==null||list.size()==0){
			return new Detail(0,0*2);
		}
		double[] arr=new double[list.size()];//每一种串关的金额
		for(int ii=0;ii<list.size();ii++){
			String[] pv=list.get(ii).replaceAll("[\\[\\]]", "").replaceAll("\"", "").split(",");//当前串关的赔率数组
			double j=1;
			for(String s:pv){
				j*=Double.parseDouble(s);
			}
			arr[ii]=j;
		}
		int sum=list.size();
		double money=0;
			
		for(int ii=0;ii<arr.length;ii++){
			money+=arr[ii];
		}
		Detail d=new Detail(sum,money*2*0.65);
		return d;
	}
	 /**
     * 组合选择（从列表中选择n个组合）
     * @param dataList 待选列表
     * @param n 选择个数
     * @param array 
     * @param list 
     * @param len 
     * @param list 
     * @param list 
     */
    public static void combinationSelect(String[] dataList, int n, List<String> list) {
    	
        combinationSelect(dataList, 0, new String[n], 0,list);
        
    }
    
    /**
     * 组合选择
     * @param dataList 待选列表
     * @param dataIndex 待选开始索引
     * @param resultList 前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     * @param lists 
     * @param list 
     * @param list 
     */
    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex, List<String> list) {  
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
        	String js=JSONObject.toJSONString(resultList);
        	list.add(js);
            return;
        }

        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1,list);
        }
    }
}
class Detail{
	private int count;
	private double money;
	public Detail(int sum, double money) {
		this.count=sum;
		this.money=new BigDecimal(money).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}