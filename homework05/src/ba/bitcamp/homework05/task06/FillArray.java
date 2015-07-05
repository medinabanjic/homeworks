package ba.bitcamp.homework05.task06;

public class FillArray {

	public static void main(String[] args) {
		int[][] matrix = new int[3][5];
		fillArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	public static void fillArray(int[][] matrix, int a, int b, int c) {
		if (a == matrix.length) {
			return;
		}
		if (b == matrix[a].length - 1) {
			matrix[a][b] = c;
			fillArray(matrix, ++a, 0, ++c);
		} else {
			matrix[a][b] = c;
			fillArray(matrix, a, ++b, ++c);
		}
	}
}