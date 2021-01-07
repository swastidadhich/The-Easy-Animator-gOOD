package cs3500.animator.provider.view;

import cs3500.animator.provider.model.IReadOnlyAnimationModel;
import cs3500.animator.provider.model.IReadOnlyTimeline;
import cs3500.animator.provider.shapes.IReadOnlyShape;
import cs3500.animator.provider.shapes.ShapeType;
import cs3500.animator.util.ViewUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * A textual view of an animation. This view uses an output. The output of the view is formatted as
 * a list of lines, where each line shows the start and end state of a shape across a motion.
 */
public class TextAnimationView implements ITextualAnimationView {

  private Appendable output;
  private IReadOnlyAnimationModel viewModel;
  private int speed;

  /**
   * Constructs a new text animation view, with default output {@code System.out.svg}.
   */
  public TextAnimationView() {
    this.output = System.out;
    this.viewModel = null;
    this.speed = 1;
  }

  @Override
  public void setOutput(Appendable output) throws NullPointerException {
    this.output = Objects.requireNonNull(output);
  }

  @Override
  public void setSpeed(int speed) throws IllegalArgumentException {
    if (speed <= 0) {
      throw new IllegalArgumentException("Speed must be positive.");
    }
    this.speed = speed;
  }

  @Override
  public void render()
      throws IllegalArgumentException, IllegalStateException {
    Objects.requireNonNull(this.viewModel);
    if (this.speed <= 0) {
      throw new IllegalArgumentException("Speed must be positive.");
    }

    // append the canvas declaration line
    ViewUtil.append(String.format("canvas %d %d %d %d\n",
        this.viewModel.getCanvasX(), this.viewModel.getCanvasY(),
        this.viewModel.getCanvasWidth(), this.viewModel.getCanvasHeight()),
        this.output);

    // append each shape's timeline
    for (IReadOnlyTimeline iReadOnlyTimeline : viewModel.getTimelines().values()) {
      this.renderTimeline(iReadOnlyTimeline, speed);
    }
  }

  /**
   * Renders the given timeline at the given speed, i.e renders the motions for one shape.
   *
   * @param timeline the timeline
   * @param speed    the speed
   */
  private void renderTimeline(IReadOnlyTimeline timeline, int speed) {
    // append the shape declaration line
    ViewUtil.append(String.format("shape %s %s\n",
        timeline.getShapeName(), typeToString(timeline.getShapeType())),
        this.output);

    List<Integer> ticks = timeline.getKeyTicks();

    if (ticks.isEmpty()) {
      return;
    }

    Iterator<Integer> iterator = ticks.iterator();
    int start = iterator.next();
    do {
      int end;
      if (iterator.hasNext()) {
        end = iterator.next();
      } else {
        end = start;
      }

      IReadOnlyShape from = timeline.getShapeAtKeyTick(start);
      IReadOnlyShape to = timeline.getShapeAtKeyTick(end);
      this.renderLine(timeline.getShapeName(), start, end, from, to, speed);
      start = end;
    }
    while (iterator.hasNext());
  }

  /**
   * Renders a single line in the view, according to the format {@code "motion name t1 x1 y1 w1 h1
   * r1 g1 b1 t2 x2 y2 w2 h2 r2 g2 b2"} where {@code t1} is the start tick, {@code x1}, {@code y1},
   * {@code w1}, {@code h1}, {@code r1}, {@code g2}, and {@code b1} are the respective properties of
   * the before shape, and {@code x2} and so on are the respective properties of the after shape.
   * The speed is given to help convert from ticks to seconds.
   *
   * @param name   the name of the shape
   * @param tick1  the start tick of the motion
   * @param tick2  the end tick of the motion
   * @param shape1 the state of the shape before the motion
   * @param shape2 the state of the shape after teh motion
   * @param speed  the speed of the animation
   */
  private void renderLine(String name, int tick1, int tick2,
      IReadOnlyShape shape1, IReadOnlyShape shape2, int speed) {
    ViewUtil.append(
        String.format("motion %s %.2f %d %d %d %d %d %d %d %.2f %d %d %d %d %d %d %d\n", name,
            ViewUtil.toSeconds(tick1, speed), shape1.getX(), shape1.getY(), shape1.getWidth(),
            shape1.getHeight(), shape1.getRed(), shape1.getGreen(), shape1.getBlue(),
            ViewUtil.toSeconds(tick2, speed), shape2.getX(), shape2.getY(), shape2.getWidth(),
            shape2.getHeight(), shape2.getRed(), shape2.getGreen(), shape2.getBlue()),
        this.output);
  }

  /**
   * Converts the given shape type to a string representation specific to text views.
   *
   * @param type the shape type
   * @return the string
   * @throws NullPointerException if the type is null
   */
  private static String typeToString(ShapeType type) throws NullPointerException {
    switch (Objects.requireNonNull(type)) {
      case RECTANGLE:
        return "rectangle";
      case OVAL:
        return "ellipse";
      default:
        throw new IllegalArgumentException("Invalid shape type.");
    }
  }

  @Override
  public void setViewModel(IReadOnlyAnimationModel viewModel) {
    this.viewModel = Objects.requireNonNull(viewModel);
  }
}
