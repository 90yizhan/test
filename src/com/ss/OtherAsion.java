package com.ss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherAsion {
	
	public static void main(String[] args) {
		String bifen=null;
		String pk=null;
		String type=null;
	    double pkNum=0.0;
	    for(int i=0;i<typeList.size();i++){
			bifen=bifenList.get(i);
			pk=pkList.get(i);//盘口
			type=typeList.get(i);//主客队
			String[] bifens = bifen.split(":");
			double hs = Double.parseDouble(bifens[0]);//主队
			double ass = Double.parseDouble(bifens[1]);//客队
			//判断有多少盘口
			String[] pks=pk.split("/");
			if(pks.length>1){
				pkNum=odds.get(pks[pks.length-1])-0.25;
	    	}else{
	    		pkNum=odds.get(pks[0]);
	    	}
			boolean con=pks[0].contains("受让");//是否包含受让   是的话则客让主
			double vs=0.0;
			if(type.equals("spv")&&con==false){//选择主   主让
				vs=hs-ass-pkNum;
			}
			if(type.equals("spv")&&con){//选择主   客让
				vs=hs-ass+pkNum;
			}
			if(type.equals("fpv")&&con==false){//选择客   主让
				double zj=0.0;
				zj=hs;
				hs=ass;
				ass=zj;
				vs=hs+pkNum-ass;
			}
			if(type.equals("fpv")&&con){//选择客   客让
				double zj=0.0;
				zj=hs;
				hs=ass;
				ass=zj;
				vs=hs-ass-pkNum;
			}
			
			if(vs>=0.5){
				System.out.println(i+2+"赢"+":"+vs);
			}else if(vs<=-0.5){
				System.out.println(i+2+"输"+":"+vs);
			}else if(vs==0.25){
				System.out.println(i+2+"赢半"+":"+vs);
			}else if(vs==-0.25){
				System.out.println(i+2+"输半"+":"+vs);
			}else{
				System.out.println(i+2+"走盘"+":"+vs);
			}
	    }
	}
	
	
	public static List<String> typeList=new ArrayList<String>();
	public static List<String> bifenList=new ArrayList<String>();
	public static List<String> pkList=new ArrayList<String>();
	
	static{
		typeList.add("spv");//大阪钢巴(半球)松本山雅
		typeList.add("spv");
		typeList.add("spv");
		typeList.add("fpv");
		typeList.add("fpv");
		typeList.add("fpv");
		typeList.add("spv");
		typeList.add("fpv");
		typeList.add("fpv");
		typeList.add("spv");
		typeList.add("spv");
		typeList.add("fpv");
		typeList.add("fpv");
		typeList.add("spv");
		typeList.add("fpv");
		typeList.add("fpv");
		typeList.add("spv");
		typeList.add("fpv");
		typeList.add("spv");
		typeList.add("spv");
		typeList.add("spv");
		typeList.add("fpv");
		typeList.add("fpv");
		typeList.add("spv");//柔佛(受让半球/一球)庆南FC
	}
	static{
		bifenList.add("2:1");//大阪钢巴(半球)松本山雅
		bifenList.add("1:0 ");
		bifenList.add("0:1");
		bifenList.add("1:0");
		bifenList.add("1:0");
		bifenList.add("0:1");
		bifenList.add("0:0");
		bifenList.add("1:0");
		bifenList.add("1:0");
		bifenList.add("2:1");
		bifenList.add("1:0");
		bifenList.add("0:0");
		bifenList.add("2:1");
		bifenList.add("0:1");
		bifenList.add("2:1");
		bifenList.add("2:1");
		bifenList.add("1:0");
		bifenList.add("3:2");
		bifenList.add("5:1");
		bifenList.add("1:2");
		bifenList.add("0:0");
		bifenList.add("2:1");
		bifenList.add("3:0");
		bifenList.add("1:1");
	}
	static{
		pkList.add("半球");//大阪钢巴(半球)松本山雅
		pkList.add("平手/半球");
		pkList.add("平手");
		pkList.add("一球/球半");
		pkList.add("一球/球半");
		pkList.add("平手/半球");
		pkList.add("半球");
		pkList.add("一球/球半");
		pkList.add("平手/半球");
		pkList.add("半球");
		pkList.add("平手/半球");
		pkList.add("平手/半球");
		pkList.add("平手/半球");
		pkList.add("平手/半球");
		pkList.add("受让平手/半球");
		pkList.add("三球/三球半");
		pkList.add("受让半球/一球");
		pkList.add("一球");
		pkList.add("两球");
		pkList.add("平手/半球");
		pkList.add("平手/半球");
		pkList.add("平手/半球");
		pkList.add("半球");
		pkList.add("受让半球/一球");
	}
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
}
