public class moveableobject{
    public vector position, velocity;
    double density;
    moveableobject()
    {
        density = 1;   //mass is defined in KG
        position = new vector();
        velocity = new vector();
    }
    public void setPos(vector v1)
    {
        position = v1;  
    }
    public void changePosBy(vector v1)
    {
        position.add(v1);
    }
    public void showPosition()
    {
        System.out.print(" position : " + position.x + " , " + position.y + "\n");
    }
    public void setVelocity(vector v)
    {
        velocity = v;
    }
}