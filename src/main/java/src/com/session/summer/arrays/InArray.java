package src.com.session.summer.arrays;

public interface InArray {
     int sumOfArrays (int[] firstArray, int[] secondArray);

     default int[] increaseArray(int[] array, int length) {
          int[] newArray = new int[length];
          System.arraycopy(array, 0, newArray, 0, array.length);
          return newArray;
     }
}
