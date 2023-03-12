package jp.co.brightstar.homeworkDay12;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class MoneyManager {
	private List<Money>moneys;
	
	//菜單
	public void menu() {
		System.out.println("-----------零錢通菜單-----------");
		System.out.println("\t1.零錢通明細");
		System.out.println("\t2.收益入帳");
		System.out.println("\t3.消費");
		System.out.println("\t4.退         出");
		System.out.println("請選擇1-4  : ");
		int option = new java.util.Scanner(System.in).nextInt();
		switch(option) {
		case 1:
			Detail();
			break;
		case 2:
			asset();
			break;
		case 3:
			payment();
			break;
		case 4:
			exit();
			break;
		default :
			System.out.println("你輸入的不是1-4之間的數字");
			menu();
		}
	}
	
	public void Detail() {
		System.out.println("-----------零錢通明細-----------");
		for(int i =0;i<moneys.size();i++) {
			System.out.println(moneys.get(i));
		}
		menu();
	}
	public void asset() {
		System.out.println("收益入帳，請輸入收益金額");
		double Salary = new java.util.Scanner(System.in).nextDouble();
		if(Salary == 0) {
			System.out.println("收益不可為0");
		}else if (Salary<1000000) {
			moneys.add(new Money("收益入帳",new Date(),(moneys.get(moneys.size()-1).getBalance()+Salary),Salary,true));
			System.out.println("已成功新增收益入帳");
			Detail();
			
		}
		menu();
	}
	public void payment() {
		System.out.println("紀錄消費，請輸入消費金額");
		double Salary = new java.util.Scanner(System.in).nextDouble();
		System.out.println("紀錄消費，請輸入消費項目名稱");
		String name = new java.util.Scanner(System.in).nextLine();
		if(Salary == 0||name==null||name.length()==0) {
			System.out.println("金額或是項目不可為空");
		}else if(moneys.get(moneys.size()-1).getBalance()<Salary){
			System.out.println("你的餘額不足以支付消費");
			payment();
		}else if (Salary<1000000) {
			moneys.add(new Money(name,new Date(),(moneys.get(moneys.size()-1).getBalance()-Salary),Salary,false));
			System.out.println("已成功新增消費紀錄");
			Detail();
		}
		menu();
	}
	public void exit() {
		System.out.println("感謝你的使用");
		System.exit(0);
		
	}
}
