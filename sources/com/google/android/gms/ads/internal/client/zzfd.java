package com.google.android.gms.ads.internal.client;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzbgs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfd implements MediaContent {
    private final zzbfv zza;
    private final VideoController zzb = new VideoController();
    private final zzbgs zzc;

    public zzfd(zzbfv zzbfv, zzbgs zzbgs) {
        this.zza = zzbfv;
        this.zzc = zzbgs;
    }

    public final float getAspectRatio() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzi = this.zza.zzi();
            if (zzi != null) {
                return (Drawable) ObjectWrapper.unwrap(zzi);
            }
            return null;
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzh() != null) {
                this.zzb.zzb(this.zza.zzh());
            }
        } catch (RemoteException e) {
            zzm.zzh("Exception occurred while getting video controller", e);
        }
        return this.zzb;
    }

    public final boolean hasVideoContent() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zza.zzj(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final zzbgs zza() {
        return this.zzc;
    }

    public final boolean zzb() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return false;
        }
    }

    public final zzbfv zzc() {
        return this.zza;
    }
}
