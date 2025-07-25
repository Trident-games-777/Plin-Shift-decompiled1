package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbsb extends zzbsk {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final String zzc = zze("description");
    private final long zzd = zzd("start_ticks");
    private final long zze = zzd("end_ticks");
    private final String zzf = zze("summary");
    private final String zzg = zze(FirebaseAnalytics.Param.LOCATION);

    public zzbsb(zzcfk zzcfk, Map map) {
        super(zzcfk, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcfk.zzi();
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final String zze(String str) {
        return TextUtils.isEmpty((CharSequence) this.zza.get(str)) ? "" : (String) this.zza.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.zzb == null) {
            zzh("Activity context is not available.");
            return;
        }
        zzv.zzq();
        if (!new zzbbv(this.zzb).zzb()) {
            zzh("This feature is not available on the device.");
            return;
        }
        zzv.zzq();
        AlertDialog.Builder zzK = zzs.zzK(this.zzb);
        Resources zze2 = zzv.zzp().zze();
        if (zze2 != null) {
            str = zze2.getString(R.string.s5);
        } else {
            str = "Create calendar event";
        }
        zzK.setTitle(str);
        if (zze2 != null) {
            str2 = zze2.getString(R.string.s6);
        } else {
            str2 = "Allow Ad to create a calendar event?";
        }
        zzK.setMessage(str2);
        if (zze2 != null) {
            str3 = zze2.getString(R.string.s3);
        } else {
            str3 = HttpHeaders.ACCEPT;
        }
        zzK.setPositiveButton(str3, new zzbrz(this));
        if (zze2 != null) {
            str4 = zze2.getString(R.string.s4);
        } else {
            str4 = "Decline";
        }
        zzK.setNegativeButton(str4, new zzbsa(this));
        zzK.create().show();
    }
}
