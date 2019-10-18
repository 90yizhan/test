package com.ss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		String sss="0.0";
		System.out.println(Double.parseDouble(sss)==0);
		System.out.println("1.html".contains("1"));
		String s = "中文其还是sasfsadfsf12fasf45d8sfs";
		//System.out.println("数字:" + s.replaceAll("[a-zA-Z]", ""));
		//System.out.println("字符:" + s.replaceAll("[0-9]", ""));
		//System.out.println("让平~3.5".split("~")[0]);
		//System.out.println("rqPpv,spv".contains("rqPpv"));
		String content = "我是<a href=u.php?action=show&uid=122113 target=_blank>超链接文本</a>爱好者";
        String regex = "<a[^>]+>([^<]+)</a>";
        content = content.replaceAll(regex,"$1");
        
        System.out.println(DateUtil.Date2Str(DateUtil.addDiffDayForUser(DateUtil.getNowDate(), -10)));
		/*Calendar cale = null;
        cale = Calendar.getInstance();
        int day = cale.get(Calendar.DATE);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String firstday, lastday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(DateUtil.getBeginDayOfMonth());
        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " );*/
		/*String weekCode="周五002";
		Pattern str = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+");
		Matcher mStr = str.matcher( weekCode );
		StringBuffer sb = new StringBuffer();
		while ( mStr.find() ) {
			System.out.println( mStr.group() );
		}
		Pattern num = Pattern.compile("[0-9]+|\\d+");
		Matcher mNum = num.matcher( weekCode );
		while ( mNum.find() ) {
			System.out.println( mNum.group());
		}*/
	}
	/*public static void main(String[] args) {
		String str="2019-11-28";
		System.out.println(str.substring(0, 7));
		List<Integer> issLi=new ArrayList<Integer>();
		issLi.add(5);
		issLi.add(58);
		issLi.add(59);
		issLi.add(58);
		for(Integer iss:issLi){
			System.out.println(iss+"a : " + Collections.frequency(issLi, iss));    
		}
	}*/
	/*public static void main(String[] args) throws IOException {
		System.out.println(DateUtil.getNowString());
		readTxt("C:\\Users\\Administrator\\Desktop\\keys.txt");  
        System.out.println(DateUtil.getNowString());
    }*/
	private static Date getTomorrow() {
		System.out.println(Integer.parseInt(DateUtil.dateToString(DateUtil.getNowDate(), "yyyy")+DateUtil.dateToString(DateUtil.getNowDate(), "MM")));
		Date now=DateUtil.getNowDate();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        String temp=DateUtil.dateToString(calendar.getTime(),"yyyy-MM-dd")+" 10:00:00";
	    try {
			return DateUtil.StringToDate(temp,"yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	/*public static void main(String[] args) {
		System.out.println(DateUtil.dateToString(getTomorrow(),"yyyy-MM-dd HH:mm:ss"));
		  String html = "<div><p style='color:red;'>12132第一串字符</p></div><br /><div><p>这是第二窜字符,</p></div><img width='199' src='_image/12/label'/><img width='199' src='_image/13/label'/><img width='199' src='_image/14/label'/>";
		  String regex = "<[^>]*>";
		  String str = html.replaceAll(regex, "");
		  System.out.println(str+"\n");
		  String ss="据西班牙媒体《马卡报》的最新消息，皇马下赛季将在教练方面进行大洗牌，劳尔有可能成为皇马B队卡斯蒂亚的主教练，而哈维-阿隆索将执教皇马青训梯队Juvenil A，即皇马U19。该报也表示，该决定还没正式敲定，但是皇马高";
		  System.out.println(ss.length());
		  String sss="另外一位需要重点提及的专家是胡安，他经常取得单日10中8这样的...";
		  String phone="17638123348";
		  StringBuffer buffer = new StringBuffer(phone);
		  System.out.println(buffer.replace(3,7,"****"));
		  String s = "017周，五";
		  Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+");
		  Matcher m = p.matcher( s );
		  while ( m.find() ) {
		  System.out.println( m.group() );
		  Pattern pattern = Pattern.compile("[0-9]*");  
		  if( pattern.matcher(m.group()).matches()){
			  System.out.println("数字");
		  }
		  }
		 }*/
	public static String readTxt(String path){  
        StringBuilder content = new StringBuilder("");  
        try {  
            String code = resolveCode(path);  
            File file = new File(path);  
            InputStream is = new FileInputStream(file);  
            InputStreamReader isr = new InputStreamReader(is, code);  
            BufferedReader br = new BufferedReader(isr);  
            String str = "";  
            while (null != (str = br.readLine())) {  
            	if(str.contains("怀旧")){
    				System.out.println(str);
    			}
            }  
            br.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.err.println("读取文件:" + path + "失败!");  
        }  
        return content.toString();  
    }  
	public static String resolveCode(String path) throws Exception {  
        InputStream inputStream = new FileInputStream(path);    
        byte[] head = new byte[3];    
        inputStream.read(head);      
        String code = "UTF-8";  //文件编码格式
        if (head[0] == -1 && head[1] == -2 )    
            code = "UTF-16";    
        else if (head[0] == -2 && head[1] == -1 )    
            code = "Unicode";    
        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)    
            code = "UTF-8";    
            
        inputStream.close();  
        System.out.println(code);   
        return code;  
    } 
}
