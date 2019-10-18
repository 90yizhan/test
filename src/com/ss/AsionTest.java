package com.ss;

import java.util.HashMap;
import java.util.Map;

public class AsionTest {

	public static Map<String, Double> odds = new HashMap();
	
	
	static{
		odds.put("平手", 0.0);
		odds.put("半球", 0.5);
		odds.put("一球", 1.0);
		odds.put("球半", 1.5);
		odds.put("两球", 2.0);
		odds.put("两球半", 2.5);
		odds.put("三球", 3.0);
		odds.put("三球半", 3.5);
	}
	
	public static void main(String[] args) {
		String bifen=null;
		String pk=null;
		String type=null;
		double minrq=0.0;//最小让球
	    double maxrq=0.0;//最大让球
	    double vs=0.0;//
		bifen="1:1";
		pk="受让半球/一球";//盘口
		type="spv";//主客队
		String[] bifens = bifen.split(":");
		double hs = Double.parseDouble(bifens[0]);//主队
		double ass = Double.parseDouble(bifens[1]);//客队
		String[] pks=pk.split("/");
		boolean con=pks[0].contains("受让");
		if(con){//客让主
			pks[0]=pks[0].substring(2);
	    	minrq=odds.get(pks[0]);
	    	vs=ass-hs;
	    }else{//主让客
	    	minrq=odds.get(pks[0]);
	    	vs=hs-ass;
	    }
		if(type.equals("spv")&&con==true&&vs<0){
			vs=Math.abs(vs);
		}
	    maxrq=odds.get(pks[pks.length-1]);
		double pv=1.60;//赔率
        if(vs>maxrq&&vs>minrq){
        	if(type.equals("fpv")&&con==false){
        		System.out.println("输");
        	}else{
        		System.out.println("赢");
        	}
        }else if(vs<=maxrq&&vs>minrq){
        	if(type.equals("fpv")&&con==false){
        		System.out.println("输半");
        	}else{
        		System.out.println("赢半");
        	}
        }else if(vs<maxrq&&vs>=minrq){
        	if(type.equals("fpv")&&con==false){
        		System.out.println("赢半");
        	}else{
        		System.out.println("输半");
        	}
        }else if(vs<maxrq&&vs<minrq){
        	if(type.equals("fpv")&&con==false){
        		System.out.println("赢");
        	}else{
        		System.out.println("输");
        	}
        }else{
        	System.out.println("走盘");
        }
        
		//System.out.println("实际中奖金额"+ winMoney);
	}
	private void test(){
		String bifen=null;
		String pk=null;
		String type=null;
		
		bifen="1:0";
		pk="平手";//盘口
		type="spv";//主客队
		/*if(pks.length==1){
        	if(vs>pkodds){
        		System.out.println("赢");
        	}else if(vs<pkodds){
        		System.out.println("输");
        	}else {
        		System.out.println("走盘");
        	}
        }else{
        	if(vs>pkodds){
        		
        	}
        }
		if(hs-ass>pkodds){
        	System.out.println("赢");
        }else if(hs-ass<pkodds){
        	if(){
        		
        	}
        	System.out.println("输");
        }else{
        	if(pks.length==1){
        		System.out.println("走盘");
        	}else{
        		if(hs-odds.get(pks[0])>0){
        			System.out.println("赢半");
        		} else if(hs-odds.get(pks[0])==0){
        			System.out.println("输半");
        		}else{
        			System.out.println("未知");
        		}
        	}
        }*/
		bifen="1:0";
		pk="半球";//盘口
		type="spv";//主客队
		/**/
		
	}
}
