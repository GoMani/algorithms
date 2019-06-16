package arrays;

class Sort {
/**
 * insertion Sort
 * complexity O(nSquare)
 * @param array
 * @param asc
 */
    public void insertionSort(int[] array, boolean asc) {

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

    public static void main(String[] args) {
        System.out.println("Sort");
        int[] array = new int[] { 1, 2, 3, 5, 4 };
        new Sort().insertionSort(array, false);
        for (int i : array) {
            System.out.println(i);
        }
    }
}