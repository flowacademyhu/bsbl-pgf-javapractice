import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;

public class PoemMain {

    public static void main(String[] args) {
        PoemMain poemMain = new PoemMain();

        String hunRules =  ("< a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS" +
                "< e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J" +
                "< k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó" +
                "< ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T" +
                "< ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS");

        PoemReader poemSort = new PoemReader();
        String[] poemArray = poemSort.readFile("poem.txt");

        try {
            RuleBasedCollator hunCollator = new RuleBasedCollator(hunRules);
            poemMain.sortStrings(hunCollator, poemArray);
        } catch (ParseException pe) {
            System.out.println("Parse exception for rules");
        }

        // Sorts the words by frequency
        poemMain.sortByFrequency(poemMain.mapMaker(poemArray));
        // Bundles the words with the same frequency
        poemMain.sortByFrequencyReloaded(poemMain.mapMakerReloaded(poemArray));
    }

    public void sortStrings(Collator collator, String[] words) {
        String tmp;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (collator.compare(words[i], words[j]) > 0) {
                    tmp = words[i];
                    words[i] = words[j];
                    words[j] = tmp;
                }
            }
        }
    }
    public HashMap<String, Integer> mapMaker(String[] poemArray) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String word: poemArray) {
            if(wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }

    public void sortByFrequency(HashMap<String, Integer> map) {
        List<WordCounterWrapper> wrapperList = new ArrayList<>();
        for(String key: map.keySet()) {
            wrapperList.add(new WordCounterWrapper(key, map.get(key)));
        }
        Collections.sort(wrapperList);

        for(WordCounterWrapper element: wrapperList) {
            System.out.println(element);
        }
    }

    public void sortByFrequencyReloaded(HashMap<Integer, ArrayList<String>> map) {
        List<WordCounterWrapper> wrapperList = new ArrayList<>();
        for(Integer key: map.keySet()) {
            wrapperList.add(new WordCounterWrapper(map.get(key), key));
        }
        Collections.sort(wrapperList);

        for(WordCounterWrapper element: wrapperList) {
            System.out.println(element);
        }
    }

    public HashMap<Integer, ArrayList<String>> mapMakerReloaded(String[] poemArray) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String word: poemArray) {
            if(wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        HashMap<Integer, ArrayList<String>> newWordMap = new HashMap<>();
        ArrayList<String> tmp = new ArrayList<>();
        for(Map.Entry<String, Integer> element : wordMap.entrySet()) {
            if(newWordMap.containsKey(element.getValue())) {
                tmp = newWordMap.get(element.getValue());
                tmp.add(element.getKey());
                newWordMap.put(element.getValue(), tmp);
            } else {
                tmp.add(element.getKey());
                newWordMap.put(element.getValue(), tmp);
            }
            tmp = new ArrayList<>();
        }
        return newWordMap;
    }
}
