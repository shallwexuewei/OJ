public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, LinkedList<String>> groups = new HashMap<String, LinkedList<String>>();
        for(String str:strings) {
            String shifted = shift(str);
            if(groups.containsKey(shifted)){
                groups.get(shifted).add(str);
            } else {
                LinkedList<String> group = new LinkedList<String>();
                group.add(str);
                groups.put(shifted, group);
            }
        }
        List<List<String>> result = new LinkedList<List<String>>();
        for(String key:groups.keySet()){
            List<String> group = groups.get(key);
            Collections.sort(group);
            result.add(group);
        }
        return result;
    }
    
    private String shift(String str){
        char c = str.charAt(0);
        int shift = c - 'a';
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - shift;
            if(index < 'a') {
                index += 'z' - 'a' + 1;
            }
            char newC = (char)index;
            builder.append(newC);
        }
        return builder.toString();
    }
}

/*
 Wrong Answer More Details 

Input:
["fpbnsbrkbcyzdmmmoisaa"
"cpjtwqcdwbldwwrryuclcngw"
"a"
"fnuqwejouqzrif"
"js"
"qcpr"
"zghmdiaqmfelr"
"iedda"
"l"
"dgwlvcyubde"
"lpt"
"qzq"
"zkddvitlk"
"xbogegswmad"
"mkndeyrh"
"llofdjckor"
"lebzshcb"
"firomjjlidqpsdeqyn"
"dclpiqbypjpfafukqmjnjg"
"lbpabjpcmkyivbtgdwhzlxa"
"wmalmuanxvjtgmerohskwil"
"yxgkdlwtkekavapflheieb"
"oraxvssurmzybmnzhw"
"ohecvkfe"
"kknecibjnq"
"wuxnoibr"
"gkxpnpbfvjm"
"lwpphufxw"
"sbs"
"txb"
"ilbqahdzgij"
"i"
"zvuur"
"yfglchzpledkq"
"eqdf"
"nw"
"aiplrzejplumda"
"d"
"huoybvhibgqibbwwdzhqhslb"
"rbnzendwnoklpyyyauemm"]
Output:
[["zghmdiaqmfelr","yfglchzpledkq"],["a","l","i","d"],["lpt","txb"],["dclpiqbypjpfafukqmjnjg","yxgkdlwtkekavapflheieb"],["xbogegswmad","gkxpnpbfvjm"],["js","nw"],["mkndeyrh","wuxnoibr"],["fpbnsbrkbcyzdmmmoisaa","rbnzendwnoklpyyyauemm"],["zkddvitlk","lwpphufxw"],["llofdjckor","kknecibjnq"],["cpjtwqcdwbldwwrryuclcngw","huoybvhibgqibbwwdzhqhslb"],["iedda","zvuur"],["firomjjlidqpsdeqyn","oraxvssurmzybmnzhw"],["qcpr","eqdf"],["qzq","sbs"],["dgwlvcyubde","ilbqahdzgij"],["lebzshcb","ohecvkfe"],["lbpabjpcmkyivbtgdwhzlxa","wmalmuanxvjtgmerohskwil"],["fnuqwejouqzrif","aiplrzejplumda"]]
Expected:
[["a","d","i","l"],["eqdf","qcpr"],["lpt","txb"],["yfglchzpledkq","zghmdiaqmfelr"],["kknecibjnq","llofdjckor"],["cpjtwqcdwbldwwrryuclcngw","huoybvhibgqibbwwdzhqhslb"],["lbpabjpcmkyivbtgdwhzlxa","wmalmuanxvjtgmerohskwil"],["iedda","zvuur"],["js","nw"],["lebzshcb","ohecvkfe"],["dgwlvcyubde","ilbqahdzgij"],["lwpphufxw","zkddvitlk"],["qzq","sbs"],["dclpiqbypjpfafukqmjnjg","yxgkdlwtkekavapflheieb"],["mkndeyrh","wuxnoibr"],["firomjjlidqpsdeqyn","oraxvssurmzybmnzhw"],["gkxpnpbfvjm","xbogegswmad"],["fpbnsbrkbcyzdmmmoisaa","rbnzendwnoklpyyyauemm"],["aiplrzejplumda","fnuqwejouqzrif"]]
*/
