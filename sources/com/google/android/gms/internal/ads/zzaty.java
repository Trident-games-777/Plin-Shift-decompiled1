package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaty implements Runnable {
    private zzaty() {
        throw null;
    }

    /* synthetic */ zzaty(zzatz zzatz) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzaua.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzaua.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzaua.zzb;
        } catch (Throwable th) {
            zzaua.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
