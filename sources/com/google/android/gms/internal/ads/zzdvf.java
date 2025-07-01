package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdvf {
    private final zzdup zza;
    private final zzdqa zzb;
    private final Object zzc = new Object();
    private final List zzd;
    private boolean zze;

    zzdvf(zzdup zzdup, zzdqa zzdqa) {
        this.zza = zzdup;
        this.zzb = zzdqa;
        this.zzd = new ArrayList();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public final void zzd(List list) {
        String str;
        boolean z;
        synchronized (this.zzc) {
            try {
                if (!this.zze) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzblp zzblp = (zzblp) it.next();
                        if (((Boolean) zzbe.zzc().zza(zzbcn.zziV)).booleanValue()) {
                            zzdpz zza2 = this.zzb.zza(zzblp.zza);
                            if (zza2 != null) {
                                zzbru zzbru = zza2.zzc;
                                if (zzbru != null) {
                                    str = zzbru.toString();
                                }
                            }
                            str = "";
                        } else {
                            str = "";
                        }
                        String str2 = str;
                        if (((Boolean) zzbe.zzc().zza(zzbcn.zziW)).booleanValue()) {
                            zzdpz zza3 = this.zzb.zza(zzblp.zza);
                            if (zza3 != null) {
                                if (zza3.zzd) {
                                    z = true;
                                    List list2 = this.zzd;
                                    String str3 = zzblp.zza;
                                    list2.add(new zzdve(str3, str2, this.zzb.zzb(str3), zzblp.zzb ? 1 : 0, zzblp.zzd, zzblp.zzc, z));
                                }
                            }
                        }
                        z = false;
                        List list22 = this.zzd;
                        String str32 = zzblp.zza;
                        list22.add(new zzdve(str32, str2, this.zzb.zzb(str32), zzblp.zzb ? 1 : 0, zzblp.zzd, zzblp.zzc, z));
                    }
                    this.zze = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zzt()) {
                    zzd(this.zza.zzg());
                } else {
                    zzc();
                    return jSONArray;
                }
            }
            for (zzdve zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
            return jSONArray;
        }
    }

    public final void zzc() {
        this.zza.zzs(new zzdvd(this));
    }
}
