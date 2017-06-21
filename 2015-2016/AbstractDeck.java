package org.elsys.cardgame.impl;

import java.util.*;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Hand;

public abstract class AbstractDeck implements Deck {

	@Override
	public Card drawTopCard() {
		return getCards().remove(0);
	}

	@Override
	public Card topCard() {
		return getCards().get(0);
	}

	@Override
	public Card bottomCard() {
		return getCards().get(getCards().size() - 1);
	}

	@Override
	public Card drawBottomCard() {
		return getCards().remove(getCards().size() - 1);
	}

	@Override
	public Hand deal() {
		List<Card> handCards = new ArrayList<>();
		for (int i = 0; i < handSize(); i++) {
			handCards.add(getCards().remove(0));
		}
		return new HandImpl(handCards);
	}

	@Override
	public void sort() {
		 getCards().sort(WarDeck.getCardComparator());

	}
	@Override
	public void shuffle() {
		long seed = System.nanoTime();
		Collections.shuffle(getCards(), new Random(seed));

	}

	@Override
	public int size() {
		return getCards().size();
	}

}
