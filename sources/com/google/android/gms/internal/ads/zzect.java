package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.autofill.HintConstants;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbbs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzect extends zzecu {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcvq zzd;
    private final TelephonyManager zze;
    /* access modifiers changed from: private */
    public final zzecl zzf;
    private zzbbs.zzq zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbbs.zzaf.zzd.CONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbbs.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbbs.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbbs.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbbs.zzaf.zzd.DISCONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbbs.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbbs.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbbs.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbbs.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbbs.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbbs.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbbs.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbbs.zzaf.zzd.CONNECTING);
    }

    zzect(Context context, zzcvq zzcvq, zzecl zzecl, zzech zzech, zzg zzg2) {
        super(zzech, zzg2);
        this.zzc = context;
        this.zzd = zzcvq;
        this.zzf = zzecl;
        this.zze = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    static /* bridge */ /* synthetic */ zzbbs.zzab zza(zzect zzect, Bundle bundle) {
        zzbbs.zzab.zzb zzb2;
        zzbbs.zzab.zza zza = zzbbs.zzab.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzect.zzg = zzbbs.zzq.ENUM_TRUE;
        } else {
            zzect.zzg = zzbbs.zzq.ENUM_FALSE;
            if (i == 0) {
                zza.zzd(zzbbs.zzab.zzc.CELL);
            } else if (i != 1) {
                zza.zzd(zzbbs.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zza.zzd(zzbbs.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb2 = zzbbs.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb2 = zzbbs.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzb2 = zzbbs.zzab.zzb.LTE;
                    break;
                default:
                    zzb2 = zzbbs.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zza.zzc(zzb2);
        }
        return (zzbbs.zzab) zza.zzbr();
    }

    static /* bridge */ /* synthetic */ zzbbs.zzaf.zzd zzb(zzect zzect, Bundle bundle) {
        return (zzbbs.zzaf.zzd) zzb.get(zzfgc.zza(zzfgc.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbbs.zzaf.zzd.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzect zzect, boolean z, ArrayList arrayList, zzbbs.zzab zzab, zzbbs.zzaf.zzd zzd2) {
        zzbbs.zzaf.zza.C0002zza zzn = zzbbs.zzaf.zza.zzn();
        zzn.zzn(arrayList);
        boolean z2 = false;
        zzn.zzD(zzg(Settings.Global.getInt(zzect.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzn.zzE(zzv.zzr().zzg(zzect.zzc, zzect.zze));
        zzn.zzM(zzect.zzf.zze());
        zzn.zzL(zzect.zzf.zzb());
        zzn.zzG(zzect.zzf.zza());
        zzn.zzH(zzd2);
        zzn.zzJ(zzab);
        zzn.zzK(zzect.zzg);
        zzn.zzN(zzg(z));
        zzn.zzP(zzect.zzf.zzd());
        zzn.zzO(zzv.zzC().currentTimeMillis());
        if (Settings.Global.getInt(zzect.zzc.getContentResolver(), "wifi_on", 0) != 0) {
            z2 = true;
        }
        zzn.zzQ(zzg(z2));
        return ((zzbbs.zzaf.zza) zzn.zzbr()).zzaV();
    }

    private static final zzbbs.zzq zzg(boolean z) {
        return z ? zzbbs.zzq.ENUM_TRUE : zzbbs.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgei.zzr(this.zzd.zzb(new Bundle()), new zzecs(this, z), zzcaj.zzf);
    }
}
