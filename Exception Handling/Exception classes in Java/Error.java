// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

public class Error extends Throwable
{
    static final long serialVersionUID = 4980196508277280342L;
    
    public Error() {
    }
    
    public Error(final String message) {
        super(message);
    }
    
    public Error(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public Error(final Throwable cause) {
        super(cause);
    }
    
    protected Error(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
