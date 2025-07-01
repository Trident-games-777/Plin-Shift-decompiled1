package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfry extends zzfsg {
    private String zza;
    private boolean zzb;
    private byte zzc;
    private int zzd;

    zzfry() {
    }

    public final zzfsg zza(String str) {
        this.zza = "";
        return this;
    }

    public final zzfsg zzb(boolean z) {
        this.zzc = (byte) (this.zzc | 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzfsg zzc(boolean z) {
        this.zzb = z;
        this.zzc = (byte) (this.zzc | 2);
        return this;
    }

    public final zzfsh zzd() {
        if (this.zzc == 3 && this.zza != null && this.zzd != 0) {
            return new zzfsa(this.zza, false, this.zzb, (zzfrw) null, (zzfrx) null, this.zzd, (zzfrz) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if ((this.zzc & 1) == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if ((this.zzc & 2) == 0) {
            sb.append(" skipChecks");
        }
        if (this.zzd == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zzfsg zze(int i) {
        this.zzd = 1;
        return this;
    }
}
