package mylist;

public abstract class Card {

  private Integer cost;
  private Integer damage;
  private final CardType type;

  // We want to know the card type because some decks will be mixed
  // normal/drawer/dual
  // and we'd need to know what type of Card we have at any given play
  // Note: we can have mixed cards in a deck because ArrayList<Card> allows us to
  // have
  // different child instances of card in the list.
  public Card(Integer cost, Integer damage, CardType type) {
    this.cost = cost;
    this.damage = damage;
    this.type = type;
    System.out.println("In card\n");
  }

  public int getCost() {
    return cost;
  }

  public int getDamage() {
    return damage;
  }

  public CardType getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Card that = (Card) o;
    return cost.equals(that.cost) && damage.equals(that.damage) && type.equals(that.type);
  }

  @Override
  public int hashCode() {
    return 31 * cost.hashCode() + damage.hashCode() + type.hashCode();
  }

  @Override
  public String toString() {
    return "(" + cost + ", " + damage + ", " + type + ")";
  }
}
