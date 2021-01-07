package cs3500.animator.util;

import java.io.IOException;

/**
 * Utility functions that are used by different views.
 */
public class ViewUtil {

  /**
   * Writes the given string to the appendable output, and converts any {@link IOException} thrown
   * to an {@link IllegalStateException}.
   *
   * @param str the string
   * @throws IllegalStateException if there is an IO exception
   */
  public static void append(String str, Appendable output) throws IllegalStateException {
    try {
      output.append(str);
    } catch (IOException ioException) {
      throw new IllegalStateException("Could not write to output.");
    }
  }

  /**
   * Converts the given tick into seconds elapsed, given the speed (as ticks-per-second).
   *
   * @param tick  the tick
   * @param speed the speed, in ticks per second
   * @return the time elapsed, in seconds
   */
  public static double toSeconds(int tick, int speed) {
    return (1.0 / speed) * tick;
  }
}
