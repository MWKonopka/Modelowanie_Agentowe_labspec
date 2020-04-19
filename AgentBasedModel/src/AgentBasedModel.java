import graph.Graph;

import java.io.IOException;

import components.Net;

public class AgentBasedModel {
	
	public static void main(String [] args) throws IOException {
	 System.out.println("ER graph :");
	 
	 Graph graph = new Graph(10000,0.99);
	 graph.printParameters();
	 graph.printAdjcencencyList();
	 graph.printComponents();
	 Net net = new Net(graph);
	 net.saveReturns(10000000, 0.0001, 1, "sda10.csv");
	}
	
}
