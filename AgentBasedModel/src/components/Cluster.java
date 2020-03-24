package components;

import java.util.ArrayList;
import java.util.Random;

public class Cluster {
	private int index;
	private ArrayList<Integer> participants;
	private ArrayList<Integer> neighbours;
	private int numofparticipants;
	private Net net;
	
	//tworzy maskê klastra przyjmuj¹c sieæ wêz³ów, listê komponentów podsieci, numer porz¹dkowy podsieci oraz sta³¹ prawdopodobieñstwa przy³¹czenia do klastra
	public Cluster(Net network, ArrayList<Integer> list, int num, double prob) {
		net = network;
		numofparticipants = 0;
		Random rand = new Random();
		index = num;
		participants = new ArrayList<Integer>();
		participants.add(list.get(0));
		numofparticipants++;
		net.returnNode(participants.get(0)).checked();
		for(int i = 0; i< participants.size(); i++) {
			neighbours = net.returnNode(participants.get(i)).returnNeighbours();
			net.returnNode(participants.get(i)).checked();
			for(int j = 0;i<neighbours.size();i++) {
				if(rand.nextInt() <= prob/numofparticipants && !net.returnNode(neighbours.get(j)).check()) {
					participants.add(neighbours.get(j));
					numofparticipants++;
				}
			}
		}
		System.out.println("Participants: ");
		for(int i = 0;i<participants.size();i++) {
			System.out.println(participants.get(i) + " ");
		}
		
		
		
		
	}
	public int returnIndex() {
		return index;
	}

}
