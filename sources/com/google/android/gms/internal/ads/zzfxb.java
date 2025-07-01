package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
abstract class zzfxb extends zzfvz {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = Integer.MAX_VALUE;

    protected zzfxb(zzfxd zzfxd, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzc;
        while (true) {
            int i3 = this.zzc;
            if (i3 != -1) {
                int zzd2 = zzd(i3);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zzc = -1;
                    i = -1;
                } else {
                    i = zzc(zzd2);
                    this.zzc = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zzc = i4;
                    if (i4 > this.zzb.length()) {
                        this.zzc = -1;
                    }
                } else {
                    if (i2 < zzd2) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    int i5 = this.zzd;
                    if (i5 == 1) {
                        zzd2 = this.zzb.length();
                        this.zzc = -1;
                        if (zzd2 > i2) {
                            this.zzb.charAt(zzd2 - 1);
                        }
                    } else {
                        this.zzd = i5 - 1;
                    }
                    return this.zzb.subSequence(i2, zzd2).toString();
                }
            } else {
                zzb();
                String str = null;
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i);
}
