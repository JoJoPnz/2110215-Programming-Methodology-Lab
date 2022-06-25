package deck;


import java.util.ArrayList;
import java.util.Arrays;


import card.base.Card;


public class Deck {
	// TODO: constructor
	private String name;
	private int deckSize;
	private Card[] deckList; 
	
	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckSize = deckList.length;
		this.deckList = deckList;
	}



	//You CAN modify the first line
	public int insertCard(Card card) throws InsertCardFailedException{
		int count = 0;
		for (Card i : deckList) {
			if (i.getName().equals(card.getName())) {
				count += 1;
			}
		}
		if(count >= 4) 
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		//FILL CODE HERE
		//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
		//Must return new deckSize
		deckList = Arrays.copyOf(deckList, deckSize+1);
		deckList[deckList.length-1] = card;
		deckSize = deckList.length;
		return deckSize;
		
	}

	//You CAN modify the first line
	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}		
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}
		//FILL CODE HERE
		//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
		//Once card is removed, other card down the list must rearrange to the empty slot
		//Must return card that was removed;
		Card out = deckList[slotNumber];
		System.arraycopy(deckList, slotNumber + 1, deckList, slotNumber, deckList.length - slotNumber - 1);
		deckList = Arrays.copyOf(deckList, deckList.length-1);
		deckSize = deckList.length;
		return out;
		
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append("(").append(this.getDeckSize()).append(" deck size)")
				.toString();
	}


	/* GETTERS & SETTERS */

	public int getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public String getName() {
		return name;
	}

	public Card[] getDeckList() {
		return deckList;
	}
	
}
