package com.map;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

	//nishuonizuiaidingxianghua fengchuiyudayishengduoshaomeilibianzhidemeng牵挂 是你多么渴望的美啊  你听那有人在唱那首魅力的歌谣 是你多么渴望的美啊  你还觉得孤单么
	//你听那有人在唱 那首魅力的歌谣 院子里灾满丁香花 一生一世守护啊
	
	public static void main(String[] args) {
		List<StudentScore> sList=buildStudent();
		Map<String, Integer> sMap=new HashMap<String, Integer>();
		Map<String, Integer> sMap2=new HashMap<String, Integer>();
		Date firstTime=new Date();
		sList.forEach(studentScore -> {
			if(sMap.containsKey(studentScore.getStuName())){
				sMap.put(studentScore.getStuName(), sMap.get(studentScore.getStuName())+studentScore.getScore());
			}else{
				sMap.put(studentScore.getStuName(), studentScore.getScore());
			}
		});
		System.out.println(new Date().getTime()-firstTime.getTime()+"-----"+sMap.toString());
		Date firstTimes=new Date();
		sList.forEach(studentScore -> sMap2.merge(studentScore.getStuName(), studentScore.getScore(), Integer :: sum));
		//sList.forEach(studentScore -> sMap2.merge(studentScore.getStuName(), studentScore.getScore(), (old, now) -> old+now));
		System.out.println(new Date().getTime()-firstTimes.getTime()+"-----"+sMap2.toString());
	}

	private static List<StudentScore> buildStudent() {
		List<StudentScore> sList=new ArrayList<StudentScore>();
		sList.add(new StudentScore("张三", "语文", 50));
		sList.add(new StudentScore("张三", "数学", 51));
		sList.add(new StudentScore("张三", "英语", 52));
		sList.add(new StudentScore("李四", "语文", 60));
		sList.add(new StudentScore("李四", "数学", 61));
		sList.add(new StudentScore("李四", "英语", 62));
		sList.add(new StudentScore("王五", "语文", 70));
		sList.add(new StudentScore("王五", "数学", 71));
		sList.add(new StudentScore("王五", "英语", 72));
		return sList;
	}
}
