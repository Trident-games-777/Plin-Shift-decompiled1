package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgor {
    private final Class zza;
    private Map zzb = new HashMap();
    private final List zzc = new ArrayList();
    private zzgos zzd;
    private zzgnd zze;

    /* synthetic */ zzgor(Class cls, zzgot zzgot) {
        this.zza = cls;
        this.zze = zzgnd.zza;
    }

    private final zzgor zze(Object obj, zzgfw zzgfw, zzguk zzguk, boolean z) throws GeneralSecurityException {
        byte[] bArr;
        if (this.zzb == null) {
            throw new IllegalStateException("addEntry cannot be called after build");
        } else if (obj == null) {
            throw new NullPointerException("`fullPrimitive` must not be null");
        } else if (zzguk.zzk() == 3) {
            int ordinal = zzguk.zzf().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzgfr.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = zzgoa.zza(zzguk.zza()).zzc();
            } else {
                bArr = zzgoa.zzb(zzguk.zza()).zzc();
            }
            zzgos zzgos = new zzgos(obj, zzgwu.zzb(bArr), zzguk.zzk(), zzguk.zzf(), zzguk.zza(), zzguk.zzb().zzg(), zzgfw, (zzgot) null);
            Map map = this.zzb;
            List list = this.zzc;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzgos);
            List list2 = (List) map.put(zzgos.zzb, Collections.unmodifiableList(arrayList));
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list2);
                arrayList2.add(zzgos);
                map.put(zzgos.zzb, Collections.unmodifiableList(arrayList2));
            }
            list.add(zzgos);
            if (!z) {
                return this;
            }
            if (this.zzd == null) {
                this.zzd = zzgos;
                return this;
            }
            throw new IllegalStateException("you cannot set two primary primitives");
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    public final zzgor zza(Object obj, zzgfw zzgfw, zzguk zzguk) throws GeneralSecurityException {
        zze(obj, zzgfw, zzguk, false);
        return this;
    }

    public final zzgor zzb(Object obj, zzgfw zzgfw, zzguk zzguk) throws GeneralSecurityException {
        zze(obj, zzgfw, zzguk, true);
        return this;
    }

    public final zzgor zzc(zzgnd zzgnd) {
        if (this.zzb != null) {
            this.zze = zzgnd;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzgou zzd() throws GeneralSecurityException {
        Map map = this.zzb;
        if (map != null) {
            zzgou zzgou = new zzgou(map, this.zzc, this.zzd, this.zze, this.zza, (zzgot) null);
            this.zzb = null;
            return zzgou;
        }
        throw new IllegalStateException("build cannot be called twice");
    }
}
