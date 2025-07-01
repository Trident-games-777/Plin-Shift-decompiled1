package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgwx;
import com.google.android.gms.internal.ads.zzgwy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzgwx<MessageType extends zzgwy<MessageType, BuilderType>, BuilderType extends zzgwx<MessageType, BuilderType>> implements zzhah {
    private String zza(String str) {
        String name = getClass().getName();
        return "Reading " + name + " from a " + str + " threw an IOException (should never happen).";
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            }
            if (list instanceof zzhat) {
                ((zzhat) list).zze(list.size() + size);
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (T next : iterable) {
                if (next == null) {
                    zzc(list, size2);
                }
                list.add(next);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            Object obj = list2.get(i);
            if (obj == null) {
                zzc(list, size2);
            }
            list.add(obj);
        }
    }

    protected static zzhbm zzbb(zzhai zzhai) {
        return new zzhbm(zzhai);
    }

    @Deprecated
    protected static <T> void zzbc(Iterable<T> iterable, Collection<? super T> collection) {
        zzbd(iterable, (List) collection);
    }

    protected static <T> void zzbd(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzgzk.zzb;
        iterable.getClass();
        if (iterable instanceof zzgzu) {
            List zza = ((zzgzu) iterable).zza();
            zzgzu zzgzu = (zzgzu) list;
            int size = list.size();
            for (Object next : zza) {
                if (next == null) {
                    String str = "Element at index " + (zzgzu.size() - size) + " is null.";
                    int size2 = zzgzu.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzgzu.remove(size2);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof zzgxp) {
                    zzgxp zzgxp = (zzgxp) next;
                    zzgzu.zzb();
                } else if (next instanceof byte[]) {
                    byte[] bArr2 = (byte[]) next;
                    zzgxp.zzv(bArr2, 0, bArr2.length);
                    zzgzu.zzb();
                } else {
                    zzgzu.add((String) next);
                }
            }
        } else if (iterable instanceof zzhar) {
            list.addAll((Collection) iterable);
        } else {
            zzb(iterable, list);
        }
    }

    private static void zzc(List<?> list, int i) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        int size = list.size();
        while (true) {
            size--;
            if (size >= i) {
                list.remove(size);
            } else {
                throw new NullPointerException(str);
            }
        }
    }

    /* renamed from: zzaC */
    public abstract BuilderType zzaP();

    /* access modifiers changed from: protected */
    public abstract BuilderType zzaD(MessageType messagetype);

    public BuilderType zzaE(zzgxp zzgxp) throws zzgzm {
        try {
            zzgxv zzl = zzgxp.zzl();
            zzaR(zzl);
            zzl.zzy(0);
            return this;
        } catch (zzgzm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* renamed from: zzaF */
    public BuilderType zzaR(zzgxv zzgxv) throws IOException {
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        return zzaW(zzgxv, zzgyh.zza);
    }

    /* renamed from: zzaG */
    public BuilderType zzaS(zzhai zzhai) {
        if (zzbt().getClass().isInstance(zzhai)) {
            return zzaD((zzgwy) zzhai);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public BuilderType zzaH(InputStream inputStream) throws IOException {
        zzgxv zzG = zzgxv.zzG(inputStream, 4096);
        zzaR(zzG);
        zzG.zzy(0);
        return this;
    }

    /* renamed from: zzaI */
    public BuilderType zzaU(byte[] bArr) throws zzgzm {
        return zzaZ(bArr, 0, bArr.length);
    }

    public BuilderType zzaJ(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        try {
            zzgxv zzl = zzgxp.zzl();
            zzaW(zzl, zzgyh);
            zzl.zzy(0);
            return this;
        } catch (zzgzm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* renamed from: zzaK */
    public abstract BuilderType zzaW(zzgxv zzgxv, zzgyh zzgyh) throws IOException;

    public BuilderType zzaL(InputStream inputStream, zzgyh zzgyh) throws IOException {
        zzgxv zzG = zzgxv.zzG(inputStream, 4096);
        zzaW(zzG, zzgyh);
        zzG.zzy(0);
        return this;
    }

    /* renamed from: zzaM */
    public BuilderType zzaY(byte[] bArr, zzgyh zzgyh) throws zzgzm {
        return zzba(bArr, 0, bArr.length, zzgyh);
    }

    /* renamed from: zzaN */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzgzm {
        try {
            zzgxv zzH = zzgxv.zzH(bArr, i, i2, false);
            zzaR(zzH);
            zzH.zzy(0);
            return this;
        } catch (zzgzm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* renamed from: zzaO */
    public BuilderType zzba(byte[] bArr, int i, int i2, zzgyh zzgyh) throws zzgzm {
        try {
            zzgxv zzH = zzgxv.zzH(bArr, i, i2, false);
            zzaW(zzH, zzgyh);
            zzH.zzy(0);
            return this;
        } catch (zzgzm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public /* bridge */ /* synthetic */ zzhah zzaQ(zzgxp zzgxp) throws zzgzm {
        zzaE(zzgxp);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhah zzaT(InputStream inputStream) throws IOException {
        zzaH(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhah zzaV(zzgxp zzgxp, zzgyh zzgyh) throws zzgzm {
        zzaJ(zzgxp, zzgyh);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhah zzaX(InputStream inputStream, zzgyh zzgyh) throws IOException {
        zzaL(inputStream, zzgyh);
        return this;
    }

    public boolean zzbe(InputStream inputStream) throws IOException {
        int i = zzgyh.zzb;
        int i2 = zzhas.zza;
        return zzbf(inputStream, zzgyh.zza);
    }

    public boolean zzbf(InputStream inputStream, zzgyh zzgyh) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            return false;
        }
        zzaL(new zzgww(inputStream, zzgxv.zzE(read, inputStream)), zzgyh);
        return true;
    }
}
