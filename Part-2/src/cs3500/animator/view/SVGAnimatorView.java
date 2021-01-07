package cs3500.animator.view;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class visually represents the SVGAnimatorView.
 */


public class SVGAnimatorView implements AnimatorView {

  private final AnimatorModel model;
  private FileWriter ap;
  private final double tempo;

  /**
   * Constructs an EasyAnimatorView with a model and appendable.
   *
   * @param model the model
   * @param ap    appendable
   */

  public SVGAnimatorView(AnimatorModel model, FileWriter ap, double tempo) {
    this.model = model; //new EasyAnimatorModel();
    this.ap = ap;
    this.tempo = tempo;
  }

  /**
   * Constructs an EasyAnimatorView with a model.
   *
   * @param model the model
   */

  public SVGAnimatorView(AnimatorModel model, double tempo) {
    this.model = model;
    this.tempo = tempo;
  }

  @Override
  public void render() throws IOException {
    this.ap.write(this.toString());
    this.ap.close();
  }


  @Override
  public String toString() {
    StringBuilder svgBuild = new StringBuilder();
    if (model.getDirections().size() == 0) {
      return "";
    }
    try {
      svgBuild.append(
              "<svg width=\"" + 1000 + "\" height=\"" + 1000
                      + "\" version=\"" + 1.1 + "\" xmlns=\""
                      + "http:"
                      + '/' + '/' + "www.w3.org/2000/svg\""
                      + " xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:sketch=\""
                      + "http://www.bohemiancoding.com/sketch/ns\"> \n");
      int motionCounter = 0;
      for (Shape2D shape : model.getDirections().keySet()) {
        List<Motion2D> lom = model.getMotionsFromShape(shape);
        String type = shape.getType();

        switch (type) {
          case "rectangle":
          case "square":
            svgBuild.append(rectangle(lom, motionCounter));
            break;
          case "ellipse":
            svgBuild.append(ellipse(lom, motionCounter));
            break;
          case "circle":
            svgBuild.append(circle(lom, motionCounter));
            break;
          default:
        }
        motionCounter++;
      }

      svgBuild.append("</svg>");

    } catch (Exception e) {
      e.printStackTrace();
    }

    return svgBuild.toString();
  }

  /**
   * This is a helper method which helps with generating strings which help with generating
   * the shape and their attributes in the svg file.
   * @param t1 tick1
   * @param t2 tick2
   * @param attribute attribute
   * @param x x position
   * @param y y position
   * @return a string for the svg file
   */
  public String animate(int t1, int t2, String attribute, String x, String y) {
    StringBuilder builder = new StringBuilder();
    builder.append("<animate attributeType=\"xml\" begin=");
    builder.append("\"" + t1 + "s\" dur=");
    builder.append("\"" + t2 + "s\" attributeName=");
    builder.append("\"" + attribute + "\" from=");
    builder.append(x + " to=");
    builder.append(y + " fill=\"freeze\" />");
    builder.append("\n");
    return builder.toString();

  }

  /**
   * This is a helper method which helps with generating strings which help with the transformation
   * of the shapes in a svg file.
   * @param x1 starting x position
   * @param x2 ending x position
   * @param y1 starting y position
   * @param y2 ending y position
   * @param t1 tick
   * @param dur duration
   * @param type type
   * @return a string for the svg file
   */
  public String animateTransform(int x1, int x2, int y1, int y2, double t1, double dur,
                                 String type) {
    StringBuilder builder = new StringBuilder();
    builder.append("<animateTransform attributeName=\"transform\" type=\"" + type + "\"");
    builder.append(" from=\"" + x1 + " " + y1 + "\" ");
    builder.append("to=\"" + x2 + " " + y2 + "\" ");
    builder.append("begin=\"" + t1 + "s\" ");
    builder.append("dur=\"" + dur + "s\" fill=\"freeze\" />");
    builder.append("\n");
    return builder.toString();

  }

