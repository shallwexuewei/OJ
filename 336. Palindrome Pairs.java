import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	private List<List<Integer>> result;

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		int wordIdx = -1;
	}

	private void insert(TrieNode node, String word, int idx, int wordIdx) {
		if (word.length() == idx) {
			node.wordIdx = wordIdx;
			return;
		}

		int charIdx = word.charAt(idx) - 'a';
		if (node.children[charIdx] == null) {
			node.children[charIdx] = new TrieNode();
		}
		insert(node.children[charIdx], word, idx + 1, wordIdx);
	}

	private void search(TrieNode node, String word, int idx, int wordIdx) {
		if(node == null) {
			return;
		}
		if (idx == -1) {
			findPalindrome(node, wordIdx, new LinkedList<Integer>());
			return;
		}
		// 在Trie上找到单词，此时判断word剩下的字符是否能构成回文，
		// 注意在这里不能return,因为可能还有其他答案
		if (node.wordIdx != -1 && node.wordIdx != wordIdx) {
			int hi = idx;
			int lo = 0;
			boolean isPalindrome = true;
			while(lo < hi) {
				if(word.charAt(hi) != word.charAt(lo)) {
					isPalindrome = false;
					break;
				}
				lo++;
				hi--;
			}
			if(isPalindrome) {
				addResult(node.wordIdx, wordIdx);
			}
		}

		int charIdx = word.charAt(idx) - 'a';
		search(node.children[charIdx], word, idx - 1, wordIdx);
	}

	private void findPalindrome(TrieNode node, int wordIdx, LinkedList<Integer> path) {
		if (node == null) {
			return;
		}

		if (node.wordIdx != -1 && node.wordIdx != wordIdx) {
			int len = path.size();
			int last = len - 1;
			boolean isPalindrome = true;
			for (int i = 0; i < len / 2; i++) {
				if (path.get(i) != path.get(last - i)) {
					isPalindrome = false;
					break;
				}
			}
			if (isPalindrome) {
				addResult(node.wordIdx, wordIdx);
			}
		}

		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null) {
				path.add(i);
				findPalindrome(node.children[i], wordIdx, path);
				path.removeLast();
			}
		}
	}

	private void addResult(int idx1, int wordIdx) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(idx1);
		list.add(wordIdx);
		result.add(list);
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		result = new ArrayList<List<Integer>>();

		if (words == null || words.length == 0) {
			return result;
		}

		TrieNode head = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			insert(head, words[i], 0, i);
		}

		for (int i = 0; i < words.length; i++) {
			search(head, words[i], words[i].length() - 1, i);
		}
		return result;

	}

	public static void main(String[] args) {
		Solution so = new Solution();
		String[] strs = { "abcd","dcba","lls","s","sssll" };
		System.out.println(so.palindromePairs(strs));
	}
}
