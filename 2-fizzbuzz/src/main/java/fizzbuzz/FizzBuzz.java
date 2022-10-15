package main.java.fizzbuzz;

public class FizzBuzz {

  public static boolean isFizzBuzz(int n){
    if(isBuzz(n) && isFizz(n)){
      return true;
    }
    return false;
  }

  public static boolean isFizz(int n){
    if(n % 3 == 0){
      return true;
    }
    if(Integer.toString(n).contains("3")){
      return true;
    }
    return false;
  }

  public static boolean isBuzz(int n){
    if(n % 5 == 0){
      return true;
    }
    if(Integer.toString(n).contains("5")){
      return true;
    }
    return false;
  }

  public static Object isFizzBuzzOrNumber(int n){
    if(isFizzBuzz(n)){
      return "FizzBuzz";
    }
    else if(isFizz(n)){
      return "Fizz";
    }
    else if(isBuzz(n)){
      return "Buzz";
    }
    else{
      return n;
    }
  }
}
