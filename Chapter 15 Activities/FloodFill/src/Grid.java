
import java.util.Stack;

public class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    private int fillCount;
    
    public Grid()
    {
        // The pixels array is automatically initialized to all 0s.
        fillCount = 1;
    }
    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, column));

        while (!stack.isEmpty())
        {
            Pair current = stack.pop();
            int r = current.row;
            int c = current.col;

            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && pixels[r][c] == 0)
            {
                pixels[r][c] = fillCount++;

                stack.push(new Pair(r - 1, c)); // North
                stack.push(new Pair(r, c + 1)); // East
                stack.push(new Pair(r + 1, c)); // South
                stack.push(new Pair(r, c - 1)); // West
            }
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
