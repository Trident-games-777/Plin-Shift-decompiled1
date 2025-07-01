package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaze implements Application.ActivityLifecycleCallbacks {
    private Activity zza;
    private Context zzb;
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public boolean zzd = true;
    /* access modifiers changed from: private */
    public boolean zze = false;
    /* access modifiers changed from: private */
    public final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private Runnable zzh;
    private boolean zzi = false;
    private long zzj;

    zzaze() {
    }

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zza = activity;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            for (zzazt zzb2 : this.zzg) {
                try {
                    zzb2.zzb();
                } catch (Exception e) {
                    zzv.zzp().zzw(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzm.zzh("", e);
                }
            }
        }
        this.zze = true;
        if (this.zzh != null) {
            zzs.zza.removeCallbacks(this.zzh);
        }
        zzftd zzftd = zzs.zza;
        zzazd zzazd = new zzazd(this);
        this.zzh = zzazd;
        zzftd.postDelayed(zzazd, this.zzj);
    }

    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z = this.zzd;
        this.zzd = true;
        if (this.zzh != null) {
            zzs.zza.removeCallbacks(this.zzh);
        }
        synchronized (this.zzc) {
            for (zzazt zzc2 : this.zzg) {
                try {
                    zzc2.zzc();
                } catch (Exception e) {
                    zzv.zzp().zzw(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzm.zzh("", e);
                }
            }
            if (!z) {
                for (zzazf zza2 : this.zzf) {
                    try {
                        zza2.zza(true);
                    } catch (Exception e2) {
                        zzm.zzh("", e2);
                    }
                }
            } else {
                zzm.zze("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final Activity zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final void zzf(zzazf zzazf) {
        synchronized (this.zzc) {
            this.zzf.add(zzazf);
        }
    }

    public final void zzg(Application application, Context context) {
        if (!this.zzi) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                zzk((Activity) context);
            }
            this.zzb = application;
            this.zzj = ((Long) zzbe.zzc().zza(zzbcn.zzaZ)).longValue();
            this.zzi = true;
        }
    }

    public final void zzh(zzazf zzazf) {
        synchronized (this.zzc) {
            this.zzf.remove(zzazf);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.zza = null;
                }
                Iterator it = this.zzg.iterator();
                while (it.hasNext()) {
                    try {
                        if (((zzazt) it.next()).zza()) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzv.zzp().zzw(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzm.zzh("", e);
                    }
                }
            }
        }
    }
}
