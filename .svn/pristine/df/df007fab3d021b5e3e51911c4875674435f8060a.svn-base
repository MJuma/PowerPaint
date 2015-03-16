/*
 * Mohammad Juma
 * 
 * TCSS 305 - Autumn 2012
 * Assignment 4 - PowerPaint
 * October 30, 2012
 */

package powerpaint.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import powerpaint.gui.PowerPaintFrame.DrawAction;


/**
 * Creates the drawing window for PowerPaint.
 * 
 * @author Mohammad Juma
 * @version 10-30-2012
 */
public class PowerPaintMenu
{
  /**
   * The number of thickness levels to support.
   */
  private static final int THICKNESS_LEVELS = 3;
  
  /**
   * The drawing panel for drawing on.
   */
  private final DrawingPanel my_drawing_panel;
  
  /**
   * The color action for choosing colors.
   */
  private final Action my_color_action;
  
  /**
   * The tools used for drawing.
   */
  private final List<DrawAction> my_drawing_actions;
  
  /**
   * The frame this menu is created for.
   */
  private final PowerPaintFrame my_frame;
  
  /**
   * Creates a new JMenubar for the drawing program.
   * @param the_drawing_panel The drawing panel for drawing on.
   * @param the_color_action The color action for choosing colors.
   * @param the_drawing_actions The tools used for drawing.
   * @param the_frame The frame this menu is created for.
   */
  public PowerPaintMenu(final DrawingPanel the_drawing_panel,
                        final Action the_color_action,
                        final List<DrawAction> the_drawing_actions,
                        final PowerPaintFrame the_frame)
  {
    my_drawing_panel = the_drawing_panel;
    my_color_action = the_color_action;
    my_drawing_actions = the_drawing_actions;
    my_frame = the_frame;
  }
  
  /**
   * Creates and returns a new Menu Bar.
   * @return menu_bar The new Menu Bar.
   */
  public JMenuBar getMenuBar()
  {
    final JMenuBar menu_bar = new JMenuBar();
    
    menu_bar.add(fileMenu());
    menu_bar.add(optionsMenu());
    menu_bar.add(toolsMenu());
    menu_bar.add(helpMenu());
    
    return menu_bar;
  }
  
  /**
   * Creates the file menu.
   * @return file_menu The file menu created.
   */
  private JMenu fileMenu()
  {
    final JMenu file_menu = new JMenu("File");
    file_menu.setMnemonic(KeyEvent.VK_F);
    
    final JMenuItem clear_item = new JMenuItem("Clear");
    clear_item.setToolTipText("Clear the drawing canvas");
    clear_item.setMnemonic(KeyEvent.VK_C);
    clear_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_drawing_panel.clearBoard();
      }
    });
    file_menu.add(clear_item);
    
    file_menu.addSeparator();
    
    final JMenuItem undo_item = new JMenuItem("Undo");
    undo_item.setToolTipText("Undo the last drawn shape");
    undo_item.setMnemonic(KeyEvent.VK_U);
    undo_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_drawing_panel.undo();
      }
    });
    file_menu.add(undo_item);
    
    final JMenuItem redo_item = new JMenuItem("Redo");
    redo_item.setToolTipText("Redraws the last drawn removed shape");
    redo_item.setMnemonic(KeyEvent.VK_R);
    redo_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_drawing_panel.redo();
      }
    });
    file_menu.add(redo_item);
    
    file_menu.addSeparator();
        
    final JMenuItem quit_item = new JMenuItem("Quit");
    quit_item.setToolTipText("Quit PowerPaint");
    quit_item.setMnemonic(KeyEvent.VK_Q);
    quit_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_frame.dispose();
      }
    });
    file_menu.add(quit_item);
    
    return file_menu;
  }
  
  /**
   * Creates the options menu.
   * @return options_menu The options menu created.
   */
  private JMenu optionsMenu()
  {
    final JMenu options_menu = new JMenu("Options");
    options_menu.setMnemonic(KeyEvent.VK_O);
    
    final JCheckBoxMenuItem grid_item = new JCheckBoxMenuItem("Grid");
    grid_item.setToolTipText("Toggle display of a grid on the canvas");
    grid_item.setMnemonic(KeyEvent.VK_G);
    grid_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_drawing_panel.toggleGrid();
      }
    });
    options_menu.add(grid_item);
    
    final JMenu thickness_menu = new JMenu("Thickness");
    thickness_menu.setMnemonic(KeyEvent.VK_T);
    final ButtonGroup thickness_group = new ButtonGroup();
    for (int i = 0; i < THICKNESS_LEVELS; i++)
    {
      final JRadioButtonMenuItem thickness_item = 
          createRadioButton(Integer.toString((int) Math.pow(2, i)));
      thickness_item.setToolTipText("Change the stroke width");
      thickness_menu.add(thickness_item);
      thickness_group.add(thickness_item);
    }
    thickness_menu.getItem(1).setSelected(true);    
    options_menu.add(thickness_menu);
    
    final JMenuItem background_item = new JMenuItem("Change Background");
    background_item.setToolTipText("Change the color of the canvas.");
    background_item.setMnemonic(KeyEvent.VK_B);
    background_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        final Color color = JColorChooser.showDialog(my_drawing_panel.getParent(),
                                                     "Select the background color",
                                                     my_drawing_panel.getBackground());
        my_drawing_panel.setBackground(color);
      }
    });
    options_menu.add(background_item);
    
    return options_menu;
  }
  
  /**
   * Creates the tools menu.
   * @return tools_menu The tools menu created.
   */
  private JMenu toolsMenu()
  {
    final JMenu tools_menu = new JMenu("Tools");
    tools_menu.setMnemonic(KeyEvent.VK_T);
    final ButtonGroup menu_group = new ButtonGroup();
    
    tools_menu.add(my_color_action);
    tools_menu.addSeparator();
    for (DrawAction draw: my_drawing_actions)
    {
      final JRadioButtonMenuItem item = new JRadioButtonMenuItem(draw);
      tools_menu.add(item);
      menu_group.add(item);
    }
    return tools_menu;
  }
  
  /**
   * Creates the help menu.
   * @return help_menu The help menu created.
   */
  private JMenu helpMenu()
  {
    final JMenu help_menu = new JMenu("Help");
    help_menu.setMnemonic(KeyEvent.VK_H);
    
    final JMenuItem about_item = new JMenuItem("About...");
    about_item.setToolTipText("View the about dialog");
    about_item.setMnemonic(KeyEvent.VK_A);
    about_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint, v1.0");
      }
    });
    help_menu.add(about_item);
    
    return help_menu;
  }

  /**
   * Creates a thickness JRadioButtonMenuItem for each thickness.
   * @param the_thickness The width of the thickness.
   * @return thickness_item The created JradioButtonMenuItem
   */
  private JRadioButtonMenuItem createRadioButton(final String the_thickness)
  {
    final JRadioButtonMenuItem thickness_item = new JRadioButtonMenuItem(the_thickness);
    thickness_item.setMnemonic(the_thickness.charAt(0));
    thickness_item.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_drawing_panel.setThickness(Integer.parseInt(the_thickness));
      }
    });
    return thickness_item;
  }
}