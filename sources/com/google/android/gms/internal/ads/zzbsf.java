package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbsf implements DialogInterface.OnClickListener {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbsh zzc;

    zzbsf(zzbsh zzbsh, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbsh;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzc.zzb.getSystemService("download");
        try {
            String str = this.zza;
            String str2 = this.zzb;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzv.zzq();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzc.zzh("Could not store picture.");
        }
    }
}
