//Cole Constantino | Any string to int with various edge cases 

import java.util.*;
public class Atoi{
  public static int solve(String str){
    String newS = str.trim();
    if(newS.length() == 0) return 0;
    StringBuilder sb = new StringBuilder();
    double d = 0.0;
    List<Character> list = new ArrayList<>();
    
    for(int i = 0; i < newS.length(); i++){
      list.add(i,newS.charAt(i));
    }
    
    //if neg or digit
    if(list.get(0) == '-' || list.get(0) == '+' || Character.isDigit(list.get(0))){
      sb.append(list.get(0));
      list.remove(0);
      for(int i = 0; i<list.size();i++){
        if(Character.isDigit(list.get(i)) == true){
          sb.append(list.get(i));
        }
        else{
          break;
        }
      } 
      
      if(sb.toString().equals("-") || sb.toString().equals("+")) 
        return 0;
      else{
        //parse value
        d = Double.parseDouble(sb.toString());
        
        if(d > 2147483647.0)
          return Integer.MAX_VALUE;
        else if (d < -2147483647.0)
          return Integer.MIN_VALUE;

        return Integer.parseInt(sb.toString());
      }
    }
    else{
      //if first char is not a digit or '-'
      return 0;
    } 
  }
  
  public static void main(String[] args){
    String s = "+1";
    System.out.println(solve(s));
  }
}