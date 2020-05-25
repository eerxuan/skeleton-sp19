/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 0;
        Palindrome palindrome = new Palindrome();

        for (int offBy = 0; offBy < 26; offBy++) {
            int i = 0;
            OffByN offByN = new OffByN(offBy);
            In in = new In("../library-sp19/data/words.txt");
            while (!in.isEmpty()) {
                String word = in.readString();

                if (word.length() >= minLength && palindrome.isPalindrome(word, offByN)) {
                    i += 1;
                    //                System.out.println(word);
                }
            }
            System.out.printf("Palindrome words longer than %d off by %d: %d\n",
                    minLength, offBy, i);
        }
    }
}
