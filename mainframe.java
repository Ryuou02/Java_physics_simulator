import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainframe extends JFrame implements ActionListener{
    JButton newObject = new JButton("add new object");
    JButton newLine = new JButton("add new surface");
    JButton newCircle = new JButton("add new round block");
    JButton renderSim = new JButton("render the simulation");
    JButton playSim = new JButton("play the simulation");
    world obj;

    mainframe(world obj)
    {
        this.obj = obj;

        newObject.addActionListener(this);
        newLine.addActionListener(this);
        newCircle.addActionListener(this);
        renderSim.addActionListener(this);
        playSim.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,1,10,20));
        buttonPanel.add(newObject);
        buttonPanel.add(newLine);
        buttonPanel.add(newCircle);
        buttonPanel.add(renderSim);
        buttonPanel.add(playSim);
        
        //this.add(simulator);


        this.add(buttonPanel);

        this.setTitle("Java Physics simulator");
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }
    class getNewObjectDimensions extends JFrame implements ActionListener
    {
        JButton addtoframe = new JButton("add object");
        JTextField xvelocity = new JTextField();
        JTextField yvelocity = new JTextField();
        JTextField mass = new JTextField();
        JTextField radius = new JTextField();
        JTextField ypos = new JTextField();
        JTextField xpos = new JTextField();
        getNewObjectDimensions()
        {
            addtoframe.addActionListener(this);
            JLabel xvel = new JLabel("velocity along x axis");
            JLabel yvel = new JLabel("velocity along y axis");
            JLabel m = new JLabel("enter mass");
            JLabel r = new JLabel("enter radius");
            JLabel xp = new JLabel("enter x coordinate of position");
            JLabel yp = new JLabel("enter y coordinate of position");

            this.setLayout(new GridLayout(7,2,10,10));
            this.add(xvel);
            this.add(xvelocity);
            this.add(yvel);
            this.add(yvelocity);
            this.add(m);
            this.add(mass);
            this.add(r);
            this.add(radius);
            this.add(xp);
            this.add(xpos);
            this.add(yp);
            this.add(ypos);
            this.add(addtoframe);
            this.setTitle("add new sphere");
            this.setVisible(true);
            this.setSize(400,400);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == addtoframe)
            {
                vector vel = new vector();
                //--------------------------handle exception caused by parseDouble function---------------------------
                vel.x = Double.parseDouble(xvelocity.getText());
                vel.y = Double.parseDouble(yvelocity.getText());
                point cn = new point(Double.parseDouble(xpos.getText()),Double.parseDouble(ypos.getText()));
                double mas = Double.parseDouble(mass.getText());
                double rad = Double.parseDouble(radius.getText());
                //---------------------------------------------------------------------------------------------------

                world.addSphere(cn,vel,rad,mas);
                this.dispose();
            }
        }
    }/* 
    private class getLineDimensions extends JFrame implements ActionListener
    {
        JButton addtoframe = new JButton("add surface");

        JTextField A = new JTextField();
        JTextField B = new JTextField();
        JTextField C = new JTextField();
        getLineDimensions()
        {
            addtoframe.addActionListener(this);
            JLabel Alabel = new JLabel("enter 'a' coefficient of line");
            JLabel Blabel = new JLabel("enter 'b' coefficient of line");
            JLabel Clabel = new JLabel("enter 'c' coefficient of line");
            

            this.setLayout(new GridLayout(4,2,10,10));
            this.add(Alabel);
            this.add(A);
            this.add(Blabel);
            this.add(B);
            this.add(Clabel);
            this.add(C);

            this.add(addtoframe);
            this.setTitle("add new surface");
            this.setVisible(true);
            this.setSize(400,400);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == addtoframe)
            {
                //--------------------------handle exception caused by parseDouble function---------------------------
                double a = Double.parseDouble(A.getText());
                double b = Double.parseDouble(B.getText());
                double c = Double.parseDouble(C.getText());
                //---------------------------------------------------------------------------------------------------

                world.addSurface(a, b, c);
                this.dispose();
            }
        }
    }*/
    private class getLineDimensions extends JFrame implements ActionListener
    {
        JButton addtoframe = new JButton("add surface");

        JTextField X1 = new JTextField();
        JTextField X2 = new JTextField();
        JTextField Y1 = new JTextField();
        JTextField Y2 = new JTextField();
        getLineDimensions()
        {
            addtoframe.addActionListener(this);
            JLabel X1label = new JLabel("enter x1");
            JLabel X2label = new JLabel("enter x2");
            JLabel Y1label = new JLabel("enter y1");
            JLabel Y2label = new JLabel("enter y2");
            

            this.setLayout(new GridLayout(5,2,10,10));
            this.add(X1label);
            this.add(X1);
            this.add(X2label);
            this.add(X2);
            this.add(Y1label);
            this.add(Y1);
            this.add(Y2label);
            this.add(Y2);

            this.add(addtoframe);
            this.setTitle("add new surface");
            this.setVisible(true);
            this.setSize(400,400);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == addtoframe)
            {
                //--------------------------handle exception caused by parseDouble function---------------------------
                double x1 = Double.parseDouble(X1.getText());
                double y1 = Double.parseDouble(Y1.getText());
                double x2 = Double.parseDouble(X2.getText());
                double y2 = Double.parseDouble(Y2.getText());
                //---------------------------------------------------------------------------------------------------

                world.addSurface(new point(x1,y1), new point(x2,y2));
                this.dispose();
            }
        }
    }
    private class getCircleDimensions extends JFrame implements ActionListener
    {
        JButton addtoframe = new JButton("add roundBlock");
        JTextField radius = new JTextField();
        JTextField xpos = new JTextField();
        JTextField ypos = new JTextField();
        getCircleDimensions()
        {
            addtoframe.addActionListener(this);
            JLabel rlabel = new JLabel("enter radius of round block");
            JLabel xlabel = new JLabel("enter x position of round block");
            JLabel ylabel = new JLabel("enter y position of round block");
            

            this.setLayout(new GridLayout(4,2,10,10));
            this.add(rlabel);
            this.add(radius);
            this.add(xlabel);
            this.add(xpos);
            this.add(ylabel);
            this.add(ypos);

            this.add(addtoframe);
            this.setTitle("add new surface");
            this.setVisible(true);
            this.setSize(400,400);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == addtoframe)
            {
                //--------------------------handle exception caused by parseDouble function---------------------------
                double r = Double.parseDouble(radius.getText());
                double x = Double.parseDouble(xpos.getText());
                double y = Double.parseDouble(ypos.getText());
                //---------------------------------------------------------------------------------------------------

                world.addRoundBlock(new point(x,y),r);
                this.dispose();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == newObject)
        {
            newObject.setEnabled(false);
            new getNewObjectDimensions();
            newObject.setEnabled(true);
        }
        if(e.getSource() == newLine)
        {
            new getLineDimensions();
        }
        if(e.getSource() == newCircle)
        {
            new getCircleDimensions();
        }
        if(e.getSource() == renderSim)
        {
            renderSim.setEnabled(false);
            System.out.println("rendering simulation");
            obj.run();
            renderSim.setEnabled(true);
        }
        if(e.getSource() == playSim)
        {
            JFrame sim = new JFrame();
            sim.add(new drawpad());
            sim.setVisible(true); 
            sim.pack(); 
            sim.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
