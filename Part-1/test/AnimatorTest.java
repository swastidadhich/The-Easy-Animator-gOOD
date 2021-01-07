import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Color;
import cs3500.animator.model.Ellipse;
import cs3500.animator.model.Circle;
import cs3500.animator.model.Rectangle;
import cs3500.animator.model.Square;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Position2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.AnimatorView;
import cs3500.animator.view.EasyAnimatorView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

/**
 * Class represents the tests for the Animator.
 */
public class AnimatorTest {

  Color red;
  Color blue;
  Color green;
  Color c1;
  Color c2;
  Color c3;
  Color c4;

  Position2D p1;
  Position2D p2;
  Position2D p3;
  Position2D p4;
  Position2D p5;
  Position2D p6;
  Position2D p7;
  Position2D p8;
  Position2D p9;

  Shape2D nullShape;
  Shape2D r1;
  Shape2D r2;
  Shape2D r3;
  Shape2D r4;
  Shape2D rAt30;
  Shape2D rAt60;
  Shape2D e1;
  Shape2D e2;
  Shape2D e3;
  Shape2D e4;
  Shape2D eAt30;
  Shape2D eAt60;
  Shape2D rAt55;
  Shape2D eAt55;
  Shape2D e1DiffPos;
  Shape2D e1DiffColor;
  Shape2D crc1;
  Shape2D crc2;
  Shape2D crc3;
  Shape2D crcAt50;
  Shape2D sq1;
  Shape2D sq2;
  Shape2D sq3;
  Shape2D sqAt40;
  Shape2D rLargeWidth;
  Shape2D rLargeHeight;

  List<Shape2D> mtShapes;
  List<Shape2D> shapeNull;
  List<Shape2D> shapesRE1;
  List<Shape2D> shapesRE2;
  List<Shape2D> shapesREat30;
  List<Shape2D> shapesREat60;
  List<Shape2D> shapesREat55;
  List<Shape2D> shapesCAt50;
  List<Shape2D> shapesC1;
  List<Shape2D> shapesS1;
  List<Shape2D> shapesSAt40;

  Motion2D mR1TickOverlap;
  Motion2D mR1TickGap;
  Motion2D mR1;
  Motion2D mR2;
  Motion2D mR3;
  Motion2D mR4;
  Motion2D mR5;
  Motion2D mE1Neg;
  Motion2D mE1BadTicks;
  Motion2D mE1;
  Motion2D mE2;
  Motion2D mE3;
  Motion2D mE4;
  Motion2D mE5;
  Motion2D mE2DiffName;
  Motion2D mE2DiffPos;
  Motion2D mE2DiffColor;
  Motion2D mC1;
  Motion2D mC2;
  Motion2D mC3;
  Motion2D mS1;
  Motion2D mS2;
  Motion2D mS3;
  Motion2D mLargeWidth;
  Motion2D mLargeHeight;

  List<Motion2D> mtMotions;
  List<Motion2D> lomR;
  List<Motion2D> lomE;
  List<Motion2D> lomENull;
  List<Motion2D> lomENeg;
  List<Motion2D> lomEBadTicks;
  List<Motion2D> lomEDiffName;
  List<Motion2D> lomEDiffPos;
  List<Motion2D> lomEDiffColor;
  List<Motion2D> lomRTickOverlap;
  List<Motion2D> lomRTickGap;
  List<Motion2D> lomInvalid;
  List<Motion2D> lomC;
  List<Motion2D> lomS;
  List<Motion2D> lomLargeWidth;
  List<Motion2D> lomLargeHeight;

