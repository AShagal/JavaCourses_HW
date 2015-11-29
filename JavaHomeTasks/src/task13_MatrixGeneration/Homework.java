package task13_MatrixGeneration;

import java.util.Random;

public class Homework {

	public static void main(String[] args) {

		System.out.println("Start generation");
		long startGenerate = System.nanoTime();
		double[][] matrix = generate();
		long endGenerate = System.nanoTime();
		System.out.println("Generation time: " + ((endGenerate - startGenerate) / 1_000_000) + "ms");

		System.out.println("Start processing");
		long start = System.nanoTime();
		process(matrix);
		long stop = System.nanoTime();
		System.out.println("Processing time: " + ((stop - start) / 1_000_000) + " ms");


	}

	private static void process(double[][] matrix) {

		Thread[] threads = new Thread[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			final double[] row = matrix[i];
			threads[i] = new Thread() {
				@Override
				public void run() {
					processRow(row);
				};
			};
			threads[i].start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void processRow(double[] ds) {
		for (int i = 0; i < ds.length; i++) {
			Math.pow(ds[i], ds[i]);
		}
	}

	private static void generateRow(double[] row, Random random) {
		for (int j = 0; j < row.length; j++) {
			row[j] = random.nextDouble();
		}
	}

	private static double[][] generate() {

		// TODO make me multi-threaded!

		Random random = new Random();
		double[][] matrix = new double[10][10_000_000];
		Thread[] threads = new Thread[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			final double[] row = matrix[i];
			threads[i] = new Thread() {
				@Override
				public void run() {
					generateRow(row, random);
				}

			};
			threads[i].start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return matrix;
	}

}
