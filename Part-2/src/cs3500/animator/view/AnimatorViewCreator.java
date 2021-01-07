package cs3500.animator.view;

import cs3500.animator.model.AnimatorModel;

import java.io.FileWriter;

/**
 * A class which defines three types of views and which contains a method for returning different
 * types of AnimatorViews.
 */
public class AnimatorViewCreator {

  private static AnimatorModel model;
  private static double tempo;
  private static Appendable ap;

  /**
   * An enum to represent the game type of pyramid solitaire.
   */
  public enum ViewType {
    TEXT(), VISUAL(), SVG();
  }

  /**
   * Constructs an AnimatorCreator with a model and tempo. Sets the appendable to System.out.
   * @param model the model
   * @param tempo ticks per second
   */
  public AnimatorViewCreator(AnimatorModel model, double tempo) {
    AnimatorViewCreator.model = model;
    AnimatorViewCreator.tempo = tempo;
    AnimatorViewCreator.ap = System.out;
  }

  /**
   * Constructs an AnimatorCreator with a model, tempo, and FileWriter.
   */
  public AnimatorViewCreator(AnimatorModel model, double tempo, Appendable ap) {
    AnimatorViewCreator.model = model;
    AnimatorViewCreator.tempo = tempo;
    AnimatorViewCreator.ap = ap;
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
        return new TextualTimeAnimatorView(model, ap, tempo);
      case VISUAL:
        return new VisualAnimatorView(model, tempo);
      case SVG:
        return new SVGAnimatorView(model, (FileWriter) ap, tempo);
      default:
        throw new IllegalArgumentException("Invalid input");
    }
  }
}
