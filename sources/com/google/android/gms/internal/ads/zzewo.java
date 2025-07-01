package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzewo implements zzevz {
    private final zzges zza;
    private final Context zzb;

    public zzewo(zzges zzges, Context context) {
        this.zza = zzges;
        this.zzb = context;
    }

    public final int zza() {
        return 39;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzewn(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzewm zzc() throws Exception {
        int i;
        boolean z;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzb.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        String networkOperator = telephonyManager.getNetworkOperator();
        int phoneType = telephonyManager.getPhoneType();
        zzv.zzq();
        int i2 = -1;
        if (zzs.zzA(this.zzb, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzb.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i = type;
                i2 = ordinal;
            } else {
                i = -1;
            }
            z = connectivityManager.isActiveNetworkMetered();
        } else {
            z = false;
            i = -2;
        }
        return new zzewm(networkOperator, i, zzv.zzr().zzm(this.zzb), phoneType, z, i2);
    }
}
