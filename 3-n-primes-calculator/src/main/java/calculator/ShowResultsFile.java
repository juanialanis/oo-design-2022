package calculator;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShowResultsFile implements ShowResultsBehavior {

  public void show(List<Integer> primes) {
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
