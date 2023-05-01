//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// Time = Avg O(N) Similar to Stepcase, Worst O(N * log N) BS on each row
// Space = O(1)

class Solution {
    int binarySearch(int arr[][], int row, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[row][mid] == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    int rowWithMax1s(int arr[][], int rows, int cols) {
        int right = cols - 1, ans = -1;

        for (int row = 0; row < rows; row++) {
            int mid = binarySearch(arr, row, 0, right);
            if (mid <= right) {
                ans = row;
                right = mid - 1;
            }
        }

        return ans;
    }
}