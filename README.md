
# Introduction
This is a simulator application, made using java, which helps the user to visualize the movement of spheres under the effect of -
  1. Collisions with other spheres
  2. Gravity(from other spheres as well as the world)
  3. Drag force
  4. Collision with stationary objects like surfaces and stationary spheres

It comes with an user-friendly GUI so that the application can be accessible to larger audience.

## How to run the application
In case you are new to java, you may read the instructions to run the java application.
Since this is an application made in java, please make sure that you have java installed in order to run the application.
  1. Clone the repository into an empty folder.
  2. Navigate to the folder where you have cloned this repository.
  3. Open the command line interface(i.e. terminal, command prompt, powershell).
  4. Compile the program by the command <code>$javac simulate.java</code> in the command line interface.
  5. Run the application using the command <code>$java simulate</code> in the command line interface. (if you compiled the program already, there is no need to recompile).
### some terms I will use within the next sections and its explanation -
1. world - by world, I mean the window in which the simulation runs.
2. render - to make the program do the necessary calculations.
# Running of the application
<center><img width="255" alt="main page" src="https://github.com/Ryuou02/Java_physics_simulator/assets/133224167/16dd00db-c9cd-4762-988a-69fdda7ab01a"></center>
Here is the screenshot of the main window of the application. It allows 4 basic functions -
  1. Add a sphere to the world.
  2. Add a surface or stationary object to the world.
  3. Rendering the simulation.(you can run the application after rendering the simulation only. Rendering means to calculate the position of every object at every moment in time.)
  4. Playing the simulation.

## add new object
![image](https://github.com/Ryuou02/Java_physics_simulator/assets/133224167/fd62556d-233b-459b-aa60-9fe416219898)

