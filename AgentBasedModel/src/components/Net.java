package components;

import java.util.ArrayList;
import graph.Graph;

public class Net {
	private ArrayList<Node> Nodes;
	
	public Net(Graph graph) {
		Nodes = new ArrayList<Node>();
		for(int i=0;i<graph.returnVertices();i++) {
			Nodes.add(new Node(i,graph.returnList(i)));
		}
		for(int i=0;i<Nodes.size();i++) {
			Nodes.get(i).showNeighbours();
		}
	}
}
