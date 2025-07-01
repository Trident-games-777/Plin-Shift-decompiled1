package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzos extends ContentObserver {
    final /* synthetic */ zzov zza;
    private final ContentResolver zzb;
    private final Uri zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzos(zzov zzov, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.zza = zzov;
        this.zzb = contentResolver;
        this.zzc = uri;
    }

    public final void onChange(boolean z) {
        zzov zzov = this.zza;
        this.zza.zzj(zzop.zzc(zzov.zza, zzov.zzh, zzov.zzg));
    }

    public final void zza() {
        this.zzb.registerContentObserver(this.zzc, false, this);
    }

    public final void zzb() {
        this.zzb.unregisterContentObserver(this);
    }
}
