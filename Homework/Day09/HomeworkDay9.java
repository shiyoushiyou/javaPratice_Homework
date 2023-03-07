package Homework.Day09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeworkDay9 {
    public static void main(String[] args) {
	//練習　12-2
	//① 「X obj = new A();」としてAインスタンスを生成した後、
	//変数objに対して呼ぶことができるメソッドを、
	//a()、b()、c()の中からすべて挙げてください。
	
	X obj = new A(); //只有void a()方法，原因??
	
	//② 「Y y1 = new A();Y y2 = new B();」
	//としてAとBのインスタンスを生成した後、
	//「y1.a();y2.a();」を実行した場合に画面に表示される内容を答えてください。
	
	Y y1 = new A();//Aa 因為 class A的 a()是Aa
	Y y2 = new B();//Bb 因為 class B的 b()是Bb
	y1.a();
	y2.a();
	
	//練習　12-3
	//練習12-2で用いたAクラスやBクラスのインスタンスをそれぞれ1つずつ生み出し、
	//要素数2からなる単一の配列に格納するとします。
	//格納した後には配列の中身をループで順に取り出し、
	//それぞれのインスタンスのb()を呼ぶ必要があります。
	
	//① 配列変数の型としては何を用いるべきか答えてください。
	//    A:y class的Array
	//② 問題文に記述された内容のプログラムを作成してください。
	
	Y []yArr = new Y[2];
	yArr[0] = new A();
	yArr[1] =new B();
		
		for(int i=0;i<yArr.length;i++) {
			yArr[i].b();
		}
	System.out.println();
	//練習　15-3
	//以下の各条件とマッチする正規表現パターンを記述してください。
		//①すべての文字列
		System.out.println("4d".matches(".*"));
		
		//②最初の1文字はA、2文字目は数字、3文字目は数字か無し
		System.out.println("A1A".matches("A\\d\\d?"));
		
		//③最初の1文字はU、2～4文字目は英大文字
		System.out.println("UA333".matches("[U][\\p{Upper}]{2,4}"));

		//メール検証 
		//^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$
		
		
		
		//練習　15-4
		//mainメソッドのみを持つクラスMainを定義し、
		//以下の手順を参考にして「現在の100日後の日付」を「西歴2020年09月24日」という
		//形式で表示するプログラムを作成してください。

		//①現在の日時をDate型で取得します。
		Date now = new Date();
		System.out.println(now);
		
		//②取得した日時情報をCalendarにセットします。
		Calendar c1 = Calendar.getInstance();//虛擬類不能new所以要用.getInstance()方法
		c1.setTime(now);
		
		//③Calendarから「日」の数値を取得します。
		int day = c1.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		//④取得した値に100を足した値をCalendarの「日」にセットします。
		 c1.add(Calendar.DAY_OF_MONTH, +100);
		 Date past = new Date();
		//⑤Calendarの日時情報をDate型に変換します。
		 past = c1.getTime();
		//⑥SimpleDateFormatを用いて、指定された形式でDateインスタンスの内容を表示します。
		 SimpleDateFormat sdf = new SimpleDateFormat("西歴yyyy年MM月dd日");
		 System.out.println(sdf.format(past));
}
}

