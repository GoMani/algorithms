/**
 * http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
 * Sort an array of 0s, 1s and 2s
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
Examples:

Input :  {0, 1, 2, 0, 1, 2}
Output : {0, 0, 1, 1, 2, 2}

Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
class DutchNationalFlagProblem {
    /**
     * Sort array containing 0s 1s and 2s Time Complexity O(n)
     * 
     * @param arr
     */
    public static void sortArray(int[] arr) {
        if(arr==null || arr.length <=1) return;
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid < high) {
            int temp;
            switch (arr[mid]) {
            case 0:
                temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
                break;
            case 1:
                mid++;
                break;
            case 2:
                temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
                break;
            }

        }

    }

    public static void main(String[] args) {
        {
            int[] arr = new int[] { 0, 1, 0, 0, 2, 1, 2 };
            sortArray(arr);
            for (int i : arr) {
                System.out.println(i);
            }
        }
        {
            int[] arr = new int[] { 0 };
            sortArray(arr);
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }

}