
import cs3500.animator.controller.InteractiveAnimatorController;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Shape2D;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.Canvas;
import cs3500.animator.view.SVGAnimatorView;
import cs3500.animator.view.AnimatorView;
import cs3500.animator.view.InteractiveAnimatorView;
import cs3500.animator.view.TextualTimeAnimatorView;
import cs3500.animator.view.VisualAnimatorView;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class represents the tests for the Animator.
 */
public class AnimatorTest {

  AnimatorModel modelR;
  AnimatorModel modelEmpty;
  AnimatorModel modelC;
  AnimatorModel modelEllipse;
  AnimatorModel modelRE;
  SVGAnimatorView svg;
  AnimatorView text;
  AnimatorView visual;
  Appendable ap;
  Shape2D rect;
  Shape2D circle;
  Motion2D mR1;
  Motion2D mR2;
  Motion2D mC1;
  LinkedHashMap<Shape2D, List<Motion2D>> directionsR;
  EasyAnimatorModel.Builder builder;
  InteractiveAnimatorView interactive;
  InteractiveAnimatorView interactiveMax;
  InteractiveAnimatorView interactiveMin;
  Canvas c1;
  Canvas c2;
  Canvas c3;
  InteractiveAnimatorController iController;
  InteractiveAnimatorController iControllerMax;
  InteractiveAnimatorController iControllerMin;

  @Before
  public void setUp() throws Exception {

    c1 = new Canvas(10, 2, 500, 1000);
    c2 = new Canvas(0, 0, 1000, 1000);
    c3 = new Canvas(1, 2, 3, 4);

    rect = new Shape2D("R", "rectangle");
    circle = new Shape2D("C", "circle");

    mR1 = new Motion2D("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    mR2 = new Motion2D("R", 10, 200, 200, 50, 100, 255, 0, 0,
        50, 300, 300, 50, 100, 255, 0, 0);
    mC1 = new Motion2D("C", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);

    directionsR = new LinkedHashMap<>();
    directionsR.put(rect, new ArrayList<>(Arrays.asList(mR1)));

    builder = new EasyAnimatorModel.Builder();

    modelR = new EasyAnimatorModel();
    modelR.addShape("R", "rectangle");
    modelR.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    modelR.addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0,
        50, 300, 300, 50, 100, 255, 0, 0);
    modelR.addMotion("R", 50, 300, 300, 50, 100, 255, 0, 0,
        51, 300, 300, 50, 100, 255, 0, 0);
    modelR.addMotion("R", 51, 300, 300, 50, 100, 255, 0, 0,
        70, 300, 300, 25, 100, 255, 0, 0);
    modelR.addMotion("R", 70, 300, 300, 25, 100, 255, 0, 0,
        100, 200, 200, 25, 100, 255, 0, 0);

    modelEllipse = new EasyAnimatorModel();
    modelEllipse.addShape("C", "ellipse");
    modelEllipse.addMotion("C", 6, 440, 70, 120, 60, 0, 0, 255,
        20, 440, 70, 120, 60, 0, 0, 255);
    modelEllipse.addMotion("C", 20, 440, 70, 120, 60, 0, 0, 255,
        50, 440, 250, 120, 60, 0, 0, 255);
    modelEllipse.addMotion("C", 50, 440, 250, 120, 60, 0, 0, 255,
        70, 440, 370, 120, 60, 0, 170, 85);
    modelEllipse.addMotion("C", 70, 440, 370, 120, 60, 0, 170, 85,
        80, 440, 370, 120, 60, 0, 255, 0);
    modelEllipse.addMotion("C", 80, 440, 370, 120, 60, 0, 255, 0,
        100, 440, 370, 120, 60, 0, 255, 0);

