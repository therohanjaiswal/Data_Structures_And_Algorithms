
// https://www.geeksforgeeks.org/find-k-closest-numbers-in-an-unsorted-array/
import java.util.*;

class Solution {
    // TC: O(n*k), SC: O(1)
    public static ArrayList<Integer> findKClosestNaive(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        // ith iteration finds out ith closest val
        for (int i = 0; i < k; ++i) {
            int minDiff = Integer.MIN_VALUE;
            int minDiffIndex = -1;
            for (int j = 0; j < n; ++j) {
                if (visited[j] == false && Math.abs(arr[j] - x) <= minDiff) {
                    minDiff = Math.abs(arr[j] - x);
                    minDiffIndex = j;
                }
            }
            res.add(arr[minDiffIndex]);
            visited[minDiff] = true;
        }
        return res;
    }

    // TC: O(nlog(k)), SC: O(k)
    // This doesn't work if same difference is occuring twice, ie., if x = 10
    // and arr is [.., 5, 10, 15], 10 -5 = 5 and 15 - 10 = 5. diff = 5 in both case.
    // arr must contain elements with distinct difference.
    public static ArrayList<Integer> findKClosestEfficient(int[] arr, int k, int x) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, new MyComparator());

        for (int i = 0; i < k; ++i)
            minHeap.add(new Pair(Math.abs(arr[i] - x), i));

        for (int i = k; i < n; ++i) {
            int diff = Math.abs(arr[i] - x);
            if (minHeap.peek().diff > diff) {
                minHeap.remove();
                minHeap.add(new Pair(diff, arr[i]));
            }
        }

        for (int i = 0; i < k; ++i)
            res.add(arr[minHeap.remove().index]);

        Collections.sort(res);
        return res;
    }

    // This function works for duplicate difference also. If difference is equal
    // then consider the smaller element.
    // TC: O(n + klog(n)), SC: O(k)
    public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) {
        // Your code goes here
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<MyPair> minHeap = new PriorityQueue<>(k, new MyComparator2());

        for (int i = 0; i < n; ++i)
            minHeap.add(new MyPair(Math.abs(arr[i] - x), arr[i]));

        for (int i = 0; i < k; ++i)
            res.add(minHeap.remove().element);

        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, 14, 4, 7, 6 };
        int x = 5, k = 3;
        ArrayList<Integer> res = findKClosestNaive(arr, k, x);
        System.out.println(res);
        res = findKClosestEfficient(arr, k, x);
    }
}

// Comparator asks if p1 is greater or not.
// 1 means p1 is greater, 0 means equal, -1 means smaller
class MyComparator2 implements Comparator<MyPair> {
    public int compare(MyPair p1, MyPair p2) {
        if (p1.diff > p2.diff)
            return 1;
        else if (p1.diff < p2.diff)
            return -1;

        // if p1.diff == p2.diff
        if (p1.element > p2.element)
            return 1;
        return 0;
    }
}

class MyComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if (p1.diff > p2.diff)
            return 1;
        else if (p1.diff < p2.diff)
            return -1;
        return 0;
    }
}

class MyPair {
    int diff;
    int element;

    MyPair(int d, int e) {
        diff = d;
        element = e;
    }
}

class Pair {
    int diff;
    int index;

    Pair(int d, int i) {
        diff = d;
        index = i;
    }
}