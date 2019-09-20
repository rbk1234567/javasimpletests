package simplejavaapps.LifeGame;

public class LifeGame {
    private int[][] grid = new int[4][4]; //initial grid

// default constructor
    public LifeGame() {

    }

    // parametric constructor
    public LifeGame(int[][] grid) {
        if(grid.length>2 & grid[0].length>2) {
            this.grid = grid;
        }
        else {
            System.out.println("Cannot initialize grid with too small dimensions ("+grid.length+","+grid[0].length+"). Default grid will be used");
        }
    }

    // make choosen cell live
    public void setCellLive(int x,int y)
    {
        try {
            this.grid[y][x] = 1;
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("You have tried to make cell["+x+"]["+y+"] live but it doesn't exist.");
        }
    }

    public int[][] getGrid()
    {
        return this.grid;
    }

    // generate new grid according to game rules
    public void nextGeneration() {
        int[][] result = new int[grid.length][grid[0].length];

        // loop through grid cells to apply game rules to each one
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {

                // get number of living cells surrounding choosen cell
                int numberOfLifeNeighbors = (getNumberOfLivingNeighbors(getNeighborsCoordinates(x, y)));

                //game rules for living cells
                if (grid[x][y] == 1) {

                    if(numberOfLifeNeighbors>=2)
                    {
                        if (numberOfLifeNeighbors > 3) {
                            result[x][y] = 0;
                        }
                        else
                        {
                            result[x][y] = 1;
                        }
                    }

                    if (numberOfLifeNeighbors < 2) {
                        result[x][y] = 0;
                    }

                }

                //game rules for dead cells
                if (grid[x][y] == 0) {
                    if (numberOfLifeNeighbors == 3) {
                        result[x][y] = 1;
                    }
                }


            }
        }

        grid = result;
    }

    private int getNumberOfLivingNeighbors(int[][] neighborsCoordinates) {
        // returns number of living cells at given grid coordinates

        int count = 0; // number of living cells

        // loop through neighbors coordinates to check grid for its values
        for (int x = 0; x < neighborsCoordinates.length; x++) {
            if (grid[neighborsCoordinates[x][0]][neighborsCoordinates[x][1]] == 1) {
                count++;
            }
        }

        return count;
    }

    private int[][] getNeighborsCoordinates(int x, int y) {
        // generate coordinates for given cell neighbors

        /*
        TL|TM|TR
        ML|CC|MR
        BL|BM|BR

        CC-choosen cell
         */


        int[][] nCoordinates = new int[8][2];

        nCoordinates[0][0] = (x == 0) ? grid.length - 1 : x - 1; //top left x
        nCoordinates[0][1] = (y == 0) ? grid[0].length - 1 : y - 1; //top left y

        nCoordinates[1][0] = x; //top middle x
        nCoordinates[1][1] = (y == 0) ? grid[0].length - 1 : y - 1; //top middle y

        nCoordinates[2][0] = (x == grid.length - 1) ? 0 : x + 1; //top right x
        nCoordinates[2][1] = (y == 0) ? grid[0].length - 1 : y - 1; //top right y

        nCoordinates[3][0] = (x == 0) ? grid.length - 1 : x - 1; //middle left x
        nCoordinates[3][1] = y; //middle left y

        nCoordinates[4][0] = (x == 0) ? grid.length - 1 : x - 1; //bottom left x
        nCoordinates[4][1] = (y == grid[0].length - 1) ? 0 : y + 1; //bottom left y

        nCoordinates[5][0] = x; //bottom middle x
        nCoordinates[5][1] = (y == grid[0].length - 1) ? 0 : y + 1; //bottom middle y

        nCoordinates[6][0] = (x == grid.length - 1) ? 0 : x + 1; //bottom right x
        nCoordinates[6][1] = (y == grid[0].length - 1) ? 0 : y + 1; //bottom right y

        nCoordinates[7][0] = (x == grid.length - 1) ? 0 : x + 1; //middle right x
        nCoordinates[7][1] = y; //middle right y

        return nCoordinates;
    }

    @Override
    public String toString() {

        //create result String holders
        StringBuilder stringBuilderOuter = new StringBuilder(); //result loop String holder
        StringBuilder stringBuilderInner = new StringBuilder(); //line pass String holder

        //loop grid cells and add its values to result String
        for (int x = 0; x < grid.length; x++) {

            stringBuilderInner.setLength(0);
            for (int y = 0; y < grid[x].length; y++) {
                stringBuilderInner.append(grid[x][y]);
                stringBuilderInner.append(" "); //make more space between values horizontally
            }

            //add line pass to result String
            stringBuilderOuter.append(stringBuilderInner.toString());
            stringBuilderOuter.append(System.lineSeparator());

        }

        return stringBuilderOuter.toString();
    }
}
