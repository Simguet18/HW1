import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int length = array.length;

        if (direction == 'L') {
            move = -move;       // Convert left shift to right shift
        } else if (direction != 'R') {
            return array;       // Invalid direction, return the original array
        }

        if (array == null || array.length <= 1) {
            return array;       // No change needed for null or single-element arrays
        }

       
        if (length == move) {
            return array;       // No change needed if the shift is equal to the length of the array
        }

        move = move % length;   // Normalize the move value to avoid unnecessary full rotations

        for (int i = 0; i < Math.abs(move); i++) {
            if (move > 0) { // Right shift
                int lastElement = array[length - 1];
                for (int j = length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = lastElement;
            } else { // Left shift
                int firstElement = array[0];
                for (int j = 0; j < length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[length - 1] = firstElement;
            }
        }
        
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}