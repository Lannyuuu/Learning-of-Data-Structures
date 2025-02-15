package demoCardGame;
import java.util.*;

public class CardGame {
    //花色是一个确定且永远不会改变的量:常量，字符串数组
    public static final String[] Suit = {"♥","♦","♠","♣"};

    //买一副牌（方法）
    public List<Card> BuyCardList(){
        List<Card> CardList = new ArrayList<>(52);
        //4个花色：
        for (int i = 0; i < 4; i++) {
            //13个面值：
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(Suit[i],j);
                CardList.add(card);
            }
        }
        return CardList;
    }
    //洗牌里面交换两个牌（方法）
    //交换CardList.get(i)和CardList.get(ranIndex)的Card类型的值
    public void swap(List<Card> CardList,int i,int j){
        Card tmp = CardList.get(i);
        CardList.set(i,CardList.get(j));
        CardList.set(j,tmp);
    }
    //洗牌（方法）
    public void shuffle(List<Card> CardList){
        for (int i = CardList.size()-1; i >0 ; i--) {
            Random random = new Random();
            int ranIndex = random.nextInt(i);
            swap(CardList,i,ranIndex);
            //nextInt(int bound)：生成一个 [0, bound) 范围内的随机整数。
        }
    }
    //抽牌(方法):3个人每个人轮流抓5张牌
    //每一个人抓的排放在一个单独的list里面
    //hand0,hand1,hand2
    //从index==0开始抓->remove(CardList[0])
    public List<List<Card>> play(List<Card> CardList ){
        //List<List<Card>> : 所有被抓的牌的List
        List<List<Card>> hand = new ArrayList<>();

        //每一个人抓的牌的List
        List<Card> hand0 = new ArrayList<>();
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();

        //每个人抓的牌汇总到hand-所有被抓的牌的List
        hand.add(hand0);
        hand.add(hand1);
        hand.add(hand2);

        for (int i = 0; i < 5; i++) { //第一次抽牌
            for (int j = 0; j < 3; j++) { //每一次抽牌3个人每个人抽一张牌
                Card tmpcard = CardList.remove(0); //直接remove走CardList里的第一张牌
                hand.get(j).add(tmpcard); //hand.get(0)-第j个人抓的牌的List
            }
        }
        return hand;
    }
    //玩牌：
}
