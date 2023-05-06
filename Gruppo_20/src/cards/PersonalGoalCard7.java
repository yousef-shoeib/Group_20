package cards;

public class PersonalGoalCard7 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 0.0 gatti
	 * 1.3 quadri
	 * 2.1 piante
	 * 3.0 trofei
	 * 4.4 giochi
	 * 5.2 libro
	 */
	private boolean match1= this.isColorMatching(0, 0, null);
	private boolean match2= this.isColorMatching(1, 3, null);
	private boolean match3= this.isColorMatching(2, 1, null);
	private boolean match4= this.isColorMatching(3, 0, null);
	private boolean match5= this.isColorMatching(4, 4, null);
	private boolean match6= this.isColorMatching(5, 2, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals7.png";
	
}
