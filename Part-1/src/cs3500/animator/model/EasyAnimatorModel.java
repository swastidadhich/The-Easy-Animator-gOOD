package cs3500.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the model for EasyAnimator this maintains the state and enforces it.
 */
public class EasyAnimatorModel implements AnimatorModel {

  // list of directions which is a list of motions
  protected List<Shape2D> los;
  protected List<List<Motion2D>> llom;
  protected int frameHeight;
  protected int frameWidth;
  protected int tick;

  /**
   * A constructor for easy animator model.
   */
  public EasyAnimatorModel() {
    this.los = new ArrayList<>();
    this.llom = new ArrayList<List<Motion2D>>();
    this.frameHeight = 500;
    this.frameWidth = 500;
    this.tick = -1;
  }

  // Initializes the motions, list of shapes, and tick at 1 to start the animation.
  @Override
  public void startAnimation(List<List<Motion2D>> llom) throws IllegalArgumentException {

    if (llom == null) {
      throw new IllegalArgumentException("Motions cannot be null");
    }

    List<List<Motion2D>> llomCopy = new ArrayList<List<Motion2D>>(llom);
    List<Shape2D> losResult = new ArrayList<Shape2D>();
    String current = "";

    for (List<Motion2D> lom : llomCopy) {
      if (lom == null) {
        throw new IllegalArgumentException("Motions cannot be null");
      }
      for (int i = 0; i < lom.size(); i++) {

        // throw exception if a motion is null
        if (lom.get(i) == null) {
          throw new IllegalArgumentException("Motion cannot be null");
        }

        // INVARIANT - no shape size can be larger than the size of the screen
        // size of screen is determined by frameHeight, frameWidth fields
        if (lom.get(i).getShapeI().getWidth() > frameWidth
            || lom.get(i).getShapeI().getHeight() > frameHeight
            || lom.get(i).getShapeF().getWidth() > frameWidth
            || lom.get(i).getShapeF().getHeight() > frameHeight) {
          throw new IllegalArgumentException("Shape too large");
        }

        // throws exception if tick is not positive
        if (lom.get(i).tick1 < 1 || lom.get(i).tick2 < 1) {
          throw new IllegalArgumentException("Tick must be positive");
        }

        // throws exception if ending tick is less than or equal to tick1
        if (lom.get(i).tick2 <= lom.get(i).tick1) {
          throw new IllegalArgumentException("Tick must be positive");
        }

        // check that start motion is same as previous end motion
        if (i < lom.size() - 1 && lom.get(i + 1) != null && (lom.get(i).getShapeF()
            != lom.get(i + 1).getShapeI() || lom.get(i).tick2 != lom.get(i + 1).tick1
            || (! lom.get(i).getName().equals(lom.get(i + 1).getName())))) {
          throw new IllegalArgumentException("Start motion must be same as previous end motion");
        }

        // initialize list of shapes
        if (i == 0 && lom.get(i).tick1 == 1) {
          losResult.add(lom.get(i).shapeI); // field of field?
        } else if (i == 0) {
          losResult.add(null);
        }

      }
    }

    this.llom = llomCopy;
    this.los = losResult;
    this.tick = 1;

  }

  // updates the model's variables to the state at the given tick
  @Override
  public void updateAnimation(int tick) throws IllegalArgumentException, IllegalStateException {

    // throw exception if animation not started
    if (this.tick == -1) {
      throw new IllegalStateException("Animation not started");
    }

    // throw exception if tick not positive
    if (tick < 1) {
      throw new IllegalArgumentException("Tick must be positive");
    }

    // update tick
    this.tick = tick;

    // update shapes
    for (int j = 0; j < llom.size(); j++) {
      List<Motion2D> lom = llom.get(j);

      for (Motion2D m : lom) {

        // update list of shapes
        if (tick >= m.tick1 && tick <= m.tick2) {

          if (los.get(j) == null) {
            los.set(j, m.getShapeI());
          }
          los.get(j).updateShape(m, tick);
        }
      }
    }
  }

  // gets the model's list of shapes
  @Override
  public List<Shape2D> getShapes() throws IllegalStateException {

    // throw exception if animation not started
    if (this.tick == -1) {
      throw new IllegalStateException("Animation not started");
    }

    List<Shape2D> losCopy = new ArrayList<Shape2D>(los);

    return losCopy;
  }

  // gets the model's list of list of motions
  @Override
  public List<List<Motion2D>> getMotions() throws IllegalStateException {

    // throw exception if animation not started
    if (this.tick == -1) {
      throw new IllegalStateException("Animation not started");
    }

    List<List<Motion2D>> llomCopy = new ArrayList<List<Motion2D>>(llom);

    return llomCopy;
  }

  // gets the model's tick
  @Override
  public int getTick() {

    return tick;
  }

}