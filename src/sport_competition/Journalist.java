package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * An class Journalist/Bookmakers to describes a listener of certain Competition
 * @see Competition
 * @version 3.0
 */
public class Journalist implements CompetitonListener {

    /**
     * execute the displaying of a Competition
     * @param theCompetition the Competition to display
     */
	public void reactToCompetition(Competition theCompetition) {
		theCompetition.getFinalDescription();
    }

    /**
     * modify a cote of a Competitor
     * @param competitor the Competitor to modify his cote
     * @param cote the number of cote to put on competitor
     */
    public void putCoteOnCompetitor(Competitor competitor, int cote) {
        competitor.putCote(cote);
    }
}