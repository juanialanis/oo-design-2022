package abstractlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class ImmutableListTest {
  static ImmutableList<Object> list;

  @BeforeAll
  public static void setUp() {
    Object[] array = { 1, 2, "asd", "test", 1 };
    list = new ImmutableList<Object>(array);
  }

  static Stream<Arguments> positionAndObject() {
    return Stream.of(Arguments.of(0, 1), Arguments.of(1, 2), Arguments.of(2, "asd"), Arguments.of(3, "test"),
        Arguments.of(0, 1));
  }

  @ParameterizedTest
  @MethodSource("positionAndObject")
  public void getElementTest(int i, Object element) {
    assertEquals(list.get(i), element);
  }

  @Test
  public void sizeTest() {
    assertEquals(list.size(), 5);
  }

  @ParameterizedTest
  @MethodSource("positionAndObject")
  public void getIndexTest(int position, Object element) {
    assertEquals(list.indexOf(element), position);
  }

  static Stream<Arguments> lastIndexAndObject() {
    return Stream.of(Arguments.of(4, 1), Arguments.of(1, 2), Arguments.of(2, "asd"), Arguments.of(3, "test"),
        Arguments.of(4, 1));
  }

  @ParameterizedTest
  @MethodSource("lastIndexAndObject")
  public void getLastIndexTest(int position, Object element) {
    System.out.println(list.lastIndexOf(element));
    assertEquals(list.lastIndexOf(element), position);
  }
}
