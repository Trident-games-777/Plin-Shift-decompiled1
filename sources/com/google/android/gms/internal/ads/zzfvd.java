package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfvd {
    public static final /* synthetic */ int zzb = 0;
    private static final zzfvv zzc = new zzfvv("OverlayDisplayService");
    private static final Intent zzd = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzfvu zza;
    private final String zze;

    zzfvd(Context context) {
        if (zzfvx.zza(context)) {
            this.zza = new zzfvu(context.getApplicationContext(), zzc, "OverlayDisplayService", zzd, new zzfuz());
        } else {
            this.zza = null;
        }
        this.zze = context.getPackageName();
    }

    static /* synthetic */ boolean zzh(String str) {
        return !zzk(str);
    }

    private static void zzi(String str, Consumer consumer) {
        if (!zzk(str)) {
            str.getClass();
            String str2 = str;
            consumer.accept(str.trim());
        }
    }

    private static boolean zzj(zzfvi zzfvi, String str, List list) {
        if (list.stream().anyMatch(new zzfva())) {
            return true;
        }
        zzc.zza(str, new Object[0]);
        zzfvg zzc2 = zzfvh.zzc();
        zzc2.zzb(8160);
        zzfvi.zza(zzc2.zzc());
        return false;
    }

    private static boolean zzk(String str) {
        return zzfxf.zzc(str).trim().isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        if (this.zza != null) {
            zzc.zzc("unbind LMD display overlay service", new Object[0]);
            this.zza.zzn();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzfuk zzfuk, zzfvi zzfvi) {
        if (this.zza == null) {
            zzc.zza("error: %s", "Play Store not found.");
            return;
        }
        if (zzj(zzfvi, "Failed to apply OverlayDisplayDismissRequest: missing appId and sessionToken.", Arrays.asList(new String[]{zzfuk.zzb(), zzfuk.zza()}))) {
            this.zza.zzi(new zzfut(this, zzfuk, zzfvi));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzfuk zzfuk, zzfvi zzfvi) {
        try {
            zzfvu zzfvu = this.zza;
            if (zzfvu != null) {
                zzfvu zzfvu2 = zzfvu;
                zzftu zzftu = (zzftu) zzfvu.zzc();
                if (zzftu != null) {
                    String str = this.zze;
                    Bundle bundle = new Bundle();
                    bundle.putString("callerPackage", str);
                    zzi(zzfuk.zzb(), new zzfuw(bundle));
                    zzi(zzfuk.zza(), new zzfux(bundle));
                    zzftu.zze(bundle, new zzfvc(this, zzfvi));
                    return;
                }
                return;
            }
            throw null;
        } catch (RemoteException e) {
            zzc.zzb(e, "dismiss overlay display from: %s", this.zze);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfvf zzfvf, zzfvi zzfvi) {
        try {
            zzfvu zzfvu = this.zza;
            if (zzfvu != null) {
                zzfvu zzfvu2 = zzfvu;
                zzftu zzftu = (zzftu) zzfvu.zzc();
                if (zzftu != null) {
                    String str = this.zze;
                    Bundle bundle = new Bundle();
                    bundle.putString("callerPackage", str);
                    bundle.putBinder("windowToken", zzfvf.zzf());
                    zzi(zzfvf.zzg(), new zzfvb(bundle));
                    bundle.putInt("layoutGravity", zzfvf.zzc());
                    bundle.putFloat("layoutVerticalMargin", zzfvf.zza());
                    bundle.putInt("displayMode", 0);
                    bundle.putInt("triggerMode", 0);
                    bundle.putInt("windowWidthPx", zzfvf.zze());
                    zzi((String) null, new zzfup(bundle));
                    zzi((String) null, new zzfuq(bundle));
                    zzi(zzfvf.zzh(), new zzfur(bundle));
                    zzi((String) null, new zzfus(bundle));
                    bundle.putBoolean("stableSessionToken", true);
                    zzftu.zzf(str, bundle, new zzfvc(this, zzfvi));
                    return;
                }
                return;
            }
            throw null;
        } catch (RemoteException e) {
            zzc.zzb(e, "show overlay display from: %s", this.zze);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzfvk zzfvk, int i, zzfvi zzfvi) {
        try {
            zzfvu zzfvu = this.zza;
            if (zzfvu != null) {
                zzfvu zzfvu2 = zzfvu;
                zzftu zzftu = (zzftu) zzfvu.zzc();
                if (zzftu != null) {
                    String str = this.zze;
                    Bundle bundle = new Bundle();
                    bundle.putString("callerPackage", str);
                    bundle.putInt("displayMode", i);
                    zzi(zzfvk.zzb(), new zzfuo(bundle));
                    zzi(zzfvk.zza(), new zzfuu(bundle));
                    zzftu.zzg(bundle, new zzfvc(this, zzfvi));
                    return;
                }
                return;
            }
            throw null;
        } catch (RemoteException e) {
            zzc.zzb(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(i), this.zze);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzfvf zzfvf, zzfvi zzfvi) {
        if (this.zza == null) {
            zzc.zza("error: %s", "Play Store not found.");
            return;
        }
        if (zzj(zzfvi, "Failed to apply OverlayDisplayShowRequest: missing appId and sessionToken.", Arrays.asList(new String[]{null, zzfvf.zzh()}))) {
            this.zza.zzi(new zzfuy(this, zzfvf, zzfvi));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzfvk zzfvk, zzfvi zzfvi, int i) {
        if (this.zza == null) {
            zzc.zza("error: %s", "Play Store not found.");
            return;
        }
        if (zzj(zzfvi, "Failed to apply OverlayDisplayUpdateRequest: missing appId and sessionToken.", Arrays.asList(new String[]{zzfvk.zzb(), zzfvk.zza()}))) {
            this.zza.zzi(new zzfuv(this, zzfvk, i, zzfvi));
        }
    }
}