  List<List<Motion2D>> mtDirections;
  List<List<Motion2D>> motionsRE;
  List<List<Motion2D>> motionsRENeg;
  List<List<Motion2D>> motionsE;
  List<List<Motion2D>> motionsRENull;
  List<List<Motion2D>> motionsSingleNull;
  List<List<Motion2D>> motionsREBadTicks;
  List<List<Motion2D>> motionsREDiffName;
  List<List<Motion2D>> motionsREDiffPos;
  List<List<Motion2D>> motionsREDiffColor;
  List<List<Motion2D>> motionsRETickOverlap;
  List<List<Motion2D>> motionsRETickGap;
  List<List<Motion2D>> motionsInvalid;
  List<List<Motion2D>> motionsC;
  List<List<Motion2D>> motionsS;
  List<List<Motion2D>> motionsR;
  List<List<Motion2D>> motionsLargeWidth;
  List<List<Motion2D>> motionsLargeHeight;

  AnimatorModel eModel;
  AnimatorView eView;

  String stringRE;
  String stringC;
  String stringS;
  String stringR;
  String stringE;

  @Before
  public void setUp() throws Exception {
    red = new Color(255, 0, 0);
    blue = new Color(0, 0, 255);
    green = new Color(0, 255, 0);
    c1 = new Color(0, 170, 85);
    c2 = new Color(0, 85, 170);
    c3 = new Color(0, 43, 213);
    c4 = new Color(128, 128, 0);

    p1 = new Position2D(200, 200);
    p2 = new Position2D(300, 300);
    p3 = new Position2D(440, 70);
    p4 = new Position2D(440, 250);
    p5 = new Position2D(440, 370);
    p6 = new Position2D(440, 130);
    p7 = new Position2D(250, 250);
    p8 = new Position2D(440, 310);
    p9 = new Position2D(440, 280);

    nullShape = null;
    r1 = new Rectangle(red, p1, 50, 100);
    r2 = new Rectangle(red, p2, 50, 100);
    r3 = new Rectangle(red, p2, 25, 100);
    r4 = new Rectangle(red, p1, 25, 100);
    rAt30 = new Rectangle(red, p7, 50, 100);
    rAt60 = new Rectangle(red, p2, 38, 100);
    rAt55 = new Rectangle(red, p2, 45, 100);
    rLargeWidth = new Rectangle(red, p2, 600, 30);
    rLargeHeight = new Rectangle(red, p2, 20, 700);

    e1 = new Ellipse(blue, p3, 120, 60);
    e2 = new Ellipse(blue, p4, 120, 60);
    e3 = new Ellipse(c1, p5, 120, 60);
    e4 = new Ellipse(green, p5, 120, 60);
    eAt30 = new Ellipse(blue, p6, 120, 60);
    eAt60 = new Ellipse(c2, p8, 120, 60);
    eAt55 = new Ellipse(c3, p9, 120, 60);
    e1DiffPos = new Ellipse(blue, p9, 120, 60);
    e1DiffColor = new Ellipse(red, p3, 120, 60);

    crc1 = new Circle(blue, p1, 100);
    crc2 = new Circle(red, p2, 80);
    crc3 = new Circle(green, p1, 60);
    crcAt50 = new Circle(c4, p7, 70);

    sq1 = new Square(red, p9, 40);
    sq2 = new Square(red, p1, 100);
    sq3 = new Square(green, p2, 100);
    sqAt40 = new Square(c4, p7, 100);

    mS1 = new Motion2D("S", sq1, sq2, 1, 20);
    mS2 = new Motion2D("S", sq2, sq2, 20, 30);
    mS3 = new Motion2D("S", sq2, sq3, 30, 50);

    mC1 = new Motion2D("C", crc1, crc2, 1, 40);
    mC2 = new Motion2D("C", crc2, crc3, 40, 60);
    mC3 = new Motion2D("C", crc3, crc2, 60, 80);

    mR1TickOverlap = new Motion2D("R", r1, r1, 1, 15);
    mR1TickGap = new Motion2D("R", r1, r1, 1, 5);
    mR1 = new Motion2D("R", r1, r1, 1, 10);
    mR2 = new Motion2D("R", r1, r2, 10, 50);
    mR3 = new Motion2D("R", r2, r2, 50, 51);
    mR4 = new Motion2D("R", r2, r3, 51, 70);
    mR5 = new Motion2D("R", r3, r4, 70, 100);
    mLargeWidth = new Motion2D("R", rLargeWidth, rLargeWidth, 70, 100);
    mLargeHeight = new Motion2D("R", rLargeHeight, rLargeHeight, 70, 100);

    mE1Neg = new Motion2D("E", e1, e1, -6, 6);
    mE1BadTicks = new Motion2D("E", e1, e1, 10, 6);
    mE2DiffName = new Motion2D("X", e1, e2, 20, 50);
    mE2DiffPos = new Motion2D("E", e1DiffPos, e2, 20, 50);
    mE2DiffColor = new Motion2D("E", e1DiffColor, e2, 20, 50);
    mE1 = new Motion2D("E", e1, e1, 6, 20);
    mE2 = new Motion2D("E", e1, e2, 20, 50);
    mE3 = new Motion2D("E", e2, e3, 50, 70);
    mE4 = new Motion2D("E", e3, e4, 70, 80);
    mE5 = new Motion2D("E", e4, e4, 80, 100);

    mtMotions = new ArrayList<>();
    lomR = new ArrayList<>(Arrays.asList(mR1, mR2, mR3, mR4, mR5));
    lomInvalid = new ArrayList<>(Arrays.asList(mR1, mE2, mR3, mE4, mR5));
    lomRTickOverlap = new ArrayList<>(Arrays.asList(mR1TickOverlap, mR2, mR3, mR4, mR5));
    lomRTickGap = new ArrayList<>(Arrays.asList(mR1TickGap, mR2, mR3, mR4, mR5));
    lomE = new ArrayList<>(Arrays.asList(mE1, mE2, mE3, mE4, mE5));
    lomENull = new ArrayList<>(Arrays.asList(mE1, mE2, mE3, mE4, mE5, null));
    lomENeg = new ArrayList<>(Arrays.asList(mE1Neg, mE2, mE3, mE4, mE5));
    lomEBadTicks = new ArrayList<>(Arrays.asList(mE1BadTicks, mE2, mE3, mE4, mE5));
    lomEDiffName = new ArrayList<>(Arrays.asList(mE1, mE2DiffName, mE3, mE4, mE5));
    lomEDiffPos = new ArrayList<>(Arrays.asList(mE1, mE2DiffPos, mE3, mE4, mE5));
    lomEDiffColor = new ArrayList<>(Arrays.asList(mE1, mE2DiffColor, mE3, mE4, mE5));
    lomC = new ArrayList<>(Arrays.asList(mC1, mC2, mC3));
    lomS = new ArrayList<>(Arrays.asList(mS1, mS2, mS3));
    lomLargeWidth = new ArrayList<>(Arrays.asList(mLargeWidth));
    lomLargeHeight = new ArrayList<>(Arrays.asList(mLargeHeight));

    mtDirections = new ArrayList<>();
    motionsE = new ArrayList<>(Arrays.asList(lomE));
    motionsR = new ArrayList<>(Arrays.asList(lomR));
    motionsRE = new ArrayList<>(Arrays.asList(lomR, lomE));
    motionsRENull = new ArrayList<>(Arrays.asList(lomR, lomE, null));
    motionsSingleNull = new ArrayList<>(Arrays.asList(lomR, lomE, lomENull));
    motionsRENeg = new ArrayList<>(Arrays.asList(lomR, lomENeg));
    motionsREBadTicks = new ArrayList<>(Arrays.asList(lomR, lomEBadTicks));
    motionsREDiffName = new ArrayList<>(Arrays.asList(lomR, lomEDiffName));
    motionsREDiffPos = new ArrayList<>(Arrays.asList(lomR, lomEDiffPos));
    motionsREDiffColor = new ArrayList<>(Arrays.asList(lomR, lomEDiffColor));
    motionsRETickOverlap = new ArrayList<>(Arrays.asList(lomRTickOverlap, lomE));
    motionsRETickGap = new ArrayList<>(Arrays.asList(lomRTickGap, lomE));
    motionsInvalid = new ArrayList<>(Arrays.asList(lomInvalid, lomE));
    motionsC = new ArrayList<>(Arrays.asList(lomC));
    motionsS = new ArrayList<>(Arrays.asList(lomS));
    motionsLargeWidth = new ArrayList<>(Arrays.asList(lomLargeWidth));
    motionsLargeHeight = new ArrayList<>(Arrays.asList(lomLargeHeight));

    mtShapes = new ArrayList<>();
    shapesRE1 = new ArrayList<Shape2D>(Arrays.asList(r1, null));
    shapesRE2 = new ArrayList<Shape2D>(Arrays.asList(r1, e1));
    shapeNull = new ArrayList<Shape2D>(Arrays.asList(nullShape));
    shapesREat30 = new ArrayList<Shape2D>(Arrays.asList(rAt30, eAt30));
    shapesREat60 = new ArrayList<Shape2D>(Arrays.asList(rAt60, eAt60));
    shapesREat55 = new ArrayList<Shape2D>(Arrays.asList(rAt55, eAt55));
    shapesCAt50 = new ArrayList<Shape2D>(Arrays.asList(crcAt50));
    shapesC1 = new ArrayList<Shape2D>(Arrays.asList(crc1));
    shapesS1 = new ArrayList<Shape2D>(Arrays.asList(sq1));
    shapesSAt40 = new ArrayList<Shape2D>(Arrays.asList(sqAt40));

    eModel = new EasyAnimatorModel();
    eView = new EasyAnimatorView(eModel);

    stringRE =
            "motion R 1 200 200 50 100 255 0 0     10 200 200 50 100 255 0 0\n"
          + "motion R 10 200 200 50 100 255 0 0     50 300 300 50 100 255 0 0\n"
          + "motion R 50 300 300 50 100 255 0 0     51 300 300 50 100 255 0 0\n"
          + "motion R 51 300 300 50 100 255 0 0     70 300 300 25 100 255 0 0\n"
          + "motion R 70 300 300 25 100 255 0 0     100 200 200 25 100 255 0 0\n"
          + "\n"
          + "motion E 6 440 70 120 60 0 0 255     20 440 70 120 60 0 0 255\n"
          + "motion E 20 440 70 120 60 0 0 255     50 440 250 120 60 0 0 255\n"
          + "motion E 50 440 250 120 60 0 0 255     70 440 370 120 60 0 170 85\n"
          + "motion E 70 440 370 120 60 0 170 85     80 440 370 120 60 0 255 0\n"
          + "motion E 80 440 370 120 60 0 255 0     100 440 370 120 60 0 255 0\n";

    stringC =
            "motion C 1 200 200 100 100 0 0 255     40 300 300 80 80 255 0 0\n"
          + "motion C 40 300 300 80 80 255 0 0     60 200 200 60 60 0 255 0\n"
          + "motion C 60 200 200 60 60 0 255 0     80 300 300 80 80 255 0 0\n";

    stringS =
           "motion S 1 440 280 40 40 255 0 0     20 200 200 100 100 255 0 0\n"
         + "motion S 20 200 200 100 100 255 0 0     30 200 200 100 100 255 0 0\n"
         + "motion S 30 200 200 100 100 255 0 0     50 300 300 100 100 0 255 0\n";

    stringR =
            "motion R 1 200 200 50 100 255 0 0     10 200 200 50 100 255 0 0\n"
          + "motion R 10 200 200 50 100 255 0 0     50 300 300 50 100 255 0 0\n"
          + "motion R 50 300 300 50 100 255 0 0     51 300 300 50 100 255 0 0\n"
          + "motion R 51 300 300 50 100 255 0 0     70 300 300 25 100 255 0 0\n"
          + "motion R 70 300 300 25 100 255 0 0     100 200 200 25 100 255 0 0\n";

    stringE =
            "motion E 6 440 70 120 60 0 0 255     20 440 70 120 60 0 0 255\n"
          + "motion E 20 440 70 120 60 0 0 255     50 440 250 120 60 0 0 255\n"
          + "motion E 50 440 250 120 60 0 0 255     70 440 370 120 60 0 170 85\n"
          + "motion E 70 440 370 120 60 0 170 85     80 440 370 120 60 0 255 0\n"
          + "motion E 80 440 370 120 60 0 255 0     100 440 370 120 60 0 255 0\n";
  }

