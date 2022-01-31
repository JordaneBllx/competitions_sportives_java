package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * Match describes differents type of Match for Competitions
 * @see ClassicalMatch
 * @version 1.0
 */
public abstract class Match {

  /**
   * Constructor
   */
  public Match () {
    super();
  }

  /**
   * return the winner of one match between two competitors
   * @param c1 a Competitor
   * @param c2 another Competitor
   * @return the winner of the match between c1 and c2
   */
  public abstract Competitor resultOfOneMatch (Competitor c1, Competitor c2) ;
  
}
