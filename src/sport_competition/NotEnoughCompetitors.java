package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * NotEnoughCompetitors Exception where the competitiors' number isn't enough for a Competition
 * @version 1.0
 * @see Exception
 */
public class NotEnoughCompetitors extends Exception {
  
    public NotEnoughCompetitors(String msg) {
      super(msg);
    }

    public NotEnoughCompetitors() {
      super();
    }
}