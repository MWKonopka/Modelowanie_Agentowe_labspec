package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
	private int designation; //numer porz¹dkowy
	private ArrayList<Integer> neighbours; //somsiedzi
	private int state; //Stan wêz³a opisyj¹cy jego rolê spoœród kupuj¹cy, sprzedaj¹cy oraz nieaktywny odpowiednia -1,1,0
	
	//tworzy wêze³ pobieraj¹c listê s¹siedztwa i numer porz¹dkowy wêz³a
	public Node(int num, List<ArrayList<Integer>> list) {
		designation = num;
		neighbours = new ArrayList<Integer>();
		neighbours = list.get(num);
		state = 0;
		}
	//Ustawienie stanu wêz³a
	public void setState(int num) {
		state = num;
	}
	//Zmiana stanu wêz³a z danym prawdopodobieñstwem
	public void changeState(double prob) {
		Random rand = new Random();
		if(rand.nextDouble() <= prob) {
			state = rand.nextInt(3) - 1;
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
			System.out.println( neighbours.get(i) + " ");
		}
	}
}



