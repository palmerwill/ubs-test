/**
 * 
 */
package com.ubs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.bean.CardBean;
import com.ubs.bean.CardBean.Card;
import com.ubs.bean.CardBean.Suit;

/**
 * @author Will Palmer
 */
public class TestDeck
{
	@Test
	public void constructor()
	{
		final List<CardBean> emptyDeck = new ArrayList<CardBean>();
		new Deck(emptyDeck);

		Assert.assertEquals(52, emptyDeck.size());

		final Map<Suit, Set<Card>> cards = new HashMap<Suit, Set<Card>>();
		for (CardBean bean : emptyDeck) {
			if (!cards.containsKey(bean.getSuit()))
				cards.put(bean.getSuit(), new HashSet<Card>());
			final Set<Card> cardSet = cards.get(bean.getSuit());
			cardSet.add(bean.getCard());
		}

		final Set<Suit> suits = cards.keySet();
		Assert.assertEquals(4, suits.size());

		final Collection<Set<Card>> values = cards.values();
		for (Set<Card> cardValues : values) {
			Assert.assertEquals(13, cardValues.size());
		}
	}
	
	@Test
	public void draw52()
	{
		final List<CardBean> emptyDeck = new ArrayList<CardBean>();
		final Deck deck = new Deck(emptyDeck);

		CardBean latestCard = null;
		final Set<CardBean> cards = new HashSet<>();
		for(int i = 0; i < 52; i++) {
			latestCard = deck.draw();
			cards.add(latestCard);
		}
		
		Assert.assertNotNull(latestCard);
		Assert.assertEquals(52, cards.size());
	}

	@Test
	public void draw53()
	{
		final List<CardBean> emptyDeck = new ArrayList<CardBean>();
		final Deck deck = new Deck(emptyDeck);

		CardBean latestCard = null;
		for(int i = 0; i < 53; i++) {
			latestCard = deck.draw();
		}
		
		Assert.assertNull(latestCard);
	}
	
	@Test
	public void shuffleDrawShuffleDraw()
	{
		final List<CardBean> emptyDeck = new ArrayList<CardBean>();
		final Deck deck = new Deck(emptyDeck);

		CardBean latestCard1 = null;
		for(int i = 0; i < 52; i++) {
			latestCard1 = deck.draw();
		}
		
		Assert.assertNotNull(latestCard1);
		
		deck.shuffle();
		CardBean latestCard2 = null;
		for(int i = 0; i < 52; i++) {
			latestCard2 = deck.draw();
		}
		
		Assert.assertNotNull(latestCard2);
	}
}