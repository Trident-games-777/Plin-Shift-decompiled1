package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcbt extends FrameLayout implements zzcbk {
    final zzcch zza;
    private final zzccf zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbdc zze;
    private final long zzf;
    private final zzcbl zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcbt(Context context, zzccf zzccf, int i, boolean z, zzbdc zzbdc, zzcce zzcce) {
        super(context);
        zzbdc zzbdc2;
        zzcbl zzcbl;
        String str;
        zzcbl zzcbl2;
        zzbdc zzbdc3 = zzbdc;
        this.zzb = zzccf;
        this.zze = zzbdc3;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzccf.zzj());
        zzcbm zzcbm = zzccf.zzj().zza;
        zzccg zzccg = new zzccg(context, zzccf.zzn(), zzccf.zzdi(), zzbdc3, zzccf.zzk());
        if (i == 3) {
            zzcbl = new zzcez(context, zzccg);
            zzbdc2 = zzbdc;
        } else {
            if (i == 2) {
                zzcbl2 = new zzccx(context, zzccg, zzccf, z, zzcbx.zza(zzccf), zzcce);
                zzbdc2 = zzbdc;
            } else {
                Context context2 = context;
                zzbdc zzbdc4 = zzbdc;
                boolean zza2 = zzcbx.zza(zzccf);
                zzbdc2 = zzbdc4;
                boolean z2 = zza2;
                zzcbl2 = new zzcbj(context2, zzccf, z, z2, zzcce, new zzccg(context2, zzccf.zzn(), zzccf.zzdi(), zzbdc4, zzccf.zzk()));
            }
            zzcbl = zzcbl2;
        }
        this.zzg = zzcbl;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcbl, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzP)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzM)).booleanValue()) {
            zzn();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) zzbe.zzc().zza(zzbcn.zzR)).longValue();
        boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzO)).booleanValue();
        this.zzk = booleanValue;
        if (zzbdc2 != null) {
            if (true != booleanValue) {
                str = "0";
            } else {
                str = DiskLruCache.VERSION;
            }
            zzbdc.zzd("spinner_used", str);
        }
        this.zza = new zzcch(this);
        zzcbl.zzr(this);
    }

    private final void zzJ() {
        if (this.zzb.zzi() != null && this.zzi && !this.zzj) {
            this.zzb.zzi().getWindow().clearFlags(128);
            this.zzi = false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        Integer zzl2 = zzl();
        if (zzl2 != null) {
            hashMap.put("playerId", zzl2.toString());
        }
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", hashMap);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            zzcbl zzcbl = this.zzg;
            if (zzcbl != null) {
                zzges zzges = zzcaj.zze;
                Objects.requireNonNull(zzcbl);
                zzges.execute(new zzcbn(zzcbl));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        zzs.zza.post(new zzcbp(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        zzs.zza.post(new zzcbs(this, z));
    }

    public final void zzA(int i) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzz(i);
        }
    }

    public final void zzB(int i) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzA(i);
        }
    }

    public final void zzC(int i) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzP)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzD(int i) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzB(i);
        }
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i, int i2, int i3, int i4) {
        if (zze.zzc()) {
            zze.zza("Set video bounds to x:" + i + ";y:" + i2 + ";w:" + i3 + ";h:" + i4);
        }
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzc.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzG(float f) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzb.zze(f);
            zzcbl.zzn();
        }
    }

    public final void zzH(float f, float f2) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzu(f, f2);
        }
    }

    public final void zzI() {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzb.zzd(false);
            zzcbl.zzn();
        }
    }

    public final void zza() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbY)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    public final void zzb(String str, String str2) {
        zzK(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "what", str, "extra", str2);
    }

    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    public final void zze() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbY)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            boolean z = (this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    public final void zzf() {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null && this.zzm == 0) {
            zzcbl zzcbl2 = this.zzg;
            zzK("canplaythrough", "duration", String.valueOf(((float) zzcbl.zzc()) / 1000.0f), "videoWidth", String.valueOf(zzcbl2.zze()), "videoHeight", String.valueOf(zzcbl2.zzd()));
        }
    }

    public final void zzg() {
        this.zzd.setVisibility(4);
        zzs.zza.post(new zzcbo(this));
    }

    public final void zzh() {
        this.zza.zzb();
        zzs.zza.post(new zzcbq(this));
    }

    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        zzs.zza.post(new zzcbr(this));
    }

    public final void zzj(int i, int i2) {
        if (this.zzk) {
            int max = Math.max(i / ((Integer) zzbe.zzc().zza(zzbcn.zzQ)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzbe.zzc().zza(zzbcn.zzQ)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap == null || bitmap.getWidth() != max || this.zzp.getHeight() != max2) {
                this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzr = false;
            }
        }
    }

    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg != null && this.zzp != null) {
            long elapsedRealtime = zzv.zzC().elapsedRealtime();
            if (this.zzg.getBitmap(this.zzp) != null) {
                this.zzr = true;
            }
            long elapsedRealtime2 = zzv.zzC().elapsedRealtime() - elapsedRealtime;
            if (zze.zzc()) {
                zze.zza("Spinner frame grab took " + elapsedRealtime2 + "ms");
            }
            if (elapsedRealtime2 > this.zzf) {
                zzm.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzk = false;
                this.zzp = null;
                zzbdc zzbdc = this.zze;
                if (zzbdc != null) {
                    zzbdc.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final Integer zzl() {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            return zzcbl.zzw();
        }
        return null;
    }

    public final void zzn() {
        String str;
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            TextView textView = new TextView(zzcbl.getContext());
            Resources zze2 = zzv.zzp().zze();
            if (zze2 == null) {
                str = "AdMob - ";
            } else {
                str = zze2.getString(R.string.watermark_label_prefix);
            }
            textView.setText(String.valueOf(str).concat(this.zzg.zzj()));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzc.bringChildToFront(textView);
        }
    }

    public final void zzo() {
        this.zza.zza();
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzt();
        }
        zzJ();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(boolean z) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzr(Integer num) {
        if (this.zzg != null) {
            if (!TextUtils.isEmpty(this.zzn)) {
                this.zzg.zzC(this.zzn, this.zzo, num);
            } else {
                zzK("no_src", new String[0]);
            }
        }
    }

    public final void zzs() {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzb.zzd(true);
            zzcbl.zzn();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt() {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            long zza2 = (long) zzcbl.zza();
            if (this.zzl != zza2 && zza2 > 0) {
                float f = ((float) zza2) / 1000.0f;
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzbW)).booleanValue()) {
                    zzK("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(zzv.zzC().currentTimeMillis()));
                } else {
                    zzK("timeupdate", "time", String.valueOf(f));
                }
                this.zzl = zza2;
            }
        }
    }

    public final void zzu() {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzo();
        }
    }

    public final void zzv() {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzp();
        }
    }

    public final void zzw(int i) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzq(i);
        }
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzy(int i) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzx(i);
        }
    }

    public final void zzz(int i) {
        zzcbl zzcbl = this.zzg;
        if (zzcbl != null) {
            zzcbl.zzy(i);
        }
    }
}
