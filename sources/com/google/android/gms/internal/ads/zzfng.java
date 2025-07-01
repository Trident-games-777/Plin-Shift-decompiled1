package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfng implements WebViewCompat.WebMessageListener {
    final /* synthetic */ zzfnh zza;

    zzfng(zzfnh zzfnh) {
        this.zza = zzfnh;
    }

    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        try {
            JSONObject jSONObject = new JSONObject(webMessageCompat.getData());
            String string = jSONObject.getString(FirebaseAnalytics.Param.METHOD);
            String string2 = jSONObject.getJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).getString("adSessionId");
            if (string.equals("startSession")) {
                zzfnh.zzd(this.zza, string2);
            } else if (!string.equals("finishSession")) {
                zzfmt.zza.booleanValue();
            } else {
                zzfnh.zzb(this.zza, string2);
            }
        } catch (JSONException e) {
            zzfoo.zza("Error parsing JS message in JavaScriptSessionService.", e);
        }
    }
}
