package org.elsys.cardgame.impl;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Operation;

public class DrawTopCard implements Operation{
	@Override
	public String getName() {
		return "draw_top_card";
	}

	@Override
	public void execute(Game game, String... params) {
		if(game.getDeck().size() >= 1)
		{
			game.getDeck().drawTopCard();
			game.setDealtHand(null);
		}
		else
			throw new CardException("ERROR: Not enough cards in deck.");
	}
}
