package simplejavaapps;

public class Anagram {

    public static void anagram(String word)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = word.length()-1;i>=0;i--)
        {
            stringBuilder.append(word.charAt(i));
        }

        System.out.println(stringBuilder.toString());
    }

}
