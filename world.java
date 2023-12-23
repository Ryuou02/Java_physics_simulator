import java.util.Scanner;
import java.util.ArrayList;

public class world{
    double current_time, time_increment, max_time;
    ArrayList<sphere> balls = new ArrayList<sphere>();
    ArrayList<immovableObj> immovableObjs = new ArrayList<immovableObj>();
    ArrayList<point[]> postions = new ArrayList<point[]>();
    vector g;
    Scanner sc;

    public world()
    {
        current_time = 0;
        time_increment = 0.01;
        g = new vector(0, -9.8);
        max_time = 3;
        sc = new Scanner(System.in);
    }
    
    public void displayStats()
    {
        System.out.println("current time : " + current_time);
        System.out.println("g : " + g.y);
        System.out.println("time_increment : " + time_increment);
        System.out.println("max_time : " + max_time);
    }

    public void setIncTime(double seconds){
        if(seconds < 0)
        {
            System.out.println("!!!increment time cannot be negative!!!");          //change to exception
            System.out.println("setting increment_time to " + time_increment);
        }
        else
            time_increment = seconds;
    }

    public void setMaxTime(double seconds)
    {
        max_time = seconds;
    }

    public boolean worldEnd()
    {
        if(current_time < max_time)
            return false;
        else
            return true;
    }
    public void incTime()
    {
        current_time += time_increment;
    }   

    //use the following functions to insert objects into the world.
    public void addSphere(point center, vector velocity, double radius)
    {
        //add new sphere to the set of objects.
        sphere s1 = new sphere(center,radius);  //add exceptions in case the sphere is kept in an illegal place, i.e. it is intersecting with another object on creation itself
        s1.setVelocity(velocity);
        balls.add(s1);
        int nop = (int)(max_time / time_increment);
        point[] p = new point[nop];
        postions.add(p);

    }
    public void addSurface(double a, double b, double c)
    {
        surface s = new surface(a,b,c);
        immovableObjs.add(s);
    }
    public void addRoundBlock(point center, double radius)
    {
        round_block r = new round_block(center,radius);
        immovableObjs.add(r);
    }

    public void run()       //render the simulation
    {       
        while(!worldEnd())
        {   System.out.println("\ntime : " + current_time + "\t"); 
            for(int i = 0; i < balls.size(); i++)
            {
                for(int j = 0; j < immovableObjs.size(); j++){
                    immovableObjs.get(i).interactWith(balls.get(i));
                }
                point[] tmp = postions.get(i);
                tmp[(int)(current_time / time_increment)] = balls.get(i).c.center;
                postions.set(i,tmp);
            }
            this.incTime();
        }
    }

    public void simulate()  //display the simulation
    {
        for(int j = 0; j < balls.size(); j++)
        {   
            point[] tmp = postions.get(j);
            System.out.println("object " + j + "positions :");
            for(double i = 0; i < max_time; i += time_increment)
            {
                System.out.println(tmp[(int)(i / time_increment)].x  + " " + tmp[(int)(i / time_increment)].y);
            }
        }
    }
}