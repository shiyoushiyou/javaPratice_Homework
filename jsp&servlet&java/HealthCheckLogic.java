package model;

public class HealthCheckLogic {
	
	public static boolean CheckTrue(String Height,String Weight) {		
		return (Height==null||Height.length()==0||Weight==null||Weight.length()==0);
			
	}
	public static double CheckBMI(String Height,String Weight) {
		double weight =Double.parseDouble(Weight);
		double height = Double.parseDouble(Height)/100;//身高專轉型cm>m
		
		return Math.round(weight/(height*height)* 100.0)/100.0;
		
	}
	public static String bodyCheck(double BMI) {
		if(BMI<18.5) {
			return "痩せ型";
		}else if(18.5<=BMI&&BMI<25) {
			return "普通";
		}else {
			return "肥満";
		}
		
	}
}
