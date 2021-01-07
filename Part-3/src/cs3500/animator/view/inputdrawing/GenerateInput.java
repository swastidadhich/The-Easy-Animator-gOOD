package cs3500.animator.view.inputdrawing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * A class to which generates a txt input file programatically .
 */

public class GenerateInput implements IInputShape {

  int t1 = 0;
  int t2 = 0;
  FileWriter input;
  int scale = 2;
  InputRect r1;


  /**
   * This is an helper method which generates the txt input file.
   */

  public GenerateInput() {
    r1 = new InputRect();
    try {
      input = new FileWriter("musicwave.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void createAnimation() {
    int count = 0;
    addMotion();
    try {
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void addMotion() {

    int scale = 1;

    int id = 0;
    int x = 0;
    Random random = new Random();
    while (id < 20) {
      t1 = 0;
      t2 = 10;
      int count = 0;
      declareShapes(id);
      int red = random.nextInt(255);
      int blue = random.nextInt(255);
      int green = random.nextInt(255);
      InputRect r = new InputRect();
      x += 15;
      r.setX(x);
      r.setB(blue);
      r.setR(red);
      r.setG(green);
      while (count < 6) {

        addRect(t1, t2, scale, id, r);
        scale = scale == 1 ? 0 : 1;
        count++;
        t1 = t2 + id;
        t2 += 10 + id;
      }
      id++;
    }
  }

  private void addRect(int t1, int t2, int scale, int id, InputRect r1) {
    StringBuilder sb = new StringBuilder();
    sb.append("motion " + id + " ");
    r1.setT(t1);
    sb.append(r1 + " ");
    r1.setT(t2);
    r1.setW(r1.w);
    if (scale == 0) {
      r1.setH(r1.h / 3);
      r1.setY(5);
    } else {
      r1.setH(r1.h * 3);
      r1.setY(20);
    }
    sb.append(r1 + " " + "\n");
    try {
      input.write(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void declareShapes(int id) {
    StringBuilder sb = new StringBuilder();
    sb.append("shape " + id + " rectangle" + "\n");
    try {
      input.write(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
