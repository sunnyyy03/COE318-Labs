package coe318.lab7;

public class VoltageSource
{

    private double voltage; 
    private Node node1; 
    private Node node2; 
    private int id;
    private static int voltage_id_counter = 1;

    public VoltageSource(double voltage, Node node1, Node node2)
    {
        if(node1 == null || node2 == null)
            throw new IllegalArgumentException(); 
        else
        {
            if(voltage < 0)  
            {
                this.voltage = voltage * -1.0; 
                this.node1 = node2;
                this.node2 = node1;
            }
            else
            {
                this.voltage = voltage; 
                
                this.node1 = node1;
                this.node2 = node2;
            }
        
            this.id = voltage_id_counter;
            voltage_id_counter++; 
        }
        
    }

    public Node[] getNodes()
    {
        Node[] nodes = new Node[2]; 
        nodes[0] = this.node1;
        nodes[1] = this.node2;
        
        return nodes; 
    }

    public String toString()
    {
        return "V" + this.id + "\t" + this.node1 + "\t" + this.node2 + "\tDC " + this.voltage;
    }
}