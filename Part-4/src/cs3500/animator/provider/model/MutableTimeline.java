package cs3500.animator.provider.model;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.provider.shapes.IReadOnlyShape;
import cs3500.animator.provider.shapes.ShapeFactory;
import cs3500.animator.provider.shapes.ShapeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation for a mutable timeline represents the state of a shape at key ticks in the
 * animation, mutable since it allows motions to be added for a shape.
 */
public class MutableTimeline implements IMutableTimeline {

  protected HashMap<Integer, IReadOnlyShape> timeline;
  protected ShapeType type;
  private final String name;
  private final AnimatorModel delegate;

  /**
   * Constructs a MutableTimeline with a shape type and shape name.
   * @param type shape type
   * @param name shape name
   */
  public MutableTimeline(ShapeType type, String name) {
    if (type == null) {
      throw new IllegalArgumentException("ShapeType cannot be null");
    }
    timeline = new HashMap<>();
    this.type = type;
    this.name = name;
    this.delegate = new EasyAnimatorModel();
    delegate.addShape(name, type.toString().toLowerCase());
  }

  @Override
  public void addMotion(int tick1, int x1, int y1, int width1, int height1, int red1, int green1,
                        int blue1, int tick2, int x2, int y2, int width2, int height2, int red2,
                        int green2, int blue2) throws IllegalArgumentException {

    // throws an exception if the motion being added is invalid, compares this motion to those
    // already added
    delegate.addMotion(name, tick1, x1, y1, width1, height1, red1, green1, blue1, tick2, x2, y2,
            width2, height2, red2, green2, blue2);

    if (! timeline.containsKey(tick1)) {
      IReadOnlyShape result1;
      result1 = ShapeFactory.shape(type, x1, y1, width1, height1, red1,
              green1, blue1);
      timeline.put(tick1, result1);
    }

    if (! timeline.containsKey(tick2)) {
      IReadOnlyShape result2;
      result2 = ShapeFactory.shape(type, x2, y2, width2, height2, red2,
              green2, blue2);
      timeline.put(tick2, result2);
    }

  }

  @Override
  public List<Integer> getKeyTicks() {
    return new ArrayList<>(timeline.keySet());
  }

  @Override
  public IReadOnlyShape getShapeAtKeyTick(int tick) throws IllegalArgumentException {

    if (timeline.containsKey(tick)) {
      return timeline.get(tick);
    }
    else {
      throw new IllegalArgumentException("No shape at given tick");
    }
  }

  @Override
  public String getShapeName() {
    return name;
  }

  @Override
  public ShapeType getShapeType() {
    return type;
  }

}

