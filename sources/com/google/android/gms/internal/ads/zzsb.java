package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzsb implements zzso {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf = new AtomicReference();
    private final zzdf zzg;
    private boolean zzh;

    public zzsb(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdf zzdf = new zzdf(zzdc.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdf;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    static /* bridge */ /* synthetic */ void zza(com.google.android.gms.internal.ads.zzsb r10, android.os.Message r11) {
        /*
            int r0 = r11.what
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x005b
            r1 = 2
            if (r0 == r1) goto L_0x0038
            r1 = 3
            if (r0 == r1) goto L_0x0032
            r1 = 4
            if (r0 == r1) goto L_0x0020
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r0.<init>(r11)
            com.google.android.gms.internal.ads.zzry.zza(r10, r2, r0)
            goto L_0x0077
        L_0x0020:
            java.lang.Object r11 = r11.obj
            android.os.Bundle r11 = (android.os.Bundle) r11
            android.media.MediaCodec r0 = r10.zzc     // Catch:{ RuntimeException -> 0x002a }
            r0.setParameters(r11)     // Catch:{ RuntimeException -> 0x002a }
            goto L_0x0077
        L_0x002a:
            r0 = move-exception
            r11 = r0
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            com.google.android.gms.internal.ads.zzry.zza(r10, r2, r11)
            goto L_0x0077
        L_0x0032:
            com.google.android.gms.internal.ads.zzdf r10 = r10.zzg
            r10.zze()
            goto L_0x0077
        L_0x0038:
            java.lang.Object r11 = r11.obj
            com.google.android.gms.internal.ads.zzsa r11 = (com.google.android.gms.internal.ads.zzsa) r11
            int r4 = r11.zza
            int r0 = r11.zzb
            android.media.MediaCodec$CryptoInfo r6 = r11.zzd
            long r7 = r11.zze
            int r9 = r11.zzf
            java.lang.Object r1 = zzb     // Catch:{ RuntimeException -> 0x0054 }
            monitor-enter(r1)     // Catch:{ RuntimeException -> 0x0054 }
            android.media.MediaCodec r3 = r10.zzc     // Catch:{ all -> 0x0051 }
            r5 = 0
            r3.queueSecureInputBuffer(r4, r5, r6, r7, r9)     // Catch:{ all -> 0x0051 }
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            goto L_0x0076
        L_0x0051:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            throw r0     // Catch:{ RuntimeException -> 0x0054 }
        L_0x0054:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            com.google.android.gms.internal.ads.zzry.zza(r10, r2, r0)
            goto L_0x0076
        L_0x005b:
            java.lang.Object r11 = r11.obj
            com.google.android.gms.internal.ads.zzsa r11 = (com.google.android.gms.internal.ads.zzsa) r11
            int r4 = r11.zza
            int r0 = r11.zzb
            int r6 = r11.zzc
            long r7 = r11.zze
            int r9 = r11.zzf
            android.media.MediaCodec r3 = r10.zzc     // Catch:{ RuntimeException -> 0x0070 }
            r5 = 0
            r3.queueInputBuffer(r4, r5, r6, r7, r9)     // Catch:{ RuntimeException -> 0x0070 }
            goto L_0x0076
        L_0x0070:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            com.google.android.gms.internal.ads.zzry.zza(r10, r2, r0)
        L_0x0076:
            r2 = r11
        L_0x0077:
            if (r2 == 0) goto L_0x0085
            java.util.ArrayDeque r10 = zza
            monitor-enter(r10)
            r10.add(r2)     // Catch:{ all -> 0x0081 }
            monitor-exit(r10)     // Catch:{ all -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r0 = move-exception
            r11 = r0
            monitor-exit(r10)     // Catch:{ all -> 0x0081 }
            throw r11
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsb.zza(com.google.android.gms.internal.ads.zzsb, android.os.Message):void");
    }

    private static zzsa zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                zzsa zzsa = new zzsa();
                return zzsa;
            }
            zzsa zzsa2 = (zzsa) arrayDeque.removeFirst();
            return zzsa2;
        }
    }

    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler != null) {
                    Handler handler2 = handler;
                    handler.removeCallbacksAndMessages((Object) null);
                    this.zzg.zzc();
                    Handler handler3 = this.zze;
                    if (handler3 != null) {
                        Handler handler4 = handler3;
                        handler3.obtainMessage(3).sendToTarget();
                        this.zzg.zza();
                        return;
                    }
                    throw null;
                }
                throw null;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void zzc() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet((Object) null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final void zzd(int i, int i2, int i3, long j, int i4) {
        zzc();
        zzsa zzi = zzi();
        zzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        int i5 = zzen.zza;
        Handler handler2 = handler;
        handler.obtainMessage(1, zzi).sendToTarget();
    }

    public final void zze(int i, int i2, zzhj zzhj, long j, int i3) {
        zzc();
        zzsa zzi = zzi();
        zzi.zza(i, 0, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzi.zzd;
        cryptoInfo.numSubSamples = zzhj.zzf;
        cryptoInfo.numBytesOfClearData = zzk(zzhj.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzk(zzhj.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] zzj = zzj(zzhj.zzb, cryptoInfo.key);
        zzj.getClass();
        cryptoInfo.key = zzj;
        byte[] zzj2 = zzj(zzhj.zza, cryptoInfo.iv);
        zzj2.getClass();
        cryptoInfo.iv = zzj2;
        cryptoInfo.mode = zzhj.zzc;
        if (zzen.zza >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzhj.zzg, zzhj.zzh));
        }
        Handler handler = this.zze;
        Handler handler2 = handler;
        handler.obtainMessage(2, zzi).sendToTarget();
    }

    public final void zzf(Bundle bundle) {
        zzc();
        Handler handler = this.zze;
        int i = zzen.zza;
        Handler handler2 = handler;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    public final void zzg() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    public final void zzh() {
        if (!this.zzh) {
            this.zzd.start();
            this.zze = new zzrz(this, this.zzd.getLooper());
            this.zzh = true;
        }
    }

    private static byte[] zzj(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static int[] zzk(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }
}