  ///////////
  // MODEL //
  ///////////

  // GET SHAPES
  // test the method get shapes can get a list of multiple shapes
  @Test
  public void testGetMultipleShapes() {
    eModel.startAnimation(motionsE);
    assertEquals(shapeNull, eModel.getShapes());
  }

  // test the method get shapes can get a list with a single shape
  @Test
  public void testGetSingleShape() {
    eModel.startAnimation(motionsC);
    assertEquals(shapesC1, eModel.getShapes());
  }

  // test the method get shapes can get an empty list of shapes, if motions are empty
  @Test
  public void testGetEmptyShapes() {
    eModel.startAnimation(mtDirections);
    assertEquals(mtShapes, eModel.getShapes());
  }

  // test an exception is thrown when the animation has not been started
  @Test(expected = IllegalStateException.class)
  public void testGetShapesAnimationNotStarted() {
    eModel.getShapes();
  }

  // GET MOTIONS
  // test the method get motions can return the animations list of list of motions
  @Test
  public void testGetMotionsEmpty() {
    eModel.startAnimation(motionsRE);
    assertEquals(motionsRE, eModel.getMotions());
  }

  // test the method get motions returns an empty list if the model has an empty set of directions
  @Test
  public void testGetMotions() {
    eModel.startAnimation(mtDirections);
    assertEquals(mtMotions, eModel.getMotions());
  }

