package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.collection.CircularIntArray;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzsd extends MediaCodec.Callback {
    private final Object zza = new Object();
    private final HandlerThread zzb;
    private Handler zzc;
    private final CircularIntArray zzd;
    private final CircularIntArray zze;
    private final ArrayDeque zzf;
    private final ArrayDeque zzg;
    private MediaFormat zzh;
    private MediaFormat zzi;
    private MediaCodec.CodecException zzj;
    private MediaCodec.CryptoException zzk;
    private long zzl;
    private boolean zzm;
    private IllegalStateException zzn;
    private zzsm zzo;

    zzsd(HandlerThread handlerThread) {
        this.zzb = handlerThread;
        this.zzd = new CircularIntArray();
        this.zze = new CircularIntArray();
        this.zzf = new ArrayDeque();
        this.zzg = new ArrayDeque();
    }

    public static /* synthetic */ void zzd(zzsd zzsd) {
        synchronized (zzsd.zza) {
            if (!zzsd.zzm) {
                long j = zzsd.zzl - 1;
                zzsd.zzl = j;
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i <= 0) {
                    if (i < 0) {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        synchronized (zzsd.zza) {
                            zzsd.zzn = illegalStateException;
                        }
                        return;
                    }
                    zzsd.zzj();
                }
            }
        }
    }

    private final void zzi(MediaFormat mediaFormat) {
        this.zze.addLast(-2);
        this.zzg.add(mediaFormat);
    }

    private final void zzj() {
        if (!this.zzg.isEmpty()) {
            this.zzi = (MediaFormat) this.zzg.getLast();
        }
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
    }

    private final void zzk() {
        IllegalStateException illegalStateException = this.zzn;
        if (illegalStateException == null) {
            MediaCodec.CodecException codecException = this.zzj;
            if (codecException == null) {
                MediaCodec.CryptoException cryptoException = this.zzk;
                if (cryptoException != null) {
                    this.zzk = null;
                    throw cryptoException;
                }
                return;
            }
            this.zzj = null;
            throw codecException;
        }
        this.zzn = null;
        throw illegalStateException;
    }

    private final boolean zzl() {
        return this.zzl > 0 || this.zzm;
    }

    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.zza) {
            this.zzk = cryptoException;
        }
    }

    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.zza) {
            this.zzd.addLast(i);
            zzsm zzsm = this.zzo;
            if (zzsm != null) {
                zzsy zzsy = ((zzsv) zzsm).zza;
                if (zzsy.zzo != null) {
                    zzsy.zzo.zza();
                }
            }
        }
    }

    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            MediaFormat mediaFormat = this.zzi;
            if (mediaFormat != null) {
                zzi(mediaFormat);
                this.zzi = null;
            }
            this.zze.addLast(i);
            this.zzf.add(bufferInfo);
            zzsm zzsm = this.zzo;
            if (zzsm != null) {
                zzsy zzsy = ((zzsv) zzsm).zza;
                if (zzsy.zzo != null) {
                    zzsy.zzo.zza();
                }
            }
        }
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzi(mediaFormat);
            this.zzi = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            r3.zzk()     // Catch:{ all -> 0x0020 }
            boolean r1 = r3.zzl()     // Catch:{ all -> 0x0020 }
            r2 = -1
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x000f:
            androidx.collection.CircularIntArray r1 = r3.zzd     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            androidx.collection.CircularIntArray r1 = r3.zzd     // Catch:{ all -> 0x0020 }
            int r2 = r1.popFirst()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x0020:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsd.zza():int");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r1 = r9.zza
            monitor-enter(r1)
            r9.zzk()     // Catch:{ all -> 0x004b }
            boolean r0 = r9.zzl()     // Catch:{ all -> 0x004b }
            r2 = -1
            if (r0 == 0) goto L_0x000f
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return r2
        L_0x000f:
            androidx.collection.CircularIntArray r0 = r9.zze     // Catch:{ all -> 0x004b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0019
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return r2
        L_0x0019:
            androidx.collection.CircularIntArray r0 = r9.zze     // Catch:{ all -> 0x004b }
            int r0 = r0.popFirst()     // Catch:{ all -> 0x004b }
            if (r0 < 0) goto L_0x003b
            android.media.MediaFormat r2 = r9.zzh     // Catch:{ all -> 0x004b }
            com.google.android.gms.internal.ads.zzdb.zzb(r2)     // Catch:{ all -> 0x004b }
            java.util.ArrayDeque r2 = r9.zzf     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.remove()     // Catch:{ all -> 0x004b }
            android.media.MediaCodec$BufferInfo r2 = (android.media.MediaCodec.BufferInfo) r2     // Catch:{ all -> 0x004b }
            int r4 = r2.offset     // Catch:{ all -> 0x004b }
            int r5 = r2.size     // Catch:{ all -> 0x004b }
            long r6 = r2.presentationTimeUs     // Catch:{ all -> 0x004b }
            int r8 = r2.flags     // Catch:{ all -> 0x004b }
            r3 = r10
            r3.set(r4, r5, r6, r8)     // Catch:{ all -> 0x004b }
            goto L_0x0049
        L_0x003b:
            r10 = -2
            if (r0 != r10) goto L_0x0049
            java.util.ArrayDeque r0 = r9.zzg     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r0.remove()     // Catch:{ all -> 0x004b }
            android.media.MediaFormat r0 = (android.media.MediaFormat) r0     // Catch:{ all -> 0x004b }
            r9.zzh = r0     // Catch:{ all -> 0x004b }
            r0 = r10
        L_0x0049:
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return r0
        L_0x004b:
            r0 = move-exception
            r10 = r0
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsd.zzb(android.media.MediaCodec$BufferInfo):int");
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            mediaFormat = this.zzh;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzl++;
            Handler handler = this.zzc;
            int i = zzen.zza;
            Handler handler2 = handler;
            handler.post(new zzsc(this));
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        zzdb.zzf(this.zzc == null);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg(zzsm zzsm) {
        synchronized (this.zza) {
            this.zzo = zzsm;
        }
    }

    public final void zzh() {
        synchronized (this.zza) {
            this.zzm = true;
            this.zzb.quit();
            zzj();
        }
    }
}
