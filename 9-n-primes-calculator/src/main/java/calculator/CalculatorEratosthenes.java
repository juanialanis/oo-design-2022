package calculator;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CalculatorEratosthenes extends Calculator {
  
  private static final int MAX_SIZE = 1000005;

  public List<Integer> calculateNumbers(int n) {

    List<Integer> result = new ArrayList<>();
    // Create a boolean array "IsPrime[0..MAX_SIZE]"
    // and initialize all entries it as true.
    // A value in IsPrime[i] will finally be false
    // if i is Not a IsPrime, else true.
    boolean[] isPrime = new boolean[MAX_SIZE];
      
    for(int i = 0; i < MAX_SIZE; i++)
        isPrime[i] = true;
      
    for (int p = 2; p * p < MAX_SIZE; p++)
    {
        // If IsPrime[p] is not changed,
        // then it is a prime
        if (isPrime[p] == true)
        {
            // Update all multiples of p greater than or
            // equal to the square of it
            // numbers which are multiple of p and are
            // less than p^2 are already been marked.
            for (int i = p * p; i < MAX_SIZE; i += p)
                isPrime[i] = false;
        }
    }
  
    // Store all prime numbers
    for (int p = 2; p < MAX_SIZE; p++){
      if (isPrime[p] == true)
        result.add(p);

      if (result.size() == n)
        return result;
    }

    return result;
  }

  public void showNumbers(List<Integer> primes) {
    BufferedWriter outputWriter = null;
    try {
      outputWriter = new BufferedWriter(new FileWriter("output.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (Integer prime : primes) {
      try {
        outputWriter.write(prime.toString());
        outputWriter.newLine();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try {
      outputWriter.flush();
      outputWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
