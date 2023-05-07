package cards;

import model.Bookshelf;

public class PersonalGoalCard1 extends PersonalGoalCard {
	public PersonalGoalCard1(Bookshelf b) {
		super(b);	
	}

	/* riga.colonna tipo
	 * 0.0 pianta
	 * 0.2 quadro
	 * 4.1 gatto
	 * 3.2 libro
	 * 1.3 giochi
	 * 5.2 trofei
	 */
	private boolean match1= this.isColorMatching(0, 0, null);
	private boolean match2= this.isColorMatching(0, 2, null);
	private boolean match3= this.isColorMatching(4, 1, null);
	private boolean match4= this.isColorMatching(3, 2, null);
	private boolean match5= this.isColorMatching(1, 3, null);
	private boolean match6= this.isColorMatching(5, 2, null);
	
	private String path="./resources/Assets/personalGoalCards/Personal_Goals1.png";
	
}
