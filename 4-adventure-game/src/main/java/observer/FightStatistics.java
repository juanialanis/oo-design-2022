package observer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import java.util.List;

public class FightStatistics implements Observer, DisplayElement {
  private String winnerCharType;
  private String winnerWeapon;
  private String loserCharType;
  private String loserWeapon;
  private GameData gameData;
  List<List<String>> records;

  public FightStatistics(GameData gameData) {
    this.gameData = gameData;
    gameData.registerObserver(this);
    try {
      if(!Files.exists(Paths.get("fight-output.txt"))){
        Files.createFile(Paths.get("fight-output.txt"));
      }
      Files.writeString(Paths.get("fight-output.txt"), "\n", StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update() {
    if(gameData.getFightStatus().equals("start-fight")){
      winnerCharType = gameData.getAttackerType();
      loserCharType = gameData.getAttackeeType();
      winnerWeapon = gameData.getAttackerWeaponType();
      loserWeapon = gameData.getAttackeeWeaponType();
      records = new ArrayList<List<String>>();
      boolean found = false;
      try {
        CSVReader csvReader = new CSVReader(new FileReader("statistics.csv"));
        String[] values = null;
        while ((values = csvReader.readNext()) != null) {
          records.add(Arrays.asList(values));
        }
        for(List<String> fight : records){
          if(fight.get(1).equals(winnerCharType) && fight.get(2).equals(winnerWeapon) && fight.get(4).equals(loserCharType) && fight.get(5).equals(loserWeapon)){
            fight.set(0, String.valueOf(1+ Integer.parseInt(fight.get(0))));
            found = true;
          }
          else if(fight.get(4).equals(winnerCharType) && fight.get(5).equals(winnerWeapon) && fight.get(1).equals(loserCharType) && fight.get(2).equals(loserWeapon)){
            fight.set(3, String.valueOf(1+ Integer.parseInt(fight.get(3))));
            found = true;
          }
        }
        if(!found){
          String[] toAdd = {"1", winnerCharType, winnerWeapon, "0", loserCharType, loserWeapon};
          records.add(Arrays.asList(toAdd));
        }
      }
      catch (Exception e) {

      }
      display();
    }
  }

  public void display() {
    try{
      FileWriter outputfile = new FileWriter("statistics.csv");
    
      // create CSVWriter object filewriter object as parameter
      CSVWriter writer = new CSVWriter(outputfile);
      for(List<String> data: records){
        String[] arr = data.toArray(new String[data.size()]);
        writer.writeNext(data.toArray(arr));
      }

      // closing writer connection
      writer.close();
    }
    catch(Exception e){

    }
  }
}
