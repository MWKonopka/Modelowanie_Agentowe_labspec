package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class Graph {

	private int numOfVertices;
	private double probOfConnection;
	private List<ArrayList<Integer>> adjencencyList;
	private List<ArrayList<Integer>> components;
	private boolean visited[];
	private int numOfComponents;
	
	public Graph(int nVertices, double probOfConnect)			//Tworzenie listy sÄ…siedztwa
	{
		this.numOfVertices = nVertices;
		this.probOfConnection = probOfConnect/nVertices;
		adjencencyList = new ArrayList<ArrayList<Integer>>();
		components = new ArrayList<ArrayList<Integer>>();
		numOfComponents = 0;
		
			visited = new boolean[numOfVertices];
			for(int i = 0; i < numOfVertices; i++)
				visited[i] = false;
																
		for(int i = 0; i< this.numOfVertices; i++)
		{
		 ArrayList<Integer> aux = new ArrayList<Integer>();
		 adjencencyList.add(aux);
		}
																		
		for(int i = 0; i< numOfVertices; i++)
			for(int j = i+1; j<numOfVertices; j++)
			{
		    Random p = new Random();
				if(p.nextDouble() < probOfConnection)
				{
					adjencencyList.get(i).add(j);
					adjencencyList.get(j).add(i);
				}
			}
		this.getComponents();
	}
	
	
	public void printParameters()
	{
		System.out.println("V: " + numOfVertices    + "\n" + 
						   "p: " + probOfConnection + "\n" );
	}
	
	
	public void printAdjcencencyList()
	{
	System.out.println("Adjencency list:");
		for(int i = 0; i<numOfVertices; i++)
		{
			System.out.print(i + ":[ ");
			for(int j = 0 ;j < adjencencyList.get(i).size(); j++)
				System.out.print(adjencencyList.get(i).get(j) + " ");
			System.out.println("]");
		}	
	}
	
	
	private ArrayList<Integer> dfs(int node) 					//implementacja algorytmu depth-first-search
	{
		
		ArrayList<Integer> component = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(node);
			while(!stack.isEmpty())
			{
			 Integer first_out = stack.pop();
			 if(!visited[first_out])
			 {
				 visited[first_out] = true;
			 	 component.add(first_out);
			 }
			 	for(int i=0; i<adjencencyList.get(first_out).size();i++)
			 	{
				 int neighbor = adjencencyList.get(first_out).get(i);
				 if(!visited[neighbor])
					 stack.add(neighbor);
			 	}
			}	
		return component;
	}
	
	
	public void getComponents()						//Dodaje liste componentow
	{
	
	 for(int i=0; i<numOfVertices; i++)
		 if(!visited[i])
		 {
			 components.add(dfs(i));
			 numOfComponents++;
		 }
	}
	public ArrayList<Integer> returnComponent(int num) //Zwraca listê uczestników komponentu
	{
		return components.get(num);
	}
	public List<ArrayList<Integer>> returnComponents(){
		return components;
	}
	public int returnNumOfComponents() {
		return numOfComponents;
	}
	public void printComponents()
	{
	 System.out.println(numOfComponents + " components:");
		for(int i=0; i<components.size(); i++)
		{
			System.out.print(i + " {");
			for(int j=0; j<components.get(i).size(); j++)
				System.out.print(components.get(i).get(j)+ " ");
			System.out.println("}");
		}
				
	}
	public List<ArrayList<Integer>> returnList(int num)
	{
		return adjencencyList;
	}
	public int returnVertices() 
	{
		return numOfVertices;
	}
}
