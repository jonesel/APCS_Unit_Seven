import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleHelper {
    private ArrayList<String> wordList = new ArrayList<>();

    public ScrabbleHelper() throws FileNotFoundException
    {
        File text = new File("files/enable.txt");
        Scanner scan = new Scanner(text);
        while (scan.hasNext()) {
            String s = scan.next();
            wordList.add(s);
        }
    }
    public ArrayList<String> getWordList()
    {
        return wordList;
    }
    public boolean foundWord(String word)
    {
        int left = 0;
        int right = wordList.size()- 1;
        while (left <= right)
        {
            int middle = (left + right) / 2;
            if (word.compareTo(wordList.get(middle)) < 0)
            {
                right = middle - 1;
            }
            else if (word.compareTo(wordList.get(middle)) > 0)
            {
                left = middle + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public ArrayList findMatches(String s)
    {
        ArrayList<String> patterns = new ArrayList<>();
        for (int j = 0; j < wordList.size(); j++)
        {
            if (wordList.get(j).contains(s))
            {
                patterns.add(wordList.get(j));
            }
        }
        return patterns;

    }
    public void sortList( ArrayList<String> test) {
        for (int j = 0; j < test.size() - 1; j++) {
            int minIndex = j;
            for (int k = j + 1; k < test.size(); k++) {
                if ((test.get(k)).length() < ((test.get(minIndex)).length())) {
                    minIndex = k;
                }
            }
            String temp = test.get(j);
            test.add(j, test.get(minIndex));
            test.remove(j + 1);
            test.add(minIndex, temp);
            test.remove(minIndex + 1);
        }
    }
    public ArrayList wordMaker(String s)
    {
        ArrayList<String> words = new ArrayList<>();
        for (int ii = 0; ii< wordList.size(); ii++)
        {
            ArrayList<Character> tiles = new ArrayList<>();
            for (int jj = 0; jj<s.length();jj++)
            {
                tiles.add(s.charAt(jj));
            }
            int ww;
            for (ww = 0; ww<wordList.get(ii).length(); ww++)
            {
                if (tiles.contains(wordList.get(ii).charAt(ww)))
                {
                    for(int aa = 0; aa<tiles.size();aa++)
                    {
                        if (tiles.get(aa).equals(wordList.get(ii).charAt(ww)))
                        {
                            tiles.remove(aa);
                            break;
                        }
                    }
                }
                else
                {
                    break;
                }
            }
            if (ww == wordList.get(ii).length())
            {
                words.add(wordList.get(ii));
            }
        }
        return words;
    }
    public int getScores(String s)
    {
        int value = 0;
        int[] scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        for (int ii = 0; ii<s.length(); ii++)
        {
            value+=scores[s.charAt(ii)-'a'];
        }
        return value;
    }
    public void sortByScores( ArrayList<String> test)
    {
        for (int j = 1; j < test.size(); j++)
        {
            int score = getScores(test.get(j));
            String temp = test.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && score > getScores(test.get(possibleIndex - 1)))
            {
                test.add(possibleIndex, test.get(possibleIndex-1));
                test.remove(possibleIndex+1);
                possibleIndex--;
            }
            test.add(possibleIndex, temp);
            test.remove(possibleIndex+1);
        }
    }

}



