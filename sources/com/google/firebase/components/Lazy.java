package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    Lazy(T t) {
        this.instance = t;
    }

    public Lazy(Provider<T> provider2) {
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
                this.instance = t;
                this.provider = null;
            }
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }
}
