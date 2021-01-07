package cs3500.animator.provider.model;

/**
 * This interface extends the readonly timeline to add mutability. In particular, motions can be
 * added.
 */
public interface IMutableTimeline extends IReadOnlyTimeline {

  /**
   * Adds a motion to the shape on this timeline. A motion is a change between two known states of
   * the shape (the before and after states) at different ticks on the timeline.
   *
   * @param tick1   the tick the motion begins on
   * @param x1      the x-coordinate of the shape before the motion
   * @param y1      the y-coordinate before the motion
   * @param width1  the width of the shape before the motion
   * @param height1 the height of the shape before the motion
   * @param red1    the shape's red color channel intensity before the motion
   * @param green1  the shape's green color channel intensity before the motion
   * @param blue1   the shape's blue color channel intensity before the motion
   * @param tick2   the tick the motion ends on
   * @param x2      the x-coordinate of the shape after the motion
   * @param y2      the y-coordinate of the shape after the motion
   * @param width2  the width of the shape after the motion
   * @param height2 the height of the shape after the motion
   * @param red2    the red color channel intensity of this shape after the motion
   * @param green2  the green color channel intensity of this shape after the motion
   * @param blue2   the blue color channel intensity of this shape  after the motion
   * @throws IllegalArgumentException if the motion is invalid
   */
  void addMotion(
      int tick1, int x1, int y1, int width1, int height1, int red1, int green1, int blue1,
      int tick2, int x2, int y2, int width2, int height2, int red2, int green2, int blue2)
      throws IllegalArgumentException;
}
