package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnv {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, zzfnd zzfnd, String str) {
        zzfnu zzfnu;
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        } else if (zza.matcher("Ad overlay").matches()) {
            Iterator it = this.zzb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzfnu = null;
                    break;
                }
                zzfnu = (zzfnu) it.next();
                if (zzfnu.zzb().get() == view) {
                    break;
                }
            }
            if (zzfnu == null) {
                this.zzb.add(new zzfnu(view, zzfnd, "Ad overlay"));
            }
        } else {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
