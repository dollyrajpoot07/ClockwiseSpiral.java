// Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
// For example, given the following matrix:
// Input:
// [[1,  2,  3,  4,  5],
//  [6,  7,  8,  9,  10],
//  [11, 12, 13, 14, 15],
//  [16, 17, 18, 19, 20]]
// You should print out the following:
// Output:
// 1
// 2
// 3
// 4
// 5
// 10
// 15
// 20
// 19
// 18
// 17
// 16
// 11
// 6
// 7
// 8
// 9
// 14
// 13
// 12

import java.util.*;

class ClockwiseSpiral {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();

		if (matrix.length == 0)
			return ans;

		int m = matrix.length, n = matrix[0].length;
		boolean[][] seen = new boolean[m][n];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int x = 0, y = 0, di = 0;

		for (int i = 0; i < m * n; i++) {
			ans.add(matrix[x][y]);
			seen[x][y] = true;
			int cr = x + dr[di];
			int cc = y + dc[di];

			if (0 <= cr && cr < m && 0 <= cc && cc < n
				&& !seen[cr][cc]) {
				x = cr;
				y = cc;
			}
			else {
				di = (di + 1) % 4;
				x += dr[di];
				y += dc[di];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = sc.nextInt();
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Enter values of array[m][n]: " );
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
		System.out.println(spiralOrder(arr));
        sc.close();
	}
}
