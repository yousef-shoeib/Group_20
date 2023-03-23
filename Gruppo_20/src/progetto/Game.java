package progetto;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();
		int numberOfPlayers=0;
		String name=new String();
		Scanner in=new Scanner(System.in);
		do {
			System.out.println("Insert number of player: ");
			numberOfPlayers= in.nextInt();
			if(numberOfPlayers<2|| numberOfPlayers>4) {
					System.out.println("You need 2-4 players to begin.");
			}
		}while(numberOfPlayers<2 || numberOfPlayers>4);
		
		
		switch (numberOfPlayers) {
				
		case 2:
			System.out.println("Insert player name: ");
			in.nextLine();
			name= in.nextLine();
			player1= new Player(name);
			System.out.println("Insert player name: ");
			name= in.nextLine();
			player2= new Player(name);
			break;
				
		case 3:
			System.out.println("Insert player name: ");
			in.nextLine();
			name= in.nextLine();
			player1= new Player(name);
			System.out.println("Insert player name: ");
			name= in.nextLine();
			player2= new Player(name);
			System.out.println("Insert player name: ");
			name= in.nextLine();
			player3= new Player(name);
			break;
				
		case 4:
			System.out.println("Insert player name: ");
			in.nextLine();
			name= in.nextLine();
			player1= new Player(name);
			System.out.println("Insert player name: ");
			name= in.nextLine();
			player2= new Player(name);
			System.out.println("Insert player name: ");
			name= in.nextLine();
			player3= new Player(name);
			System.out.println("Insert player name: ");
			name= in.nextLine();
			player4= new Player(name);
			break;
			
		}
			player1.stampa();
		
			player2.stampa();
		
			player3.stampa();
	
			player4.stampa();
		
			in.close();
	}

}
