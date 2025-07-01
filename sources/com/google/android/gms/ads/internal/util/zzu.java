package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzu extends zzt {
    static final boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final boolean zzd(Activity activity, Configuration configuration) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzeQ)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeS)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzbc.zzb();
        int zzy = zzf.zzy(activity, configuration.screenHeightDp);
        int zzy2 = zzf.zzy(activity, configuration.screenWidthDp);
        zzv.zzq();
        DisplayMetrics zzt = zzs.zzt((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zzt.heightPixels;
        int i2 = zzt.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzbe.zzc().zza(zzbcn.zzeO)).intValue();
        if (!zze(i, zzy + dimensionPixelSize, round) || !zze(i2, zzy2, round)) {
            return true;
        }
        return false;
    }
}
