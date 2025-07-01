package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import java.util.Map;
import java.util.Objects;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzxp extends zzcb {
    public final boolean zzC;
    public final boolean zzD;
    public final boolean zzE;
    public final boolean zzF;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    /* access modifiers changed from: private */
    public final SparseArray zzR;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzS;

    static {
        new zzxp(new zzxo());
        Integer.toString(1000, 36);
        Integer.toString(1001, 36);
        Integer.toString(PointerIconCompat.TYPE_HAND, 36);
        Integer.toString(PointerIconCompat.TYPE_HELP, 36);
        Integer.toString(PointerIconCompat.TYPE_WAIT, 36);
        Integer.toString(WebSocketProtocol.CLOSE_NO_STATUS_CODE, 36);
        Integer.toString(PointerIconCompat.TYPE_CELL, 36);
        Integer.toString(PointerIconCompat.TYPE_CROSSHAIR, 36);
        Integer.toString(PointerIconCompat.TYPE_TEXT, 36);
        Integer.toString(PointerIconCompat.TYPE_VERTICAL_TEXT, 36);
        Integer.toString(PointerIconCompat.TYPE_ALIAS, 36);
        Integer.toString(PointerIconCompat.TYPE_COPY, 36);
        Integer.toString(PointerIconCompat.TYPE_NO_DROP, 36);
        Integer.toString(PointerIconCompat.TYPE_ALL_SCROLL, 36);
        Integer.toString(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_ZOOM_IN, 36);
    }

    private zzxp(zzxo zzxo) {
        super(zzxo);
        this.zzC = zzxo.zza;
        this.zzD = false;
        this.zzE = zzxo.zzb;
        this.zzF = false;
        this.zzG = zzxo.zzc;
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzL = zzxo.zzd;
        this.zzM = zzxo.zze;
        this.zzN = zzxo.zzf;
        this.zzO = false;
        this.zzP = zzxo.zzg;
        this.zzQ = false;
        this.zzR = zzxo.zzh;
        this.zzS = zzxo.zzi;
    }

    public static zzxp zzd(Context context) {
        return new zzxp(new zzxo(context));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxp zzxp = (zzxp) obj;
            if (super.equals(zzxp) && this.zzC == zzxp.zzC && this.zzE == zzxp.zzE && this.zzG == zzxp.zzG && this.zzL == zzxp.zzL && this.zzM == zzxp.zzM && this.zzN == zzxp.zzN && this.zzP == zzxp.zzP) {
                SparseBooleanArray sparseBooleanArray = this.zzS;
                SparseBooleanArray sparseBooleanArray2 = zzxp.zzS;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray sparseArray = this.zzR;
                            SparseArray sparseArray2 = zzxp.zzR;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                int i2 = 0;
                                while (i2 < size2) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzwr zzwr = (zzwr) entry.getKey();
                                                if (map2.containsKey(zzwr)) {
                                                    if (!Objects.equals(entry.getValue(), map2.get(zzwr))) {
                                                    }
                                                }
                                            }
                                            i2++;
                                        }
                                    }
                                }
                                return true;
                            }
                        } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.zzC ? 1 : 0)) * 961) + (this.zzE ? 1 : 0)) * 961) + (this.zzG ? 1 : 0)) * 28629151) + (this.zzL ? 1 : 0)) * 31) + (this.zzM ? 1 : 0)) * 31) + (this.zzN ? 1 : 0)) * 961) + (this.zzP ? 1 : 0)) * 31;
    }

    public final zzxo zzc() {
        return new zzxo(this, (zzya) null);
    }

    @Deprecated
    public final zzxq zze(int i, zzwr zzwr) {
        Map map = (Map) this.zzR.get(i);
        if (map != null) {
            return (zzxq) map.get(zzwr);
        }
        return null;
    }

    public final boolean zzf(int i) {
        return this.zzS.get(i);
    }

    @Deprecated
    public final boolean zzg(int i, zzwr zzwr) {
        Map map = (Map) this.zzR.get(i);
        return map != null && map.containsKey(zzwr);
    }
}
