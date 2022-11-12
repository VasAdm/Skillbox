import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class LoaderMultiThreading implements Runnable {
    private static final char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
    private final List<Integer> regCodes;

    public LoaderMultiThreading(List<Integer> regCodes) {
        this.regCodes = regCodes;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            for (Integer regCode : regCodes) {

                FileOutputStream outputStream = new FileOutputStream("res/region_" + regCode + ".txt");
                BufferedOutputStream writer = new BufferedOutputStream(outputStream);

                for (char firstLetter : letters) {
                    StringBuilder builder = new StringBuilder();
                    for (int number = 1; number < 1000; number++) {

                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {

                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(regCode, 2));
                                builder.append(System.lineSeparator());
                            }
                        }
                    }
                    writer.write(builder.toString().getBytes());
                }
                writer.flush();
                writer.close();

            } //regCodeEnd

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " +(System.currentTimeMillis() - start) + " ms");

    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }
        return numberStr.toString();
    }
}
