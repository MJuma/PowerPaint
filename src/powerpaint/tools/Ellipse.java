/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.tools;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Ellipse class for drawing ellipses.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
public class Ellipse extends AbstractShape
{
  /**
   * An ellipse shape.
   */
  private Ellipse2D my_ellipse = new Ellipse2D.Double();
  
  /**
   * Creates a new ellipse.
   * @return my_ellipse The new ellipse.
   */
  public Shape newShape()
  {
    my_ellipse = new Ellipse2D.Double(getStart().x, getStart().y, 0, 0);
    return my_ellipse;
  }
  
  /**
   * Creates a new dragged ellipse.
   * @return my_ellipse The dragged ellipse.
   */
  public Shape draggedShape()
  {
    final double min_x = Math.min(getStart().x, getStop().x);
    final double max_x = Math.max(getStart().x, getStop().x);
    final double min_y = Math.min(getStart().y, getStop().y);
    final double max_y = Math.max(getStart().y, getStop().y);
    my_ellipse = new Ellipse2D.Double(min_x, min_y, max_x - min_x, max_y - min_y);
    return my_ellipse;
  }
}
