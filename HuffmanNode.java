package assignment;

public class HuffmanNode implements Comparable<HuffmanNode>{
	int value;
	String c; // if this is not a leaf, it will be -
	HuffmanNode left;
	HuffmanNode right; // binary tree
	@Override
	public int compareTo(HuffmanNode o) {
		// TODO Auto-generated method stub
		if(this.value > o.value) {
			return 1;
		}
		else if (this.value < o.value) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
