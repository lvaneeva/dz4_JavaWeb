public class IsNotTriangleException extends Exception {
    public IsNotTriangleException(String error) {
        super(error);
        System.out.println("Это не треугольник");
    }
}
