package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SelectionGlobaleTest {

    private ArrayList<League> leaguesPlayed;
    private SelectionGlobal selection;
    private Competitor c1;
    private Competitor c2;
    private Competitor c3;
    private Competitor c4;
    private Competitor c5;
    private Competitor c6;
    private Competitor c7;
    private Competitor c8;
    private Competitor c9;

	@Before
	public void before() {
        this.c1 = new Competitor("J1",1);
        this.c2 = new Competitor("J2",2);
        this.c3 = new Competitor("J3",3);
        this.c4 = new Competitor("J4",4);
        this.c5 = new Competitor("J5",5);
        this.c6 = new Competitor("J6",6);
        this.c7 = new Competitor("J7",7);
        this.c8 = new Competitor("J8",8);
        this.c9 = new Competitor("J9",9);
        ArrayList<Competitor> competitors1 = new ArrayList<Competitor>();
        ArrayList<Competitor> competitors2 = new ArrayList<Competitor>();
        ArrayList<Competitor> competitors3 = new ArrayList<Competitor>();
        competitors1.add(c1);
        competitors1.add(c2);
        competitors1.add(c3);
        competitors2.add(c4);
        competitors2.add(c5);
        competitors2.add(c6);
        competitors3.add(c7);
        competitors3.add(c8);
        competitors3.add(c9);
        ArrayList<League> leagues = new ArrayList<League>();
        League l1 = new League(new ClassicalMatch(),competitors1);
        League l2 = new League(new ClassicalMatch(),competitors2);
        League l3 = new League(new ClassicalMatch(),competitors3);
        leagues.add(l1);
        leagues.add(l2);
        leagues.add(l3);
        SelectionGlobal selection = new SelectionGlobal();
        this.selection = selection;
		this.leaguesPlayed = leagues;
	}


	@Test
	public void testCreation() {
        assertNotNull(this.leaguesPlayed);
	}

    @Test
    public void testSelectionGlobal () {
        ArrayList<Competitor> competitorsPhaseFinal = this.selection.getCompetitorsForFinalTournament(this.leaguesPlayed);
        assertTrue(competitorsPhaseFinal.contains(this.c3));
        assertTrue(competitorsPhaseFinal.contains(this.c6));
        assertTrue(competitorsPhaseFinal.contains(this.c9));
        assertTrue(competitorsPhaseFinal.contains(this.c8));
        assertFalse(competitorsPhaseFinal.contains(this.c1));
        assertFalse(competitorsPhaseFinal.contains(this.c4));
        assertFalse(competitorsPhaseFinal.contains(this.c2));
        assertFalse(competitorsPhaseFinal.contains(this.c5));
        assertFalse(competitorsPhaseFinal.contains(this.c7));
    }


    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(sport_competition.SelectionGlobaleTest.class);
    }

}

