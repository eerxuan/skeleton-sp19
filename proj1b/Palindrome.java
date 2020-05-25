public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() == 1 || word.isEmpty()) {
            return true;
        }
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeDeque(deque);
    }

    private boolean isPalindromeDeque(Deque<Character> deque) {
        if (deque.size() == 1 || deque.isEmpty()) {
            return true;
        }

        if (deque.removeFirst() != deque.removeLast()) {
            return false;
        } else {
            return isPalindromeDeque(deque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        if (word.length() == 1 || word.isEmpty()) {
            return true;
        }
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeDequeCC(deque, cc);
    }

    private boolean isPalindromeDequeCC(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 1 || deque.isEmpty()) {
            return true;
        }

        if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return false;
        } else {
            return isPalindromeDequeCC(deque, cc);
        }
    }
}
