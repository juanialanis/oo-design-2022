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
	private String losserCharType;
	private String looserWeapon;
  private GameData gameData;
  List<List<String>> records;
	
	public FightStatistics(GameData gameData) {
		this.gameData = gameData;
		gameData.registerObserverToFight(this);
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
    if(!gameData.getIsFightStarted()){
      winnerCharType = gameData.getCharacterAttackType();
      losserCharType = gameData.getCharacterReceivesAttackType();
      winnerWeapon = gameData.getPlayerOneWeapon();
      looserWeapon = gameData.getPlayerTwoWeapon();
      records = new ArrayList<List<String>>();
      boolean found = false;
      try {
        CSVReader csvReader = new CSVReader(new FileReader("statistics.csv"));
        String[] values = null;
        while ((values = csvReader.readNext()) != null) {
          records.add(Arrays.asList(values));
        }
        for(List<String> fight : records){
          System.out.println("COMPARA " + fight.get(1) + " CON " + winnerCharType + " Y ES VERDADERO? " + fight.get(1).equals(winnerCharType));
          System.out.println("COMPARA " + fight.get(2) + " CON " + winnerWeapon + " Y ES VERDADERO? " + fight.get(2).equals(winnerWeapon));
          System.out.println("COMPARA " + fight.get(4) + " CON " + losserCharType + " Y ES VERDADERO? " + fight.get(3).equals(losserCharType));
          System.out.println("COMPARA " + fight.get(5) + " CON " + looserWeapon + " Y ES VERDADERO? " + fight.get(4).equals(looserWeapon));
          if(fight.get(1).equals(winnerCharType) && fight.get(2).equals(winnerWeapon) && fight.get(4).equals(losserCharType) && fight.get(5).equals(losserCharType)){
            fight.set(0, String.valueOf(1+ Integer.parseInt(fight.get(0))));
            found = true;
          }
        }
        if(!found){
          String[] toAdd = {"1", winnerCharType, winnerWeapon, "0", losserCharType, looserWeapon};
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
