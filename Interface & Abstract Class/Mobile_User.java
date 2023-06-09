interface SIM
{
	void calling();
	void sendSMS();
}

class JIO implements SIM
{
	public void calling()
	{
		System.out.println("Calling with JIO");
	}
	public void sendSMS()
	{
		System.out.println("SMS with JIO");
	}
}

class AIRTEL implements SIM
{
	public void calling()
	{
		System.out.println("Calling with AIRTEL");
	}
	public void sendSMS()
	{
		System.out.println("SMS with AIRTEL");
	}
}

class VI implements SIM
{
	public void calling()
	{
		System.out.println("Calling with VI");
	}
	public void sendSMS()
	{
		System.out.println("SMS with VI");
	}
}

class Mobile
{
	public void insertSIM(SIM s)
	{
		s.calling();
		s.sendSMS();
	}
}

class Mobile_User
{
	public static void main(String args[])
	{
		Mobile Nokia=new Mobile();
		Nokia.insertSIM(new AIRTEL());
		Nokia.insertSIM(new JIO());
	}
}