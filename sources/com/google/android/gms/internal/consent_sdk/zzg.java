package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import com.google.android.ump.FormError;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzg extends Exception {
    private final int zza;

    public zzg(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final String getMessage() {
        String message = super.getMessage();
        String str = message;
        return message;
    }

    public final FormError zza() {
        if (getCause() == null) {
            String message = super.getMessage();
            String str = message;
            Log.w("UserMessagingPlatform", message);
        } else {
            String message2 = super.getMessage();
            String str2 = message2;
            Log.w("UserMessagingPlatform", message2, getCause());
        }
        int i = this.zza;
        String message3 = super.getMessage();
        String str3 = message3;
        return new FormError(i, message3);
    }

    public zzg(int i, String str, Throwable th) {
        super(str, th);
        this.zza = i;
    }
}
