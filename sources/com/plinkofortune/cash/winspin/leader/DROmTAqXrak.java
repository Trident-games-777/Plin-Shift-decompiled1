package com.plinkofortune.cash.winspin.leader;

import android.content.Context;
import android.provider.Settings;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/plinkofortune/cash/winspin/leader/DROmTAqXrak;", "", "<init>", "()V", "zvSyKlNrddQ", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: DROmTAqXrak.kt */
public final class DROmTAqXrak {
    public static final int $stable = 0;
    public static final DROmTAqXrak INSTANCE = new DROmTAqXrak();

    private DROmTAqXrak() {
    }

    public final String zvSyKlNrddQ(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{98, 6, Ascii.SUB, -93, -74, -17, 96}, new byte[]{1, 105, 116, -41, -45, -105, Ascii.DC4, -107}));
        try {
            str = Settings.Global.getString(context.getContentResolver(), StringFog.decrypt(new byte[]{71, 57, -24, -111, 105, -122, -41, 74, 74, 56, -18}, new byte[]{38, 93, -118, -50, Ascii.FF, -24, -74, 40}));
        } catch (Exception unused) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        return StringFog.decrypt(new byte[]{Ascii.SYN}, new byte[]{39, 10, Ascii.ESC, 42, 96, 105, Ascii.DLE, 62});
    }
}
