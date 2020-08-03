package assignment;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestLoadText {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/huffman.txt");
		ArrayList<Integer> data = lt.get();
		for(int i : data) {
			System.out.println(i);
		}
	}
}
