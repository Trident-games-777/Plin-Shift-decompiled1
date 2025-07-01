package com.github.megatronking.stringfog;

public interface IStringFog {
    String decrypt(byte[] bArr, byte[] bArr2);

    byte[] encrypt(String str, byte[] bArr);

    boolean shouldFog(String str);
}
