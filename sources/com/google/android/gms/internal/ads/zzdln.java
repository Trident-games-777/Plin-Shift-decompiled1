package com.google.android.gms.internal.ads;

import java.util.function.Function;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdln implements Function {
    public final Object apply(Object obj) {
        return ((JSONObject) obj).optJSONArray("flags");
    }
}
