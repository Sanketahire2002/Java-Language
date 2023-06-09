// Inheritance Type 3 : Hybrid Inheritance

class A {}

class B extends A   {}

class C extends A   {}

class D extends A   {}

class E extends B   {}

class F extends B   {}

class G extends B   {}

class H extends B   {}

class I extends C   {}

class J extends I   {}

class K extends J   {}

class L extends K   {}

// class Z extends Z   {}      Cyclic Inheritance Not Allowed

class Inheritance_Type_4 extends A
{
    public static void main(String[] args)
    {

    }
}