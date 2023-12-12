public class point {
    public double x;
    public double y;
    point()
    {
        x = 0; 
        y = 0;
    }
    point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    double distanceFrom(point p1)
    {
        return Math.sqrt((x - p1.x)*(x - p1.x) + (y - p1.y) * (y - p1.y));
    }
}
