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
    {   //throw exception if q1 and q2 are the same point.
        start = q1;
        end = q2;
        finiteLine = true;
        a = start.y - end.y;
        b = start.x - end.x;
        c = -a * start.x - b * end.y;
    }
    line(double a, double b, double c)
    {
        // if a, b are set to 0 throw an exception
        this.a = a;
        this.b = b;
        this.c = c;
        finiteLine = false;
    }
    public double lineLenght()
    {
        return start.distanceTo(end);
    }
    public double getAngle()  //returns angle between line and x-axis
    {
        return Math.atan2(a,b);
    }
    boolean intersects(circle c)
    {
        if(distanceToCircle(c) <= 0)
            return true;
        else return false;
    }
    double distanceToCircle(circle c)
    {
        return ((this.a * c.center.x) + (this.b * c.center.y) + this.c) / Math.sqrt(a * a + b * b) - c.radius;
    }
    point IntersectionPoint(line l1)
    {
        point tmp = new point(0,0);         //include exception for division by 0 here
        tmp.x = (this.b * l1.c - l1.b * this.c) / (this.a * l1.b - l1.a * this.b);
        tmp.y = (l1.a * this.c - this.a - l1.c) / (this.a * l1.b - l1.a * this.b);
        return tmp;
    }
}
