package testing.junit.practico.ejercicio2;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import java.util.Arrays;

public class BoundedQueueFromStringCap extends SimpleArgumentConverter {

    @Override
    protected BoundedQueue convert(Object source, Class<?> targetType) {
        String strSource = ((String)source);
        if (strSource.equals("null"))
            return null;
        strSource = strSource.substring(1, strSource.length()-1);
        String [] strArray = strSource.split(",");
        BoundedQueue q = new BoundedQueue(Integer.parseInt(strArray[0]));
        for (int i = 1; i < strArray.length; i++)
            if (isNumeric(strArray[i])) {
                q.enQueue(Integer.parseInt(strArray[i]));
            } else {
                q.enQueue(strArray[i]);
            }

        return q;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
