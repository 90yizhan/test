package com.ss.match;

import com.alibaba.fastjson.JSONObject;

public class JclqTest {

	public static void main(String[] args) {
		JSONObject js=new JSONObject();
		js.put("type", "让球主负");
		js.put("pv", 1.7);
		js.put("pk", 6.5);
		String bf="87:75";
		checkSf(bf,js);

	}

	private static void checkSf(String bfs, JSONObject play) {
		String[] bf=bfs.split(":");
		Double ke= Double.parseDouble(bf[0]); //客
		Double zhu= Double.parseDouble(bf[1]); //主
		Integer playState=1;//赛果  1未中奖   2中奖
		Integer actualBonus=0;//实际奖金
		String chPv=play.getString("type");//获取投注内容	让球主负
		double pvPlay=play.getDoubleValue("pv");
		double vs=play.getDoubleValue("pk");//让球数
		switch (chPv) {//判断胜负  及实际奖金
		case "主负":
			if(ke>zhu){
				playState=2;
				actualBonus=(int) (pvPlay*200*1);
			}else if(ke==zhu){
				playState=2;
			}
			break;
		case "主胜":
			if(ke<zhu){
				playState=2;
				actualBonus=(int) (pvPlay*200*1);
			}else if(ke==zhu){
				playState=2;
			}
			break;
		case "让球主负":
			zhu=zhu+vs;
			if(ke>zhu){
				playState=2;
				actualBonus=(int) (pvPlay*200*1);
			}else if(ke==zhu){
				playState=2;
			}
			break;
		case "让球主胜":
			zhu=zhu+vs;
			if(ke<zhu){
				playState=2;
				actualBonus=(int) (pvPlay*200*1);
			}else if(ke==zhu){
				playState=2;
			}
			break;
		case "大":
			if(ke+zhu>vs){
				playState=2;
				actualBonus=(int) (pvPlay*200*1);
			}else if(ke+zhu==vs){
				playState=2;
			}
			break;
		case "小":
			if(ke+zhu<vs){
				playState=2;
				actualBonus=(int) (pvPlay*200*1);
			}else if(ke+zhu==vs){
				playState=2;
			}
			break;
	}
		System.out.println(playState);
		System.out.println(actualBonus);
	}

}
