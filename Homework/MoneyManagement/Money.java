package jp.co.brightstar.homeworkDay12;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Money {
	
	private String name;//項目
	private Date date;//日期
	private double balance;//餘額
	private double money;//錢
	private boolean PlusOrSubtract ;//判斷是收益還是消費
	
	@Override
	public String toString() {
		
		String name = this.name;
		Double money = this.money;
		Double balance= this.balance;
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    String date = sdf.format(this.date);
			if(PlusOrSubtract) {
			return name +"\t +"+money +"\t"+date +"\t"+"餘額 :"+balance;
			}else {
				return name +"\t -"+money +"\t"+date +"\t"+"餘額 :"+balance;
			}
				
				
				//name +"\t"+money +"\t"+date +"\t"+"餘額 :"+balance;
	}
	
	
	
	
	
}
