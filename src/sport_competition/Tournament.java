package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * Tournament, a type of Competition
 * Only the competitors who have won their match in one round participate in the next round. The winners of each match meet with each other until only one remains, who is then declared the winner of the tournament. The organization of such tournaments requires a number of competitors to the power of 2.
 * @see Competition
 * @version 1.0
 */
public class Tournament extends Competition {

  /**
   * Contructor 
   */
  public Tournament (Match match, ArrayList<Competitor> competitors){
    super(match, competitors);
  }

  /**
   * return a copy of the List of Competitors
   * @param competitors an ArrayList<Competitor>
   * @return a copy of ArrayList<Competitor> given in @param
   */
  public ArrayList<Competitor> copyCompetitors (ArrayList<Competitor> competitors) {
    ArrayList<Competitor> competitorsRemaining = new ArrayList<Competitor>(); 
    Iterator<Competitor> iter = competitors.iterator();
    while (iter.hasNext())
    {
      competitorsRemaining.add(iter.next());
    }
    return competitorsRemaining;
  }

  /**
   * return a description of the matches played and play all the matches of a competition
   * @param competitors ArrayList<Competitor> of competitors
   * @return description of the matches played
   */
  public String play (ArrayList<Competitor> competitors){
    try {
      int nbCompetitors = competitors.size();
      powerOfTwo(nbCompetitors);
      String matchDescription = "";
      ArrayList<Competitor> competitorsRemaining = copyCompetitors(competitors);
      int size = competitorsRemaining.size();
      while (size!=1) {
        for (int i=0;i<competitorsRemaining.size();i++) {
          Competitor c1 = competitorsRemaining.get(i);
          Competitor c2 = competitorsRemaining.get(i+1);
          Competitor winner = this.scheduleMatch(c1,c2);
          if (c1.equals(winner)) {
            competitorsRemaining.remove(c2);
            size--;
          }
          else {
            competitorsRemaining.remove(c1);
            size--;
          }
          matchDescription = matchDescription + c1.getName() + " vs " + c2.getName() + " --> " + winner.getName() + " wins!\n" ;    
        }
      }
      return matchDescription;
    }
    catch (NbCompetitorsNotCorrectForTournament e) {
      return e.toString();
    }
  }


  /**
   * return an NbCompetitorsNotCorrectForTournament Exception if the number of Competitors are not a power of two
   * @param number a number to test if it's a power of two
   * @exception NbCompetitorsNotCorrectForTournament if the number of Competitors are not a power of two
   * @return true if the number of competitors is a power of two
   */
  public boolean powerOfTwo (int number) throws NbCompetitorsNotCorrectForTournament {
    if (number%2 != 0) {
      throw new NbCompetitorsNotCorrectForTournament("Please give a number power of two");
    }
    else if (number == 2) {
      return true;
    }
    else {
      return powerOfTwo(number/2);
    }
  }

  /**
   * display a description of the results of Tournament
   */
  public void getFinalDescription() {
    Map<Competitor,Integer> resultsTheTournament = this.ranking();
    
    System.out.println("\n*** Ranking ***");
    for (Map.Entry<Competitor,Integer> entry : resultsTheTournament.entrySet())  
      System.out.println(entry.getKey().toString());
  }

}




  /*
  protected void play (ArrayList<Competitor> competitors) {
    String matchDescription = "";
    ArrayList<Competitor> competitorsRemaining = new ArrayList<Competitor>(); 
    Iterator<Competitor> iter = competitors.iterator();
    while (iter.hasNext())
    {
      competitorsRemaining.add(iter.next());
    }
    while (competitorsRemaining.size()!=1) {
      for (int i=0;i<competitorsRemaining.size();i++) {
        Competitor c1 = competitorsRemaining.get(i);
        if (i+1<competitorsRemaining.size()) {
          Competitor c2 = competitorsRemaining.get(i+1);
          Competitor winner = this.scheduleMatch(c1,c2);
          if (c1.equals(winner)) {
            competitorsRemaining.remove(c2);
          }
          else {
            competitorsRemaining.remove(c1);
          }
          System.out.println(c1.getName() + " vs " + c2.getName() + " --> " + winner.getName() + " wins!") ;    
        }
      }
    }   
  }*/



 