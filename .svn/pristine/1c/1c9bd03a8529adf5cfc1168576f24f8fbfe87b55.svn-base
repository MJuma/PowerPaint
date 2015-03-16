/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import powerpaint.tools.Ellipse;
import powerpaint.tools.Line;
import powerpaint.tools.Pencil;
import powerpaint.tools.Rectangle;
import powerpaint.tools.Tools;


/**
 * Creates the frame for the PowerPaint program.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
@SuppressWarnings("serial")
public class PowerPaintFrame extends JFrame
{
  /**
   * The width of the panel.
   */
  public static final int WIDTH = 400;

  /**
   * The height of the panel.
   */
  public static final int HEIGHT = 300;

  /**
   * The tool bar.
   */
  private final JToolBar my_tool_bar;

  /**
   * The drawing panel.
   */
  private final DrawingPanel my_drawing_panel;

  /**
   * List of drawing actions.
   */
  private List<DrawAction> my_drawing_actions;

  /**
   * Color action responsible for choosing the drawing color.
   */
  private Action my_color_action;
  
  /**
   * The color button on the tool bar.
   */
  private JToggleButton my_color_button;
  
  /**
   * The menu bar.
   */
  private final PowerPaintMenu my_menu;

  /**
   * The set of tools used in this drawing program.
   */
  private final Tools[] my_tools = new Tools[] {new Pencil(), new Line(),
    new Rectangle(), new Ellipse()};

  /**
   * PowerPaintFrame constructor, creates the initial frame for the program.
   */
  public PowerPaintFrame()
  {
    super("PowerPaint");
    my_drawing_panel = new DrawingPanel();
    my_drawing_panel.setTool(my_tools[0]);
    initializeActions();
    my_menu = new PowerPaintMenu(my_drawing_panel, my_color_action, my_drawing_actions, this);
    my_tool_bar = createToolBar();
  }

  /**
   * Starts the GUI.
   */
  public void start()
  {    
    setSize(WIDTH, HEIGHT);
    setBackground(Color.WHITE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setJMenuBar(my_menu.getMenuBar());
    add(my_drawing_panel, BorderLayout.CENTER);
    add(my_tool_bar, BorderLayout.SOUTH);
    pack();
    setVisible(true);
  }

  /**
   * Initializes all the actions for the tools and menu items.
   */
  private void initializeActions()
  { 
    my_color_action = new AbstractAction("Color...")
    {  
      public void actionPerformed(final ActionEvent the_event)
      {  
        final Color color = JColorChooser.showDialog(my_drawing_panel.getParent(),
                                               "Select the pen color",
                                               my_drawing_panel.getSelectedColor());
        my_drawing_panel.setSelectedColor(color);
        my_color_button.setBackground(my_drawing_panel.getSelectedColor());
        my_color_button.setSelected(false);
      }
    };
    my_color_action.putValue(Action.SHORT_DESCRIPTION, "Change the pen color.");
    my_color_action.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);

    my_drawing_actions = new ArrayList<DrawAction>();
    for (int i = 0; i < my_tools.length; i++)
    {
      final int period = my_tools[i].getClass().getName().lastIndexOf('.') + 1;
      final String name = my_tools[i].getClass().getName().substring(period);

      my_drawing_actions.add(new DrawAction(my_tools[i], name));
      my_drawing_actions.get(i).putValue(Action.MNEMONIC_KEY, 
                   Integer.valueOf(my_drawing_actions.get(i).name().charAt(0)));
    }
  }

  /**
   * Creates a tool bar for the frame.
   * 
   * @return tool_bar
   */
  private JToolBar createToolBar()
  {
    final JToolBar tool_bar = new JToolBar();

    my_color_button = new JToggleButton(my_color_action);
    my_color_button.setBackground(my_drawing_panel.getSelectedColor());
    tool_bar.add(my_color_button);

    my_drawing_actions.get(0).setEnabled(true);
    for (DrawAction draw : my_drawing_actions)
    {
      final JToggleButton toggle_button = new JToggleButton(draw);
      if (draw.isEnabled())
      {
        toggle_button.setSelected(true);
      }
      tool_bar.add(toggle_button);
    }
    return tool_bar;
  }

  /**
   * Creates the Listener for the Action.
   * 
   * @author Mohammad Juma
   * @version 10-30-2012
   */
  public class DrawAction extends AbstractAction
  {
    /**
     * The selected tool.
     */
    private final Tools my_tool;

    /**
     * The name of the selected tool.
     */
    private final String my_name;

    /**
     * Constructs a new tool.
     * 
     * @param the_tool The chosen tool.
     * @param the_name The name of the tool.
     */
    public DrawAction(final Tools the_tool, final String the_name)
    {
      super(the_name, new ImageIcon("images/" + the_name + "_bw.gif"));
      my_name = the_name;
      putValue(Action.SHORT_DESCRIPTION, "Select the " + the_name + " tool");
      putValue(Action.SELECTED_KEY, false);
      my_tool = the_tool;
    }
    
    /**
     * Returns the name of the tool.
     * @return my_name The tools name.
     */
    public String name()
    {
      return my_name;
    }

    /**
     * Activates the tool.
     * @param the_event The event
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      my_drawing_panel.setTool(my_tool);
    }
  }
}
