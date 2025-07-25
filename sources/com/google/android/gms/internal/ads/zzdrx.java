package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdrx {
    public static Bundle zza(Pair... pairArr) {
        Bundle bundle = new Bundle();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue()) {
            for (int i = 0; i < 2; i++) {
                Pair pair = pairArr[i];
                if (!TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                    bundle.putLong((String) pair.first, ((Long) pair.second).longValue());
                }
            }
        }
        return bundle;
    }
}
