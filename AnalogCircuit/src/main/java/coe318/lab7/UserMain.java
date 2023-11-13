package coe318.lab7;
import java.util.Scanner;
import java.util.ArrayList;

public class UserMain
{

	public static void main(String[] args)
	{
		String userInput;
		Circuit circuit = Circuit.getInstance();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your input:");
		
		while(true)
		{
			userInput = input.nextLine().trim();
			
			if(userInput.equalsIgnoreCase("end"))
			{
				System.out.println("All Done");
				break; //Terminate program
			}
			else if(userInput.equalsIgnoreCase("spice"))
			{
				System.out.println(circuit);
			}
			else 
			{
				String[] inputs = userInput.split(" ");
				
				if(inputs.length != 4)
					throw new IllegalArgumentException();
				else
				{
					Node node1 = new Node();
					Node node2 = new Node(); 
					node1.id = Integer.parseInt(inputs[1]);
					node2.id = Integer.parseInt(inputs[2]);
					double value = Double.parseDouble(inputs[3]);
					
					if(userInput.toLowerCase().startsWith("v"))
					{
						VoltageSource v = new VoltageSource(value, node1, node2);
						circuit.add(v);
					}
					else if (userInput.toLowerCase().startsWith("r"))
					{
						Resistor r = new Resistor(value, node1, node2);
						circuit.add(r);
					}
				}
			}
		}
	}
}