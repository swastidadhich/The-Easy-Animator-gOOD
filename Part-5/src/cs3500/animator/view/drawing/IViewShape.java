package cs3500.animator.view.drawing;

import java.awt.Graphics;

/**
 * An interface for a shape in the view.
 */
public interface IViewShape {

  /**
   * Draw the given graphic.
   * @param g the graphic
   */
  void draw(Graphics g);

  /**
   * Draw the given graphic in outlibe.
   * @param g the graphic
   */
  void drawOutline(Graphics g);

}
