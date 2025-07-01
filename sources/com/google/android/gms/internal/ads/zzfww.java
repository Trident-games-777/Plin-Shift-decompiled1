package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzfww extends zzfxb {
    final /* synthetic */ zzfwx zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfww(zzfwx zzfwx, zzfxd zzfxd, CharSequence charSequence) {
        super(zzfxd, charSequence);
        this.zza = zzfwx;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfwq.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            zzfwx zzfwx = this.zza;
            if (zzfwx.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
