package jp.co.brightstar.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DVD管理器
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DVDManager {
	//DVD數組
	private List<DVD> dvds ;
	
	//菜單
		public void menu() throws ParseException {
			System.out.println("歡迎使用DVD管理器");
			System.out.println("-----------------------");
			System.out.println("1.新增DVD");
			System.out.println("2.查看DVD");
			System.out.println("3.刪除DVD");
			System.out.println("4.借出DVD");
			System.out.println("5.歸還DVD");
			System.out.println("6.退出DVD");
			System.out.println("-----------------------");
			System.out.print("請選擇 : ");
			
			int option = new java.util.Scanner(System.in).nextInt();
			switch(option) {
				case 1:
					System.out.println("新增DVD");
					insertDVD();
					break;
				case 2:
					System.out.println("查看DVD");
					selectDVD();
					break;
				case 3:
					System.out.println("刪除DVD");
					deleteDVD();
					break;
				case 4:
					System.out.println("借出DVD");
					rentDVD();
					break;
				case 5:
					System.out.println("歸還DVD");
					returnDVD() ;
					break;
				case 6:
					System.out.println("退出DVD");
					exitDVD();
					break;
				default:
					//TODO 輸入數字範圍不正的情況下，請重新輸入
					System.out.println("請輸入1~6之間的數字");
					menu();	
			}
			System.out.println("-----------------------");
			returnMenu();
		}
	//返回菜單
		public void returnMenu() throws ParseException  {
			System.out.println("輸入0返回");
			int input = new java.util.Scanner(System.in).nextInt();
				if(input==0) {
					menu();
				}else {
					System.out.println("請輸入0");
					returnMenu();
				}
		}
		
	//新增DVD
		public void insertDVD() {
			Scanner Sca =new Scanner(System.in);
			System.out.println("請輸入新增DVD資訊");
			String name = Sca.nextLine();
			if(name==null||name.length()==0) {
				System.out.println("輸入的名字的空");
			}else if (name.length()<10) {
				dvds.add(new DVD(name,0,null,0));
				System.out.println("已成功新增DVD:《 "+name+"》");
				selectDVD();
			}
			
		}
		

     	//查看DVD
		public void selectDVD() {
			System.out.println("序號\t狀態\t名稱\t\t借出日期\t\t借出次數");
			for(int i = 0;i<dvds.size();i++) {
				System.out.println((i+1)+"\t"+dvds.get(i));
				
				}
		}

	   //刪除DVD
		public void deleteDVD() {
				if(dvds.isEmpty()) {
					System.out.println("DVD集合為空");
				}else {
				//判斷DVD數組裡是否有可借DVD
				boolean isAllLended = true;
				for(DVD dvd :dvds) {
					if(dvd.getState()==1) {
						isAllLended = false;
						break;
					}
				}
				if(isAllLended) {
					System.out.println("數組裡沒有可刪DVD");
				}else {
					selectDVD();
					System.out.println("請輸入刪除DVD序號");
					Scanner Sca =new Scanner(System.in);
					int deleteNum = Sca.nextInt();
					if(deleteNum<1||deleteNum>dvds.size()) {
						System.out.println("輸入序號不再數組範圍內");
					}else if(dvds.get(deleteNum-1).getState()==1) {
						System.out.println("輸入序號對應DVD狀態為已借出");
					}else {
						DVD dvd = dvds.remove(deleteNum-1);
						
						System.out.println("已成功刪除DVD:《 "+dvd.getName()+"》");
						selectDVD();
					}
				}
	}
}		

	//借出DVD
		public void rentDVD() throws ParseException  {
			boolean available = true;
			for(DVD dvd:dvds) {
				if(dvd.getState()==1) {
					available = false;
					break;
				}
			}
				if(available) {
					System.out.println("沒有可借出DVD");
				}else {
					System.out.println("輸入借出DVD之序號");
					int rantNum = new java.util.Scanner(System.in).nextInt();
					if(rantNum<1||rantNum>dvds.size()) {
						System.out.println("你輸入的序號超出數組範圍");
					}else if(dvds.get(rantNum-1)==null) {
						System.out.println("查找不到相符的DVD");
					}else if (dvds.get(rantNum-1).getState()==1) {
						System.out.println("此DVD狀態為已借出");
					}else {
						String name =dvds.get(rantNum-1).getName();
						System.out.println("請輸入借出日期格式為yyyy年MM月dd日");
						String rantDate = new java.util.Scanner(System.in).nextLine();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
						dvds.get(rantNum-1).setState(1);
						dvds.get(rantNum-1).setDate(sdf.parse(rantDate));
						dvds.get(rantNum-1).setCount(dvds.get(rantNum-1).getCount()+1);
						
						System.out.println("成功借出DVD:"+name);
						
					}
				}
			}
			
	//歸還DVD
		public void returnDVD() throws ParseException  {
			boolean available =true;
			for(DVD dvd:dvds) {
				if(dvd.getState()==0) {
					available = false;
					break;
				}
			}
				if(available==true) {
					System.out.println("沒有可借DVD");
				}else {
					System.out.println("輸入租借DVD之序號");
					int rantNum = new java.util.Scanner(System.in).nextInt();
					if(rantNum<1||rantNum>dvds.size()) {
						System.out.println("你輸入的序號超出數組範圍");
					}else if (dvds.get(rantNum-1).getState()==0) {
						System.out.println("此DVD狀態為可借");
					}else {
						String name = dvds.get(rantNum-1).getName();
						System.out.println("請輸入還DVD日期格式為yyyy-MM-dd HH:mm");
						String rantDate = new java.util.Scanner(System.in).nextLine();
						dvds.get(rantNum-1).setState(0);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date returnday = sdf.parse(rantDate);
						long rant = dvds.get(rantNum-1).getDate().getTime();
						long return_ = returnday.getTime();
						int day =(int)((return_-rant)/(1000*60*60*24));
						if(day<1) {
							day++;
						}
						int money = day;
						dvds.get(rantNum-1).setDate(null);
						System.out.println("成功歸還DVD:"+name+"共使用了"+day+"天，花費為"+money);
					}
				}
			}


	//退出DVD
		public void exitDVD() {
			System.out.println("感謝你的使用");
			System.exit(0);
		}
}
