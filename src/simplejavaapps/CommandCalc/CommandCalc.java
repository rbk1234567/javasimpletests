package simplejavaapps.CommandCalc;

public class CommandCalc {

    public static void runCommandsFromFile(String filePath)
    {
        String[] commands = CommandCalcFileLoader.loadFile(filePath);


        if(isInputCorrect(commands)==true)
        {

            double applyNumber = Double.valueOf(commands[commands.length-1].substring(commands[commands.length-1].lastIndexOf(" "),commands[commands.length-1].length()));
            for(int i=0;i<commands.length-1;i++) {
                applyNumber = runCommand(commands[i],applyNumber);
            }
            System.out.println("Result is: "+applyNumber);
        }



    }

    private static double runCommand(String command, double applyNumber) {
        double result = applyNumber;
        String[] commandParts = command.split(" ");

        switch(CommandCalcCommands.valueOf(commandParts[0]))
        {
            case add:
            {
                result=result+Double.valueOf(commandParts[1]);
                break;
            }
            case subtract:
            {
                result=result-Double.valueOf(commandParts[1]);
                break;
            }
            case multiply:
            {
                result=result*Double.valueOf(commandParts[1]);
                break;
            }
            case divide:
            {
                result=result/Double.valueOf(commandParts[1]);
                break;
            }
            default:
            {
                break;
            }

        }
        return result;
    }

    private static boolean isInputCorrect(String[] commands) {
        boolean result = true;


        if(commands[commands.length-1].contains(CommandCalcCommands.apply.toString()))
        {
            for (String command:commands) {
                String[] line = command.split(" ");
                if(line.length!=2)
                {
                    System.out.println("Command line format is incorrect");
                    result = false;
                }
                else
                {
                    try{
                        Double.parseDouble(line[1]);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Cannot parse one of the numbers");
                        result = false;
                    }
                }

            }
        }
        else
        {
            System.out.println("File doesn't contain APPLY command");
            result = false;
        }

        return result;
    }

}
