package cs3500.animator.view;

import cs3500.animator.model.Canvas;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * A class which defines three types of views and which contains a method for returning different
 * types of AnimatorViews.
 */
public class AnimatorViewCreator {

  private static Canvas canvas;
  private static double tempo;
  private static Appendable ap;
  private static LinkedHashMap<Shape2D, List<Motion2D>> directions;
  private static List<SpeedInterval> los;

  /**
   * An enum to represent the game type of pyramid solitaire.
   */
  public enum ViewType {
    TEXT(), VISUAL(), SVG(), INTERACTIVE()
  }

  /**
   * Constructs an AnimatorCreator with a canvas and tempo. Sets the appendable to System.out.
   * @param canvas the model
   * @param tempo ticks per second
   */
  public AnimatorViewCreator(Canvas canvas, double tempo) {
    AnimatorViewCreator.canvas = canvas;
    AnimatorViewCreator.tempo = tempo;
    AnimatorViewCreator.ap = System.out;
    AnimatorViewCreator.directions = null;
  }

  /**
   * Constructs an AnimatorCreator with a canvas, tempo, and list of SpeedIntervals. Sets the
   * appendable to System.out.
   * @param canvas the model
   * @param tempo ticks per second
   * @param los list of speed intervals
   */
  public AnimatorViewCreator(Canvas canvas, double tempo, List<SpeedInterval> los) {
    AnimatorViewCreator.canvas = canvas;
    AnimatorViewCreator.tempo = tempo;
    AnimatorViewCreator.los = los;
    AnimatorViewCreator.ap = System.out;
    AnimatorViewCreator.directions = null;
  }

  /**
   * Constructs an AnimatorCreator with a canvas and tempo. Sets the appendable to System.out.
   * @param directions the model
   * @param tempo ticks per second
   */
  public AnimatorViewCreator(LinkedHashMap<Shape2D, List<Motion2D>> directions, double tempo) {
    AnimatorViewCreator.directions = directions;
    AnimatorViewCreator.tempo = tempo;
    AnimatorViewCreator.ap = System.out;
    AnimatorViewCreator.canvas = null;
  }

  /**
   * Constructs an AnimatorCreator with directions, tempo, and appendable.
   * @param directions directions
   * @param tempo tempo
   * @param ap appendable
   */
  public AnimatorViewCreator(LinkedHashMap<Shape2D, List<Motion2D>> directions, double tempo,
                             Appendable ap) {
    AnimatorViewCreator.directions = directions;
    AnimatorViewCreator.tempo = tempo;
    AnimatorViewCreator.ap = ap;
    AnimatorViewCreator.canvas = null;
  }

  /**
   * Returns a view type depending on the given enum view type.
   * @param type the view type
   * @return a type of view
   * @throws IllegalArgumentException if given an invalid ViewType
   */
  public static AnimatorView create(ViewType type) throws IllegalArgumentException {
    switch (type) {
      case TEXT:
        return new TextualTimeAnimatorView(directions, ap, tempo);
      case VISUAL:
        return new VisualAnimatorView(canvas, tempo);
      case SVG:
        return new SVGAnimatorView(directions, ap, tempo);
      case INTERACTIVE:
        return new InteractiveAnimatorView(canvas, tempo, los);
      default:
        throw new IllegalArgumentException("Invalid input");
    }
  }
}
