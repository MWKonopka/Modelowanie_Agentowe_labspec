import graph.Graph;

import java.io.File;
import java.io.IOException;

import components.Net;

public class AgentBasedModel {
	
	public static void main(String [] args) throws IOException {
	 System.out.println("ER graph :");
	 
	 //set parameters
	 String filename = "p0.8a0.0001.csv";
	 int rep = 1000;
	 int size = 10000;
	 double prob = 0.8;
	 int timeSteps = 10000;
	 double activity = 0.0001;
	 int type = 0;
	 
	 File file = new File(filename);
	 file.delete();
	 Graph graph = new Graph(size,prob);
	 Net net = new Net(graph);
	 net.saveReturns(timeSteps, activity, type, filename);
	 for(int i = 0; i < rep; i++) {
		 graph = new Graph(size,prob);
		 net = new Net(graph);
		 net.saveReturns(timeSteps, activity, type, filename); 
		 System.out.println(i + "/" + rep);
	 }
	 System.out.println("Done");
	}
	
}
