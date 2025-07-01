package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzfx;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzeik implements zzefb {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        zzfff zzfff2 = zzfff;
        zzfet zzfet2 = zzfet;
        String optString = zzfet2.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzffo zzffo = zzfff2.zza.zza;
        zzffm zzffm = new zzffm();
        zzffm.zzq(zzffo);
        zzffm.zzt(optString);
        Bundle zzd = zzd(zzffo.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzfet2.zzv.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzfet2.zzv.optString("adJson", (String) null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzfet2.zzD.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzfet2.zzD.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzm zzm = zzffo.zzd;
        Bundle bundle = zzm.zzn;
        List list = zzm.zzo;
        String str = zzm.zzp;
        String str2 = zzm.zzq;
        boolean z = zzm.zzr;
        zzc zzc = zzm.zzs;
        int i = zzm.zzt;
        String str3 = zzm.zzu;
        List list2 = zzm.zzv;
        int i2 = zzm.zzw;
        Bundle bundle2 = zzd;
        String str4 = zzm.zzx;
        int i3 = zzm.zzy;
        long j = zzm.zzz;
        String str5 = str2;
        int i4 = zzm.zzd;
        boolean z2 = z;
        List list3 = zzm.zze;
        zzc zzc2 = zzc;
        boolean z3 = zzm.zzf;
        int i5 = i;
        int i6 = zzm.zzg;
        String str6 = str3;
        boolean z4 = zzm.zzh;
        List list4 = list2;
        String str7 = zzm.zzi;
        int i7 = i3;
        zzfx zzfx = zzm.zzj;
        Location location = zzm.zzk;
        String str8 = zzm.zzl;
        int i8 = i2;
        long j2 = zzm.zzb;
        zzffm.zzH(new zzm(zzm.zza, j2, zzd2, i4, list3, z3, i6, z4, str7, zzfx, location, str8, bundle2, bundle, list, str, str5, z2, zzc2, i5, str6, list4, i8, str4, i7, j));
        zzffo zzJ = zzffm.zzJ();
        Bundle bundle3 = new Bundle();
        zzfew zzfew = zzfff2.zzb.zzb;
        Bundle bundle4 = new Bundle();
        bundle4.putStringArrayList("nofill_urls", new ArrayList(zzfew.zza));
        bundle4.putInt("refresh_interval", zzfew.zzc);
        bundle4.putString("gws_query_id", zzfew.zzb);
        bundle3.putBundle("parent_common_config", bundle4);
        zzffo zzffo2 = zzfff2.zza.zza;
        Bundle bundle5 = new Bundle();
        bundle5.putString("initial_ad_unit_id", zzffo2.zzf);
        bundle5.putString("allocation_id", zzfet2.zzw);
        bundle5.putString("ad_source_name", zzfet2.zzF);
        bundle5.putStringArrayList("click_urls", new ArrayList(zzfet2.zzc));
        bundle5.putStringArrayList("imp_urls", new ArrayList(zzfet2.zzd));
        bundle5.putStringArrayList("manual_tracking_urls", new ArrayList(zzfet2.zzp));
        bundle5.putStringArrayList("fill_urls", new ArrayList(zzfet2.zzm));
        bundle5.putStringArrayList("video_start_urls", new ArrayList(zzfet2.zzg));
        bundle5.putStringArrayList("video_reward_urls", new ArrayList(zzfet2.zzh));
        bundle5.putStringArrayList("video_complete_urls", new ArrayList(zzfet2.zzi));
        bundle5.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzfet2.zzj);
        bundle5.putString("valid_from_timestamp", zzfet2.zzk);
        bundle5.putBoolean("is_closable_area_disabled", zzfet2.zzP);
        bundle5.putString("recursive_server_response_data", zzfet2.zzao);
        if (zzfet2.zzl != null) {
            Bundle bundle6 = new Bundle();
            bundle6.putInt("rb_amount", zzfet2.zzl.zzb);
            bundle6.putString("rb_type", zzfet2.zzl.zza);
            bundle5.putParcelableArray("rewards", new Bundle[]{bundle6});
        }
        bundle3.putBundle("parent_ad_config", bundle5);
        return zzc(zzJ, bundle3, zzfet2, zzfff2);
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        return !TextUtils.isEmpty(zzfet.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    /* access modifiers changed from: protected */
    public abstract ListenableFuture zzc(zzffo zzffo, Bundle bundle, zzfet zzfet, zzfff zzfff);
}
