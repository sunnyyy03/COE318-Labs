package coe318.lab7;
import java.util.ArrayList;

public class Circuit
{
    private ArrayList<Object> circuitElements = new ArrayList<>();
    private static Circuit instance = null; 
    
    private Circuit() {} 
    
    public static Circuit getInstance()
    {
        if(instance == null)
            instance = new Circuit();

        return instance; 
    }
    
    public void add(Resistor r)
    {
        circuitElements.add(r);
    }
    
    public void add(VoltageSource v)
    {
        circuitElements.add(v); 
    }

  
    public String toString()
    {
        String result = ""; 
        
        for(int i = 0; i < circuitElements.size(); i++)
            result += circuitElements.get(i) + "\n";
        
        return result; 
    }
}