/**
 * Fisher–Yates shuffle (Knuth Shuffle)
 *
 * @author yuzheng
 */
public class Shuffle {

  public static <T> void shuffle(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int j = (int)(Math.random() * (i + 1));
      T tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
  }
}

