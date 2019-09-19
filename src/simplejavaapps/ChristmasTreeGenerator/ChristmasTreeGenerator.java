package simplejavaapps.ChristmasTreeGenerator;

public class ChristmasTreeGenerator {

    private char treeSign = 'O';
    private char backgroundSign = '+';
    private int height = 5;
    private int ratio = 1;
    private int distanceFromLeft = 0;  // width of background outside both sides of the lowest tree line
    private String tree = "";

    // default constructor
    public ChristmasTreeGenerator()
    {
        generateTree(this.treeSign,this.backgroundSign,this.height,this.ratio,this.distanceFromLeft);
    }

    //parametric constructor
    public ChristmasTreeGenerator(char treeSign, char backgroundSign, int height, int ratio,int distanceFromLeft)
    {
        this.treeSign=treeSign;
        this.backgroundSign=backgroundSign;
        this.height = height;
        this.ratio = ratio;
        this.distanceFromLeft = distanceFromLeft;

        generateTree(this.treeSign,this.backgroundSign,this.height,this.ratio,this.distanceFromLeft);
    }


    @Override
    public String toString() {
        return this.tree;
    }

    private void generateTree(char treeSign, char backgroundSign, int height, int ratio,int distanceFromLeft)
    {
        // make sure distance from left is 0 or more (otherwise it make pyramid from left)
        distanceFromLeft = (distanceFromLeft<0)?0:distanceFromLeft;

        // line pass and final result String holders
        StringBuilder treeBuilder = new StringBuilder();
        StringBuilder output = new StringBuilder();

        // calculate how many treeSigns and backgroundSigns for first line is needed
        int empties = ((height*ratio)-ratio)+ distanceFromLeft;
        int signs = 1;

        //line pass loop
        for(int i=0;i<height;i++)
        {
            // clear line pass holder
            output.setLength(0);

            // fill with backgroundSign from left
           for(int e=empties;e>0;e--)
           {
               output.append(backgroundSign);
           }
           // fill with treeSign
           for(int s=0;s<signs;s++)
           {
               output.append(treeSign);
           }
           // fill with backgroundSign to right
           for(int e=empties;e>0;e--)
           {
               output.append(backgroundSign);
           }

           // set initial values for next line pass
           empties=empties-(1*ratio);
           signs=signs+(ratio*2);

           // add line pass to final result holder
           treeBuilder.append(output.toString());
           treeBuilder.append(System.lineSeparator());
        }

        // get result
        this.tree = treeBuilder.toString();

    }

}
