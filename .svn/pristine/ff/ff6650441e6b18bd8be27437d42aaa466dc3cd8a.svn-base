/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.tools;

import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * Pencil class drawing with a Pencil tool.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
public class Pencil extends AbstractShape
{ 
  /**
   * Creates a new pencil line.
   * @return path The new pencil line.
   */
  public Shape newShape()
  {
    return new Path2D.Double();
  }
  
  /**
   * Creates a new dragged pencil line.
   * @return path The dragged pencil line.
   */
  public Shape draggedShape()
  {
    final Path2D path = (Path2D) getShape();
    path.moveTo(getStart().x, getStart().y);
    path.lineTo(getStop().x, getStop().y);
    setStart(getStop());
    return path;
  }
}
