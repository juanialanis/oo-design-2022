package mylist;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class CardCollection {

    List<Card> cards;

    public CardCollection() {
        cards = new ArrayList<Card>();
    }

    public Card draw() {
        return cards.remove(new Random().nextInt(cards.size()));
    }

    public CardCollection draw(int n){
        return null;
    }

    public Card draw(Card card) {
        return cards.remove(cards.indexOf(card));
    }

    public void receive(Card card) {
        cards.add(card);
    }

    public void receive(CardCollection collection) {
        cards.addAll(collection.cards);
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < cards.size() - 1; i++) {
            result += cards.get(i).toString() + ", ";
        }
        result += cards.get(cards.size() - 1).toString() + "]";
        return result;
    }
}
