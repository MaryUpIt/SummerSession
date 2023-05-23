package src.com.session.summer.programs;

public class Alphabet {

    public static void printAlphabet() {
        char letter = 'a';
        while (letter <= 'z') {
            System.out.print(letter == 'z' ? letter : letter + ", ");
            letter++;
        }
    }
}
