package sport_competition;

import java.util.*;


/**
 * Master, a type of Competition
 * The competition begins with a group stage at the end of which some competitors are selected to compete in the final stage of the tournament. The pools are organized in the form of a championship while the final phase takes place in the form of a knockout tournament.
 * @see Competition
 * @version 2.0
 */
public class Master extends Competition{

	protected SelectionStrategy selection;
	protected Pool pools ;
	protected Tournament phaseFinal ;
	/**
	 * Constructor
	 */
	public Master(Match match, ArrayList<Competitor> competitors,SelectionStrategy selection) {
		super(match,competitors);
		this.selection=selection;
	}

	/**
	 * return a description of the matches played and play all the matches of a competition
	 * @param competitors ArrayList<Competitor> of competitors
	 * @return description of the matches played
	 */
	public String play(ArrayList<Competitor> competitors) {
		Pool thePool = new Pool (this.match, this.competitors, this.selection);
		try {
			thePool.PoolMaker();
		}
		catch (LackOfCompetitors e) {
		}
		this.pools = thePool ;
		String description = thePool.playAllLeagues();
		ArrayList<League> copyLeagues = LeaguesCopyWithResults(this.getPool().getLeagues());
		ArrayList<Competitor> competitorsTournament =  this.getSelection().getCompetitorsForFinalTournament(copyLeagues);
		Tournament finalPhase = new Tournament (this.match,competitorsTournament);
		description = description + "\nTournament -- Final Phase\n" + finalPhase.play(competitorsTournament);
		this.phaseFinal = finalPhase;
		return description;
	}
	/**
	 * return a SelectionStrategy of a Master
	 * @return the SelectionStrategy of this
	 */
	public SelectionStrategy getSelection() {
		return this.selection;
	}

	/**
	 * return a Pool of a Master
	 * @return the Pool of this
	 */
	public Pool getPool() {
		return this.pools;
	}

	/**
	 * return a Tournament of a Master
	 * @return the Tournament of this
	 */
	public Tournament getPhaseFinal() {
		return this.phaseFinal;
	}
	
	/**
	 * make a copy of an ArrayList of League
	 * @param leagues an ArrayList of League
	 * @return a copy of leagues
	 */
	public ArrayList<League> LeaguesCopyWithResults(ArrayList<League> leagues) {
		ArrayList<League> leagueCopy = new ArrayList<>();
		for (League l : leagues) {
			ArrayList<Competitor> competitors = new ArrayList<>();
			for (Competitor c : l.getCompetitors()) {
				competitors.add(new Competitor(c.getName(),c.getNbPoints()));
			}
			leagueCopy.add(new League(l.getMatch(),competitors));
		}
		return leagueCopy;
	}

	/**
   * display a description of the results of Master
   */
	public void getFinalDescription() {
		
        ArrayList<League> leaguesOfMaster = this.getPool().getLeagues();

        ArrayList<Map<Competitor,Integer>> listRanking = new ArrayList<Map<Competitor,Integer>>();
        int i=1;
        for (League l : leaguesOfMaster) {
            Map<Competitor,Integer> resultsOfALeague = l.ranking();
            System.out.println("\n*** Ranking League n°"+ i +"***");
            for (Map.Entry<Competitor,Integer> entry : resultsOfALeague.entrySet())
                System.out.println(entry.getKey().toString());
            i++;  
        }

        Map<Competitor,Integer> resultsTheTournamentOfTheMaster = this.getPhaseFinal().ranking();
        System.out.println("\n*** Ranking Final Tournament***");
        for (Map.Entry<Competitor,Integer> entry : resultsTheTournamentOfTheMaster.entrySet())  
            System.out.println(entry.getKey().toString());
	}
}
