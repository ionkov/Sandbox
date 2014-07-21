import java.util.Arrays;


/**
 * @author George Ionkov
 *
 */
public class CirclePrint {

    public static void main(String args[] ) throws Exception {
        int r = 5;
        int c = 5;
        
        // Assuming input will not be malformed read the matrix
        int[][] matrix = new int[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0 ; i < c * r; i++) {
            matrix[y][x] = i;
            if (x == c - 1) {
                x = 0;
                y++;
            } else {
                x++;
            }
        }
                
        for (int i = 0; i < r; i++) {
        	System.out.println(Arrays.toString(matrix[i]));
        }
        
        
        print(matrix, 0, 0, -1, c, -1, r, true);
    }
    
    
    protected static void print(int[][] matrix, int x, int y, int minX, int maxX, int minY, int maxY, boolean updated) {
    	 //System.out.println("params: " + x + " " + y + " " + minX + " " + maxX + " " + minY + " " + maxY + " " + updated);

    	 int ox = x;
    	 int oy = y;
    	 
        if (x + 1 < maxX && y - 1 == minY) {
            // Go right if possible
            if (x - 1 == minX) {
                if (!updated){
                    minX++;
                }
                updated = !updated;
            }
            x++;
        } else if (y + 1 < maxY && x + 1 == maxX) {
            // Go down if possible
            if (y - 1 == minY) {
                if (!updated){
                    minY++;
                }
                updated = !updated;
            }
            y++;
        } else if (x - 1 > minX && y + 1 == maxY) {
            // Go left if possible            
            if (x + 1 == maxX) {
                if (!updated){
                    maxX--;
                } 
                updated = !updated;
            }
            x--;
        } else if (y - 1 > minY && x - 1 == minX) {
            // Go up if possible                        
            if (y + 1 == maxY) {
                if (!updated){
                    maxY--;
                }
                updated = !updated;
            }
            y--;
        } else {
            // Base Case: we are in the middle so print the last character and return.
            return;
        }
        
        // General Case: print and recurse
        if (ox != 0 || oy != 0) {
        	System.out.print(",");
        }
        System.out.print(matrix[oy][ox]);
        print(matrix, x , y, minX, maxX, minY, maxY, updated);
    }
}
