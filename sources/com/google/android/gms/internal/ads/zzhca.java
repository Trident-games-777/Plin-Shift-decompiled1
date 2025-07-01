package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public enum zzhca {
    DOUBLE(zzhcb.DOUBLE, 1),
    FLOAT(zzhcb.FLOAT, 5),
    INT64(zzhcb.LONG, 0),
    UINT64(zzhcb.LONG, 0),
    INT32(zzhcb.INT, 0),
    FIXED64(zzhcb.LONG, 1),
    FIXED32(zzhcb.INT, 5),
    BOOL(zzhcb.BOOLEAN, 0),
    STRING(zzhcb.STRING, 2),
    GROUP(zzhcb.MESSAGE, 3),
    MESSAGE(zzhcb.MESSAGE, 2),
    BYTES(zzhcb.BYTE_STRING, 2),
    UINT32(zzhcb.INT, 0),
    ENUM(zzhcb.ENUM, 0),
    SFIXED32(zzhcb.INT, 5),
    SFIXED64(zzhcb.LONG, 1),
    SINT32(zzhcb.INT, 0),
    SINT64(zzhcb.LONG, 0);
    
    private final zzhcb zzt;

    private zzhca(zzhcb zzhcb, int i) {
        this.zzt = zzhcb;
    }

    public final zzhcb zza() {
        return this.zzt;
    }
}
