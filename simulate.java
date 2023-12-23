public class simulate{
    public static void main(String[] args)
    {
        world w1 = new world();
        w1.setMaxTime(3);
        w1.setIncTime(0.01);
        w1.run();
    }
}