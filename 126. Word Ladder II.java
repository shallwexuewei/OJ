import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	public class Node {
		int len;
		String str;
		ArrayList<Node> prevList;

		public Node(int l, String s) {
			this.len = l;
			this.str = s;
			prevList = new ArrayList<>();
		}

		public Node(int l, String s, Node prev) {
			this.len = l;
			this.str = s;
			prevList = new ArrayList<>();
			prevList.add(prev);
		}
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		// null
		List<List<String>> res = new ArrayList<List<String>>();

		int size = wordList.size();

		// BFS
		LinkedList<Node> q = new LinkedList<Node>();
		// visit state
		HashMap<String, Node> visited2Node = new HashMap<String, Node>();
		// wildcardMap
		HashMap<String, LinkedList<String>> wildcardMap = getWildcardMap(wordList);

		if (beginWord.equals(endWord)) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(beginWord);
			res.add(list);
			return res;
		}

		Node node = new Node(1, beginWord);
		q.add(node);
		visited2Node.put(beginWord, node);
		int minLen = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			node = q.removeFirst();
			String current = node.str;
			if (node.len == minLen || node.len > size) {
				break;
			}
			int nextLen = node.len + 1;
//			for (int i = 0; i < nextLen; i++) {
//				System.out.print("  ");
//			}
//			System.out.println(current);
			LinkedList<String> wildcardList = getWildcardList(current);
			for (String wildcardWord : wildcardList) {
				LinkedList<String> neighbors = wildcardMap.get(wildcardWord);
				for (String neighbor : neighbors) {
					if (!neighbor.equals(current)) {
						if (visited2Node.containsKey(neighbor)) {
							int d = visited2Node.get(neighbor).len;
							// when the string is visited by shorter path
							if (d < nextLen) {
								continue;
							}
						}

						// for(int i = 0; i < nextLen; i++) {
						// System.out.print(" ");
						// }
						// System.out.println("n:"+neighbor);

						if (visited2Node.containsKey(neighbor)) { 
							Node next = visited2Node.get(neighbor);
							next.prevList.add(node);
						} else {
							if (neighbor.equals(endWord)) {
								minLen = nextLen;
								Node next = new Node(nextLen, neighbor, node);
								visited2Node.put(neighbor, next);
							} else if (nextLen < minLen) {
								Node next = new Node(nextLen, neighbor, node);
								q.add(next);
								visited2Node.put(neighbor, next);
							}
						}
					}
				}
			}
		}
		
		if(!visited2Node.containsKey(endWord)){
		    return res;
		}

		LinkedList<String> list = new LinkedList<String>();
		list.add(endWord);
		res.add(list); 
		constructList(visited2Node.get(endWord), res, list);
		return res;
	}

	private void constructList(Node node, List<List<String>> res, LinkedList<String> list) {
		ArrayList<Node> prevList = node.prevList;
		if (prevList.isEmpty()) {
			return;
		}

		int size = prevList.size();
		if (size > 1) {
			for (int i = size - 1; i > 0; i--) {
				Node prev = prevList.get(i);
				LinkedList<String> copy = new LinkedList<>();
				copy.addAll(list);
				copy.add(0, prev.str);
				res.add(copy);
				constructList(prev, res, copy);
			}
		}
		list.add(0, prevList.get(0).str);
		constructList(prevList.get(0), res, list);
	}

	// get wildcardList
	private LinkedList<String> getWildcardList(String word) { // O(K)
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < word.length(); i++) {
			list.add(word.substring(0, i) + "_" + word.substring(i + 1));
		}
		return list;
	}

	// make wildcardMap
	private HashMap<String, LinkedList<String>> getWildcardMap(Set<String> wordList) { // O(KN)
		HashMap<String, LinkedList<String>> wildcardMap = new HashMap<String, LinkedList<String>>();
		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String wildcardWord = word.substring(0, i) + "_" + word.substring(i + 1);
				if (wildcardMap.containsKey(wildcardWord)) {
					wildcardMap.get(wildcardWord).add(word);
				} else {
					LinkedList<String> realWords = new LinkedList<String>();
					realWords.add(word);
					wildcardMap.put(wildcardWord, realWords);
				}
			}
		}
		return wildcardMap;
	}

	public static void main(String[] args) {
		String st = "a";
		String end = "c";
		String[] words = { "a","b","c" };
//		String st = "hot";
//		String end = "dog";
//		String[] words = { "hot","cog","dog","tot","hog","hop","pot","dot" };
//		String st = "cet";
//		String end = "ism";
//		String[] words = { "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per",
//				"val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue",
//				"fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum",
//				"fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw",
//				"out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie",
//				"noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim",
//				"san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin",
//				"feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax",
//				"hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax",
//				"tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot",
//				"ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave",
//				"buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew",
//				"web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig",
//				"era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and",
//				"ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par",
//				"wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six",
//				"ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy",
//				"rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk",
//				"cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let",
//				"see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow",
//				"cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal",
//				"keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy",
//				"due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib",
//				"eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our",
//				"ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi",
//				"yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo",
//				"cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg",
//				"put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw",
//				"eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol",
//				"din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox",
//				"lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins",
//				"con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic",
//				"ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all",
//				"pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago",
//				"ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip",
//				"han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape",
//				"rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho",
//				"tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy",
//				"foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len",
//				"air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten",
//				"mob" };
		Set<String> set = new HashSet<String>();
		for (String w : words) {
			set.add(w);
		}
		Solution s = new Solution();
		List<List<String>> ladders = s.findLadders(st, end, set);
		for (List<String> list : ladders) {
			for (String str : list) {
				System.out.print(str + ", ");
			}
			System.out.println();
		}

	}
}
