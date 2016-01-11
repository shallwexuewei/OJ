public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (s == null || words == null || words.length == 0) {
			return res;
		}

		int len = s.length();
		int wordLen = words[0].length();
		int windowLen = words.length * wordLen;
		if (len == 0 || windowLen == 0 || len < windowLen) {
			return res;
		}

		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		for (String w : words) {
			if (dict.containsKey(w)) {
				dict.put(w, dict.get(w) + 1);
			} else {
				dict.put(w, 1);
			}
		}

		for (int st = 0; st < wordLen; st++) { // shift
			for (int i = st; i <= s.length() - windowLen;) { // i:left pointer
																// of the window
				int j = i; // j: right pointer of the window
				int found = 0;
				HashMap<String, Integer> visited = new HashMap<String, Integer>();

				while (j <= s.length() - wordLen) { 
					String subStr = s.substring(j, j + wordLen);
					if (!dict.containsKey(subStr)) {
						i = j + wordLen;
						break;
					}

					if (visited.containsKey(subStr)) {
						while (visited.get(subStr) >= dict.get(subStr)) {
							String prevHead = s.substring(i, i + wordLen);
							visited.put(prevHead, visited.get(prevHead) - 1);
							i += wordLen; // new window starting index
							found--;
						}
						visited.put(subStr, visited.get(subStr) + 1);
						found++;
					} else {
						visited.put(subStr, 1);
						found++;
					}
					if (found == words.length) {
						res.add(i);
					}
					
					if (found >= words.length) {
						String prevhead = s.substring(i, i + wordLen);
						visited.put(prevhead, visited.get(prevhead) - 1);
						i += wordLen;
						found--;
					} 
					j += wordLen;
				} 
			}
		}

		return res;
	}
}

/*
Submission Result: Wrong Answer More Details 

Input:
"wordgoodgoodgoodbestword"
["word","good","best","good"]
Output:
[]
Expected:
[8]
 
*/
