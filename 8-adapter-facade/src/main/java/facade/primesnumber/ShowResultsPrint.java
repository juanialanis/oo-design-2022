package facade.primesnumber;

import java.util.List;

public class ShowResultsPrint implements ShowResultsBehavior {
  public void show(List<Integer> list){
    for(int n: list){
      System.out.println(n);
    }
  }
}
