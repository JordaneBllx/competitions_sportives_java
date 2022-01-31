package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * An interface CompetitonListener to describes different types of CompetitionListener (like Journalists)
 * @see Journalist
 * @see Competition
 * @version 3.0
 */
public interface CompetitonListener extends java.util.EventListener {
    public void reactToCompetition(Competition competition);
}

