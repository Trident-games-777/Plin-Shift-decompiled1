package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzse extends zzhm {
    private long zzg;
    private int zzh;
    private int zzi = 32;

    public zzse() {
        super(2, 0);
    }

    public final void zzb() {
        super.zzb();
        this.zzh = 0;
    }

    public final int zzm() {
        return this.zzh;
    }

    public final long zzn() {
        return this.zzg;
    }

    public final void zzo(int i) {
        this.zzi = i;
    }

    public final boolean zzp(zzhm zzhm) {
        ByteBuffer byteBuffer;
        zzdb.zzd(!zzhm.zzd(1073741824));
        zzdb.zzd(!zzhm.zzd(268435456));
        zzdb.zzd(!zzhm.zzd(4));
        if (zzq()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzhm.zzc;
            if (!(byteBuffer2 == null || (byteBuffer = this.zzc) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000)) {
                return false;
            }
        }
        int i = this.zzh;
        this.zzh = i + 1;
        if (i == 0) {
            this.zze = zzhm.zze;
            if (zzhm.zzd(1)) {
                zzc(1);
            }
        }
        ByteBuffer byteBuffer3 = zzhm.zzc;
        if (byteBuffer3 != null) {
            zzj(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzhm.zze;
        return true;
    }

    public final boolean zzq() {
        return this.zzh > 0;
    }
}
