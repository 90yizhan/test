package com.ss.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
 
public class Fault_Result {
	public void getFaultResult(){
		List<FaultResult> FaultResultList=new ArrayList<FaultResult>();
		try {
			//假设调用别人接口,他会返回一个符合json格式的字符串现在对这个字符串进行按年排序(升序)，再按月排序(升序)。
			String FaultResult="[{\"year\":\"2015\",\"month\":10,\"count\":47},{\"year\":\"2015\",\"month\":10,\"count\":21},{\"year\":2017,\"month\":12,\"count\":4},{\"year\":2018,\"month\":11,\"count\":2},{\"year\":2017,\"month\":10,\"count\":2},{\"year\":2016,\"month\":12,\"count\":2},{\"year\":2016,\"month\":01,\"count\":2}]"; 
			//转换成json对象数组  
			JSONArray jsonFaultResult= JSONArray.fromObject(FaultResult);  
			//先按年份排升序,再返月份排升序
			for(int i=0;i<jsonFaultResult.length();i++) {
				JSONObject jsonObjectFault=(JSONObject) jsonFaultResult.get(i);
				String year=jsonObjectFault.getString("year");
				String month=jsonObjectFault.getString("month");
				String count=jsonObjectFault.getString("count");
				FaultResultList.add(new FaultResult(year,month,count));
			}
			System.out.println("=============排序前的数据================");
			for(FaultResult list:FaultResultList) {
				System.out.println(list.getYear()+" , "+list.getMonth()+" , "+list.getCount() );
			}
			
			Collections.sort(FaultResultList, new EmpComparator());
			
			System.out.println("=============排序后的数据================");
			for(FaultResult list:FaultResultList) {
				System.out.println(list.getYear()+" , "+list.getMonth()+" , "+list.getCount() );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Fault_Result fr=new Fault_Result();
		fr.getFaultResult();
	}
}
