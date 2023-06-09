// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.util.Map;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.io.PrintStream;
import java.util.Objects;
import java.util.List;
import java.io.Serializable;

public class Throwable implements Serializable
{
    private static final long serialVersionUID = -3042686055658047285L;
    private transient Object backtrace;
    private String detailMessage;
    private static final StackTraceElement[] UNASSIGNED_STACK;
    private Throwable cause;
    private StackTraceElement[] stackTrace;
    private static final List<Throwable> SUPPRESSED_SENTINEL;
    private List<Throwable> suppressedExceptions;
    private static final String NULL_CAUSE_MESSAGE = "Cannot suppress a null exception.";
    private static final String SELF_SUPPRESSION_MESSAGE = "Self-suppression not permitted";
    private static final String CAUSE_CAPTION = "Caused by: ";
    private static final String SUPPRESSED_CAPTION = "Suppressed: ";
    private static final Throwable[] EMPTY_THROWABLE_ARRAY;
    
    public Throwable() {
        this.cause = this;
        this.stackTrace = Throwable.UNASSIGNED_STACK;
        this.suppressedExceptions = Throwable.SUPPRESSED_SENTINEL;
        this.fillInStackTrace();
    }
    
    public Throwable(final String detailMessage) {
        this.cause = this;
        this.stackTrace = Throwable.UNASSIGNED_STACK;
        this.suppressedExceptions = Throwable.SUPPRESSED_SENTINEL;
        this.fillInStackTrace();
        this.detailMessage = detailMessage;
    }
    
    public Throwable(final String detailMessage, final Throwable cause) {
        this.cause = this;
        this.stackTrace = Throwable.UNASSIGNED_STACK;
        this.suppressedExceptions = Throwable.SUPPRESSED_SENTINEL;
        this.fillInStackTrace();
        this.detailMessage = detailMessage;
        this.cause = cause;
    }
    
    public Throwable(final Throwable cause) {
        this.cause = this;
        this.stackTrace = Throwable.UNASSIGNED_STACK;
        this.suppressedExceptions = Throwable.SUPPRESSED_SENTINEL;
        this.fillInStackTrace();
        this.detailMessage = ((cause == null) ? null : cause.toString());
        this.cause = cause;
    }
    
    protected Throwable(final String detailMessage, final Throwable cause, final boolean b, final boolean b2) {
        this.cause = this;
        this.stackTrace = Throwable.UNASSIGNED_STACK;
        this.suppressedExceptions = Throwable.SUPPRESSED_SENTINEL;
        if (b2) {
            this.fillInStackTrace();
        }
        else {
            this.stackTrace = null;
        }
        this.detailMessage = detailMessage;
        this.cause = cause;
        if (!b) {
            this.suppressedExceptions = null;
        }
    }
    
    public String getMessage() {
        return this.detailMessage;
    }
    
    public String getLocalizedMessage() {
        return this.getMessage();
    }
    
    public synchronized Throwable getCause() {
        return (this.cause == this) ? null : this.cause;
    }
    
    public synchronized Throwable initCause(final Throwable t) {
        if (this.cause != this) {
            throw new IllegalStateException("Can't overwrite cause with " + Objects.toString(t, "a null"), this);
        }
        if (t == this) {
            throw new IllegalArgumentException("Self-causation not permitted", this);
        }
        this.cause = t;
        return this;
    }
    
