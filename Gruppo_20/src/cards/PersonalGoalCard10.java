package cards;

public class PersonalGoalCard10 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 0.4 trofei
	 * 1.1 giochi
	 * 2.0 libro
	 * 3.3 gatti
	 * 4.1 quadri
	 * 5.3 piante
	 */
	private boolean match1= this.isColorMatching(0, 4, null);
	private boolean match2= this.isColorMatching(1, 1, null);
	private boolean match3= this.isColorMatching(2, 0, null);
	private boolean match4= this.isColorMatching(3, 3, null);
	private boolean match5= this.isColorMatching(4, 1, null);
	private boolean match6= this.isColorMatching(5, 3, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals10.png";
	
}
