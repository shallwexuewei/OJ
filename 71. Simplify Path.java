public class Solution {
    public String simplifyPath(String path) {
        String[] entries = path.split("/");
        LinkedList<String> list = new LinkedList<String>();
        for(String entry:entries) {
            if(entry.isEmpty() || entry.equals(".")){
                continue;
            }
            if(entry.equals("..") ){
                if(!list.isEmpty())    list.removeLast();
            } else {
                list.add(entry);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        if(list.isEmpty()){
            return "/";
        }
        
        while(!list.isEmpty()) {
            builder.append('/');
            builder.append(list.removeFirst());
        }
        return builder.toString();
    }
}
