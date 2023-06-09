interface Animal
{
	void eat();
	void sleep();
}

class Lion implements Animal
{
	public void eat()
	{
		System.out.println("Lion eats meat ");
	}
	public void sleep()
	{
		System.out.println("Lion lives in cave");
	}
}

class Rabbit implements Animal
{
	public void eat()
	{
		System.out.println("Rabbit eats grass");
	}
	public void sleep()
	{
		System.out.println("Rabbit lives in dig");
	}
}

class Zoo
{
	public static void sendAnimal(Animal a)
	{
		a.eat();
		a.sleep();
	}
}

class Animal_User
{
	public static void main(String args[])
	{
		Zoo.sendAnimal(new Rabbit());
		Zoo.sendAnimal(new Lion());
	}
}
