package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Funnels {
    private Funnels() {
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    private enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        public void funnel(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.putBytes(bArr);
        }

        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return UnencodedCharsFunnel.INSTANCE;
    }

    private enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putUnencodedChars(charSequence);
        }

        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    public static Funnel<CharSequence> stringFunnel(Charset charset) {
        return new StringCharsetFunnel(charset);
    }

    private static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        StringCharsetFunnel(Charset charset2) {
            this.charset = (Charset) Preconditions.checkNotNull(charset2);
        }

        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putString(charSequence, this.charset);
        }

        public String toString() {
            String name = this.charset.name();
            return new StringBuilder(String.valueOf(name).length() + 22).append("Funnels.stringFunnel(").append(name).append(")").toString();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        private static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
            }
        }
    }

    public static Funnel<Integer> integerFunnel() {
        return IntegerFunnel.INSTANCE;
    }

    private enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        public void funnel(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.putInt(num.intValue());
        }

        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> funnel) {
        return new SequentialFunnel(funnel);
    }

    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        SequentialFunnel(Funnel<E> funnel) {
            this.elementFunnel = (Funnel) Preconditions.checkNotNull(funnel);
        }

        public void funnel(Iterable<? extends E> iterable, PrimitiveSink primitiveSink) {
            for (Object funnel : iterable) {
                this.elementFunnel.funnel(funnel, primitiveSink);
            }
        }

        public String toString() {
            String valueOf = String.valueOf(this.elementFunnel);
            return new StringBuilder(String.valueOf(valueOf).length() + 26).append("Funnels.sequentialFunnel(").append(valueOf).append(")").toString();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }
    }

    public static Funnel<Long> longFunnel() {
        return LongFunnel.INSTANCE;
    }

    private enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        public void funnel(Long l, PrimitiveSink primitiveSink) {
            primitiveSink.putLong(l.longValue());
        }

        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        return new SinkAsStream(primitiveSink);
    }

    private static class SinkAsStream extends OutputStream {
        final PrimitiveSink sink;

        SinkAsStream(PrimitiveSink primitiveSink) {
            this.sink = (PrimitiveSink) Preconditions.checkNotNull(primitiveSink);
        }

        public void write(int i) {
            this.sink.putByte((byte) i);
        }

        public void write(byte[] bArr) {
            this.sink.putBytes(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.sink.putBytes(bArr, i, i2);
        }

        public String toString() {
            String valueOf = String.valueOf(this.sink);
            return new StringBuilder(String.valueOf(valueOf).length() + 24).append("Funnels.asOutputStream(").append(valueOf).append(")").toString();
        }
    }
}
