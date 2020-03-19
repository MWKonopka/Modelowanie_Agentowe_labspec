package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
	private int designation; //numer porz�dkowy
	private ArrayList<Integer> neighbours; //somsiedzi
	private int state; //Stan w�z�a opisyj�cy jego rol� spo�r�d kupuj�cy, sprzedaj�cy oraz nieaktywny odpowiednia -1,1,0
	
	//tworzy w�ze� pobieraj�c list� s�siedztwa i numer porz�dkowy w�z�a
	public Node(int num, List<ArrayList<Integer>> list) {
		designation = num;
		neighbours = new ArrayList<Integer>();
		neighbours = list.get(num);
		state = 0;
		}
	//Ustawienie stanu w�z�a
	public void setState(int num) {
		state = num;
	}
	//Zmiana stanu w�z�a z danym prawdopodobie�stwem
	public void changeState(double prob) {
		Random rand = new Random();
		if(rand.nextDouble() <= prob) {
			state = rand.nextInt(3) - 1;
		}
	}
	//Zwraca stan w�z�a
	public int returnState() {
		return state;
	}
	//zwraca s�siad�w w�z�a
	public ArrayList<Integer> returnNeighbours(){
		return neighbours;
	}
	//Wypisanie s�siad�w w�z�a
	public void showNeighbours() {
		System.out.println("Somsiedzi node " + designation);
		for(int i=0;i<neighbours.size();i++) {
			System.out.println( neighbours.get(i) + " ");
		}
	}
}



