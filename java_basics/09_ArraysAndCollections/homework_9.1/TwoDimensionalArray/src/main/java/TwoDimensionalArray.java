public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] newChar = new char[size][size];
        int length = newChar.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                boolean checker = (i == j || i == length - 1 - j);
                newChar[i][j] = (checker) ? symbol : ' ';
                newChar[i][length - 1 - j] = (checker) ? symbol : ' ';
            }
        }
//         TODO: Написать метод, который создаст двумерный массив char заданного размера.
//          массив должен содержать символ symbol по диагоналям, пример для size = 3
//          [X,  , X]
//          [ , X,  ]
//          [X,  , X]

        return newChar;
    }
}
