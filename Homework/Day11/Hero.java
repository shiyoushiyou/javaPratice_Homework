package Homework.Day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hero {
    private String name;
    public Hero(String name) { 
        this.name = name; 
    }
    public String getName() { 
        return this.name; 
    }
}
class test{
    public static void main(String[] args) {
        List<Hero> arrs = new ArrayList<>();
        arrs.add(new Hero("張三"));
        arrs.add(new Hero("李四"));
        for(Hero arr:arrs){
            System.out.println(arr.getName());
        }
    }
}
class HeroMap{

    public static void main(String[]args){
        Map<Hero,Integer>prefs =new HashMap<>();
        prefs.put(new Hero("張三"),3);
        prefs.put(new Hero("李四"),7);
        Set <Hero>keys = prefs.keySet();
        for(Hero key:keys){
            System.out.println(key.getName()+"が倒した敵="+prefs.get(key));
        }
    }
}
