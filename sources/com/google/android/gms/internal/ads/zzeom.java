package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeom implements zzevz {
    private final zzevz zza;
    private final zzffo zzb;
    private final Context zzc;
    private final zzbzz zzd;

    public zzeom(zzeqp zzeqp, zzffo zzffo, Context context, zzbzz zzbzz) {
        this.zza = zzeqp;
        this.zzb = zzffo;
        this.zzc = context;
        this.zzd = zzbzz;
    }

    public final int zza() {
        return 7;
    }

    public final ListenableFuture zzb() {
        return zzgei.zzm(this.zza.zzb(), new zzeol(this), zzcaj.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeon zzc(zzewi zzewi) {
        boolean z;
        String str;
        String str2;
        int i;
        int i2;
        float f;
        float f2;
        DisplayMetrics displayMetrics;
        zzs zzs = this.zzb.zze;
        zzs[] zzsArr = zzs.zzg;
        if (zzsArr == null) {
            str = zzs.zza;
            z = zzs.zzi;
        } else {
            String str3 = null;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (zzs zzs2 : zzsArr) {
                boolean z5 = zzs2.zzi;
                if (!z5 && !z3) {
                    str3 = zzs2.zza;
                    z3 = true;
                }
                if (z5) {
                    if (!z4) {
                        z2 = true;
                    }
                    z4 = true;
                }
                if (z3 && z4) {
                    break;
                }
            }
            str = str3;
            z = z2;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            i = 0;
            f2 = 0.0f;
            f = 0.0f;
            i2 = 0;
        } else {
            zzbzz zzbzz = this.zzd;
            float f3 = displayMetrics.density;
            int i3 = displayMetrics.widthPixels;
            int i4 = displayMetrics.heightPixels;
            int i5 = i3;
            str2 = zzbzz.zzi().zzj();
            f2 = 0.0f;
            i2 = i5;
            float f4 = f3;
            i = i4;
            f = f4;
        }
        StringBuilder sb = new StringBuilder();
        zzs[] zzsArr2 = zzs.zzg;
        if (zzsArr2 != null) {
            int i6 = 0;
            boolean z6 = false;
            while (true) {
                float f5 = f2;
                if (i6 >= zzsArr2.length) {
                    break;
                }
                zzs zzs3 = zzsArr2[i6];
                if (zzs3.zzi) {
                    z6 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i7 = zzs3.zze;
                    if (i7 == -1) {
                        i7 = f != f5 ? (int) (((float) zzs3.zzf) / f) : -1;
                    }
                    sb.append(i7);
                    sb.append("x");
                    int i8 = zzs3.zzb;
                    if (i8 == -2) {
                        i8 = f != f5 ? (int) (((float) zzs3.zzc) / f) : -2;
                    }
                    sb.append(i8);
                }
                i6++;
                f2 = f5;
            }
            if (z6) {
                if (sb.length() != 0) {
                    sb.insert(0, "|");
                }
                sb.insert(0, "320x50");
            }
        }
        return new zzeon(zzs, str, z, sb.toString(), f, i2, i, str2, this.zzb.zzq);
    }
}
