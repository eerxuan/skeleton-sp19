import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertEquals(true, palindrome.isPalindrome("noon"));
        assertEquals(true, palindrome.isPalindrome("a"));
        assertEquals(true, palindrome.isPalindrome(""));
        assertEquals(false, palindrome.isPalindrome("car"));
        assertEquals(false, palindrome.isPalindrome("aaaaaabaaaaaaa"));
        assertEquals(false, palindrome.isPalindrome(null));

    }

    @Test
    public void testIsPalindromeOffByOne() {
        OffByOne offByOne = new OffByOne();
        assertEquals(true, palindrome.isPalindrome("flake", offByOne));
        assertEquals(true, palindrome.isPalindrome("f", offByOne));
        assertEquals(false, palindrome.isPalindrome("fff", offByOne));
        assertEquals(false, palindrome.isPalindrome("tees", offByOne));
        assertEquals(false, palindrome.isPalindrome(null, offByOne));
    }
}
