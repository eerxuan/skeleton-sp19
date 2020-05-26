import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertEquals(true, offByOne.equalChars('a', 'b'));
        assertEquals(true, offByOne.equalChars('c', 'b'));
        assertEquals(true, offByOne.equalChars('+', '*'));
        assertEquals(true, offByOne.equalChars('*', '+'));
        assertEquals(true, offByOne.equalChars('A', 'B'));
        assertEquals(false, offByOne.equalChars('A', 'A'));
        assertEquals(false, offByOne.equalChars('a', 'a'));
        assertEquals(false, offByOne.equalChars('a', 'c'));
        assertEquals(false, offByOne.equalChars('a', 'A'));
        assertEquals(false, offByOne.equalChars('%', '%'));
    }
}
