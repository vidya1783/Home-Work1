package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken() };

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		List<Singable> singableThings=new ArrayList<>();
		singableThings.add(new Cow());
		singableThings.add(new Chicken());
		singableThings.add(new Tractor ("Big Green","Vroom Vroom"));
		singableThings.add (new Horse("Bojack","Whinnie"));
		for (Singable thing :singableThings){
			String name=thing.getName();
			String sound = thing.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		//A dual interface approach
		List <Rideable>rideableThings =new ArrayList<>();
		rideableThings.add(new Horse("Brian", "Whinnie"));
		rideableThings.add(new Tractor("Big Green", "Chug"));
		for(Rideable thing:rideableThings){
			thing.Ride();
		}
		List<Singable> singableRideableThings=new ArrayList<>();
		singableRideableThings.add(new Cow());
		singableRideableThings.add(new Chicken());
		singableRideableThings.add(new Tractor ("Big Green","Vroom Vroom"));
		singableRideableThings.add (new Horse("Bojack","Whinnie"));
		for (Singable thing :singableRideableThings){
			String name=thing.getName();
			String sound = thing.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			if (thing instanceof Rideable) {

				((Rideable)thing).Ride();

			}

			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

	}
}