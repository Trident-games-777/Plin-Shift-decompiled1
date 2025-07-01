package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcp implements zzcm {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzck zze = zzck.zza;
    private zzck zzf;
    private zzck zzg;
    private zzck zzh;
    private boolean zzi;
    private zzco zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzcp() {
        zzck zzck = zzck.zza;
        this.zzf = zzck;
        this.zzg = zzck;
        this.zzh = zzck;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
    }

    public final zzck zza(zzck zzck) throws zzcl {
        if (zzck.zzd == 2) {
            int i = this.zzb;
            if (i == -1) {
                i = zzck.zzb;
            }
            this.zze = zzck;
            zzck zzck2 = new zzck(i, zzck.zzc, 2);
            this.zzf = zzck2;
            this.zzi = true;
            return zzck2;
        }
        throw new zzcl("Unhandled input format:", zzck);
    }

    public final ByteBuffer zzb() {
        int zza;
        zzco zzco = this.zzj;
        if (zzco != null && (zza = zzco.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                ByteBuffer order = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzco.zzd(this.zzl);
            this.zzo += (long) zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    public final void zzc() {
        if (zzg()) {
            this.zzg = this.zze;
            this.zzh = this.zzf;
            if (this.zzi) {
                zzck zzck = this.zzg;
                this.zzj = new zzco(zzck.zzb, zzck.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzco zzco = this.zzj;
                if (zzco != null) {
                    zzco.zzc();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzd() {
        zzco zzco = this.zzj;
        if (zzco != null) {
            zzco.zze();
        }
        this.zzp = true;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzco zzco = this.zzj;
            zzco.getClass();
            zzco zzco2 = zzco;
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzn += (long) remaining;
            zzco.zzf(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        this.zze = zzck.zza;
        zzck zzck = zzck.zza;
        this.zzf = zzck;
        this.zzg = zzck;
        this.zzh = zzck;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 4.0f) >= 1.0E-4f || Math.abs(this.zzd - 4.0f) >= 1.0E-4f || this.zzf.zzb != this.zze.zzb) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzco zzco = this.zzj;
        return zzco == null || zzco.zza() == 0;
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 >= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            long j3 = this.zzn;
            zzco zzco = this.zzj;
            zzco.getClass();
            zzco zzco2 = zzco;
            long zzb2 = j3 - ((long) zzco.zzb());
            int i = this.zzh.zzb;
            int i2 = this.zzg.zzb;
            if (i == i2) {
                return zzen.zzu(j, zzb2, j2, RoundingMode.FLOOR);
            }
            return zzen.zzu(j, zzb2 * ((long) i), j2 * ((long) i2), RoundingMode.FLOOR);
        }
        return (long) (((double) this.zzc) * ((double) j));
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }
}
