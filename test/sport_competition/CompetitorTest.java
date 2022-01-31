package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompetitorTest {

    private Competitor c1;

	@Before
	public void before() {
		this.c1 = new Competitor("Midas");
	}


	@Test
	public void testCreation() {
        assertNotNull(this.c1);
	}

	@Test
	public void testHadPoint() {
        assertEquals(0,this.c1.getNbPoints());
        this.c1.addPoint();
        assertEquals(1,this.c1.getNbPoints());
	}


    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(sport_competition.CompetitorTest.class);
    }

}
