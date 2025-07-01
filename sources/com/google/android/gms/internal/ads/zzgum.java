package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgum extends zzgyx implements zzhaj {
    /* access modifiers changed from: private */
    public static final zzgum zza;
    private static volatile zzhaq zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private zzgzj zzd = zzbK();

    static {
        zzgum zzgum = new zzgum();
        zza = zzgum;
        zzgyx.zzcb(zzgum.class, zzgum);
    }

    private zzgum() {
    }

    public static zzgui zzc() {
        return (zzgui) zza.zzaZ();
    }

    public static zzgum zzg(InputStream inputStream, zzgyh zzgyh) throws IOException {
        return (zzgum) zzgyx.zzbu(zza, inputStream, zzgyh);
    }

    static /* synthetic */ void zzi(zzgum zzgum, zzguk zzguk) {
        zzguk.getClass();
        zzgzj zzgzj = zzgum.zzd;
        if (!zzgzj.zzc()) {
            zzgum.zzd = zzgyx.zzbL(zzgzj);
        }
        zzgum.zzd.add(zzguk);
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final zzguk zzd(int i) {
        return (zzguk) this.zzd.get(i);
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgyw zzgyw, Object obj, Object obj2) {
        zzhaq zzhaq;
        switch (zzgyw.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzguk.class});
            case 3:
                return new zzgum();
            case 4:
                return new zzgui((zzgul) null);
            case 5:
                return zza;
            case 6:
                zzhaq zzhaq2 = zzb;
                if (zzhaq2 != null) {
                    return zzhaq2;
                }
                synchronized (zzgum.class) {
                    zzhaq = zzb;
                    if (zzhaq == null) {
                        zzhaq = new zzgys(zza);
                        zzb = zzhaq;
                    }
                }
                return zzhaq;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final List zzh() {
        return this.zzd;
    }
}
