package cs3500.animator.provider.view;

import cs3500.animator.provider.shapes.IReadOnlyShape;
import cs3500.animator.provider.shapes.ShapeFactory;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Objects;
import java.util.Optional;
import java.util.Iterator;

/**
 * A tweener is responsible for computing the state of a shape at any given tick inside a range of
 * ticks through the use of linear interpolation.
 */
public final class Tweener {

  private final SortedMap<Integer, IReadOnlyShape> keyTicks;

  /**
   * Constructs a new tweener.
   */
  public Tweener() {
    this.keyTicks = new TreeMap<>();
  }

  /**
   * Adds the key tick, and its corresponding shape state, to this tweener.
   *
   * @param tick  the key tick
   * @param shape the state of the shape at the tick
   * @throws NullPointerException if the shape is null
   */
  public void addKeyTick(int tick, IReadOnlyShape shape) throws NullPointerException {
    this.keyTicks.put(tick, Objects.requireNonNull(shape));
  }

  /**
   * Gets the shape from this tweener at the given tick. If the tick happens before any of the key
   * ticks, then an empty shape is returned. If the tick is a key tick, then the corresponding key
   * shape is returned. If the tick is between two key ticks, then an interpolated shape is
   * returned. If the tick happens after all of the key ticks, then the last known shape is
   * returned.
   *
   * @param tick the tick
   * @return the shape at the tick
   */
  public Optional<IReadOnlyShape> getShapeAt(int tick) throws IllegalArgumentException {
    if (this.keyTicks.isEmpty()) {
      // throw new IllegalArgumentException("No shapes in this tweener.");
      return Optional.empty();
      // ^ this is more semantically correct
    }

    if (tick < this.keyTicks.firstKey()) {
      return Optional.empty();
    } else if (tick > this.keyTicks.lastKey()) {
      return Optional.of(this.keyTicks.get(this.keyTicks.lastKey()));
    } else if (this.keyTicks.containsKey(tick)) {
      return Optional.of(this.keyTicks.get(tick));
    } else {
      Iterator<Integer> ticks = this.keyTicks.keySet().iterator();
      int lower = ticks.next();
      int upper = ticks.next();
      while (!(tick > lower && tick < upper)) {
        lower = upper;
        upper = ticks.next();
      }
      return Optional.of(
          tweenShape(lower, tick, upper, this.keyTicks.get(lower), this.keyTicks.get(upper)));
    }
  }

  /**
   * Linearly interpolates across the given range of ticks and shapes.
   *
   * @param tick1  the lower bound of the tick
   * @param tick2  the intermediate value of the tick
   * @param tick3  the upper bound of the tick
   * @param shape1 the lower state of the shape
   * @param shape2 the upper state of the shape
   * @return the intermediate state of the shape
   * @throws IllegalArgumentException if the upper bound and lower bound of the tick are equal
   */
  private static IReadOnlyShape tweenShape(int tick1, int tick2, int tick3,
      IReadOnlyShape shape1, IReadOnlyShape shape2) throws IllegalArgumentException {
    int newX = tween(tick1, tick2, tick3, shape1.getX(), shape2.getX());
    int newY = tween(tick1, tick2, tick3, shape1.getY(), shape2.getY());

    int newWidth = tween(tick1, tick2, tick3, shape1.getWidth(), shape2.getWidth());
    int newHeight = tween(tick1, tick2, tick3, shape1.getHeight(), shape2.getHeight());

    int newRed = tween(tick1, tick2, tick3, shape1.getRed(), shape2.getRed());
    int newGreen = tween(tick1, tick2, tick3, shape1.getGreen(), shape2.getGreen());
    int newBlue = tween(tick1, tick2, tick3, shape1.getBlue(), shape2.getBlue());
    
    return ShapeFactory
        .shape(shape1.getType(), newX, newY, newWidth, newHeight, newRed, newGreen, newBlue);
  }

  /**
   * Linearly interpolates across the given range of ticks and properties. Since a double value is
   * calculated, but an integer must be returned, this method rounds to the nearest integer instead
   * of flooring/ceiling a number.
   *
   * @param tick1     the lower bound of the tick
   * @param tick2     the intermediate value of the tick
   * @param tick3     the upper bound of the tick
   * @param property1 the lower bound of the property
   * @param property2 the upper bound of the property
   * @return the intermediate value of the property
   * @throws IllegalArgumentException if the upper bound and lower bound of the tick are equal
   */
  private static int tween(int tick1, int tick2, int tick3, int property1, int property2)
      throws IllegalArgumentException {
    if (tick1 == tick3) {
      throw new IllegalArgumentException("Must have tick values to linearly interpolate across.");
    }

    double initialWeight = ((double) tick3 - tick2) / (tick3 - tick1);
    double initialValue = initialWeight * property1;

    double finalWeight = ((double) tick2 - tick1) / (tick3 - tick1);
    double finalValue = finalWeight * property2;

    return (int) Math.round(finalValue + initialValue);
  }
}
