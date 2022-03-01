import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ScrabbleDriver
{
    public static void main (String [] args) throws FileNotFoundException
    {
        ScrabbleHelper sH = new ScrabbleHelper();
        System.out.println(sH.getWordList().get(66349));
        ArrayList<String> test = sH.findMatches("cat");
        System.out.println(test);
        sH.sortList(test);
        System.out.println(test);
        test = sH.wordMaker("oieflbr");
        System.out.println(test);
        sH.sortByScores(test);
        System.out.println(test);
    }

    public void reader() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        ScrabbleHelper sH = new ScrabbleHelper();
        while (scan.hasNext())
        {
            System.out.print("Enter a word to test: ");
            String s = scan.next();
            if (sH.foundWord(s))
            {
                System.out.println(" \" " + s + "\" is a word");
            }
            else
            {
                System.out.println(" \" " + s + "\" is not a word");
            }
        }
        System.out.println("Goob-bye!");
    }
}
