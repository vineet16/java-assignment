import java.util.*;

public class perfectNumber {

  public perfectNumber() {

  }

  public Boolean isPerfectNumber(Integer num){

    Integer sum = 1;
    
    Integer factor = 2;
    while(Math.pow(factor, 2) <= num){
      if(num%factor == 0){
        if(Math.pow(factor, 2) == num){
          sum += factor;
        }else {
          sum += factor + (num/factor);
        }
      }
      factor++;
    }

    if(sum == num){
      return true;
    }
    return false;
  }

  public static void main (String[] args) {

    Integer n = 28;

    perfectNumber check = new perfectNumber();
    Boolean sol = check.isPerfectNumber(n); 

    System.out.println(sol);
  }
} 