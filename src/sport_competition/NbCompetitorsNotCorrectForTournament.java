package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * NbCompetitorsNotCorrectForTournament Exception where the competitiors' number isn't a power of two for a Tournament
 * @version 1.0
 * @see Exception
 */
public class NbCompetitorsNotCorrectForTournament extends Exception {
    public NbCompetitorsNotCorrectForTournament(String msg) {
      super(msg);
    }
}