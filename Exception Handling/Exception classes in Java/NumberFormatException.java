// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

public class NumberFormatException extends IllegalArgumentException
{
    static final long serialVersionUID = -2848938806368998894L;
    
    public NumberFormatException() {
    }
    
    public NumberFormatException(final String s) {
        super(s);
    }
    
    static NumberFormatException forInputString(final String str) {
        return new NumberFormatException("For input string: \"" + str + "\"");
    }
}