  // test an exception is thrown when the animation has not been started
  @Test(expected = IllegalStateException.class)
  public void testGetMotionsAnimationNotStarted() {
    eModel.getMotions();
  }

  // GET TICKS
  // test that the get ticks method returns -1 if the animation is not started
  @Test
  public void testGetTicksAnimationNotStarted() {
    assertEquals(-1, eModel.getTick());
  }

  // test that the get ticks method returns 1 if the animation is just started
  @Test
  public void testGetTicksAnimationJustStarted() {
    eModel.startAnimation(motionsRE);
    assertEquals(1, eModel.getTick());
  }

  // test that the get ticks method correctly returns the tick if the animation is not at tick 1
  @Test
  public void testGetTicks() {
    eModel.startAnimation(motionsRE);
    eModel.updateAnimation(15);
    assertEquals(15, eModel.getTick());
  }


  // START ANIMATION
  // test that start animation correctly initializes the tick as 1
  @Test
  public void testStartAnimationTicks() {
    assertEquals(-1, eModel.getTick());
    eModel.startAnimation(motionsRE);
    assertEquals(1, eModel.getTick());
  }

  // test that start animation correctly initializes the list of shapes at their tick 1 state
  @Test
  public void testStartAnimationShapes() {
    eModel.startAnimation(motionsRE);
    assertEquals(shapesRE1, eModel.getShapes());
  }

