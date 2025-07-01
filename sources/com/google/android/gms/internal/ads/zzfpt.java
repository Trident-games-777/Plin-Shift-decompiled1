package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfpt extends zzfpq {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private long zzd;
    private long zze;
    private byte zzf;

    zzfpt() {
    }

    public final zzfpq zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    public final zzfpq zzb(boolean z) {
        this.zzf = (byte) (this.zzf | Ascii.DLE);
        return this;
    }

    public final zzfpq zzc(boolean z) {
        this.zzf = (byte) (this.zzf | 4);
        return this;
    }

    public final zzfpq zzd(boolean z) {
        this.zzc = true;
        this.zzf = (byte) (this.zzf | 2);
        return this;
    }

    public final zzfpq zze(long j) {
        this.zze = 300;
        this.zzf = (byte) (this.zzf | 32);
        return this;
    }

    public final zzfpq zzf(long j) {
        this.zzd = 100;
        this.zzf = (byte) (this.zzf | 8);
        return this;
    }

    public final zzfpq zzg(boolean z) {
        this.zzb = z;
        this.zzf = (byte) (this.zzf | 1);
        return this;
    }

    public final zzfpr zzh() {
        String str;
        if (this.zzf == 63 && (str = this.zza) != null) {
            return new zzfpv(str, this.zzb, this.zzc, false, this.zzd, false, this.zze, (zzfpu) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" clientVersion");
        }
        if ((this.zzf & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.zzf & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        if ((this.zzf & 4) == 0) {
            sb.append(" enableQuerySignalsTimeout");
        }
        if ((this.zzf & 8) == 0) {
            sb.append(" querySignalsTimeoutMs");
        }
        if ((this.zzf & Ascii.DLE) == 0) {
            sb.append(" enableQuerySignalsCache");
        }
        if ((this.zzf & 32) == 0) {
            sb.append(" querySignalsCacheTtlSeconds");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
