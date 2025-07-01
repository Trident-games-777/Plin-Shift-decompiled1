package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzaox;
import com.google.android.gms.internal.ads.zzapt;
import com.google.android.gms.internal.ads.zzapu;
import com.google.android.gms.internal.ads.zzaqu;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbi extends zzaqu {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzl zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbi(zzbn zzbn, int i, String str, zzapu zzapu, zzapt zzapt, byte[] bArr, Map map, zzl zzl) {
        super(i, str, zzapu, zzapt);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzl;
    }

    public final Map zzl() throws zzaox {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    public final byte[] zzx() throws zzaox {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final void zzz(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
