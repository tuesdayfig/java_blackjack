public class Card
{
    public int numericValue;
    public String faceValue;
    public String suit;
    public Card(int numericValue, String faceValue, String suit)
    {
        this.numericValue = numericValue;
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public Card()
    {

    }

    public String print()
    {
        return (this.faceValue + " " + this.suit);
    }
}