package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import javax.annotation.Nullable;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepw implements zzevy {
    @Nullable
    private final Integer zza;

    private zzepw(@Nullable Integer num) {
        this.zza = num;
    }

    static /* bridge */ /* synthetic */ zzepw zzb(VersionInfoParcel versionInfoParcel) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjI)).booleanValue()) {
            return new zzepw((Integer) null);
        }
        zzv.zzq();
        int i = 0;
        try {
            if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzjL)).booleanValue()) {
                    if (versionInfoParcel.clientJarVersion >= ((Integer) zzbe.zzc().zza(zzbcn.zzjK)).intValue() && Build.VERSION.SDK_INT >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        i = SdkExtensions.getExtensionVersion(31);
                    }
                }
                return new zzepw(Integer.valueOf(i));
            }
            i = SdkExtensions.getExtensionVersion(DurationKt.NANOS_IN_MILLIS);
            return new zzepw(Integer.valueOf(i));
        } catch (Exception e) {
            zzv.zzp().zzw(e, "AdUtil.getAdServicesExtensionVersion");
        }
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
