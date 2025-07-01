package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.CollectionUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbse extends zzbsk {
    private String zza = "top-right";
    private boolean zzb = true;
    private int zzc = 0;
    private int zzd = 0;
    private int zze = -1;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = -1;
    private final Object zzi = new Object();
    private final zzcfk zzj;
    private final Activity zzk;
    private zzche zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbsl zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public zzbse(zzcfk zzcfk, zzbsl zzbsl) {
        super(zzcfk, "resize");
        this.zzj = zzcfk;
        this.zzk = zzcfk.zzi();
        this.zzo = zzbsl;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzm */
    public final void zzc(boolean z) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkx)).booleanValue()) {
            this.zzq.removeView((View) this.zzj);
            this.zzp.dismiss();
        } else {
            this.zzp.dismiss();
            this.zzq.removeView((View) this.zzj);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzky)).booleanValue()) {
            ViewParent parent = ((View) this.zzj).getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView((View) this.zzj);
            }
        }
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkz)).booleanValue()) {
                try {
                    this.zzr.addView((View) this.zzj);
                    this.zzj.zzaj(this.zzl);
                } catch (IllegalStateException e) {
                    zzm.zzh("Unable to add webview back to view hierarchy.", e);
                }
            } else {
                this.zzr.addView((View) this.zzj);
                this.zzj.zzaj(this.zzl);
            }
        }
        if (z) {
            zzl("default");
            zzbsl zzbsl = this.zzo;
            if (zzbsl != null) {
                zzbsl.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    public final void zza(boolean z) {
        synchronized (this.zzi) {
            if (this.zzp != null) {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzkw)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzc(z);
                } else {
                    zzcaj.zze.zza(new zzbsc(this, z));
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f9, code lost:
        r4 = r1.zzc + r1.zzf;
        r9 = r1.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0201, code lost:
        r9 = r9 + r1.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0202, code lost:
        if (r4 < 0) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0206, code lost:
        if ((r4 + 50) > r7) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x020a, code lost:
        if (r9 < r5[0]) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0210, code lost:
        if ((r9 + 50) <= r5[1]) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0213, code lost:
        r16 = new int[]{r1.zzc + r1.zzf, r1.zzd + r1.zzg};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x019a, code lost:
        r4 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x019b, code lost:
        if (r4 == 0) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x019d, code lost:
        if (r4 == 1) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019f, code lost:
        if (r4 == 2) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a1, code lost:
        if (r4 == 3) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a3, code lost:
        if (r4 == 4) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a5, code lost:
        if (r4 == 5) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        r4 = ((r1.zzc + r1.zzf) + r9) - 50;
        r9 = r1.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01b2, code lost:
        r4 = ((r1.zzc + r1.zzf) + r9) - 50;
        r9 = r1.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01bd, code lost:
        r4 = ((r1.zzc + r1.zzf) + (r9 >> 1)) - 25;
        r9 = r1.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01cb, code lost:
        r4 = r1.zzc + r1.zzf;
        r9 = r1.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01d3, code lost:
        r9 = ((r9 + r1.zzg) + r14) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01d8, code lost:
        r4 = ((r1.zzc + r1.zzf) + (r9 >> 1)) - 25;
        r9 = ((r1.zzd + r1.zzg) + (r14 >> 1)) - 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01eb, code lost:
        r4 = ((r1.zzc + r1.zzf) + (r9 >> 1)) - 25;
        r9 = r1.zzd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0274 A[Catch:{ RuntimeException -> 0x0446 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x027b A[Catch:{ RuntimeException -> 0x0446 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.util.Map r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "Cannot show popup window: "
            java.lang.Object r3 = r1.zzi
            monitor-enter(r3)
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x0014
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x0014:
            com.google.android.gms.internal.ads.zzcfk r4 = r1.zzj     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzche r4 = r4.zzO()     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x0023
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x0023:
            com.google.android.gms.internal.ads.zzcfk r4 = r1.zzj     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzche r4 = r4.zzO()     // Catch:{ all -> 0x0493 }
            boolean r4 = r4.zzi()     // Catch:{ all -> 0x0493 }
            if (r4 == 0) goto L_0x0036
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x0036:
            com.google.android.gms.internal.ads.zzcfk r4 = r1.zzj     // Catch:{ all -> 0x0493 }
            boolean r4 = r4.zzaF()     // Catch:{ all -> 0x0493 }
            if (r4 == 0) goto L_0x0045
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x0045:
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0493 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x0064
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0493 }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzO(r4)     // Catch:{ all -> 0x0493 }
            r1.zzh = r4     // Catch:{ all -> 0x0493 }
        L_0x0064:
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0493 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x0083
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0493 }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzO(r4)     // Catch:{ all -> 0x0493 }
            r1.zze = r4     // Catch:{ all -> 0x0493 }
        L_0x0083:
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0493 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x00a2
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0493 }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzO(r4)     // Catch:{ all -> 0x0493 }
            r1.zzf = r4     // Catch:{ all -> 0x0493 }
        L_0x00a2:
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0493 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x00c1
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0493 }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzO(r4)     // Catch:{ all -> 0x0493 }
            r1.zzg = r4     // Catch:{ all -> 0x0493 }
        L_0x00c1:
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0493 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x00dd
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0493 }
            boolean r4 = java.lang.Boolean.parseBoolean(r4)     // Catch:{ all -> 0x0493 }
            r1.zzb = r4     // Catch:{ all -> 0x0493 }
        L_0x00dd:
            java.lang.String r4 = "customClosePosition"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0493 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0493 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x00ed
            r1.zza = r0     // Catch:{ all -> 0x0493 }
        L_0x00ed:
            int r0 = r1.zzh     // Catch:{ all -> 0x0493 }
            if (r0 < 0) goto L_0x048c
            int r0 = r1.zze     // Catch:{ all -> 0x0493 }
            if (r0 < 0) goto L_0x048c
            android.app.Activity r0 = r1.zzk     // Catch:{ all -> 0x0493 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0493 }
            if (r0 == 0) goto L_0x0485
            android.view.View r4 = r0.getDecorView()     // Catch:{ all -> 0x0493 }
            if (r4 != 0) goto L_0x0105
            goto L_0x0485
        L_0x0105:
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0493 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzV(r4)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            android.app.Activity r5 = r1.zzk     // Catch:{ all -> 0x0493 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzs.zzR(r5)     // Catch:{ all -> 0x0493 }
            r6 = 0
            r7 = r4[r6]     // Catch:{ all -> 0x0493 }
            r8 = 1
            r4 = r4[r8]     // Catch:{ all -> 0x0493 }
            int r9 = r1.zzh     // Catch:{ all -> 0x0493 }
            r10 = 5
            r11 = 4
            r12 = 3
            r13 = 2
            r15 = 50
            r16 = 0
            if (r9 < r15) goto L_0x026b
            if (r9 <= r7) goto L_0x012d
            goto L_0x026b
        L_0x012d:
            int r14 = r1.zze     // Catch:{ all -> 0x0493 }
            if (r14 < r15) goto L_0x0263
            if (r14 <= r4) goto L_0x0135
            goto L_0x0263
        L_0x0135:
            if (r14 != r4) goto L_0x0142
            if (r9 != r7) goto L_0x0142
            java.lang.String r4 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0493 }
            r17 = r15
            goto L_0x0272
        L_0x0142:
            boolean r4 = r1.zzb     // Catch:{ all -> 0x0493 }
            if (r4 == 0) goto L_0x0222
            java.lang.String r4 = r1.zza     // Catch:{ all -> 0x0493 }
            int r17 = r4.hashCode()     // Catch:{ all -> 0x0493 }
            switch(r17) {
                case -1364013995: goto L_0x018e;
                case -1012429441: goto L_0x0182;
                case -655373719: goto L_0x0176;
                case 1163912186: goto L_0x016a;
                case 1288627767: goto L_0x015e;
                case 1755462605: goto L_0x0152;
                default: goto L_0x014f;
            }
        L_0x014f:
            r17 = r15
            goto L_0x019a
        L_0x0152:
            r17 = r15
            java.lang.String r15 = "top-center"
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x019a
            r4 = r8
            goto L_0x019b
        L_0x015e:
            r17 = r15
            java.lang.String r15 = "bottom-center"
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x019a
            r4 = r11
            goto L_0x019b
        L_0x016a:
            r17 = r15
            java.lang.String r15 = "bottom-right"
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x019a
            r4 = r10
            goto L_0x019b
        L_0x0176:
            r17 = r15
            java.lang.String r15 = "bottom-left"
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x019a
            r4 = r12
            goto L_0x019b
        L_0x0182:
            r17 = r15
            java.lang.String r15 = "top-left"
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x019a
            r4 = r6
            goto L_0x019b
        L_0x018e:
            r17 = r15
            java.lang.String r15 = "center"
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x019a
            r4 = r13
            goto L_0x019b
        L_0x019a:
            r4 = -1
        L_0x019b:
            if (r4 == 0) goto L_0x01f9
            if (r4 == r8) goto L_0x01eb
            if (r4 == r13) goto L_0x01d8
            if (r4 == r12) goto L_0x01cb
            if (r4 == r11) goto L_0x01bd
            if (r4 == r10) goto L_0x01b2
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r14 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r4 = r4 + r14
            int r4 = r4 + r9
            int r4 = r4 + -50
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
            goto L_0x01f6
        L_0x01b2:
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r15 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r4 = r4 + r15
            int r4 = r4 + r9
            int r4 = r4 + -50
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
            goto L_0x01c8
        L_0x01bd:
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r15 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r9 = r9 >> r8
            int r4 = r4 + r15
            int r4 = r4 + r9
            int r4 = r4 + -25
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
        L_0x01c8:
            int r15 = r1.zzg     // Catch:{ all -> 0x0493 }
            goto L_0x01d3
        L_0x01cb:
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r4 = r4 + r9
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
            goto L_0x01c8
        L_0x01d3:
            int r9 = r9 + r15
            int r9 = r9 + r14
            int r9 = r9 + -50
            goto L_0x0202
        L_0x01d8:
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r15 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r9 = r9 >> r8
            int r4 = r4 + r15
            int r4 = r4 + r9
            int r4 = r4 + -25
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
            int r15 = r1.zzg     // Catch:{ all -> 0x0493 }
            int r9 = r9 + r15
            int r14 = r14 >> r8
            int r9 = r9 + r14
            int r9 = r9 + -25
            goto L_0x0202
        L_0x01eb:
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r14 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r9 = r9 >> r8
            int r4 = r4 + r14
            int r4 = r4 + r9
            int r4 = r4 + -25
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
        L_0x01f6:
            int r14 = r1.zzg     // Catch:{ all -> 0x0493 }
            goto L_0x0201
        L_0x01f9:
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r4 = r4 + r9
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
            goto L_0x01f6
        L_0x0201:
            int r9 = r9 + r14
        L_0x0202:
            if (r4 < 0) goto L_0x0272
            int r4 = r4 + 50
            if (r4 > r7) goto L_0x0272
            r4 = r5[r6]     // Catch:{ all -> 0x0493 }
            if (r9 < r4) goto L_0x0272
            int r9 = r9 + 50
            r4 = r5[r8]     // Catch:{ all -> 0x0493 }
            if (r9 <= r4) goto L_0x0213
            goto L_0x0272
        L_0x0213:
            int r4 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r5 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r4 = r4 + r5
            int r5 = r1.zzd     // Catch:{ all -> 0x0493 }
            int r7 = r1.zzg     // Catch:{ all -> 0x0493 }
            int r5 = r5 + r7
            int[] r16 = new int[]{r4, r5}     // Catch:{ all -> 0x0493 }
            goto L_0x0272
        L_0x0222:
            r17 = r15
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0493 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzV(r4)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            android.app.Activity r5 = r1.zzk     // Catch:{ all -> 0x0493 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzs.zzR(r5)     // Catch:{ all -> 0x0493 }
            r4 = r4[r6]     // Catch:{ all -> 0x0493 }
            int r7 = r1.zzc     // Catch:{ all -> 0x0493 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0493 }
            int r7 = r7 + r9
            int r9 = r1.zzd     // Catch:{ all -> 0x0493 }
            int r14 = r1.zzg     // Catch:{ all -> 0x0493 }
            int r9 = r9 + r14
            if (r7 >= 0) goto L_0x0246
            r7 = r6
            goto L_0x024e
        L_0x0246:
            int r14 = r1.zzh     // Catch:{ all -> 0x0493 }
            int r15 = r7 + r14
            if (r15 <= r4) goto L_0x024e
            int r7 = r4 - r14
        L_0x024e:
            r4 = r5[r6]     // Catch:{ all -> 0x0493 }
            if (r9 >= r4) goto L_0x0254
            r9 = r4
            goto L_0x025e
        L_0x0254:
            int r4 = r1.zze     // Catch:{ all -> 0x0493 }
            int r14 = r9 + r4
            r5 = r5[r8]     // Catch:{ all -> 0x0493 }
            if (r14 <= r5) goto L_0x025e
            int r9 = r5 - r4
        L_0x025e:
            int[] r16 = new int[]{r7, r9}     // Catch:{ all -> 0x0493 }
            goto L_0x0272
        L_0x0263:
            r17 = r15
            java.lang.String r4 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0493 }
            goto L_0x0272
        L_0x026b:
            r17 = r15
            java.lang.String r4 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0493 }
        L_0x0272:
            if (r16 != 0) goto L_0x027b
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x027b:
            com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ all -> 0x0493 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0493 }
            int r5 = r1.zzh     // Catch:{ all -> 0x0493 }
            int r4 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r4, r5)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ all -> 0x0493 }
            android.app.Activity r5 = r1.zzk     // Catch:{ all -> 0x0493 }
            int r7 = r1.zze     // Catch:{ all -> 0x0493 }
            int r5 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r5, r7)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r7 = r1.zzj     // Catch:{ all -> 0x0493 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0493 }
            android.view.ViewParent r7 = r7.getParent()     // Catch:{ all -> 0x0493 }
            if (r7 == 0) goto L_0x047e
            boolean r9 = r7 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0493 }
            if (r9 == 0) goto L_0x047e
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r9 = r1.zzj     // Catch:{ all -> 0x0493 }
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x0493 }
            r7.removeView(r9)     // Catch:{ all -> 0x0493 }
            android.widget.PopupWindow r9 = r1.zzp     // Catch:{ all -> 0x0493 }
            if (r9 != 0) goto L_0x02e5
            r1.zzr = r7     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r7 = r1.zzj     // Catch:{ all -> 0x0493 }
            r9 = r7
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x0493 }
            r9.setDrawingCacheEnabled(r8)     // Catch:{ all -> 0x0493 }
            r9 = r7
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x0493 }
            android.graphics.Bitmap r9 = r9.getDrawingCache()     // Catch:{ all -> 0x0493 }
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r9)     // Catch:{ all -> 0x0493 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0493 }
            r7.setDrawingCacheEnabled(r6)     // Catch:{ all -> 0x0493 }
            android.widget.ImageView r7 = new android.widget.ImageView     // Catch:{ all -> 0x0493 }
            android.app.Activity r14 = r1.zzk     // Catch:{ all -> 0x0493 }
            r7.<init>(r14)     // Catch:{ all -> 0x0493 }
            r1.zzm = r7     // Catch:{ all -> 0x0493 }
            r7.setImageBitmap(r9)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r7 = r1.zzj     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzche r7 = r7.zzO()     // Catch:{ all -> 0x0493 }
            r1.zzl = r7     // Catch:{ all -> 0x0493 }
            android.view.ViewGroup r7 = r1.zzr     // Catch:{ all -> 0x0493 }
            android.widget.ImageView r9 = r1.zzm     // Catch:{ all -> 0x0493 }
            r7.addView(r9)     // Catch:{ all -> 0x0493 }
            goto L_0x02e8
        L_0x02e5:
            r9.dismiss()     // Catch:{ all -> 0x0493 }
        L_0x02e8:
            android.widget.RelativeLayout r7 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0493 }
            android.app.Activity r9 = r1.zzk     // Catch:{ all -> 0x0493 }
            r7.<init>(r9)     // Catch:{ all -> 0x0493 }
            r1.zzq = r7     // Catch:{ all -> 0x0493 }
            r7.setBackgroundColor(r6)     // Catch:{ all -> 0x0493 }
            android.widget.RelativeLayout r7 = r1.zzq     // Catch:{ all -> 0x0493 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0493 }
            r9.<init>(r4, r5)     // Catch:{ all -> 0x0493 }
            r7.setLayoutParams(r9)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            android.widget.RelativeLayout r7 = r1.zzq     // Catch:{ all -> 0x0493 }
            android.widget.PopupWindow r9 = new android.widget.PopupWindow     // Catch:{ all -> 0x0493 }
            r9.<init>(r7, r4, r5, r6)     // Catch:{ all -> 0x0493 }
            r1.zzp = r9     // Catch:{ all -> 0x0493 }
            r9.setOutsideTouchable(r6)     // Catch:{ all -> 0x0493 }
            android.widget.PopupWindow r7 = r1.zzp     // Catch:{ all -> 0x0493 }
            r7.setTouchable(r8)     // Catch:{ all -> 0x0493 }
            android.widget.PopupWindow r7 = r1.zzp     // Catch:{ all -> 0x0493 }
            boolean r9 = r1.zzb     // Catch:{ all -> 0x0493 }
            r9 = r9 ^ r8
            r7.setClippingEnabled(r9)     // Catch:{ all -> 0x0493 }
            android.widget.RelativeLayout r7 = r1.zzq     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r9 = r1.zzj     // Catch:{ all -> 0x0493 }
            android.view.View r9 = (android.view.View) r9     // Catch:{ all -> 0x0493 }
            r14 = -1
            r7.addView(r9, r14, r14)     // Catch:{ all -> 0x0493 }
            android.widget.LinearLayout r7 = new android.widget.LinearLayout     // Catch:{ all -> 0x0493 }
            android.app.Activity r9 = r1.zzk     // Catch:{ all -> 0x0493 }
            r7.<init>(r9)     // Catch:{ all -> 0x0493 }
            r1.zzn = r7     // Catch:{ all -> 0x0493 }
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ all -> 0x0493 }
            android.app.Activity r9 = r1.zzk     // Catch:{ all -> 0x0493 }
            r15 = r17
            int r9 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r9, r15)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ all -> 0x0493 }
            android.app.Activity r14 = r1.zzk     // Catch:{ all -> 0x0493 }
            int r14 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r14, r15)     // Catch:{ all -> 0x0493 }
            r7.<init>(r9, r14)     // Catch:{ all -> 0x0493 }
            java.lang.String r9 = r1.zza     // Catch:{ all -> 0x0493 }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x0493 }
            switch(r14) {
                case -1364013995: goto L_0x0382;
                case -1012429441: goto L_0x0378;
                case -655373719: goto L_0x036e;
                case 1163912186: goto L_0x0364;
                case 1288627767: goto L_0x035a;
                case 1755462605: goto L_0x0350;
                default: goto L_0x034f;
            }
        L_0x034f:
            goto L_0x038c
        L_0x0350:
            java.lang.String r14 = "top-center"
            boolean r9 = r9.equals(r14)
            if (r9 == 0) goto L_0x038c
            r14 = r8
            goto L_0x038d
        L_0x035a:
            java.lang.String r14 = "bottom-center"
            boolean r9 = r9.equals(r14)
            if (r9 == 0) goto L_0x038c
            r14 = r11
            goto L_0x038d
        L_0x0364:
            java.lang.String r14 = "bottom-right"
            boolean r9 = r9.equals(r14)
            if (r9 == 0) goto L_0x038c
            r14 = r10
            goto L_0x038d
        L_0x036e:
            java.lang.String r14 = "bottom-left"
            boolean r9 = r9.equals(r14)
            if (r9 == 0) goto L_0x038c
            r14 = r12
            goto L_0x038d
        L_0x0378:
            java.lang.String r14 = "top-left"
            boolean r9 = r9.equals(r14)
            if (r9 == 0) goto L_0x038c
            r14 = r6
            goto L_0x038d
        L_0x0382:
            java.lang.String r14 = "center"
            boolean r9 = r9.equals(r14)
            if (r9 == 0) goto L_0x038c
            r14 = r13
            goto L_0x038d
        L_0x038c:
            r14 = -1
        L_0x038d:
            r9 = 9
            r15 = 10
            if (r14 == 0) goto L_0x03ce
            r19 = r6
            r6 = 14
            if (r14 == r8) goto L_0x03c7
            if (r14 == r13) goto L_0x03c1
            r13 = 12
            if (r14 == r12) goto L_0x03ba
            if (r14 == r11) goto L_0x03b3
            r6 = 11
            if (r14 == r10) goto L_0x03ac
            r7.addRule(r15)     // Catch:{ all -> 0x0493 }
            r7.addRule(r6)     // Catch:{ all -> 0x0493 }
            goto L_0x03d6
        L_0x03ac:
            r7.addRule(r13)     // Catch:{ all -> 0x0493 }
            r7.addRule(r6)     // Catch:{ all -> 0x0493 }
            goto L_0x03d6
        L_0x03b3:
            r7.addRule(r13)     // Catch:{ all -> 0x0493 }
            r7.addRule(r6)     // Catch:{ all -> 0x0493 }
            goto L_0x03d6
        L_0x03ba:
            r7.addRule(r13)     // Catch:{ all -> 0x0493 }
            r7.addRule(r9)     // Catch:{ all -> 0x0493 }
            goto L_0x03d6
        L_0x03c1:
            r6 = 13
            r7.addRule(r6)     // Catch:{ all -> 0x0493 }
            goto L_0x03d6
        L_0x03c7:
            r7.addRule(r15)     // Catch:{ all -> 0x0493 }
            r7.addRule(r6)     // Catch:{ all -> 0x0493 }
            goto L_0x03d6
        L_0x03ce:
            r19 = r6
            r7.addRule(r15)     // Catch:{ all -> 0x0493 }
            r7.addRule(r9)     // Catch:{ all -> 0x0493 }
        L_0x03d6:
            android.widget.LinearLayout r6 = r1.zzn     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzbsd r9 = new com.google.android.gms.internal.ads.zzbsd     // Catch:{ all -> 0x0493 }
            r9.<init>(r1)     // Catch:{ all -> 0x0493 }
            r6.setOnClickListener(r9)     // Catch:{ all -> 0x0493 }
            android.widget.LinearLayout r6 = r1.zzn     // Catch:{ all -> 0x0493 }
            java.lang.String r9 = "Close button"
            r6.setContentDescription(r9)     // Catch:{ all -> 0x0493 }
            android.widget.RelativeLayout r6 = r1.zzq     // Catch:{ all -> 0x0493 }
            android.widget.LinearLayout r9 = r1.zzn     // Catch:{ all -> 0x0493 }
            r6.addView(r9, r7)     // Catch:{ all -> 0x0493 }
            android.widget.PopupWindow r6 = r1.zzp     // Catch:{ RuntimeException -> 0x0446 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0446 }
            com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ RuntimeException -> 0x0446 }
            android.app.Activity r7 = r1.zzk     // Catch:{ RuntimeException -> 0x0446 }
            r9 = r16[r19]     // Catch:{ RuntimeException -> 0x0446 }
            int r7 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r7, r9)     // Catch:{ RuntimeException -> 0x0446 }
            com.google.android.gms.ads.internal.client.zzbc.zzb()     // Catch:{ RuntimeException -> 0x0446 }
            android.app.Activity r9 = r1.zzk     // Catch:{ RuntimeException -> 0x0446 }
            r10 = r16[r8]     // Catch:{ RuntimeException -> 0x0446 }
            int r9 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r9, r10)     // Catch:{ RuntimeException -> 0x0446 }
            r10 = r19
            r6.showAtLocation(r0, r10, r7, r9)     // Catch:{ RuntimeException -> 0x0446 }
            r0 = r16[r10]     // Catch:{ all -> 0x0493 }
            r2 = r16[r8]     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzbsl r6 = r1.zzo     // Catch:{ all -> 0x0493 }
            if (r6 == 0) goto L_0x041e
            int r7 = r1.zzh     // Catch:{ all -> 0x0493 }
            int r9 = r1.zze     // Catch:{ all -> 0x0493 }
            r6.zza(r0, r2, r7, r9)     // Catch:{ all -> 0x0493 }
        L_0x041e:
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzj     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzche r2 = com.google.android.gms.internal.ads.zzche.zzb(r4, r5)     // Catch:{ all -> 0x0493 }
            r0.zzaj(r2)     // Catch:{ all -> 0x0493 }
            r10 = 0
            r0 = r16[r10]     // Catch:{ all -> 0x0493 }
            r2 = r16[r8]     // Catch:{ all -> 0x0493 }
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0493 }
            android.app.Activity r4 = r1.zzk     // Catch:{ all -> 0x0493 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzR(r4)     // Catch:{ all -> 0x0493 }
            r4 = r4[r10]     // Catch:{ all -> 0x0493 }
            int r2 = r2 - r4
            int r4 = r1.zzh     // Catch:{ all -> 0x0493 }
            int r5 = r1.zze     // Catch:{ all -> 0x0493 }
            r1.zzk(r0, r2, r4, r5)     // Catch:{ all -> 0x0493 }
            java.lang.String r0 = "resized"
            r1.zzl(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x0446:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0493 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0493 }
            r4.<init>(r2)     // Catch:{ all -> 0x0493 }
            r4.append(r0)     // Catch:{ all -> 0x0493 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0493 }
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            android.widget.RelativeLayout r0 = r1.zzq     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r2 = r1.zzj     // Catch:{ all -> 0x0493 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0493 }
            r0.removeView(r2)     // Catch:{ all -> 0x0493 }
            android.view.ViewGroup r0 = r1.zzr     // Catch:{ all -> 0x0493 }
            if (r0 == 0) goto L_0x047c
            android.widget.ImageView r2 = r1.zzm     // Catch:{ all -> 0x0493 }
            r0.removeView(r2)     // Catch:{ all -> 0x0493 }
            android.view.ViewGroup r0 = r1.zzr     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r2 = r1.zzj     // Catch:{ all -> 0x0493 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0493 }
            r0.addView(r2)     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzj     // Catch:{ all -> 0x0493 }
            com.google.android.gms.internal.ads.zzche r2 = r1.zzl     // Catch:{ all -> 0x0493 }
            r0.zzaj(r2)     // Catch:{ all -> 0x0493 }
        L_0x047c:
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x047e:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x0485:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x048c:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x0493 }
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            return
        L_0x0493:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0493 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbse.zzb(java.util.Map):void");
    }

    public final void zzd(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzi) {
            z = this.zzp != null;
        }
        return z;
    }
}
