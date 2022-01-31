package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * LackOfCompetitors Exception where the competitiors' number isn't an even number
 * @version 1.0
 * @see Exception
 */
public class LackOfCompetitors extends Exception {
  
    public LackOfCompetitors(String msg) {
      super(msg);
    }

    public LackOfCompetitors() {
      super();
    }
}