package cards;

import model.Bookshelf;

public class PersonalGoalCard5 extends PersonalGoalCard {
	public PersonalGoalCard5(Bookshelf b) {
		super(b);
	}

	/* riga.colonna tipo
	 * 1.1 trofei
	 * 3.1 quadri
	 * 3.2 libri
	 * 4.4 piante
	 * 5.0 giochi
	 * 5.3 gatto
	 */
	private boolean match1= this.isColorMatching(1, 1, null);
	private boolean match2= this.isColorMatching(3, 1, null);
	private boolean match3= this.isColorMatching(3, 2, null);
	private boolean match4= this.isColorMatching(4, 4, null);
	private boolean match5= this.isColorMatching(5, 0, null);
	private boolean match6= this.isColorMatching(5, 3, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals5.png";
	
}
