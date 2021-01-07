package cs3500.animator.provider.view;

import cs3500.animator.provider.shapes.IReadOnlyShape;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * A panel that draws view shapes onto the screen.
 */
public final class DrawingPanel extends JPanel {

  private final List<IReadOnlyShape> shapesToDraw;
  private int x; // the x-coordinate of the top-left corner of the drawing panel
  private int y; // the y-coordinate of the top-left corner of the drawing panel

  /**
   * Constructs a new drawing panel. By default, the coordinate of the top-left corner of the
   * drawing panel is {@code (0,0)}.
   */
  public DrawingPanel() {
    super();
    this.shapesToDraw = new ArrayList<>();
    this.x = 0;
    this.y = 0;
  }

  /**
   * Sets the coordinates of the top-left corner of this drawing panel.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   */
  public void setXY(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Adds the given view shape to this drawing panel's list of shapes to draw in the next frame.
   *
   * @param shape the view shape
   */
  public void drawShape(IReadOnlyShape shape) {
    this.shapesToDraw.add(shape);
  }

  /**
   * Renders every shape in the drawing panel, then clears the list of shapes to draw so that a new
   * frame can be drawn.
   *
   * @param g the graphics context
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.translate(-this.x, -this.y);

    for (IReadOnlyShape shape : this.shapesToDraw) {
      shape.render(g);
    }

    this.shapesToDraw.clear();
  }
}
