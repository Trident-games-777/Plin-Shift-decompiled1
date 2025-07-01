package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfua extends zzfve {
    private IBinder zza;
    private String zzb;
    private int zzc;
    private float zzd;
    private int zze;
    private String zzf;
    private byte zzg;

    zzfua() {
    }

    public final zzfve zza(String str) {
        this.zzf = str;
        return this;
    }

    public final zzfve zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfve zzc(int i) {
        this.zzg = (byte) (this.zzg | 4);
        return this;
    }

    public final zzfve zzd(int i) {
        this.zzc = i;
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }

    public final zzfve zze(float f) {
        this.zzd = f;
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    public final zzfve zzf(int i) {
        this.zzg = (byte) (this.zzg | 8);
        return this;
    }

    public final zzfve zzg(IBinder iBinder) {
        if (iBinder != null) {
            this.zza = iBinder;
            return this;
        }
        throw new NullPointerException("Null windowToken");
    }

    public final zzfve zzh(int i) {
        this.zze = i;
        this.zzg = (byte) (this.zzg | Ascii.DLE);
        return this;
    }

    public final zzfvf zzi() {
        IBinder iBinder;
        if (this.zzg == 31 && (iBinder = this.zza) != null) {
            return new zzfuc(iBinder, this.zzb, this.zzc, this.zzd, 0, 0, (String) null, this.zze, (String) null, this.zzf, (String) null, (zzfub) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" windowToken");
        }
        if ((this.zzg & 1) == 0) {
            sb.append(" layoutGravity");
        }
        if ((this.zzg & 2) == 0) {
            sb.append(" layoutVerticalMargin");
        }
        if ((this.zzg & 4) == 0) {
            sb.append(" displayMode");
        }
        if ((this.zzg & 8) == 0) {
            sb.append(" triggerMode");
        }
        if ((this.zzg & Ascii.DLE) == 0) {
            sb.append(" windowWidthPx");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
