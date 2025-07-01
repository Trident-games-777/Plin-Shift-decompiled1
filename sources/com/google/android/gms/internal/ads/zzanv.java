package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzanv implements zzann {
    final /* synthetic */ zzanw zza;
    private final zzec zzb = new zzec(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzanv(zzanw zzanw, int i) {
        this.zza = zzanw;
        this.zze = i;
    }

    public final void zza(zzed zzed) {
        int i;
        int i2;
        zzed zzed2 = zzed;
        if (zzed2.zzm() == 2) {
            zzek zzek = (zzek) this.zza.zzb.get(0);
            if ((zzed2.zzm() & 128) != 0) {
                zzed2.zzM(1);
                int zzq = zzed2.zzq();
                int i3 = 3;
                zzed2.zzM(3);
                zzed2.zzG(this.zzb, 2);
                this.zzb.zzn(3);
                int i4 = 13;
                this.zza.zzr = this.zzb.zzd(13);
                zzed2.zzG(this.zzb, 2);
                int i5 = 4;
                this.zzb.zzn(4);
                int i6 = 12;
                zzed2.zzM(this.zzb.zzd(12));
                this.zzc.clear();
                this.zzd.clear();
                int zzb2 = zzed2.zzb();
                while (zzb2 > 0) {
                    int i7 = 5;
                    zzed2.zzG(this.zzb, 5);
                    zzec zzec = this.zzb;
                    int zzd2 = zzec.zzd(8);
                    zzec.zzn(i3);
                    int zzd3 = this.zzb.zzd(i4);
                    this.zzb.zzn(i5);
                    int zzd4 = this.zzb.zzd(i6);
                    int zzd5 = zzed2.zzd();
                    int i8 = zzd5 + zzd4;
                    int i9 = 0;
                    String str = null;
                    ArrayList arrayList = null;
                    int i10 = -1;
                    while (zzed2.zzd() < i8) {
                        int zzm = zzed2.zzm();
                        int zzd6 = zzed2.zzd() + zzed2.zzm();
                        if (zzd6 > i8) {
                            break;
                        }
                        if (zzm == i7) {
                            long zzu = zzed2.zzu();
                            if (zzu != 1094921523) {
                                if (zzu != 1161904947) {
                                    if (zzu != 1094921524) {
                                        if (zzu == 1212503619) {
                                            i2 = 36;
                                            i = zzb2;
                                            i10 = i2;
                                            zzed2.zzM(zzd6 - zzed2.zzd());
                                            zzb2 = i;
                                            i3 = 3;
                                            i5 = 4;
                                            i7 = 5;
                                        }
                                        i = zzb2;
                                        zzed2.zzM(zzd6 - zzed2.zzd());
                                        zzb2 = i;
                                        i3 = 3;
                                        i5 = 4;
                                        i7 = 5;
                                    }
                                }
                                i = zzb2;
                                i10 = 135;
                                zzed2.zzM(zzd6 - zzed2.zzd());
                                zzb2 = i;
                                i3 = 3;
                                i5 = 4;
                                i7 = 5;
                            }
                            i = zzb2;
                            i10 = 129;
                            zzed2.zzM(zzd6 - zzed2.zzd());
                            zzb2 = i;
                            i3 = 3;
                            i5 = 4;
                            i7 = 5;
                        } else {
                            if (zzm != 106) {
                                if (zzm != 122) {
                                    if (zzm == 127) {
                                        int zzm2 = zzed2.zzm();
                                        if (zzm2 != 21) {
                                            if (zzm2 == 14) {
                                                i2 = 136;
                                            } else {
                                                if (zzm2 == 33) {
                                                    i2 = 139;
                                                }
                                                i = zzb2;
                                                zzed2.zzM(zzd6 - zzed2.zzd());
                                                zzb2 = i;
                                                i3 = 3;
                                                i5 = 4;
                                                i7 = 5;
                                            }
                                        }
                                    } else if (zzm == 123) {
                                        i2 = 138;
                                    } else {
                                        if (zzm == 10) {
                                            String trim = zzed2.zzB(i3, StandardCharsets.UTF_8).trim();
                                            i9 = zzed2.zzm();
                                            i = zzb2;
                                            str = trim;
                                        } else if (zzm == 89) {
                                            ArrayList arrayList2 = new ArrayList();
                                            while (zzed2.zzd() < zzd6) {
                                                String trim2 = zzed2.zzB(i3, StandardCharsets.UTF_8).trim();
                                                int zzm3 = zzed2.zzm();
                                                int i11 = zzb2;
                                                byte[] bArr = new byte[i5];
                                                zzed2.zzH(bArr, 0, i5);
                                                arrayList2.add(new zzanx(trim2, zzm3, bArr));
                                                zzb2 = i11;
                                                i3 = 3;
                                                i5 = 4;
                                            }
                                            i = zzb2;
                                            arrayList = arrayList2;
                                            i10 = 89;
                                        } else {
                                            i = zzb2;
                                            if (zzm == 111) {
                                                i10 = 257;
                                            }
                                        }
                                        zzed2.zzM(zzd6 - zzed2.zzd());
                                        zzb2 = i;
                                        i3 = 3;
                                        i5 = 4;
                                        i7 = 5;
                                    }
                                    i = zzb2;
                                    i10 = i2;
                                    zzed2.zzM(zzd6 - zzed2.zzd());
                                    zzb2 = i;
                                    i3 = 3;
                                    i5 = 4;
                                    i7 = 5;
                                }
                                i = zzb2;
                                i10 = 135;
                                zzed2.zzM(zzd6 - zzed2.zzd());
                                zzb2 = i;
                                i3 = 3;
                                i5 = 4;
                                i7 = 5;
                            }
                            i = zzb2;
                            i10 = 129;
                            zzed2.zzM(zzd6 - zzed2.zzd());
                            zzb2 = i;
                            i3 = 3;
                            i5 = 4;
                            i7 = 5;
                        }
                        i = zzb2;
                        i10 = 172;
                        zzed2.zzM(zzd6 - zzed2.zzd());
                        zzb2 = i;
                        i3 = 3;
                        i5 = 4;
                        i7 = 5;
                    }
                    int i12 = zzb2;
                    zzed2.zzL(i8);
                    zzany zzany = new zzany(i10, str, i9, arrayList, Arrays.copyOfRange(zzed2.zzN(), zzd5, i8));
                    if (zzd2 == 6 || zzd2 == 5) {
                        zzd2 = zzany.zza;
                    }
                    int i13 = i12 - (zzd4 + 5);
                    if (!this.zza.zzh.get(zzd3)) {
                        zzaob zzb3 = this.zza.zze.zzb(zzd2, zzany);
                        this.zzd.put(zzd3, zzd3);
                        this.zzc.put(zzd3, zzb3);
                    }
                    zzb2 = i13;
                    i3 = 3;
                    i5 = 4;
                    i6 = 12;
                    i4 = 13;
                }
                int size = this.zzd.size();
                for (int i14 = 0; i14 < size; i14++) {
                    SparseIntArray sparseIntArray = this.zzd;
                    zzanw zzanw = this.zza;
                    int keyAt = sparseIntArray.keyAt(i14);
                    int valueAt = sparseIntArray.valueAt(i14);
                    zzanw.zzh.put(keyAt, true);
                    this.zza.zzi.put(valueAt, true);
                    zzaob zzaob = (zzaob) this.zzc.valueAt(i14);
                    if (zzaob != null) {
                        zzaob.zzb(zzek, this.zza.zzl, new zzaoa(zzq, keyAt, 8192));
                        this.zza.zzg.put(valueAt, zzaob);
                    }
                }
                this.zza.zzg.remove(this.zze);
                this.zza.zzm = 0;
                zzanw zzanw2 = this.zza;
                if (zzanw2.zzm == 0) {
                    zzanw2.zzl.zzD();
                    this.zza.zzn = true;
                }
            }
        }
    }

    public final void zzb(zzek zzek, zzacu zzacu, zzaoa zzaoa) {
    }
}
