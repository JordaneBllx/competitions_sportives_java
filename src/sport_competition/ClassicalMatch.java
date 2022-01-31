package sport_competition;

import java.util.*;
import sport_competition.*;


/**
 * ClassicalMatch describe Match were Competitors have the same chance to be the winner
 * @see Match
 * @version 1.0
 */
public class ClassicalMatch extends Match{

  /**
   * Constructor
   */
  public ClassicalMatch () {
    super();
  }

  /**
   * return the winner of one match between two competitors
   * @param c1 a Competitor
   * @param c2 another Competitor
   * @return the winner of the match between c1 and c2
   */
  public Competitor resultOfOneMatch (Competitor c1, Competitor c2) {
    Random r = new Random();
    int n = r.nextInt(2); 
    // Always one winner
    if (n==0) {
      c1.addPoint();
      c1.removecote();
      c2.addcote();
      return c1;
    }
    else {
      c2.addPoint();
      c2.removecote();
      c1.addcote();
      return c2;
    }
  }
  
}
