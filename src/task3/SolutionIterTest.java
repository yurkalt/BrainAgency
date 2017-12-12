package task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Iurii_Stepanchuk on 12/12/2017.
 */
public class SolutionIterTest {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = new FileReader("Test");
            SolutionIter solutionIter = new SolutionIter(reader);
            for (Integer sol: solutionIter) {
                System.out.println(sol);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
