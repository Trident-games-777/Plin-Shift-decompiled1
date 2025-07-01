package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzggc {
    private final List zza = new ArrayList();
    private final zzgnd zzb = zzgnd.zza;
    private boolean zzc = false;

    /* access modifiers changed from: private */
    public final void zzd() {
        for (zzgga zzi : this.zza) {
            zzi.zza = false;
        }
    }

    public final zzggc zza(zzgga zzgga) {
        if (zzgga.zzf == null) {
            if (zzgga.zza) {
                zzd();
            }
            zzgga.zzf = this;
            this.zza.add(zzgga);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzggf zzb() throws GeneralSecurityException {
        byte b;
        int i;
        int i2;
        if (!this.zzc) {
            char c = 1;
            this.zzc = true;
            List list = this.zza;
            zzgui zzc2 = zzgum.zzc();
            ArrayList arrayList = new ArrayList(list.size());
            List list2 = this.zza;
            byte b2 = 0;
            int i3 = 0;
            while (i3 < list2.size() - 1) {
                int i4 = i3 + 1;
                if (((zzgga) list2.get(i3)).zze != zzggb.zza || ((zzgga) list2.get(i4)).zze == zzggb.zza) {
                    i3 = i4;
                } else {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (zzgga zzgga : this.zza) {
                zzgfy unused = zzgga.zzb;
                if (zzgga.zze != null) {
                    if (zzgga.zze == zzggb.zza) {
                        byte b3 = b2;
                        while (true) {
                            if (b3 != 0 && !hashSet.contains(Integer.valueOf(b3))) {
                                break;
                            }
                            SecureRandom secureRandom = new SecureRandom();
                            byte[] bArr = new byte[4];
                            byte b4 = b2;
                            while (b4 == 0) {
                                secureRandom.nextBytes(bArr);
                                b4 = ((bArr[2] & 255) << 8) | ((bArr[b2] & 255) << Ascii.CAN) | ((bArr[c] & 255) << Ascii.DLE) | (bArr[3] & 255);
                                b2 = 0;
                            }
                            b3 = b4;
                        }
                        b = b3;
                        i = 3;
                    } else {
                        i = 3;
                        zzggb unused2 = zzgga.zze;
                        b = 0;
                    }
                    Integer valueOf = Integer.valueOf(b);
                    if (!hashSet.contains(valueOf)) {
                        hashSet.add(valueOf);
                        zzgfw unused3 = zzgga.zzc;
                        zzgfw zza2 = zzgnp.zzb().zza(zzgga.zzd, c != zzgga.zzd.zza() ? null : valueOf);
                        zzggd zzggd = new zzggd(zza2, zzgga.zzb, b, zzgga.zza, (zzgge) null);
                        byte b5 = b;
                        zzgfy zzb2 = zzgga.zzb;
                        zzgow zzgow = (zzgow) zzgnz.zzc().zzd(zza2, zzgow.class, zzggn.zza());
                        Integer zzf = zzgow.zzf();
                        if (zzf == null || zzf.intValue() == b5) {
                            if (zzgfy.zza.equals(zzb2)) {
                                i2 = i;
                            } else if (zzgfy.zzb.equals(zzb2)) {
                                i2 = 4;
                            } else if (zzgfy.zzc.equals(zzb2)) {
                                i2 = 5;
                            } else {
                                throw new IllegalStateException("Unknown key status");
                            }
                            zzguj zzc3 = zzguk.zzc();
                            zzgtx zza3 = zzgua.zza();
                            zza3.zzb(zzgow.zzg());
                            zza3.zzc(zzgow.zze());
                            zza3.zza(zzgow.zzb());
                            zzc3.zza(zza3);
                            zzc3.zzd(i2);
                            zzc3.zzb(b5);
                            zzc3.zzc(zzgow.zzc());
                            zzc2.zza((zzguk) zzc3.zzbr());
                            if (zzgga.zza) {
                                if (num != null) {
                                    throw new GeneralSecurityException("Two primaries were set");
                                } else if (zzgga.zzb == zzgfy.zza) {
                                    num = valueOf;
                                } else {
                                    throw new GeneralSecurityException("Primary key is not enabled");
                                }
                            }
                            arrayList.add(zzggd);
                            c = 1;
                            b2 = 0;
                        } else {
                            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
                        }
                    } else {
                        throw new GeneralSecurityException("Id " + b + " is used twice in the keyset");
                    }
                } else {
                    throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                }
            }
            if (num != null) {
                zzc2.zzb(num.intValue());
                zzgum zzgum = (zzgum) zzc2.zzbr();
                zzggf.zzh(zzgum);
                return new zzggf(zzgum, arrayList, this.zzb, (zzgge) null);
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}
