package task02_inheritance;

import java.util.ArrayList;

public class Generalization {

	
	class Picture {
		
		int width;
		int height;
		String fileName;
		
		void show() {
			// show picture
		}
		
	}
	
	class AnimatedPicture extends Picture {
		int fps;
		ArrayList<String> frames;
		
		@Override
		void show() {
			//show animation
		}
	}
}
