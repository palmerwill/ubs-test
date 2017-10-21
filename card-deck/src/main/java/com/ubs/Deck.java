/**
 * 
 */
package com.ubs;

import java.util.ArrayList;
import java.util.List;

import com.ubs.bean.CardBean;
import com.ubs.bean.CardBean.Card;
import com.ubs.bean.CardBean.Suit;

/**
 * @author Will Palmer
 */
public class Deck
{
	private List<CardBean> cards;

	public Deck(List<CardBean> emptyDeck)
	{
		cards = emptyDeck;
		initialiseDeck();
	}

	public void shuffle()
	{
		initialiseDeck();
		final List<CardBean> temp = new ArrayList<>();
		while(cards.size() > 0) {
			final int index = getRandomIndex();
			temp.add(cards.remove(index));
		}
		cards.clear();
		cards.addAll(temp);
	}

	public CardBean draw()
	{
		if(cards.size() == 0)
			return null;
		final int index = getRandomIndex();
		return cards.remove(index);
	}

	private void initialiseDeck()
	{
		final List<CardBean> cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Card card : Card.values()) {
				cards.add(new CardBean(suit, card));
			}
		}
		this.cards.clear();
		this.cards.addAll(cards);
	}
	
	private int getRandomIndex()
	{
		return (int)(Math.round((Math.random() * (double)(cards.size() - 1))));
	}
}
