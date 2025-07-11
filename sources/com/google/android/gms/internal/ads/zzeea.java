package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationManagerCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.NotificationHandlerActivity;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeea extends zzbsy {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdsm zzc;
    private final zzr zzd;
    private final zzedp zze;
    private String zzf;
    private String zzg;

    public zzeea(Context context, zzedp zzedp, zzr zzr, zzdsm zzdsm) {
        this.zzb = context;
        this.zzc = zzdsm;
        this.zzd = zzr;
        this.zze = zzedp;
    }

    public static void zzc(Context context, zzdsm zzdsm, zzedp zzedp, String str, String str2) {
        zzd(context, zzdsm, zzedp, str, str2, new HashMap());
    }

    public static void zzd(Context context, zzdsm zzdsm, zzedp zzedp, String str, String str2, Map map) {
        String str3;
        String str4 = true != zzv.zzp().zzA(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY;
        if (zzdsm != null) {
            zzdsl zza2 = zzdsm.zza();
            zza2.zzb("gqi", str);
            zza2.zzb("action", str2);
            zza2.zzb("device_connectivity", str4);
            zza2.zzb("event_timestamp", String.valueOf(zzv.zzC().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zza2.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            str3 = zza2.zze();
        } else {
            str3 = "";
        }
        zzedp.zzd(new zzedr(zzv.zzC().currentTimeMillis(), str, str3, 2));
    }

    public static final PendingIntent zzr(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, AdService.CLASS_NAME);
            return zzftr.zzb(context, 0, intent, zzftr.zza | 1073741824, 0);
        }
        intent.setClassName(context, NotificationHandlerActivity.CLASS_NAME);
        return zzftr.zza(context, 0, intent, 201326592);
    }

    private static XmlResourceParser zzs(int i) {
        Resources zze2 = zzv.zzp().zze();
        if (zze2 == null) {
            return null;
        }
        try {
            return zze2.getLayout(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private final String zzt() {
        zzedh zzedh = (zzedh) this.zza.get(this.zzf);
        return zzedh == null ? "" : zzedh.zzb();
    }

    private static String zzu(int i, String str) {
        Resources zze2 = zzv.zzp().zze();
        if (zze2 != null) {
            try {
                return zze2.getString(i);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return str;
    }

    private final void zzv(String str, String str2, Map map) {
        zzd(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzw() {
        /*
            r6 = this;
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ RemoteException -> 0x0040 }
            android.content.Context r0 = r6.zzb     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.ads.internal.util.zzbq r0 = com.google.android.gms.ads.internal.util.zzs.zzz(r0)     // Catch:{ RemoteException -> 0x0040 }
            android.content.Context r1 = r6.zzb     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.ads.internal.offline.buffering.zza r2 = new com.google.android.gms.ads.internal.offline.buffering.zza     // Catch:{ RemoteException -> 0x0040 }
            java.lang.String r3 = r6.zzg     // Catch:{ RemoteException -> 0x0040 }
            java.lang.String r4 = r6.zzf     // Catch:{ RemoteException -> 0x0040 }
            java.util.Map r5 = r6.zza     // Catch:{ RemoteException -> 0x0040 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.internal.ads.zzedh r5 = (com.google.android.gms.internal.ads.zzedh) r5     // Catch:{ RemoteException -> 0x0040 }
            if (r5 != 0) goto L_0x0022
            java.lang.String r5 = ""
            goto L_0x0026
        L_0x0022:
            java.lang.String r5 = r5.zzc()     // Catch:{ RemoteException -> 0x0040 }
        L_0x0026:
            r2.<init>(r3, r4, r5)     // Catch:{ RemoteException -> 0x0040 }
            boolean r1 = r0.zzg(r1, r2)     // Catch:{ RemoteException -> 0x0040 }
            if (r1 != 0) goto L_0x0047
            android.content.Context r2 = r6.zzb     // Catch:{ RemoteException -> 0x003e }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r3 = r6.zzg     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r4 = r6.zzf     // Catch:{ RemoteException -> 0x003e }
            boolean r1 = r0.zzf(r2, r3, r4)     // Catch:{ RemoteException -> 0x003e }
            goto L_0x0047
        L_0x003e:
            r0 = move-exception
            goto L_0x0042
        L_0x0040:
            r0 = move-exception
            r1 = 0
        L_0x0042:
            java.lang.String r2 = "Failed to schedule offline notification poster."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
        L_0x0047:
            if (r1 != 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzedp r0 = r6.zze
            java.lang.String r1 = r6.zzf
            r0.zzc(r1)
            java.lang.String r0 = r6.zzf
            java.lang.String r1 = "offline_notification_worker_not_scheduled"
            com.google.android.gms.internal.ads.zzfzr r2 = com.google.android.gms.internal.ads.zzfzr.zzd()
            r6.zzv(r0, r1, r2)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeea.zzw():void");
    }

    private final void zzx(Activity activity, zzm zzm) {
        zzv.zzq();
        if (NotificationManagerCompat.from(activity).areNotificationsEnabled()) {
            zzw();
            zzy(activity, zzm);
        } else if (Build.VERSION.SDK_INT < 33) {
            zzv.zzq();
            AlertDialog.Builder zzK = zzs.zzK(activity);
            zzK.setTitle(zzu(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzu(R.string.notifications_permission_confirm, HttpHeaders.ALLOW), new zzedt(this, activity, zzm)).setNegativeButton(zzu(R.string.notifications_permission_decline, "Don't allow"), new zzedu(this, zzm)).setOnCancelListener(new zzedv(this, zzm));
            zzK.create().show();
            zzv(this.zzf, "rtsdi", zzfzr.zzd());
        } else {
            activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
            zzv(this.zzf, "asnpdi", zzfzr.zzd());
        }
    }

    private final void zzy(Activity activity, zzm zzm) {
        AlertDialog alertDialog;
        zzv.zzq();
        AlertDialog.Builder onCancelListener = zzs.zzK(activity).setOnCancelListener(new zzeds(zzm));
        XmlResourceParser zzs = zzs(R.layout.offline_ads_dialog);
        if (zzs == null) {
            onCancelListener.setMessage(zzu(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            alertDialog = onCancelListener.create();
        } else {
            Drawable drawable = null;
            View inflate = activity.getLayoutInflater().inflate(zzs, (ViewGroup) null);
            onCancelListener.setView(inflate);
            String zzt = zzt();
            if (!zzt.isEmpty()) {
                TextView textView = (TextView) inflate.findViewById(R.id.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(zzt);
            }
            zzedh zzedh = (zzedh) this.zza.get(this.zzf);
            if (zzedh != null) {
                drawable = zzedh.zza();
            }
            if (drawable != null) {
                ((ImageView) inflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(drawable);
            }
            alertDialog = onCancelListener.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
        Timer timer = new Timer();
        timer.schedule(new zzedz(this, alertDialog, timer, zzm), 3000);
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zzA = zzv.zzp().zzA(this.zzb);
            HashMap hashMap = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzA) {
                    c = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith(ProxyConfig.MATCH_HTTP)));
                try {
                    Intent launchIntentForPackage = this.zzb.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zzb.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzv(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                if (c == 1) {
                    this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                } else {
                    zzedp.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to get writable offline buffering database: ".concat(e.toString()));
            }
        }
    }

    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        int i = 0;
        while (i < strArr.length) {
            if (!strArr[i].equals("android.permission.POST_NOTIFICATIONS")) {
                i++;
            } else {
                zzeec zzeec = (zzeec) ObjectWrapper.unwrap(iObjectWrapper);
                Activity zza2 = zzeec.zza();
                zzm zzb2 = zzeec.zzb();
                HashMap hashMap = new HashMap();
                if (iArr[i] == 0) {
                    hashMap.put("dialog_action", "confirm");
                    zzw();
                    zzy(zza2, zzb2);
                } else {
                    hashMap.put("dialog_action", "dismiss");
                    if (zzb2 != null) {
                        zzb2.zzb();
                    }
                }
                zzv(this.zzf, "asnpdc", hashMap);
                return;
            }
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzeec zzeec = (zzeec) ObjectWrapper.unwrap(iObjectWrapper);
        Activity zza2 = zzeec.zza();
        zzm zzb2 = zzeec.zzb();
        this.zzf = zzeec.zzc();
        this.zzg = zzeec.zzd();
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzie)).booleanValue()) {
            zzv(this.zzf, "dialog_impression", zzfzr.zzd());
            zzv.zzq();
            AlertDialog.Builder zzK = zzs.zzK(zza2);
            zzK.setTitle(zzu(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzu(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzu(R.string.offline_opt_in_confirm, "OK"), new zzedw(this, zza2, zzb2)).setNegativeButton(zzu(R.string.offline_opt_in_decline, "No thanks"), new zzedx(this, zzb2)).setOnCancelListener(new zzedy(this, zzb2));
            zzK.create().show();
            return;
        }
        zzx(zza2, zzb2);
    }

    public final void zzh() {
        this.zze.zze(new zzedi(this.zzd));
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new zza(str, str2, ""));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a9 A[SYNTHETIC, Splitter:B:13:0x00a9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(com.google.android.gms.dynamic.IObjectWrapper r8, com.google.android.gms.ads.internal.offline.buffering.zza r9) {
        /*
            r7 = this;
            java.lang.Object r8 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r8)
            android.content.Context r8 = (android.content.Context) r8
            java.lang.String r0 = r9.zza
            java.lang.String r1 = r9.zzb
            java.lang.String r9 = r9.zzc
            java.lang.String r2 = r7.zzt()
            com.google.android.gms.ads.internal.util.zzaa r3 = com.google.android.gms.ads.internal.zzv.zzr()
            java.lang.String r4 = "offline_notification_channel"
            java.lang.String r5 = "AdMob Offline Notifications"
            r3.zzh(r8, r4, r5)
            java.lang.String r3 = "offline_notification_clicked"
            android.app.PendingIntent r3 = zzr(r8, r3, r1, r0)
            java.lang.String r5 = "offline_notification_dismissed"
            android.app.PendingIntent r0 = zzr(r8, r5, r1, r0)
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            r5.<init>((android.content.Context) r8, (java.lang.String) r4)
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0046
            int r4 = com.google.android.gms.ads.impl.R.string.offline_notification_title_with_advertiser
            java.lang.String r6 = "You are back online! Continue learning about %s"
            java.lang.String r4 = zzu(r4, r6)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r2 = java.lang.String.format(r4, r2)
            r5.setContentTitle(r2)
            goto L_0x0051
        L_0x0046:
            int r2 = com.google.android.gms.ads.impl.R.string.offline_notification_title
            java.lang.String r4 = "You are back online! Let's pick up where we left off"
            java.lang.String r2 = zzu(r2, r4)
            r5.setContentTitle(r2)
        L_0x0051:
            r2 = 1
            androidx.core.app.NotificationCompat$Builder r2 = r5.setAutoCancel(r2)
            androidx.core.app.NotificationCompat$Builder r0 = r2.setDeleteIntent(r0)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setContentIntent(r3)
            android.content.pm.ApplicationInfo r2 = r8.getApplicationInfo()
            int r2 = r2.icon
            androidx.core.app.NotificationCompat$Builder r0 = r0.setSmallIcon((int) r2)
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzif
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.setPriority(r2)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzih
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 0
            if (r0 == 0) goto L_0x00a6
            boolean r0 = r9.isEmpty()
            if (r0 != 0) goto L_0x00a6
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x00a6 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x00a6 }
            java.net.URLConnection r9 = r0.openConnection()     // Catch:{ IOException -> 0x00a6 }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ IOException -> 0x00a6 }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r9)     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00a7
        L_0x00a6:
            r9 = r2
        L_0x00a7:
            if (r9 == 0) goto L_0x00c0
            androidx.core.app.NotificationCompat$Builder r0 = r5.setLargeIcon((android.graphics.Bitmap) r9)     // Catch:{ NotFoundException -> 0x00c0 }
            androidx.core.app.NotificationCompat$BigPictureStyle r3 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch:{ NotFoundException -> 0x00c0 }
            r3.<init>()     // Catch:{ NotFoundException -> 0x00c0 }
            androidx.core.app.NotificationCompat$BigPictureStyle r9 = r3.bigPicture((android.graphics.Bitmap) r9)     // Catch:{ NotFoundException -> 0x00c0 }
            r3 = r2
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ NotFoundException -> 0x00c0 }
            androidx.core.app.NotificationCompat$BigPictureStyle r9 = r9.bigLargeIcon((android.graphics.Bitmap) r2)     // Catch:{ NotFoundException -> 0x00c0 }
            r0.setStyle(r9)     // Catch:{ NotFoundException -> 0x00c0 }
        L_0x00c0:
            java.lang.String r9 = "notification"
            java.lang.Object r8 = r8.getSystemService(r9)
            android.app.NotificationManager r8 = (android.app.NotificationManager) r8
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            android.app.Notification r0 = r5.build()     // Catch:{ IllegalArgumentException -> 0x00da }
            r2 = 54321(0xd431, float:7.612E-41)
            r8.notify(r1, r2, r0)     // Catch:{ IllegalArgumentException -> 0x00da }
            java.lang.String r8 = "offline_notification_impression"
            goto L_0x00e6
        L_0x00da:
            r8 = move-exception
            java.lang.String r0 = "notification_not_shown_reason"
            java.lang.String r8 = r8.getMessage()
            r9.put(r0, r8)
            java.lang.String r8 = "offline_notification_failed"
        L_0x00e6:
            r7.zzv(r1, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeea.zzj(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Activity activity, zzm zzm, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzv(this.zzf, "rtsdc", hashMap);
        activity.startActivity(zzv.zzr().zzf(activity));
        zzw();
        if (zzm != null) {
            zzm.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzm zzm, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzv(this.zzf, "rtsdc", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzm zzm, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzv(this.zzf, "rtsdc", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(Activity activity, zzm zzm, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzv(this.zzf, "dialog_click", hashMap);
        zzx(activity, zzm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzm zzm, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzv(this.zzf, "dialog_click", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzm zzm, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzv(this.zzf, "dialog_click", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final void zzq(String str, zzdiy zzdiy) {
        String str2;
        String str3 = "";
        if (!TextUtils.isEmpty(zzdiy.zzx())) {
            str2 = zzdiy.zzx();
        } else {
            str2 = zzdiy.zzB() != null ? zzdiy.zzB() : str3;
        }
        zzbfy zzm = zzdiy.zzm();
        if (zzm != null) {
            try {
                str3 = zzm.zze().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbfy zzn = zzdiy.zzn();
        Drawable drawable = null;
        if (zzn != null) {
            try {
                IObjectWrapper zzf2 = zzn.zzf();
                if (zzf2 != null) {
                    drawable = (Drawable) ObjectWrapper.unwrap(zzf2);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzedd(str2, str3, drawable));
    }
}
