package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzenu implements zzevz {
    private final zzges zza;
    private final Context zzb;
    private final zzffo zzc;
    private final View zzd;

    public zzenu(zzges zzges, Context context, zzffo zzffo, ViewGroup viewGroup) {
        this.zza = zzges;
        this.zzb = context;
        this.zzc = zzffo;
        this.zzd = viewGroup;
    }

    public final int zza() {
        return 3;
    }

    public final ListenableFuture zzb() {
        zzbcn.zza(this.zzb);
        return this.zza.zzb(new zzent(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzenv zzc() throws Exception {
        ArrayList arrayList = new ArrayList();
        View view = this.zzd;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzenv(this.zzb, this.zzc.zze, arrayList);
    }
}
