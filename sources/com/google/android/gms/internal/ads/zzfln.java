package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfln {
    private final zzeiv zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzffg zzf;
    private final zzffh zzg;
    private final Clock zzh;
    private final zzavc zzi;

    public zzfln(zzeiv zzeiv, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzffg zzffg, zzffh zzffh, Clock clock, zzavc zzavc) {
        this.zza = zzeiv;
        this.zzb = versionInfoParcel.afmaVersion;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzffg;
        this.zzg = zzffh;
        this.zzh = clock;
        this.zzi = zzavc;
    }

    public static final List zzf(int i, int i2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_mpe@", "2." + i2));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    public static final List zzh(List list, long j) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_ttr@", Long.toString(j, 10)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static String zzi(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return zzl.zzk() ? "fakeForAdDebugLog" : str;
    }

    private static String zzj(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzfff zzfff, zzfet zzfet, List list) {
        return zzd(zzfff, zzfet, false, "", "", list);
    }

    public final List zzd(zzfff zzfff, zzfet zzfet, boolean z, String str, String str2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            String zzj = zzj(zzj(zzj((String) it.next(), "@gw_adlocid@", zzfff.zza.zza.zzf), "@gw_adnetrefresh@", true != z ? "0" : DiskLruCache.VERSION), "@gw_sdkver@", this.zzb);
            if (zzfet != null) {
                zzj = zzbyx.zzc(zzj(zzj(zzj(zzj, "@gw_qdata@", zzfet.zzy), "@gw_adnetid@", zzfet.zzx), "@gw_allocid@", zzfet.zzw), this.zze, zzfet.zzW, zzfet.zzaw);
            }
            String zzj2 = zzj(zzj(zzj(zzj(zzj, "@gw_adnetstatus@", this.zza.zzg()), "@gw_ttr@", Long.toString(this.zza.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z3 = false;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdD)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean z4 = !isEmpty;
            if (z3) {
                z2 = z4;
            } else if (isEmpty) {
                arrayList.add(zzj2);
            }
            if (this.zzi.zzf(Uri.parse(zzj2))) {
                Uri.Builder buildUpon = Uri.parse(zzj2).buildUpon();
                if (z3) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zzj2 = buildUpon.build().toString();
            }
            arrayList.add(zzj2);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065 A[LOOP:0: B:12:0x005f->B:14:0x0065, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zze(com.google.android.gms.internal.ads.zzfet r11, java.util.List r12, com.google.android.gms.internal.ads.zzbwj r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.common.util.Clock r1 = r10.zzh
            long r1 = r1.currentTimeMillis()
            java.lang.String r3 = r13.zzc()     // Catch:{ RemoteException -> 0x00b0 }
            int r13 = r13.zzb()     // Catch:{ RemoteException -> 0x00b0 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ RemoteException -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzdE
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzffh r4 = r10.zzg
            if (r4 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzfwo r4 = com.google.android.gms.internal.ads.zzfwo.zzc()
            goto L_0x003b
        L_0x0032:
            com.google.android.gms.internal.ads.zzffg r4 = r4.zza
            goto L_0x0037
        L_0x0035:
            com.google.android.gms.internal.ads.zzffg r4 = r10.zzf
        L_0x0037:
            com.google.android.gms.internal.ads.zzfwo r4 = com.google.android.gms.internal.ads.zzfwo.zzd(r4)
        L_0x003b:
            com.google.android.gms.internal.ads.zzfll r5 = new com.google.android.gms.internal.ads.zzfll
            r5.<init>()
            com.google.android.gms.internal.ads.zzfwo r5 = r4.zza(r5)
            java.lang.String r6 = ""
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzflm r7 = new com.google.android.gms.internal.ads.zzflm
            r7.<init>()
            com.google.android.gms.internal.ads.zzfwo r4 = r4.zza(r7)
            java.lang.Object r4 = r4.zzb(r6)
            java.lang.String r4 = (java.lang.String) r4
            java.util.Iterator r12 = r12.iterator()
        L_0x005f:
            boolean r6 = r12.hasNext()
            if (r6 == 0) goto L_0x00af
            java.lang.Object r6 = r12.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = android.net.Uri.encode(r5)
            java.lang.String r8 = "@gw_rwd_userid@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r4)
            java.lang.String r8 = "@gw_rwd_custom_data@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = java.lang.Long.toString(r1)
            java.lang.String r8 = "@gw_tmstmp@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r3)
            java.lang.String r8 = "@gw_rwd_itm@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = "@gw_rwd_amt@"
            java.lang.String r6 = zzj(r6, r7, r13)
            java.lang.String r7 = r10.zzb
            java.lang.String r8 = "@gw_sdkver@"
            java.lang.String r6 = zzj(r6, r8, r7)
            android.content.Context r7 = r10.zze
            boolean r8 = r11.zzW
            java.util.Map r9 = r11.zzaw
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbyx.zzc(r6, r7, r8, r9)
            r0.add(r6)
            goto L_0x005f
        L_0x00af:
            return r0
        L_0x00b0:
            r11 = move-exception
            java.lang.String r12 = "Unable to determine award type and amount."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r12, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfln.zze(com.google.android.gms.internal.ads.zzfet, java.util.List, com.google.android.gms.internal.ads.zzbwj):java.util.List");
    }
}
