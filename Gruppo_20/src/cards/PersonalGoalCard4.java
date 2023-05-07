package cards;

import model.Bookshelf;

public class PersonalGoalCard4 extends PersonalGoalCard {
	public PersonalGoalCard4(Bookshelf b) {
		super(b);
	}

	/* riga.colonna tipo
	 * 0.4 giochi
	 * 2.0 trofei
	 * 2.2 quadri
	 * 3.3 piante
	 * 4.1 libro
	 * 4.2 gatto
	 */
	private boolean match1= this.isColorMatching(0, 4, null);
	private boolean match2= this.isColorMatching(2, 0, null);
	private boolean match3= this.isColorMatching(2, 2, null);
	private boolean match4= this.isColorMatching(3, 3, null);
	private boolean match5= this.isColorMatching(4, 1, null);
	private boolean match6= this.isColorMatching(4, 2, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals4.png";
	
}
