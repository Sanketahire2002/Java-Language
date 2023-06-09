class Bike
{
    private int engineno,bikeno;
    private String colour,owner;

    public Bike(int engineno,String colour)
    {
        this.engineno = engineno;
        this.colour = colour;
    }

    public void getEngineno()
    {
        System.out.println("Bike Engine Number = "+this.engineno);
    }

    public void getColour()
    {
        System.out.println("Bike Colour = "+this.colour);
    }

    public void getBikeno()
    {
        System.out.println("Bike Bike Number = "+this.bikeno);
    }

    public void getOwner()
    {
        System.out.println("Bike Engine Number = "+this.owner);
    }

    public void setBikeno(int bikeno)
    {
        this.bikeno = bikeno;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }
}

class Encapsulation
{
    public static void main(String[] args)
    {
        Bike pulsar = new Bike(55820,"Red");

        pulsar.setBikeno(1100);
        pulsar.setOwner("Sanket");
        pulsar.getEngineno();
        pulsar.getColour();
        pulsar.getBikeno();
        pulsar.getOwner();
    }
}