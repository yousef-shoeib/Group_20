package cards;

public class PersonalGoalCard1 extends PersonalGoalCard {
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
	private int points;
	public void setPoints() {
		int matches=this.countMatches();
		if(matches==1||matches==2) {
			this.points=matches;
		}
		if(matches==3) {
			this.points=4;
		}
		if(matches==4) {
			this.points=6;
		}
		if(matches==5) {
			this.points=9;
		}
		if(matches==6) {
			this.points=12;
		}
	}
	public int getPoints() {
		return points;
	}
	
}
