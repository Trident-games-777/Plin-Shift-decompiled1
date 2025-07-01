package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public interface zzsn {
    int zza();

    int zzb(MediaCodec.BufferInfo bufferInfo);

    MediaFormat zzc();

    ByteBuffer zzf(int i);

    ByteBuffer zzg(int i);

    void zzi();

    void zzj();

    void zzk(int i, int i2, int i3, long j, int i4);

    void zzl(int i, int i2, zzhj zzhj, long j, int i3);

    void zzm();

    void zzn(int i, long j);

    void zzo(int i, boolean z);

    void zzp(Surface surface);

    void zzq(Bundle bundle);

    void zzr(int i);

    boolean zzs(zzsm zzsm);
}
