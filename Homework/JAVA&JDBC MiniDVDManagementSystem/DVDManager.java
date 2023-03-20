package jp.co.brightstar.dvd;

import java.util.List;
import java.util.Scanner;
//DVD管理器
public class DVDManager {

	//菜單
		public void menu()  {
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
		public void returnMenu() {
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
				DVDDao.insertDVD(name);
				System.out.println("已成功新增DVD:《 "+name+"》");
				selectDVD();
			}
			
		}
		
     	//查看DVD
		public void selectDVD() {
			System.out.println("序號\t狀態\t名稱\t\t借出日期\t\t借出次數");
			
			List<DVD>dvds =DVDDao.selectDVD();
			for(DVD dvd:dvds) {
				System.out.println(dvd);			
				}
		}

	   //刪除DVD
		public void deleteDVD() {
				int count = DVDDao.DelectFlagZero(0);
				if(count <=0) {
					System.out.println("沒有可刪除DVD");
				}else {
					System.out.println("請輸入刪除DVD序號");
					Scanner Sca =new Scanner(System.in);
					int deleteNum = Sca.nextInt();
					DVD dvd  =DVDDao.getDVDById(deleteNum);
					
					if(dvd.getName()==null) {
						System.out.println("沒有此張DVD");
						}else if(dvd.getState()==1){
							System.out.println("此張DVD狀態為已借出");		
					}else{
						DVDDao.deleteDVD(deleteNum);
						System.out.println("DVD"+dvd.getName()+"已被刪除");
						selectDVD() ;
					}
					
				}
			}
	//借出DVD
		public void rentDVD()  {
			int count = DVDDao.DelectFlagZero(0);
			if(count <=0) {
				System.out.println("沒有可借出DVD");
			}else {
					System.out.println("輸入借出DVD之序號");
					int rantNum = new java.util.Scanner(System.in).nextInt();
					DVD dvd  =DVDDao.getDVDById(rantNum);
					if(dvd.getName()==null) {
						System.out.println("沒有此張DVD");
					}else if(dvd.getState()==1){
						System.out.println("此張DVD狀態為已借出");		
					}else {
						DVDDao.rentDVD(rantNum);
						System.out.println("成功借出DVD:"+DVDDao.idOfDelectFlag(rantNum));
						selectDVD() ;
						
					}
				}
	}
			
	//歸還DVD
		public void returnDVD()  {
			int count = DVDDao.DelectFlagZero(0);
			if(count <=0) {
				System.out.println("沒有可歸還DVD");
			}else {
					System.out.println("輸入歸還DVD之序號");
					int rantNum = new java.util.Scanner(System.in).nextInt();
					DVD dvd  =DVDDao.getDVDById(rantNum);
					if(dvd.getName()==null) {
						System.out.println("沒有此張DVD");
					}else if (dvd.getState()==0) {
						System.out.println("此DVD狀態為可借");
					}else {
						DVDDao.returnDVD(rantNum);
						System.out.println("DVD"+dvd.getName()+"已被歸還");
						selectDVD() ;
						}
				}
	}
			


	//退出DVD
		public void exitDVD() {
			System.out.println("感謝你的使用");
			System.exit(0);
		}
}
