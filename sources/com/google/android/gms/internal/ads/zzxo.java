package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzxo extends zzca {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;
    /* access modifiers changed from: private */
    public boolean zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final SparseArray zzh;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzi;

    @Deprecated
    public zzxo() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    private final void zzx() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    public final zzxo zzp(int i, boolean z) {
        if (this.zzi.get(i) == z) {
            return this;
        }
        if (z) {
            this.zzi.put(i, true);
            return this;
        }
        this.zzi.delete(i);
        return this;
    }

    public zzxo(Context context) {
        super.zze(context);
        Point zzw = zzen.zzw(context);
        super.zzf(zzw.x, zzw.y, true);
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    /* synthetic */ zzxo(zzxp zzxp, zzya zzya) {
        super(zzxp);
        this.zza = zzxp.zzC;
        this.zzb = zzxp.zzE;
        this.zzc = zzxp.zzG;
        this.zzd = zzxp.zzL;
        this.zze = zzxp.zzM;
        this.zzf = zzxp.zzN;
        this.zzg = zzxp.zzP;
        SparseArray zza2 = zzxp.zzR;
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < zza2.size(); i++) {
            sparseArray.put(zza2.keyAt(i), new HashMap((Map) zza2.valueAt(i)));
        }
        this.zzh = sparseArray;
        this.zzi = zzxp.zzS.clone();
    }
}
