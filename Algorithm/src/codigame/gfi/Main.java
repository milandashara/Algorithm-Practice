package codigame.gfi;

abstract class Animal {

	 abstract String getName();
}

class Dog extends Animal {
	String name;

	/**
	 * Creates a new dog with the given name.
	 */
	Dog(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
}

class Cat extends Animal {
	String name;

	/**
	 * Creates a new cat with the given name.
	 */
	Cat(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
}

class Application {

	/**
	 * @return the name of the given animal
	 */
	static String getAnimalName(Animal a) {
		return a.getName();
	}
}
