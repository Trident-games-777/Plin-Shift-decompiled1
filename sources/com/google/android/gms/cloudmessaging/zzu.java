package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
final class zzu extends zzs {
    zzu(int i, int i2, Bundle bundle) {
        super(i, i2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzd(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return false;
    }
}
