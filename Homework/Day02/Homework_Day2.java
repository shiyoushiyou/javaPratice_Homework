package Homework.Day02;

import java.util.Scanner;

public class Homework_Day2 {
    public static void main(String[]args){ 
    }
}
class practice3_1{
    public void P3_1(){
    //　練習　3-1    
    //次の日本語で記載された条件式をJavaで記述してみましょう。
    //①変数weightの値が60に等しい。
    int weight = 60;
    System.out.println(weight == 60);
    //②変数age1とage2の合計を2倍したものが60を超えている。
    // (age1+age2)*2>60;

    //③変数ageが奇数である。
    // age%2 != 0;
    
    //④変数nameの中身の文字列が「湊」と等しい。
    String name = "湊";
    if("湊".equals(name)) {
    System.out.println("這是同一個字");
    }
    }
}

class practice3_2{
    public void P3_2(){
        //　練習　3-2
        //次に挙げるAからFの式のうち、条件式として適切なものを選んでください。
        /*
         * C.age !=30
         * D.true
         * E.b + 5 < 20
         */
    }
}

class practice3_3{
    public void P3_3(){
        //①int 型の変数isHungryを定義し、
        //0か1を代入する（どちらを代入しても構わない）。
        Scanner Sca = new Scanner(System.in);
        //②画面に「こんにちは」と表示する。
        System.out.println("こんにちは");
        System.out.println("お腹空いてますか？\n"+"0→お腹がいっぱい  1→はらぺこ");
        int isHungry = Sca.nextInt();

        //③もし変数isHungryが０であれば「お腹がいっぱいです」、
        //そうでなければ「はらぺこです」と表示する。
        if(isHungry == 0){
            System.out.println("お腹がいっぱいです");
        }
        else if(isHungry == 1){
            System.out.println("はらぺこです");
            //④もし変数isHungryが空腹を示すならば、変数foodを利用して
            //「○○ををいただきます」と表示する（○○には食べものの名前が入る）。
            System.out.println("何が食べたいですか？");
            //また、String型の変数foodを定義し、
            //適当な食べものの名前を代入する。
            String food = Sca.nextLine();
            if (food != null){
                System.out.println(food+"ををいただきます");  
                System.out.println("ごちそうさまでした");
            }
        }
        else{
            System.out.println("0か1を入力してください");
        }
        //⑤最後に「ごちそうさまでした」と表示する。
        System.out.println("ごちそうさまでした");
    }
}

class practice3_3_TernaryOperator{
    public void P3_3_Ternary_Operator(){
        //三元运算符
        //ans == 0 ? "表" : "裏"		
        //変数ansが0なら「表」、0以外なら「裏」に化ける		
        int ans = new java.util.Scanner(System.in).nextInt();
        int Front = 0;
        System.out.print((ans <1)? "表" : "裏");
    }
}

class practice3_5{
    public void P3_5(){
    //　練習　3-5
    //①画面に「［メニュー］1：検索 2：登録 3：削除 4：変更>」と表示する。
    //表示後は改行しないこと。
    System.out.println("［メニュー］1：検索 2：登録 3：削除 4：変更>");
    //②数字を入力し、変数selectedに代入する。
    Scanner Sca = new Scanner(System.in);
    int selected =Sca.nextInt();
    //③もし変数selectedが1なら「検索します」、2なら「登録します」、
    //3なら「削除します」、4なら「変更します」と表示する。
    switch(selected){
        case 1:
        System.out.println("入力したのは"+selected+":検索します");
        break;
        case 2:
        System.out.println("入力したのは"+selected+":登録します");
        break;
        case 3:
        System.out.println("入力したのは"+selected+":削除します");
        break;
        default :
        System.out.println("入力したのは"+selected+":変更します");
    }
    }
}

class DayOfMonth{
    public void DayOfMonth_(String[] args) {
        System.out.println("請輸入查詢月份");
        int month = new java.util.Scanner(System.in) .nextInt();
        int day =0;
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day =31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day =30;
                break;
                // 判断输入的年是否是闰年
                // A：能被4整除并且不能被100整除
                // B：或者能被400整除
            case 2:
                System.out.println("請輸入今年年分");
                int year = new java.util.Scanner(System.in) .nextInt();
                if(year/4==0&&year/100!=0||year/400==0) {
                    day = 29;
                }else {
                    day = 28;
                }
                break;	
        }
        System.out.println("你查詢的"+month+"月共"+day+"天");
    }
}
