import java.util.*;

public class world{
    double current_time, time_increment, max_time;
    vector g;
    double height_of_sphere;
    Scanner sc;
    
    //----------------------world objects declared here ---------------------
    //sphere s1;
    //-------------------------------------------------


    world()
    {
        current_time = 0;
        time_increment = 0.01;
        g = new vector(0, -9.8);
        max_time = 3;
      //  s1 = new sphere();
        height_of_sphere = 0;
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
            System.out.println("!!!increment time cannot be negative!!!");
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
        if(current_time != max_time)
            return false;
        else
            return true;
    }

    public void incTime()
    {
        current_time += time_increment;
    }   

    public void setHeightOfSphere()
    {
        String input;
        System.out.println("how high is the Sphere to be placed?");
        input = sc.next();
        if(input.charAt(0) == 'g')
        {
            System.out.println("set gravity : ");
            g.y = sc.nextDouble();
            System.out.println("set height of object : ");
            height_of_sphere = sc.nextDouble();
        }
        else{
            height_of_sphere = Double.parseDouble(input);
        }
        //s1.setPos(vector.setVector(0,height_of_sphere));
        //s1.showPosition();
    }

    
    public void run()
    {       
        setHeightOfSphere();
        while(current_time < max_time)
        {   System.out.println("\n" + current_time + "\t"); 
 //           s1.showPosition();
 //           s1.changePosBy(vector.calcDistance(s1.velocity, g, time_increment));
 //           s1.setVelocity(vector.calcVelocity(s1.velocity, g, time_increment));
            this.incTime();
        }
    }
}