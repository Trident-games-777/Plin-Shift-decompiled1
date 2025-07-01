package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzarf extends zzhfg {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk = 1.0d;
    private float zzl = 1.0f;
    private zzhfq zzm = zzhfq.zza;
    private long zzn;

    public zzarf() {
        super("mvhd");
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzhfl.zza(zzarb.zzf(byteBuffer));
            this.zzh = zzhfl.zza(zzarb.zzf(byteBuffer));
            this.zzi = zzarb.zze(byteBuffer);
            this.zzj = zzarb.zzf(byteBuffer);
        } else {
            this.zzg = zzhfl.zza(zzarb.zze(byteBuffer));
            this.zzh = zzhfl.zza(zzarb.zze(byteBuffer));
            this.zzi = zzarb.zze(byteBuffer);
            this.zzj = zzarb.zze(byteBuffer);
        }
        this.zzk = zzarb.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        ByteBuffer byteBuffer2 = byteBuffer;
        byteBuffer2.get(bArr);
        this.zzl = ((float) ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8)))))) / 256.0f;
        zzarb.zzd(byteBuffer2);
        zzarb.zze(byteBuffer2);
        zzarb.zze(byteBuffer2);
        double zzb = zzarb.zzb(byteBuffer2);
        double zzb2 = zzarb.zzb(byteBuffer2);
        double zza = zzarb.zza(byteBuffer2);
        this.zzm = new zzhfq(zzb, zzb2, zzarb.zzb(byteBuffer2), zzarb.zzb(byteBuffer2), zza, zzarb.zza(byteBuffer2), zzarb.zza(byteBuffer2), zzarb.zzb(byteBuffer2), zzarb.zzb(byteBuffer2));
        byteBuffer2.getInt();
        byteBuffer2.getInt();
        byteBuffer2.getInt();
        byteBuffer2.getInt();
        byteBuffer2.getInt();
        byteBuffer2.getInt();
        this.zzn = zzarb.zze(byteBuffer2);
    }
}
