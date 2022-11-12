public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (4.0 / 3) * Math.PI * Math.pow(Math.abs(radius), 3);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = (a + b + c) /2;
        return !isTrianglePossible(a, b, c) ? -1 : Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
