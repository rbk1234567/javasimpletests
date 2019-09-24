package simplejavaapps.LifeGame;

public class LifeGame {
    private int[][] grid = new int[4][4]; //initial grid

    // default constructor
    public LifeGame() {

    }

    // parametric constructor
    public LifeGame(int[][] grid) {
        if (grid.length > 2 & grid[0].length > 2) {
            this.grid = grid;
        } else {
            System.out.println("Cannot initialize grid with too small dimensions (" + grid.length + "," + grid[0].length + "). Default grid will be used");
        }
    }

    // make choosen cell live
    public void setCellLive(int x, int y) {
        try {
            this.grid[y][x] = 1;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You have tried to make cell[" + x + "][" + y + "] live but it doesn't exist.");
        }
    }

    public int[][] getGrid() {
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

                    if (numberOfLifeNeighbors >= 2) {
                        if (numberOfLifeNeighbors > 3) {
                            result[x][y] = 0;
                        } else {
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

        int[][] nCoordinates = new int[8][2];

        int xSize = this.grid.length;
        int ySize = this.grid[0].length;
        int pointNumber = 0;

        for (int xDist = -1; xDist <= 1; xDist++) {
            for (int yDist = -1; yDist <= 1; yDist++) {
                if (xDist == 0 & yDist == 0) {
                    //this is actual cell x,y not neighbors coordinate

                }else{
                    nCoordinates[pointNumber][0]=FoldGridCoordinateX(x+xDist);
                    nCoordinates[pointNumber][1]=FoldGridCoordinateY(y+yDist);

                    pointNumber++;
                }

            }

        }

        return nCoordinates;

    }

    private int FoldGridCoordinateX(int i) {
        int xGridSize = this.grid.length;
        return (i+xGridSize) % xGridSize;
    }

    private int FoldGridCoordinateY(int i) {
        int yGridSize = this.grid[0].length;
        return (i+yGridSize) % yGridSize;
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
