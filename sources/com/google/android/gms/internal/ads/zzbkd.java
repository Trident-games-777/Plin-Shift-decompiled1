package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.browser.customtabs.CustomTabsClient;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbkd implements zzbjr {
    private final zzb zza;
    private final zzdsm zzb;
    private final zzr zzc;
    private final zzbse zzd;
    private final zzedp zze;
    private final zzcnb zzf;
    private zzaa zzg = null;
    private final zzges zzh = zzcaj.zzf;

    public zzbkd(zzb zzb2, zzbse zzbse, zzedp zzedp, zzdsm zzdsm, zzcnb zzcnb) {
        this.zza = zzb2;
        this.zzd = zzbse;
        this.zze = zzedp;
        this.zzb = zzdsm;
        this.zzc = new zzr((String) null);
        this.zzf = zzcnb;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzavc zzavc, Uri uri, View view, Activity activity, zzffs zzffs) {
        if (zzavc != null) {
            try {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlI)).booleanValue() || zzffs == null) {
                    if (zzavc.zze(uri)) {
                        return zzavc.zza(uri, context, view, activity);
                    }
                } else if (zzavc.zze(uri)) {
                    return zzffs.zza(uri, context, view, activity);
                }
            } catch (zzavd unused) {
            } catch (Exception e) {
                zzv.zzp().zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            }
        }
        return uri;
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            zzm.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return DiskLruCache.VERSION.equals(map.get("custom_close"));
    }

    /* access modifiers changed from: private */
    public final void zzh(String str, zza zza2, Map map, String str2) {
        String str3;
        boolean z;
        boolean z2;
        Object obj;
        Object obj2;
        Map map2 = map;
        String str4 = str2;
        zzcfk zzcfk = (zzcfk) zza2;
        zzfet zzD = zzcfk.zzD();
        zzfew zzR = zzcfk.zzR();
        boolean z3 = false;
        if (zzD == null || zzR == null) {
            str3 = "";
            z = false;
        } else {
            str3 = zzR.zzb;
            z = zzD.zzai;
        }
        boolean z4 = !((Boolean) zzbe.zzc().zza(zzbcn.zzkr)).booleanValue() || !map2.containsKey("sc") || !((String) map2.get("sc")).equals("0");
        boolean z5 = ((Boolean) zzbe.zzc().zza(zzbcn.zzmt)).booleanValue() && map2.containsKey("ig_cl") && ((String) map2.get("ig_cl")).equals("true");
        if ("expand".equalsIgnoreCase(str4)) {
            if (zzcfk.zzaF()) {
                zzm.zzj("Cannot expand WebView that is already expanded.");
                return;
            }
            zzk(false);
            ((zzcgu) zza2).zzaL(zzf(map2), zzb(map2), z4);
        } else if ("webapp".equalsIgnoreCase(str4)) {
            zzk(false);
            boolean z6 = ((Boolean) zzbe.zzc().zza(zzbcn.zzlD)).booleanValue() && Objects.equals(map2.get("is_allowed_for_lock_screen"), DiskLruCache.VERSION);
            if (str != null) {
                ((zzcgu) zza2).zzaN(zzf(map2), zzb(map2), str, z4, z6);
            } else {
                ((zzcgu) zza2).zzaM(zzf(map2), zzb(map2), (String) map2.get("html"), (String) map2.get("baseurl"), z4);
            }
        } else {
            Intent intent = null;
            if ("chrome_custom_tab".equalsIgnoreCase(str4)) {
                Context context = zzcfk.getContext();
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzeH)).booleanValue()) {
                    zze.zza("User opt out chrome custom tab.");
                    zzm(10);
                } else {
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzeF)).booleanValue()) {
                        int i = zzbdm.zza;
                        if (CustomTabsClient.getPackageName(context, (List<String>) null) != null) {
                            z3 = true;
                        }
                    } else {
                        z3 = zzbdo.zzg(context);
                    }
                    if (!z3) {
                        zzm(4);
                    } else {
                        zza zza3 = zza2;
                        zzk(true);
                        if (TextUtils.isEmpty(str)) {
                            zzm.zzj("Cannot open browser with null or empty url");
                            zzm(7);
                            return;
                        }
                        Uri zzd2 = zzd(zzc(zzcfk.getContext(), zzcfk.zzI(), Uri.parse(str), zzcfk.zzF(), zzcfk.zzi(), zzcfk.zzS()));
                        if (!z || this.zze == null || !zzl(zza3, zzcfk.getContext(), zzd2.toString(), str3)) {
                            this.zzg = new zzbka(this);
                            ((zzcgu) zza3).zzaJ(new zzc((String) null, zzd2.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z4, z5);
                            return;
                        }
                        return;
                    }
                }
                map2.put("use_first_package", "true");
                map2.put("use_running_process", "true");
                zzj(zza2, map2, z, str3, z4, z5);
            } else if (!"app".equalsIgnoreCase(str4) || !"true".equalsIgnoreCase((String) map2.get("system_browser"))) {
                zza zza4 = zza2;
                String str5 = str3;
                boolean z7 = z5;
                boolean z8 = z;
                if ("open_app".equalsIgnoreCase(str4)) {
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzhS)).booleanValue()) {
                        zzk(true);
                        String str6 = (String) map2.get("p");
                        if (str6 == null) {
                            zzm.zzj("Package name missing from open app action.");
                        } else if (!z8 || this.zze == null || !zzl(zza4, zzcfk.getContext(), str6, str5)) {
                            PackageManager packageManager = zzcfk.getContext().getPackageManager();
                            if (packageManager == null) {
                                zzm.zzj("Cannot get package manager from open app action.");
                                return;
                            }
                            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str6);
                            if (launchIntentForPackage != null) {
                                ((zzcgu) zza4).zzaJ(new zzc(launchIntentForPackage, this.zzg), z4, z7);
                            }
                        }
                    }
                } else {
                    zzk(true);
                    String str7 = (String) map2.get("intent_url");
                    if (!TextUtils.isEmpty(str7)) {
                        try {
                            intent = Intent.parseUri(str7, 0);
                        } catch (URISyntaxException e) {
                            zzm.zzh("Error parsing the url: ".concat(String.valueOf(str7)), e);
                        }
                    }
                    if (!(intent == null || intent.getData() == null)) {
                        Uri data = intent.getData();
                        if (!Uri.EMPTY.equals(data)) {
                            Uri zzd3 = zzd(zzc(zzcfk.getContext(), zzcfk.zzI(), data, zzcfk.zzF(), zzcfk.zzi(), zzcfk.zzS()));
                            if (!TextUtils.isEmpty(intent.getType())) {
                                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhT)).booleanValue()) {
                                    intent.setDataAndType(zzd3, intent.getType());
                                }
                            }
                            intent.setData(zzd3);
                        }
                    }
                    if (!((Boolean) zzbe.zzc().zza(zzbcn.zzil)).booleanValue() || !"intent_async".equalsIgnoreCase(str4) || !map2.containsKey("event_id")) {
                        obj = "event_id";
                        z2 = false;
                    } else {
                        obj = "event_id";
                        z2 = true;
                    }
                    HashMap hashMap = new HashMap();
                    if (z2) {
                        Map map3 = map2;
                        zza zza5 = zza4;
                        boolean z9 = z4;
                        obj2 = obj;
                        Map map4 = map3;
                        zzbkb zzbkb = new zzbkb(this, z9, zza5, hashMap, map4);
                        zza4 = zza5;
                        map2 = map4;
                        this.zzg = zzbkb;
                    } else {
                        boolean z10 = z4;
                        obj2 = obj;
                        z3 = z10;
                    }
                    if (intent == null) {
                        String uri = !TextUtils.isEmpty(str) ? zzd(zzc(zzcfk.getContext(), zzcfk.zzI(), Uri.parse(str), zzcfk.zzF(), zzcfk.zzi(), zzcfk.zzS())).toString() : str;
                        if (!z8 || this.zze == null || !zzl(zza4, zzcfk.getContext(), uri, str5)) {
                            ((zzcgu) zza4).zzaJ(new zzc((String) map2.get("i"), uri, (String) map2.get("m"), (String) map2.get("p"), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzg), z3, z7);
                        } else if (z2) {
                            hashMap.put((String) map2.get(obj2), true);
                            ((zzbmm) zza4).zzd("openIntentAsync", hashMap);
                        }
                    } else if (!z8 || this.zze == null || !zzl(zza4, zzcfk.getContext(), intent.getData().toString(), str5)) {
                        ((zzcgu) zza4).zzaJ(new zzc(intent, this.zzg), z3, z7);
                    } else if (z2) {
                        hashMap.put((String) map2.get(obj2), true);
                        ((zzbmm) zza4).zzd("openIntentAsync", hashMap);
                    }
                }
            } else {
                zzj(zza2, map2, z, str3, z4, z5);
            }
        }
    }

    private final void zzi(Context context, String str, String str2) {
        this.zze.zzc(str);
        zzdsm zzdsm = this.zzb;
        if (zzdsm != null) {
            zzeea.zzd(context, zzdsm, this.zze, str, "dialog_not_shown", zzfzr.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f6, code lost:
        if (com.google.android.gms.internal.ads.zzbkc.zzc(r12, r7, r8, r9, r10) == null) goto L_0x00f8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzj(com.google.android.gms.ads.internal.client.zza r20, java.util.Map r21, boolean r22, java.lang.String r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = 1
            r1.zzk(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzcfk r4 = (com.google.android.gms.internal.ads.zzcfk) r4
            android.content.Context r7 = r4.getContext()
            com.google.android.gms.internal.ads.zzavc r8 = r4.zzI()
            android.view.View r9 = r4.zzF()
            com.google.android.gms.internal.ads.zzffs r10 = r4.zzS()
            java.lang.String r5 = "activity"
            java.lang.Object r5 = r7.getSystemService(r5)
            r11 = r5
            android.app.ActivityManager r11 = (android.app.ActivityManager) r11
            java.lang.String r5 = "u"
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x0037
            r12 = 0
            goto L_0x0153
        L_0x0037:
            android.net.Uri r5 = android.net.Uri.parse(r5)
            r6 = r8
            r8 = r9
            r9 = 0
            r18 = r7
            r7 = r5
            r5 = r18
            android.net.Uri r7 = zzc(r5, r6, r7, r8, r9, r10)
            r9 = r8
            r8 = r6
            android.net.Uri r6 = zzd(r7)
            java.lang.String r7 = "use_first_package"
            java.lang.Object r7 = r2.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            boolean r13 = java.lang.Boolean.parseBoolean(r7)
            java.lang.String r7 = "use_running_process"
            java.lang.Object r7 = r2.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            boolean r14 = java.lang.Boolean.parseBoolean(r7)
            java.lang.String r7 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r7)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 != 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzeB
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r7.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r3 = 0
        L_0x0087:
            java.lang.String r2 = r6.getScheme()
            java.lang.String r7 = "http"
            boolean r2 = r7.equalsIgnoreCase(r2)
            java.lang.String r12 = "https"
            if (r2 == 0) goto L_0x00a2
            android.net.Uri$Builder r2 = r6.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r12)
            android.net.Uri r12 = r2.build()
            goto L_0x00ba
        L_0x00a2:
            java.lang.String r2 = r6.getScheme()
            boolean r2 = r12.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00b9
            android.net.Uri$Builder r2 = r6.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r7)
            android.net.Uri r12 = r2.build()
            goto L_0x00ba
        L_0x00b9:
            r12 = 0
        L_0x00ba:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.Intent r6 = com.google.android.gms.internal.ads.zzbkc.zza(r6, r5, r8, r9, r10)
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzbkc.zza(r12, r5, r8, r9, r10)
            if (r3 == 0) goto L_0x00d5
            com.google.android.gms.ads.internal.zzv.zzq()
            com.google.android.gms.ads.internal.util.zzs.zzo(r5, r6)
            com.google.android.gms.ads.internal.zzv.zzq()
            com.google.android.gms.ads.internal.util.zzs.zzo(r5, r12)
        L_0x00d5:
            r7 = r5
            r5 = r6
            r6 = r2
            android.content.pm.ResolveInfo r2 = com.google.android.gms.internal.ads.zzbkc.zzd(r5, r6, r7, r8, r9, r10)
            r3 = r6
            if (r2 == 0) goto L_0x00e6
            r6 = r2
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzbkc.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0153
        L_0x00e6:
            if (r12 == 0) goto L_0x00f8
            android.content.pm.ResolveInfo r6 = com.google.android.gms.internal.ads.zzbkc.zzc(r12, r7, r8, r9, r10)
            if (r6 == 0) goto L_0x00f8
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzbkc.zzb(r5, r6, r7, r8, r9, r10)
            android.content.pm.ResolveInfo r2 = com.google.android.gms.internal.ads.zzbkc.zzc(r12, r7, r8, r9, r10)
            if (r2 != 0) goto L_0x0153
        L_0x00f8:
            boolean r2 = r3.isEmpty()
            if (r2 == 0) goto L_0x00ff
            goto L_0x0152
        L_0x00ff:
            if (r14 == 0) goto L_0x0143
            if (r11 == 0) goto L_0x0143
            java.util.List r2 = r11.getRunningAppProcesses()
            if (r2 == 0) goto L_0x0143
            int r11 = r3.size()
            r12 = 0
        L_0x010e:
            if (r12 >= r11) goto L_0x0143
            java.lang.Object r6 = r3.get(r12)
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            java.util.Iterator r14 = r2.iterator()
        L_0x011a:
            boolean r16 = r14.hasNext()
            int r17 = r12 + 1
            if (r16 == 0) goto L_0x0140
            java.lang.Object r16 = r14.next()
            r15 = r16
            android.app.ActivityManager$RunningAppProcessInfo r15 = (android.app.ActivityManager.RunningAppProcessInfo) r15
            java.lang.String r15 = r15.processName
            r16 = r2
            android.content.pm.ActivityInfo r2 = r6.activityInfo
            java.lang.String r2 = r2.packageName
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x013d
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzbkc.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0153
        L_0x013d:
            r2 = r16
            goto L_0x011a
        L_0x0140:
            r12 = r17
            goto L_0x010e
        L_0x0143:
            if (r13 == 0) goto L_0x0152
            r2 = 0
            java.lang.Object r2 = r3.get(r2)
            r6 = r2
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzbkc.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0153
        L_0x0152:
            r12 = r5
        L_0x0153:
            if (r22 == 0) goto L_0x0171
            com.google.android.gms.internal.ads.zzedp r2 = r1.zze
            if (r2 == 0) goto L_0x0171
            if (r12 == 0) goto L_0x0171
            android.content.Context r2 = r4.getContext()
            android.net.Uri r3 = r12.getData()
            java.lang.String r3 = r3.toString()
            r4 = r23
            boolean r2 = r1.zzl(r0, r2, r3, r4)
            if (r2 != 0) goto L_0x0170
            goto L_0x0171
        L_0x0170:
            return
        L_0x0171:
            com.google.android.gms.internal.ads.zzcgu r0 = (com.google.android.gms.internal.ads.zzcgu) r0     // Catch:{ ActivityNotFoundException -> 0x0182 }
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x0182 }
            com.google.android.gms.ads.internal.overlay.zzaa r3 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x0182 }
            r2.<init>(r12, r3)     // Catch:{ ActivityNotFoundException -> 0x0182 }
            r3 = r24
            r4 = r25
            r0.zzaJ(r2, r3, r4)     // Catch:{ ActivityNotFoundException -> 0x0182 }
            return
        L_0x0182:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkd.zzj(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzk(boolean z) {
        zzbse zzbse = this.zzd;
        if (zzbse != null) {
            zzbse.zza(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c1, code lost:
        if (r4 != false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        r2 = r2.zzad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzdsm r0 = r8.zzb
            if (r0 == 0) goto L_0x000b
            com.google.android.gms.internal.ads.zzedp r1 = r8.zze
            java.lang.String r2 = "offline_open"
            com.google.android.gms.internal.ads.zzeea.zzc(r10, r0, r1, r12, r2)
        L_0x000b:
            com.google.android.gms.internal.ads.zzbzz r0 = com.google.android.gms.ads.internal.zzv.zzp()
            boolean r0 = r0.zzA(r10)
            r1 = 0
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzedp r9 = r8.zze
            com.google.android.gms.ads.internal.util.client.zzr r10 = r8.zzc
            r9.zzh(r10, r12)
            return r1
        L_0x001e:
            r0 = r9
            com.google.android.gms.internal.ads.zzcfk r0 = (com.google.android.gms.internal.ads.zzcfk) r0
            com.google.android.gms.internal.ads.zzfet r2 = r0.zzD()
            r3 = 1
            if (r2 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzbtm r2 = r2.zzad
            if (r2 == 0) goto L_0x003a
            boolean r4 = r2.zza
            if (r4 == 0) goto L_0x003a
            java.lang.String r4 = r2.zzb
            if (r4 == 0) goto L_0x003a
            boolean r2 = r2.zzc
            if (r2 == 0) goto L_0x003a
            r2 = r3
            goto L_0x003b
        L_0x003a:
            r2 = r1
        L_0x003b:
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzii
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x005b
            if (r2 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzdsm r9 = r8.zzb
            if (r9 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzedp r11 = r8.zze
            java.lang.String r0 = "onfs"
            com.google.android.gms.internal.ads.zzeea.zzc(r10, r9, r11, r12, r0)
        L_0x005a:
            return r1
        L_0x005b:
            com.google.android.gms.ads.internal.zzv.zzq()
            com.google.android.gms.ads.internal.util.zzbq r2 = com.google.android.gms.ads.internal.util.zzs.zzz(r10)
            com.google.android.gms.ads.internal.zzv.zzq()
            androidx.core.app.NotificationManagerCompat r4 = androidx.core.app.NotificationManagerCompat.from(r10)
            boolean r4 = r4.areNotificationsEnabled()
            java.lang.String r5 = "offline_notification_channel"
            com.google.android.gms.ads.internal.util.zzaa r6 = com.google.android.gms.ads.internal.zzv.zzr()
            boolean r5 = r6.zzi(r10, r5)
            com.google.android.gms.internal.ads.zzche r6 = r0.zzO()
            boolean r6 = r6.zzi()
            if (r6 == 0) goto L_0x0089
            android.app.Activity r6 = r0.zzi()
            if (r6 != 0) goto L_0x0089
            r6 = r3
            goto L_0x008a
        L_0x0089:
            r6 = r1
        L_0x008a:
            if (r4 != 0) goto L_0x00ca
            com.google.android.gms.ads.internal.zzv.zzq()
            androidx.core.app.NotificationManagerCompat r4 = androidx.core.app.NotificationManagerCompat.from(r10)
            boolean r4 = r4.areNotificationsEnabled()
            if (r4 == 0) goto L_0x009a
            goto L_0x00c4
        L_0x009a:
            int r4 = android.os.Build.VERSION.SDK_INT
            r7 = 33
            if (r4 >= r7) goto L_0x00b1
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzid
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r7.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            goto L_0x00c1
        L_0x00b1:
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzic
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r7.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
        L_0x00c1:
            if (r4 == 0) goto L_0x00c4
            goto L_0x00ca
        L_0x00c4:
            java.lang.String r9 = "notifications_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00ca:
            if (r5 == 0) goto L_0x00d2
            java.lang.String r9 = "notification_channel_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00d2:
            if (r2 != 0) goto L_0x00da
            java.lang.String r9 = "work_manager_unavailable"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00da:
            if (r6 == 0) goto L_0x00e2
            java.lang.String r9 = "ad_no_activity"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00e2:
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzia
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r4.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x00fa
            java.lang.String r9 = "notification_flow_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00fa:
            com.google.android.gms.ads.internal.overlay.zzm r2 = r0.zzL()
            if (r2 == 0) goto L_0x0130
            android.app.Activity r2 = r0.zzi()
            if (r2 == 0) goto L_0x0130
            com.google.android.gms.internal.ads.zzeeb r2 = com.google.android.gms.internal.ads.zzeec.zze()
            android.app.Activity r4 = r0.zzi()
            r2.zza(r4)
            r4 = 0
            r2.zzb(r4)
            r2.zzc(r12)
            r2.zzd(r11)
            com.google.android.gms.internal.ads.zzeec r11 = r2.zze()
            com.google.android.gms.ads.internal.overlay.zzm r0 = r0.zzL()     // Catch:{ Exception -> 0x0127 }
            r0.zzf(r11)     // Catch:{ Exception -> 0x0127 }
            goto L_0x0138
        L_0x0127:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            r8.zzi(r10, r12, r9)
            return r1
        L_0x0130:
            r10 = r9
            com.google.android.gms.internal.ads.zzcgu r10 = (com.google.android.gms.internal.ads.zzcgu) r10
            r0 = 14
            r10.zzaK(r12, r11, r0)
        L_0x0138:
            r9.onAdClicked()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkd.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void zzm(int i) {
        zzdsm zzdsm;
        String str;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeE)).booleanValue() && (zzdsm = this.zzb) != null) {
            zzdsl zza2 = zzdsm.zza();
            zza2.zzb("action", "cct_action");
            switch (i) {
                case 2:
                    str = "CONTEXT_NOT_AN_ACTIVITY";
                    break;
                case 3:
                    str = "CONTEXT_NULL";
                    break;
                case 4:
                    str = "CCT_NOT_SUPPORTED";
                    break;
                case 5:
                    str = "CCT_READY_TO_OPEN";
                    break;
                case 6:
                    str = "ACTIVITY_NOT_FOUND";
                    break;
                case 7:
                    str = "EMPTY_URL";
                    break;
                case 8:
                    str = "UNKNOWN";
                    break;
                case 9:
                    str = "WRONG_EXP_SETUP";
                    break;
                default:
                    str = "OPT_OUT";
                    break;
            }
            zza2.zzb("cct_open_status", str);
            zza2.zzf();
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        ListenableFuture listenableFuture;
        zza zza2 = (zza) obj;
        String str = (String) map.get("u");
        Map hashMap = new HashMap();
        zzcfk zzcfk = (zzcfk) zza2;
        if (zzcfk.zzD() != null) {
            hashMap = zzcfk.zzD().zzaw;
        }
        String zzc2 = zzbyx.zzc(str, zzcfk.getContext(), true, hashMap);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            zzm.zzj("Action missing from an open GMSG.");
            return;
        }
        zzb zzb2 = this.zza;
        if (zzb2 == null || zzb2.zzc()) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjI)).booleanValue() || this.zzf == null || !zzcnb.zzj(zzc2)) {
                listenableFuture = zzgei.zzh(zzc2);
            } else {
                listenableFuture = this.zzf.zzb(zzc2, zzbc.zze());
            }
            zzgei.zzr(listenableFuture, new zzbjz(this, map, zza2, str2), this.zzh);
            return;
        }
        zzb2.zzb(zzc2);
    }
}
