package org.elsys.cardgame.impl;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Operation;

public class Highest implements Operation {

	@Override
	public String getName() {
		return "highest";
	}

	@Override
	public void execute(Game game, String... params) {
		if(game.getDealtHand() == null)
			throw new CardException("ERROR: No hand");
		else if(game.getDealtHand().getCards().size() >= 1 )
		{
			game.getDealtHand().highest();
		}
		else
			throw new CardException("ERROR: Not enough cards in deck.");
	}

}

