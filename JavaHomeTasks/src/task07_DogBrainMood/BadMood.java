package task07_DogBrainMood;

import task07_DogBrainMood.Dog.BrainState;

public class BadMood implements BrainState {

	Dog dog;

	public BadMood(Dog dog) {
		this.dog = dog;
	}

	@Override
	public void feed() {
		dog.eat();
		dog.brainState = new GoodMood(dog);
	}

	@Override
	public void stroke() {
		dog.bite();
	}

}
