public class surface extends immovableObj{
    line l1;
    public surface(double a, double b, double c)
    {
        super();
        l1 = new line(a,b,c);
    }
    public void interactWith(sphere obj1)
    {
        if(this.l1.distanceToCircle(obj1.c) < 0)
        {
           // get angle of line with x-axis
           double angle = this.l1.getAngle();
           // then get new components of velocity with respect to the surface
           vector newVel = obj1.velocity.rotateBy(angle);
           // reverse the y velocity after doing that
           newVel.y = -1 * newVel.y;
           // get back the old vector
           obj1.velocity = newVel.rotateBy(-1 * angle);
        }
    }
}
