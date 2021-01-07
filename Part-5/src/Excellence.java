import cs3500.animator.controller.AnimatorController;
import cs3500.animator.controller.VisualAnimatorController;
import cs3500.animator.controller.EasyAnimatorController;
import cs3500.animator.controller.InteractiveAnimatorController;
import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.Canvas;
import cs3500.animator.model.Shape2D;
import cs3500.animator.model.Motion2D;

import cs3500.animator.view.AnimatorView;
import cs3500.animator.view.AnimatorViewCreator;
import cs3500.animator.view.AnimatorVisual;
import cs3500.animator.view.AnimatorInteractive;
import cs3500.animator.view.TextualTimeAnimatorView;
import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.SpeedInterval;
import cs3500.animator.view.SVGAnimatorView;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Class which contains the main method which will render the animation given a command line
 * argument.
 */
public class Excellence {

  /**
   * Renders a type of view given command line arguments which specify the type of view, input
   * file, and optionally the tempo and out file.
   * @param args command line arguments
   * @throws IOException if view cannot be rendered
   */
  public static void main(String[] args) throws IOException {

    String in = "";
    String out = "";
    String view = "";
    String slomo = "";
    double speed = 1;

    // invalid args if odd in size
    if (Arrays.asList(args).size()  % 2 != 0) {
      popUpError();
      System.exit(0);
    }

    for (int i = 0; i < args.length; i = i + 2) {

      String arg1 = args[i];
      String arg2 = args[i + 1];

      switch (arg1) {
        case "-in":
          if (in.equals("")) {
            in = arg2;
          }
          else {
            popUpError();
            System.exit(0);
          }
          break;
        case "-out":
          if (out.equals("")) {
            out = arg2;
          }
          else {
            popUpError();
            System.exit(0);
          }
          break;
        case "-view":
          if (view.equals("")) {
            view = arg2;
          }
          else {
            popUpError();
            System.exit(0);
          }
          break;
        case "-speed":
          if (speed == 1) {
            try {
              speed = Integer.parseInt(args[i + 1]);
            } catch (NumberFormatException e) {
              System.err.println("Invalid input");
              System.exit(1);
            }
          }
          else {
            popUpError();
            System.exit(0);
          }
          break;
        case "-slomo":
          if (slomo.equals("")) {
            slomo = arg2;
          }
          else {
            popUpError();
            System.exit(0);
          }
          break;
        default:
          popUpError();
          System.exit(0);
      }
    }

    AnimatorView v;
    AnimatorController c;
    AnimatorViewCreator creator;
    Readable rd = null;
    Readable rdSlomo = null;
    List<SpeedInterval> speedIntervals = new ArrayList<>();
    if (! slomo.equals("")) {
      try {
        rdSlomo = new FileReader(slomo);
      } catch (FileNotFoundException e) {
        popUpError();
        System.exit(0);
      }
      speedIntervals = new AnimationReader().parseSlomo(rdSlomo);
    }

    try {
      rd = new FileReader(in);
    } catch (FileNotFoundException e) {
      popUpError();
      System.exit(0);
    }
    AnimationBuilder<AnimatorModel> builder = new EasyAnimatorModel.Builder();
    AnimatorModel model = new AnimationReader().parseFile(rd, builder);
    //List<SpeedInterval> speedIntervals = new AnimationReader().parseSlomo(rdSlomo);
    Canvas canvas = model.getCanvas();
    LinkedHashMap<Shape2D, List<Motion2D>> directions = model.getDirections();

    if (in.equals("") || view.equals("")) {
      throw new IllegalArgumentException("Invalid input");
    }

    switch (view) {
      case "text":
        if (out.equals("")) {
          creator = new AnimatorViewCreator(directions, speed);
        }
        else {
          FileWriter apText = new FileWriter(out);
          creator = new AnimatorViewCreator(directions, speed, apText);
        }
        v = creator.create(AnimatorViewCreator.ViewType.TEXT);

        c = new EasyAnimatorController((TextualTimeAnimatorView) v);
        c.playAnimation();
        break;
      case "visual":
        if (! out.equals("")) {
          popUpError();
          System.exit(0);
        }
        creator = new AnimatorViewCreator(canvas, speed);
        v = creator.create(AnimatorViewCreator.ViewType.VISUAL);

        c = new VisualAnimatorController(model, (AnimatorVisual) v);
        c.playAnimation();
        break;
      case "svg":
        if (out.equals("")) {
          creator = new AnimatorViewCreator(directions, speed);
        }
        else {
          FileWriter fw = new FileWriter(out);
          creator = new AnimatorViewCreator(directions, speed, fw);
        }
        v = creator.create(AnimatorViewCreator.ViewType.SVG);

        c = new EasyAnimatorController((SVGAnimatorView) v);
        c.playAnimation();
        break;
      case "interactive":
        if (! out.equals("")) {
          popUpError();
          System.exit(0);
        }

        creator = new AnimatorViewCreator(canvas, speed, speedIntervals);
        v = creator.create(AnimatorViewCreator.ViewType.INTERACTIVE);

        c = new InteractiveAnimatorController(model, (AnimatorInteractive) v);
        c.playAnimation();
        break;
      default:
        popUpError();
        System.exit(0);
    }

  }

  // shows an error message
  private static void popUpError() {
    JOptionPane.showMessageDialog(new JFrame(), "Invalid command argument."
            ,"Command argument error", JOptionPane.ERROR_MESSAGE);
  }

}
