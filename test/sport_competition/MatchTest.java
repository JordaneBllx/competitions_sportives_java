package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public abstract class MatchTest {

  protected Match myMatch;

  protected abstract Match createMatch();

  @Before
  public void init () {
    this.myMatch = this.createMatch();
  }

  @Test
  public void testResultOfOneMatch() {
    MockMatch match = new MockMatch();
    Competitor winner = new Competitor("C1");
    Competitor looser = new Competitor("C2");
    assertSame(winner, match.resultOfOneMatch(winner,looser));
	}


  public class MockMatch extends Match {

    public Competitor resultOfOneMatch(Competitor winner, Competitor looser) {
      return winner;
    }
  }

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(sport_competition.MatchTest.class);
  }

}
