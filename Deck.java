import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	ArrayList<Card> usedCard;
	public int nUsed;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		for(int n = nDeck; n > 0;n--) {
			for(int rank = 1;rank <= 13;rank++) {
				for (Card.esuit s : Card.esuit.values()) {
					Card card = new Card(s,rank);
					cards.add(card);
				}
			}
		}
		shuffle();
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(int n = 0;n < cards.size(); n++) {
			cards.get(n).printCard();
		}
	}
	public void shuffle() {
		Random rnd = new Random();
		int j = rnd.nextInt(52);
		nUsed = 0;
		usedCard.clear();
		cards = new ArrayList<Card>();
		for(int i = 0; i < 52;i++) {
			cards.add(i, cards.get(j));
			cards.remove(j+1);//delete original card of index j
		}
	}
	public Card getOneCard() {
		if(cards.isEmpty()) {
			nUsed ++;
			usedCard.add(cards.get(0));
			Card reg = cards.get(0);
			cards.remove(0);
			return reg;
		}
		else {
			shuffle();
			nUsed ++;
			usedCard.add(cards.get(0));
			Card reg = cards.get(0);
			cards.remove(0);
			return reg;
		}
	}
}
