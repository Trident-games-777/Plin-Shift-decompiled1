package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzavb extends zzava {
    private zzavb(Context context, zzauz zzauz) {
        super(context, zzauz);
    }

    public static zzavb zzu(Context context, zzauz zzauz) {
        zzs(context, zzauz);
        return new zzavb(context, zzauz);
    }

    /* access modifiers changed from: protected */
    public final List zzq(zzawf zzawf, Context context, zzasf zzasf, zzars zzars) {
        if (zzawf.zzk() == null || !this.zzu.zza) {
            return super.zzq(zzawf, context, zzasf, (zzars) null);
        }
        int zza = zzawf.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzq(zzawf, context, zzasf, (zzars) null));
        arrayList.add(new zzawx(zzawf, "I548ixRBwSg+qVTan0l7SrCz1ZaKKX3ZWtyXgu8y1OX29GkbAkB2rT1/ilUIPvFa", "lJ7kzsnnwzWch0Zt9duIk9QjvlIbpzkFDyarwE3sjFc=", zzasf, zza, 24));
        return arrayList;
    }
}
