import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day18 {


    /**
     * Rotate an array by n positions.
     *
     * @param array the input array
     * @param n number of positions to rotate; positive => right rotation, negative => left rotation
     * @param <T> element type
     * @return a new rotated array (or null if input is null)
     */
    public static <T> T[] rotateArray(T[] array, int n) {
        if (array == null) {
            throw new IllegalArgumentException("array must not be null");
        }

        return usingArrayCopy(array, n);
    }

    private static <T> T[] usingArrayCopy(T[] array, int n) {
        int len = array.length;

        if(len < 2) {
            return array.clone();
        }

        @SuppressWarnings("unchecked")
        //use this reflection api method of creating a new array to ensure the underlying elements are instances of T
        T[] returnArray =  (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

        // This bit gave me trouble, using the remainder operator normalizing n to a right-rotation value between 0 and len
        // whether positive or negative
        int shift = ((n % len) + len) % len;

        //copy last shift items to the start
        System.arraycopy(array, len - shift, returnArray, 0, shift);

        //copy remaining items to the end
        System.arraycopy(array, 0, returnArray, shift, len - shift);

        return returnArray;
    }

    private static <T> T[] usingCollectionsAPI(T[] array, int n) {
        if (array == null) return null;
        int len = array.length;

        if (len < 2) {
            return Arrays.copyOf(array, len);
        }

        List<T> list = new ArrayList<>(Arrays.asList(array));
        Collections.rotate(list, n);

        return list.toArray(Arrays.copyOf(array, 0));
    }

    private static <T> T[] usingStreams(T[] array, int n) {
        if (array == null) return null;
        int len = array.length;

        if (len < 2) {
            return Arrays.copyOf(array, len);
        }

        java.util.List<T> list = new ArrayList<>(Arrays.asList(array));
        java.util.Collections.rotate(list, n);
        return list.toArray(Arrays.copyOf(array, 0));
    }
}
