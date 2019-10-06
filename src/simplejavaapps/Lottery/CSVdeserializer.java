package simplejavaapps.Lottery;

import java.io.*;
import java.nio.charset.Charset;


public class CSVdeserializer {

    static final String PATH="/home/rbk/Pobrane/lottery.csv";


    public String getFileStringData()
    {
        InputStream inputStream = null;
        String output = null;
        try {
            inputStream = new FileInputStream(PATH);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));


            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringBuilder stringBuilder = new StringBuilder();


            while(line != null){
                stringBuilder.append(line).append("\n");
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


    public LotteryEntry[] deserializeData(String data)
    {
        String[] lines = data.split(System.lineSeparator());
        LotteryEntry[] output = new LotteryEntry[lines.length-1];
        for(int i=1;i<lines.length;i++)
        {

            String[] lineValues = lines[i].split(",");
            for(String s:lineValues)
            {
                s = s.replace("\"","");
                //System.out.println(s);
            }

            output[i-1] = new LotteryEntry(lineValues[0],lineValues[1],lineValues[2],lineValues[3],lineValues[4]);

        }

        return output;

    }
}
