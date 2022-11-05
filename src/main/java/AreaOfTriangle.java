public class AreaOfTriangle {
    public double areaOfTriangle(int a, int b, int c) throws IsNotTriangleException {
        if (a<=0 || b<=0 || c<=0) throw new IsNotTriangleException("Это не треугольник!");
        if (a+b<c || a+c<b||b+c<a) throw new IsNotTriangleException("Не может существовать треугольник с такими сторонами!");
        double p=(a+b+c)/2.0;
        double value =  Math.sqrt(p*(p-a)*(p-b)*(p-c));
        double scale = Math.pow(10, 3);
        double result = Math.ceil(value * scale) / scale;
        return result;
    }
}
