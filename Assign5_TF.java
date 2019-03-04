import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{
    public static void main(String[] args)
    {
    	Scanner input = new Scanner(System.in);
    	String playerResponse = "Y";
    	while ( playerResponse.toUpperCase().equals("Y") || playerResponse.toUpperCase().equals("YES") )
    	{
    		System.out.println(gameRoutine() + "\n");
    		System.out.println("Continue playing? (y/n)");
    		playerResponse = input.nextLine();
    	}

    	System.out.println("Quitting game.  Thanks for playing!");
    	
    }

    public static String gameRoutine()
    {
    	StandardDeck deck = new StandardDeck();
    	List<Hand> players = new ArrayList<Hand>();
    	Scanner input = new Scanner(System.in);
    	int numberOfPlayers = 2;
    	String playerResponse = "";
    	// for number of players
    	// System.out.print("How many players (including dealer)?  ");
    	// numberOfPlayers = Integer.parseInt(input.next());

    	for ( int i = 0; i < numberOfPlayers; i++ )
    	{
    		players.add(new Hand());
    	}

    	deck.Deal(players, 2);

    	for ( int i = 0; i < numberOfPlayers; i++ )
    	{
    		if ( i == 0 )
    		{
    			System.out.println("Your Hand:\n" + players.get(i).print(i));
    		}
    		else
    		{
    			System.out.println("Dealer Hand:\n" + players.get(i).print(i));
    		}
    	}

    	if ( players.get(0).Value() == 21 && players.get(1).Value() != 21 )
    	{
    		return "You have BlackJack! Congratulations, you won this hand!";
    	}
    	else if ( players.get(1).Value() == 21 )
    	{
    		System.out.println("Dealer Hand:\n" + players.get(1).print(0));
    		return "Dealer has BlackJack. You lose.";
    	}

    	System.out.println("Your Hand:\n" + players.get(0).print(0));
    	System.out.println("Hit or Stay?");
    	playerResponse = input.nextLine();

    	while ( ( playerResponse.toUpperCase().equals("HIT") || playerResponse.toUpperCase().equals("H") ) && players.get(0).Value() < 21 )
    	{
    		deck.Hit(players.get(0));
    		System.out.println("Your Hand:\n" + players.get(0).print(0));
	    	if ( players.get(0).Value() > 21 )
	    	{
	    		return "You busted! You lost!";
	    	}
	    	System.out.println("Hit or Stay?");
	    	playerResponse = input.nextLine();
    	}

    	while ( players.get(0).Value() > players.get(1).Value() )
    	{
    		deck.Hit(players.get(1));
    		System.out.println("Dealer Hand:\n" + players.get(1).print(0));
    		if ( players.get(1).Value() > 21 )
	    	{
	    		return "Dealer busted! You won!";
	    	}
    	}

    	if ( players.get(0).Value() < players.get(1).Value() )
    	{
    		System.out.println("Dealer Hand:\n" + players.get(1).print(0));
    		
    		return "Dealer wins!";
    	}
    	else
    	{
    		System.out.println("Dealer has " + players.get(1).Value() + ". You have " + players.get(0).Value() );
    		return "Push, neither win nor lose";
    	}

    }
}