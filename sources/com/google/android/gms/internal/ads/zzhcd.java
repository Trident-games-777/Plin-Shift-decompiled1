package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzhcd implements zzgzd {
    static final zzgzd zza = new zzhcd();

    private zzhcd() {
    }

    public final boolean zza(int i) {
        if (!(i == 0 || i == 1 || i == 2 || i == 1999)) {
            switch (i) {
                case 1000:
                case 1001:
                case PointerIconCompat.TYPE_HAND:
                case PointerIconCompat.TYPE_HELP:
                case PointerIconCompat.TYPE_WAIT:
                case WebSocketProtocol.CLOSE_NO_STATUS_CODE /*1005*/:
                case PointerIconCompat.TYPE_CELL:
                case PointerIconCompat.TYPE_CROSSHAIR:
                case PointerIconCompat.TYPE_TEXT:
                case PointerIconCompat.TYPE_VERTICAL_TEXT:
                case PointerIconCompat.TYPE_ALIAS:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
