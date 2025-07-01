package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzanj extends zzacc {
    public zzanj(zzek zzek, long j, long j2) {
        super(new zzabx(), new zzanh(zzek, (zzani) null), j, 0, j + 1, 0, j2, 188, 1000);
    }

    static /* bridge */ /* synthetic */ int zzh(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i + 1] & 255) << Ascii.DLE) | ((bArr[i + 2] & 255) << 8);
    }
}
