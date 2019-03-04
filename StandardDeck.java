import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StandardDeck
{
    List<Card> cards = new ArrayList<Card>();
    
    public StandardDeck()
    {
        for( int i = 0; i < 52; i++ )
        {
            Card card = new Card();
            if ( i % 13 < 10 )
            {
                card.numericValue = i % 13 + 1;
                if ( i % 13 == 0 )
                {
                    card.faceValue = "A";
                }
                else
                {
                    card.faceValue = (i % 13 + 1) + "";
                }
            }
            else
            {
                card.numericValue = 10;
                if ( i % 13 - 10 == 0 )
                {
                    card.faceValue = "J";
                }
                else if ( i % 13 - 10 == 1 )
                {
                    card.faceValue = "Q";
                }
                else
                {
                    card.faceValue = "K";
                }
            }
            
            if ( i % 4 == 0 )
            {
                card.suit = "heart";
            }
            else if ( i % 4 == 1 )
            {
                card.suit = "diamond";
            }
            else if ( i % 4 == 2 )
            {
                card.suit = "club";
            }
            else if ( i % 4 == 3 )
            {
                card.suit = "spade";
            }
            cards.add(i, card);
        }
        Collections.shuffle(cards);
    }

    public void Deal(List<Hand> hands, int cards)
    {
        for ( int i = 0; i < cards; i++ )
        {
            for (int j = 0; j < hands.size(); j++ )
            {
                hands.get(j).cards.add(this.cards.get(0));
                this.cards.remove(0);
            }
        }
        
    }

    public void Hit(Hand hand)
    {
        hand.cards.add(this.cards.get(0));
        this.cards.remove(0);
    }

}