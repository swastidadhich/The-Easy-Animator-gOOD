package cs3500.animator.view.drawing;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents a panel on which objects can be drawn on.
 */
public class DrawingPanel extends JPanel {

  List<IViewShape> shapes;

  /**
   * Constructs a DrawingPanel with an empty list of shapes.
   */
  public DrawingPanel() {
    super();
    shapes = new ArrayList<>();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g); // must call super

    for (IViewShape shape : shapes) {
      shape.draw(g); //very extendable
    }

    shapes.clear();
  }

  /**
   * Adds the given shape to this drawing panel's list of shapes.
   *
   * @param shape the shape being added
   * @throws IllegalArgumentException if the given shape is null
   */
  public void drawShape(IViewShape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Input shape cannot be null");
    }
    shapes.add(shape);
  }

}

