package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ClassicalMatchTest extends MatchTest {

  protected Match createMatch() {
    return new ClassicalMatch();
  }

  @Test
	public void testCreation() {
    assertNotNull(myMatch);
	}

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(sport_competition.ClassicalMatchTest.class);
  }


}
