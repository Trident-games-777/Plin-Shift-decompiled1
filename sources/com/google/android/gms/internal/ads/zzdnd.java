package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdnd extends zzbmd implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbfk {
    private View zza;
    private zzeb zzb;
    private zzdit zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdnd(zzdit zzdit, zzdiy zzdiy) {
        this.zza = zzdiy.zzf();
        this.zzb = zzdiy.zzj();
        this.zzc = zzdit;
        if (zzdiy.zzs() != null) {
            zzdiy.zzs().zzap(this);
        }
    }

    private final void zzg() {
        View view;
        zzdit zzdit = this.zzc;
        if (zzdit != null && (view = this.zza) != null) {
            zzdit.zzB(view, Collections.emptyMap(), Collections.emptyMap(), zzdit.zzY(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private static final void zzi(zzbmh zzbmh, int i) {
        try {
            zzbmh.zze(i);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onGlobalLayout() {
        zzg();
    }

    public final void onScrollChanged() {
        zzg();
    }

    public final zzeb zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzbfv zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdit zzdit = this.zzc;
        if (zzdit == null || zzdit.zzc() == null) {
            return null;
        }
        return zzdit.zzc().zza();
    }

    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdit zzdit = this.zzc;
        if (zzdit != null) {
            zzdit.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdnc(this));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbmh zzbmh) throws RemoteException {
        String str;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbmh, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            if (view == null) {
                str = "can not get video view.";
            } else {
                str = "can not get video controller.";
            }
            zzm.zzg("Instream internal error: ".concat(str));
            zzi(zzbmh, 0);
        } else if (this.zze) {
            zzm.zzg("Instream ad should not be used again.");
            zzi(zzbmh, 1);
        } else {
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzv.zzy();
            zzcaw.zza(this.zza, this);
            zzv.zzy();
            zzcaw.zzb(this.zza, this);
            zzg();
            try {
                zzbmh.zzf();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
