package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zza {
    public static final boolean zza(Context context, Intent intent, zzac zzac, zzaa zzaa, boolean z) {
        if (z) {
            return zzc(context, intent.getData(), zzac, zzaa);
        }
        try {
            String uri = intent.toURI();
            zze.zza("Launching an intent: " + uri);
            zzv.zzq();
            zzs.zzT(context, intent);
            if (zzac != null) {
                zzac.zzg();
            }
            if (zzaa != null) {
                zzaa.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzm.zzj(e.getMessage());
            if (zzaa != null) {
                zzaa.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, zzc zzc, zzac zzac, zzaa zzaa) {
        int i = 0;
        if (zzc == null) {
            zzm.zzj("No intent data for launcher overlay.");
            return false;
        }
        zzbcn.zza(context);
        Intent intent = zzc.zzh;
        if (intent != null) {
            return zza(context, intent, zzac, zzaa, zzc.zzj);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzc.zzb)) {
            zzm.zzj("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.zzc)) {
            String str = zzc.zzb;
            intent2.setDataAndType(Uri.parse(str), zzc.zzc);
        } else {
            intent2.setData(Uri.parse(zzc.zzb));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.zzd)) {
            intent2.setPackage(zzc.zzd);
        }
        if (!TextUtils.isEmpty(zzc.zze)) {
            String[] split = zzc.zze.split(RemoteSettings.FORWARD_SLASH_STRING, 2);
            if (split.length < 2) {
                zzm.zzj("Could not parse component name from open GMSG: ".concat(String.valueOf(zzc.zze)));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str2 = zzc.zzf;
        if (!TextUtils.isEmpty(str2)) {
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                zzm.zzj("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeC)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzeB)).booleanValue()) {
                zzv.zzq();
                zzs.zzo(context, intent2);
            }
        }
        return zza(context, intent2, zzac, zzaa, zzc.zzj);
    }

    private static final boolean zzc(Context context, Uri uri, zzac zzac, zzaa zzaa) {
        int i;
        try {
            i = zzv.zzq().zzm(context, uri);
            if (zzac != null) {
                zzac.zzg();
            }
        } catch (ActivityNotFoundException e) {
            zzm.zzj(e.getMessage());
            i = 6;
        }
        if (zzaa != null) {
            zzaa.zzb(i);
        }
        return i == 5;
    }
}
