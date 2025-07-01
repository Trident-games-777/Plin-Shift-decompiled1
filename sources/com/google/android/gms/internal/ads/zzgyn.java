package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public enum zzgyn {
    DOUBLE(0, 1, zzgzo.DOUBLE),
    FLOAT(1, 1, zzgzo.FLOAT),
    INT64(2, 1, zzgzo.LONG),
    UINT64(3, 1, zzgzo.LONG),
    INT32(4, 1, zzgzo.INT),
    FIXED64(5, 1, zzgzo.LONG),
    FIXED32(6, 1, zzgzo.INT),
    BOOL(7, 1, zzgzo.BOOLEAN),
    STRING(8, 1, zzgzo.STRING),
    MESSAGE(9, 1, zzgzo.MESSAGE),
    BYTES(10, 1, zzgzo.BYTE_STRING),
    UINT32(11, 1, zzgzo.INT),
    ENUM(12, 1, zzgzo.ENUM),
    SFIXED32(13, 1, zzgzo.INT),
    SFIXED64(14, 1, zzgzo.LONG),
    SINT32(15, 1, zzgzo.INT),
    SINT64(16, 1, zzgzo.LONG),
    GROUP(17, 1, zzgzo.MESSAGE),
    DOUBLE_LIST(18, 2, zzgzo.DOUBLE),
    FLOAT_LIST(19, 2, zzgzo.FLOAT),
    INT64_LIST(20, 2, zzgzo.LONG),
    UINT64_LIST(21, 2, zzgzo.LONG),
    INT32_LIST(22, 2, zzgzo.INT),
    FIXED64_LIST(23, 2, zzgzo.LONG),
    FIXED32_LIST(24, 2, zzgzo.INT),
    BOOL_LIST(25, 2, zzgzo.BOOLEAN),
    STRING_LIST(26, 2, zzgzo.STRING),
    MESSAGE_LIST(27, 2, zzgzo.MESSAGE),
    BYTES_LIST(28, 2, zzgzo.BYTE_STRING),
    UINT32_LIST(29, 2, zzgzo.INT),
    ENUM_LIST(30, 2, zzgzo.ENUM),
    SFIXED32_LIST(31, 2, zzgzo.INT),
    SFIXED64_LIST(32, 2, zzgzo.LONG),
    SINT32_LIST(33, 2, zzgzo.INT),
    SINT64_LIST(34, 2, zzgzo.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzgzo.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzgzo.FLOAT),
    INT64_LIST_PACKED(37, 3, zzgzo.LONG),
    UINT64_LIST_PACKED(38, 3, zzgzo.LONG),
    INT32_LIST_PACKED(39, 3, zzgzo.INT),
    FIXED64_LIST_PACKED(40, 3, zzgzo.LONG),
    FIXED32_LIST_PACKED(41, 3, zzgzo.INT),
    BOOL_LIST_PACKED(42, 3, zzgzo.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzgzo.INT),
    ENUM_LIST_PACKED(44, 3, zzgzo.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzgzo.INT),
    SFIXED64_LIST_PACKED(46, 3, zzgzo.LONG),
    SINT32_LIST_PACKED(47, 3, zzgzo.INT),
    SINT64_LIST_PACKED(48, 3, zzgzo.LONG),
    GROUP_LIST(49, 2, zzgzo.MESSAGE),
    MAP(50, 4, zzgzo.VOID);
    
    private static final zzgyn[] zzZ = null;
    private final int zzab;

    static {
        zzZ = new zzgyn[r1];
        for (zzgyn zzgyn : values()) {
            zzZ[zzgyn.zzab] = zzgyn;
        }
    }

    private zzgyn(int i, int i2, zzgzo zzgzo) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1) {
            zzgzo.zza();
        } else if (i3 == 3) {
            zzgzo.zza();
        }
        if (i2 == 1) {
            zzgzo zzgzo2 = zzgzo.VOID;
            zzgzo.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
