package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaus implements zzfrk {
    final /* synthetic */ zzfpk zza;

    zzaus(zzauu zzauu, zzfpk zzfpk) {
        this.zza = zzfpk;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
