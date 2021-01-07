package cs3500.animator.view;

import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.AnimatorView;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * A class to represent a textual representation of an animator model.
 */
public class TextualTimeAnimatorView implements AnimatorView {
  private final LinkedHashMap<Shape2D, List<Motion2D>> directions;
  private final Appendable ap;
  private final double tempo;

  /**
   * Constructs a TextualTimeAnimatorView with a model, appendable, and tempo.
   * @param directions the directions
   * @param ap the appendable
   * @param tempo speed in ticks/second
   * @throws IllegalArgumentException if the model or appendable is null, the tempo is not positive
   */
  public TextualTimeAnimatorView(LinkedHashMap<Shape2D, List<Motion2D>> directions, Appendable ap,
                                 double tempo) {

    if (directions == null || ap == null) {
      throw new IllegalArgumentException("Directions and/or appendable cannot be null");
    }

    if (tempo <= 0) {
      throw new IllegalArgumentException("Tempo must be positive");
    }

    this.directions = directions;
    this.ap = ap;
    this.tempo = tempo;
  }

  // Converts this easy animator view to a string
  @Override
  public String toString() {
    StringBuilder animator = new StringBuilder();
    String s = "";

    for (Shape2D shape : directions.keySet()) {
      for (Motion2D m : directions.get(shape)) {
        animator.append("motion " + m.getName() + " ");
        animator.append(String.format("%.2f", m.getTick1() / tempo) + " ");
        animator.append(m.getX1() + " ");
        animator.append(m.getY1() + " ");
        animator.append(m.getWidth1() + " ");
        animator.append(m.getHeight1() + " ");
        animator.append(m.getRed1() + " ");
        animator.append(m.getGreen1() + " ");
        animator.append(m.getBlue1() + " ");
        animator.append("    ");
        animator.append(String.format("%.2f", m.getTick1() / tempo) + " ");
        animator.append(m.getX2() + " ");
        animator.append(m.getY2() + " ");
        animator.append(m.getWidth2() + " ");
        animator.append(m.getHeight2() + " ");
        animator.append(m.getRed2() + " ");
        animator.append(m.getGreen2() + " ");
        animator.append(m.getBlue2() + " ");
        animator.append("\n");
      }
      animator.append("\n");
    }
    return animator.toString();
  }

  // Renders the view
  @Override
  public void render() throws IOException {
    if (ap instanceof FileWriter) {
      FileWriter f = (FileWriter) ap;
      f.write(this.toString());
      f.close();
    }
    else {
      this.ap.append(this.toString());
      this.ap.append("\n");
    }

  }

}
