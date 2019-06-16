package arrays;

class Sort {
    /**
     * insertion Sort complexity O(nSquare)
     * 
     * @param array
     * @param asc
     */
    public void insertionSort(int[] array, boolean asc) {
        if (array == null || array.length < 2)
            return;
        for (int j = 1; j < array.length; j++) {
            int current = array[j];
            int i = j - 1;
            while (i >= 0 && comparator(array[i], current, asc)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = current;
        }

    }

    boolean comparator(int i, int j, boolean asc) {
        if (asc)
            return i > j;
        return j > i;
    }
/**
 *  Selection Sort
 *  Complexity O(nSquare)
 * @param array
 * @param asc
 */
    public void selectionSort(int[] array, boolean asc) {
        if (array == null || array.length < 2)
            return;
        for (int j = 0; j < array.length - 1; j++) {
            int current = array[j];
            int i = j + 1;
            int minOrMax = array[j];
            int index = j;
            while (i < array.length) {
                if (comparator(min, array[i], asc)) {
                    minOrMax = array[i];
                    index = i;
                }
                i++;
            }
            array[j] = minOrMax;
            array[index] = current;
        }
    }

    public static void main(String[] args) {
        System.out.println("Sort");
        {
            int[] array = new int[] { 1, 7, 3, 5, 4 };
            System.out.println("insertion sort asc");
            new Sort().insertionSort(array, true);
            for (int i : array) {
                System.out.println(i);
            }
            System.out.println("insertion sort desc");
            new Sort().insertionSort(array, false);
            for (int i : array) {
                System.out.println(i);
            }
        }
        {
            int[] array = new int[] { 1, 7, 3, 5, 4 };
            System.out.println("Selection Sort asc");
            new Sort().selectionSort(array, true);
            for (int i : array) {
                System.out.println(i);
            }

            new Sort().selectionSort(array, false);
            System.out.println("Selection Sort desc");
            for (int i : array) {
                System.out.println(i);
            }
        }

    }
}