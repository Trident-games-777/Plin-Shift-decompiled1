package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzglw extends zzglu {
    public zzglw(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final zzgls zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzglv(bArr, i);
    }
}
