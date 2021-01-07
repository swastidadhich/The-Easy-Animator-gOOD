package cs3500.animator.view;

/**
 * Class which defines a tempo for a specified tick interval.
 */
public class SpeedInterval {

  protected int t1;
  protected int t2;
  protected double tempo;

  /**
   * Constructs a SpeedInterval with a tick1, tick2, and tempo.
   * @param t1 tick1
   * @param t2 tick2
   * @param tempo tempo
   */
  public SpeedInterval(int t1, int t2, double tempo) {
    this.t1 = t1;
    this.t2 = t2;
    this.tempo = tempo;
  }

  /**
   * Returns the starting tick.
   * @return tick1
   */
  protected int getT1() {
    return t1;
  }

  /**
   * Returns the final tick.
   * @return tick2
   */
  protected int getT2() {
    return t2;
  }

  /**
   * Returns the tempo.
   * @return tempo
   */
  protected double getTempo() {
    return tempo;
  }

}
