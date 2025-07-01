package com.google.android.gms.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class AbstractAdRequestBuilder<T extends AbstractAdRequestBuilder<T>> {
    protected final zzeh zza;

    protected AbstractAdRequestBuilder() {
        zzeh zzeh = new zzeh();
        this.zza = zzeh;
        zzeh.zzt("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    @Deprecated
    public T addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
        this.zza.zzo(cls, bundle);
        return self();
    }

    public T addCustomTargeting(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.contains(",")) {
            zzm.zzj("Value " + str2 + " contains invalid character ',' (comma). The server will parse it as a list of comma-separated values.");
        }
        this.zza.zzp(str, str2);
        return self();
    }

    public T addKeyword(String str) {
        this.zza.zzq(str);
        return self();
    }

    public T addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zza.zzr(cls, bundle);
        if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            this.zza.zzu("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return self();
    }

    /* access modifiers changed from: protected */
    public abstract T self();

    public T setAdString(String str) {
        this.zza.zzv(str);
        return self();
    }

    public T setContentUrl(String str) {
        Preconditions.checkNotNull(str, "Content URL must be non-null.");
        Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
        int length = str.length();
        Preconditions.checkArgument(length <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
        this.zza.zzw(str);
        return self();
    }

    public T setHttpTimeoutMillis(int i) {
        this.zza.zzx(i);
        return self();
    }

    public T setNeighboringContentUrls(List<String> list) {
        if (list == null) {
            zzm.zzj("neighboring content URLs list should not be null");
            return self();
        }
        this.zza.zzz(list);
        return self();
    }

    public T setRequestAgent(String str) {
        this.zza.zzC(str);
        return self();
    }

    @Deprecated
    public final AbstractAdRequestBuilder zza(String str) {
        this.zza.zzt(str);
        return self();
    }

    @Deprecated
    public final AbstractAdRequestBuilder zzb(boolean z) {
        this.zza.zzy(z);
        return self();
    }

    public final AbstractAdRequestBuilder zzc(Bundle bundle) {
        this.zza.zzA(bundle);
        return self();
    }

    @Deprecated
    public final AbstractAdRequestBuilder zzd(boolean z) {
        this.zza.zzD(z);
        return self();
    }

    public T addCustomTargeting(String str, List<String> list) {
        if (list != null) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next) && next.contains(",")) {
                    zzm.zzj("Value " + next + " contains invalid character ',' (comma). The server will parse it as a list of comma-separated values.");
                }
            }
            this.zza.zzp(str, TextUtils.join(",", list));
        }
        return self();
    }
}
