package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LeagueCompetitionTest extends CompetitionTest {

  protected Competition createCompetition() {
    Competitor c1 = new Competitor("J1");
    Competitor c2 = new Competitor("J2");
    Competitor c3 = new Competitor("J3");
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(c1);
    competitors.add(c2);
    competitors.add(c3);
		Match theMatch = new ClassicalMatch();
    League theLeague = new League(theMatch,competitors);
    return theLeague;
  }

  @Test
	public void testCreation() {
    assertNotNull(myCompetition);
	}

	@Test 
	public void testPlay() {
		myCompetition.play(myCompetition.getCompetitors());
    int sum = 0;
    int nbCompetitors = myCompetition.getNbCompetitors();
		Iterator<Competitor> iter = myCompetition.getCompetitors().iterator();
        while (iter.hasNext())
        {
			sum += iter.next().getNbPoints();
		}
		assertEquals(nbCompetitors*2,sum);
	}
  

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(sport_competition.LeagueCompetitionTest.class);
  }


}
