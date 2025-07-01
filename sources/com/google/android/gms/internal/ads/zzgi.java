package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgi {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzax.zzb("media3.datasource");
    }

    private zzgi(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        boolean z = false;
        boolean z2 = j2 >= 0;
        zzdb.zzd(z2);
        zzdb.zzd(z2);
        if (j3 <= 0) {
            j3 = j3 == -1 ? -1 : j3;
            zzdb.zzd(z);
            uri.getClass();
            Uri uri2 = uri;
            this.zza = uri;
            this.zzb = 1;
            this.zzc = null;
            this.zzd = Collections.unmodifiableMap(new HashMap(map));
            this.zze = j2;
            this.zzf = j3;
            this.zzg = i2;
        }
        z = true;
        zzdb.zzd(z);
        uri.getClass();
        Uri uri22 = uri;
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zze = j2;
        this.zzf = j3;
        this.zzg = i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ zzgi(android.net.Uri r1, long r2, int r4, byte[] r5, java.util.Map r6, long r7, long r9, java.lang.String r11, int r12, java.lang.Object r13, com.google.android.gms.internal.ads.zzgh r14) {
        /*
            r0 = this;
            r13 = r12
            r12 = 0
            r14 = 0
            r3 = 0
            r5 = 1
            r10 = r9
            r8 = r7
            r7 = r6
            r6 = 0
            r2 = r1
            r1 = r0
            r1.<init>(r2, r3, r5, r6, r7, r8, r10, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgi.<init>(android.net.Uri, long, int, byte[], java.util.Map, long, long, java.lang.String, int, java.lang.Object, com.google.android.gms.internal.ads.zzgh):void");
    }

    @Deprecated
    public zzgi(Uri uri, long j, long j2, String str) {
        this(uri, 0, 1, (byte[]) null, Collections.emptyMap(), j, j2, (String) null, 0, (Object) null);
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "DataSpec[GET " + obj + ", " + this.zze + ", " + this.zzf + ", null, " + this.zzg + "]";
    }

    public final zzgg zza() {
        return new zzgg(this, (zzgh) null);
    }

    public final boolean zzb(int i) {
        return (this.zzg & i) == i;
    }
}
