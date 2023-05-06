package cards;

public class PersonalGoalCard11 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 0.2 piante
	 * 1.1 libro
	 * 2.0 giochi
	 * 3.2 quadri
	 * 4.4 gatti
	 * 5.3 trofei
	 */
	private boolean match1= this.isColorMatching(0, 2, null);
	private boolean match2= this.isColorMatching(1, 1, null);
	private boolean match3= this.isColorMatching(2, 0, null);
	private boolean match4= this.isColorMatching(3, 2, null);
	private boolean match5= this.isColorMatching(4, 4, null);
	private boolean match6= this.isColorMatching(5, 3, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals11.png";
	
}

