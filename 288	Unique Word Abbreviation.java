public class ValidWordAbbr {
    // solution 1
    // HashMap<String, List<String>> space: O(K)*O(N) given K the size of abbr number and N the average size of word list
    
    // solution 2
    // HashMap<String, Boolean> space: O(K)
    // + HashSet<String> space: O(K) given K the size of abbr number
    
    HashMap<String, Boolean> abbr2unique;
    HashSet<String> wordSet;
    

    public ValidWordAbbr(String[] dictionary) {
        abbr2unique = new HashMap<String, Boolean>(); 
        wordSet = new HashSet<String>();
        for(String s:dictionary) {
            String abbr = abbreviate(s);
            if(abbr2unique.containsKey(abbr)){
                if(abbr2unique.get(abbr)){
                    // if not the original word
                    if(!wordSet.contains(s)){
                        abbr2unique.put(abbr, false); 
                    }
                }
            } else {
                abbr2unique.put(abbr, true);
                wordSet.add(s);
            } 
        }
    }
    
    private String abbreviate(String word) {
        int len = word.length();
        if(len < 3) {
            return word;
        }
        
        StringBuilder builder = new StringBuilder();
        builder.append(word.charAt(0));
        builder.append(len-2);
        builder.append(word.charAt(len-1));
        return builder.toString();
    }

    public boolean isUnique(String word) { 
        String abbr = abbreviate(word);
        if(abbr2unique.containsKey(abbr)){
            boolean unique = abbr2unique.get(abbr);
            if(unique) {
                return wordSet.contains(word);
            } else {
                return false;
            } 
        } 
        return true;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
["deer"
"door"
"cake"
"card"],isUnique("dear"),isUnique("door"),isUnique("cart"),isUnique("cake")
Output:
[false,true,true,true]
Expected:
[false,false,true,true]


换成
    // solution 2
    // HashMap<String, Boolean> space: O(K)
    // + HashSet<String> space: O(K) given K the size of abbr number
也是解决不了：
Input:["a","a"],isUnique("a")
Output:[false]
Expected:[true]

*/


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
