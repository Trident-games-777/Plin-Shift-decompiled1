package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzggf {
    private final zzgum zza;
    private final List zzb;
    private final zzgnd zzc;

    private zzggf(zzgum zzgum, List list) {
        this.zza = zzgum;
        this.zzb = list;
        this.zzc = zzgnd.zza;
    }

    /* synthetic */ zzggf(zzgum zzgum, List list, zzgnd zzgnd, zzgge zzgge) {
        this.zza = zzgum;
        this.zzb = list;
        this.zzc = zzgnd;
    }

    static final zzggf zza(zzgum zzgum) throws GeneralSecurityException {
        zzh(zzgum);
        return new zzggf(zzgum, zzg(zzgum));
    }

    public static final zzggf zzb(zzggj zzggj) throws GeneralSecurityException {
        zzggc zzggc = new zzggc();
        zzgga zzgga = new zzgga(zzggj, (zzgge) null);
        zzgga.zzd();
        zzgga.zzc();
        zzggc.zza(zzgga);
        return zzggc.zzb();
    }

    private final Object zzf(zzgmn zzgmn, Class cls, Class cls2) throws GeneralSecurityException {
        int i = zzggq.zza;
        zzgum zzgum = this.zza;
        int zzb2 = zzgum.zzb();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzguk zzguk : zzgum.zzh()) {
            if (zzguk.zzk() == 3) {
                if (!zzguk.zzj()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzguk.zza())}));
                } else if (zzguk.zzf() == zzgve.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzguk.zza())}));
                } else if (zzguk.zzk() != 2) {
                    if (zzguk.zza() == zzb2) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    z2 &= zzguk.zzb().zzb() == zzgty.ASYMMETRIC_PUBLIC;
                    i2++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzguk.zza())}));
                }
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (z || z2) {
            zzgor zzb3 = zzgou.zzb(cls2);
            zzb3.zzc(this.zzc);
            for (int i3 = 0; i3 < this.zzb.size(); i3++) {
                zzguk zzd = this.zza.zzd(i3);
                if (zzd.zzk() == 3) {
                    zzggd zzggd = (zzggd) this.zzb.get(i3);
                    if (zzggd != null) {
                        zzgfw zza2 = zzggd.zza();
                        try {
                            Object zzb4 = zzgmn.zzb(zza2, cls2);
                            if (zzd.zza() == this.zza.zzb()) {
                                zzb3.zzb(zzb4, zza2, zzd);
                            } else {
                                zzb3.zza(zzb4, zza2, zzd);
                            }
                        } catch (GeneralSecurityException e) {
                            throw new GeneralSecurityException("Unable to get primitive " + cls2.toString() + " for key of type " + zzd.zzb().zzg() + ", see https://developers.google.com/tink/faq/registration_errors", e);
                        }
                    } else {
                        throw new GeneralSecurityException("Key parsing of key with index " + i3 + " and type_url " + zzd.zzb().zzg() + " failed, unable to get primitive");
                    }
                }
            }
            return zzgmn.zzc(zzb3.zzd(), cls);
        } else {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }

    private static List zzg(zzgum zzgum) {
        zzgfw zzgfw;
        zzgfy zzgfy;
        ArrayList arrayList = new ArrayList(zzgum.zza());
        for (zzguk zzguk : zzgum.zzh()) {
            int zza2 = zzguk.zza();
            try {
                zzgow zza3 = zzgow.zza(zzguk.zzb().zzg(), zzguk.zzb().zzf(), zzguk.zzb().zzb(), zzguk.zzf(), zzguk.zzf() == zzgve.RAW ? null : Integer.valueOf(zzguk.zza()));
                zzgnz zzc2 = zzgnz.zzc();
                zzggn zza4 = zzggn.zza();
                if (!zzc2.zzj(zza3)) {
                    zzgfw = new zzgmz(zza3, zza4);
                } else {
                    zzgfw = zzc2.zza(zza3, zza4);
                }
                int zzk = zzguk.zzk() - 2;
                boolean z = true;
                if (zzk == 1) {
                    zzgfy = zzgfy.zza;
                } else if (zzk == 2) {
                    zzgfy = zzgfy.zzb;
                } else if (zzk == 3) {
                    zzgfy = zzgfy.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                if (zza2 != zzgum.zzb()) {
                    z = false;
                }
                arrayList.add(new zzggd(zzgfw, zzgfy, zza2, z, (zzgge) null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public static void zzh(zzgum zzgum) throws GeneralSecurityException {
        if (zzgum == null || zzgum.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        int i = zzggq.zza;
        zzgun zza2 = zzgur.zza();
        zzgum zzgum = this.zza;
        zza2.zzb(zzgum.zzb());
        for (zzguk zzguk : zzgum.zzh()) {
            zzguo zza3 = zzgup.zza();
            zza3.zzc(zzguk.zzb().zzg());
            zza3.zzd(zzguk.zzk());
            zza3.zzb(zzguk.zzf());
            zza3.zza(zzguk.zza());
            zza2.zza((zzgup) zza3.zzbr());
        }
        return ((zzgur) zza2.zzbr()).toString();
    }

    /* access modifiers changed from: package-private */
    public final zzgum zzc() {
        return this.zza;
    }

    public final Object zzd(zzgfq zzgfq, Class cls) throws GeneralSecurityException {
        zzgmn zzgmn = (zzgmn) zzgfq;
        Class zza2 = zzgmn.zza(cls);
        if (zza2 != null) {
            return zzf(zzgmn, cls, zza2);
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls.getName())));
    }
}
