import java.util.List;
import java.util.ArrayList;

public class Hand
{
	public List<Card> cards = new ArrayList<Card>();
	public int value;

	public int Value()
	{
		int aceCount = 0;
		this.value = 0;
		for ( int i = 0; i < this.cards.size(); i++ )
		{
			//add handling for ace
			if ( this.cards.get(i).faceValue.equals("A") )
			{
				aceCount++;
			}
			else
			{
				this.value += this.cards.get(i).numericValue;
			}
			
		}

		for ( int i = 0; i < aceCount; i++ )
		{
			if ( this.value + 11 <= 21 && i == 0 )
			{
				this.value += 11;
			}
			else
			{
				this.value += 1;
			}
		}

		return this.value;
	}

	public String print(int dealer)
	{
		String hand = "";
		for (int i = 0; i < this.cards.size(); i++ )
		{
			if ( dealer == 1 )
			{
				i++;
				hand += "--\n";
			}
			hand += this.cards.get(i).print() + "\n";
		}
		return hand;
	}
}