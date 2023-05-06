package cards;

public class PersonalGoalCard9 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 0.2 giochi
	 * 2.2 gatti
	 * 3.4 ladri
	 * 4.1 trofei
	 * 4.4 piante
	 * 5.0 quadri
	 */
	private boolean match1= this.isColorMatching(0, 2, null);
	private boolean match2= this.isColorMatching(2, 2, null);
	private boolean match3= this.isColorMatching(3, 4, null);
	private boolean match4= this.isColorMatching(4, 1, null);
	private boolean match5= this.isColorMatching(4, 4, null);
	private boolean match6= this.isColorMatching(5, 0, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals9.png";
	
}
