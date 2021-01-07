package cs3500.animator.model;

import cs3500.animator.util.AnimationBuilder;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * This is the model for EasyAnimator this maintains the state and enforces it.
 */
public class EasyAnimatorModel implements AnimatorModel {

  // a linked hashmap maintains the order of added elements
  private final LinkedHashMap<Shape2D, List<Motion2D>> directions;
  private ICanvas canvas;

  /**
   * A constructor for easy animator model.
   */
  public EasyAnimatorModel() {
    this.directions = new LinkedHashMap<>();
    this.canvas = new Canvas();
  }

  /**
   * Static class which builds an EasyAnimatorModel by initializing shapes, motions, and a canvas.
   */
  public static final class Builder implements AnimationBuilder<AnimatorModel> {

    AnimatorModel model;

    /**
     * Constructs a Builder with an empty EasyAnimatorModel.
     */
    public Builder() {
      this.model = new EasyAnimatorModel();
    }

    @Override
    public AnimatorModel build() {
      return model;
    }

    @Override
    public AnimationBuilder<AnimatorModel> setBounds(int x, int y, int width, int height) {
      model.initCanvas(x, y, width, height);
      return this;
    }

    @Override
    public AnimationBuilder<AnimatorModel> declareShape(String name, String type) {
      model.addShape(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<AnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
                                                   int h1, int r1, int g1, int b1, int t2, int x2,
                                                   int y2, int w2, int h2, int r2, int g2, int b2) {

      model.addMotion(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
      return this;
    }
  }

  @Override
  public void addShape(String name, String type) throws IllegalArgumentException {

    if (name == null || type == null) {
      throw new IllegalArgumentException("Name and type cannot be null");
    }

    // find if the name has already been added
    for (Shape2D s : directions.keySet()) {
      if (s.getName().equals(name)) {
        throw new IllegalArgumentException("Shape name already added");
      }
    }

    directions.put(new Shape2D(name, type), new ArrayList<Motion2D>());
  }

  @Override
  public void addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                        int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2)
                        throws IllegalArgumentException {

    // throws exception if tick is negative
    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Tick cannot be negative");
    }

    // throws exception if ending tick is less than tick1
    if (t2 < t1) {
      throw new IllegalArgumentException("Final tick cannot be smaller than initial tick");
    }

    // throws exception if shape name does not exist
    Shape2D key = this.getShapeWithName(name);

    // throws exception if the shape does not exist
    List<Motion2D> lom = getMotionsFromShape(key);

    // throws exception if name is null, if arguments are negative, if rgb is invalid
    Motion2D m = new Motion2D(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);

    // throws exception if this motion overlaps with any already added motions for the shape
    for (Motion2D m2 : lom) {
      if (m.overlapWith(m2)) {
        throw new IllegalArgumentException("invalid motion");
      }
    }

    lom.add(m);
    directions.put(key, lom);
  }

  @Override
  public List<IShape2D> getShapes() {
    return new ArrayList<>(directions.keySet());
  }

  @Override
  public List<Motion2D> getMotionsFromShape(Shape2D shape) throws IllegalArgumentException {
    List<Motion2D> result = directions.get(shape); // .get will return null if shape does not exist

    if (result == null || shape == null) {
      throw new IllegalArgumentException("Invalid shape");
    }
    return new ArrayList<>(result);
  }

  /**
   * Gets the shape with the given name from this model's directions.
   * @param name the name of the shape
   * @return the shape from the model's directions
   * @throws IllegalArgumentException if no shape with the given name has been added
   */
  private Shape2D getShapeWithName(String name) throws IllegalArgumentException {
    for (Shape2D s : directions.keySet()) {
      if (s.getName().equals(name)) {
        return s;
      }
    }
    throw new IllegalArgumentException("No shape exists with given name");
  }

  @Override
  public void initCanvas(int x, int y, int width, int height) throws IllegalArgumentException {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and/or height cannot be negative");
    }
    canvas = new Canvas(x, y, width,height);
  }

  @Override
  public Canvas getCanvas() {
    return new Canvas(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
  }

  @Override
  public LinkedHashMap<Shape2D, List<Motion2D>> getDirections() {
    return new LinkedHashMap<>(directions);
  }

  @Override
  public int getLastTick() {
    int lastTick = 0;

    for (Shape2D shape : directions.keySet()) {
      for (Motion2D m : directions.get(shape)) {
        if (m.getTick2() > lastTick) {
          lastTick = m.getTick2();
        }
      }
    }

    return lastTick;
  }

  @Override
  public int getFirstTick() {

    int firstTick = -1;

    for (Shape2D shape : directions.keySet()) {
      for (Motion2D m : directions.get(shape)) {
        if (firstTick == -1) {
          firstTick = m.getTick1();
        }
        else if (m.getTick1() < firstTick) {
          firstTick = m.getTick2();
        }
      }
    }

    if (firstTick < 0) {
      throw new IllegalArgumentException("Cannot have negative first tick");
    }

    return firstTick;
  }

}