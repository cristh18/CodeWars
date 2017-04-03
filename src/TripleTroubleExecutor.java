import java.util.ArrayList;
import java.util.List;

public class TripleTroubleExecutor {

    private static int counter;
    private static boolean existNumberInRepetitions;
    private static List<RepeatedNumber> repetitionsNumberOne;
    private static List<RepeatedNumber> repetitionsNumberTwo;

    public TripleTroubleExecutor() {
        this.counter = 1;
    }

    public static void main(String[] args) {
        TripleTroubleExecutor tripleTroubleExecutor = new TripleTroubleExecutor();
        tripleDouble(451999277L, 41177722899L);
        //tripleDouble(1222345, 12345);
        //tripleDouble(12345, 12345);
    }

    private static int tripleDouble(long num1, long num2) {
        fillRepetitionArrays(num1, num2);
        return compareArrayElements();
    }

    private static void fillRepetitionArrays(long num1, long num2) {
        repetitionsNumberOne = getNumberMatches(readNumber(num1), repetitionsNumberOne);
        repetitionsNumberOne.removeIf(repeatedNumber -> repeatedNumber.times == 2);
        System.out.println("\n");
        repetitionsNumberTwo = getNumberMatches(readNumber(num2), repetitionsNumberTwo);
        repetitionsNumberTwo.removeIf(repeatedNumber -> repeatedNumber.times == 3);

        System.out.println("\n========================================");
        readRepetitions(repetitionsNumberOne);
        System.out.println("\n");
        readRepetitions(repetitionsNumberTwo);
    }

    private static String readNumber(long number) {
        String numberValue = String.valueOf(number);
        StringBuilder numberText = new StringBuilder();
        int length = numberValue.length();
        for (int i = 0; i < length; i++) {
            int specificNumber = Integer.parseInt(String.valueOf(numberValue.charAt(i)));
            System.out.print(specificNumber);
            numberText.append(String.valueOf(numberValue.charAt(i)));
        }
        return numberText.toString();
    }

    private static List<RepeatedNumber> getNumberMatches(String number, List<RepeatedNumber> repetitionsArray) {
        int length = number.length();
        int repeatedNumber;
        repetitionsArray = new ArrayList<>();
        resetCounter();
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                if (Integer.parseInt(String.valueOf(number.charAt(i))) == Integer.parseInt(String.valueOf(number.charAt(i + 1)))
                        && counter < 3) {
                    counter++;
                    repeatedNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
                    saveRepeatedNumbers(repetitionsArray, repeatedNumber);
                } else {
                    resetCounter();
                }
            }
        }
        return repetitionsArray;
    }

    private static void saveRepeatedNumbers(List<RepeatedNumber> repetitionsArray, int repeatedNumber) {
        int indexOfRepeatedNumberInArray = indexOfRepeatedNumberInArray(repetitionsArray, repeatedNumber);
        if (existNumberInRepetitions) {
            RepeatedNumber repeatedNumberExisting = repetitionsArray.get(indexOfRepeatedNumberInArray);
            repeatedNumberExisting.times = counter;
            repetitionsArray.set(indexOfRepeatedNumberInArray, repeatedNumberExisting);
        } else {
            repetitionsArray.add(new RepeatedNumber(repeatedNumber, counter));
        }
    }

    private static void resetCounter() {
        counter = 1;
    }

    private static void readRepetitions(List<RepeatedNumber> repetitionsArray) {
        for (RepeatedNumber repeatedNumber : repetitionsArray) {
            System.out.println("Number: " + repeatedNumber.number + ", Times: " + repeatedNumber.times);
        }
    }

    private static int indexOfRepeatedNumberInArray(List<RepeatedNumber> repetitionsArray, int number) {
        existNumberInRepetitions = false;
        int index = 0;
        int size = repetitionsArray.size();
        for (int i = 0; i < size; i++) {
            if (repetitionsArray.get(i).number == number) {
                existNumberInRepetitions = true;
                index = i;
            }
        }
        return index;
    }

    private static int compareArrayElements() {
        int isTripleDouble = 0;
        if (repetitionsNumberOne != null && !repetitionsNumberOne.isEmpty()) {
            for (RepeatedNumber aRepetitionsNumberOne : repetitionsNumberOne) {
                if (repetitionsNumberTwo != null && !repetitionsNumberTwo.isEmpty()) {
                    for (RepeatedNumber aRepetitionsNumberTwo : repetitionsNumberTwo) {
                        if (aRepetitionsNumberOne.number == aRepetitionsNumberTwo.number) {
                            isTripleDouble = 1;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("isTripleDouble: " + isTripleDouble);
        return isTripleDouble;
    }

    static class RepeatedNumber {
        int number;
        int times;

        public RepeatedNumber(int number, int times) {
            this.number = number;
            this.times = times;
        }
    }

}
