package task3;

import sun.misc.IOUtils;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Iurii_Stepanchuk on 12/12/2017.
 */
public class SolutionIter implements Iterable<Integer> {

    private List<Integer> integerList;

    public SolutionIter(Reader inp) {
        this.integerList = getIntegerListFromReader(inp);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SolutionIterator();
    }

    private class SolutionIterator implements
            Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return integerList.iterator().hasNext();
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                Integer result = integerList.iterator().next();
                integerList.remove(result);
                return result;
            }
            throw new NoSuchElementException();
        }
    }

    List<Integer> getIntegerListFromReader(Reader inp) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] buff = new char[1000];
        int val = -1;
        try {
            while ((val = inp.read(buff)) != -1) {
                stringBuilder.append(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = stringBuilder.toString().split("\\n");
        List<Integer> numbers = new ArrayList<>();
        for (String line : lines) {
            try {
                Integer number = Integer.parseInt(line.trim());
                if (Math.abs(number) <= 1000_000_000) {
                    numbers.add(number);
                }
            } catch (NumberFormatException e) {
            }
        }
        return numbers;
    }

}