  // test that start animation initializes a shape as null if it does not have a motion at tick 1
  @Test
  public void testStartAnimationShapesNull() {
    eModel.startAnimation(motionsE);
    assertEquals(shapeNull, eModel.getShapes());
  }

  // test that start animation correctly initializes the list of list of motions as the directions
  @Test
  public void testStartAnimationMotions() {
    eModel.startAnimation(motionsRE);
    assertEquals(motionsRE, eModel.getMotions());
  }

  // test that start animation initializes an empty list of shapes when given empty directions
  @Test
  public void testStartAnimationMtShapes() {
    eModel.startAnimation(mtDirections);
    assertEquals(mtShapes, eModel.getShapes());
  }

  // test start animation initializes an empty list of list of motions when given empty directions
  @Test
  public void testStartAnimationMtMotions() {
    eModel.startAnimation(mtDirections);
    assertEquals(mtMotions, eModel.getMotions());
  }

  // test that start animation correctly initializes motions for a circle
  @Test
  public void testStartAnimationCircle() {
    eModel.startAnimation(motionsC);
    assertEquals(shapesC1, eModel.getShapes());
  }

  // test that start animation correctly initializes motions for a circle
  @Test
  public void testStartAnimationSquare() {
    eModel.startAnimation(motionsS);
    assertEquals(shapesS1, eModel.getShapes());
  }

