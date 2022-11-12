public class Arithmetic {
    private int x = 0;
    private int y = 0;

    public static int Summarization (int x, int y) {
        return (x + y);
    }

    public static int Multiplication (int x, int y) {
        return (x * y);
    }

    public static int Max (int x, int y) {
        return(Math.max(x,y));
//        return (x >= y ? x : y);
    }

    public static int Min (int x, int y) {
        return(Math.min(x,y));
//        return (x <= y ? x : y);
    }

    public Arithmetic(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
