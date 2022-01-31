package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * An abstract Competition class to different types of Competition
 * @see Tournament
 * @see League
 * @version 1.0
 */
public abstract class Competition {

  protected final Match match;
  protected final ArrayList<Competitor> competitors;
  private Collection<CompetitonListener> listCL = new HashSet<CompetitonListener>();
  
  /**
   * Constructor
   */
  public Competition (Match match, ArrayList<Competitor> competitors) {
    this.competitors = competitors;
    this.match = match;
  }

  /**
   * subscribe the cl to the competition
   * @param cl a CompetitionListener to add in the list of CompetitionListener
   */
  public void register(CompetitonListener cl) {
		listCL.add(cl);		
	}
  
  /**
   * unsubscribe the cl to the competition
   * @param cl a CompetitionListener to remove in the list of CompetitionListener
   */
	public void unRegister(CompetitonListener cl) {
		listCL.remove(cl);
	}

  /**
   * execute the event on all the CompetitionListener of the Competition
   */
	public void endCompetitionDetected() {
		for (CompetitonListener competitionObserver : listCL) {
			competitionObserver.reactToCompetition(this);
		}
  }

  /**
   * return the ArrayList<Competitor> competitors
   * @return competitors of this
   */
  public ArrayList<Competitor> getCompetitors() {
    return this.competitors;
  }

  /**
   * return the number of competitors
   * @return the size of ArrayList<Competitor> competitors of this
   */
  public int getNbCompetitors() {
    return this.competitors.size();
  }

  /**
   * play matches of a competition (of this)
   */
  public void play() {
    try {
      this.enoughCompetitors(this.competitors);
      this.play(this.competitors);
      this.endCompetitionDetected();
    }
    catch (NotEnoughCompetitors e) {
      System.out.println("2 Competitors minimum");
    }
  }

  /**
   * return a description of the matches played and play all the matches of a competition
   * @param competitors ArrayList<Competitor> of competitors
   * @return description of the matches played
   */
  public abstract String play (ArrayList<Competitor> competitors);

  /**
   * throws NotEnoughCompetitors Exception if a competition has not enough competitors
   * @param competitors ArrayList<Competitor> of competitors
   * @exception NotEnoughCompetitors if competitors.size() inferior 2
   */
  public void enoughCompetitors (ArrayList<Competitor> competitors) 
  throws NotEnoughCompetitors {
    if (competitors.size()<2) {
      throw new NotEnoughCompetitors();
    }
  }

  /**
   * organize a match between two competitors for a competition
   * @param c1 a Competitor
   * @param c2 another Competitor
   * @return the winner of the match
   */
  public Competitor scheduleMatch (Competitor c1, Competitor c2) {
    Competitor winner = this.match.resultOfOneMatch(c1,c2);
    return winner;
  }

  /**
   * sorting in descending order the list of competitors according to their number of points
   * @return a Map corresponding to the ranking
   */
  public Map<Competitor,Integer> ranking () {
    Map<Competitor, Integer> rank = new HashMap<>();
    for (Competitor competitor : this.competitors) {
        rank.put(competitor, competitor.getNbPoints());
    }
    MapUtil util = new MapUtil();
    return util.sortByDescendingValue(rank);
  }


  /**
   * return the match of a Competition
   * @return the match of this
   */
  public Match getMatch() {
    return this.match;
  }

  public abstract void getFinalDescription();

}
