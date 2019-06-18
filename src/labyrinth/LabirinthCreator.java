/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Point;
import java.util.Arrays;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author User
 */
public class LabirinthCreator {

    int sizeX;
    int sizeY;
    Random rg;
    boolean[][] array;
    boolean[][] clone;
    private int bestScore;

    public LabirinthCreator() {
        rg = new Random();
    }

    public void creator() {
        array = new boolean[sizeX][sizeY];
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                array[i][j] = i % 2 != 0 && j % 2 != 0
                        && i < sizeX - 1 && j < sizeY - 1;
            }
        }
        rg = new Random();
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(1, 1));
        while (stack.size() > 0) {
            Point current = stack.peek();
            List<Point> unusedNeighbors = new LinkedList<>();
            //left
            if (current.x > 2) {
                if (!isUsedCell(current.x - 2, current.y)) {
                    unusedNeighbors.add(new Point(current.x - 2, current.y));
                }
            }
            //top
            if (current.y > 2) {
                if (!isUsedCell(current.x, current.y - 2)) {
                    unusedNeighbors.add(new Point(current.x, current.y - 2));
                }
            }
            //right
            if (current.x < sizeX - 2) {
                if (!isUsedCell(current.x + 2, current.y)) {
                    unusedNeighbors.add(new Point(current.x + 2, current.y));
                }
            }
            //bottom
            if (current.y < sizeY - 2) {
                if (!isUsedCell(current.x, current.y + 2)) {
                    unusedNeighbors.add(new Point(current.x, current.y + 2));
                }
            }
            if (unusedNeighbors.size() > 0) {
                int rnd = rg.nextInt(unusedNeighbors.size());
                Point direction = unusedNeighbors.get(rnd);
                int diffX = (direction.x - current.x) / 2;
                int diffY = (direction.y - current.y) / 2;
                array[current.x + diffX][current.y + diffY] = true;
                stack.push(direction);
            } else {
                if (bestScore < stack.size()) {
                    bestScore = stack.size();
                    // exit
                    array[0][0] = true;
                    array[0][1] = true;
                    array[1][0] = true;
                    array[sizeX - 2][sizeY - 2] = true;
                }
                stack.pop();
            }
        }
        clone = new boolean[sizeX][sizeY];
        for (int i = 0; i < array.length; i++) {
            clone[i] = Arrays.copyOf(array[i], array[i].length);
        }
        mixed();
    }

    private boolean isUsedCell(int x, int y) {
        if (x < 0 || y < 0 || x >= sizeX - 1 || y >= sizeY - 1) {
            return true;
        }
        return array[x][y - 1] //left
                || array[x - 1][y] //top
                || array[x][y + 1] //right
                || array[x + 1][y]; //bottom
    }

    public boolean[][] getArray() {
        return array;
    }

    public boolean[][] getClone() {
        return clone;
    }

    public void setSize(int level) {
        if (level == 1) {
            sizeX = 21;
            sizeY = 39;
        } else if (level == 2) {
            sizeX = 39;
            sizeY = 75;
        } else {
            sizeX = 63;
            sizeY = 123;
        }
    }

    public boolean[][] revers(int i, int j) {
        for (int k = 0; k < 2; k++) {
            try {
                boolean temp;
                boolean temp2;
                temp = clone[j][i + 2];
                clone[j][i + 2] = clone[j][i + 1];
                temp2 = clone[j + 1][i + 2];
                clone[j + 1][i + 2] = temp;
                temp = clone[j + 2][i + 2];
                clone[j + 2][i + 2] = temp2;
                temp2 = clone[j + 2][i + 1];
                clone[j + 2][i + 1] = temp;
                temp = clone[j + 2][i];
                clone[j + 2][i] = temp2;
                temp2 = clone[j + 1][i];
                clone[j + 1][i] = temp;
                temp = clone[j][i];
                clone[j][i] = temp2;
                clone[j][i + 1] = temp;
            } catch (ArrayIndexOutOfBoundsException e) {
                return clone;
            }
        }
        return clone;
    }

    public boolean[][] correctOne(int i, int j) {
        clone[j][i] = array[j][i];
        clone[j][i + 1] = array[j][i + 1];
        clone[j][i + 2] = array[j][i + 2];
        clone[j + 1][i] = array[j + 1][i];
        clone[j + 2][i] = array[j + 2][i];
        clone[j + 1][i + 2] = array[j + 1][i + 2];
        clone[j + 2][i + 1] = array[j + 2][i + 1];
        clone[j + 2][i + 2] = array[j + 2][i + 2];
        return clone;
    }

    private void mixed() {
        int a = 0;
        for (int k = 0; k < sizeX - 2; k += 3) {
            for (int p = 0; p < sizeY - 2; p += 3) {
                if (k == 0 && p == 0) {
                    continue;
                }
                a = rg.nextInt(3);
                while (a > 0) {
                    revers(p, k);
                    a--;
                }
            }
        }
    }

}
