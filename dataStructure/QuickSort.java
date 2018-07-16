import java.util.Arrays;

public class QuickSort {

  public static <T extends Comparable<? super T>> void sort(T[] array) {
    sort(array, 0, array.length-1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] array, int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);
      sort(array, low, pi-1); // before pivot
      sort(array, pi+1, high); // after pivot
    }
  }

  private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {
    // randomly pick pivot
    swap(array, low, (int)(Math.random() * (high - low + 1)) + low);
    T pivot = array[low];

    int i = low + 1;
    int j = high;
    while (i <= j) {
      if (array[i].compareTo(pivot) <= 0) {
        i++;
      } else {
        // swap
        swap(array, i, j);
        j--;
      }
    }

    // put pivot to right position
    array[low] = array[j];
    array[j] = pivot;
    return j;
  }

  private static <T> void swap(T[] arr, int x, int y) {
    T tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }

}
