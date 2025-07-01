package com.plinkofortune.cash.winspin.profile;

import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/plinkofortune/cash/winspin/profile/ProfileData;", "", "path", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getName", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ProfileData.kt */
public final class ProfileData {
    public static final int $stable = 0;
    private final String name;
    private final String path;

    public ProfileData(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, StringFog.decrypt(new byte[]{-38, -73, -61, 70}, new byte[]{-76, -42, -82, 35, Ascii.NAK, 1, 42, 105}));
        this.path = str;
        this.name = str2;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getName() {
        return this.name;
    }
}
