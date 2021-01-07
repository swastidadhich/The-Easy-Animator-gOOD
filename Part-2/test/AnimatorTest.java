
import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.Motion2D;
import cs3500.animator.model.Shape2D;
import cs3500.animator.view.AnimatorView;
import cs3500.animator.view.SVGAnimatorView;
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

  @Before
  public void setUp() throws Exception {

    rect = new Shape2D("R", "rectangle");
    circle = new Shape2D("C", "circle");

    mR1 = new Motion2D("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    mR2 = new Motion2D("R",10,200, 200, 50, 100, 255, 0,  0,
            50,  300, 300, 50, 100, 255, 0 ,0);
    mC1 = new Motion2D("C",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);

    directionsR = new LinkedHashMap<>();
    directionsR.put(rect, new ArrayList<>(Arrays.asList(mR1)));

    builder = new EasyAnimatorModel.Builder();

    modelR = new EasyAnimatorModel();
    modelR.addShape("R", "rectangle");
    modelR.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    modelR.addMotion("R",10,200, 200, 50, 100, 255, 0,  0,
            50,  300, 300, 50, 100, 255, 0 ,0);
    modelR.addMotion("R",50,300, 300, 50, 100, 255, 0,  0,
            51,  300, 300, 50, 100, 255, 0 ,0);
    modelR.addMotion("R",51,300, 300, 50, 100, 255, 0,  0,
            70,  300, 300, 25, 100, 255, 0 ,0);
    modelR.addMotion("R",70,300, 300, 25, 100, 255, 0,  0,
            100,  200, 200, 25, 100, 255, 0 ,0);

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
    modelRE.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    modelRE.addMotion("R",10,200, 200, 50, 100, 255, 0,  0,
            50,  300, 300, 50, 100, 255, 0 ,0);
    modelRE.addMotion("R",50,300, 300, 50, 100, 255, 0,  0,
            51,  300, 300, 50, 100, 255, 0 ,0);
    modelRE.addMotion("R",51,300, 300, 50, 100, 255, 0,  0,
            70,  300, 300, 25, 100, 255, 0 ,0);
    modelRE.addMotion("R",70,300, 300, 25, 100, 255, 0,  0,
            100,  200, 200, 25, 100, 255, 0 ,0);
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
    modelC.addMotion("C",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);

    modelEmpty = new EasyAnimatorModel();

    ap = System.out;
    svg = new SVGAnimatorView(modelR, new FileWriter("out.svg"), 5);
    text = new TextualTimeAnimatorView(modelR, ap, 5);
    visual = new VisualAnimatorView(modelR, 5);
  }

  // ANIMATOR MODEL

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
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), modelEmpty.getMotionsFromShape(rect));
  }

  // test that addMotion correctly adds multiple motions to the model
  @Test
  public void testAddMultipleMotions() {
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    modelEmpty.addMotion("R",10,200, 200, 50, 100, 255, 0,  0,
            50,  300, 300, 50, 100, 255, 0 ,0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1, mR2)), modelEmpty.getMotionsFromShape(rect));
  }

  // test that addMotion correctly adds motions to different shapes
  @Test
  public void testAddMotionsMultipleShapes() {
    modelEmpty.addShape("R", "rectangle");
    modelEmpty.addShape("C", "circle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    modelEmpty.addMotion("C",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), modelEmpty.getMotionsFromShape(rect));
    assertEquals(new ArrayList<>(Arrays.asList(mC1)), modelEmpty.getMotionsFromShape(circle));
  }

  // test that addMotion throws an exception if the shape with in the motion name has not been added
  @Test(expected = IllegalArgumentException.class)
  public void testNoMatchingShape() {
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
  }

  // test that addMotion throws an exception if ticks in the motion overlap with already added ones
  @Test(expected = IllegalArgumentException.class)
  public void testTickOverlap() {
    modelR.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            5,  200, 200, 50, 100, 255, 0 ,0);
  }

  // test that addMotion throws an exception if tick1 is greater than tick2
  @Test(expected = IllegalArgumentException.class)
  public void testTick1GreaterThan2() {
    modelR.addMotion("R",10,200, 200, 50, 100, 255, 0,  0,
            5,  200, 200, 50, 100, 255, 0 ,0);
  }

  // test that addMotion throws an exception if the motion being added has a different state at a
  // shared tick with an already added one
  @Test(expected = IllegalArgumentException.class)
  public void testDifferentStateSameTick() {
    modelR.addMotion("R",100,  200, 200, 25, 100, 255, 0 ,99,
            105,  200, 200, 50, 100, 255, 0 ,0);
  }

  // test that addMotion throws an exception if a tick is negative
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeTick() {
    modelR.addMotion("R",-10,200, 200, 50, 100, 255, 0,  0,
            5,  200, 200, 50, 100, 255, 0 ,0);
  }

  // test that addMotion throws an exception if the name is null
  @Test(expected = IllegalArgumentException.class)
  public void testNullMotionName() {
    modelR.addMotion(null,150,200, 200, 50, 100, 255, 0,  0,
            200,  200, 200, 50, 100, 255, 0 ,0);
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
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    modelEmpty.addMotion("C",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), modelEmpty.getMotionsFromShape(rect));
    assertEquals(new ArrayList<>(Arrays.asList(mC1)), modelEmpty.getMotionsFromShape(circle));
  }

  // test that getMotionsFromShape throws an exception if given null
  @Test(expected = IllegalArgumentException.class)
  public void testNullShape() {
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    modelEmpty.getMotionsFromShape(null);
  }

  // test that getMotionsFromShape throws an exception if the given shape has not been added
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotAdded() {
    modelEmpty.addShape("R", "rectangle");
    assertEquals(new ArrayList<>(), modelEmpty.getMotionsFromShape(rect));
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    modelEmpty.getMotionsFromShape(circle);
  }

  // initCanvas
  // test that initCanvas correctly initializes the canvas
  @Test
  public void testInitCanvas() {
    modelEmpty.initCanvas(1, 2, 500, 1000);
    assertEquals(1, modelEmpty.getCanvasX());
    assertEquals(2, modelEmpty.getCanvasY());
    assertEquals(500, modelEmpty.getCanvasWidth());
    assertEquals(1000, modelEmpty.getCanvasHeight());
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

  // test getCanvasX
  @Test
  public void testGetCanvasX() {
    modelEmpty.initCanvas(10, 2, 500, 1000);
    assertEquals(10, modelEmpty.getCanvasX());
  }

  // test getCanvasY
  @Test
  public void testGetCanvasY() {
    modelEmpty.initCanvas(10, 2, 500, 1000);
    assertEquals(2, modelEmpty.getCanvasY());
  }

  // test getCanvasWidth
  @Test
  public void testGetCanvasWidth() {
    modelEmpty.initCanvas(10, 2, 500, 1000);
    assertEquals(500, modelEmpty.getCanvasWidth());
  }

  // test getCanvasX
  @Test
  public void testGetCanvasHeight() {
    modelEmpty.initCanvas(10, 2, 500, 1000);
    assertEquals(1000, modelEmpty.getCanvasHeight());
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
    modelEmpty.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
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
    builder.addMotion("C",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    assertEquals(modelC.getDirections(), builder.build().getDirections());
  }

  // setBounds
  // test that the builder can correctly set the bounds
  @Test
  public void testSetBounds() {
    assertEquals(0, builder.build().getCanvasX());
    assertEquals(0, builder.build().getCanvasY());
    assertEquals(1000, builder.build().getCanvasWidth());
    assertEquals(1000, builder.build().getCanvasHeight());
    builder.setBounds(1, 2, 3, 4);
    assertEquals(1, builder.build().getCanvasX());
    assertEquals(2, builder.build().getCanvasY());
    assertEquals(3, builder.build().getCanvasWidth());
    assertEquals(4, builder.build().getCanvasHeight());
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
    builder.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1)), builder.build().getMotionsFromShape(rect));
  }

  // test that addMotion correctly adds multiple motions to the model
  @Test
  public void testAddMultipleMotionsBuilder() {
    builder.declareShape("R", "rectangle");
    assertEquals(new ArrayList<>(), builder.build().getMotionsFromShape(rect));
    builder.addMotion("R",1,200, 200, 50, 100, 255, 0,  0,
            10,  200, 200, 50, 100, 255, 0 ,0);
    builder.addMotion("R",10,200, 200, 50, 100, 255, 0,  0,
            50,  300, 300, 50, 100, 255, 0 ,0);
    assertEquals(new ArrayList<>(Arrays.asList(mR1, mR2)),
            builder.build().getMotionsFromShape(rect));
  }


  // ANIMATOR VIEW

  // Testing SVG

  @Test(expected = NullPointerException.class)
  public void testSVG() throws IOException {
    svg = new SVGAnimatorView(null, new FileWriter("out.svg"), 5);
    svg.render();
  }

  @Test
  public void testSVGEmpty() {
    try {
      svg = new SVGAnimatorView(modelEmpty, new FileWriter("out.svg"), 20);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("", svg.toString());
  }

  @Test
  public void testFalseSVGEmpty() {
    try {
      svg = new SVGAnimatorView(modelEmpty, new FileWriter("out.svg"), 20);
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
      svg = new SVGAnimatorView(modelR, new FileWriter("out.svg"), 20);
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
      svg = new SVGAnimatorView(modelR, new FileWriter("out.svg"), 20);
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
      svg = new SVGAnimatorView(modelEllipse, new FileWriter("out.svg"), 20);
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
      svg = new SVGAnimatorView(modelEllipse, new FileWriter("out.svg"), 20);
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
                    + "to=\"200 200\" begin=\"14.0s\" dur=\"6.0s\" fill=\"freeze\" />" + "\n",
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
                    + "from=\"200 200\" to=\"200 200\" begin=\"1.0s\" dur=\"10.0s\" " +
                    "fill=\"freeze\" />" + "\n",
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

  // Textual
  // test an empty model view
  @Test
  public void testEmptyText() {
    text = new TextualTimeAnimatorView(modelEmpty, ap, 5);
    assertEquals("", text.toString());
  }

  // test the tempo at 1 tick per second
  @Test
  public void testTempo1() {
    text = new TextualTimeAnimatorView(modelR, ap, 1);
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
    text = new TextualTimeAnimatorView(modelR, ap, 10);
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
    text = new TextualTimeAnimatorView(modelRE, ap, 5);
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
    text = new TextualTimeAnimatorView(modelR, null, 5);
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
    text = new TextualTimeAnimatorView(modelR, ap, 0);
    text.render();
  }

  // test when the tempo is negative
  @Test(expected = IllegalArgumentException.class)
  public void testNegTempo() throws IOException {
    text = new TextualTimeAnimatorView(modelR, ap, -5);
    text.render();
  }

}
