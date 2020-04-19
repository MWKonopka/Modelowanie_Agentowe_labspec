package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
	private int designation; //numer porz¹dkowy
	private ArrayList<Integer> neighbours; //somsiedzi
	private int state; //Stan wêz³a opisyj¹cy jego rolê spoœród kupuj¹cy, sprzedaj¹cy oraz nieaktywny odpowiednia -1,1,0
	private boolean checked;
	private Random rand;
	private double chance;
	//tworzy wêze³ pobieraj¹c listê s¹siedztwa i numer porz¹dkowy wêz³a
	public Node(int num, List<ArrayList<Integer>> list) {
		checked = false;
		designation = num;
		neighbours = new ArrayList<Integer>();
		neighbours = list.get(num);
		state = 0;
		rand = new Random();
		chance = 0;
		}
	//Ustawienie stanu wêz³a
	public void setState(int num) {
		state = num;
	}
	//Zmiana stanu wêz³a z danym prawdopodobieñstwem. chice wybiera pêtlê. 0 to domyœlny model CB (prob to prawdopodobieñstwo, 1 to self-dependent activity (prob to rozmiar klastra)
	public void changeState(double prob, int choice) {
		if(choice == 0) {
			chance = rand.nextDouble();
			if(chance <= 2*prob) {
				state = rand.nextInt(2);
				if(state == 0) {
					state--;
				}
			}
			else {
				state = 0;
			}
		}
		if(choice == 1) {
			chance = rand.nextDouble();
			if(chance <= 1/(2*Math.sqrt(prob))) {
				state = rand.nextInt(2);
				if(state == 0) {
					state--;
				}
			}
			else {
				state = 0;
			}
		}
	}
	//Zwraca stan wêz³a
	public int returnState() {
		return state;
	}
	//zwraca s¹siadów wêz³a
	public ArrayList<Integer> returnNeighbours(){
		return neighbours;
	}
	//Wypisanie s¹siadów wêz³a
	public void showNeighbours() {
		System.out.println("Somsiedzi node " + designation);
		for(int i=0;i<neighbours.size();i++) {
			System.out.print( neighbours.get(i) + " ");
		}
		System.out.println(" ");
	}
	public int returnNumber() {
		return designation;
	}
	public void checked() {
		checked = true;
	}
	public boolean check() {
		return checked;
	}
}



