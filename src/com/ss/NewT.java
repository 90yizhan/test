package com.ss;

public class NewT {

	public static void main(String[] args) {
		Integer a=300;
		Integer b=200;
		//System.out.println(a+b);
		//String yuan="1.00.html";
		//System.out.println(yuan.substring(0, yuan.lastIndexOf(".")));
		
		//String s="http://wx.xd310.cn/index.htm";
		//way1(s,".html");
		
		Integer c=20190120;
		//System.out.println(c.toString().substring(0, 6));
		System.out.println(Integer.parseInt(("201912").substring(4, 6)));
	}
	public static void way1(String st,String M) {
		int count = 0;
		while(st.indexOf(M)>=0) {
			st=st.substring(st.indexOf(M)+M.length());
			count++;
		}
		System.out.println("指定字符串在原字符串中出现："+count+"次");
	}
}
