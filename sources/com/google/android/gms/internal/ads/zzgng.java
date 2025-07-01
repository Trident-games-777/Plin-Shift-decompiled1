package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgng {
    @Nullable
    private ArrayList zza = new ArrayList();
    private zzgnd zzb = zzgnd.zza;
    @Nullable
    private Integer zzc = null;

    public final zzgng zza(zzgfy zzgfy, int i, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzgnh(zzgfy, i, str, str2, (zzgni) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzgng zzb(zzgnd zzgnd) {
        if (this.zza != null) {
            this.zzb = zzgnd;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzgng zzc(int i) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzgnj zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    int zza2 = ((zzgnh) arrayList.get(i)).zza();
                    i++;
                    if (zza2 == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzgnj zzgnj = new zzgnj(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzgni) null);
            this.zza = null;
            return zzgnj;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
