package stringcalculator;

import java.lang.IllegalArgumentException;
public class StringCalculator {

  public static int add(String numbers){
    int result = 0;
    if(numbers == ""){
      return result;
    }
    String divider = ",";
    if(numbers.contains("//")){
      divider = numbers.split("\n")[0].substring(2);
      if(divider.contains("[")){
        String[] dividers = divider.split("\\]");
        for(int i = 0; i < dividers.length; i++){
          dividers[i] = dividers[i].replaceAll("\\[","");
        }
        divider = ",";
        for(int i = 0; i < dividers.length; i++){
          numbers = numbers.replace(dividers[i],divider);
        }
      }
      int location = numbers.indexOf("\n");
      numbers = numbers.substring(location+1);
    }
    String[] operands = numbers.replaceAll("\\n", divider).split(divider);
    for(String value: operands){
      int numberValue = Integer.parseInt(value);
      if(numberValue < 0){
        throw new IllegalArgumentException("Negatives not allowed");
      }
      if(numberValue <= 1000){
        result+=numberValue;
      }
    }
    return result;
  }
}
