package calculator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class ShowResultsFile implements ShowResultsBehavior {

  Path path;

  public ShowResultsFile(){
    path = Paths.get("output.txt");
    try {
      if(!Files.exists(path)){
        Files.createFile(path);
      }
      Files.writeString(Paths.get("output.txt"), "");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public void show(int n){
    try {
      Files.writeString(Paths.get("output.txt"), (n+"\n"), StandardOpenOption.APPEND);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
