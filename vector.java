public class vector{
    public double x, y;
    vector()
    {
        x = 0; 
        y = 0;
    }
    vector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public void add(vector v1)
    {
        x += v1.x;
        y += v1.y;
    }

    public static vector calcVelocity(vector initialVelocity, vector acceleration, double seconds)
    {
        vector v1 = new vector();
        v1.x = initialVelocity.x + acceleration.x * seconds;
        v1.y = initialVelocity.y + acceleration.y * seconds;
        return v1;
    }
    public static vector calcDistance(vector initialVelocity, vector acceleration, double seconds)
    {
        vector v1 = new vector();
        v1.x = initialVelocity.x * seconds + acceleration.x * seconds * seconds / 2;
        v1.y = initialVelocity.y * seconds + acceleration.y * seconds * seconds / 2;
        return v1;
    }

    public static vector setVector(double x, double y)
    {
        vector v = new vector();
        v.x = x;
        v.y = y;
        return v;
    }
    public vector rotateBy(double angle)
    {
        vector tmp = new vector();
        tmp.x = Math.cos(angle) * this.x - Math.sin(angle) * this.y;
        tmp.y = Math.sin(angle) * this.x + Math.cos(angle) * this.y;
        return tmp;
    }
}