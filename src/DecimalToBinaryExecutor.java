public class DecimalToBinaryExecutor {

    public static void main(String args[]) {
        countBits(1234);
    }

    public static int countBits(int n) {
        int bitsNumber = 0;
        if (n > 0) {
            while (n > 0) {
                double res = ((double) n) / 2;
                System.out.println(res);
                if (!((res == Math.floor(res)) && !Double.isInfinite(res))) {
                    bitsNumber++;
                }
                n = (int) Math.floor(res);
            }
        }
        System.out.println(bitsNumber);
        return bitsNumber;
    }
}
