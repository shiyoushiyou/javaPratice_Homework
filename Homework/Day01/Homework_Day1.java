package Homework.Day01;
import java.util.Scanner;
import java.util.Random;

public class Homework_Day1 { 
    public static void main(String[]args){ 
        
    }
}
class practice1_3{
    public void P1_3(){
    /*練習　1-3
    以下に示した5つの値を格納するために適した型を考え、
    「初期化」による宣言を行うソースコードを作成してください。
    */ 
    //①true & "true"
    boolean boolean_True = true;
    String String_true = "true";
    //②'駆'  & "駆"
    String String_word = "駆";
    char char_word = '駆';
    //③3.14
    long long_PI=314159265853979L;
    float float_PI = 3.14F; 
    //⑤"ミナトの攻撃！敵に15ポイントのダメージを与えた。"
    String String_words = "ミナトの攻撃!敵に15ポイントのダメージを与えた。";
    }
}

class practice2_1{
    public void P2_1(){
    /*　練習　2-1
     * 「x+yは15」を表示させたいのですが、
     * 意図どおりに動きません。正しく動作するように修正してください。
     */

     int x = 5;
     int y = 10;
     int z = x+y;
     String ans = "x+yは"+z;
     System.out.println(ans);
     //或是更改至下列
     String Ans = "x+yは";
     System.out.println(Ans+(x+y));
    }
}

class practice2_2{
    public void P2_2(){
//　練習　2-2
//  次の文で文法として正しいものを、すべて選んでください。
    String s = 2 + "人目";
    byte b = 1;
    short y = (byte)2;
    double d = 2.0F;
    }
}

class practice2_3{
    public void P2_2(){
    //①画面に「ようこう占いの館へ」と表示します。
    System.out.println("ようこう占いの館へ");
    //②画面に「あなたの名前を入力してください」と表示します。
    System.out.println("あなたの名前を入力してください");
    String name = "";
    String ageString = "";
    //③キーボードから1行の文字入力を受け付け、String型の変数nameに格納すします。
    try(Scanner Sca = new Scanner(System.in)){
    name = Sca.next();
    //④画面に「あなたの年齢を入力してください」と表示します。
    System.out.println("あなたの年齢を入力してください");
    //⑤キーボードから1行の文字入力を受け付け、String型の変数ageStringに格納すします。
    ageString = Sca.next();
    //⑥変数ageStringの内容をint型に変換し、int型の変数ageに代入します。
    int age = Integer.parseInt(ageString);
    //⑦0から3までの乱数を生成し、int型の変数fortuneに代入します。
    Random random = new Random();
    int times = 3;
    //⑧fortuneの数値をインクリメント演算子で1増やし、1から4の乱数にします。
    int fortune = random.nextInt(times)+1;
    //⑨画面に「占いの結果が出ました！」と表示します。
    System.out.println("占いの結果が出ました！");
    //⑩画面に「（年齢）歳の（名前）さん、
    //あなたの運気番号は（乱数）です」と表示します。
    System.out.println(age+"歳の"+name+"さん、あなたの運気番号は"+times+"です");
    //⑪画面に「1: 大吉　2:中吉　3:吉　4: 凶」と表示します。
    if(times==1){
        System.out.println("大吉");
    }
    else if(times==2){
        System.out.println("中吉");
    }
    else if(times==3){
        System.out.println("吉");
    }
    else{
        System.out.println("凶");
    }
    } 
    }
}
