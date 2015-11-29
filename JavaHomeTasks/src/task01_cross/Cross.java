package task01_cross;

import java.util.Scanner;

public class Cross {

	
	private static final String QUIT_KEY = "q";
	static int[][] matrix;
	
	static void BuildMatrix(int size) {
		matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = 1;
			matrix[i][size - i - 1] = 1;
		}
	}
	
	private static void PrintMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String task = null;  
		int matrixSize = 0;
		do {
			task = scanner.nextLine();
			try {
				matrixSize = Integer.parseInt(task);				
				BuildMatrix(matrixSize);
				PrintMatrix();
			} catch(Exception e) {
				if (task.compareTo(QUIT_KEY) != 0) {
					System.out.println("Not an integer or \"q\" command");					
				}
			}
		} while(task.compareTo(QUIT_KEY) != 0);
		scanner.close();
	}

}
