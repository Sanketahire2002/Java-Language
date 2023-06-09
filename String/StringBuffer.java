// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.io.ObjectStreamField;
import java.io.Serializable;

public final class StringBuffer extends AbstractStringBuilder implements Serializable, CharSequence
{
    private transient char[] toStringCache;
    static final long serialVersionUID = 3388685877147921107L;
    private static final ObjectStreamField[] serialPersistentFields;
    
    public StringBuffer() {
        super(16);
    }
    
    public StringBuffer(final int capacity) {
        super(capacity);
    }
    
    public StringBuffer(final String s) {
        super(s.length() + 16);
        this.append(s);
    }
    
    public StringBuffer(final CharSequence charSequence) {
        this(charSequence.length() + 16);
        this.append(charSequence);
    }
    
    @Override
    public synchronized int length() {
        return this.count;
    }
    
    @Override
    public synchronized int capacity() {
        return this.value.length;
    }
    
    @Override
    public synchronized void ensureCapacity(final int minimumCapacity) {
        super.ensureCapacity(minimumCapacity);
    }
    
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
    }
    
    @Override
    public synchronized void setLength(final int length) {
        this.toStringCache = null;
        super.setLength(length);
    }
    
    @Override
    public synchronized char charAt(final int index) {
        if (index < 0 || index >= this.count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return this.value[index];
    }
    
    @Override
    public synchronized int codePointAt(final int index) {
        return super.codePointAt(index);
    }
    
    @Override
    public synchronized int codePointBefore(final int index) {
        return super.codePointBefore(index);
    }
    
    @Override
    public synchronized int codePointCount(final int beginIndex, final int endIndex) {
        return super.codePointCount(beginIndex, endIndex);
    }
    
    @Override
    public synchronized int offsetByCodePoints(final int index, final int codePointOffset) {
        return super.offsetByCodePoints(index, codePointOffset);
    }
    
    @Override
    public synchronized void getChars(final int srcBegin, final int srcEnd, final char[] dst, final int dstBegin) {
        super.getChars(srcBegin, srcEnd, dst, dstBegin);
    }
    
    @Override
    public synchronized void setCharAt(final int index, final char c) {
        if (index < 0 || index >= this.count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        this.toStringCache = null;
        this.value[index] = c;
    }
    
    @Override
    public synchronized StringBuffer append(final Object o) {
        this.toStringCache = null;
        super.append(String.valueOf(o));
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final String str) {
        this.toStringCache = null;
        super.append(str);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final StringBuffer sb) {
        this.toStringCache = null;
        super.append(sb);
        return this;
    }
    
    @Override
    synchronized StringBuffer append(final AbstractStringBuilder asb) {
        this.toStringCache = null;
        super.append(asb);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final CharSequence s) {
        this.toStringCache = null;
        super.append(s);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final CharSequence s, final int start, final int end) {
        this.toStringCache = null;
        super.append(s, start, end);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final char[] str) {
        this.toStringCache = null;
        super.append(str);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final char[] str, final int offset, final int len) {
        this.toStringCache = null;
        super.append(str, offset, len);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final boolean b) {
        this.toStringCache = null;
        super.append(b);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final char c) {
        this.toStringCache = null;
        super.append(c);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final int i) {
        this.toStringCache = null;
        super.append(i);
        return this;
    }
    
    @Override
    public synchronized StringBuffer appendCodePoint(final int codePoint) {
        this.toStringCache = null;
        super.appendCodePoint(codePoint);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final long l) {
        this.toStringCache = null;
        super.append(l);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final float f) {
        this.toStringCache = null;
        super.append(f);
        return this;
    }
    
    @Override
    public synchronized StringBuffer append(final double d) {
        this.toStringCache = null;
        super.append(d);
        return this;
    }
    
    @Override
    public synchronized StringBuffer delete(final int start, final int end) {
        this.toStringCache = null;
        super.delete(start, end);
        return this;
    }
    
    @Override
    public synchronized StringBuffer deleteCharAt(final int index) {
        this.toStringCache = null;
        super.deleteCharAt(index);
        return this;
    }
    
    @Override
    public synchronized StringBuffer replace(final int start, final int end, final String str) {
        this.toStringCache = null;
        super.replace(start, end, str);
        return this;
    }
    
    @Override
    public synchronized String substring(final int n) {
        return this.substring(n, this.count);
    }
    
    @Override
    public synchronized CharSequence subSequence(final int start, final int end) {
        return super.substring(start, end);
    }
    
    @Override
    public synchronized String substring(final int start, final int end) {
        return super.substring(start, end);
    }
    
    @Override
    public synchronized StringBuffer insert(final int index, final char[] str, final int offset, final int len) {
        this.toStringCache = null;
        super.insert(index, str, offset, len);
        return this;
    }
    
    @Override
    public synchronized StringBuffer insert(final int offset, final Object o) {
        this.toStringCache = null;
        super.insert(offset, String.valueOf(o));
        return this;
    }
    
    @Override
    public synchronized StringBuffer insert(final int offset, final String str) {
        this.toStringCache = null;
        super.insert(offset, str);
        return this;
    }
    
    @Override
    public synchronized StringBuffer insert(final int offset, final char[] str) {
        this.toStringCache = null;
        super.insert(offset, str);
        return this;
    }
    
    @Override
    public StringBuffer insert(final int dstOffset, final CharSequence s) {
        super.insert(dstOffset, s);
        return this;
    }
    
    @Override
    public synchronized StringBuffer insert(final int dstOffset, final CharSequence s, final int start, final int end) {
        this.toStringCache = null;
        super.insert(dstOffset, s, start, end);
        return this;
    }
    
    @Override
    public StringBuffer insert(final int offset, final boolean b) {
        super.insert(offset, b);
        return this;
    }
    
    @Override
    public synchronized StringBuffer insert(final int offset, final char c) {
        this.toStringCache = null;
        super.insert(offset, c);
        return this;
    }
    
    @Override
    public StringBuffer insert(final int offset, final int i) {
        super.insert(offset, i);
        return this;
    }
    
    @Override
    public StringBuffer insert(final int offset, final long l) {
        super.insert(offset, l);
        return this;
    }
    
    @Override
    public StringBuffer insert(final int offset, final float f) {
        super.insert(offset, f);
        return this;
    }
    
    @Override
    public StringBuffer insert(final int offset, final double d) {
        super.insert(offset, d);
        return this;
    }
    
    @Override
    public int indexOf(final String str) {
        return super.indexOf(str);
    }
    
    @Override
    public synchronized int indexOf(final String str, final int fromIndex) {
        return super.indexOf(str, fromIndex);
    }
    
    @Override
    public int lastIndexOf(final String s) {
        return this.lastIndexOf(s, this.count);
    }
    
    @Override
    public synchronized int lastIndexOf(final String str, final int fromIndex) {
        return super.lastIndexOf(str, fromIndex);
    }
    
    @Override
    public synchronized StringBuffer reverse() {
        this.toStringCache = null;
        super.reverse();
        return this;
    }
    
    @Override
    public synchronized String toString() {
        if (this.toStringCache == null) {
            this.toStringCache = Arrays.copyOfRange(this.value, 0, this.count);
        }
        return new String(this.toStringCache, true);
    }
    
    private synchronized void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        final ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("value", this.value);
        putFields.put("count", this.count);
        putFields.put("shared", false);
        objectOutputStream.writeFields();
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        final ObjectInputStream.GetField fields = objectInputStream.readFields();
        this.value = (char[])fields.get("value", null);
        this.count = fields.get("count", 0);
    }
    
    static {
        serialPersistentFields = new ObjectStreamField[] { new ObjectStreamField("value", char[].class), new ObjectStreamField("count", Integer.TYPE), new ObjectStreamField("shared", Boolean.TYPE) };
    }
}
