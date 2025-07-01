package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbcn;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzu extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final ImageButton zza;
    private final zzag zzb;

    public zzu(Context context, zzt zzt, zzag zzag) {
        super(context);
        this.zzb = zzag;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        zzc();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzbc.zzb();
        int zzy = zzf.zzy(context, zzt.zza);
        zzbc.zzb();
        int zzy2 = zzf.zzy(context, 0);
        zzbc.zzb();
        int zzy3 = zzf.zzy(context, zzt.zzb);
        zzbc.zzb();
        imageButton.setPadding(zzy, zzy2, zzy3, zzf.zzy(context, zzt.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzbc.zzb();
        int zzy4 = zzf.zzy(context, zzt.zzd + zzt.zza + zzt.zzb);
        zzbc.zzb();
        addView(imageButton, new FrameLayout.LayoutParams(zzy4, zzf.zzy(context, zzt.zzd + zzt.zzc), 17));
        long longValue = ((Long) zzbe.zzc().zza(zzbcn.zzbj)).longValue();
        if (longValue > 0) {
            zzs zzs = ((Boolean) zzbe.zzc().zza(zzbcn.zzbk)).booleanValue() ? new zzs(this) : null;
            imageButton.setAlpha(0.0f);
            imageButton.animate().alpha(1.0f).setDuration(longValue).setListener(zzs);
        }
    }

    private final void zzc() {
        String str = (String) zzbe.zzc().zza(zzbcn.zzbi);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || "default".equals(str)) {
            this.zza.setImageResource(17301527);
            return;
        }
        Resources zze = zzv.zzp().zze();
        if (zze != null) {
            Drawable drawable = null;
            try {
                if ("white".equals(str)) {
                    drawable = zze.getDrawable(R.drawable.admob_close_button_white_circle_black_cross);
                } else if ("black".equals(str)) {
                    drawable = zze.getDrawable(R.drawable.admob_close_button_black_circle_white_cross);
                }
            } catch (Resources.NotFoundException unused) {
                zzm.zze("Close button resource not found, falling back to default.");
            }
            if (drawable == null) {
                this.zza.setImageResource(17301527);
                return;
            }
            this.zza.setImageDrawable(drawable);
            this.zza.setScaleType(ImageView.ScaleType.CENTER);
            return;
        }
        this.zza.setImageResource(17301527);
    }

    public final void onClick(View view) {
        zzag zzag = this.zzb;
        if (zzag != null) {
            zzag.zzj();
        }
    }

    public final void zzb(boolean z) {
        if (z) {
            this.zza.setVisibility(8);
            if (((Long) zzbe.zzc().zza(zzbcn.zzbj)).longValue() > 0) {
                this.zza.animate().cancel();
                this.zza.clearAnimation();
                return;
            }
            return;
        }
        this.zza.setVisibility(0);
    }
}
