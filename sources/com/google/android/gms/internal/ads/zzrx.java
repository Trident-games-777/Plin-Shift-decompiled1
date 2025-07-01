package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzrx implements zzsn {
    private final MediaCodec zza;
    private final zzsd zzb;
    private final zzso zzc;
    private final zzsj zzd;
    private boolean zze;
    private int zzf = 0;

    /* synthetic */ zzrx(MediaCodec mediaCodec, HandlerThread handlerThread, zzso zzso, zzsj zzsj, zzrw zzrw) {
        this.zza = mediaCodec;
        this.zzb = new zzsd(handlerThread);
        this.zzc = zzso;
        this.zzd = zzsj;
    }

    static /* bridge */ /* synthetic */ void zzh(zzrx zzrx, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        zzsj zzsj;
        zzrx.zzb.zzf(zzrx.zza);
        Trace.beginSection("configureCodec");
        zzrx.zza.configure(mediaFormat, surface, (MediaCrypto) null, i);
        Trace.endSection();
        zzrx.zzc.zzh();
        Trace.beginSection("startCodec");
        zzrx.zza.start();
        Trace.endSection();
        if (zzen.zza >= 35 && (zzsj = zzrx.zzd) != null) {
            zzsj.zza(zzrx.zza);
        }
        zzrx.zzf = 1;
    }

    /* access modifiers changed from: private */
    public static String zzt(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    public final ByteBuffer zzf(int i) {
        return this.zza.getInputBuffer(i);
    }

    public final ByteBuffer zzg(int i) {
        return this.zza.getOutputBuffer(i);
    }

    public final void zzi() {
        this.zza.detachOutputSurface();
    }

    public final void zzj() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    public final void zzk(int i, int i2, int i3, long j, int i4) {
        this.zzc.zzd(i, 0, i3, j, i4);
    }

    public final void zzl(int i, int i2, zzhj zzhj, long j, int i3) {
        this.zzc.zze(i, 0, zzhj, j, 0);
    }

    public final void zzm() {
        zzsj zzsj;
        zzsj zzsj2;
        zzsj zzsj3;
        try {
            if (this.zzf == 1) {
                this.zzc.zzg();
                this.zzb.zzh();
            }
            this.zzf = 2;
            if (!this.zze) {
                if (zzen.zza >= 30 && zzen.zza < 33) {
                    this.zza.stop();
                }
                if (zzen.zza >= 35 && (zzsj3 = this.zzd) != null) {
                    zzsj3.zzc(this.zza);
                }
                this.zza.release();
                this.zze = true;
            }
        } catch (Throwable th) {
            if (zzen.zza >= 35 && (zzsj2 = this.zzd) != null) {
                zzsj2.zzc(this.zza);
            }
            this.zza.release();
            this.zze = true;
            throw th;
        }
    }

    public final void zzn(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    public final void zzo(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    public final void zzp(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    public final void zzq(Bundle bundle) {
        this.zzc.zzf(bundle);
    }

    public final void zzr(int i) {
        this.zza.setVideoScalingMode(i);
    }

    public final boolean zzs(zzsm zzsm) {
        this.zzb.zzg(zzsm);
        return true;
    }
}
