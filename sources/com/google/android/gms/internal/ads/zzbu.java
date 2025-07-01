package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbu {
    public static final Object zza = new Object();
    private static final zzaw zzp;
    public Object zzb = zza;
    @Deprecated
    public Object zzc;
    public zzaw zzd = zzp;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;
    public zzaq zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public int zzn;
    public int zzo;

    static {
        zzak zzak = new zzak();
        zzak.zza("androidx.media3.common.Timeline");
        zzak.zzb(Uri.EMPTY);
        zzp = zzak.zzc();
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass().equals(obj.getClass())) {
            zzbu zzbu = (zzbu) obj;
            return Objects.equals(this.zzb, zzbu.zzb) && Objects.equals(this.zzd, zzbu.zzd) && Objects.equals((Object) null, (Object) null) && Objects.equals(this.zzj, zzbu.zzj) && this.zze == zzbu.zze && this.zzf == zzbu.zzf && this.zzg == zzbu.zzg && this.zzh == zzbu.zzh && this.zzi == zzbu.zzi && this.zzk == zzbu.zzk && this.zzm == zzbu.zzm && this.zzn == zzbu.zzn && this.zzo == zzbu.zzo;
        }
    }

    public final int hashCode() {
        int i;
        int hashCode = ((this.zzb.hashCode() + 217) * 31) + this.zzd.hashCode();
        zzaq zzaq = this.zzj;
        if (zzaq == null) {
            i = 0;
        } else {
            i = zzaq.hashCode();
        }
        long j = this.zze;
        long j2 = this.zzf;
        long j3 = this.zzg;
        int i2 = (((((((((((((hashCode * 961) + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzk ? 1 : 0);
        long j4 = this.zzm;
        return ((((((i2 * 961) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.zzn) * 31) + this.zzo) * 31;
    }

    public final zzbu zza(Object obj, zzaw zzaw, Object obj2, long j, long j2, long j3, boolean z, boolean z2, zzaq zzaq, long j4, long j5, int i, int i2, long j6) {
        this.zzb = obj;
        if (zzaw == null) {
            zzaw = zzp;
        }
        this.zzd = zzaw;
        this.zzc = null;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = z;
        this.zzi = z2;
        this.zzj = zzaq;
        this.zzl = 0;
        this.zzm = j5;
        this.zzn = 0;
        this.zzo = 0;
        this.zzk = false;
        return this;
    }

    public final boolean zzb() {
        return this.zzj != null;
    }
}
