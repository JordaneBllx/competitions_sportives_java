package sport_competition;

import java.util.*;
import sport_competition.*;

public class MainSport {

    public static void main(String[] args) {
        Competitor c1 = new Competitor("Midas");
        Competitor c2 = new Competitor("Sadim");
        Competitor c3 = new Competitor("Emilie");
        Competitor c4 = new Competitor("Maxence");

        Competitor c10 = new Competitor("Emile");
        Competitor c11 = new Competitor("Romane");
        Competitor c12 = new Competitor("Meline");
        Competitor c13 = new Competitor("Camille");
        Competitor c14 = new Competitor("Thomas");
        Competitor c15 = new Competitor("Loan");
        Competitor c16 = new Competitor("Alix");
        Competitor c17 = new Competitor("Charles");

        ArrayList<Competitor> competitorsForLeague = new ArrayList<Competitor>();
        competitorsForLeague.add(c1);
        competitorsForLeague.add(c2);
        competitorsForLeague.add(c3);
        competitorsForLeague.add(c4);

        ArrayList<Competitor> competitorsForTournament = new ArrayList<Competitor>();
        competitorsForTournament.add(c10);
        competitorsForTournament.add(c11);
        competitorsForTournament.add(c12);
        competitorsForTournament.add(c13);
        competitorsForTournament.add(c14);
        competitorsForTournament.add(c15);
        competitorsForTournament.add(c16);
        competitorsForTournament.add(c17);

        Match theMatch = new ClassicalMatch();

        ArrayList<Competitor> competitorsForMaster = new ArrayList<Competitor>();

        for (int i=1; i<=24 ; i++) {
            competitorsForMaster.add(new Competitor("Joueur " + i));
        }

        League theLeague = new League (theMatch,competitorsForLeague);
        Tournament theTournament = new Tournament (theMatch, competitorsForTournament);
        Master theMaster = new Master(theMatch, competitorsForMaster, new SelectionLast());
        Master theMasterFollowed = new Master(theMatch, competitorsForMaster, new SelectionGlobal());

        /*System.out.println("\n-----------V1----------------");
        System.out.println("\n---------LEAGUE--------------");
        theLeague.play();
        Map<Competitor,Integer> resultsTheLeague = theLeague.ranking();
    
        System.out.println("\n*** Ranking ***");

        for (Map.Entry<Competitor,Integer> entry : resultsTheLeague.entrySet())  
            System.out.println(entry.getKey().toString()); 
    
        System.out.println("\n---------TOURNAMENT----------");

        theTournament.play();
        Map<Competitor,Integer> resultsTheTournament = theTournament.ranking();
    
        System.out.println("\n*** Ranking ***");
        for (Map.Entry<Competitor,Integer> entry : resultsTheTournament.entrySet())  
            System.out.println(entry.getKey().toString());
    

        System.out.println("\n-----------V2----------------");

        theMaster.play();

        ArrayList<League> leaguesOfMaster = theMaster.getPool().getLeagues();

        ArrayList<Map<Competitor,Integer>> listRanking = new ArrayList<Map<Competitor,Integer>>();
        int i=1;
        for (League l : leaguesOfMaster) {
            Map<Competitor,Integer> resultsOfALeague = l.ranking();
            System.out.println("\n*** Ranking League n°"+ i +"***");
            for (Map.Entry<Competitor,Integer> entry : resultsOfALeague.entrySet())
                System.out.println(entry.getKey().toString());
            i++;  
        }

        Map<Competitor,Integer> resultsTheTournamentOfTheMaster = theMaster.getPhaseFinal().ranking();
        System.out.println("\n*** Ranking Final Tournament***");
        for (Map.Entry<Competitor,Integer> entry : resultsTheTournamentOfTheMaster.entrySet())  
            System.out.println(entry.getKey().toString());
    

        */


        System.out.println("\n-----------V3----------------");
        Journalist theJournalist = new Journalist();
        theLeague.register(theJournalist);
        theJournalist.putCoteOnCompetitor(c1,10);
        theJournalist.putCoteOnCompetitor(c2,3);
        theJournalist.putCoteOnCompetitor(c3,5);
        theJournalist.putCoteOnCompetitor(c4,1);
        
        theLeague.register(new Journalist());
        theTournament.register(new Journalist());
        /**Affichage 2 fois car deux abonnements */
        theLeague.play();
        /**1 abonnement, 1 affichage */
        theTournament.play();
        /** 0 abonnement, 0 affichage */
        theMaster.play();

    }

}
