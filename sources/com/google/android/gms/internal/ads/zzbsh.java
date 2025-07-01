package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.net.HttpHeaders;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbsh extends zzbsk {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;

    public zzbsh(zzcfk zzcfk, Map map) {
        super(zzcfk, "storePicture");
        this.zza = map;
        this.zzb = zzcfk.zzi();
    }

    public final void zzb() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.zzb == null) {
            zzh("Activity context is not available");
            return;
        }
        zzv.zzq();
        if (!new zzbbv(this.zzb).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str5 = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str5)) {
            zzh("Image url cannot be empty.");
        } else if (URLUtil.isValidUrl(str5)) {
            String lastPathSegment = Uri.parse(str5).getLastPathSegment();
            zzv.zzq();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                Resources zze = zzv.zzp().zze();
                zzv.zzq();
                AlertDialog.Builder zzK = zzs.zzK(this.zzb);
                if (zze != null) {
                    str = zze.getString(R.string.s1);
                } else {
                    str = "Save image";
                }
                zzK.setTitle(str);
                if (zze != null) {
                    str2 = zze.getString(R.string.s2);
                } else {
                    str2 = "Allow Ad to store image in Picture gallery?";
                }
                zzK.setMessage(str2);
                if (zze != null) {
                    str3 = zze.getString(R.string.s3);
                } else {
                    str3 = HttpHeaders.ACCEPT;
                }
                zzK.setPositiveButton(str3, new zzbsf(this, str5, lastPathSegment));
                if (zze != null) {
                    str4 = zze.getString(R.string.s4);
                } else {
                    str4 = "Decline";
                }
                zzK.setNegativeButton(str4, new zzbsg(this));
                zzK.create().show();
                return;
            }
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
        } else {
            zzh("Invalid image url: ".concat(String.valueOf(str5)));
        }
    }
}
