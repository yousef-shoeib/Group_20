package cards;

import model.Bookshelf;

public class PersonalGoalCard12 extends PersonalGoalCard {
	public PersonalGoalCard12(Bookshelf b) {
		super(b);
	}

	/* riga.colonna tipo
	 * 0.2 libri
	 * 1.1 piante
	 * 2.2 quadri
	 * 3.3 trofei
	 * 4.4 giochi
	 * 5.0 gatti
	 */
	private boolean match1= this.isColorMatching(0, 2, null);
	private boolean match2= this.isColorMatching(1, 1, null);
	private boolean match3= this.isColorMatching(2, 2, null);
	private boolean match4= this.isColorMatching(3, 3, null);
	private boolean match5= this.isColorMatching(4, 4, null);
	private boolean match6= this.isColorMatching(5, 0, null);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals12.png";
	
}

