package cards;

public class PersonalGoalCard6 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 0.2 trofei
	 * 0.4 gatto
	 * 2.3 libro
	 * 4.1 giochi
	 * 4.3 quadri
	 * 5.0 piante
	 */
	private boolean match1= this.isColorMatching(0, 2, null);
	private boolean match2= this.isColorMatching(0, 4, null);
	private boolean match3= this.isColorMatching(2, 3, null);
	private boolean match4= this.isColorMatching(4, 1, null);
	private boolean match5= this.isColorMatching(4, 3, null);
	private boolean match6= this.isColorMatching(5, 0, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals6.png";
	
}
