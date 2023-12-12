/*
 * line be like ax + by + c = 0
 * -a/b = m;
 */
public class line extends shapes
{
    point start,end;
    double a,b,c;
    boolean finiteLine;
    line(point q1, point q2)
    {
        start = q1;
        end = q2;
        finiteLine = true;
        a = start.y - end.y;
        b = start.x - end.x;
        c = -a * start.x - b * end.y;
    }
    line(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        finiteLine = false;
    }
    public double lineLenght()
    {
        return start.distanceFrom(end);
    }
}