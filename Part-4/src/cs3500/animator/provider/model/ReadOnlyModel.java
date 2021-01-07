package cs3500.animator.provider.model;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.provider.shapes.ShapeType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A class to represent a model of an animation which can be observed but not mutated.
 */
public class ReadOnlyModel implements IReadOnlyAnimationModel {

  private final AnimatorModel delegate;

  /**
   * Constructs a ReadOnlyModel with a new EasyAnimatorModel.
   */
  public ReadOnlyModel() {
    this.delegate = new EasyAnimatorModel();
  }

  /**
   * Constructs a ReadOnlyModel with an AnimatorModel.
   * @param delegate animator model
   */
  public ReadOnlyModel(AnimatorModel delegate) {
    this.delegate = delegate;
  }

  @Override
  public int getCanvasX() {
    return delegate.getCanvas().getX();
  }

  @Override
  public int getCanvasY() {
    return delegate.getCanvas().getY();
  }

  @Override
  public int getCanvasWidth() {
    return delegate.getCanvas().getWidth();
  }

  @Override
  public int getCanvasHeight() {
    return delegate.getCanvas().getHeight();
  }

  @Override
  public Map<String, IReadOnlyTimeline> getTimelines() {
    Map<String, IReadOnlyTimeline> result = new LinkedHashMap<>();

    for (Shape2D shape2D : delegate.getDirections().keySet()) {

      ShapeType shapeType = null;
      String type = shape2D.getType();
      if (type.equals("oval") || type.equals("circle") || type.equals("ellipse")) {
        shapeType = ShapeType.OVAL;
      }
      else if (type.equals("rectangle") || type.equals("square")) {
        shapeType = ShapeType.RECTANGLE;
      }

      IMutableTimeline timeline = new MutableTimeline(shapeType, shape2D.getName());

      for (Motion2D m : delegate.getMotionsFromShape(shape2D)) {

        timeline.addMotion(m.getTick1(), m.getX1(), m.getY1(), m.getWidth1(), m.getHeight1(),
                m.getRed1(), m.getGreen1(), m.getBlue1(), m.getTick2(), m.getX2(), m.getY2(),
                m.getWidth2(), m.getHeight2(), m.getRed2(), m.getGreen2(), m.getBlue2());

      }
      result.put(shape2D.getName(), timeline);

    }
    return result;
  }

  @Override
  public int getLastTick() {
    return delegate.getLastTick();
  }
}
