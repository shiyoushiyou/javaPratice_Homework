package jp.co.brightstar.homeworkDay12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
public static void main(String[] args) throws ParseException {
	MoneyManager MM = new MoneyManager();
	Date Day = new Date(); 
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String date ="2023-01-01 12:22";
	List<Money> moneys= new ArrayList ();
	
	moneys.add(new Money("收益入帳",sdf.parse(date),100.0,100.0,true));
	MM.setMoneys(moneys);
	MM.menu();
}
}
