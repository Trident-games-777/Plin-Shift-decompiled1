package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbeh;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class CsiUrlBuilder {
    private final String zza = ((String) zzbeh.zza.zze());

    public String generateUrl(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zza).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }
}
