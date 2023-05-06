package cards;

public class PersonalGoalCard3 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 1.0 quadro
	 * 1.3 giochi
	 * 2.2 painta
	 * 3.1 gatto
	 * 3.4 trofei
	 * 5.0 libro
	 */
	private boolean match1= this.isColorMatching(1, 0, null);
	private boolean match2= this.isColorMatching(1, 3, null);
	private boolean match3= this.isColorMatching(2, 2, null);
	private boolean match4= this.isColorMatching(3, 1, null);
	private boolean match5= this.isColorMatching(3, 4, null);
	private boolean match6= this.isColorMatching(5, 0, null);
	
	private String path="./resources/Assets/personalGoalCards/Personal_Goals3.png";
	
}