  /**
   * This is a helper method which helps with actually translating and getting the shapes to
   * move, resize and change color.
   * @param lom list of motions
   * @return a string for the svg file
   */
  public String animateMotion(List<Motion2D> lom) {
    StringBuilder builder = new StringBuilder();
    Utilities util = new Utilities();
    boolean isInitial = true;
    if (lom == null) {
      return "";
    }
    for (Motion2D motion : lom) {
      if (isInitial) {
        builder.append(
                animateTransform(motion.getX1(), motion.getX2(), motion.getY1(), motion.getY2(),
                        (motion.getTick1() / tempo),
                        ((motion.getTick2() - motion.getTick1()) / tempo), "translate"));

      }

      // UPON uncommenting the below code the pyramid is centered but the motion is not accurate;

      //      if (Math.abs(motion.getX2() - motion.getX1()) != 0
      //          || Math.abs(motion.getY2() - motion.getY1()) != 0) {
      //        builder.append(
      //            animateTransform(motion.getX1(), motion.getX2(), motion.getY1(), motion.getY2(),
      //                (int) (motion.getTick1() / tempo),
      //                (int) ((motion.getTick2() - motion.getTick1()) / tempo), "translate"));
      //
      //      }
      if (Math.abs(motion.getWidth2() - motion.getWidth1()) > 0) {

        builder.append(animate((int) (motion.getTick1() / tempo),
                (int) ((motion.getTick2() - motion.getTick1()) / tempo), "width", "\"" +
                        String.valueOf(motion.getWidth1()) + "\"",
                "\"" + String.valueOf(motion.getWidth2()) + "\""));
      }
      if (Math.abs(motion.getHeight2() - motion.getHeight1()) > 0) {

        builder.append(animate((int) (motion.getTick1() / tempo),
                (int) ((motion.getTick2() - motion.getTick1()) / tempo), "height",
                String.valueOf(motion.getHeight1()),
                String.valueOf(motion.getHeight2())));
      }

      if (motion.getRed1() != motion.getRed2() || motion.getGreen1() != motion.getGreen2()
              || motion.getBlue1() != motion.getBlue2()) {
        String rgb1 = new StringBuilder().append(
                "\"rgb(" + motion.getRed1() + "," + motion.getGreen1() + "," + motion.getBlue1()
                        + ")\"").toString();
        String rgb2 = new StringBuilder().append(
                "\"rgb(" + motion.getRed2() + "," + motion.getGreen2() + ","
                        + motion.getBlue2() + ")\"")
                .toString();
        builder.append(
                animate((int) (motion.getTick1() / tempo), (int) (motion.getTick2() / tempo),
                        "fill", rgb1, rgb2));
      }
    }
    return builder.toString();
  }

  /**
   * This helper method helps in generating strings for the svg file for a rectangle and its
   * attributes (x = x-coordinate, y = y-coordinate, width, height & rbg).
   * @param lom list of motions
   * @param id identification tag for the shape
   * @return a string for the svg file
   */
  public String rectangle(List<Motion2D> lom, int id) {
    int x = lom.get(0).getX1();
    int y = lom.get(0).getY1();
    int width = lom.get(0).getWidth1();
    int height = lom.get(0).getHeight1();
    int r = lom.get(0).getRed1();
    int b = lom.get(0).getBlue1();
    int g = lom.get(0).getGreen1();
    StringBuilder builder = new StringBuilder();
    builder.append("<rect id=\"" + id + "\" x=");
    builder.append("\"" + x + "\" y=");
    builder.append("\"" + y + "\" width=");
    builder.append("\"" + width + "\" height=");
    builder.append("\"" + height + "\" fill=");
    builder.append("\"rgb(" + r + "," + g + "," + b + ")\" visibility=");
    builder.append("\"visible\" >");
    builder.append("\n");
    builder.append(animateMotion(lom));
    builder.append("</rect>");
    builder.append("\n");
    return builder.toString();
  }

  /**
   * This helper method helps in generating strings for the svg file for an ellipse and its
   * attributes (x = x-coordinate, y = y-coordinate, width, height & rbg).
   * @param lom list of motions
   * @param id identification tag for the shape
   * @return a string for the svg file
   */
  public String ellipse(List<Motion2D> lom, int id) {
    int x = lom.get(0).getX1();
    int y = lom.get(0).getY1();
    int width = lom.get(0).getWidth1();
    int height = lom.get(0).getHeight1();
    int r = lom.get(0).getRed1();
    int b = lom.get(0).getBlue1();
    int g = lom.get(0).getGreen1();
    StringBuilder builder = new StringBuilder();
    builder.append("<ellipse id=\"" + id + "\" cx=");
    builder.append("\"" + x + "\" cy=");
    builder.append("\"" + y + "\" rx=");
    builder.append("\"" + width + "\" ry=");
    builder.append("\"" + height + "\" fill=");
    builder.append("\"rgb(" + r + "," + g + "," + b + ")\" visibility=");
    builder.append("\"visible\" >");
    builder.append("\n");
    builder.append(animateMotion(lom));
    builder.append("</ellipse>");
    builder.append("\n");
    return builder.toString();
  }

  /**
   * This helper method helps in generating strings for the svg file for a circle and its
   * attributes (x = x-coordinate, y = y-coordinate, width & rbg).
   * @param lom list of motions
   * @param id identification tag for the shape
   * @return a string for the svg file
   */
  public String circle(List<Motion2D> lom, int id) {
    int x = lom.get(0).getX1();
    int y = lom.get(0).getY1();
    int width = lom.get(0).getWidth1();
    int r = lom.get(0).getRed1();
    int b = lom.get(0).getBlue1();
    int g = lom.get(0).getGreen1();
    StringBuilder builder = new StringBuilder();
    builder.append("<circle id=\"" + id + "\" cx=");
    builder.append("\"" + x + "\" cy=");
    builder.append("\"" + y + "\" r=");
    builder.append("\"" + width + "\" fill=");
    builder.append("\"rgb(" + r + "," + g + "," + b + ")\" visibility=");
    builder.append("\"visible\" >");
    builder.append("\n");
    builder.append(animateMotion(lom));
    builder.append("</circle>");
    builder.append("\n");
    return builder.toString();
  }
}