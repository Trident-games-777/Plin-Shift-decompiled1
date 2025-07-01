package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzsu extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzsq zzc;
    public final String zzd;

    public zzsu(zzad zzad, Throwable th, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + zzad.toString(), th, zzad.zzo, false, (zzsq) null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i), (zzsu) null);
    }

    static /* bridge */ /* synthetic */ zzsu zza(zzsu zzsu, zzsu zzsu2) {
        return new zzsu(zzsu.getMessage(), zzsu.getCause(), zzsu.zza, false, zzsu.zzc, zzsu.zzd, zzsu2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzsu(com.google.android.gms.internal.ads.zzad r11, java.lang.Throwable r12, boolean r13, com.google.android.gms.internal.ads.zzsq r14) {
        /*
            r10 = this;
            java.lang.String r13 = r14.zza
            java.lang.String r0 = r11.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Decoder init failed: "
            r1.<init>(r2)
            r1.append(r13)
            java.lang.String r13 = ", "
            r1.append(r13)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            java.lang.String r5 = r11.zzo
            boolean r11 = r12 instanceof android.media.MediaCodec.CodecException
            if (r11 == 0) goto L_0x002a
            r11 = r12
            android.media.MediaCodec$CodecException r11 = (android.media.MediaCodec.CodecException) r11
            java.lang.String r11 = r11.getDiagnosticInfo()
            goto L_0x002b
        L_0x002a:
            r11 = 0
        L_0x002b:
            r8 = r11
            r6 = 0
            r9 = 0
            r2 = r10
            r4 = r12
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsu.<init>(com.google.android.gms.internal.ads.zzad, java.lang.Throwable, boolean, com.google.android.gms.internal.ads.zzsq):void");
    }

    private zzsu(String str, Throwable th, String str2, boolean z, zzsq zzsq, String str3, zzsu zzsu) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzsq;
        this.zzd = str3;
    }
}
