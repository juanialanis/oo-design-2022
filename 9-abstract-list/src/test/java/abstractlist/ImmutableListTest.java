package abstractlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;

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

  static Stream<Arguments> sublistGenerator() {
    return Stream.of(Arguments.of(0, 2, Arrays.asList(new Object[] { 1, 2 })),
        Arguments.of(1, 3, Arrays.asList(new Object[] { 2, "asd" })),
        Arguments.of(2, 4, Arrays.asList(new Object[] { "asd", "test" })));
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
  @MethodSource("sublistGenerator")
  public void sublistTest(int start, int end, List<Object> sublist) {
    assertEquals(list.subList(start, end), sublist);
  }
}
