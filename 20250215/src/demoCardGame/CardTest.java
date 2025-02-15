package demoCardGame;
import java.util.ArrayList;
import java.util.List;

public class CardTest {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        //买一副牌：
        List<Card> myCardList = game.BuyCardList();
        System.out.println("新买的牌："+myCardList);
        //洗牌:
        game.shuffle(myCardList);
        System.out.println("洗牌之后："+myCardList);

        List<List<Card>> hand = game.play(myCardList);
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("第"+(i+1)+"个人的牌是:"+hand.get(i));
        }
        System.out.println("剩余的牌是："+myCardList);
    }
}