    @Override
    public String toString() {
        final String name = this.getClass().getName();
        final String localizedMessage = this.getLocalizedMessage();
        return (localizedMessage != null) ? (name + ": " + localizedMessage) : name;
    }
    
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }
    
    public void printStackTrace(final PrintStream printStream) {
        this.printStackTrace(new WrappedPrintStream(printStream));
    }
    
    private void printStackTrace(final PrintStreamOrWriter printStreamOrWriter) {
        final Set<Throwable> setFromMap = Collections.newSetFromMap(new IdentityHashMap<Throwable, Boolean>());
        setFromMap.add(this);
        synchronized (printStreamOrWriter.lock()) {
            printStreamOrWriter.println(this);
            final StackTraceElement[] ourStackTrace;
            final StackTraceElement[] array = ourStackTrace = this.getOurStackTrace();
            for (int length = ourStackTrace.length, i = 0; i < length; ++i) {
                printStreamOrWriter.println("\tat " + ourStackTrace[i]);
            }
            final Throwable[] suppressed = this.getSuppressed();
            for (int length2 = suppressed.length, j = 0; j < length2; ++j) {
                suppressed[j].printEnclosedStackTrace(printStreamOrWriter, array, "Suppressed: ", "\t", setFromMap);
            }
            final Throwable cause = this.getCause();
            if (cause != null) {
                cause.printEnclosedStackTrace(printStreamOrWriter, array, "Caused by: ", "", setFromMap);
            }
        }
    }
    
    private void printEnclosedStackTrace(final PrintStreamOrWriter printStreamOrWriter, final StackTraceElement[] array, final String str, final String s, final Set<Throwable> set) {
        assert Thread.holdsLock(printStreamOrWriter.lock());
        if (set.contains(this)) {
            printStreamOrWriter.println("\t[CIRCULAR REFERENCE:" + this + "]");
        }
        else {
            set.add(this);
            final StackTraceElement[] ourStackTrace = this.getOurStackTrace();
            int n = ourStackTrace.length - 1;
            for (int n2 = array.length - 1; n >= 0 && n2 >= 0 && ourStackTrace[n].equals(array[n2]); --n, --n2) {}
            final int i = ourStackTrace.length - 1 - n;
            printStreamOrWriter.println(s + str + this);
            for (int j = 0; j <= n; ++j) {
                printStreamOrWriter.println(s + "\tat " + ourStackTrace[j]);
            }
            if (i != 0) {
                printStreamOrWriter.println(s + "\t... " + i + " more");
            }
            final Throwable[] suppressed = this.getSuppressed();
            for (int length = suppressed.length, k = 0; k < length; ++k) {
                suppressed[k].printEnclosedStackTrace(printStreamOrWriter, ourStackTrace, "Suppressed: ", s + "\t", set);
            }
            final Throwable cause = this.getCause();
            if (cause != null) {
                cause.printEnclosedStackTrace(printStreamOrWriter, ourStackTrace, "Caused by: ", s, set);
            }
        }
    }
    
    public void printStackTrace(final PrintWriter printWriter) {
        this.printStackTrace(new WrappedPrintWriter(printWriter));
    }
    
    public synchronized Throwable fillInStackTrace() {
        if (this.stackTrace != null || this.backtrace != null) {
            this.fillInStackTrace(0);
            this.stackTrace = Throwable.UNASSIGNED_STACK;
        }
        return this;
    }
    
    private native Throwable fillInStackTrace(final int p0);
    
    public StackTraceElement[] getStackTrace() {
        return this.getOurStackTrace().clone();
    }
    
    private synchronized StackTraceElement[] getOurStackTrace() {
        if (this.stackTrace == Throwable.UNASSIGNED_STACK || (this.stackTrace == null && this.backtrace != null)) {
            final int stackTraceDepth = this.getStackTraceDepth();
            this.stackTrace = new StackTraceElement[stackTraceDepth];
            for (int i = 0; i < stackTraceDepth; ++i) {
                this.stackTrace[i] = this.getStackTraceElement(i);
            }
        }
        else if (this.stackTrace == null) {
            return Throwable.UNASSIGNED_STACK;
        }
        return this.stackTrace;
    }
    
    public void setStackTrace(final StackTraceElement[] array) {
        final StackTraceElement[] stackTrace = array.clone();
        for (int i = 0; i < stackTrace.length; ++i) {
            if (stackTrace[i] == null) {
                throw new NullPointerException("stackTrace[" + i + "]");
            }
        }
        synchronized (this) {
            if (this.stackTrace == null && this.backtrace == null) {
                return;
            }
            this.stackTrace = stackTrace;
        }
    }
    
    native int getStackTraceDepth();
    
    native StackTraceElement getStackTraceElement(final int p0);
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.suppressedExceptions != null) {
            List<Throwable> suppressed_SENTINEL;
            if (this.suppressedExceptions.isEmpty()) {
                suppressed_SENTINEL = Throwable.SUPPRESSED_SENTINEL;
            }
            else {
                suppressed_SENTINEL = new ArrayList<Throwable>(1);
                for (final Throwable t : this.suppressedExceptions) {
                    if (t == null) {
                        throw new NullPointerException("Cannot suppress a null exception.");
                    }
                    if (t == this) {
                        throw new IllegalArgumentException("Self-suppression not permitted");
                    }
                    suppressed_SENTINEL.add(t);
                }
            }
            this.suppressedExceptions = suppressed_SENTINEL;
        }
        if (this.stackTrace != null) {
            if (this.stackTrace.length == 0) {
                this.stackTrace = Throwable.UNASSIGNED_STACK.clone();
            }
            else if (this.stackTrace.length == 1 && SentinelHolder.STACK_TRACE_ELEMENT_SENTINEL.equals(this.stackTrace[0])) {
                this.stackTrace = null;
            }
            else {
                final StackTraceElement[] stackTrace = this.stackTrace;
                for (int length = stackTrace.length, i = 0; i < length; ++i) {
                    if (stackTrace[i] == null) {
                        throw new NullPointerException("null StackTraceElement in serial stream. ");
                    }
                }
            }
        }
        else {
            this.stackTrace = Throwable.UNASSIGNED_STACK.clone();
        }
    }
    
    private synchronized void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        this.getOurStackTrace();
        final StackTraceElement[] stackTrace = this.stackTrace;
        try {
            if (this.stackTrace == null) {
                this.stackTrace = SentinelHolder.STACK_TRACE_SENTINEL;
            }
            objectOutputStream.defaultWriteObject();
        }
        finally {
            this.stackTrace = stackTrace;
        }
    }
    
    public final synchronized void addSuppressed(final Throwable cause) {
        if (cause == this) {
            throw new IllegalArgumentException("Self-suppression not permitted", cause);
        }
        if (cause == null) {
            throw new NullPointerException("Cannot suppress a null exception.");
        }
        if (this.suppressedExceptions == null) {
            return;
        }
        if (this.suppressedExceptions == Throwable.SUPPRESSED_SENTINEL) {
            this.suppressedExceptions = new ArrayList<Throwable>(1);
        }
        this.suppressedExceptions.add(cause);
    }
    
    public final synchronized Throwable[] getSuppressed() {
        if (this.suppressedExceptions == Throwable.SUPPRESSED_SENTINEL || this.suppressedExceptions == null) {
            return Throwable.EMPTY_THROWABLE_ARRAY;
        }
        return this.suppressedExceptions.toArray(Throwable.EMPTY_THROWABLE_ARRAY);
    }
    
    static {
        UNASSIGNED_STACK = new StackTraceElement[0];
        SUPPRESSED_SENTINEL = Collections.unmodifiableList((List<? extends Throwable>)new ArrayList<Throwable>(0));
        EMPTY_THROWABLE_ARRAY = new Throwable[0];
    }
    
    private static class SentinelHolder
    {
        public static final StackTraceElement STACK_TRACE_ELEMENT_SENTINEL;
        public static final StackTraceElement[] STACK_TRACE_SENTINEL;
        
        static {
            STACK_TRACE_ELEMENT_SENTINEL = new StackTraceElement("", "", null, Integer.MIN_VALUE);
            STACK_TRACE_SENTINEL = new StackTraceElement[] { SentinelHolder.STACK_TRACE_ELEMENT_SENTINEL };
        }
    }
    
    private abstract static class PrintStreamOrWriter
    {
        abstract Object lock();
        
        abstract void println(final Object p0);
    }
    
    private static class WrappedPrintStream extends PrintStreamOrWriter
    {
        private final PrintStream printStream;
        
        WrappedPrintStream(final PrintStream printStream) {
            this.printStream = printStream;
        }
        
        @Override
        Object lock() {
            return this.printStream;
        }
        
        @Override
        void println(final Object o) {
            this.printStream.println(o);
        }
    }
    
    private static class WrappedPrintWriter extends PrintStreamOrWriter
    {
        private final PrintWriter printWriter;
        
        WrappedPrintWriter(final PrintWriter printWriter) {
            this.printWriter = printWriter;
        }
        
        @Override
        Object lock() {
            return this.printWriter;
        }
        
        @Override
        void println(final Object o) {
            this.printWriter.println(o);
        }
    }
}
