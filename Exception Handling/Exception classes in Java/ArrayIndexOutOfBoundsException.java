// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
{
    private static final long serialVersionUID = -5116101128118950844L;
    
    public ArrayIndexOutOfBoundsException() {
    }
    
    public ArrayIndexOutOfBoundsException(final int i) {
        super("Array index out of range: " + i);
    }
    
    public ArrayIndexOutOfBoundsException(final String s) {
        super(s);
    }
}
