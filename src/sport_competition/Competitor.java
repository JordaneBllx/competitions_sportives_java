package sport_competition;

import java.util.*;
import sport_competition.*;

/**
 * To describe a Competitor of a Competition
 * @version 1.0
 */
public class Competitor {

  private final String name;
  private int nbPoints;
  private int cote;

  /**
   * Constructor
   */
  public Competitor (String name) {
    this.name = name;
    this.nbPoints = 0;
    this.cote = 0;
  }

  /**
   * Constructor with the number of points to put on a Competitor
   */
  public Competitor (String name, int nbPoints) {
    this.name = name;
    this.nbPoints = nbPoints;
    this.cote = 0;
  }

  /**
   * to put a number of cote to a Competitor
   * @param cote the number to put on the cote of a Competitor
   */
  public void putCote (int cote) {
    this.cote=cote;
  }

  /**
   * add only one point to a Competitor (to this)
   */
  public void addPoint () {
    this.nbPoints += 1;
  }

  /**
   * add only one point to the cote of a Competitor (to this)
   */
  public void addcote () {
    this.cote += 1;
  }

  /**
   * remove only one point to the cote of a Competitor (to this)
   */
  public void removecote () {
    this.cote -= 1;
  }

  /**
   * return the number of points of a Competitor
   * @return the number of points of this
   */
  public int getNbPoints () {
    return this.nbPoints;
  }

  /**
   * return the number of cote of a Competitor
   * @return the number of cote of this
   */
  public int getNbCote () {
    return this.cote;
  }

  /**
   * return the name of a Competitor
   * @return the name of this
   */
  public String getName () {
    return this.name;
  }
  
  /**
   * return a displayable description of a Competitor
   * @return a displayable description of this
   */
  public String toString () {
    return (this.name+" - "+"Points : "+this.nbPoints+" - "+"Cote : "+this.cote);
  }

  /**
   * two Competitors are "equals" if they have the same name and the same number of points
   * @param o a Competitor to compare of another (this)
   * @return true if they are equals, otherwize false
	 */
	public boolean equals(Object o) {
		if (o instanceof Competitor) {
			Competitor other = (Competitor) o;
			return this.name.equals(other.name) && this.nbPoints == other.nbPoints;
		}
		else {
			return false;
		}
	}

}
