package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzv;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcrc extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcrc(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcrc zza(Context context, View view, zzfet zzfet) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcrc zzcrc = new zzcrc(context);
        if (!(zzfet.zzu.isEmpty() || (resources = zzcrc.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzfeu zzfeu = (zzfeu) zzfet.zzu.get(0);
            zzcrc.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzfeu.zza) * displayMetrics.density), (int) (((float) zzfeu.zzb) * displayMetrics.density)));
        }
        zzcrc.zzb = view;
        zzcrc.addView(view);
        zzv.zzy();
        zzcaw.zzb(zzcrc, zzcrc);
        zzv.zzy();
        zzcaw.zza(zzcrc, zzcrc);
        JSONObject jSONObject = zzfet.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzcrc.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzcrc.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcrc.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzcrc.addView(relativeLayout);
        return zzcrc;
    }

    private final int zzb(double d) {
        zzbc.zzb();
        return zzf.zzy(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb2 = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, zzb2, 0, zzb2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
