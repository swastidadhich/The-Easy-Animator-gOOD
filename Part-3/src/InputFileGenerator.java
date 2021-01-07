
import cs3500.animator.view.inputdrawing.GenerateInput;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class which contains the main method which will generate the input files, given the command line
 * which will specify whether the file is generated programatically or manually.
 */

public class InputFileGenerator {

  /**
   * Renders a txt file from command line arguments which specify whether the file is generated
   * programatically or manually.
   *
   * @param args command line arguments
   * @throws IOException if view cannot be rendered
   */

  public static void main(String[] args) {
    GenerateInput ge = new GenerateInput();
    ge.createAnimation();
    InputFileGenerator in = new InputFileGenerator();
    in.generate();
  }

  /**
   * This is an  method which manually generates the txt input file.
   */

  public void generate() {

    try {
      FileWriter input = new FileWriter("sunset.txt");
      StringBuilder sb = new StringBuilder();
      sb.append("canvas ");
      sb.append("200 70 360 360" + "\n");
      sb.append("canvas 0 0 800 800\n"
          + "shape background rectangle\n"
          + "shape sun ellipse\n"
          + "shape building1 rectangle\n"
          + "shape building2 rectangle\n"
          + "shape treebark rectangle\n"
          + "shape treetop1 ellipse\n"
          + "shape treetop2 ellipse\n"
          + "\n"
          + "motion background 1 0 0 800 800 137 207 240 1 0 0 800 800 137 207 240\n"
          + "motion background 1 0 0 800 800 137 207 240 50 0 0 800 800 137 207 240\n"
          + "motion background 50 0 0 800 800 137 207 240 90 0 0 800 800 2 7 93\n"
          + "motion background 90 0 0 800 800 2 7 93 200 0 0 800 800 2 7 93\n"
          + "\n"
          + "motion sun 1 600 100 150 150 255 229 124 1 600 100 150 150 255 229 124\n"
          + "motion sun 1 600 100 150 150 255 229 124 50 100 100 150 150 255 229 124\n"
          + "motion sun 50 100 100 150 150 255 229 124 90 100 100 150 150 255 250 250\n"
          + "motion sun 90 100 100 150 150 255 250 250 200 100 100 150 150 255 250 250\n"
          + "\n"
          + "motion building1 1 30 424 200 326 128 128 112 1 30 424 200 326 128 128 112\n"
          + "motion building1 1 30 424 200 326 128 128 112 50 30 424 200 326 128 128 112\n"
          + "motion building1 50 30 424 200 326 128 128 112 90 30 424 200 326 0 0 0\n"
          + "motion building1 90 30 424 200 326 0 0 0 200 30 424 200 326 0 0 0\n"
          + "\n"
          + "motion building2 1 270 375 150 375 254 127 156 1 270 375 150 375 254 127 156\n"
          + "motion building2 1 270 375 150 375 254 127 156 50 270 375 150 375 254 127 156\n"
          + "motion building2 50 270 375 150 375 254 127 156 90 270 375 150 375 0 0 0\n"
          + "motion building2 90 270 375 150 375 0 0 0 200 270 375 150 375 0 0 0\n"
          + "\n"
          + "\n"
          + "motion treebark 1 570 570 50 200 51 25 0 1 570 570 50 200 51 25 0\n"
          + "motion treebark 1 570 570 50 200 51 25 0 50 570 570 50 200 51 25 0\n"
          + "motion treebark 50 570 570 50 200 51 25 0 90 570 570 50 200 0 0 0\n"
          + "motion treebark 90 570 570 50 200 0 0 0 200 570 570 50 200 0 0 0\n"
          + "\n"
          + "motion treetop1 1 500 450 200 125 34 139 34 1 500 450 200 125 34 139 34\n"
          + "motion treetop1 1 500 450 200 125 34 139 34 50 500 450 200 125 34 139 34\n"
          + "motion treetop1 50 500 450 200 125 34 139 34 90 500 450 200 125 0 0 0\n"
          + "motion treetop1 90 500 450 200 125 0 0 0 200 500 450 200 125 0 0 0\n"
          + "\n"
          + "motion treetop2 1 530 370 150 105 34 139 34 1 530 370 150 105 34 139 34\n"
          + "motion treetop2 1 530 370 150 105 34 139 34 50 530 370 150 105 34 139 34\n"
          + "motion treetop2 50 530 370 150 105 34 139 34 90 530 370 150 105 0 0 0\n"
          + "motion treetop2 90 530 370 150 105 0 0 0 200 530 370 150 105 0 0 0\n");
      input.write(sb.toString());
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
