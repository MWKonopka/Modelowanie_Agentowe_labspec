package components;

import java.util.ArrayList;
import java.util.List;

import graph.Graph;

public class Net {
	private ArrayList<Node> nodes;
	private List<ArrayList<Integer>> components;
	
	
	public Net(Graph graph) {
		nodes = new ArrayList<Node>();
		components = graph.returnComponents();
		for(int i=0;i<graph.returnVertices();i++) {
			nodes.add(new Node(i,graph.returnList(i)));
		}
	}
	public Node returnNode(int num) {
		return nodes.get(num);
	}
	public int symulate(double probOfChange) {
		int state = 0;
		int deltaX = 0;
		for(int i=0;i<components.size();i++) {
			nodes.get(components.get(i).get(0)).changeState(probOfChange);
			state = nodes.get(components.get(i).get(0)).returnState();
			for(int j=0;j<components.get(i).size();j++) {
				nodes.get(components.get(i).get(j)).setState(state);
			}
		}
		for(int i=0;i<nodes.size();i++) {
			deltaX += nodes.get(i).returnState();
		}
		return deltaX;
	}
	public List<ArrayList<Integer>> symulateTimeChange(int timeSteps, double probOfChange){
		ArrayList<Integer> iterations = new ArrayList<Integer>();
		ArrayList<Integer> Changes = new ArrayList<Integer>();
		List<ArrayList<Integer>> returned = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<timeSteps;i++) {
			iterations.add(i);
			Changes.add(symulate(probOfChange));
		}
		returned.add(iterations);
		returned.add(Changes);
		return returned;
	}
	public void printReturns(int timeSteps, double probOfChange) {
		List<ArrayList<Integer>> printy = symulateTimeChange(timeSteps, probOfChange);
		for(int i=0;i < printy.get(1).size();i++) {
			System.out.println("Iteracja " + i +": " + printy.get(1).get(i));
		}
	}
}
