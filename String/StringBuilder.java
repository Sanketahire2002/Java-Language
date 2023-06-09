// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class StringBuilder extends AbstractStringBuilder implements Serializable, CharSequence
{
    static final long serialVersionUID = 4383685877147921099L;
    
    public StringBuilder() {
        super(16);
    }
    
    public StringBuilder(final int capacity) {
        super(capacity);
    }
    
    public StringBuilder(final String s) {
        super(s.length() + 16);
        this.append(s);
    }
    
    public StringBuilder(final CharSequence charSequence) {
        this(charSequence.length() + 16);
        this.append(charSequence);
    }
    
    @Override
    public StringBuilder append(final Object o) {
        return this.append(String.valueOf(o));
    }
    
    @Override
    public StringBuilder append(final String str) {
        super.append(str);
        return this;
    }
    
    @Override
    public StringBuilder append(final StringBuffer sb) {
        super.append(sb);
        return this;
    }
    
    @Override
    public StringBuilder append(final CharSequence s) {
        super.append(s);
        return this;
    }
    
    @Override
    public StringBuilder append(final CharSequence s, final int start, final int end) {
        super.append(s, start, end);
        return this;
    }
    
    @Override
    public StringBuilder append(final char[] str) {
        super.append(str);
        return this;
    }
    
    @Override
    public StringBuilder append(final char[] str, final int offset, final int len) {
        super.append(str, offset, len);
        return this;
    }
    
    @Override
    public StringBuilder append(final boolean b) {
        super.append(b);
        return this;
    }
    
    @Override
    public StringBuilder append(final char c) {
        super.append(c);
        return this;
    }
    
    @Override
    public StringBuilder append(final int i) {
        super.append(i);
        return this;
    }
    
    @Override
    public StringBuilder append(final long l) {
        super.append(l);
        return this;
    }
    
    @Override
    public StringBuilder append(final float f) {
        super.append(f);
        return this;
    }
    
    @Override
    public StringBuilder append(final double d) {
        super.append(d);
        return this;
    }
    
    @Override
    public StringBuilder appendCodePoint(final int codePoint) {
        super.appendCodePoint(codePoint);
        return this;
    }
    
    @Override
    public StringBuilder delete(final int start, final int end) {
        super.delete(start, end);
        return this;
    }
    
    @Override
    public StringBuilder deleteCharAt(final int index) {
        super.deleteCharAt(index);
        return this;
    }
    
    @Override
    public StringBuilder replace(final int start, final int end, final String str) {
        super.replace(start, end, str);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int index, final char[] str, final int offset, final int len) {
        super.insert(index, str, offset, len);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final Object obj) {
        super.insert(offset, obj);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final String str) {
        super.insert(offset, str);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final char[] str) {
        super.insert(offset, str);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int dstOffset, final CharSequence s) {
        super.insert(dstOffset, s);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int dstOffset, final CharSequence s, final int start, final int end) {
        super.insert(dstOffset, s, start, end);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final boolean b) {
        super.insert(offset, b);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final char c) {
        super.insert(offset, c);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final int i) {
        super.insert(offset, i);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final long l) {
        super.insert(offset, l);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final float f) {
        super.insert(offset, f);
        return this;
    }
    
    @Override
    public StringBuilder insert(final int offset, final double d) {
        super.insert(offset, d);
        return this;
    }
    
    @Override
    public int indexOf(final String str) {
        return super.indexOf(str);
    }
    
    @Override
    public int indexOf(final String str, final int fromIndex) {
        return super.indexOf(str, fromIndex);
    }
    
    @Override
    public int lastIndexOf(final String str) {
        return super.lastIndexOf(str);
    }
    
    @Override
    public int lastIndexOf(final String str, final int fromIndex) {
        return super.lastIndexOf(str, fromIndex);
    }
    
    @Override
    public StringBuilder reverse() {
        super.reverse();
        return this;
    }
    
    @Override
    public String toString() {
        return new String(this.value, 0, this.count);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.count);
        objectOutputStream.writeObject(this.value);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = objectInputStream.readInt();
        this.value = (char[])objectInputStream.readObject();
    }
}
