package simplejavaapps.CommandCalc;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class CommandCalcFileLoader {

    public static String[] loadFile(String filePath)
    {
        String[] commands = getStringFromFile(filePath).split(System.lineSeparator());

        return commands;
    }


    private static String getStringFromFile(String filePath)
    {
        String output = null;
        try {
            InputStream inputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));


            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringBuilder stringBuilder = new StringBuilder();


            while(line != null){
                if(!line.isEmpty()) {
                    stringBuilder.append(line).append("\n");
                }
                try {
                    line = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            output = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return output;
    }

}
