package mylist;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardCollectionTest {

  CardCollection cards;

  @BeforeEach
  public void setUp() {
    cards = new CardCollection();
  }

  @Test
  public void drawRandomCardTest() {
    cards.receive(new NormalCard(0));
    cards.receive(new NormalCard(0));
    cards.receive(new NormalCard(0));
    int size = cards.size();
    cards.draw();
    assertThat(cards.size()).isEqualTo(size - 1);
  }

  @Test
  public void drawGivenCardTest() {
    cards.receive(new NormalCard(0));
    cards.receive(new NormalCard(1));
    cards.receive(new NormalCard(2));
    int size = cards.size();
    Card card = cards.draw(new NormalCard(1));
    assertThat(cards.size()).isEqualTo(size - 1);
    assertThat(card).isEqualTo(new NormalCard(1));
  }

  @Test
  public void addCardTest() {
    cards.receive(new NormalCard(0));
    assertThat(cards.size()).isEqualTo(1);
    assertThat(cards.toString()).isEqualTo("[(0, 0, NORMAL)]");
  }

  @Test
  public void addAllTest() {
    CardCollection col = new CardCollection();
    int size = cards.size();
    System.out.println(size);
    col.receive(new NormalCard(0));
    col.receive(new NormalCard(1));
    col.receive(new NormalCard(2));
    System.out.println(col.size());
    cards.receive(col);
    System.out.println("cards.size : " + cards.size());
    System.out.println("col.size : " + col.size());
    assertThat(cards.size()).isEqualTo(size + col.size());
  }

}
