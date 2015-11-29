package task07_DogBrainMood;

import task07_DogBrainMood.Dog.BrainState;

public class GoodMood implements BrainState {

	private static final int MAX_STROKES = 3;
	int count;
	Dog dog;

	public GoodMood(Dog dog) {
		this.dog = dog;
	}

	@Override
	public void feed() {
		dog.eat();
		dog.wag();
	}

	@Override
	public void stroke() {
		dog.wag();
		dog.bark();
		count++;
		if (count >= MAX_STROKES) {
			dog.brainState = new BadMood(dog);
		}
	}

}