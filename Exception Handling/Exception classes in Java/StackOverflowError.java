// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

public class StackOverflowError extends VirtualMachineError
{
    private static final long serialVersionUID = 8609175038441759607L;
    
    public StackOverflowError() {
    }
    
    public StackOverflowError(final String message) {
        super(message);
    }
}
