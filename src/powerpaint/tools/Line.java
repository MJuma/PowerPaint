/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.tools;

import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * Line class for drawing lines.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
public class Line extends AbstractShape
{
  /**
   * A line shape.
   */
  private Line2D my_line = new Line2D.Double();
  
  /**
   * Creates a new line.
   * @return my_line The new line.
   */
  public Shape newShape()
  {
    my_line = new Line2D.Double(getStart().x, getStart().y, 0, 0);
    return my_line;
  }
  
  /**
   * Creates a new dragged line.
   * @return my_line The dragged line.
   */
  public Shape draggedShape()
  {
    my_line = new Line2D.Double(getStart().x, getStart().y,
                                getStop().x, getStop().y);
    return my_line;
  }
}
