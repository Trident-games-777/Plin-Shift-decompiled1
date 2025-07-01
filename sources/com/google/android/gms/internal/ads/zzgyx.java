package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgyr;
import com.google.android.gms.internal.ads.zzgyx;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzgyx<MessageType extends zzgyx<MessageType, BuilderType>, BuilderType extends zzgyr<MessageType, BuilderType>> extends zzgwy<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Class<?>, zzgyx<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzhbo zzt = zzhbo.zzc();

    protected static zzgyz zzbA() {
        return zzgxf.zzd();
    }

    protected static zzgyz zzbB(zzgyz zzgyz) {
        int size = zzgyz.size();
        return zzgyz.zze(size == 0 ? 10 : size + size);
    }

    protected static zzgza zzbC() {
        return zzgye.zze();
    }

    protected static zzgza zzbD(zzgza zzgza) {
        int size = zzgza.size();
        return zzgza.zzg(size == 0 ? 10 : size + size);
    }

    protected static zzgze zzbE() {
        return zzgyo.zze();
    }

    protected static zzgze zzbF(zzgze zzgze) {
        int size = zzgze.size();
        return zzgze.zzg(size == 0 ? 10 : size + size);
    }

    protected static zzgzf zzbG() {
        return zzgyy.zzg();
    }

    protected static zzgzf zzbH(zzgzf zzgzf) {
        int size = zzgzf.size();
        return zzgzf.zzh(size == 0 ? 10 : size + size);
    }

    protected static zzgzi zzbI() {
        return zzgzx.zzh();
    }

    protected static zzgzi zzbJ(zzgzi zzgzi) {
        int size = zzgzi.size();
        return zzgzi.zze(size == 0 ? 10 : size + size);
    }

    protected static <E> zzgzj<E> zzbK() {
        return zzhat.zzd();
    }

    protected static <E> zzgzj<E> zzbL(zzgzj<E> zzgzj) {
        int size = zzgzj.size();
        return zzgzj.zzf(size == 0 ? 10 : size + size);
    }

    static Object zzbR(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzbS(zzhai zzhai, String str, Object[] objArr) {
        return new zzhau(zzhai, str, objArr);
    }

    static Method zzbT(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            String name = cls.getName();
            throw new RuntimeException("Generated message class \"" + name + "\" missing method \"" + str + "\".", e);
        }
    }

    public static <ContainingType extends zzhai, Type> zzgyv<ContainingType, Type> zzbe(ContainingType containingtype, zzhai zzhai, zzgzc zzgzc, int i, zzhca zzhca, boolean z, Class cls) {
        zzgzc zzgzc2 = zzgzc;
        int i2 = i;
        return new zzgyv<>(containingtype, Collections.emptyList(), zzhai, new zzgyu(zzgzc2, i2, zzhca, true, z), cls);
    }

    public static <ContainingType extends zzhai, Type> zzgyv<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzhai zzhai, zzgzc zzgzc, int i, zzhca zzhca, Class cls) {
        zzgzc zzgzc2 = zzgzc;
        zzhai zzhai2 = zzhai;
        return new zzgyv<>(containingtype, type, zzhai2, new zzgyu(zzgzc2, i, zzhca, false, false), cls);
    }

    static <T extends zzgyx> T zzbh(Class<T> cls) {
        T t = (zzgyx) zzc.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzgyx) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        T zzbi = ((zzgyx) zzhbu.zzg(cls)).zzbt();
        if (zzbi != null) {
            zzc.put(cls, zzbi);
            return zzbi;
        }
        throw new IllegalStateException();
    }

    protected static <T extends zzgyx<T, ?>> T zzbk(T t, InputStream inputStream) throws zzgzm {
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        T zzg = zzg(t, inputStream, zzgyh.zza);
        zzf(zzg);
        return zzg;
    }

    protected static <T extends zzgyx<T, ?>> T zzbl(T t, InputStream inputStream, zzgyh zzgyh) throws zzgzm {
        T zzg = zzg(t, inputStream, zzgyh);
        zzf(zzg);
        return zzg;
    }

    protected static <T extends zzgyx<T, ?>> T zzbm(T t, zzgxp zzgxp) throws zzgzm {
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        T zzbr = zzbr(t, zzgxp, zzgyh.zza);
        zzf(zzbr);
        return zzbr;
    }

    protected static <T extends zzgyx<T, ?>> T zzbn(T t, zzgxv zzgxv) throws zzgzm {
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        return zzbs(t, zzgxv, zzgyh.zza);
    }

    protected static <T extends zzgyx<T, ?>> T zzbo(T t, InputStream inputStream) throws zzgzm {
        zzgxv zzG = zzgxv.zzG(inputStream, 4096);
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        T zzbz = zzbz(t, zzG, zzgyh.zza);
        zzf(zzbz);
        return zzbz;
    }

    protected static <T extends zzgyx<T, ?>> T zzbp(T t, ByteBuffer byteBuffer) throws zzgzm {
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        return zzbv(t, byteBuffer, zzgyh.zza);
    }

    protected static <T extends zzgyx<T, ?>> T zzbq(T t, byte[] bArr) throws zzgzm {
        int length = bArr.length;
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        T zzi = zzi(t, bArr, 0, length, zzgyh.zza);
        zzf(zzi);
        return zzi;
    }

    protected static <T extends zzgyx<T, ?>> T zzbr(T t, zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        T zzh = zzh(t, zzgxp, zzgyh);
        zzf(zzh);
        return zzh;
    }

    protected static <T extends zzgyx<T, ?>> T zzbs(T t, zzgxv zzgxv, zzgyh zzgyh) throws zzgzm {
        T zzbz = zzbz(t, zzgxv, zzgyh);
        zzf(zzbz);
        return zzbz;
    }

    protected static <T extends zzgyx<T, ?>> T zzbu(T t, InputStream inputStream, zzgyh zzgyh) throws zzgzm {
        T zzbz = zzbz(t, zzgxv.zzG(inputStream, 4096), zzgyh);
        zzf(zzbz);
        return zzbz;
    }

    protected static <T extends zzgyx<T, ?>> T zzbv(T t, ByteBuffer byteBuffer, zzgyh zzgyh) throws zzgzm {
        zzgxv zzgxv;
        int i = zzgxv.zzd;
        if (byteBuffer.hasArray()) {
            zzgxv = zzgxv.zzH(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), false);
        } else if (!byteBuffer.isDirect() || !zzhbu.zzB()) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            zzgxv = zzgxv.zzH(bArr, 0, remaining, true);
        } else {
            zzgxv = new zzgxt(byteBuffer, false, (zzgxu) null);
        }
        T zzbs = zzbs(t, zzgxv, zzgyh);
        zzf(zzbs);
        return zzbs;
    }

    protected static <T extends zzgyx<T, ?>> T zzbx(T t, byte[] bArr, zzgyh zzgyh) throws zzgzm {
        T zzi = zzi(t, bArr, 0, bArr.length, zzgyh);
        zzf(zzi);
        return zzi;
    }

    protected static <T extends zzgyx<T, ?>> T zzby(T t, zzgxv zzgxv) throws zzgzm {
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        return zzbz(t, zzgxv, zzgyh.zza);
    }

    static <T extends zzgyx<T, ?>> T zzbz(T t, zzgxv zzgxv, zzgyh zzgyh) throws zzgzm {
        T zzbj = t.zzbj();
        try {
            zzhbb zzb2 = zzhas.zza().zzb(zzbj.getClass());
            zzb2.zzh(zzbj, zzgxw.zzq(zzgxv), zzgyh);
            zzb2.zzf(zzbj);
            return zzbj;
        } catch (zzgzm e) {
            if (e.zzb()) {
                throw new zzgzm((IOException) e);
            }
            throw e;
        } catch (zzhbm e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgzm) {
                throw ((zzgzm) e3.getCause());
            }
            throw new zzgzm(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgzm) {
                throw ((zzgzm) e4.getCause());
            }
            throw e4;
        }
    }

    private int zzc(zzhbb<?> zzhbb) {
        if (zzhbb != null) {
            return zzhbb.zza(this);
        }
        return zzhas.zza().zzb(getClass()).zza(this);
    }

    protected static <T extends zzgyx> void zzcb(Class<T> cls, T t) {
        t.zzbX();
        zzc.put(cls, t);
    }

    protected static final <T extends zzgyx<T, ?>> boolean zzce(T t, boolean z) {
        byte byteValue = ((Byte) t.zzbP(zzgyw.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzhas.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.zzbQ(zzgyw.SET_MEMOIZED_IS_INITIALIZED, true != zzl ? null : t);
        }
        return zzl;
    }

    /* access modifiers changed from: private */
    public static <MessageType extends zzgyt<MessageType, BuilderType>, BuilderType, T> zzgyv<MessageType, T> zzd(zzgyf<MessageType, T> zzgyf) {
        return (zzgyv) zzgyf;
    }

    private static <T extends zzgyx<T, ?>> T zzf(T t) throws zzgzm {
        if (t == null || t.zzbw()) {
            return t;
        }
        throw t.zzaP().zza();
    }

    private static <T extends zzgyx<T, ?>> T zzg(T t, InputStream inputStream, zzgyh zzgyh) throws zzgzm {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            zzgxv zzG = zzgxv.zzG(new zzgww(inputStream, zzgxv.zzE(read, inputStream)), 4096);
            T zzbz = zzbz(t, zzG, zzgyh);
            zzG.zzy(0);
            return zzbz;
        } catch (zzgzm e) {
            if (e.zzb()) {
                throw new zzgzm((IOException) e);
            }
            throw e;
        } catch (IOException e2) {
            throw new zzgzm(e2);
        }
    }

    private static <T extends zzgyx<T, ?>> T zzh(T t, zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        zzgxv zzl = zzgxp.zzl();
        T zzbz = zzbz(t, zzl, zzgyh);
        zzl.zzy(0);
        return zzbz;
    }

    /* access modifiers changed from: private */
    public static <T extends zzgyx<T, ?>> T zzi(T t, byte[] bArr, int i, int i2, zzgyh zzgyh) throws zzgzm {
        if (i2 == 0) {
            return t;
        }
        T zzbj = t.zzbj();
        try {
            zzhbb zzb2 = zzhas.zza().zzb(zzbj.getClass());
            zzb2.zzi(zzbj, bArr, i, i + i2, new zzgxd(zzgyh));
            zzb2.zzf(zzbj);
            return zzbj;
        } catch (zzgzm e) {
            zzgzm zzgzm = e;
            if (zzgzm.zzb()) {
                throw new zzgzm((IOException) zzgzm);
            }
            throw zzgzm;
        } catch (zzhbm e2) {
            throw e2.zza();
        } catch (IOException e3) {
            IOException iOException = e3;
            if (iOException.getCause() instanceof zzgzm) {
                throw ((zzgzm) iOException.getCause());
            }
            throw new zzgzm(iOException);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private void zzj() {
        if (this.zzt == zzhbo.zzc()) {
            this.zzt = zzhbo.zzf();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhas.zza().zzb(getClass()).zzk(this, (zzgyx) obj);
    }

    public int hashCode() {
        if (zzcf()) {
            return zzaW();
        }
        if (zzcd()) {
            zzcc(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzhak.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public int zzaL() {
        return this.zzd & Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public int zzaM(zzhbb zzhbb) {
        if (zzcf()) {
            int zzc2 = zzc(zzhbb);
            if (zzc2 >= 0) {
                return zzc2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzc2);
        } else if (zzaL() != Integer.MAX_VALUE) {
            return zzaL();
        } else {
            int zzc3 = zzc(zzhbb);
            zzaS(zzc3);
            return zzc3;
        }
    }

    public zzhan zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    /* access modifiers changed from: package-private */
    public void zzaS(int i) {
        if (i >= 0) {
            this.zzd = i | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i);
    }

    /* access modifiers changed from: package-private */
    public int zzaW() {
        return zzhas.zza().zzb(getClass()).zzb(this);
    }

    /* access modifiers changed from: package-private */
    public int zzaX() {
        return this.zzq;
    }

    public int zzaY() {
        return zzaM((zzhbb) null);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzgyx<MessageType, BuilderType>, BuilderType extends zzgyr<MessageType, BuilderType>> BuilderType zzaZ() {
        return (zzgyr) zzbP(zzgyw.NEW_BUILDER);
    }

    public final zzhaq<MessageType> zzbN() {
        return (zzhaq) zzbP(zzgyw.GET_PARSER);
    }

    /* access modifiers changed from: package-private */
    public Object zzbO() throws Exception {
        return zzbP(zzgyw.BUILD_MESSAGE_INFO);
    }

    /* access modifiers changed from: protected */
    public Object zzbP(zzgyw zzgyw) {
        return zzde(zzgyw, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object zzbQ(zzgyw zzgyw, Object obj) {
        return zzde(zzgyw, obj, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void zzbU() {
        this.zzq = 0;
    }

    /* access modifiers changed from: package-private */
    public void zzbV() {
        zzaS(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public void zzbW() {
        zzhas.zza().zzb(getClass()).zzf(this);
        zzbX();
    }

    /* access modifiers changed from: package-private */
    public void zzbX() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    public void zzbY(int i, zzgxp zzgxp) {
        zzj();
        zzhbo zzhbo = this.zzt;
        zzhbo.zzg();
        if (i != 0) {
            zzhbo.zzj((i << 3) | 2, zzgxp);
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: protected */
    public final void zzbZ(zzhbo zzhbo) {
        this.zzt = zzhbo.zze(this.zzt, zzhbo);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzgyx<MessageType, BuilderType>, BuilderType extends zzgyr<MessageType, BuilderType>> BuilderType zzba(MessageType messagetype) {
        BuilderType zzaZ = zzaZ();
        zzaZ.zzbj(messagetype);
        return zzaZ;
    }

    /* renamed from: zzbb */
    public final BuilderType zzcZ() {
        return (zzgyr) zzbP(zzgyw.NEW_BUILDER);
    }

    /* renamed from: zzbc */
    public final BuilderType zzbM() {
        BuilderType buildertype = (zzgyr) zzbP(zzgyw.NEW_BUILDER);
        buildertype.zzbj(this);
        return buildertype;
    }

    /* renamed from: zzbi */
    public final MessageType zzbt() {
        return (zzgyx) zzbP(zzgyw.GET_DEFAULT_INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public MessageType zzbj() {
        return (zzgyx) zzbP(zzgyw.NEW_MUTABLE_INSTANCE);
    }

    public final boolean zzbw() {
        return zzce(this, true);
    }

    /* access modifiers changed from: protected */
    public void zzca(int i, int i2) {
        zzj();
        zzhbo zzhbo = this.zzt;
        zzhbo.zzg();
        if (i != 0) {
            zzhbo.zzj(i << 3, Long.valueOf((long) i2));
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public void zzcc(int i) {
        this.zzq = i;
    }

    /* access modifiers changed from: package-private */
    public boolean zzcd() {
        return zzaX() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean zzcf() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: protected */
    public boolean zzcg(int i, zzgxv zzgxv) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        zzj();
        return this.zzt.zzm(i, zzgxv);
    }

    public void zzda(zzgyc zzgyc) throws IOException {
        zzhas.zza().zzb(getClass()).zzj(this, zzgyd.zza(zzgyc));
    }

    /* access modifiers changed from: protected */
    public abstract Object zzde(zzgyw zzgyw, Object obj, Object obj2);
}