  // START ANIMATION EXCEPTIONS
  // test an exception is thrown when start animation is given null directions
  @Test(expected = IllegalArgumentException.class)
  public void testNullListOfListOfMotions() {
    eModel.startAnimation(null);
  }

  // test an exception is thrown when a null list of motion is given within the directions
  @Test(expected = IllegalArgumentException.class)
  public void testNullListOfMotion() {
    eModel.startAnimation(motionsRENull);
  }

  // test an exception is thrown when start animation is given a null motion within the directions
  @Test(expected = IllegalArgumentException.class)
  public void testNullMotion() {
    eModel.startAnimation(motionsSingleNull);
  }

  // test an exception is thrown when start animation is given directions with negative ticks
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeTick() {
    eModel.startAnimation(motionsRENeg);
  }

  // test an exception where start animation is given motions where start tick > ending tick
  @Test(expected = IllegalArgumentException.class)
  public void testTick1MoreThanTick2() {
    eModel.startAnimation(motionsREBadTicks);
  }

  // test an exception where the starting motion's name is different from the ending name
  // of the previous motion
  @Test(expected = IllegalArgumentException.class)
  public void testDiffMotionName() {
    eModel.startAnimation(motionsREDiffName);
  }

  // test an exception where the starting motion's position is different from the ending position of
  // the previous motion
  @Test(expected = IllegalArgumentException.class)
  public void testDiffMotionPosition() {
    eModel.startAnimation(motionsREDiffPos);
  }

  // test an exception where the starting motion's color is different from the ending color of
  // the previous motion
  @Test(expected = IllegalArgumentException.class)
  public void testDiffMotionColor() {
    eModel.startAnimation(motionsREDiffColor);
  }

  // test an exception is thrown where a single list of motions contains two types of shapes
  @Test(expected = IllegalArgumentException.class)
  public void testMotionMultipleShapes() {
    eModel.startAnimation(motionsInvalid);
  }

  // test an exception is thrown where directions have overlapping ticks (overlapping motion)
  @Test(expected = IllegalArgumentException.class)
  public void testTickOverlap() {
    eModel.startAnimation(motionsRETickOverlap);
  }

  // test an exception is thrown where directions have a gap in the ticks
  @Test(expected = IllegalArgumentException.class)
  public void testTickGap() {
    eModel.startAnimation(motionsRETickGap);
  }

  // UPDATE ANIMATION
  // test that update animation correctly updates shapes when given the current tick
  @Test
  public void testUpdateShapesTick1() {
    eModel.startAnimation(motionsRE);
    assertEquals(shapesRE1, eModel.getShapes());
    eModel.updateAnimation(1);
    assertEquals(shapesRE1, eModel.getShapes());
  }

  // test that update animation correctly updates shapes at a non-current tick
  @Test
  public void testUpdateShapesTick10() {
    eModel.startAnimation(motionsRE);
    assertEquals(shapesRE1, eModel.getShapes());
    eModel.updateAnimation(10);
    assertEquals(shapesRE2, eModel.getShapes());
  }

