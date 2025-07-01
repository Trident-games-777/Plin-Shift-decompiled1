package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zztn implements zzsn {
    private final MediaCodec zza;
    private final zzsj zzb;

    /* synthetic */ zztn(MediaCodec mediaCodec, zzsj zzsj, zztm zztm) {
        this.zza = mediaCodec;
        this.zzb = zzsj;
        if (zzen.zza >= 35 && zzsj != null) {
            zzsj.zza(mediaCodec);
        }
    }

    public final int zza() {
        return this.zza.dequeueInputBuffer(0);
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0);
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
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
        this.zza.flush();
    }

    public final void zzk(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    public final void zzl(int i, int i2, zzhj zzhj, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzhj.zza(), j, 0);
    }

    /* JADX INFO: finally extract failed */
    public final void zzm() {
        zzsj zzsj;
        zzsj zzsj2;
        try {
            if (zzen.zza >= 30 && zzen.zza < 33) {
                this.zza.stop();
            }
            if (zzen.zza >= 35 && (zzsj2 = this.zzb) != null) {
                zzsj2.zzc(this.zza);
            }
            this.zza.release();
        } catch (Throwable th) {
            if (zzen.zza >= 35 && (zzsj = this.zzb) != null) {
                zzsj.zzc(this.zza);
            }
            this.zza.release();
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
        this.zza.setParameters(bundle);
    }

    public final void zzr(int i) {
        this.zza.setVideoScalingMode(i);
    }

    public final /* synthetic */ boolean zzs(zzsm zzsm) {
        return false;
    }
}
