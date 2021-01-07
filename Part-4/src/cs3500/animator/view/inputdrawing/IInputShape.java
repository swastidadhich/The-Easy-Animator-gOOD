package cs3500.animator.view.inputdrawing;

/**
 * An interface to represent the Input Shapes which help with generation of a txt file.
 */

public interface IInputShape {

  /**
   * This is a helper method which creates the animation input by adding the list of motion and
   * passes it file generator.
   */

  void createAnimation();

  /**
   * This is a helper method which uses the declared shape (reconigsed by its id) and adds it to the
   * input file.
   *
   * @param id identification tag for the shape
   */

  void declareShapes(int id);

}
