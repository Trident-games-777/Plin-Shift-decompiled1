package com.google.android.gms.internal.ads;

import android.net.Network;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzfsu implements zzfsx {
    public final /* synthetic */ Network zza;
    public final /* synthetic */ URL zzb;

    public /* synthetic */ zzfsu(Network network, URL url) {
        this.zza = network;
        this.zzb = url;
    }

    public final URLConnection zza() {
        return this.zza.openConnection(this.zzb);
    }
}
