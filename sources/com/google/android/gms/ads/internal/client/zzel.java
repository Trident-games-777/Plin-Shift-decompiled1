package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbpc;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzel {
    final zzbd zza;
    private final zzbpc zzb;
    private final zzr zzc;
    private final AtomicBoolean zzd;
    /* access modifiers changed from: private */
    public final VideoController zze;
    private zza zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    private AppEventListener zzi;
    private zzby zzj;
    private VideoOptions zzk;
    private String zzl;
    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    private OnPaidEventListener zzp;

    public zzel(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzr.zza, (zzby) null, 0);
    }

    private static zzs zzD(Context context, AdSize[] adSizeArr, int i) {
        AdSize[] adSizeArr2 = adSizeArr;
        for (AdSize equals : adSizeArr2) {
            if (equals.equals(AdSize.INVALID)) {
                return new zzs("invalid", 0, 0, false, 0, 0, (zzs[]) null, false, false, false, true, false, false, false, false);
            }
        }
        zzs zzs = new zzs(context, adSizeArr2);
        zzs.zzj = zzE(i);
        return zzs;
    }

    private static boolean zzE(int i) {
        return i == 1;
    }

    public final boolean zzA() {
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                return zzby.zzY();
            }
            return false;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean zzB() {
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                return zzby.zzZ();
            }
            return false;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final AdSize[] zzC() {
        return this.zzh;
    }

    public final AdListener zza() {
        return this.zzg;
    }

    public final AdSize zzb() {
        zzs zzg2;
        try {
            zzby zzby = this.zzj;
            if (!(zzby == null || (zzg2 = zzby.zzg()) == null)) {
                return zzb.zzc(zzg2.zze, zzg2.zzb, zzg2.zza);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final OnPaidEventListener zzc() {
        return this.zzp;
    }

    public final ResponseInfo zzd() {
        zzdy zzdy = null;
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzdy = zzby.zzk();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzdy);
    }

    public final VideoController zzf() {
        return this.zze;
    }

    public final VideoOptions zzg() {
        return this.zzk;
    }

    public final AppEventListener zzh() {
        return this.zzi;
    }

    public final zzeb zzi() {
        zzby zzby = this.zzj;
        if (zzby != null) {
            try {
                return zzby.zzl();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        return null;
    }

    public final String zzj() {
        zzby zzby;
        if (this.zzl == null && (zzby = this.zzj) != null) {
            try {
                this.zzl = zzby.zzr();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        return this.zzl;
    }

    public final void zzk() {
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzx();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(IObjectWrapper iObjectWrapper) {
        this.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzm(zzei zzei) {
        zzby zzby;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzm.getContext();
                zzs zzD = zzD(context, this.zzh, this.zzn);
                if ("search_v2".equals(zzD.zza)) {
                    zzby = (zzby) new zzao(zzbc.zza(), context, zzD, this.zzl).zzd(context, false);
                } else {
                    zzby = (zzby) new zzam(zzbc.zza(), context, zzD, this.zzl, this.zzb).zzd(context, false);
                }
                this.zzj = zzby;
                zzby.zzD(new zzg(this.zza));
                zza zza2 = this.zzf;
                if (zza2 != null) {
                    this.zzj.zzC(new zzb(zza2));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzG(new zzaza(appEventListener));
                }
                if (this.zzk != null) {
                    this.zzj.zzU(new zzga(this.zzk));
                }
                this.zzj.zzP(new zzfs(this.zzp));
                this.zzj.zzN(this.zzo);
                zzby zzby2 = this.zzj;
                if (zzby2 != null) {
                    try {
                        IObjectWrapper zzn2 = zzby2.zzn();
                        if (zzn2 != null) {
                            if (((Boolean) zzbel.zzf.zze()).booleanValue()) {
                                if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                                    zzf.zza.post(new zzej(this, zzn2));
                                }
                            }
                            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
                        }
                    } catch (RemoteException e) {
                        zzm.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            if (zzei != null) {
                zzei.zzq(currentTimeMillis);
            }
            zzby zzby3 = this.zzj;
            if (zzby3 != null) {
                zzby3.zzab(this.zzc.zza(this.zzm.getContext(), zzei));
                return;
            }
            throw null;
        } catch (RemoteException e2) {
            zzm.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzn() {
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzz();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzo() {
        if (!this.zzd.getAndSet(true)) {
            try {
                zzby zzby = this.zzj;
                if (zzby != null) {
                    zzby.zzA();
                }
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzp() {
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzB();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzq(zza zza2) {
        try {
            this.zzf = zza2;
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzC(zza2 != null ? new zzb(zza2) : null);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzr(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzs(AdSize... adSizeArr) {
        if (this.zzh == null) {
            zzt(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zzt(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzF(zzD(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        this.zzm.requestLayout();
    }

    public final void zzu(String str) {
        if (this.zzl == null) {
            this.zzl = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void zzv(AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzG(appEventListener != null ? new zzaza(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzw(boolean z) {
        this.zzo = z;
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzN(z);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzx(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzby zzby = this.zzj;
            if (zzby != null) {
                zzby.zzP(new zzfs(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final boolean zzz(zzby zzby) {
        try {
            IObjectWrapper zzn2 = zzby.zzn();
            if (zzn2 == null || ((View) ObjectWrapper.unwrap(zzn2)).getParent() != null) {
                return false;
            }
            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
            this.zzj = zzby;
            return true;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public zzel(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzr.zza, (zzby) null, i);
    }

    public final void zzy(VideoOptions videoOptions) {
        zzga zzga;
        this.zzk = videoOptions;
        try {
            zzby zzby = this.zzj;
            if (zzby != null) {
                if (videoOptions == null) {
                    zzga = null;
                } else {
                    zzga = new zzga(videoOptions);
                }
                zzby.zzU(zzga);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public zzel(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzr.zza, (zzby) null, 0);
    }

    public zzel(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzr.zza, (zzby) null, i);
    }

    zzel(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzr zzr, zzby zzby, int i) {
        zzs zzs;
        ViewGroup viewGroup2 = viewGroup;
        AttributeSet attributeSet2 = attributeSet;
        this.zzb = new zzbpc();
        this.zze = new VideoController();
        this.zza = new zzek(this);
        this.zzm = viewGroup2;
        this.zzc = zzr;
        this.zzj = null;
        this.zzd = new AtomicBoolean(false);
        this.zzn = i;
        if (attributeSet2 != null) {
            Context context = viewGroup2.getContext();
            try {
                zzaa zzaa = new zzaa(context, attributeSet2);
                this.zzh = zzaa.zzb(z);
                this.zzl = zzaa.zza();
                if (viewGroup2.isInEditMode()) {
                    zzf zzb2 = zzbc.zzb();
                    AdSize adSize = this.zzh[0];
                    int i2 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzs = new zzs("invalid", 0, 0, false, 0, 0, (zzs[]) null, false, false, false, true, false, false, false, false);
                    } else {
                        zzs = new zzs(context, adSize);
                        zzs.zzj = zzE(i2);
                    }
                    zzb2.zzn(viewGroup2, zzs, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzbc.zzb().zzm(viewGroup2, new zzs(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }
}
