package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * League, a type of Competition
 * Each competitor meets twice each of the other competitors in the championship. At the end of the championship, the winner is the competitor with the most victories.
 * @see Competition
 * @version 1.0
 */
public class League extends Competition {

  /**
   * Contructor 
   */
  public League (Match match, ArrayList<Competitor> competitors){
    super(match, competitors);
  }

  /**
   * return a description of the matches played and play all the matches of a competition
   * @param competitors ArrayList<Competitor> of competitors
   * @return description of the matches played
   */
  public String play (ArrayList<Competitor> competitors) {
    int i;
    int j;
    String matchDescription = "";
    for (i=0;i<competitors.size();i++) {
      for (j=0;j<competitors.size();j++) {
        if (i!=j) {
          Competitor c1 = competitors.get(i);
          Competitor c2 = competitors.get(j);
          Competitor winner = this.scheduleMatch(c1,c2);
          matchDescription = matchDescription + c1.getName() + " vs " + c2.getName() + " --> " + winner.getName() + " wins!\n";
        }    
      }
    }
    return matchDescription;
  }

  /**
   * display a description of the results of League
   */
  public void getFinalDescription() {
    Map<Competitor,Integer> resultsTheLeague = this.ranking();
    
    System.out.println("\n*** Ranking ***");
    for (Map.Entry<Competitor,Integer> entry : resultsTheLeague.entrySet())  
      System.out.println(entry.getKey().toString());
  }

}
