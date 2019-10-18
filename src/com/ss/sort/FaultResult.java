package com.ss.sort;

public class FaultResult {
	private String year;      //年
    private String month;     //月
    private String count;     //数据
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
    //构造方法
    public FaultResult(String year, String month, String count) {  
        this.year = year;  
        this.month = month;  
        this.count = count;  
    }  
    //默认构造方法
    public FaultResult() {  
      
    }  
}
