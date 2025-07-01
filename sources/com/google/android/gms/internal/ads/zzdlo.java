package com.google.android.gms.internal.ads;

import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdlo implements Function {
    public final Object apply(Object obj) {
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject.optString("key").equals("afma_video_player_type")) {
                return optJSONObject.optString("value");
            }
        }
        return null;
    }
}
