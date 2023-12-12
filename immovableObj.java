public class immovableObj{
    vector endPoints;
    int verticesNo;
    immovableObj()
    {
        verticesNo = 0;
        System.out.println("!!immovable object needs coordinates!!");
        System.exit(0);
    }

    immovableObj(vector coords, int number_of_vertices)
    {
        if(number_of_vertices < 1)
        {
            System.out.println("!!number of vertices given to be invalid!!");
            System.exit(0);
        }
        verticesNo = number_of_vertices;
        //coords = new vector[verticesNo];
        endPoints = coords;
    }
    int getVertices()
    {
        return verticesNo;
    }
}
