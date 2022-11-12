import type.SortType;

import java.util.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */
    private static String state = "";
    private static String searchTypeName = "";
    private static long start = 0;
    private static long end = 0;
    private static final ArrayList<String> baseList= new ArrayList<>(CoolNumbers.generateCoolNumbers());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите номер автомобиля");

            String number = scanner.nextLine();

            checkType(SortType.BRUTE, number);
            checkType(SortType.BINARY, number);
            checkType(SortType.HASH, number);
            checkType(SortType.TREE, number);
        }
    }

    private static void checkType(SortType type, String number) {
        switch (type) {
            case BRUTE:
                searchTypeName = "Поиск перебором: ";
                bruteSearch(number);
                break;
            case BINARY:
                searchTypeName = "Бинарный поиск: ";
                sortedSearch(number);
                break;
            case HASH:
                searchTypeName = "Поиск в HashSet: ";
                hashSearch(number);
                break;
            case TREE:
                searchTypeName = "Поиск в TreeSet: ";
                treeSearch(number);
                break;
        }
    }

    private static void bruteSearch(String number) {
        ArrayList<String> list = new ArrayList<>(baseList);

        start = System.nanoTime();
        boolean bruteForceSearch = CoolNumbers.bruteForceSearchInList(list, number);
        end = System.nanoTime() - start;
        state = bruteForceSearch ? "найден" : "не найден";
        printResult();
    }

    private static void sortedSearch(String number) {
        List<String> sortedList = new ArrayList<>(baseList);
        Collections.sort(sortedList);

        start = System.nanoTime();
        boolean binarySearch = CoolNumbers.binarySearchInList(sortedList, number);
        end = System.nanoTime() - start;
        state = binarySearch ? "найден" : "не найден";
        printResult();
    }

    private static void hashSearch(String number) {
        HashSet<String> hashSet = new HashSet<>(baseList);

        start = System.nanoTime();
        boolean searchInHashSet = CoolNumbers.searchInHashSet(hashSet, number);
        end = System.nanoTime() - start;
        state = searchInHashSet ? "найден" : "не найден";
        printResult();
    }

    private static void treeSearch(String number) {
        TreeSet<String> treeSet = new TreeSet<>(baseList);

        start = System.nanoTime();
        boolean searchInTreeSet = CoolNumbers.searchInTreeSet(treeSet, number);
        end = System.nanoTime() - start;
        state = searchInTreeSet ? "найден" : "не найден";
        printResult();
    }

    private static void printResult() {
        System.out.println(searchTypeName + "номер " + state + " , поиск занял " + end + "нс");
    }
}
