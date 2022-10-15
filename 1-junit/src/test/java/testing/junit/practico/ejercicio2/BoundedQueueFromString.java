package testing.junit.practico.ejercicio2;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import java.util.Arrays;

public class BoundedQueueFromString extends SimpleArgumentConverter {

    @Override
    protected BoundedQueue convert(Object source, Class<?> targetType) {
        String strSource = ((String)source);
        if (strSource.equals("null"))
            return null;
        strSource = strSource.substring(1, strSource.length()-1);
        String [] strArray = strSource.split(",");
        BoundedQueue q = new BoundedQueue(strArray.length);
        for (int i = 0; i < strArray.length; i++)
            q.enQueue(Integer.parseInt(strArray[i]));
        return q;
    }
}
