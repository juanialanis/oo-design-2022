package abstractlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;


public class ImmutableListTest {

  static ImmutableList list;

  @BeforeAll
  public static void setUp(){
    Object[] array = {1 ,2 , "asd", "test"};
    list = new ImmutableList<Object>(array);
  }


  static Stream<Arguments> positionAndObject() {
    return Stream.of(
      Arguments.of(0, 1),
      Arguments.of(1, 2),
      Arguments.of(2, "asd"),
      Arguments.of(3, "test")
    );
  }


  @ParameterizedTest
  @MethodSource("positionAndObject")
  public void getElementTest(int i, Object element) {
    assertEquals(list.get(i), element);
  }

  @Test
  public void sizeTest(){
    assertEquals(list.size(),4);
  }
}
