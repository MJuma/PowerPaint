/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.tools;

import java.awt.Point;
import java.awt.Shape;

/**
 * Shape class for creating drawing tools.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
public abstract class AbstractShape implements Tools
{  
  /**
   * The shape drawn by the tool.
   */
  private Shape my_shape;
  
  /**
   * Coordinate of the starting point for the shape.
   */
  private Point my_start;
  
  /**
   * Coordinate for the ending point for the shape.
   */
  private Point my_stop; 
  
  /**
   * Starts drawing the shape from this coordinate.
   * @param the_start Coordinates the tool starts drawing from.
   */
  public void pressed(final Point the_start)
  {
    setStart(the_start);
    setShape(newShape());
  }
  
  /**
   * Releases the tool.
   * @return The generated shape.
   */
  public Shape released()
  {
    return getShape();
  }
  
  /**
   * Drags the tool and updates the shape.
   * @param the_stop The current coordinate of the tool.
   */
  public void dragged(final Point the_stop)
  {
    setStop(the_stop);
    setShape(draggedShape());
  }
  
  /**
   * The shape created as the tool is dragged.
   * @return The dragged shape.
   */
  
  /**
   * Returns the generated shape.
   * @return my_shape. The generated shape.
   */
  public Shape getShape()
  {
    return my_shape;
  }
  
  /**
   * Returns the start coordinate.
   * @return my_start. The start coordinate.
   */
  public Point getStart()
  {
    return my_start;
  }
  
  /**
   * Returns the ending coordinate.
   * @return my_stop The ending coordinate.
   */
  public Point getStop()
  {
    return my_stop;
  }
  
  /**
   * Sets the shape from the tool.
   * @param the_shape The new shape.
   */
  public void setShape(final Shape the_shape)
  {
    my_shape = the_shape;
  }
  
  /**
   * Sets the starting coordinate.
   * @param the_start The starting coordinate.
   */
  public void setStart(final Point the_start)
  {
    my_start  = the_start;
  }
  
  /**
   * Sets the ending coordinate.
   * @param the_stop The ending coordinate.
   */
  public void setStop(final Point the_stop)
  {
    my_stop = the_stop;
  }
}
