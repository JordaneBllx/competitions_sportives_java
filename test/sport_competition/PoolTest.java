package sport_competition;

import java.util.*;
import sport_competition.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PoolTest {

    private Pool thePoolEven;
	private Pool thePoolNotEven;

	@Before
	public void before() {
		Competitor c1 = new Competitor("J1");
		Competitor c2 = new Competitor("J2");
		Competitor c3 = new Competitor("J3");
		Competitor c11 = new Competitor("J11");
		Competitor c12 = new Competitor("J12");
		Competitor c13 = new Competitor("J13");
		Competitor c14 = new Competitor("J14");

		ArrayList<Competitor> competitorsNotEven = new ArrayList<Competitor>();
		competitorsNotEven.add(c1);
		competitorsNotEven.add(c2);
		competitorsNotEven.add(c3);
		ArrayList<Competitor> competitorsEven = new ArrayList<Competitor>();
		competitorsEven.add(c11);
		competitorsEven.add(c12);
		competitorsEven.add(c13);
		competitorsEven.add(c14);

		this.thePoolNotEven = new Pool(new ClassicalMatch(), competitorsNotEven, new SelectionGlobal());
		this.thePoolEven = new Pool(new ClassicalMatch(), competitorsEven, new SelectionGlobal());
	}


	@Test
	public void testCreation() {
        assertNotNull(this.thePoolEven);
		assertNotNull(this.thePoolNotEven);
	}

	@Test
	public void testGetFactors() {
		ArrayList<Integer> trueFactors = new ArrayList<Integer>();
		trueFactors.add(1);
		trueFactors.add(5);
		trueFactors.add(25);
		ArrayList<Integer> factorsToCheck = this.thePoolEven.getFactors(25);
		Iterator<Integer> iter1 = trueFactors.iterator(); 
		Iterator<Integer> iter2 = factorsToCheck.iterator();
		while (iter1.hasNext() && iter2.hasNext()) { 
            assertEquals(iter1.next(), iter2.next());
        } 
	}

	@Test(expected=LackOfCompetitors.class)
	public void testPoolMakerNotEven() throws LackOfCompetitors{
		this.thePoolNotEven.PoolMaker();
	}


	@Test
 	public void testPoolMakerEven() {
		try {
			this.thePoolEven.PoolMaker();
			assertNotNull(this.thePoolEven.getLeagues());
		}
		catch (LackOfCompetitors e) {
			fail();
		}
  	}


    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(sport_competition.PoolTest.class);
    }

}
