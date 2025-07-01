package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeth implements zzevz {
    private final zzges zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzeth(zzges zzges, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzges;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final int zza() {
        return 22;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzetg(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeti zzc() throws Exception {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfN)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzeti(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        boolean z = null;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfO)).booleanValue() && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                boolean z2 = true;
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                            z2 = false;
                        }
                        z = Boolean.valueOf(z2);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    z = true;
                }
                return new zzeti(z);
            }
        }
        return new zzeti((Boolean) null);
    }
}
