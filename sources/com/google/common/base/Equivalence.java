package com.google.common.base;

import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class Equivalence<T> {
    /* access modifiers changed from: protected */
    public abstract boolean doEquivalent(T t, T t2);

    /* access modifiers changed from: protected */
    public abstract int doHash(T t);

    protected Equivalence() {
    }

    public final boolean equivalent(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    public final int hash(@CheckForNull T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(Function<? super F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    public final <S extends T> Wrapper<S> wrap(@ParametricNullness S s) {
        return new Wrapper<>(s);
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        @ParametricNullness
        private final T reference;

        private Wrapper(Equivalence<? super T> equivalence2, @ParametricNullness T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.reference = t;
        }

        @ParametricNullness
        public T get() {
            return this.reference;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.reference);
            return new StringBuilder(String.valueOf(valueOf).length() + 7 + String.valueOf(valueOf2).length()).append(valueOf).append(".wrap(").append(valueOf2).append(")").toString();
        }
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final Predicate<T> equivalentTo(@CheckForNull T t) {
        return new EquivalentToPredicate(this, t);
    }

    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        @CheckForNull
        private final T target;

        EquivalentToPredicate(Equivalence<T> equivalence2, @CheckForNull T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.target = t;
        }

        public boolean apply(@CheckForNull T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EquivalentToPredicate) {
                EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
                return this.equivalence.equals(equivalentToPredicate.equivalence) && Objects.equal(this.target, equivalentToPredicate.target);
            }
        }

        public int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.target);
            return new StringBuilder(String.valueOf(valueOf).length() + 15 + String.valueOf(valueOf2).length()).append(valueOf).append(".equivalentTo(").append(valueOf2).append(")").toString();
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        /* access modifiers changed from: protected */
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        /* access modifiers changed from: protected */
        public int doHash(Object obj) {
            return obj.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        /* access modifiers changed from: protected */
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        Identity() {
        }

        /* access modifiers changed from: protected */
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}
