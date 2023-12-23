
public class sphere extends moveableobject{
    public circle c;
    sphere()
    {
        super();
        c = new circle(new point(0,0),1);
    }
    
    sphere(point p, double radius)
    {
        super();
        this.c = new circle(new point(p), radius);
    }

    public void setCenter(point p)
    {
        c.center = p;
    }
    public void updateVelocity(double time)
    {
        double eta = 1.81e-5;
        vector dragForce = new vector();
        double drag = 6 * 3.1415 * eta * this.c.radius * this.velocity.x;
        dragForce.setVector(drag,0);
        drag = 6 * 3.1415 * eta * this.c.radius * this.velocity.y;
        dragForce.setVector(dragForce.x, drag);
        vector netForce = new vector();

        //added drag Force
        netForce.add(dragForce);
        vector netAccel = new vector();
        netAccel.setVector(netForce.x / mass, netForce.y / mass);
        
        // calculate final velocity
        this.velocity.calcVelocity(this.velocity, netAccel, time);
    }

    public void checkCollisionAndSetVelocity(sphere s1)
    {
        if(s1.c.intersects(this.c)) //a collision is detected
        {
            double angle = 0;
            angle = Math.atan2(s1.c.center.y-this.c.center.y,s1.c.center.x-this.c.center.x);
            vector newVel1 = this.velocity.rotateBy(angle);
            vector newVel2 = s1.velocity.rotateBy(angle);
            double tmp;
            // get new values for y value of the vectors
            tmp = (this.mass - s1.mass)*(newVel1.y - newVel2.y) / (this.mass + s1.mass) + newVel2.y;
            newVel2.y = 2 * this.mass * (newVel1.y - newVel2.y) / (this.mass + s1.mass) + newVel2.y;
            newVel1.y = tmp;
            s1.velocity = newVel2.rotateBy(-1 * angle);
            this.velocity = newVel1.rotateBy(-1 * angle);
        }
    }
}
