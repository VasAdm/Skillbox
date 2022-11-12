public class Main {
    public static void main(String[] args) {
        char[][] array = TwoDimensionalArray.getTwoDimensionalArray(100);

        for (char[] chars : array) {
            for (char symbol : chars) System.out.print(symbol);
            System.out.println();
        }
    }
}
