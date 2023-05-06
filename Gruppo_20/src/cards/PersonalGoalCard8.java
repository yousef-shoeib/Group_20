package cards;

public class PersonalGoalCard8 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 0.4 quadro
	 * 1.1 gatti
	 * 2.2 trofei
	 * 3.0 pianta
	 * 4.3 libro
	 * 5.3 giochi
	 */
	private boolean match1= this.isColorMatching(0, 4, null);
	private boolean match2= this.isColorMatching(1, 1, null);
	private boolean match3= this.isColorMatching(2, 2, null);
	private boolean match4= this.isColorMatching(3, 0, null);
	private boolean match5= this.isColorMatching(4, 3, null);
	private boolean match6= this.isColorMatching(5, 3, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals8.png";
	
}
