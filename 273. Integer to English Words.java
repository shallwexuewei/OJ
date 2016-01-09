public class Solution {
    private final String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] bigs = {"", "Thousand", "Million", "Billion"};
    private final String hundred = "Hundred";
    private final String negative = "Negative";

    public String numberToWords(int num) {
        if(num == 0) {
            return smalls[0];
        }
        if(num < 1) {
            return "";
        }
        
        LinkedList<String> parts = new LinkedList<String>();
        int chunkCount = 0;
        
        while(num > 0) {
            if(num % 1000 != 0) {
                String chunk = convertChunk(num % 1000);
                if(chunkCount != 0)
                    chunk += " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000;
            chunkCount++;
        }
        
        return listToString(parts);
    }
    
    String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<String>();
        
        if(number >= 100) {
            parts.addLast(smalls[number/100]);
            parts.addLast(hundred);
            number %= 100;
        }
        
        /* convert tens place */
        if(number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number %= 10;
        }
        
        /* convert ones place */
        if(number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }
        
        return listToString(parts);
    }
    
    /* Convert a linked list of strings to a string, dividing it up with spaces */
    String listToString(LinkedList<String> parts) { 
        StringBuilder sb = new StringBuilder();
        while(parts.size() > 1) {
            String lastStr = parts.pop(); 
            sb.append(lastStr);
            sb.append(" ");
        }
        sb.append(parts.pop()); 
        return sb.toString();
    }
    
    
    
    
}

/*
Input:
123
Output:
"One Hundred Twenty Three "
Expected:
"One Hundred Twenty Three"
*/
