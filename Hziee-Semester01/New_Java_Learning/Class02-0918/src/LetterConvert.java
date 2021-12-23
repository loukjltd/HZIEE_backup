import java.io.IOException;

public class LetterConvert {
    public static void main(String[] args) throws IOException {
        char testLetter;
        testLetter = (char) System.in.read();
        System.out.printf("%c", testLetter - 32);
    }
}
