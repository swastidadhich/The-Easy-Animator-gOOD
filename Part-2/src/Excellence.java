import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.AnimatorView;
import cs3500.animator.view.AnimatorViewCreator;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
        default:
          popUpError();
          System.exit(0);
      }
    }

    AnimatorView v = null;
    AnimatorViewCreator creator;
    Readable rd = new FileReader(in);
    AnimationBuilder<AnimatorModel> builder = new EasyAnimatorModel.Builder();
    AnimatorModel model = new AnimationReader().parseFile(rd, builder);

    if (in.equals("") || view.equals("")) {
      throw new IllegalArgumentException("Invalid input");
    }

    switch (view) {
      case "text":
        if (out.equals("")) {
          creator = new AnimatorViewCreator(model, speed);
        }
        else {
          FileWriter apText = new FileWriter(out);
          creator = new AnimatorViewCreator(model, speed, apText);
        }

        v = creator.create(AnimatorViewCreator.ViewType.TEXT);
        break;
      case "visual":
        if (! out.equals("")) {
          popUpError();
          System.exit(0);
        }
        creator = new AnimatorViewCreator(model, speed);
        v = creator.create(AnimatorViewCreator.ViewType.VISUAL);
        break;
      case "svg":
        if (out.equals("")) {
          popUpError();
          System.exit(0);
        }
        FileWriter fw = new FileWriter(out);
        creator = new AnimatorViewCreator(model, speed, fw);
        v = creator.create(AnimatorViewCreator.ViewType.SVG);
        break;
      default:
        popUpError();
        System.exit(0);
    }

    v.render();
  }

  // shows an error message
  private static void popUpError() {
    JOptionPane.showMessageDialog(new JFrame(), "Invalid command argument."
            ,"Command argument error", JOptionPane.ERROR_MESSAGE);
  }

}