    modelRE = new EasyAnimatorModel();
    modelRE.addShape("R", "rectangle");
    modelRE.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    modelRE.addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0,
        50, 300, 300, 50, 100, 255, 0, 0);
    modelRE.addMotion("R", 50, 300, 300, 50, 100, 255, 0, 0,
        51, 300, 300, 50, 100, 255, 0, 0);
    modelRE.addMotion("R", 51, 300, 300, 50, 100, 255, 0, 0,
        70, 300, 300, 25, 100, 255, 0, 0);
    modelRE.addMotion("R", 70, 300, 300, 25, 100, 255, 0, 0,
        100, 200, 200, 25, 100, 255, 0, 0);
    modelRE.addShape("C", "ellipse");
    modelRE.addMotion("C", 6, 440, 70, 120, 60, 0, 0, 255,
        20, 440, 70, 120, 60, 0, 0, 255);
    modelRE.addMotion("C", 20, 440, 70, 120, 60, 0, 0, 255,
        50, 440, 250, 120, 60, 0, 0, 255);
    modelRE.addMotion("C", 50, 440, 250, 120, 60, 0, 0, 255,
        70, 440, 370, 120, 60, 0, 170, 85);
    modelRE.addMotion("C", 70, 440, 370, 120, 60, 0, 170, 85,
        80, 440, 370, 120, 60, 0, 255, 0);
    modelRE.addMotion("C", 80, 440, 370, 120, 60, 0, 255, 0,
        100, 440, 370, 120, 60, 0, 255, 0);

    modelC = new EasyAnimatorModel();
    modelC.addShape("C", "circle");
    modelC.addMotion("C", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);

    modelEmpty = new EasyAnimatorModel();

    ap = System.out;
    svg = new SVGAnimatorView(modelR.getDirections(), new FileWriter("out.svg"), 5);
    text = new TextualTimeAnimatorView(modelR.getDirections(), ap, 5);
    visual = new VisualAnimatorView(c1, 5);

    interactive = new InteractiveAnimatorView(modelRE.getCanvas(), 5);
    interactiveMax = new InteractiveAnimatorView(modelRE.getCanvas(), 100);
    interactiveMin = new InteractiveAnimatorView(modelRE.getCanvas(), 1);

    iController = new InteractiveAnimatorController(modelRE, interactive);
    iControllerMax = new InteractiveAnimatorController(modelRE, interactiveMax);
    iControllerMin = new InteractiveAnimatorController(modelRE, interactiveMin);
  }

  ///////////
  // MODEL //
  ///////////

  // addShape
  // test that a shape can be correctly added to the model
  @Test
  public void testAddShape() {
    assertEquals(new ArrayList<>(), modelEmpty.getShapes());
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(Arrays.asList(rect)), modelEmpty.getShapes());
  }

  // test that multiple shapes can be correctly added to the model
  @Test
  public void testAddMultipleShapes() {
    assertEquals(new ArrayList<>(), modelEmpty.getShapes());
    modelEmpty.addShape("R", "rectangle");
    modelEmpty.addShape("C", "circle");
    assertEquals(new ArrayList<>(Arrays.asList(rect, circle)), modelEmpty.getShapes());
  }

  // test that addShape throws an exception if given a null name
  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    modelEmpty.addShape(null, "rectangle");
  }

  // test that addShape throws an exception if given a null type
  @Test(expected = IllegalArgumentException.class)
  public void testNullType() {
    modelEmpty.addShape("R", null);
  }

  // test that addShape throws an exception if a shape with the same name has already been added
  @Test(expected = IllegalArgumentException.class)
  public void testAlreadyAdded() {
    modelR.addShape("R", "rectangle");
  }

  // addMotion
  // test that addMotion correctly adds a motion to the model
  @Test
  public void testAddMotion() {
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), modelEmpty.getMotionsFromShape(rect));
  }

  // test that addMotion correctly adds multiple motions to the model
  @Test
  public void testAddMultipleMotions() {
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    modelEmpty.addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0,
        50, 300, 300, 50, 100, 255, 0, 0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1, mR2)), modelEmpty.getMotionsFromShape(rect));
  }

  // test that addMotion correctly adds motions to different shapes
  @Test
  public void testAddMotionsMultipleShapes() {
    modelEmpty.addShape("R", "rectangle");
    modelEmpty.addShape("C", "circle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    modelEmpty.addMotion("C", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), modelEmpty.getMotionsFromShape(rect));
    assertEquals(new ArrayList<>(Arrays.asList(mC1)), modelEmpty.getMotionsFromShape(circle));
  }

  // test that addMotion throws an exception if the shape with in the motion name has not been added
  @Test(expected = IllegalArgumentException.class)
  public void testNoMatchingShape() {
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
  }

  // test that addMotion throws an exception if ticks in the motion overlap with already added ones
  @Test(expected = IllegalArgumentException.class)
  public void testTickOverlap() {
    modelR.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        5, 200, 200, 50, 100, 255, 0, 0);
  }

  // test that addMotion throws an exception if tick1 is greater than tick2
  @Test(expected = IllegalArgumentException.class)
  public void testTick1GreaterThan2() {
    modelR.addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0,
        5, 200, 200, 50, 100, 255, 0, 0);
  }

  // test that addMotion throws an exception if the motion being added has a different state at a
  // shared tick with an already added one
  @Test(expected = IllegalArgumentException.class)
  public void testDifferentStateSameTick() {
    modelR.addMotion("R", 100, 200, 200, 25, 100, 255, 0, 99,
        105, 200, 200, 50, 100, 255, 0, 0);
  }

  // test that addMotion throws an exception if a tick is negative
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeTick() {
    modelR.addMotion("R", -10, 200, 200, 50, 100, 255, 0, 0,
        5, 200, 200, 50, 100, 255, 0, 0);
  }

  // test that addMotion throws an exception if the name is null
  @Test(expected = IllegalArgumentException.class)
  public void testNullMotionName() {
    modelR.addMotion(null, 150, 200, 200, 50, 100, 255, 0, 0,
        200, 200, 200, 50, 100, 255, 0, 0);
  }

  // getShapes
  // test that getShapes correctly gets the shapes in the model when there are none
  @Test
  public void testEmptyShapes() {
    assertEquals(new ArrayList<>(), modelEmpty.getShapes());
  }

  // test that getShapes correctly gets the shapes in the model when there is one
  @Test
  public void testGetSingleShape() {
    assertEquals(new ArrayList<>(), modelEmpty.getShapes());
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(Arrays.asList(rect)), modelEmpty.getShapes());
  }

  // test that getShapes correctly gets the shapes in the model when there are multiple
  @Test
  public void testGetMultipleShapes() {
    assertEquals(new ArrayList<>(), modelEmpty.getShapes());
    modelEmpty.addShape("R", "rectangle");
    modelEmpty.addShape("C", "circle");
    assertEquals(new ArrayList<>(Arrays.asList(rect, circle)), modelEmpty.getShapes());
  }

  // getMotionsFromShape
  // test that getMotionsFromShape correctly gets the list of motions for that shape
  @Test
  public void testGetMotionsFromShape() {
    modelEmpty.addShape("R", "rectangle");
    modelEmpty.addShape("C", "circle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    modelEmpty.addMotion("C", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), modelEmpty.getMotionsFromShape(rect));
    assertEquals(new ArrayList<>(Arrays.asList(mC1)), modelEmpty.getMotionsFromShape(circle));
  }

  // test that getMotionsFromShape throws an exception if given null
  @Test(expected = IllegalArgumentException.class)
  public void testNullShape() {
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    modelEmpty.getMotionsFromShape(null);
  }

  // test that getMotionsFromShape throws an exception if the given shape has not been added
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotAdded() {
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    modelEmpty.getMotionsFromShape(circle);
  }

  // initCanvas
  // test that initCanvas correctly initializes the canvas
  @Test
  public void testInitCanvas() {
    modelEmpty.initCanvas(1, 2, 500, 1000);
    assertEquals(1, modelEmpty.getCanvas().getX());
    assertEquals(2, modelEmpty.getCanvas().getY());
    assertEquals(500, modelEmpty.getCanvas().getWidth());
    assertEquals(1000, modelEmpty.getCanvas().getHeight());
  }

  // test initCanvas throws an exception if the width is negative
  @Test(expected = IllegalArgumentException.class)
  public void testNegWidth() {
    modelEmpty.initCanvas(1, 2, -500, 1000);
  }

  // test initCanvas throws an exception if the height is negative
  @Test(expected = IllegalArgumentException.class)
  public void testNegHeight() {
    modelEmpty.initCanvas(1, 2, 500, -1000);
  }

  // test getCanvas
  @Test
  public void testGetCanvas() {
    modelEmpty.initCanvas(10, 2, 500, 1000);
    assertEquals(c1, modelEmpty.getCanvas());
  }

  // test getDirections
  // test getting an empty set of directions
  @Test
  public void testGetDirectionsMt() {
    assertEquals(new LinkedHashMap<>(), modelEmpty.getDirections());
  }

  // test getting a set of directions with a shape and motions
  @Test
  public void testGetDirections() {
    modelEmpty.addShape("R", "rectangle");
    modelEmpty.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    assertEquals(directionsR, modelEmpty.getDirections());
  }

  // BUILDER
  // build
  // test that the build method correctly returns an empty model when nothing has been added
  @Test
  public void testBuildEmptyModel() {
    assertEquals(new LinkedHashMap<>(), builder.build().getDirections());
  }

  // test that the build method can correctly return a model that contains directions
  @Test
  public void testBuildModel() {
    //assertEquals(modelEmpty, builder.build());
    builder.declareShape("C", "circle");
    builder.addMotion("C", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    assertEquals(modelC.getDirections(), builder.build().getDirections());
  }

  // setBounds
  // test that the builder can correctly set the bounds
  @Test
  public void testSetBounds() {
    assertEquals(c2, builder.build().getCanvas());
    builder.setBounds(1, 2, 3, 4);
    assertEquals(c3, builder.build().getCanvas());
  }

  // declareShape
  // test that a shape can be correctly added using the builder
  @Test
  public void testBuilderDeclareShape() {
    assertEquals(new ArrayList<>(), builder.build().getShapes());
    builder.declareShape("R", "rectangle");
    assertEquals(new ArrayList<>(Arrays.asList(rect)), builder.build().getShapes());
  }

  // test that multiple shapes can be correctly added using the builder
  @Test
  public void testBuilderDeclareMultipleShapes() {
    assertEquals(new ArrayList<>(), builder.build().getShapes());
    builder.declareShape("R", "rectangle");
    builder.declareShape("C", "circle");
    assertEquals(new ArrayList<>(Arrays.asList(rect, circle)), builder.build().getShapes());
  }

  // addMotion
  // test that addMotion correctly adds a motion to the model
  @Test
  public void testAddMotionBuilder() {
    builder.declareShape("R", "rectangle");
    assertEquals(new ArrayList<>(), builder.build().getMotionsFromShape(rect));
    builder.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), builder.build().getMotionsFromShape(rect));
  }

  // test that addMotion correctly adds multiple motions to the model
  @Test
  public void testAddMultipleMotionsBuilder() {
    builder.declareShape("R", "rectangle");
    assertEquals(new ArrayList<>(), builder.build().getMotionsFromShape(rect));
    builder.addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
        10, 200, 200, 50, 100, 255, 0, 0);
    builder.addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0,
        50, 300, 300, 50, 100, 255, 0, 0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1, mR2)),
        builder.build().getMotionsFromShape(rect));
  }

  //////////
  // VIEW //
  //////////

  // SVG view

  @Test(expected = NullPointerException.class)
  public void testSVG() throws IOException {
    svg = new SVGAnimatorView(null, new FileWriter("out.svg"), 5);
    svg.render();
  }

  @Test
  public void testSVGEmpty() {
    try {
      svg = new SVGAnimatorView(new LinkedHashMap<>(), new FileWriter("out.svg"), 20);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("", svg.toString());
  }

  @Test
  public void testFalseSVGEmpty() {
    try {
      svg = new SVGAnimatorView(new LinkedHashMap<>(), new FileWriter("out.svg"), 20);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertNotEquals("<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
        + "xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" "
        + "xmlns:sketch=\"http://www.bohemiancoding.com/sketch/ns\"> \n"
        + "<ellipse id=\"0\" cx=\"440\" cy=\"70\" rx=\"120\" ry=\"60\" fill=\"rgb(0,0,255)\" "
        + "visibility=\"visible\" >\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 70\" "
        + "to=\"440 250\" begin=\"1s\" dur=\"1s\" fill=\"freeze\" />\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 250\" "
        + "to=\"440 370\" begin=\"2s\" dur=\"1s\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2s\" dur=\"3s\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"3s\" dur=\"4s\" attributeName=\"fill\" "
        + "from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>", svg.toString());
  }

  @Test
  public void testSVGNonEmptyRect() {
    try {
      svg = new SVGAnimatorView(modelR.getDirections(), new FileWriter("out.svg"), 20);
      svg.render();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(
        "<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
            + "xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/"
            + "xlink\" "
            + "xmlns:sketch=\"http://www.bohemiancoding.com/sketch/ns\"> \n"
            + "<rect id=\"0\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" "
            + "fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\""
            + "200 200\" "
            + "to=\"200 200\" begin=\"0.05s\" dur=\"0.45s\" fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"200"
            + " 200\" "
            + "to=\"300 300\" begin=\"0.5s\" dur=\"2.0s\" fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\""
            + "300 300\" "
            + "to=\"300 300\" begin=\"2.5s\" dur=\"0.05s\" fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\""
            + "300 300\" "
            + "to=\"300 300\" begin=\"2.55s\" dur=\"0.95s\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"2s\" dur=\"0s\" attributeName="
            + "\"width\" "
            + "from=\"50\" to=\"25\" fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\""
            + "300 300\" "
            + "to=\"200 200\" begin=\"3.5s\" dur=\"1.5s\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "</svg>", svg.toString());
  }

  @Test
  public void testFalseSVGNonEmptyRect() {
    try {
      svg = new SVGAnimatorView(modelR.getDirections(), new FileWriter("out.svg"), 20);
      svg.render();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertNotEquals("<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
        + "xmlns=\"http://www.w3.org/2000/svg\" "
        + "xmlns:xlink=\"http://www.w3.org/1999/xlink\" "
        + "xmlns:sketch=\"http://www.bohemiancoding.com/sketch/ns\"> \n"
        + "<ellipse id=\"0\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" "
        + "fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" "
        + "from=\"200 200\" to=\"300 300\" begin=\"0s\" dur=\"2s\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2s\" dur=\"0s\" "
        + "attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" "
        + "from=\"300 300\" to=\"200 200\" begin=\"3s\" dur=\"1s\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>", svg.toString());
  }

  @Test(expected = NullPointerException.class)
  public void testSVGException() {
    try {
      svg = new SVGAnimatorView(null, new FileWriter("out.svg"), 5);
    } catch (IOException e) {
      e.printStackTrace();
    }
    svg.toString();
  }

  @Test
  public void testSVGNonEmptyEllipse() {
    try {
      svg = new SVGAnimatorView(modelEllipse.getDirections(), new FileWriter("out.svg"), 20);
      svg.render();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
        + "xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" "
        + "xmlns:sketch=\"http://www.bohemiancoding.com/sketch/ns\"> \n"
        + "<ellipse id=\"0\" cx=\"440\" cy=\"70\" rx=\"120\" ry=\"60\" fill=\"rgb(0,0,255)\" "
        + "visibility=\"visible\" >\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 70\" "
        + "to=\"440 70\" begin=\"0.3s\" dur=\"0.7s\" fill=\"freeze\" />\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 70\" "
        + "to=\"440 250\" begin=\"1.0s\" dur=\"1.5s\" fill=\"freeze\" />\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 250\" "
        + "to=\"440 370\" begin=\"2.5s\" dur=\"1.0s\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2s\" dur=\"3s\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" fill=\"freeze\" />\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 370\" "
        + "to=\"440 370\" begin=\"3.5s\" dur=\"0.5s\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"3s\" dur=\"4s\" attributeName=\"fill\" "
        + "from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 370\" "
        + "to=\"440 370\" begin=\"4.0s\" dur=\"1.0s\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>", svg.toString());
  }

  @Test
  public void testFalseSVGNonEmptyEllipse() {
    try {
      svg = new SVGAnimatorView(modelEllipse.getDirections(), new FileWriter("out.svg"), 20);
      svg.render();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertNotEquals("<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
        + "xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" "
        + "xmlns:sketch=\"http://www.bohemiancoding.com/sketch/ns\"> \n"
        + "<rect id=\"0\" cx=\"440\" cy=\"70\" rx=\"120\" ry=\"60\" fill=\"rgb(0,0,255)\" "
        + "visibility=\"visible\" >\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 70\" "
        + "to=\"440 250\" begin=\"1s\" dur=\"1s\" fill=\"freeze\" />\n"
        + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\"440 250\" "
        + "to=\"440 370\" begin=\"2s\" dur=\"1s\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"2s\" dur=\"3s\" attributeName=\"fill\" "
        + "from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"3s\" dur=\"4s\" attributeName=\"fill\" "
        + "from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "</svg>", svg.toString());
  }

  @Test
  public void testNonEmptyAnimateMotion() {
    Shape2D shape = new Shape2D("R", "rectangle");
    assertEquals("<animateTransform attributeName=\"transform\" type=\"translate\" "
            + "from=\"200 200\" to=\"200 200\" begin=\"0.2s\" dur=\"1.8s\" "
            + "fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" "
            + "from=\"200 200\" "
            + "to=\"300 300\" begin=\"2.0s\" dur=\"8.0s\" fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" "
            + "from=\"300 300\" "
            + "to=\"300 300\" begin=\"10.0s\" dur=\"0.2s\" fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" "
            + "from=\"300 300\" "
            + "to=\"300 300\" begin=\"10.2s\" dur=\"3.8s\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"10s\" dur=\"3s\" attributeName="
            + "\"width\" "
            + "from=\"50\" to=\"25\" fill=\"freeze\" />\n"
            + "<animateTransform attributeName=\"transform\" type=\"translate\" from=\""
            + "300 300\" "
            + "to=\"200 200\" begin=\"14.0s\" dur=\"6.0s\" fill=\"freeze\" />"
            + "\n",
        svg.animateMotion(modelR.getDirections().get(shape)));
  }

  @Test
  public void testEmptyAnimateMotion() {
    Shape2D shape = new Shape2D("C", "ellipse");
    assertEquals("", svg.animateMotion(modelEmpty.getDirections().get(shape)));
  }

  @Test
  public void testNonEmptyAnimateTransform() {
    Shape2D shape = new Shape2D("R", "rectangle");
    Motion2D motion = modelR.getDirections().get(shape).get(0);
    assertEquals("<animateTransform attributeName=\"transform\" type=\"translate\" "
            + "from=\"200 200\" to=\"200 200\" begin=\"1.0s\" dur=\"10.0s\" "
            + "fill=\"freeze\" />" + "\n",
        svg.animateTransform(motion.getX1(), motion.getX2(),
            motion.getY1(), motion.getY2(), motion.getTick1(),
            motion.getTick2(), "translate"));

  }

  @Test(expected = NullPointerException.class)
  public void testEmptyAnimateTransform() {
    Shape2D shape = new Shape2D("C", "ellipse");
    Motion2D motion = modelR.getDirections().get(shape).get(0);
    assertEquals("", svg.animateTransform(motion.getX1(), motion.getX2(),
        motion.getY1(), motion.getY2(), motion.getTick1(),
        motion.getTick2(), "translate"));
  }

  @Test
  public void testNonEmptyAnimate() {
    Shape2D shape = new Shape2D("R", "rectangle");
    Motion2D motion = modelR.getDirections().get(shape).get(3);
    assertEquals("<animate attributeType=\"xml\" begin=\"51s\" dur=\"70s\" "
            + "attributeName=\"width\" from=50 to=25 fill=\"freeze\" />" + "\n",
        svg.animate(motion.getTick1(),
            motion.getTick2(), "width",
            String.valueOf(motion.getWidth1()), String.valueOf(motion.getWidth2())));

  }

  @Test(expected = NullPointerException.class)
  public void testEmptyAnimate() {
    Shape2D shape = new Shape2D("C", "ellipse");
    Motion2D motion = modelR.getDirections().get(shape).get(3);
    assertEquals("", svg.animate(motion.getTick1(),
        motion.getTick2(), "width",
        String.valueOf(motion.getWidth1()), String.valueOf(motion.getWidth2())));

  }

  // TEXTUAL
  // test an empty model view
  @Test
  public void testEmptyText() {
    text = new TextualTimeAnimatorView(new LinkedHashMap<>(), ap, 5);
    assertEquals("", text.toString());
  }

  // test the tempo at 1 tick per second
  @Test
  public void testTempo1() {
    text = new TextualTimeAnimatorView(modelR.getDirections(), ap, 1);
    assertEquals("motion R 1.00 200 200 50 100 255 0 0     1.00 200 200 50 100 255 0 0 \n"
            + "motion R 10.00 200 200 50 100 255 0 0     10.00 300 300 50 100 255 0 0 \n"
            + "motion R 50.00 300 300 50 100 255 0 0     50.00 300 300 50 100 255 0 0 \n"
            + "motion R 51.00 300 300 50 100 255 0 0     51.00 300 300 25 100 255 0 0 \n"
            + "motion R 70.00 300 300 25 100 255 0 0     70.00 200 200 25 100 255 0 0 \n"
            + "\n",
        text.toString());
  }

  // test the tempo at 10 ticks per second
  @Test
  public void testTempo10() {
    text = new TextualTimeAnimatorView(modelR.getDirections(), ap, 10);
    assertEquals("motion R 0.10 200 200 50 100 255 0 0     0.10 200 200 50 100 255 0 0 \n"
            + "motion R 1.00 200 200 50 100 255 0 0     1.00 300 300 50 100 255 0 0 \n"
            + "motion R 5.00 300 300 50 100 255 0 0     5.00 300 300 50 100 255 0 0 \n"
            + "motion R 5.10 300 300 50 100 255 0 0     5.10 300 300 25 100 255 0 0 \n"
            + "motion R 7.00 300 300 25 100 255 0 0     7.00 200 200 25 100 255 0 0 \n"
            + "\n",
        text.toString());
  }

  // test a single shape textual view
  @Test
  public void testNonEmptyText() {
    assertEquals("motion R 0.20 200 200 50 100 255 0 0     0.20 200 200 50 100 255 0 0 \n"
            + "motion R 2.00 200 200 50 100 255 0 0     2.00 300 300 50 100 255 0 0 \n"
            + "motion R 10.00 300 300 50 100 255 0 0     10.00 300 300 50 100 255 0 0 \n"
            + "motion R 10.20 300 300 50 100 255 0 0     10.20 300 300 25 100 255 0 0 \n"
            + "motion R 14.00 300 300 25 100 255 0 0     14.00 200 200 25 100 255 0 0 \n\n",
        text.toString());
  }

  // test multiple shapes in the model textual view
  @Test
  public void testMultipleShapeModel() {
    text = new TextualTimeAnimatorView(modelRE.getDirections(), ap, 5);
    assertEquals("motion R 0.20 200 200 50 100 255 0 0     0.20 200 200 50 100 255 0 0 \n"
            + "motion R 2.00 200 200 50 100 255 0 0     2.00 300 300 50 100 255 0 0 \n"
            + "motion R 10.00 300 300 50 100 255 0 0     10.00 300 300 50 100 255 0 0 \n"
            + "motion R 10.20 300 300 50 100 255 0 0     10.20 300 300 25 100 255 0 0 \n"
            + "motion R 14.00 300 300 25 100 255 0 0     14.00 200 200 25 100 255 0 0 \n"
            + "\n"
            + "motion C 1.20 440 70 120 60 0 0 255     1.20 440 70 120 60 0 0 255 \n"
            + "motion C 4.00 440 70 120 60 0 0 255     4.00 440 250 120 60 0 0 255 \n"
            + "motion C 10.00 440 250 120 60 0 0 255     10.00 440 370 120 60 0 170 85 \n"
            + "motion C 14.00 440 370 120 60 0 170 85     14.00 440 370 120 60 0 255 0 \n"
            + "motion C 16.00 440 370 120 60 0 255 0     16.00 440 370 120 60 0 255 0 \n"
            + "\n",
        text.toString());
  }

  // test null model
  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() throws IOException {
    text = new TextualTimeAnimatorView(null, ap, 5);
    text.render();
  }

  // test null appendable
  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() throws IOException {
    text = new TextualTimeAnimatorView(modelR.getDirections(), null, 5);
    text.render();
  }

  // test null appendable and model
  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendableModel() throws IOException {
    text = new TextualTimeAnimatorView(null, null, 5);
    text.render();
  }

  // test when the tempo is 0
  @Test(expected = IllegalArgumentException.class)
  public void testZeroTempo() throws IOException {
    text = new TextualTimeAnimatorView(modelR.getDirections(), ap, 0);
    text.render();
  }

  // test when the tempo is negative
  @Test(expected = IllegalArgumentException.class)
  public void testNegTempo() throws IOException {
    text = new TextualTimeAnimatorView(modelR.getDirections(), ap, -5);
    text.render();
  }

  // VISUAL view
  // test unsupported exception thrown when render() is called on the visual view
  @Test(expected = UnsupportedOperationException.class)
  public void testVisualRender() throws IOException {
    visual.render();
  }

  // INTERACTIVE view

  // Render
  // test unsupported exception thrown when render() is called on the interactive view
  @Test(expected = UnsupportedOperationException.class)
  public void testInteractiveRender() {
    interactive.render();
  }

  // GetTempo
  // test getTempo with a positive tempo
  @Test
  public void testGetTempoPositive() {
    InteractiveAnimatorView iPositive = new InteractiveAnimatorView(modelRE.getCanvas(), 5);
    assertEquals(5, iPositive.getTempo(), 0.001);
  }

  // test getTempo at tempo of 0
  @Test
  public void testGetTempoZero() {
    InteractiveAnimatorView iZero = new InteractiveAnimatorView(modelRE.getCanvas(), 0);
    assertEquals(0, iZero.getTempo(), 0.001);
  }

  // SpeedUp
  // test that speed up increases the tempo by 1
  @Test
  public void testSpeedUp() {
    assertEquals(5, interactive.getTempo(), 0.001);
    interactive.speedUp();
    assertEquals(6, interactive.getTempo(), 0.001);
  }

  // test speed up used multiple times
  @Test
  public void testSpeedUpMultiple() {
    assertEquals(5, interactive.getTempo(), 0.001);
    interactive.speedUp();
    interactive.speedUp();
    interactive.speedUp();
    interactive.speedUp();
    interactive.speedUp();
    assertEquals(10, interactive.getTempo(), 0.001);
  }

  // test an exception is thrown when speeding up at the max speed
  @Test(expected = IllegalStateException.class)
  public void testInteractiveSpeedUpAtMax() {
    interactiveMax.speedUp();
  }

  // SlowDown
  // test that slowDown the tempo by 1
  @Test
  public void testSlowDown() {
    assertEquals(5, interactive.getTempo(), 0.001);
    interactive.slowDown();
    assertEquals(4, interactive.getTempo(), 0.001);
  }

  // test slowDown used multiple times
  @Test
  public void testSlowDownMultiple() {
    assertEquals(5, interactive.getTempo(), 0.001);
    interactive.slowDown();
    interactive.slowDown();
    interactive.slowDown();
    assertEquals(2, interactive.getTempo(), 0.001);
  }

  // test an exception is thrown when speeding up at the max speed
  @Test(expected = IllegalStateException.class)
  public void testInteractiveSlowDownAtMin() {
    interactiveMin.slowDown();
  }

  ////////////////
  // CONTROLLER //
  ////////////////

  // INTERACTIVE controller

  // ExecuteAction
  // test executeAction works as expected when given the speed up command
  @Test
  public void executeActionSpeedUp() {
    assertEquals(5, iController.view.getTempo(), 0.001);
    iController.executeAction("Speed Up");
    assertEquals(6, iController.view.getTempo(), 0.001);
  }

  // test executeAction works as expected when given multiple speed up commands
  @Test
  public void executeActionSpeedUpMultiple() {
    assertEquals(5, iController.view.getTempo(), 0.001);
    iController.executeAction("Speed Up");
    iController.executeAction("Speed Up");
    iController.executeAction("Speed Up");
    assertEquals(8, iController.view.getTempo(), 0.001);
  }

  // test executeAction with the speed up command when the animation is paused
  @Test
  public void executeActionSpeedUpPaused() {
    InteractiveAnimatorController iControllerPaused = new InteractiveAnimatorController(modelRE,
        interactive, 20, true, false);
    assertEquals(5, iControllerPaused.view.getTempo(), 0.001);
    iControllerPaused.executeAction("Speed Up");
    assertEquals(6, iControllerPaused.view.getTempo(), 0.001);
  }

  // test executeAction with the speed up command when the animation is looping
  @Test
  public void executeActionSpeedUpLooping() {
    InteractiveAnimatorController iControllerLoop = new InteractiveAnimatorController(modelRE,
        interactive, 20, false, true);
    assertEquals(5, iControllerLoop.view.getTempo(), 0.001);
    iControllerLoop.executeAction("Speed Up");
    assertEquals(6, iControllerLoop.view.getTempo(), 0.001);
  }

  // test executeAction will cause an exception to be thrown when speed up is called at max speed
  @Test(expected = IllegalStateException.class)
  public void speedUpAtMax() {
    iControllerMax.executeAction("Speed Up");
  }

  // test executeAction works as expected when given the slow down command
  @Test
  public void executeActionSlowDown() {
    assertEquals(5, iController.view.getTempo(), 0.001);
    iController.executeAction("Slow Down");
    assertEquals(4, iController.view.getTempo(), 0.001);
  }

  // test executeAction works as expected when given multiple slow down commands
  @Test
  public void executeActionSlowDownMultiple() {
    assertEquals(5, iController.view.getTempo(), 0.001);
    iController.executeAction("Slow Down");
    iController.executeAction("Slow Down");
    iController.executeAction("Slow Down");
    assertEquals(2, iController.view.getTempo(), 0.001);
  }

  // test executeAction with the slow down command when the animation is paused
  @Test
  public void executeActionSlowDownPaused() {
    InteractiveAnimatorController iControllerPaused = new InteractiveAnimatorController(modelRE,
        interactive, 20, true, false);
    assertEquals(5, iControllerPaused.view.getTempo(), 0.001);
    iControllerPaused.executeAction("Slow Down");
    assertEquals(4, iControllerPaused.view.getTempo(), 0.001);
  }

  // test executeAction with the slow down command when the animation is looping
  @Test
  public void executeActionSlowDownLooping() {
    InteractiveAnimatorController iControllerLoop = new InteractiveAnimatorController(modelRE,
        interactive, 20, false, true);
    assertEquals(5, iControllerLoop.view.getTempo(), 0.001);
    iControllerLoop.executeAction("Slow Down");
    assertEquals(4, iControllerLoop.view.getTempo(), 0.001);
  }

  // test executeAction will cause an exception to be thrown when slow down is called at min speed
  @Test(expected = IllegalStateException.class)
  public void slowDownAtMin() {
    iControllerMin.executeAction("Slow Down");
  }

  // test executeAction with the restart command
  @Test
  public void executeActionRestart() {
    InteractiveAnimatorController iControllerTick20 = new InteractiveAnimatorController(modelRE,
        interactive, 20);
    assertEquals(20, iControllerTick20.tick);
    iControllerTick20.executeAction("Restart");
    assertEquals(1, iControllerTick20.tick, 0.001);
  }

  // test executeAction with the restart command at the first tick
  @Test
  public void executeActionRestartFirstTick() {
    InteractiveAnimatorController iControllerFirstTick = new InteractiveAnimatorController(modelRE,
        interactive, 1);
    assertEquals(1, iControllerFirstTick.tick);
    iControllerFirstTick.executeAction("Restart");
    assertEquals(1, iControllerFirstTick.tick, 0.001);
  }

  // test executeAction with the restart command when the animation is paused
  @Test
  public void executeActionRestartPaused() {
    InteractiveAnimatorController iControllerPaused = new InteractiveAnimatorController(modelRE,
        interactive, 20, true, false);
    assertEquals(20, iControllerPaused.tick);
    iControllerPaused.executeAction("Restart");
    assertEquals(1, iControllerPaused.tick, 0.001);
  }

  // test executeAction with the restart command when the animation is looping
  @Test
  public void executeActionRestartLooping() {
    InteractiveAnimatorController iControllerLoop = new InteractiveAnimatorController(modelRE,
        interactive, 20, false, true);
    assertEquals(20, iControllerLoop.tick);
    iControllerLoop.executeAction("Restart");
    assertEquals(1, iControllerLoop.tick, 0.001);
  }

  // test executeAction with the loop command when the animation is looping
  @Test
  public void executeActionDisableLoop() {
    InteractiveAnimatorController iControllerLoop = new InteractiveAnimatorController(modelRE,
        interactive, 20, false, true);
    assertEquals(true, iControllerLoop.loop);
    iControllerLoop.executeAction("Loop");
    assertEquals(false, iControllerLoop.loop);
  }

  // test executeAction with the loop command when the animation is looping and paused
  @Test
  public void executeActionDisableLoopPaused() {
    InteractiveAnimatorController iControllerLoop = new InteractiveAnimatorController(modelRE,
        interactive, 20, true, true);
    assertEquals(true, iControllerLoop.loop);
    iControllerLoop.executeAction("Loop");
    assertEquals(false, iControllerLoop.loop);
  }

  // test executeAction with the loop command when the animation is not looping
  @Test
  public void executeActionEnableLoop() {
    InteractiveAnimatorController iControllerNoLoop = new InteractiveAnimatorController(modelRE,
        interactive, 20, false, false);
    assertEquals(false, iControllerNoLoop.loop);
    iControllerNoLoop.executeAction("Loop");
    assertEquals(true, iControllerNoLoop.loop);
  }

  // test executeAction with the loop command when the animation is not looping and paused
  @Test
  public void executeActionEnableLoopPaused() {
    InteractiveAnimatorController iControllerNoLoop = new InteractiveAnimatorController(modelRE,
        interactive, 20, true, false);
    assertEquals(false, iControllerNoLoop.loop);
    iControllerNoLoop.executeAction("Loop");
    assertEquals(true, iControllerNoLoop.loop);
  }

  // ExecuteKey
  // test executeKey with a space bar press can pause a playing animation
  @Test
  public void executeKeyPause() {
    InteractiveAnimatorController iControllerPlaying = new InteractiveAnimatorController(modelRE,
        interactive, 20, false, false);
    assertEquals(false, iControllerPlaying.paused);
    iControllerPlaying.executeKey(32);
    assertEquals(true, iControllerPlaying.paused);
  }

  // test executeKey with a space bar press can pause a playing animation when looping
  @Test
  public void executeKeyPauseWithLoop() {
    InteractiveAnimatorController iControllerPlaying = new InteractiveAnimatorController(modelRE,
        interactive, 20, false, true);
    assertEquals(false, iControllerPlaying.paused);
    iControllerPlaying.executeKey(32);
    assertEquals(true, iControllerPlaying.paused);
  }

  // test executeKey with a space bar press can resume a paused animation
  @Test
  public void executeKeyResume() {
    InteractiveAnimatorController iControllerPaused = new InteractiveAnimatorController(modelRE,
        interactive, 20, true, false);
    assertEquals(true, iControllerPaused.paused);
    iControllerPaused.executeKey(32);
    assertEquals(false, iControllerPaused.paused);
  }

  // test executeKey with a space bar press can resume a paused animation
  @Test
  public void executeKeyResumeWithLoop() {
    InteractiveAnimatorController iControllerPaused = new InteractiveAnimatorController(modelRE,
        interactive, 20, true, true);
    assertEquals(true, iControllerPaused.paused);
    iControllerPaused.executeKey(32);
    assertEquals(false, iControllerPaused.paused);
  }

  // test executeKey with a space bar press can start a paused animation at the first tick
  @Test
  public void executeKeyStart() {
    InteractiveAnimatorController iControllerPaused = new InteractiveAnimatorController(modelRE,
        interactive, 1, true, false);
    assertEquals(true, iControllerPaused.paused);
    iControllerPaused.executeKey(32);
    assertEquals(false, iControllerPaused.paused);
  }

  // test executeKey with a space bar press can start a paused animation at the first tick
  @Test
  public void executeKeyStartWithLoop() {
    InteractiveAnimatorController iControllerPaused = new InteractiveAnimatorController(modelRE,
        interactive, 1, true, true);
    assertEquals(true, iControllerPaused.paused);
    iControllerPaused.executeKey(32);
    assertEquals(false, iControllerPaused.paused);
  }

}
