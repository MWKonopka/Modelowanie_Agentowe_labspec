import graph.Graph;
import components.Net;
import components.Cluster;

public class AgentBasedModel {
	
	public static void main(String [] args) {
	 System.out.println("ER graph :");
	 
	 Graph graph = new Graph(20,0.2);
	 graph.printParameters();
	 graph.printAdjcencencyList();
	 graph.printComponents();
	 Net net = new Net(graph);
	 //Cluster clust = new Cluster(net,graph.returnComponents(0),0, 0.97);
	}
	
}
