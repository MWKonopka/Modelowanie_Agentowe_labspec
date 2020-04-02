import graph.Graph;

import java.io.IOException;

import components.Net;

public class AgentBasedModel {
	
	public static void main(String [] args) throws IOException {
	 System.out.println("ER graph :");
	 
	 Graph graph = new Graph(10000,0.98);
	 graph.printParameters();
	 graph.printAdjcencencyList();
	 graph.printComponents();
	 Net net = new Net(graph);
	 net.saveReturns(1000000, 0.0001,"10k.csv");
	}
	
}
