package sport_competition;

import java.util.*;

/**
 * SelectionStrategy, an interface to descripte different strategy to select competitors of played leagues
 * @version 2.0
 */
public interface SelectionStrategy {

    /**
     * returns an ArrayList of Competitors selected for the final phase (Tournament)
     * @param leagues an ArrayList of played leagues
     * @return the ArrayList of Competitors selected of played leagues
     */
    public ArrayList<Competitor> getCompetitorsForFinalTournament (ArrayList<League> leagues) ;

    /**
     * returns True if a number is a power of true, otherwize false
     * @param number a number to check if it's a power of two
     * @return True if number is a power of true, otherwize false
     */
    public static boolean powerOfTwoWithoutException (int number) {
        if (number%2 != 0) {
            return false;
        }
        else if (number == 2) {
            return true;
        }
        else {
            return powerOfTwoWithoutException(number/2);
        }
    }

}