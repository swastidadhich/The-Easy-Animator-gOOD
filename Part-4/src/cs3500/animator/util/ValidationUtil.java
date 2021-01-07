package cs3500.animator.util;

/**
 * Utility functions that can validate inputs when it is required.
 */
public class ValidationUtil {

  /**
   * Ensures that the given number is non-negative.
   *
   * @param n the number
   * @return the number, validated
   * @throws IllegalArgumentException if the number is negative
   */
  public static int ensureNonNegative(int n) throws IllegalArgumentException {
    if (n < 0) {
      throw new IllegalArgumentException("n is negative.");
    }
    return n;
  }

  /**
   * Ensures that the given number is in the range {@code [lower, upper)}.
   *
   * @param lower the lower bound of the range, inclusive
   * @param n     the number
   * @param upper the upper bound of the range, exclusive
   * @return the number, validated
   * @throws IllegalArgumentException if the number is outside the range
   */
  public static int ensureInRange(int lower, int n, int upper) throws IllegalArgumentException {
    if (!(lower <= n && n < upper)) {
      throw new IllegalArgumentException("n is outside the given range.");
    }
    return n;
  }
}
