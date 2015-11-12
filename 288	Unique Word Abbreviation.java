public class ValidWordAbbr {
    HashMap<String, String> abbr2word;
    

    public ValidWordAbbr(String[] dictionary) {
        abbr2word = new HashMap<String, String>();
        for(String s:dictionary) {
            abbr2word.put(abbreviate(s), s);
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
        if(abbr2word.containsKey(abbr)){
            if(!abbr2word.get(abbr).equals(word)){
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
*/


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
