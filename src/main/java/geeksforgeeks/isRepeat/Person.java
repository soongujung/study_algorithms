package geeksforgeeks.isRepeat;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/check-if-a-linked-list-is-circular-linked-list/
 */
public class Person {
	public static Set<Person> registry = new HashSet<Person>();

	private String name;
	private Person head = null;
	private Person nextPerson = null;
	public static boolean isRepeat = false;

	public Person(String name) {
		this.name = name;
	}

	public void setNextPerson(Person target) {
		if(head == null) {
			head = this;
			registry.add(this);
		}

		if(registry.contains(target)){
			isRepeat = true;
			return;
		}

		if(!registry.contains(target)){
			registry.add(target);
			this.nextPerson = target;
			return;
		}
	}

	public boolean isRepeat(){
		return isRepeat;
	}

	public static void main(String [] args){
		Person a = new Person("A");
		Person b = new Person("B");
		Person c = new Person("C");

		// case 1)				a -> b -> c -> a -> null
//		a.setNextSong(b);
//		b.setNextSong(c);
//		c.setNextSong(a);

		// case 2)				a -> b -> c -> b -> null
//		a.setNextSong(b);
//		b.setNextSong(c);
//		c.setNextSong(b);

		// case 3) 				a -> b -> c -> null
		a.setNextPerson(b);
		b.setNextPerson(c);

		System.out.println("is A repeat ? :: " + a.isRepeat());
		System.out.println("is B repeat ? :: " + b.isRepeat());
		System.out.println("is C repeat ? :: " + c.isRepeat());
	}
}
