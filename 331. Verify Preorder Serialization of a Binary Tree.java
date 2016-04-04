import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() < 1) {
			return false;
		}

		String[] nodes = preorder.split(",");
		int idx = dfs(nodes, 0);
		return idx == nodes.length;
	}

	private int dfs(String[] nodes, int idx) {
		if (idx >= nodes.length) {
			return -1;
		}
		System.out.println(idx + ", " + nodes.length);
		System.out.println(nodes);

		if (nodes[idx].equals("#")) {
			return idx + 1;
		}
		int rightIdx = dfs(nodes, idx + 1);
		if(rightIdx == -1) {
			return -1;
		}
		return dfs(nodes, rightIdx);
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		// String[][] strs = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO",
		// "SJC" }, { "LHR", "SFO" } };
		String[][] strs = { { "A", "JFK" }, { "JFK", "S" }, { "JFK", "A" } };
		System.out.println(so.isValidSerialization("1"));
	}
}
