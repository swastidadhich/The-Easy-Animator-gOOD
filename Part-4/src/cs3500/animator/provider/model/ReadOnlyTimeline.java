package cs3500.animator.provider.model;

import cs3500.animator.provider.shapes.IReadOnlyShape;
import cs3500.animator.provider.shapes.ShapeType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Implementation for a read only timeline which represents the state of a shape at key ticks in the
 * animation, read only because it can only be observed.
 */
public class ReadOnlyTimeline implements IReadOnlyTimeline {

  protected LinkedHashMap<Integer, IReadOnlyShape> timeline;
  protected ShapeType type;
  private final String name;

  /**
   * Constructs a ReadOnlyTimeline with a shape type and shape name.
   * @param type shape type
   * @param name shape name
   */
  public ReadOnlyTimeline(ShapeType type, String name) {
    timeline = new LinkedHashMap<>();
    this.type = type;
    this.name = name;
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
