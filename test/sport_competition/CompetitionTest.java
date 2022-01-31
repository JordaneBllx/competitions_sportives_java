package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public abstract class CompetitionTest {

  protected Competition myCompetition;

  protected abstract Competition createCompetition();

  @Before
  public void init () {
    this.myCompetition = this.createCompetition();
  }

  @Test
  public void testScheduleMatch() {
    Competitor c1 = new Competitor("C1");
    Competitor c2 = new Competitor("C2");
    Competitor winner =  this.myCompetition.scheduleMatch(c1,c2);
    if (c1.getNbPoints()>c2.getNbPoints()) {
      assertSame(winner,c1);
    }
    else {
      assertSame(winner,c2);
    }
	}

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(sport_competition.CompetitionTest.class);
  }

}
