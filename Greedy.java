package assignment;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Greedy {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/huffman.txt"); // 19, 9
		//LoadText lt = new LoadText("data/input_random_22_320.txt");
		ArrayList<Integer> data = lt.get();
		
		// initializing the heap
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>();
		int index = 1;
		for(int weight : data) {
			HuffmanNode node = new HuffmanNode();
			node.c = Integer.toString(index);
			node.value = weight;
			node.left = null;
			node.right = null;
			q.add(node);
		}
		HuffmanNode root = new HuffmanNode(); // the meaning of this is not clear for now

		while(q.size() > 1) {
			// pull the two nodes with the least weight
			HuffmanNode n1 = q.poll();
			HuffmanNode n2 = q.poll();
			HuffmanNode merge = new HuffmanNode();
			merge.left = n1;
			merge.right = n2;
			merge.value = n1.value + n2.value;
			merge.c = "-"; // merge node
			q.add(merge);
			root = merge; // the last update will determine the root
		}
		System.out.println("Max depth of tree: " + (findMaxLength(root) - 1));
		System.out.println("Min depth of tree: " + (findMinLength(root) - 1));
	}
	
	public static int findMaxLength(HuffmanNode n) {
		// n is assumed to be the roof
		if(n.left == null && n.right == null && n.c != "-") {
			return 1;
		}
		else {
			int leftLength = findMaxLength(n.left);
			int rightLength = findMaxLength(n.right);
			return Math.max(leftLength, rightLength) + 1;
		}
	}
	
	public static int findMinLength(HuffmanNode n) {
		// n is assumed to be the roof
		if(n.left == null && n.right == null && n.c != "-") {
			return 1;
		}
		else {
			int leftLength = findMinLength(n.left);
			int rightLength = findMinLength(n.right);
			return Math.min(leftLength, rightLength) + 1;
		}
	}
	

}
