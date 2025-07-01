package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdnk extends zzbgr {
    private final Context zza;
    private final zzdiy zzb;
    private zzdjy zzc;
    /* access modifiers changed from: private */
    public zzdit zzd;

    public zzdnk(Context context, zzdiy zzdiy, zzdjy zzdjy, zzdit zzdit) {
        this.zza = context;
        this.zzb = zzdiy;
        this.zzc = zzdjy;
        this.zzd = zzdit;
    }

    public final zzeb zze() {
        return this.zzb.zzj();
    }

    public final zzbfv zzf() throws RemoteException {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            zzv.zzp().zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    public final zzbfy zzg(String str) {
        return (zzbfy) this.zzb.zzh().get(str);
    }

    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final String zzi() {
        return this.zzb.zzA();
    }

    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    public final List zzk() {
        try {
            SimpleArrayMap zzh = this.zzb.zzh();
            SimpleArrayMap zzi = this.zzb.zzi();
            String[] strArr = new String[(zzh.size() + zzi.size())];
            int i = 0;
            for (int i2 = 0; i2 < zzh.size(); i2++) {
                strArr[i] = (String) zzh.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < zzi.size(); i3++) {
                strArr[i] = (String) zzi.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            zzv.zzp().zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    public final void zzl() {
        zzdit zzdit = this.zzd;
        if (zzdit != null) {
            zzdit.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final void zzm() {
        try {
            String zzC = this.zzb.zzC();
            if (Objects.equals(zzC, "Google")) {
                zzm.zzj("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(zzC)) {
                zzm.zzj("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdit zzdit = this.zzd;
                if (zzdit != null) {
                    zzdit.zzf(zzC, false);
                }
            }
        } catch (NullPointerException e) {
            zzv.zzp().zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    public final void zzn(String str) {
        zzdit zzdit = this.zzd;
        if (zzdit != null) {
            zzdit.zzF(str);
        }
    }

    public final void zzo() {
        zzdit zzdit = this.zzd;
        if (zzdit != null) {
            zzdit.zzJ();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdit zzdit;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzu() != null && (zzdit = this.zzd) != null) {
            zzdit.zzK((View) unwrap);
        }
    }

    public final boolean zzq() {
        zzdit zzdit = this.zzd;
        if ((zzdit == null || zzdit.zzX()) && this.zzb.zzr() != null && this.zzb.zzs() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdjy zzdjy;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdjy = this.zzc) == null || !zzdjy.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzq().zzar(new zzdnj(this, NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdjy zzdjy;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdjy = this.zzc) == null || !zzdjy.zzg((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzs().zzar(new zzdnj(this, NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzt() {
        zzeew zzu = this.zzb.zzu();
        if (zzu != null) {
            zzv.zzB().zzk(zzu.zza());
            if (this.zzb.zzr() == null) {
                return true;
            }
            this.zzb.zzr().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzm.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
