package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzewr implements zzgdp {
    public final ListenableFuture zza(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (getTopicsResponse == null) {
            return zzgei.zzh(new zzewv("", 1, (zzewu) null));
        }
        zzhch zzc = zzhci.zzc();
        for (Topic next : getTopicsResponse.getTopics()) {
            zzhcf zzc2 = zzhcg.zzc();
            zzc2.zzc(next.getTopicId());
            zzc2.zza(next.getModelVersion());
            zzc2.zzb(next.getTaxonomyVersion());
            zzc.zza((zzhcg) zzc2.zzbr());
        }
        return zzgei.zzh(new zzewv(Base64.encodeToString(((zzhci) zzc.zzbr()).zzaV(), 1), 1, (zzewu) null));
    }
}
