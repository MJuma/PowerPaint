/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import powerpaint.tools.AbstractShape;
import powerpaint.tools.Tools;

/**
 * Creates the drawing window for PowerPaint.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel
{
  /**
   * The width of the panel.
   */
  private static final int WIDTH = 400;

  /**
   * The height of the panel.
   */
  private static final int HEIGHT = 300;
  
  /**
   * The distance in pixels between grid lines.
   */
  private static final int GRID_DISTANCE = 10;

  /**
   * The listener responsible for all mouse events.
   */
  private final ClickListener my_listener = new ClickListener();
  
  /**
   * The current tool.
   */
  private Tools my_tool;
  
  /**
   * The current color.
   */
  private Color my_color = Color.BLACK;
  
  /**
   * The previously drawn shapes.
   */
  private final List<Shape> my_shapes = new ArrayList<Shape>();
  
  /**
   * The colors of the previously drawn shapes.
   */
  private final List<Color> my_shapes_color = new ArrayList<Color>();
  
  /**
   * The thickness's of the previously drawn shapes.
   */
  private final List<Integer> my_shapes_thickness = new ArrayList<Integer>();
  
  /**
   * The previously drawn shapes.
   */
  private final List<Shape> my_redos = new ArrayList<Shape>();
  
  /**
   * The colors of the previously drawn shapes.
   */
  private final List<Color> my_redos_color = new ArrayList<Color>();
  
  /**
   * The thickness's of the previously drawn shapes.
   */
  private final List<Integer> my_redos_thickness = new ArrayList<Integer>();
  
  /**
   * Toggles the grid on and off.
   */
  private boolean my_grid;
  
  /**
   * The thickness of the drawing tool.
   */
  private int my_thickness = 2;

  /**
   * Constructs a new ellipse panel.
   */
  public DrawingPanel()
  {
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setSize(WIDTH, HEIGHT);
    setBackground(Color.WHITE);
    addMouseListener(my_listener);
    addMouseMotionListener(my_listener);
  }

  /**
   * Paints the drawn paths.
   * 
   * @param the_graphics The graphics context to use for painting.
   */
  public void paintComponent(final Graphics the_graphics)
  {
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                         RenderingHints.VALUE_ANTIALIAS_ON);
    
    if (!my_shapes.isEmpty())
    {
      for (int i = 0; i < my_shapes.size(); i++)
      {
        g2d.setColor(my_shapes_color.get(i));
        g2d.setStroke(new BasicStroke(my_shapes_thickness.get(i)));
        g2d.draw(my_shapes.get(i));
      }
    }
    
    if (((AbstractShape) my_tool).getStart() != null &&
        ((AbstractShape) my_tool).getStop() != null)
    {
      g2d.setColor(getSelectedColor());
      g2d.setStroke(new BasicStroke(my_thickness));
      g2d.draw(((AbstractShape) my_tool).getShape());
    }
    
    if (my_grid)
    {
      g2d.setColor(Color.BLACK);
      g2d.setStroke(new BasicStroke(1));
      for (int i = 0; i < getWidth() / GRID_DISTANCE; i++)
      {
        g2d.drawLine(i * GRID_DISTANCE, 0, i * GRID_DISTANCE, getHeight());
      }
      for (int i = 0; i < getHeight() / GRID_DISTANCE; i++)
      {
        g2d.drawLine(0, i * GRID_DISTANCE, getWidth(), i * GRID_DISTANCE);
      }
    }
  }
  
  /**
   * Sets the tool the drawing panel will use.
   * @param the_tool The desired tool.
   */
  public void setTool(final Tools the_tool)
  {
    my_tool = the_tool;
  }
  
  /**
   * Clears the board of all drawings.
   */
  public void clearBoard()
  {
    for (int i = my_shapes.size() - 1; i >= 0; i--)
    {
      my_shapes.remove(i);
    }
    for (int i = my_redos.size() - 1; i >= 0; i--)
    {
      my_redos.remove(i);
      my_redos_color.remove(i);
      my_redos_thickness.remove(i);
    }
    ((AbstractShape) my_tool).setStart(null);
    repaint();
  }
  
  /**
   * Undoes the last drawn shape.
   */
  public void undo()
  {
    if (!my_shapes.isEmpty())
    {
      final int last_drawn = my_shapes.size() - 1;
      my_redos.add(my_shapes.get(last_drawn));
      my_redos_color.add(my_shapes_color.get(last_drawn));
      my_redos_thickness.add(my_shapes_thickness.get(last_drawn));
      my_shapes.remove(last_drawn);
      my_shapes_color.remove(last_drawn);
      my_shapes_thickness.remove(last_drawn);
      ((AbstractShape) my_tool).setStart(null);
      repaint();
    }
  }
  
  /**
   * Redraws the last drawn shape.
   */
  public void redo()
  {
    if (!my_redos.isEmpty())
    {
      final int last_removed = my_redos.size() - 1;
      my_shapes.add(my_redos.get(last_removed));
      my_shapes_color.add(my_redos_color.get(last_removed));
      my_shapes_thickness.add(my_redos_thickness.get(last_removed));
      my_redos.remove(last_removed);
      my_redos_color.remove(last_removed);
      my_redos_thickness.remove(last_removed);
      repaint();
    }
  }
  
  /**
   * Returns the currently selected color.
   * @return my_color The selected color.
   */
  public Color getSelectedColor()
  {
    return my_color;
  }
  
  /**
   * Sets the desired color.
   * @param the_color The desired color.
   */
  public void setSelectedColor(final Color the_color)
  {
    my_color = the_color;
  }
  
  /**
   * Enables and disables the grid on the drawing panel.
   */
  public void toggleGrid()
  {
    my_grid ^= true;
    repaint();
  }
  
  /**
   * Sets the thickness of the drawing tool.
   * @param the_thickness The drawing tools thickness.
   */
  public void setThickness(final int the_thickness)
  {
    my_thickness = the_thickness;
  }

  /**
   * A mouse adapter that listens for clicks and draw the shapes.
   * 
   * @author Mohammad Juma
   * @version 10-30-2012
   */
  private class ClickListener extends MouseAdapter
  {
    /**
     * Event that occurs when the mouse is pressed.
     * @param the_event Event generated.
     */
    public void mousePressed(final MouseEvent the_event)
    {
      ((AbstractShape) my_tool).pressed(the_event.getPoint());
    }

    /**
     * Event that occurs when the mouse is released.
     * @param the_event Event generated.
     */
    public void mouseReleased(final MouseEvent the_event)
    {
      my_shapes.add(((AbstractShape) my_tool).released());
      my_shapes_color.add(getSelectedColor());
      my_shapes_thickness.add(my_thickness);
      repaint();
    }

    /**
     * Event that occurs when the mouse is dragged.
     * @param the_event Event generated.
     */
    public void mouseDragged(final MouseEvent the_event)
    {
      ((AbstractShape) my_tool).dragged(the_event.getPoint());
      repaint();
    }
  }
}
