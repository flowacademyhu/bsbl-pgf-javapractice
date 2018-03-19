import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnagramMain {

    static ArrayList<String> words;
    static String speech = "Friends, Romans, countrymen, lend me your ears;\n" +
            "I come to bury Caesar, not to praise him.\n" +
            "The evil that men do lives after them;\n" +
            "The good is oft interred with their bones;\n" +
            "So let it be with Caesar. The noble Brutus\n" +
            "Hath told you Caesar was ambitious:\n" +
            "If it were so, it was a grievous fault,\n" +
            "And grievously hath Caesar answer'd it.\n" +
            "Here, under leave of Brutus and the rest-\n" +
            "For Brutus is an honourable man;\n" +
            "So are they all, all honourable men-\n" +
            "Come I to speak in Caesar's funeral.\n" +
            "He was my friend, faithful and just to me:\n" +
            "But Brutus says he was ambitious;\n" +
            "And Brutus is an honourable man.\n" +
            "He hath brought many captives home to Rome\n" +
            "Whose ransoms did the general coffers fill:\n" +
            "Did this in Caesar seem ambitious?\n" +
            "When that the poor have cried, Caesar hath wept:\n" +
            "Ambition should be made of sterner stuff:\n" +
            "Yet Brutus says he was ambitious;\n" +
            "And Brutus is an honourable man.\n" +
            "You all did see that on the Lupercal\n" +
            "I thrice presented him a kingly crown,\n" +
            "Which he did thrice refuse: was this ambition?\n" +
            "Yet Brutus says he was ambitious;\n" +
            "And, sure, he is an honourable man.\n" +
            "I speak not to disprove what Brutus spoke,\n" +
            "But here I am to speak what I do know.\n" +
            "You all did love him once, not without cause:\n" +
            "What cause withholds you then, to mourn for him?\n" +
            "O judgment! thou art fled to brutish beasts,\n" +
            "And men have lost their reason. Bear with me;\n" +
            "My heart is in the coffin there with Caesar,\n" +
            "And I must pause till it come back to me. ";

    public static void main(String[] args) {
        AnagramMain am = new AnagramMain();
        //System.out.println(am.regexMaker("abc"));
        //Pattern pattern = Pattern.compile(am.regexMaker("abc"));
        //System.out.println(pattern.matcher("abc").matches());
        am.textToSArray(speech);
        //Matcher matcher = pattern.matcher(words);
        am.getAnagrams("that");
    }

    public void textToSArray(String t) {
        String text = t;
        text = text.toLowerCase().replaceAll("[\\n]", " ").replaceAll("[\\.\\;\\?\\:\\,\\-]", "").trim();
        words = new ArrayList<String>(Arrays.asList(text.split(" ")));
        //System.out.println(words);
        //System.out.println(text);
    }

    public void getAnagrams(String word) {
        Pattern pattern = Pattern.compile(regexMaker(word));
        System.out.println("The anagrams of the word " + "'" + word + "'" + " are:");
        for(int i = 0; i < words.size(); i++) {
            if(pattern.matcher(words.get(i)).matches()) {
                System.out.println(words.get(i));
            }
        }
    }

    public String regexMaker(String expression) {
        final ArrayList<String> regexList = new ArrayList<String>();
        char[] characters = new char[expression.length()];
        expression.toLowerCase().getChars(0, expression.length(), characters, 0);
        HashMap<Character, String> regexParts = new HashMap<Character, String>();

        for (int i = 0; i < characters.length; i++) {
            if(!regexParts.containsKey(characters[i])) {
                regexParts.put(characters[i], "(?=.*" + characters[i]);
            } else {
                String tmp = regexParts.get(characters[i]);
                regexParts.put(characters[i], tmp + ".*" + characters[i]);
            }
        }

        regexParts.forEach((key, value) -> {
            String tmp = regexParts.get(key);
            regexParts.put(key, tmp + ")");
            regexList.add(regexParts.get(key));

        });

        String regex = "";
        for(int i = 0; i < regexList.size(); i++) {
            regex += regexList.get(i);
        }

        regex += "^";
        for(int i = 0; i < characters.length; i++) {
            regex += ".";
        }
        regex += "$";

        return regex;
    }
}
