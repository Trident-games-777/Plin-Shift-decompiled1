package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbpg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public class LiteSdkInfo extends zzcv {
    public LiteSdkInfo(Context context) {
    }

    public zzbpg getAdapterCreator() {
        return new zzbpc();
    }

    public zzfb getLiteSdkVersion() {
        return new zzfb(ModuleDescriptor.MODULE_VERSION, 243799000, "23.5.0");
    }
}
