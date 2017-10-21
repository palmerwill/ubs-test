/**
 * 
 */
package com.ubs.bean;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.bean.CardBean.Card;
import com.ubs.bean.CardBean.Suit;


/**
 * @author Will Palmer
 */
public class TestCardBean
{
	@Test
	public void constructor()
	{
		final CardBean bean = new CardBean(Suit.HEARTS, Card.FOUR);
		
		Assert.assertEquals(Suit.HEARTS, bean.getSuit());
		Assert.assertEquals(Card.FOUR, bean.getCard());
	}
}
