package com.ss;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

public class MathUtil {
	public static int jiechengC(int c1,int c2){
		int sum1=1;
		int sum2=1;
		for(int i=0;i<c2;i++){
			sum1=sum1*c1;
			c1=c1-1;
		}
		for(int c=c2;c>=1;c--){
			sum2=sum2*c;
		}
		return sum1/sum2;
	}
	
	/**
	 * 从字符数组中第begin个字符开始挑选number个字符加入list中   
	 * @param cs
	 * @param begin 第begin个字符开始挑选
	 * @param number 挑选number个字符
	 * @param list
	 * @param bilist
	 */
    public static void getBetInfo(String []cs,int begin,int number,List<String> list,List<String> bilist){   
         if(number==0){
        	// Collections.sort(list);
        	 String strlist="";
        	 for(String str:list){strlist=strlist+str+",";}
            bilist.add(strlist);
            return ;   
         }   
         if(begin==cs.length){   
            return;   
         }   
        list.add(cs[begin]); 
        getBetInfo(cs,begin+1,number-1,list,bilist); 
         list.remove(cs[begin]);
         getBetInfo(cs,begin+1,number,list,bilist);   
     }
    public static int formatstringtoint(String str){
    	if(str==null||"".equals(str.trim())){
    		return 0;
    	}else{
    		return Integer.parseInt(str);
    	}
    }
    public static String randomNum(int count){
    	String numberChar = "0123456789";
    	StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
           sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }
        return sb.toString();
    }
    /**
	 * 格式化小数
	 * @param num
	 * @param dotLen
	 * @return
	 */
	public static String formatNumber(Object num,int dotLen){
		if(num == null){
			return "";
		}
		String numString = String.valueOf(num);
		if(numString.indexOf(".")>0){
			if(numString.length()>numString.indexOf(".")+3){
				numString = numString.substring(0,numString.indexOf(".")+3);
			}
		}
		
		return numString;
	}
	
	public static double formatNumberToDouble(Object num,int dotLen){
		if(num == null){
			return 0.0;
		}
		String numString = String.valueOf(num);
        if(StringUtils.isEmpty(numString)){
            return 0.0;
        }
		if(numString.indexOf(".")>0){
			if(numString.length()>numString.indexOf(".")+3){
				numString = numString.substring(0,numString.indexOf(".")+3);
			}
		}
		
		return Double.valueOf(numString);
	}
	
	   /**  
     * 对double数据进行取精度.  
     * @param value  double数据.  
     * @param scale  精度位数(保留的小数位数).  
     * @param roundingMode  精度取值方式.  
     * @return 精度计算后的数据.  
     */  
    public static double round(double value, int scale, 
             int roundingMode) {   
        BigDecimal bd = new BigDecimal(value);   
        bd = bd.setScale(scale, roundingMode);   
        double d = bd.doubleValue();   
        bd = null;   
        return d;   
    }
    public static double doubleTodouble3(double value) {
        long   l1   =   Math.round(value*1000);   //四舍五入
        double   ret   =   l1/1000.0;               //注意：使用   100.0   而不是   100
        return   ret;
    }
    public static double doubleTodouble2(double value) {
        long   l1   =   Math.round(value*100);   //四舍五入
        double   ret   =   l1/100.0;               //注意：使用   100.0   而不是   100
        return   ret;
    }
    public static double doubleTodouble6(double value) {
    	double   l1   =   Math.rint(value*1000000);   //四舍五入
        double   ret   =   l1/1000000.0;               //注意：使用   100.0   而不是   100
        return   ret;
    }
    public static double doubleTodouble2(String str){
        try{
            double b = Double.parseDouble(str);
            return doubleTodouble2(b);
        }catch(Exception e)
        {
            return 0;
        }
    }
    public static double doubleTodouble3(String str){
        try{
            double b = Double.parseDouble(str);
            return doubleTodouble3(b);
        }catch(Exception e)
        {
            return 0;
        }
    }
    public static double doubleTodouble6(String str){
        try{
            double b = Double.parseDouble(str);
            return doubleTodouble6(b);
        }catch(Exception e)
        {
            return 0;
        }
    }
}
