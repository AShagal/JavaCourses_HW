package task02_inheritance;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Construction {
	
	static class ArraySaver {
		
		void saveToFile(String fileName, int[] data) {
			try {
				PrintWriter pw = new PrintWriter(fileName);
				for (int i = 0; i < data.length; i++) {
					pw.print(i + " ");
				}
				pw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	static class TreeSaver extends ArraySaver {
		
		
	
		@Override
		void saveToFile(String fileName, int[] data) {
			try {
				PrintWriter pw = new PrintWriter(fileName);
				String tree = printTree(0, data);
				pw.print(tree);
				pw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private String printTree(int index, int[] data) {
			String tree = "(";
			
			if(index < data.length) {
				tree += Integer.toString(data[index]);
				if(!(index * 2 + 1 > data.length && index * 2 + 3 > data.length)) {					
					tree += printTree(index * 2 + 1, data);
					tree += printTree(index * 2 + 2, data);
				}
			}
			tree += ")";
			
			return tree;
		}
	}
	
	public static void main(String[] args) {
		int[] data = {1,2,3,1,8,5};
		
		TreeSaver treeSaver = new TreeSaver();
		treeSaver.saveToFile("myTree.txt", data);
	}
	
}
