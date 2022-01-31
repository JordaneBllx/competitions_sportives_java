package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TournamentCompetitionTest extends CompetitionTest {

  protected Competition createCompetition() {
    Competitor c1 = new Competitor("J1");
    Competitor c2 = new Competitor("J2");
    Competitor c3 = new Competitor("J3");
    Competitor c4 = new Competitor("J4");
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(c1);
    competitors.add(c2);
    competitors.add(c3);
    competitors.add(c4);
		Match theMatch = new ClassicalMatch();
    Tournament theTournament = new Tournament(theMatch,competitors);
    return theTournament;
  }

  private Tournament tournament;
  private Tournament tournamentNotPowerOfTwo;

  @Before
  public void initTournament () {
    this.tournament = new Tournament(new ClassicalMatch(),new ArrayList<Competitor>());
    
    Competitor c1 = new Competitor("J1");
    Competitor c2 = new Competitor("J2");
    Competitor c3 = new Competitor("J3");
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(c1);
    competitors.add(c2);
    competitors.add(c3);
		Match theMatch = new ClassicalMatch();
    this.tournamentNotPowerOfTwo = new Tournament(theMatch,competitors);
  }

  @Test
	public void testCreation() {
    assertNotNull(myCompetition);
	}

	@Test 
	public void testPlayWhenCompetitorsNumberIsPowerOfTwo() {
		myCompetition.play(myCompetition.getCompetitors());
    int sum = 0;
    int nbCompetitors = myCompetition.getNbCompetitors();
		Iterator<Competitor> iter = myCompetition.getCompetitors().iterator();
    while (iter.hasNext())
    {
      sum += iter.next().getNbPoints();
    }
		assertEquals(nbCompetitors-1,sum);
  }
  
  @Test
  public void testCopyCompetitors () {
    ArrayList<Competitor> copy = this.tournamentNotPowerOfTwo.copyCompetitors(this.tournamentNotPowerOfTwo.getCompetitors());
    int size = copy.size();
    assertEquals(copy.size(),this.tournamentNotPowerOfTwo.getNbCompetitors());
    for (int i=0; i<size; i++) {
      assertSame(this.tournamentNotPowerOfTwo.getCompetitors().get(i),copy.get(i));
    }
  }

  @Test
	public void testPlayWhenCompetitorsNumberIsNotPowerOfTwo(){
		this.tournamentNotPowerOfTwo.play();
    int sum = 0;
    int nbCompetitors = this.tournamentNotPowerOfTwo.getNbCompetitors();
		Iterator<Competitor> iter = this.tournamentNotPowerOfTwo.getCompetitors().iterator();
      while (iter.hasNext())
      {
			  sum += iter.next().getNbPoints();
		  }
		assertEquals(0,sum);
	}
  
  @Test
  public void testPowerOfTwoWhereIsTwo() {
    try {
      assertTrue(this.tournament.powerOfTwo(2));
    }
    catch (NbCompetitorsNotCorrectForTournament e) {
      fail();
    }
  }

  @Test
  public void testPowerOfTwoWhereIsAPowerOfTwo() {
    try {
      assertTrue(this.tournament.powerOfTwo(4));
      assertTrue(this.tournament.powerOfTwo(8));
      assertTrue(this.tournament.powerOfTwo(16));
      assertTrue(this.tournament.powerOfTwo(32));
    }
    catch (NbCompetitorsNotCorrectForTournament e) {
      fail();
    }
  }

  @Test(expected=NbCompetitorsNotCorrectForTournament.class)
  public void testPowerOfTwoWhereIsNOTAPowerOfTwo() throws NbCompetitorsNotCorrectForTournament{
    this.tournament.powerOfTwo(6);
  }

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(sport_competition.TournamentCompetitionTest.class);
  }


}
