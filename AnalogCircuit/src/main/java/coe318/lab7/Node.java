package coe318.lab7;

public class Node
{
    public int id;
    private static int node_id_counter = 0; 

    public Node()
    {
        this.id = node_id_counter; 
        node_id_counter++;    
    }
    
    public String toString()
    {
        return "" + this.id; 
    }
}