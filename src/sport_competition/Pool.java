package sport_competition;

import java.util.*;

/**
 * Pool, a class to make pools of a Master
 * @see Master
 * @version 2.0
 */
public class Pool extends Master {

	protected ArrayList<League> listLeague ;

	/**
	 * Constructor
	 */
	public Pool(Match match, ArrayList<Competitor> competitors ,SelectionStrategy selection) {
		super(match, competitors, selection);
		this.listLeague = new ArrayList<League>();		
	}
	
	/**
	 * returns a list containing all the factors of a given parameters number
	 * @param number a number
	 * @return the list containing all the factors of number
	 */
	public ArrayList<Integer> getFactors (int number) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i =1 ; i<= number ; i++) {
			if (number % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}

	/**
	 * returns a slice of a ArrayList of Competitors
	 * @param index1 the beginning of the slice
	 * @param index2 the end of the slice, excluded
	 * @return the slice of this.competitors
	 */
	public ArrayList<Competitor> getPartOfCompetitors(int index1 , int index2) {
		ArrayList<Competitor> secondo = new ArrayList<Competitor>();
		for (int i = index1; i<index2 ; i++) {
			secondo.add(this.competitors.get(i));
		}
		return secondo;
	}

	/**
	 * put in the poolObject an ArrayList of Leagues made in this function
	 * @exception LackOfCompetitors if the number of competitors isn't an even number
	 */
	public void PoolMaker() throws LackOfCompetitors { 
		int competitorsSize = this.competitors.size();
		ArrayList<League> leagues = new ArrayList<League>();
		if (competitorsSize % 2 != 0) {
			throw new LackOfCompetitors("Need an even number of competitors to make equal teams");
		}
		else {
			ArrayList<Integer> factors = getFactors(competitorsSize);
			int factorsSize = factors.size();
			int poolsNumber = factors.get(factorsSize/2) ;
			int numberPlayersPerPool = competitorsSize / poolsNumber ;
			int i=0 ;
			while (i!=competitorsSize) {
				leagues.add(new League(new ClassicalMatch(), this.getPartOfCompetitors(i , i + numberPlayersPerPool)));
				i+=numberPlayersPerPool;
			}				
			this.listLeague = leagues;
		}
	}

	/**
	 * returns a displayable descriptions of all played leagues in the PoolObject
	 * @return the displayable description 
	 */
	public String playAllLeagues () {
		String description = "";
		int i = 1 ;
		for (League l : this.listLeague) {
			description = description + "\nLeague n°" + i + "\n";
			description = description + l.play(l.getCompetitors());
			i++;
		}
		return description;
	}
	
	/**
	 * returns the SelectionStrategy of a Pool
	 * @return the SelectionStrategy of this
	 */
	public SelectionStrategy getSelection() {
		return this.selection;
	}

	/**
	 * returns an ArrayList<League> of a Pool
	 * @return the ArrayList<League> of this
	 */
	public ArrayList<League> getLeagues () {
		return this.listLeague;
	}
}
