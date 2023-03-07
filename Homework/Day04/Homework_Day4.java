package Homework.Day04;
import java.util.Scanner;

public class Homework_Day4 {//調用方法
    public static void main(String[]args){
        Scanner Sca =new Scanner(System.in);
        System.out.println("請問你要計算三角形還是圓形的面積。0→三角形，1→圓形");
        int ans =Sca.nextInt();
        if(ans==0){
            System.out.println("請輸入長度");
            double len = Sca.nextDouble();
            System.out.println("請輸入寬度");
            double width = Sca.nextDouble();
            System.out.println("三角形的面積為："+calcTriangleArea(len,width));
        }else{
            System.out.println("請輸入圓形半徑");
            double Radius = Sca.nextDouble();
            System.out.println("三角形的面積為："+calcCircleArea(Radius));
        }
        
    }
    //以下の仕様を参考にメソッド「calcTriangleArea」と
    //「calcCircleArea」を作成してください。
    public static double calcTriangleArea(double x,double y){
        /*
            * 												
        メソッド名	calcTriangleArea											
        戻り値の型	三角形の面積（double）											
        引数リスト	三角形の底辺の長さ、単位はcm（double bottom）											
            三角形の高さ、単位はcm（double height）											
        処理内容	引数を使用して面積を求め、それを戻す*/	
        return (x*y)/2;

    
    }
    										
	public static double calcCircleArea(double x){											
        /*メソッド名	calcCircleArea											
        戻り値の型	円の面積（double）											
        引数リスト	円の半径、単位はcm（double radius）											
        処理内容	引数を使用して面積を求め、それを戻す。											
        mainメソッドからそれぞれのメソッドに適当な引数を渡して呼び出し、戻り値を出力して正しい面積が表示されるかを確認してください。												
        */
        final double Pi = 3.14;
        return (x*x*Pi);
    }
}
class Area{//使用類跟對象來呼叫方法
    public static void main(String[]args){
        Scanner Sca =new Scanner(System.in);
        System.out.println("請問你要計算三角形還是圓形的面積。0→三角形，1→圓形");
        int ans =Sca.nextInt();
        Area area01 = new Area();
        if(ans==0){
            area01.calcTriangleArea();

        }else{
            area01.calcCircleArea();

        }
    }

    public static void calcTriangleArea(){
        /*
            * 												
        メソッド名	calcTriangleArea											
        戻り値の型	三角形の面積（double）											
        引数リスト	三角形の底辺の長さ、単位はcm（double bottom）											
            三角形の高さ、単位はcm（double height）											
        処理内容	引数を使用して面積を求め、それを戻す*/	
        Scanner Sca =new Scanner(System.in);
        System.out.println("請輸入長度");
            double len = Sca.nextDouble();
            System.out.println("請輸入寬度");
            double width = Sca.nextDouble();
            System.out.println("三角形的面積為："+(len*width)/2);
        return ;

    
    }

    public static void calcCircleArea(){											
        /*メソッド名	calcCircleArea											
        戻り値の型	円の面積（double）											
        引数リスト	円の半径、単位はcm（double radius）											
        処理内容	引数を使用して面積を求め、それを戻す。											
        mainメソッドからそれぞれのメソッドに適当な引数を渡して呼び出し、戻り値を出力して正しい面積が表示されるかを確認してください。												
        */
        final double Pi = 3.14;
        Scanner Sca =new Scanner(System.in);
        System.out.println("請輸入圓形半徑");
        double Radius = Sca.nextDouble();
        System.out.println("三角形的面積為："+(Radius*Radius*Pi));

        return;
    }
}
