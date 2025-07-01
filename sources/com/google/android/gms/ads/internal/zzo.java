package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzfgq;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzo extends WebViewClient {
    final /* synthetic */ zzu zza;

    zzo(zzu zzu) {
        this.zza = zzu;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzu zzu = this.zza;
        if (zzu.zzg != null) {
            try {
                zzu.zzg.zzf(zzfgq.zzd(1, (String) null, (zze) null));
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        zzu zzu2 = this.zza;
        if (zzu2.zzg != null) {
            try {
                zzu2.zzg.zze(0);
            } catch (RemoteException e2) {
                zzm.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zza.zzq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzu zzu = this.zza;
            if (zzu.zzg != null) {
                try {
                    zzu.zzg.zzf(zzfgq.zzd(3, (String) null, (zze) null));
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
            zzu zzu2 = this.zza;
            if (zzu2.zzg != null) {
                try {
                    zzu2.zzg.zze(3);
                } catch (RemoteException e2) {
                    zzm.zzl("#007 Could not call remote method.", e2);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzu zzu3 = this.zza;
            if (zzu3.zzg != null) {
                try {
                    zzu3.zzg.zzf(zzfgq.zzd(1, (String) null, (zze) null));
                } catch (RemoteException e3) {
                    zzm.zzl("#007 Could not call remote method.", e3);
                }
            }
            zzu zzu4 = this.zza;
            if (zzu4.zzg != null) {
                try {
                    zzu4.zzg.zze(0);
                } catch (RemoteException e4) {
                    zzm.zzl("#007 Could not call remote method.", e4);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            zzu zzu5 = this.zza;
            if (zzu5.zzg != null) {
                try {
                    zzu5.zzg.zzi();
                } catch (RemoteException e5) {
                    zzm.zzl("#007 Could not call remote method.", e5);
                }
            }
            this.zza.zzV(this.zza.zzb(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            zzu zzu6 = this.zza;
            if (zzu6.zzg != null) {
                try {
                    zzu6.zzg.zzc();
                    this.zza.zzg.zzh();
                } catch (RemoteException e6) {
                    zzm.zzl("#007 Could not call remote method.", e6);
                }
            }
            zzu.zzw(this.zza, zzu.zzo(this.zza, str));
            return true;
        }
    }
}
