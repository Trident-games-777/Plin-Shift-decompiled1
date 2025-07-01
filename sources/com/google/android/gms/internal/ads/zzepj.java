package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepj implements zzevy {
    final ArrayList zza;

    public zzepj(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zza);
    }
}
