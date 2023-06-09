abstract class Vehicle
{
	abstract void brake();
	abstract void engine();
	void vehicleNumber()
	{
		System.out.println("VehicleNumber method in abstract Main Parent Class");
	}
	
	void inAll()
	{
		System.out.println("inAll method in all Classes");
	}
}

abstract class Car extends Vehicle
{
	void brake()
	{
		System.out.println("Brake method in Abstract Car class");
	}
	
	abstract void engine();
}

abstract class Bus extends Vehicle
{
	void brake()
	{
		System.out.println("Brake method in Abstract Bus class");
	}
	
	abstract void engine();
}

class BMW extends Car
{
	void engine()
	{
		System.out.println("Engine method in child BMW class of Parent Car class");
	}
}

class Jeep extends Car
{
	void engine()
	{
		System.out.println("Engine method in child Jeep class of Parent Car class");
	}
}

class MHRTC extends Bus
{
	void engine()
	{
		System.out.println("Engine method in child MHRTC class of Parent Bus class");
	}
}

class Olo extends Bus
{
	void engine()
	{
		System.out.println("Engine method in child Olo class of Parent Bus class");
	}

	void brake()
	{
		System.out.println("*********************");
	}
	
}

class Abstract
{
	public static void main(String[] args)
	{
		Vehicle b = new BMW();
		Vehicle j = new Jeep();
		Vehicle m = new MHRTC();
		Vehicle o = new Olo();
		
		b.engine();
		b.brake();
		
		j.engine();
		j.brake();
		
		m.engine();
		m.brake();
		
		o.engine();
		o.brake();
		
		b.vehicleNumber();
		j.vehicleNumber();
		m.vehicleNumber();
		o.vehicleNumber();
	}
}
