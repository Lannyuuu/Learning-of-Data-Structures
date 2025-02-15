package demoCardGame;

//定义一个Card类：面值+花色
public class Card {
    public int rank; //面值
    public String suit; //花色

    public Card( String suit,int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "{" + suit + rank + "}";
    }
}
