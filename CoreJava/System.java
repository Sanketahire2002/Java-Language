// 
// Decompiled by Procyon v0.5.36
// 

package java.lang;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.stream.Stream;
import jdk.internal.module.ServicesCatalog;
import java.util.Iterator;
import java.net.URI;
import java.lang.module.ModuleDescriptor;
import java.security.ProtectionDomain;
import java.util.concurrent.ConcurrentHashMap;
import java.security.AccessControlContext;
import sun.nio.ch.Interruptible;
import java.lang.reflect.Executable;
import java.lang.annotation.Annotation;
import sun.reflect.annotation.AnnotationType;
import jdk.internal.reflect.ConstantPool;
import java.lang.reflect.Method;
import java.util.List;
import jdk.internal.access.JavaLangAccess;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileDescriptor;
import sun.misc.Version;
import sun.misc.VM;
import java.io.UnsupportedEncodingException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import java.util.Map;
import java.util.PropertyPermission;
import java.security.AccessController;
import sun.security.util.SecurityConstants;
import java.security.PrivilegedAction;
import java.security.Permission;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.Channel;
import sun.misc.SharedSecrets;
import java.util.Properties;
import java.io.Console;
import java.io.PrintStream;
import java.io.InputStream;

public final class System
{
    public static final InputStream in;
    public static final PrintStream out;
    public static final PrintStream err;
    private static volatile SecurityManager security;
    private static volatile Console cons;
    private static Properties props;
    private static String lineSeparator;
    
    private static native void registerNatives();
    
    private System() {
    }
    
    public static void setIn(final InputStream in0) {
        checkIO();
        setIn0(in0);
    }
    
    public static void setOut(final PrintStream out0) {
        checkIO();
        setOut0(out0);
    }
    
    public static void setErr(final PrintStream err0) {
        checkIO();
        setErr0(err0);
    }
    
    public static Console console() {
        if (System.cons == null) {
            synchronized (System.class) {
                System.cons = SharedSecrets.getJavaIOAccess().console();
            }
        }
        return System.cons;
    }
    
    public static Channel inheritedChannel() throws IOException {
        return SelectorProvider.provider().inheritedChannel();
    }
    
