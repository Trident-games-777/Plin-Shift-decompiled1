package com.github.megatronking.stringfog.xor;

import com.github.megatronking.stringfog.IStringFog;
import java.nio.charset.StandardCharsets;

public final class StringFogImpl implements IStringFog {
    public boolean shouldFog(String str) {
        return true;
    }

    public byte[] encrypt(String str, byte[] bArr) {
        return xor(str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public String decrypt(byte[] bArr, byte[] bArr2) {
        return new String(xor(bArr, bArr2), StandardCharsets.UTF_8);
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (i2 >= length2) {
                i2 = 0;
            }
            bArr[i] = (byte) (bArr[i] ^ bArr2[i2]);
            i++;
            i2++;
        }
        return bArr;
    }
}
