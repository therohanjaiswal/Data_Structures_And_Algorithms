class Solution {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 3, 4, 5, 5, 6 };
        frequencyCount(arr);
    }

    public static void frequencyCount(int[] arr) {
        int n = arr.length;
        int j = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {

            if (arr[j] != arr[i]) {
                System.out.print(arr[j] + "-");
                j = i;
                System.out.println(count);
                count = 1;
            } else {
                ++count;
            }
        }
        System.out.print(arr[j] + "-");
        System.out.println(count);
    }
}
