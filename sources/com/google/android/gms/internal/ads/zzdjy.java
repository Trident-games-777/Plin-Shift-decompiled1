package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdjy {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final zzg zzb;
    private final zzffo zzc;
    private final zzdjd zzd;
    private final zzdiy zze;
    private final zzdkk zzf;
    private final zzdks zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbfn zzj;
    private final zzdiv zzk;

    public zzdjy(zzg zzg2, zzffo zzffo, zzdjd zzdjd, zzdiy zzdiy, zzdkk zzdkk, zzdks zzdks, Executor executor, Executor executor2, zzdiv zzdiv) {
        this.zzb = zzg2;
        this.zzc = zzffo;
        this.zzj = zzffo.zzi;
        this.zzd = zzdjd;
        this.zze = zzdiy;
        this.zzf = zzdkk;
        this.zzg = zzdks;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdiv;
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        View zzf2 = z ? this.zze.zzf() : this.zze.zzg();
        if (zzf2 == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzf2.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzf2.getParent()).removeView(zzf2);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdU)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzf2, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        zzdiy zzdiy = this.zze;
        if (zzdiy.zzf() != null) {
            boolean z = viewGroup != null;
            if (zzdiy.zzc() == 2 || zzdiy.zzc() == 1) {
                this.zzb.zzF(this.zzc.zzf, String.valueOf(zzdiy.zzc()), z);
            } else if (zzdiy.zzc() == 6) {
                this.zzb.zzF(this.zzc.zzf, ExifInterface.GPS_MEASUREMENT_2D, z);
                this.zzb.zzF(this.zzc.zzf, DiskLruCache.VERSION, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzdku r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzdjd r0 = r9.zzd
            boolean r0 = r0.zzf()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0016
            com.google.android.gms.internal.ads.zzdjd r0 = r9.zzd
            boolean r0 = r0.zze()
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r6 = r3
            goto L_0x0036
        L_0x0016:
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r5 = "1098"
            r4[r1] = r5
            java.lang.String r5 = "3011"
            r4[r2] = r5
            r5 = r1
        L_0x0022:
            if (r5 >= r0) goto L_0x0014
            r6 = r4[r5]
            android.view.View r6 = r10.zzg(r6)
            if (r6 == 0) goto L_0x0033
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x0033
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            goto L_0x0036
        L_0x0033:
            int r5 = r5 + 1
            goto L_0x0022
        L_0x0036:
            android.view.View r0 = r10.zzf()
            android.content.Context r0 = r0.getContext()
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r4.<init>(r5, r5)
            com.google.android.gms.internal.ads.zzdiy r5 = r9.zze
            android.view.View r7 = r5.zze()
            if (r7 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzbfn r0 = r9.zzj
            android.view.View r5 = r5.zze()
            if (r0 != 0) goto L_0x0055
            goto L_0x0090
        L_0x0055:
            if (r6 != 0) goto L_0x0090
            int r0 = r0.zze
            zzh(r4, r0)
            r5.setLayoutParams(r4)
            r6 = r3
            goto L_0x0090
        L_0x0061:
            com.google.android.gms.internal.ads.zzbfr r7 = r5.zzl()
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzbfi
            if (r7 != 0) goto L_0x006b
            r5 = r3
            goto L_0x0090
        L_0x006b:
            com.google.android.gms.internal.ads.zzbfr r5 = r5.zzl()
            com.google.android.gms.internal.ads.zzbfi r5 = (com.google.android.gms.internal.ads.zzbfi) r5
            if (r6 != 0) goto L_0x007b
            int r6 = r5.zzc()
            zzh(r4, r6)
            r6 = r3
        L_0x007b:
            com.google.android.gms.internal.ads.zzbfj r7 = new com.google.android.gms.internal.ads.zzbfj
            r7.<init>(r0, r5, r4)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzdS
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r4.zza(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setContentDescription(r0)
            r5 = r7
        L_0x0090:
            r0 = -1
            if (r5 != 0) goto L_0x0094
            goto L_0x00d6
        L_0x0094:
            android.view.ViewParent r4 = r5.getParent()
            boolean r4 = r4 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x00a5
            android.view.ViewParent r4 = r5.getParent()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r4.removeView(r5)
        L_0x00a5:
            if (r6 == 0) goto L_0x00ae
            r6.removeAllViews()
            r6.addView(r5)
            goto L_0x00cf
        L_0x00ae:
            com.google.android.gms.ads.formats.zza r4 = new com.google.android.gms.ads.formats.zza
            android.view.View r6 = r10.zzf()
            android.content.Context r6 = r6.getContext()
            r4.<init>(r6)
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r6.<init>(r0, r0)
            r4.setLayoutParams(r6)
            r4.addView(r5)
            android.widget.FrameLayout r6 = r10.zzh()
            if (r6 == 0) goto L_0x00cf
            r6.addView(r4)
        L_0x00cf:
            java.lang.String r4 = r10.zzk()
            r10.zzq(r4, r5, r2)
        L_0x00d6:
            com.google.android.gms.internal.ads.zzfzo r4 = com.google.android.gms.internal.ads.zzdju.zza
            int r5 = r4.size()
            r6 = r1
        L_0x00dd:
            if (r6 >= r5) goto L_0x00f2
            java.lang.Object r7 = r4.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            android.view.View r7 = r10.zzg(r7)
            boolean r8 = r7 instanceof android.view.ViewGroup
            int r6 = r6 + 1
            if (r8 == 0) goto L_0x00dd
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            goto L_0x00f3
        L_0x00f2:
            r7 = r3
        L_0x00f3:
            java.util.concurrent.Executor r4 = r9.zzi
            com.google.android.gms.internal.ads.zzdjv r5 = new com.google.android.gms.internal.ads.zzdjv
            r5.<init>(r9, r7)
            r4.execute(r5)
            if (r7 != 0) goto L_0x0101
            goto L_0x01af
        L_0x0101:
            boolean r2 = r9.zzi(r7, r2)
            if (r2 == 0) goto L_0x011c
            com.google.android.gms.internal.ads.zzdiy r0 = r9.zze
            com.google.android.gms.internal.ads.zzcfk r1 = r0.zzs()
            if (r1 == 0) goto L_0x01af
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzs()
            com.google.android.gms.internal.ads.zzdjx r1 = new com.google.android.gms.internal.ads.zzdjx
            r1.<init>(r10, r7)
            r0.zzar(r1)
            return
        L_0x011c:
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzjH
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r4.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0149
            boolean r1 = r9.zzi(r7, r1)
            if (r1 == 0) goto L_0x0149
            com.google.android.gms.internal.ads.zzdiy r0 = r9.zze
            com.google.android.gms.internal.ads.zzcfk r1 = r0.zzq()
            if (r1 == 0) goto L_0x01af
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzq()
            com.google.android.gms.internal.ads.zzdjx r1 = new com.google.android.gms.internal.ads.zzdjx
            r1.<init>(r10, r7)
            r0.zzar(r1)
            return
        L_0x0149:
            r7.removeAllViews()
            android.view.View r1 = r10.zzf()
            if (r1 == 0) goto L_0x0156
            android.content.Context r3 = r1.getContext()
        L_0x0156:
            if (r3 == 0) goto L_0x01af
            com.google.android.gms.internal.ads.zzdiv r1 = r9.zzk
            com.google.android.gms.internal.ads.zzbfv r1 = r1.zza()
            if (r1 == 0) goto L_0x01af
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzi()     // Catch:{ RemoteException -> 0x01aa }
            if (r1 == 0) goto L_0x01af
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r1)
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            if (r1 == 0) goto L_0x01af
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r3)
            r2.setImageDrawable(r1)
            com.google.android.gms.dynamic.IObjectWrapper r10 = r10.zzj()
            if (r10 == 0) goto L_0x0199
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzgb
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x018f
            goto L_0x0199
        L_0x018f:
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)
            android.widget.ImageView$ScaleType r10 = (android.widget.ImageView.ScaleType) r10
            r2.setScaleType(r10)
            goto L_0x019e
        L_0x0199:
            android.widget.ImageView$ScaleType r10 = zza
            r2.setScaleType(r10)
        L_0x019e:
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r10.<init>(r0, r0)
            r2.setLayoutParams(r10)
            r7.addView(r2)
            return
        L_0x01aa:
            java.lang.String r10 = "Could not get main image drawable"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdjy.zzb(com.google.android.gms.internal.ads.zzdku):void");
    }

    public final void zzc(zzdku zzdku) {
        if (zzdku != null && this.zzf != null && zzdku.zzh() != null && this.zzd.zzg()) {
            try {
                zzdku.zzh().addView(this.zzf.zza());
            } catch (zzcfw e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(zzdku zzdku) {
        if (zzdku != null) {
            Context context = zzdku.zzf().getContext();
            if (!zzbu.zzh(context, this.zzd.zza)) {
                return;
            }
            if (!(context instanceof Activity)) {
                zzm.zze("Activity context is needed for policy validator.");
            } else if (this.zzg != null && zzdku.zzh() != null) {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    windowManager.addView(this.zzg.zza(zzdku.zzh(), windowManager), zzbu.zzb());
                } catch (zzcfw e) {
                    zze.zzb("web view can not be obtained", e);
                }
            }
        }
    }

    public final void zze(zzdku zzdku) {
        this.zzh.execute(new zzdjw(this, zzdku));
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
