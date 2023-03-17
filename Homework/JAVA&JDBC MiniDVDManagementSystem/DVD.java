package jp.co.brightstar.dvd;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

//DVD
@Data
public class DVD {
	private int id;
	//名稱
	private String name;
	
	//狀態:未借出>>0 已借出>>1
	private int state;
	
	//借出日期
	private Date date;
	
	//借出次數
	private int count;

	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
			String state = null;
			if (this.state==0) {
				state="可借";
			}else if(this.state==1) {
				state = "已借出";
			}

			String name = "《 "+this.name+"》";
			
			String count = this.count+"次";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 ");
			String date =this.state==1?sdf.format(this.date):"                         ";	
				return this.id+"\t"+state+"\t"+name+"\t"+date+"\t"+count;
			}

	}
	

