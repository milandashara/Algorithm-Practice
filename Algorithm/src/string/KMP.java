package string;

/**
 * 
 * @author Milan
 * Substring
 * 
 * Search for Pattern in String
 *
 */
public class KMP {

	/**
	 * Calculate LSP Table
	 * 
	 * L[i]=Length of longest matching prefix and suffix  at i
	 * @param pattern
	 * @return
	 */
	static int[] computeLspTable(String pattern) {
	    int[] lsp = new int[pattern.length()];
	    lsp[0] = 0;  // Base case
	    for (int i = 1; i < pattern.length(); i++) {
	        // Start by assuming we're extending the previous LSP
	        int j = lsp[i - 1];
	        
	        
	        while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
	        	j = lsp[j - 1];
	        
	        if (pattern.charAt(i) == pattern.charAt(j))
	        	j++;
	        
	        lsp[i] = j;
	    }
	    return lsp;
	}
	
	
	/**
	 * KMP Search
	 * 
	 * If mismatch occurs at Pattern j , fall back in pattern by LSP[j-1] , i.e j=LSP[j-1].
	 * So we don't have to start from begining every time where we save time. It uses extra space of Size M.
	 * 
	 * Time = Size of pattern * size of String
	 * @param pattern
	 * @param text
	 * @return
	 */
	static int  search(String pattern, String text) {
	    int[] lsp = computeLspTable(pattern);
	    
	    int j = 0;  // Number of chars matched in pattern
	    for (int i = 0; i < text.length(); i++) {
	        while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
	            // Fall back in the pattern
	            j = lsp[j - 1];  // Strictly decreasing
	        }
	        if (text.charAt(i) == pattern.charAt(j)) {
	            // Next char matched, increment position
	            j++;
	            
	            //found substring
	            if (j == pattern.length())
	                return i - (j - 1);
	        }
	    }
	    
	    return -1;  // Not found
	}
	
	public static void main(String[] args) {
		String str="abcabacbababc";
		String pattern="abab";
		int startIndex=search(pattern, str);
		System.out.println(startIndex);
		System.out.println(str.substring(startIndex,startIndex+pattern.length()));
	}
	
}
