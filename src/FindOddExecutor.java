import java.util.ArrayList;
import java.util.LinkedHashSet;

public class FindOddExecutor {

    private static LinkedHashSet numberTimes;

    public static int findIt(int[] a) {
        readArray(a);
        int size = numberTimes.size();
        return getNumber(size);
    }

    private static int getNumber(int size) {
        return (int) new ArrayList<>(numberTimes).get(size - 1);
    }

    private static void readArray(int[] a) {
        int length = a.length;
        numberTimes = new LinkedHashSet();
        if (length > 1) {
            for (int i = 0; i < length; i++) {
                int times = 0;
                for (int j = 1; j < length; j++) {
                    if (a[i] == a[j]) {
                        times++;
                    }
                }
                validateOdd(a, i, times);
            }
            System.out.println(numberTimes);
        } else {
            numberTimes.add(a[0]);
        }
    }

    private static void validateOdd(int[] a, int i, int times) {
        if (times % 2 != 0) {
            numberTimes.add(a[i]);
        }
    }

    public static void main(String args[]) {
        //System.out.println(findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        //System.out.println(findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        //System.out.println(findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        //System.out.println(findIt(new int[]{10}));
        //System.out.println(findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        System.out.println(findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}
