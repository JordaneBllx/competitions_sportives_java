package sport_competition;

import java.util.*;

/**
 * SelectionGlobale, a type of SelectionStrategy
 * All the first in each pool end up in the terminal phase. If the number of players is not a power of two (necessary for the execution of a tournament), the best or all second place players will be selected, then the best third place players if necessary.
 * @see SelectionStrategy
 * @version 2.0
 */
public class SelectionGlobal implements SelectionStrategy  { 

    /**
     * returns an ArrayList of Competitors selected for the final phase (Tournament)
     * @param leagues an ArrayList of played leagues
     * @return the ArrayList of Competitors selected of played leagues
     */
    public ArrayList<Competitor> getCompetitorsForFinalTournament (ArrayList<League> leagues) {
        ArrayList<Competitor> listNumber1 = new ArrayList<Competitor>();
        ArrayList<Competitor> listNumber2 = new ArrayList<Competitor>();
        ArrayList<Competitor> listNumber3 = new ArrayList<Competitor>();
        
        ArrayList<Map<Competitor,Integer>> listRanking = new ArrayList<Map<Competitor,Integer>>();
        for (League l : leagues) 
            listRanking.add(l.ranking());

        for (Map<Competitor,Integer> rank : listRanking){
            /*for (Map.Entry<Competitor,Integer> entry : rank.entrySet()) {
                System.out.println(entry.getKey().toString());
            }*/
            Iterator it = rank.entrySet().iterator();
            listNumber1.add((Competitor)((Map.Entry)it.next()).getKey());
            if (it.hasNext()) {
                listNumber2.add((Competitor)((Map.Entry)it.next()).getKey());
            }
            if (it.hasNext()) {
                listNumber3.add((Competitor)((Map.Entry)it.next()).getKey());
            }
        }
        Map<Competitor,Integer> rank2 = (new League(new ClassicalMatch(), listNumber2)).ranking();
        Map<Competitor,Integer> rank3 = (new League(new ClassicalMatch(), listNumber3)).ranking();
        int listSize1 = listNumber1.size() ;
        int listSize2 = listNumber2.size() ;
        int listSize3 = listNumber3.size() ;
        int j=0;
        int i=0;
        Iterator it2 = rank2.entrySet().iterator();
        Iterator it3 = rank3.entrySet().iterator();
        while (!SelectionStrategy.powerOfTwoWithoutException(listSize1+i) && (i+j)<listSize3+listSize2) {
            if (i<listSize2) {
                listNumber1.add((Competitor)((Map.Entry)it2.next()).getKey());
                i++;
            }
            else {
                listNumber1.add((Competitor)((Map.Entry)it3.next()).getKey());
                j++;
            }
        }
        return listNumber1;
    }
}
