class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;

       
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
           
            reverse(arr, 0, n - 1);
        } else {
            // Step 2: Find element just larger than arr[idx] from right
            for (int i = n - 1; i > idx; i--) {
                if (arr[i] > arr[idx]) {
                    swap(arr, i, idx);
                    break;
                }
            }
          
            reverse(arr, idx + 1, n - 1);
        }


        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
