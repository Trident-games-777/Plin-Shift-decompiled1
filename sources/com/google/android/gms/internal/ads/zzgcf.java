package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgcf implements FilenameFilter {
    private final Pattern zza;

    public final boolean accept(File file, String str) {
        return this.zza.matcher(str).matches();
    }

    public zzgcf(Pattern pattern) {
        pattern.getClass();
        Pattern pattern2 = pattern;
        this.zza = pattern;
    }
}
