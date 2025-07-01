package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzop {
    public static final zzop zza = new zzop(zzfzo.zzo(zzon.zza));
    static final zzfzr zzb;
    private static final zzfzo zzc = zzfzo.zzq(2, 5, 6);
    private final SparseArray zzd;
    private final int zze;

    static {
        zzfzq zzfzq = new zzfzq();
        zzfzq.zza(5, 6);
        zzfzq.zza(17, 6);
        zzfzq.zza(7, 6);
        zzfzq.zza(30, 10);
        zzfzq.zza(18, 6);
        zzfzq.zza(6, 8);
        zzfzq.zza(8, 8);
        zzfzq.zza(14, 8);
        zzb = zzfzq.zzc();
    }

    private zzop(List list) {
        this.zzd = new SparseArray();
        for (int i = 0; i < list.size(); i++) {
            zzon zzon = (zzon) list.get(i);
            this.zzd.put(zzon.zzb, zzon);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzd.size(); i3++) {
            i2 = Math.max(i2, ((zzon) this.zzd.valueAt(i3)).zzc);
        }
        this.zze = i2;
    }

    static Uri zza() {
        if (zzf()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    static zzop zzc(Context context, zzg zzg, zzow zzow) {
        return zzd(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzg, zzow);
    }

    static zzop zzd(Context context, Intent intent, zzg zzg, zzow zzow) {
        Object systemService = context.getSystemService("audio");
        systemService.getClass();
        AudioManager audioManager = (AudioManager) systemService;
        if (zzow == null) {
            zzow = zzen.zza >= 33 ? zzom.zzb(audioManager, zzg) : null;
        }
        if (zzen.zza >= 33 && (zzen.zzM(context) || zzen.zzI(context))) {
            return zzom.zza(audioManager, zzg);
        }
        if (zzen.zza >= 23 && zzok.zza(audioManager, zzow)) {
            return zza;
        }
        zzfzs zzfzs = new zzfzs();
        zzfzs.zzf(2);
        if (zzen.zza < 29 || (!zzen.zzM(context) && !zzen.zzI(context))) {
            ContentResolver contentResolver = context.getContentResolver();
            boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
            if ((z || zzf()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
                zzfzs.zzh(zzc);
            }
            if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
                return new zzop(zze(zzgcr.zzh(zzfzs.zzi()), 10));
            }
            int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
            if (intArrayExtra != null) {
                zzfzs.zzh(zzgcr.zzg(intArrayExtra));
            }
            return new zzop(zze(zzgcr.zzh(zzfzs.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
        }
        zzfzs.zzh(zzol.zzb(zzg));
        return new zzop(zze(zzgcr.zzh(zzfzs.zzi()), 10));
    }

    private static zzfzo zze(int[] iArr, int i) {
        zzfzl zzfzl = new zzfzl();
        for (int zzon : iArr) {
            zzfzl.zzf(new zzon(zzon, i));
        }
        return zzfzl.zzi();
    }

    private static boolean zzf() {
        return "Amazon".equals(zzen.zzc) || "Xiaomi".equals(zzen.zzc);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r1.contentEquals(r3) != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r9 instanceof com.google.android.gms.internal.ads.zzop
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.android.gms.internal.ads.zzop r9 = (com.google.android.gms.internal.ads.zzop) r9
            android.util.SparseArray r1 = r8.zzd
            android.util.SparseArray r3 = r9.zzd
            int r4 = com.google.android.gms.internal.ads.zzen.zza
            r5 = 31
            if (r4 < r5) goto L_0x001d
            boolean r1 = r1.contentEquals(r3)
            if (r1 == 0) goto L_0x0046
            goto L_0x003f
        L_0x001d:
            int r4 = r1.size()
            int r5 = r3.size()
            if (r4 != r5) goto L_0x0046
            r5 = r2
        L_0x0028:
            if (r5 >= r4) goto L_0x003f
            int r6 = r1.keyAt(r5)
            java.lang.Object r7 = r1.valueAt(r5)
            java.lang.Object r6 = r3.get(r6)
            boolean r6 = java.util.Objects.equals(r7, r6)
            if (r6 == 0) goto L_0x0046
            int r5 = r5 + 1
            goto L_0x0028
        L_0x003f:
            int r1 = r8.zze
            int r9 = r9.zze
            if (r1 != r9) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        int i2 = zzen.zza;
        SparseArray sparseArray = this.zzd;
        if (i2 >= 31) {
            i = sparseArray.contentHashCode();
        } else {
            int i3 = 17;
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                i3 = (((i3 * 31) + sparseArray.keyAt(i4)) * 31) + Objects.hashCode(sparseArray.valueAt(i4));
            }
            i = i3;
        }
        return this.zze + (i * 31);
    }

    public final String toString() {
        String obj = this.zzd.toString();
        return "AudioCapabilities[maxChannelCount=" + this.zze + ", audioProfiles=" + obj + "]";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (com.google.android.gms.internal.ads.zzen.zzG(r8.zzd, 30) == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a0, code lost:
        if (r6 != 5) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zzb(com.google.android.gms.internal.ads.zzad r9, com.google.android.gms.internal.ads.zzg r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.zzo
            r0.getClass()
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r9.zzk
            int r0 = com.google.android.gms.internal.ads.zzbg.zza(r0, r1)
            com.google.android.gms.internal.ads.zzfzr r1 = zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x001c
            goto L_0x00cb
        L_0x001c:
            r1 = 7
            r2 = 6
            r3 = 8
            r4 = 18
            if (r0 != r4) goto L_0x002f
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzen.zzG(r0, r4)
            if (r0 != 0) goto L_0x002e
            r0 = r2
            goto L_0x004a
        L_0x002e:
            r0 = r4
        L_0x002f:
            if (r0 != r3) goto L_0x003d
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzen.zzG(r0, r3)
            if (r0 == 0) goto L_0x003b
            r0 = r3
            goto L_0x003d
        L_0x003b:
            r0 = r1
            goto L_0x004a
        L_0x003d:
            r5 = 30
            if (r0 != r5) goto L_0x004a
            android.util.SparseArray r6 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzen.zzG(r6, r5)
            if (r5 != 0) goto L_0x004a
            goto L_0x003b
        L_0x004a:
            android.util.SparseArray r5 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzen.zzG(r5, r0)
            if (r5 == 0) goto L_0x00cb
            android.util.SparseArray r5 = r8.zzd
            java.lang.Object r5 = r5.get(r0)
            com.google.android.gms.internal.ads.zzon r5 = (com.google.android.gms.internal.ads.zzon) r5
            r5.getClass()
            r6 = r5
            com.google.android.gms.internal.ads.zzon r6 = (com.google.android.gms.internal.ads.zzon) r6
            int r6 = r9.zzC
            r7 = -1
            if (r6 == r7) goto L_0x0084
            if (r0 != r4) goto L_0x0068
            goto L_0x0084
        L_0x0068:
            java.lang.String r9 = r9.zzo
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x007d
            int r9 = com.google.android.gms.internal.ads.zzen.zza
            r10 = 33
            if (r9 >= r10) goto L_0x007d
            r9 = 10
            if (r6 <= r9) goto L_0x008f
            goto L_0x00cb
        L_0x007d:
            boolean r9 = r5.zzb(r6)
            if (r9 != 0) goto L_0x008f
            goto L_0x00cb
        L_0x0084:
            int r9 = r9.zzD
            if (r9 != r7) goto L_0x008b
            r9 = 48000(0xbb80, float:6.7262E-41)
        L_0x008b:
            int r6 = r5.zza(r9, r10)
        L_0x008f:
            int r9 = com.google.android.gms.internal.ads.zzen.zza
            r10 = 28
            if (r9 > r10) goto L_0x00a3
            if (r6 != r1) goto L_0x0099
            r2 = r3
            goto L_0x00a4
        L_0x0099:
            r9 = 3
            if (r6 == r9) goto L_0x00a4
            r9 = 4
            if (r6 == r9) goto L_0x00a4
            r9 = 5
            if (r6 != r9) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r2 = r6
        L_0x00a4:
            int r9 = com.google.android.gms.internal.ads.zzen.zza
            r10 = 26
            if (r9 > r10) goto L_0x00b8
            java.lang.String r9 = "fugu"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x00b8
            r9 = 1
            if (r2 != r9) goto L_0x00b8
            r2 = 2
        L_0x00b8:
            int r9 = com.google.android.gms.internal.ads.zzen.zzi(r2)
            if (r9 == 0) goto L_0x00cb
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r9 = android.util.Pair.create(r10, r9)
            return r9
        L_0x00cb:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.zzb(com.google.android.gms.internal.ads.zzad, com.google.android.gms.internal.ads.zzg):android.util.Pair");
    }
}
