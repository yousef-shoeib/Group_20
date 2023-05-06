package cards;

public class PersonalGoalCard2 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 1.1 pianta
	 * 2.0 gatto
	 * 2.2 gioco
	 * 3.4 libro
	 * 4.3 trofeo
	 * 5.4 quadro
	 */
	
	
	private boolean match1= this.isColorMatching(1, 1, null);
	private boolean match2= this.isColorMatching(2, 0, null);
	private boolean match3= this.isColorMatching(2, 2, null);
	private boolean match4= this.isColorMatching(3, 4, null);
	private boolean match5= this.isColorMatching(4, 3, null);
	private boolean match6= this.isColorMatching(5, 4, null);
	private String path="./resources/Assets/personalGoalCards/Personal_Goals2.png";
	
	
}

