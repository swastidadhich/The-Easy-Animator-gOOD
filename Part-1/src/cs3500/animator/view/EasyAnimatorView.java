package cs3500.animator.view;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.Motion2D;

import java.io.IOException;
import java.util.List;

/**
 * A class to represent an easy animator view.
 */

public class EasyAnimatorView implements AnimatorView {

  private final AnimatorModel model;
  private Appendable ap;

  /**
   * Constructs an EasyAnimatorView with a model and appendable.
   *
   * @param model the model
   * @param ap    appendable
   */

  public EasyAnimatorView(AnimatorModel model, Appendable ap) {
    this.model = new EasyAnimatorModel();
    this.ap = ap;
  }

  /**
   * Constructs an EasyAnimatorView with a model.
   *
   * @param model the model
   */

  public EasyAnimatorView(AnimatorModel model) {
    this.model = model;
  }

  // Converts this easy animator view to a string
  @Override
  public String toString() {
    StringBuilder animator = new StringBuilder();
    String s = "";

    if (this.model.getTick() == -1) {
      throw new IllegalStateException("Animation not started");
    }

    for (int i = 0; i < this.model.getMotions().size(); i++) {
      List<Motion2D> lom = this.model.getMotions().get(i);
      for (int j = 0; j < lom.size(); j++) {
        Motion2D m = lom.get(j);
        animator.append("motion " + m.getName() + " ");
        animator.append(m.getTick1() + " ");
        animator.append(m.getShapeI().getPositionX() + " ");
        animator.append(m.getShapeI().getPositionY() + " ");
        animator.append(m.getShapeI().getWidth() + " ");
        animator.append(m.getShapeI().getHeight() + " ");
        animator.append(m.getShapeI().getRed() + " ");
        animator.append(m.getShapeI().getGreen() + " ");
        animator.append(m.getShapeI().getBlue() + " ");
        animator.append("    ");
        animator.append(m.getTick2() + " ");
        animator.append(m.getShapeF().getPositionX() + " ");
        animator.append(m.getShapeF().getPositionY() + " ");
        animator.append(m.getShapeF().getWidth() + " ");
        animator.append(m.getShapeF().getHeight() + " ");
        animator.append(m.getShapeF().getRed() + " ");
        animator.append(m.getShapeF().getGreen() + " ");
        animator.append(m.getShapeF().getBlue());
        if (j < lom.size()) {
          animator.append("\n");
        }
      }
      if (i < this.model.getMotions().size() - 1) {
        animator.append("\n");
      }
    }
    return animator.toString();
  }

  // Renders the view
  @Override
  public void render() throws IOException {
    this.ap.append(model.toString());
    this.ap.append("\n");
  }
}
