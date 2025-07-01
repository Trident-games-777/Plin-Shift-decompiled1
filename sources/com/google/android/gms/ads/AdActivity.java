package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbtg zza;

    private final void zza() {
        zzbtg zzbtg = this.zza;
        if (zzbtg != null) {
            try {
                zzbtg.zzx();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null && !zzbtg.zzH()) {
                return;
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbtg zzbtg2 = this.zza;
            if (zzbtg2 != null) {
                zzbtg2.zzi();
            }
        } catch (RemoteException e2) {
            zzm.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzbtg zzq = zzbc.zza().zzq(this);
        this.zza = zzq;
        if (zzq != null) {
            try {
                zzq.zzl(bundle);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
                finish();
            }
        } else {
            zzm.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzm();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzo();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzq();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzr();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzs(bundle);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzt();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzu();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbtg zzbtg = this.zza;
            if (zzbtg != null) {
                zzbtg.zzv();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
