public class KataExecutor {

    public static void main(String[] args) {
        System.out.println(TripleDouble(451999277L, 41177722899L));
    }

    public static int TripleDouble(long num1, long num2)
    {
        System.out.println(hasRepeat(num1, 3));
        System.out.println(hasRepeat(num2, 2));
        return hasRepeat(num1, 3) && hasRepeat(num2, 2) ? 1 : 0;
    }

    public static boolean hasRepeat(long num, int times) {
        Long old = null;
        int t = 0;
        while (num > 0) {
            Long n = num % 10;
            num /= 10;
            if (n == old) {
                if (++t == times) return true;
            } else {
                old = n;
                t = 1;
            }
        }
        return false;
    }

}
