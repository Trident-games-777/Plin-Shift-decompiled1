package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcj {
    private final zzfzo zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private boolean zzd;

    public zzcj(zzfzo zzfzo) {
        this.zza = zzfzo;
        zzck zzck = zzck.zza;
        this.zzd = false;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z;
        ByteBuffer byteBuffer2;
        do {
            z = false;
            for (int i = 0; i <= zzi(); i++) {
                if (!this.zzc[i].hasRemaining()) {
                    zzcm zzcm = (zzcm) this.zzb.get(i);
                    if (!zzcm.zzh()) {
                        if (i > 0) {
                            byteBuffer2 = this.zzc[i - 1];
                        } else {
                            byteBuffer2 = byteBuffer.hasRemaining() ? byteBuffer : zzcm.zza;
                        }
                        zzcm.zze(byteBuffer2);
                        this.zzc[i] = zzcm.zzb();
                        int i2 = ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) > 0 ? 1 : ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) == 0 ? 0 : -1));
                        boolean z2 = true;
                        if (i2 <= 0 && !this.zzc[i].hasRemaining()) {
                            z2 = false;
                        }
                        z |= z2;
                    } else if (!this.zzc[i].hasRemaining() && i < zzi()) {
                        ((zzcm) this.zzb.get(i + 1)).zzd();
                    }
                }
            }
        } while (z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcj)) {
            return false;
        }
        zzcj zzcj = (zzcj) obj;
        if (this.zza.size() != zzcj.zza.size()) {
            return false;
        }
        for (int i = 0; i < this.zza.size(); i++) {
            if (this.zza.get(i) != zzcj.zza.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzck zza(zzck zzck) throws zzcl {
        if (!zzck.equals(zzck.zza)) {
            for (int i = 0; i < this.zza.size(); i++) {
                zzcm zzcm = (zzcm) this.zza.get(i);
                zzck zza2 = zzcm.zza(zzck);
                if (zzcm.zzg()) {
                    zzdb.zzf(!zza2.equals(zzck.zza));
                    zzck = zza2;
                }
            }
            return zzck;
        }
        throw new zzcl("Unhandled input format:", zzck);
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzcm.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzcm.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = false;
        for (int i = 0; i < this.zza.size(); i++) {
            zzcm zzcm = (zzcm) this.zza.get(i);
            zzcm.zzc();
            if (zzcm.zzg()) {
                this.zzb.add(zzcm);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i2 = 0; i2 <= zzi(); i2++) {
            this.zzc[i2] = ((zzcm) this.zzb.get(i2)).zzb();
        }
    }

    public final void zzd() {
        if (zzh() && !this.zzd) {
            this.zzd = true;
            ((zzcm) this.zzb.get(0)).zzd();
        }
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (zzh() && !this.zzd) {
            zzj(byteBuffer);
        }
    }

    public final void zzf() {
        for (int i = 0; i < this.zza.size(); i++) {
            zzcm zzcm = (zzcm) this.zza.get(i);
            zzcm.zzc();
            zzcm.zzf();
        }
        this.zzc = new ByteBuffer[0];
        zzck zzck = zzck.zza;
        this.zzd = false;
    }

    public final boolean zzg() {
        return this.zzd && ((zzcm) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining();
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