  // test that updateAnimation correctly updates the position of multiple shapes when given a tick
  // between a motion interval
  @Test
  public void testUpdateShapesPosition() {
    eModel.startAnimation(motionsRE);
    assertEquals(shapesRE1, eModel.getShapes());
    eModel.updateAnimation(30);
    assertEquals(shapesREat30, eModel.getShapes());
  }

  // test that updateAnimation correctly updates the color of multiple shapes when given a tick
  // between a motion interval
  @Test
  public void testUpdateShapesColor() {
    eModel.startAnimation(motionsRE);
    assertEquals(shapesRE1, eModel.getShapes());
    eModel.updateAnimation(60);
    assertEquals(shapesREat60, eModel.getShapes());
  }

  // test that updateAnimation correctly updates the dimensions of multiple shapes when given a
  // tick between a motion interval
  @Test
  public void testUpdateShapesDimensions() {
    eModel.startAnimation(motionsRE);
    assertEquals(shapesRE1, eModel.getShapes());
    eModel.updateAnimation(55);
    assertEquals(shapesREat55, eModel.getShapes());
  }

  // test update animation with a circle
  @Test
  public void testUpdateCircle() {
    eModel.startAnimation(motionsC);
    assertEquals(shapesC1, eModel.getShapes());
    eModel.updateAnimation(50);
    assertEquals(shapesCAt50, eModel.getShapes());
  }

  // test update animation with a square
  @Test
  public void testUpdateSquare() {
    eModel.startAnimation(motionsS);
    assertEquals(shapesS1, eModel.getShapes());
    eModel.updateAnimation(40);
    assertEquals(shapesSAt40, eModel.getShapes());
  }

  // UPDATE ANIMATION EXCEPTIONS
  // test an exception is thrown when the animation has not been started
  @Test(expected = IllegalStateException.class)
  public void testUpdateAnimationNotStarted() {
    eModel.updateAnimation(10);
  }

  // test an exception is thrown when given a tick of 0
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateAnimationTick0() {
    eModel.startAnimation(motionsS);
    eModel.updateAnimation(0);
  }

  // test an exception is thrown when given a negative tick
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateAnimationNegTick() {
    eModel.startAnimation(motionsS);
    eModel.updateAnimation(-10);
  }

  // INVARIANT TEST
  // test that a model containing directions with a shape with a width larger than frameWidth
  // throws an exception
  @Test(expected = IllegalArgumentException.class)
  public void testInvariantWidthTooLarge() {
    eModel.startAnimation(motionsLargeWidth);
  }

  // test that a model containing directions with a shape with a height larger than frameHeight
  // throws an exception
  @Test(expected = IllegalArgumentException.class)
  public void testInvariantHeightTooLarge() {
    eModel.startAnimation(motionsLargeHeight);
  }

  //////////
  // VIEW //
  //////////

  // test the view of a rectangle and ellipse
  @Test
  public void testViewMultipleShapes() throws IOException {
    eModel.startAnimation(motionsRE);
    assertEquals(stringRE, eView.toString());
  }

  // test the view of a circle
  @Test
  public void testViewCircle() throws IOException {
    eModel.startAnimation(motionsC);
    assertEquals(stringC, eView.toString());
  }

  // test the view of a square
  @Test
  public void testViewSquare() throws IOException {
    eModel.startAnimation(motionsS);
    assertEquals(stringS, eView.toString());
  }

  // test the view of a ellipse
  @Test
  public void testViewEllipse() throws IOException {
    eModel.startAnimation(motionsE);
    assertEquals(stringE, eView.toString());
  }

  // test the view of a rectangle
  @Test
  public void testViewRectangle() throws IOException {
    eModel.startAnimation(motionsR);
    assertEquals(stringR, eView.toString());
  }

  // test the view of an empty set of motions
  @Test
  public void testViewMt() throws IOException {
    eModel.startAnimation(mtDirections);
    assertEquals("", eView.toString());
  }

}
