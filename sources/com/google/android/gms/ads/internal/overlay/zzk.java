package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzk extends zzb {
    final /* synthetic */ zzm zza;

    /* synthetic */ zzk(zzm zzm, zzl zzl) {
        this.zza = zzm;
    }

    public final void zza() {
        BitmapDrawable bitmapDrawable;
        Bitmap zza2 = zzv.zzv().zza(Integer.valueOf(this.zza.zzc.zzo.zzf));
        if (zza2 != null) {
            zzv.zzq();
            zzm zzm = this.zza;
            zzl zzl = zzm.zzc.zzo;
            boolean z = zzl.zzd;
            float f = zzl.zze;
            Activity activity = zzm.zzb;
            if (!z || f <= 0.0f || f > 25.0f) {
                bitmapDrawable = new BitmapDrawable(activity.getResources(), zza2);
            } else {
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(zza2, zza2.getWidth(), zza2.getHeight(), false);
                    Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                    RenderScript create = RenderScript.create(activity);
                    ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                    Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                    create2.setRadius(f);
                    create2.setInput(createFromBitmap);
                    create2.forEach(createFromBitmap2);
                    createFromBitmap2.copyTo(createBitmap);
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), createBitmap);
                } catch (RuntimeException unused) {
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), zza2);
                }
            }
            zzs.zza.post(new zzj(this, bitmapDrawable));
        }
    }
}
