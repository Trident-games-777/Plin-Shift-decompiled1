package com.github.megatronking.stringfog;

import java.lang.reflect.InvocationTargetException;

public final class StringFogWrapper implements IStringFog {
    private final IStringFog mStringFogImpl;

    public StringFogWrapper(String str) {
        try {
            this.mStringFogImpl = (IStringFog) Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("Stringfog implementation class not found: " + str);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Stringfog implementation class new instance failed: " + e.getMessage());
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            throw new IllegalArgumentException("Stringfog implementation class create instance failed: " + e2.getMessage());
        }
    }

    public byte[] encrypt(String str, byte[] bArr) {
        IStringFog iStringFog = this.mStringFogImpl;
        return iStringFog == null ? str.getBytes() : iStringFog.encrypt(str, bArr);
    }

    public String decrypt(byte[] bArr, byte[] bArr2) {
        IStringFog iStringFog = this.mStringFogImpl;
        return iStringFog == null ? new String(bArr) : iStringFog.decrypt(bArr, bArr2);
    }

    public boolean shouldFog(String str) {
        IStringFog iStringFog = this.mStringFogImpl;
        return iStringFog != null && iStringFog.shouldFog(str);
    }
}
