package jp.co.brightstar.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//測試
public class test {
	public static void main(String[] args) throws ParseException {
		
		DVDManager manager = new DVDManager();
		Date now = new Date();
		//初始化DVD
		List<DVD> dvds = new ArrayList ();
//		Calendar c = Calendar.getInstance();
//		c.set(2023,2,1);
//		dvds.add(new DVD("羅馬假日",1,c.getTime(),15));
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日");
		String date ="2023年03月01日";
		dvds.add(new DVD("羅馬假日",1,sdf.parse(date),15));
		dvds.add(new DVD("風聲鶴唳",0,null,12));
		dvds.add(new DVD("浪漫滿屋",0,null,30));
		//		DVD[]dvds = new DVD[6];
//		//有參構造器的順序，是照定義的順序
		manager.setDvds(dvds);
		manager.menu();
		
		
}
}
