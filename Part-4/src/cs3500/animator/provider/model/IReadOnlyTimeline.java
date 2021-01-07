package cs3500.animator.provider.model;

import cs3500.animator.provider.shapes.IReadOnlyShape;
import cs3500.animator.provider.shapes.ShapeType;

import java.util.List;

/**
 * A timeline represents the state of a single shape across time. This timeline can only be
 * observed. The observations that can be made include: getting the key ticks (where states of the
 * shape are explicitly defined), getting the state of the shape at said key ticks, getting the name
 * of the shape, and getting the type of the shape.
 */
public interface IReadOnlyTimeline {

  /**
   * Gets a list of the key ticks on this timeline.
   *
   * @return the key ticks
   */
  List<Integer> getKeyTicks();

  /**
   * Gets a readonly look at the shape on this timeline at the given key tick.
   *
   * @param tick the tick to observe the shape at
   * @return the state of the shape at the key tick
   * @throws IllegalArgumentException if the tick is not a key tick on this timeline
   */
  IReadOnlyShape getShapeAtKeyTick(int tick) throws IllegalArgumentException;

  /**
   * Gets the name of the shape on this timeline.
   *
   * @return the name
   */
  String getShapeName();

  /**
   * Gets the type of the shape on this timeline.
   *
   * @return the type
   */
  ShapeType getShapeType();
}
