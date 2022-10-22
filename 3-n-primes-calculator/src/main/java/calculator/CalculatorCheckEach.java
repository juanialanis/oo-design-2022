package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorCheckEach implements CalculatorBehavior {
  
  public List<Integer> calculate(int n){
    List<Integer> result = new ArrayList<>();
    int i = 0;
    while(result.size() < n){
      if(this.isPrime(i)){
        result.add(i);
      }
      i++;
    }
    return result;
  }

  private boolean isPrime(int n){
    //since 0 and 1 is not prime return false.
    if(n==1||n==0)return false;

    //Run a loop from 2 to n-1
    for(int i=2; i<n; i++){
      // if the number is divisible by i, then n is not a prime number.
      if(n%i==0)return false;
    }
    //otherwise, n is prime number.
    return true;
  }
}
