/**
 * 
 */
package com.ubs.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Will Palmer
 */
public class CardBean
{
	private Suit suit;
	private Card card;
	
	public CardBean(Suit suit, Card card)
	{
		this.suit = suit;
		this.card = card;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public Card getCard()
	{
		return card;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(obj == this)
			return true;
		if(!(obj instanceof CardBean))
			return false;
		final CardBean other = (CardBean)obj;
		return new EqualsBuilder().append(suit, other.suit).append(card, other.card).isEquals();
	}
	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(suit).append(card).toHashCode();
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("Suit", suit)
				.append("Card", card).toString();
	}
	
	public enum Suit
	{
		SPADES,
		CLUBS,
		HEARTS,
		DIAMONDS;
	}
	
	public enum Card
	{
		ACE(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13);
		
		private int value;
		
		private Card(int value)
		{
			
		}
		
		public int getValue()
		{
			return value;
		}
	}
}
