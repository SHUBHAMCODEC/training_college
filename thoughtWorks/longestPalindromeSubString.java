package thoughtWorks;

public class longestPalindromeSubString {
    
    // Tracks the starting index and total length of the longest palindrome found
    private static int resultStart = 0;
    private static int resultLength = 0;

    public static String longestPalindrome(String s) {
        // Edge case: empty string or single character
        if (s == null || s.length() < 1) {
            return "";
        }

        // Reset tracking variables for fresh execution
        resultStart = 0;
        resultLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindromes (e.g., "aba", center is 'b')
            expandAroundCenter(s, i, i);
            
            // Case 2: Even-length palindromes (e.g., "abba", center is between 'b' and 'b')
            expandAroundCenter(s, i, i + 1);
        }

        // Extract and return the longest palindrome substring
        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void expandAroundCenter(String s, int left, int right) {
        // Expand outward as long as characters on both sides match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Calculate length of the valid palindrome found
        // (right - 1) - (left + 1) + 1 simplifies to right - left - 1
        int currentLength = right - left - 1;

        // Update global tracking if a longer palindrome is found
        if (currentLength > resultLength) {
            resultStart = left + 1; // The palindrome started at left + 1 due to the final loop decrement
            resultLength = currentLength;
        }
    }

    public static void main(String[] args) {
        String testInput = "babad";
        String lps = longestPalindrome(testInput);
        
        System.out.println("Input String: " + testInput);
        System.out.println("Longest Palindromic Substring: \"" + lps + "\"");
    }
}
