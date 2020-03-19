import graph.Graph;
import components.Net;

public class AgentBasedModel {
	
	public static void main(String [] args) {
	 System.out.println("ER graph :");
	 
	 Graph graph = new Graph(10,0.2);
	 graph.printParameters();
	 graph.printAdjcencencyList();
	 graph.printComponents();
	// Net net = new Net(graph);
	}
	
}
