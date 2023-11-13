package coe318.lab7;

public class Resistor
{
    private double resistance; 
    private Node node1; 
    private Node node2; 
    private int id; 
    private static int resistor_id_counter = 1; 

    public Resistor(double resistance, Node node1, Node node2)
    {
        if(resistance <= 0 || (node1 == null || node2 == null))
            throw new IllegalArgumentException(); 

        this.resistance = resistance; 

        this.node1 = node1;
        this.node2 = node2;
        
        this.id = resistor_id_counter;
        resistor_id_counter++;
    }

    //Get array of nodes
    public Node[] getNodes()
    {
        Node[] nodes = new Node[2]; //Create array of two nodes
        
        //Assign nodes
        nodes[0] = this.node1;
        nodes[1] = this.node2;
        
        return nodes; //Return node array
    }

    //Return string version of resistor
    public String toString()
    {
        //Format is:
        //R[Resistor ID] [node1] [node2] [resistance]
        return "R" + this.id + "\t" + this.node1 + "\t" + this.node2 + "\t" + this.resistance;
    }
}
