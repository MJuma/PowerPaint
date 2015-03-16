/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.tools;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Rectangle class for drawing rectangles.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
public class Rectangle extends AbstractShape
{ 
  /**
   * A rectangle shape.
   */
  private Rectangle2D my_rectangle = new Rectangle2D.Double();
  
  /**
   * Creates a new rectangle.
   * @return my_ellipse The new rectangle.
   */
  public Shape newShape()
  {
    my_rectangle = new Rectangle2D.Double(getStart().x, getStart().y, 0, 0);
    return my_rectangle;
  }
  
  /**
   * Creates a new dragged rectangle.
   * @return my_ellipse The dragged rectangle.
   */
  public Shape draggedShape()
  {
    final double min_x = Math.min(getStart().x, getStop().x);
    final double max_x = Math.max(getStart().x, getStop().x);
    final double min_y = Math.min(getStart().y, getStop().y);
    final double max_y = Math.max(getStart().y, getStop().y);
    my_rectangle = new Rectangle2D.Double(min_x, min_y, max_x - min_x, max_y - min_y);
    return my_rectangle;
  }
}
