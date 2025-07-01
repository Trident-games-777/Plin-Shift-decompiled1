package com.plinkofortune.cash.winspin;

import com.github.megatronking.stringfog.xor.StringFogImpl;

public final class StringFog {
    private static final StringFogImpl IMPL = new StringFogImpl();

    public static String decrypt(byte[] bArr, byte[] bArr2) {
        return IMPL.decrypt(bArr, bArr2);
    }
}