    private static void checkIO() {
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("setIO"));
        }
    }
    
    private static native void setIn0(final InputStream p0);
    
    private static native void setOut0(final PrintStream p0);
    
    private static native void setErr0(final PrintStream p0);
    
    public static void setSecurityManager(final SecurityManager securityManager0) {
        try {
            securityManager0.checkPackageAccess("java.lang");
        }
        catch (Exception ex) {}
        setSecurityManager0(securityManager0);
    }
    
    private static synchronized void setSecurityManager0(final SecurityManager security) {
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("setSecurityManager"));
        }
        if (security != null && security.getClass().getClassLoader() != null) {
            AccessController.doPrivileged((PrivilegedAction<Object>)new PrivilegedAction<Object>() {
                @Override
                public Object run() {
                    security.getClass().getProtectionDomain().implies(SecurityConstants.ALL_PERMISSION);
                    return null;
                }
            });
        }
        System.security = security;
    }
    
    public static SecurityManager getSecurityManager() {
        return System.security;
    }
    
    public static native long currentTimeMillis();
    
    public static native long nanoTime();
    
    public static native void arraycopy(final Object p0, final int p1, final Object p2, final int p3, final int p4);
    
    public static native int identityHashCode(final Object p0);
    
    private static native Properties initProperties(final Properties p0);
    
    public static Properties getProperties() {
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPropertiesAccess();
        }
        return System.props;
    }
    
    public static String lineSeparator() {
        return System.lineSeparator;
    }
    
    public static void setProperties(Properties props) {
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPropertiesAccess();
        }
        if (props == null) {
            props = new Properties();
            initProperties(props);
        }
        System.props = props;
    }
    
    public static String getProperty(final String s) {
        checkKey(s);
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPropertyAccess(s);
        }
        return System.props.getProperty(s);
    }
    
    public static String getProperty(final String s, final String defaultValue) {
        checkKey(s);
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPropertyAccess(s);
        }
        return System.props.getProperty(s, defaultValue);
    }
    
    public static String setProperty(final String s, final String value) {
        checkKey(s);
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new PropertyPermission(s, "write"));
        }
        return (String)System.props.setProperty(s, value);
    }
    
    public static String clearProperty(final String s) {
        checkKey(s);
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new PropertyPermission(s, "write"));
        }
        return (String)System.props.remove(s);
    }
    
    private static void checkKey(final String s) {
        if (s == null) {
            throw new NullPointerException("key can't be null");
        }
        if (s.equals("")) {
            throw new IllegalArgumentException("key can't be empty");
        }
    }
    
    public static String getenv(final String name) {
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("getenv." + name));
        }
        return ProcessEnvironment.getenv(name);
    }
    
    public static Map<String, String> getenv() {
        final SecurityManager securityManager = getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("getenv.*"));
        }
        return ProcessEnvironment.getenv();
    }
    
    public static void exit(final int status) {
        Runtime.getRuntime().exit(status);
    }
    
    public static void gc() {
        Runtime.getRuntime().gc();
    }
    
    public static void runFinalization() {
        Runtime.getRuntime().runFinalization();
    }
    
    @Deprecated
    public static void runFinalizersOnExit(final boolean b) {
        Runtime.runFinalizersOnExit(b);
    }
    
    @CallerSensitive
    public static void load(final String filename) {
        Runtime.getRuntime().load0(Reflection.getCallerClass(), filename);
    }
    
    @CallerSensitive
    public static void loadLibrary(final String libname) {
        Runtime.getRuntime().loadLibrary0(Reflection.getCallerClass(), libname);
    }
    
    public static native String mapLibraryName(final String p0);
    
    private static PrintStream newPrintStream(final FileOutputStream fileOutputStream, final String encoding) {
        if (encoding != null) {
            try {
                return new PrintStream(new BufferedOutputStream(fileOutputStream, 128), true, encoding);
            }
            catch (UnsupportedEncodingException ex) {}
        }
        return new PrintStream(new BufferedOutputStream(fileOutputStream, 128), true);
    }
    
    private static void initializeSystemClass() {
        initProperties(System.props = new Properties());
        VM.saveAndRemoveProperties(System.props);
        System.lineSeparator = System.props.getProperty("line.separator");
        Version.init();
        final FileInputStream in = new FileInputStream(FileDescriptor.in);
        final FileOutputStream fileOutputStream = new FileOutputStream(FileDescriptor.out);
        final FileOutputStream fileOutputStream2 = new FileOutputStream(FileDescriptor.err);
        setIn0(new BufferedInputStream(in));
        setOut0(newPrintStream(fileOutputStream, System.props.getProperty("sun.stdout.encoding")));
        setErr0(newPrintStream(fileOutputStream2, System.props.getProperty("sun.stderr.encoding")));
        loadLibrary("zip");
        Terminator.setup();
        VM.initializeOSEnvironment();
        final Thread currentThread = Thread.currentThread();
        currentThread.getThreadGroup().add(currentThread);
        setJavaLangAccess();
        VM.booted();
    }
    
    private static void setJavaLangAccess() {
        SharedSecrets.setJavaLangAccess((sun.misc.JavaLangAccess)new JavaLangAccess() {
            @Override
            public List<Method> getDeclaredPublicMethods(final Class<?> klass, final String name, final Class<?>... parameterTypes) {
                return klass.getDeclaredPublicMethods(name, parameterTypes);
            }
            
            @Override
            public ConstantPool getConstantPool(final Class<?> klass) {
                return klass.getConstantPool();
            }
            
            @Override
            public boolean casAnnotationType(final Class<?> klass, final AnnotationType oldType, final AnnotationType newType) {
                return klass.casAnnotationType(oldType, newType);
            }
            
            @Override
            public AnnotationType getAnnotationType(final Class<?> klass) {
                return klass.getAnnotationType();
            }
            
            @Override
            public Map<Class<? extends Annotation>, Annotation> getDeclaredAnnotationMap(final Class<?> klass) {
                return klass.getDeclaredAnnotationMap();
            }
            
            @Override
            public byte[] getRawClassAnnotations(final Class<?> klass) {
                return klass.getRawAnnotations();
            }
            
            @Override
            public byte[] getRawClassTypeAnnotations(final Class<?> klass) {
                return klass.getRawTypeAnnotations();
            }
            
            @Override
            public byte[] getRawExecutableTypeAnnotations(final Executable executable) {
                return Class.getExecutableTypeAnnotationBytes(executable);
            }
            
            @Override
            public <E extends Enum<E>> E[] getEnumConstantsShared(final Class<E> klass) {
                return klass.getEnumConstantsShared();
            }
            
            @Override
            public void blockedOn(final Interruptible b) {
                Thread.blockedOn(b);
            }
            
            @Override
            public void registerShutdownHook(final int slot, final boolean registerShutdownInProgress, final Runnable hook) {
                Shutdown.add(slot, registerShutdownInProgress, hook);
            }
            
            @Override
            public Thread newThreadWithAcc(final Runnable target, final AccessControlContext acc) {
                return new Thread(target, acc);
            }
            
            @Override
            public void invokeFinalize(final Object o) throws Throwable {
                o.finalize();
            }
            
            @Override
            public ConcurrentHashMap<?, ?> createOrGetClassLoaderValueMap(final ClassLoader cl) {
                return cl.createOrGetClassLoaderValueMap();
            }
            
            @Override
            public Class<?> defineClass(final ClassLoader loader, final String name, final byte[] b, final ProtectionDomain pd, final String source) {
                return ClassLoader.defineClass1(loader, name, b, 0, b.length, pd, source);
            }
            
            @Override
            public Class<?> findBootstrapClassOrNull(final ClassLoader cl, final String name) {
                return cl.findBootstrapClassOrNull(name);
            }
            
            @Override
            public Package definePackage(final ClassLoader cl, final String name, final Module module) {
                return cl.definePackage(name, module);
            }
            
            @Override
            public String fastUUID(final long lsb, final long msb) {
                return Long.fastUUID(lsb, msb);
            }
            
            @Override
            public void addNonExportedPackages(final ModuleLayer layer) {
                SecurityManager.addNonExportedPackages(layer);
            }
            
            @Override
            public void invalidatePackageAccessCache() {
                SecurityManager.invalidatePackageAccessCache();
            }
            
            @Override
            public Module defineModule(final ClassLoader loader, final ModuleDescriptor descriptor, final URI uri) {
                return new Module(null, loader, descriptor, uri);
            }
            
            @Override
            public Module defineUnnamedModule(final ClassLoader loader) {
                return new Module(loader);
            }
            
            @Override
            public void addReads(final Module m1, final Module m2) {
                m1.implAddReads(m2);
            }
            
            @Override
            public void addReadsAllUnnamed(final Module m) {
                m.implAddReadsAllUnnamed();
            }
            
            @Override
            public void addExports(final Module m, final String pn, final Module other) {
                m.implAddExports(pn, other);
            }
            
            @Override
            public void addExportsToAllUnnamed(final Module m, final String pn) {
                m.implAddExportsToAllUnnamed(pn);
            }
            
            @Override
            public void addOpens(final Module m, final String pn, final Module other) {
                m.implAddOpens(pn, other);
            }
            
            @Override
            public void addOpensToAllUnnamed(final Module m, final String pn) {
                m.implAddOpensToAllUnnamed(pn);
            }
            
            @Override
            public void addOpensToAllUnnamed(final Module m, final Iterator<String> packages) {
                m.implAddOpensToAllUnnamed(packages);
            }
            
            @Override
            public void addUses(final Module m, final Class<?> service) {
                m.implAddUses(service);
            }
            
            @Override
            public boolean isReflectivelyExported(final Module m, final String pn, final Module other) {
                return m.isReflectivelyExported(pn, other);
            }
            
            @Override
            public boolean isReflectivelyOpened(final Module m, final String pn, final Module other) {
                return m.isReflectivelyOpened(pn, other);
            }
            
            @Override
            public ServicesCatalog getServicesCatalog(final ModuleLayer layer) {
                return layer.getServicesCatalog();
            }
            
            @Override
            public Stream<ModuleLayer> layers(final ModuleLayer layer) {
                return layer.layers();
            }
            
            @Override
            public Stream<ModuleLayer> layers(final ClassLoader loader) {
                return ModuleLayer.layers(loader);
            }
            
            @Override
            public String newStringNoRepl(final byte[] bytes, final Charset cs) throws CharacterCodingException {
                return StringCoding.newStringNoRepl(bytes, cs);
            }
            
            @Override
            public byte[] getBytesNoRepl(final String s, final Charset cs) throws CharacterCodingException {
                return StringCoding.getBytesNoRepl(s, cs);
            }
            
            @Override
            public String newStringUTF8NoRepl(final byte[] bytes, final int off, final int len) {
                return StringCoding.newStringUTF8NoRepl(bytes, off, len);
            }
            
            @Override
            public byte[] getBytesUTF8NoRepl(final String s) {
                return StringCoding.getBytesUTF8NoRepl(s);
            }
            
            @Override
            public void setCause(final Throwable t, final Throwable cause) {
                t.setCause(cause);
            }
        });
    }
    
    static {
        registerNatives();
        in = null;
        out = null;
        err = null;
        System.security = null;
        System.cons = null;
    }
}
