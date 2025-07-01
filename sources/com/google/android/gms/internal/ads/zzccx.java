package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzccx extends zzcbl implements TextureView.SurfaceTextureListener, zzcbv {
    private final zzccf zzc;
    private final zzccg zzd;
    private final zzcce zze;
    private zzcbk zzf;
    private Surface zzg;
    private zzcbw zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl = 1;
    private zzccd zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzccx(Context context, zzccg zzccg, zzccf zzccf, boolean z, boolean z2, zzcce zzcce) {
        super(context);
        this.zzc = zzccf;
        this.zzd = zzccg;
        this.zzn = z;
        this.zze = zzcce;
        setSurfaceTextureListener(this);
        zzccg.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + RemoteSettings.FORWARD_SLASH_STRING + canonicalName + ":" + message;
    }

    private final void zzU() {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            zzcbw.zzQ(true);
        }
    }

    private final void zzV() {
        if (!this.zzo) {
            this.zzo = true;
            zzs.zza.post(new zzccw(this));
            zzn();
            this.zzd.zzb();
            if (this.zzp) {
                zzp();
            }
        }
    }

    private final void zzW(boolean z, Integer num) {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null && !z) {
            zzcbw.zzP(num);
        } else if (this.zzi != null && this.zzg != null) {
            if (z) {
                if (zzad()) {
                    zzcbw.zzU();
                    zzY();
                } else {
                    zzm.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzi.startsWith("cache:")) {
                zzcdr zzp2 = this.zzc.zzp(this.zzi);
                if (zzp2 instanceof zzcea) {
                    zzcbw zza = ((zzcea) zzp2).zza();
                    this.zzh = zza;
                    zza.zzP(num);
                    if (!this.zzh.zzV()) {
                        zzm.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzp2 instanceof zzcdx) {
                    zzcdx zzcdx = (zzcdx) zzp2;
                    String zzF = zzF();
                    ByteBuffer zzl2 = zzcdx.zzl();
                    boolean zzm2 = zzcdx.zzm();
                    String zzk2 = zzcdx.zzk();
                    if (zzk2 == null) {
                        zzm.zzj("Stream cache URL is null.");
                        return;
                    }
                    zzcbw zzE = zzE(num);
                    this.zzh = zzE;
                    zzE.zzG(new Uri[]{Uri.parse(zzk2)}, zzF, zzl2, zzm2);
                } else {
                    zzm.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
            } else {
                this.zzh = zzE(num);
                String zzF2 = zzF();
                Uri[] uriArr = new Uri[this.zzj.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzj;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzh.zzF(uriArr, zzF2);
            }
            this.zzh.zzL(this);
            zzZ(this.zzg, false);
            if (this.zzh.zzV()) {
                int zzt = this.zzh.zzt();
                this.zzl = zzt;
                if (zzt == 3) {
                    zzV();
                }
            }
        }
    }

    private final void zzX() {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            zzcbw.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ((Surface) null, true);
            zzcbw zzcbw = this.zzh;
            if (zzcbw != null) {
                zzcbw.zzL((zzcbv) null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            try {
                zzcbw.zzS(surface, z);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set surface before player is initialized.");
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzs != f) {
            this.zzs = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcbw zzcbw = this.zzh;
        return zzcbw != null && zzcbw.zzV() && !this.zzk;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzs;
        if (f != 0.0f && this.zzm == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzccd zzccd = this.zzm;
        if (zzccd != null) {
            zzccd.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzn) {
            zzccd zzccd = new zzccd(getContext());
            this.zzm = zzccd;
            zzccd.zzd(surfaceTexture, i, i2);
            this.zzm.start();
            SurfaceTexture zzb = this.zzm.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, (Integer) null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        zzs.zza.post(new zzcct(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzccd zzccd = this.zzm;
        if (zzccd != null) {
            zzccd.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ((Surface) null, true);
        }
        zzs.zza.post(new zzccp(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzccd zzccd = this.zzm;
        if (zzccd != null) {
            zzccd.zzc(i, i2);
        }
        zzs.zza.post(new zzcco(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        zzs.zza.post(new zzccn(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzA(int i) {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            zzcbw.zzN(i);
        }
    }

    public final void zzB(int i) {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            zzcbw.zzR(i);
        }
    }

    public final void zzD(int i, int i2) {
        this.zzq = i;
        this.zzr = i2;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    public final zzcbw zzE(Integer num) {
        zzcce zzcce = this.zze;
        zzccf zzccf = this.zzc;
        zzces zzces = new zzces(zzccf.getContext(), zzcce, zzccf, num);
        zzm.zzi("ExoPlayerAdapter initialized.");
        return zzces;
    }

    /* access modifiers changed from: package-private */
    public final String zzF() {
        zzccf zzccf = this.zzc;
        return zzv.zzq().zzc(zzccf.getContext(), zzccf.zzn().afmaVersion);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(String str) {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzb("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(String str) {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzc("ExoPlayerAdapter exception", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzi();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(int i, int i2) {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzj(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzP() {
        float zza = this.zzb.zza();
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            try {
                zzcbw.zzT(zza, false);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set volume before player is initialized.");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(int i) {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zze();
        }
    }

    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    public final int zzb() {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            return zzcbw.zzr();
        }
        return -1;
    }

    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    public final int zzd() {
        return this.zzr;
    }

    public final int zze() {
        return this.zzq;
    }

    public final long zzf() {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            return zzcbw.zzx();
        }
        return -1;
    }

    public final long zzg() {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            return zzcbw.zzA();
        }
        return -1;
    }

    public final long zzh() {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            return zzcbw.zzB();
        }
        return -1;
    }

    public final void zzi(boolean z, long j) {
        if (this.zzc != null) {
            zzcaj.zze.execute(new zzccq(this, z, j));
        }
    }

    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    public final void zzk(String str, Exception exc) {
        String zzT = zzT(str, exc);
        zzm.zzj("ExoPlayerAdapter error: ".concat(zzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        zzs.zza.post(new zzccu(this, zzT));
        zzv.zzp().zzv(exc, "AdExoPlayerView.onError");
    }

    public final void zzl(String str, Exception exc) {
        String zzT = zzT("onLoadException", exc);
        zzm.zzj("ExoPlayerAdapter exception: ".concat(zzT));
        zzv.zzp().zzv(exc, "AdExoPlayerView.onException");
        zzs.zza.post(new zzccr(this, zzT));
    }

    public final void zzm(int i) {
        if (this.zzl != i) {
            this.zzl = i;
            if (i == 3) {
                zzV();
            } else if (i == 4) {
                if (this.zze.zza) {
                    zzX();
                }
                this.zzd.zze();
                this.zzb.zzc();
                zzs.zza.post(new zzccv(this));
            }
        }
    }

    public final void zzn() {
        zzs.zza.post(new zzccm(this));
    }

    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            zzs.zza.post(new zzccs(this));
        }
    }

    public final void zzp() {
        if (zzac()) {
            if (this.zze.zza) {
                zzU();
            }
            this.zzh.zzO(true);
            this.zzd.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            zzs.zza.post(new zzccl(this));
            return;
        }
        this.zzp = true;
    }

    public final void zzq(int i) {
        if (zzac()) {
            this.zzh.zzI((long) i);
        }
    }

    public final void zzr(zzcbk zzcbk) {
        this.zzf = zzcbk;
    }

    public final void zzs(String str) {
        if (str != null) {
            zzC(str, (String[]) null, (Integer) null);
        }
    }

    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    public final void zzu(float f, float f2) {
        zzccd zzccd = this.zzm;
        if (zzccd != null) {
            zzccd.zzf(f, f2);
        }
    }

    public final void zzv() {
        zzs.zza.post(new zzcck(this));
    }

    public final Integer zzw() {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            return zzcbw.zzC();
        }
        return null;
    }

    public final void zzx(int i) {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            zzcbw.zzJ(i);
        }
    }

    public final void zzy(int i) {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            zzcbw.zzK(i);
        }
    }

    public final void zzz(int i) {
        zzcbw zzcbw = this.zzh;
        if (zzcbw != null) {
            zzcbw.zzM(i);
        }
    }

    public final void zzC(String str, String[] strArr, Integer num) {
        if (str != null) {
            boolean z = true;
            if (strArr == null) {
                this.zzj = new String[]{str};
            } else {
                this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            String str2 = this.zzi;
            if (!this.zze.zzk || str2 == null || str.equals(str2) || this.zzl != 4) {
                z = false;
            }
            this.zzi = str;
            zzW(z, num);
        }
    }
}
