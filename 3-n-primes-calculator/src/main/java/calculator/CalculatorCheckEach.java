package calculator;

public class CalculatorCheckEach extends CalculatorBehavior{
  
  public void calculate(int n){
    for(int i = 0; i <= n; i++){
      if(isPrime(i)){
        showResultsBehavior.show(i);
      }
    }
  }

  private static boolean isPrime(int n){
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
