package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzdvg;
import com.google.android.gms.internal.ads.zzdvk;
import com.google.android.gms.internal.ads.zzges;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzat {
    private final Context zza;
    private final zzdvk zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzat(Context context) {
        this.zzg = 0;
        this.zzl = new zzag(this);
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        zzv.zzu().zzb();
        this.zzk = zzv.zzu().zza();
        this.zzb = zzv.zzt().zza();
    }

    private final void zzs(Context context) {
        ArrayList arrayList = new ArrayList();
        int zzu = zzu(arrayList, "None", true);
        int zzu2 = zzu(arrayList, "Shake", true);
        int zzu3 = zzu(arrayList, "Flick", true);
        int ordinal = this.zzb.zza().ordinal();
        int i = ordinal != 1 ? ordinal != 2 ? zzu : zzu3 : zzu2;
        zzv.zzq();
        AlertDialog.Builder zzK = zzs.zzK(context);
        AtomicInteger atomicInteger = new AtomicInteger(i);
        zzK.setTitle("Setup gesture");
        zzK.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new zzao(atomicInteger));
        zzK.setNegativeButton("Dismiss", new zzap(this));
        zzK.setPositiveButton("Save", new zzaq(this, atomicInteger, i, zzu2, zzu3));
        zzK.setOnCancelListener(new zzar(this));
        zzK.create().show();
    }

    private final boolean zzt(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzi.x - f) < ((float) this.zzh) && Math.abs(this.zzi.y - f2) < ((float) this.zzh) && Math.abs(this.zzj.x - f3) < ((float) this.zzh) && Math.abs(this.zzj.y - f4) < ((float) this.zzh);
    }

    private static final int zzu(List list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzd);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza() {
        zzs(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzs(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzges zzges) {
        if (!zzv.zzt().zzj(this.zza, this.zzd, this.zze)) {
            zzv.zzt().zzd(this.zza, this.zzd, this.zze);
            return;
        }
        zzges.execute(new zzam(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzges zzges) {
        if (!zzv.zzt().zzj(this.zza, this.zzd, this.zze)) {
            zzv.zzt().zzd(this.zza, this.zzd, this.zze);
            return;
        }
        zzges.execute(new zzal(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        zzv.zzt().zzc(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        zzv.zzt().zzc(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzg = 4;
        zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(AtomicInteger atomicInteger, int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (atomicInteger.get() != i) {
            if (atomicInteger.get() == i2) {
                this.zzb.zzm(zzdvg.SHAKE);
            } else if (atomicInteger.get() == i3) {
                this.zzb.zzm(zzdvg.FLICK);
            } else {
                this.zzb.zzm(zzdvg.NONE);
            }
        }
        zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i) {
        zzv.zzq();
        zzs.zzT(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, int i2, int i3, int i4, int i5, DialogInterface dialogInterface, int i6) {
        if (i6 == i) {
            if (!(this.zza instanceof Activity)) {
                zzm.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = this.zzc;
            String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                zzv.zzq();
                Map zzP = zzs.zzP(build);
                for (String str3 : zzP.keySet()) {
                    sb.append(str3);
                    sb.append(" = ");
                    sb.append((String) zzP.get(str3));
                    sb.append("\n\n");
                }
                String trim = sb.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            zzv.zzq();
            AlertDialog.Builder zzK = zzs.zzK(this.zza);
            zzK.setMessage(str2);
            zzK.setTitle("Ad Information");
            zzK.setPositiveButton("Share", new zzai(this, str2));
            zzK.setNegativeButton("Close", new zzaj());
            zzK.create().show();
        } else if (i6 == i2) {
            zzm.zze("Debug mode [Creative Preview] selected.");
            zzcaj.zza.execute(new zzah(this));
        } else if (i6 == i3) {
            zzm.zze("Debug mode [Troubleshooting] selected.");
            zzcaj.zza.execute(new zzaf(this));
        } else if (i6 == i4) {
            zzdvk zzdvk = this.zzb;
            zzges zzges = zzcaj.zze;
            zzges zzges2 = zzcaj.zza;
            if (zzdvk.zzq()) {
                zzges.execute(new zzas(this));
            } else {
                zzges2.execute(new zzae(this, zzges));
            }
        } else if (i6 == i5) {
            zzdvk zzdvk2 = this.zzb;
            zzges zzges3 = zzcaj.zze;
            zzges zzges4 = zzcaj.zza;
            if (zzdvk2.zzq()) {
                zzges3.execute(new zzad(this));
            } else {
                zzges4.execute(new zzak(this, zzges3));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        zzax zzt = zzv.zzt();
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zzm = zzt.zzm();
        Context context = this.zza;
        zzt.zzh(zzt.zzj(context, str, str2));
        if (zzt.zzm()) {
            if (!zzm && !TextUtils.isEmpty(str3)) {
                zzt.zze(context, str2, str3, str);
            }
            zzm.zze("Device is linked for debug signals.");
            zzt.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzt.zzd(context, str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl() {
        zzax zzt = zzv.zzt();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzt.zzk(context, str, str2)) {
            zzt.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(zzt.zza)) {
            zzm.zze("Creative is not pushed for this device.");
            zzt.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if (DiskLruCache.VERSION.equals(zzt.zza)) {
            zzm.zze("The app is not linked for creative preview.");
            zzt.zzd(context, str, str2);
        } else if ("0".equals(zzt.zza)) {
            zzm.zze("Device is linked for in app preview.");
            zzt.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzg;
        if (i != -1) {
            if (i == 0) {
                if (actionMasked == 5) {
                    this.zzg = 5;
                    this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                    this.zzk.postDelayed(this.zzl, ((Long) zzbe.zzc().zza(zzbcn.zzeI)).longValue());
                }
            } else if (i == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z = false;
                        for (int i2 = 0; i2 < historySize; i2++) {
                            z |= !zzt(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                        }
                        if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.zzg = -1;
                this.zzk.removeCallbacks(this.zzl);
            }
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            if (!(this.zza instanceof Activity)) {
                zzm.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(zzv.zzt().zzb())) {
                str = "Creative preview";
            }
            String str2 = "Troubleshooting (enabled)";
            if (true != zzv.zzt().zzm()) {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            int zzu = zzu(arrayList, "Ad information", true);
            int zzu2 = zzu(arrayList, str, true);
            int zzu3 = zzu(arrayList, str2, true);
            boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zziO)).booleanValue();
            int zzu4 = zzu(arrayList, "Open ad inspector", booleanValue);
            int zzu5 = zzu(arrayList, "Ad inspector settings", booleanValue);
            zzv.zzq();
            AlertDialog.Builder zzK = zzs.zzK(this.zza);
            zzK.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzan(this, zzu, zzu2, zzu3, zzu4, zzu5));
            zzK.create().show();
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public zzat(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
