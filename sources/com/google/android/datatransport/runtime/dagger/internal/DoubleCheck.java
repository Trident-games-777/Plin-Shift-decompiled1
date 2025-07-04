package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider2) {
        this.provider = provider2;
    }

    public T get() {
        T t;
        T t2 = this.instance;
        T t3 = UNINITIALIZED;
        if (t2 != t3) {
            return t2;
        }
        synchronized (this) {
            t = this.instance;
            if (t == t3) {
                t = this.provider.get();
                this.instance = reentrantCheck(this.instance, t);
                this.provider = null;
            }
        }
        return t;
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        if (obj == UNINITIALIZED || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        Preconditions.checkNotNull(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        return new DoubleCheck(p);
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p) {
        if (p instanceof Lazy) {
            return (Lazy) p;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(p));
    }
}
