package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfpb implements zzfoc {
    private static final zzfpb zza = new zzfpb();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzd = new zzfox();
    /* access modifiers changed from: private */
    public static final Runnable zze = new zzfoy();
    private final List zzf = new ArrayList();
    private int zzg;
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfoe zzj = new zzfoe();
    private final zzfou zzk = new zzfou();
    /* access modifiers changed from: private */
    public final zzfov zzl = new zzfov(new zzfpe());
    private long zzm;

    zzfpb() {
    }

    public static zzfpb zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfpb zzfpb) {
        zzfpb zzfpb2;
        zzfpb.zzg = 0;
        zzfpb.zzi.clear();
        zzfpb.zzh = false;
        for (zzfna zzfna : zzfnr.zza().zzb()) {
        }
        zzfpb.zzm = System.nanoTime();
        zzfpb.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzfod zza2 = zzfpb.zzj.zza();
        if (zzfpb.zzk.zze().size() > 0) {
            Iterator it = zzfpb.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject zza3 = zza2.zza((View) null);
                View zza4 = zzfpb.zzk.zza(str);
                zzfod zzb2 = zzfpb.zzj.zzb();
                String zzc2 = zzfpb.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzfon.zzb(zza5, str);
                    try {
                        zza5.put("notVisibleReason", zzc2);
                    } catch (JSONException e) {
                        zzfoo.zza("Error with setting not visible reason", e);
                    }
                    zzfon.zzc(zza3, zza5);
                }
                zzfon.zzf(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfpb.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfpb.zzk.zzf().size() > 0) {
            JSONObject zza6 = zza2.zza((View) null);
            zzfpb2 = zzfpb;
            zzfpb2.zzk((View) null, zza2, zza6, 1, false);
            zzfon.zzf(zza6);
            zzfpb2.zzl.zzd(zza6, zzfpb2.zzk.zzf(), nanoTime);
            boolean z = zzfpb2.zzh;
        } else {
            zzfpb2 = zzfpb;
            zzfpb2.zzl.zzb();
        }
        zzfpb2.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzfpb2.zzm;
        if (zzfpb2.zzf.size() > 0) {
            for (zzfpa zzfpa : zzfpb2.zzf) {
                int i = zzfpb2.zzg;
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzfpa.zzb();
                if (zzfpa instanceof zzfoz) {
                    int i2 = zzfpb2.zzg;
                    ((zzfoz) zzfpa).zza();
                }
            }
        }
        zzfob.zza().zzc();
    }

    private final void zzk(View view, zzfod zzfod, JSONObject jSONObject, int i, boolean z) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        zzfod zzfod2 = zzfod;
        zzfod2.zzb(view, jSONObject, this, z2, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zza(View view, zzfod zzfod, JSONObject jSONObject, boolean z) {
        int zzl2;
        zzfpb zzfpb;
        boolean z2;
        boolean z3;
        zzfod zzfod2;
        View view2;
        if (zzfos.zza(view) != null || (zzl2 = this.zzk.zzl(view)) == 3) {
            return;
        }
        JSONObject zza2 = zzfod.zza(view);
        zzfon.zzc(jSONObject, zza2);
        String zzd2 = this.zzk.zzd(view);
        if (zzd2 != null) {
            zzfon.zzb(zza2, zzd2);
            try {
                zza2.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzk(view)));
            } catch (JSONException e) {
                zzfoo.zza("Error with setting has window focus", e);
            }
            Boolean valueOf = Boolean.valueOf(this.zzk.zzj(zzd2));
            if (valueOf.booleanValue()) {
                try {
                    zza2.put("isPipActive", valueOf);
                } catch (JSONException e2) {
                    zzfoo.zza("Error with setting is picture-in-picture active", e2);
                }
            }
            this.zzk.zzh();
            zzfpb = this;
        } else {
            zzfot zzb2 = this.zzk.zzb(view);
            if (zzb2 != null) {
                zzfnu zza3 = zzb2.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList zzb3 = zzb2.zzb();
                int size = zzb3.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) zzb3.get(i));
                }
                try {
                    zza2.put("isFriendlyObstructionFor", jSONArray);
                    zza2.put("friendlyObstructionClass", zza3.zzd());
                    zza2.put("friendlyObstructionPurpose", zza3.zza());
                    zza2.put("friendlyObstructionReason", zza3.zzc());
                } catch (JSONException e3) {
                    zzfoo.zza("Error with setting friendly obstruction", e3);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || z2) {
                zzfpb = this;
                view2 = view;
                zzfod2 = zzfod;
                z3 = true;
            } else {
                view2 = view;
                zzfod2 = zzfod;
                z3 = false;
                zzfpb = this;
            }
            zzfpb.zzk(view2, zzfod2, zza2, zzl2, z3);
        }
        zzfpb.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfow(this));
    }
}
