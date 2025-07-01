package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B/\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007BC\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bBM\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rB?\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010 \u001a\u00020\u000fH\u0016R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u0006!"}, d2 = {"Landroidx/compose/ui/window/PopupProperties;", "", "focusable", "", "dismissOnBackPress", "dismissOnClickOutside", "clippingEnabled", "(ZZZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "excludeFromSystemGesture", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "usePlatformDefaultWidth", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZ)V", "flags", "", "inheritSecurePolicy", "(IZZZZZ)V", "getClippingEnabled", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getExcludeFromSystemGesture", "getFlags$ui_release", "()I", "getFocusable", "getInheritSecurePolicy$ui_release", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "equals", "other", "hashCode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class PopupProperties {
    public static final int $stable = 0;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final int flags;
    private final boolean inheritSecurePolicy;
    private final boolean usePlatformDefaultWidth;

    public PopupProperties(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.flags = i;
        this.inheritSecurePolicy = z;
        this.dismissOnBackPress = z2;
        this.dismissOnClickOutside = z3;
        this.excludeFromSystemGesture = z4;
        this.usePlatformDefaultWidth = z5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PopupProperties(int r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 2
            r0 = 1
            if (r9 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r9 = r8 & 4
            if (r9 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r9 = r8 & 8
            if (r9 == 0) goto L_0x0010
            r5 = r0
        L_0x0010:
            r9 = r8 & 16
            if (r9 == 0) goto L_0x0015
            r6 = r0
        L_0x0015:
            r8 = r8 & 32
            if (r8 == 0) goto L_0x001a
            r7 = 0
        L_0x001a:
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>((int) r3, (boolean) r4, (boolean) r5, (boolean) r6, (boolean) r7, (boolean) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(int, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getFlags$ui_release() {
        return this.flags;
    }

    public final boolean getInheritSecurePolicy$ui_release() {
        return this.inheritSecurePolicy;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, boolean z4) {
        this(z, z2, z3, SecureFlagPolicy.Inherit, true, z4);
    }

    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z6;
        boolean z7;
        SecureFlagPolicy secureFlagPolicy2;
        boolean z8;
        boolean z9;
        boolean z10;
        PopupProperties popupProperties;
        z = (i & 1) != 0 ? false : z;
        z2 = (i & 2) != 0 ? true : z2;
        z3 = (i & 4) != 0 ? true : z3;
        secureFlagPolicy = (i & 8) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy;
        z4 = (i & 16) != 0 ? true : z4;
        if ((i & 32) != 0) {
            z6 = true;
            secureFlagPolicy2 = secureFlagPolicy;
            z7 = z4;
            z9 = z2;
            z8 = z3;
            popupProperties = this;
            z10 = z;
        } else {
            z6 = z5;
            z7 = z4;
            z8 = z3;
            secureFlagPolicy2 = secureFlagPolicy;
            z10 = z;
            z9 = z2;
            popupProperties = this;
        }
        new PopupProperties(z10, z9, z8, secureFlagPolicy2, z7, z6);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5) {
        this(z, z2, z3, secureFlagPolicy, z4, z5, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PopupProperties(boolean r3, boolean r4, boolean r5, androidx.compose.ui.window.SecureFlagPolicy r6, boolean r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r2 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r11 = r10 & 2
            r1 = 1
            if (r11 == 0) goto L_0x000c
            r4 = r1
        L_0x000c:
            r11 = r10 & 4
            if (r11 == 0) goto L_0x0011
            r5 = r1
        L_0x0011:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x0017
            androidx.compose.ui.window.SecureFlagPolicy r6 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
        L_0x0017:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x001c
            r7 = r1
        L_0x001c:
            r11 = r10 & 32
            if (r11 == 0) goto L_0x0021
            r8 = r1
        L_0x0021:
            r10 = r10 & 64
            if (r10 == 0) goto L_0x0027
            r10 = r0
            goto L_0x0028
        L_0x0027:
            r10 = r9
        L_0x0028:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(boolean, boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PopupProperties(boolean r1, boolean r2, boolean r3, androidx.compose.ui.window.SecureFlagPolicy r4, boolean r5, boolean r6, boolean r7) {
        /*
            r0 = this;
            int r1 = androidx.compose.ui.window.AndroidPopup_androidKt.createFlags(r1, r4, r6)
            androidx.compose.ui.window.SecureFlagPolicy r6 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
            if (r4 != r6) goto L_0x000a
            r4 = 1
            goto L_0x000b
        L_0x000a:
            r4 = 0
        L_0x000b:
            r6 = r5
            r5 = r3
            r3 = r4
            r4 = r2
            r2 = r1
            r1 = r0
            r1.<init>((int) r2, (boolean) r3, (boolean) r4, (boolean) r5, (boolean) r6, (boolean) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(boolean, boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, boolean):void");
    }

    public final boolean getFocusable() {
        return (this.flags & 8) == 0;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        if (this.inheritSecurePolicy) {
            return SecureFlagPolicy.Inherit;
        }
        if ((this.flags & 8192) == 0) {
            return SecureFlagPolicy.SecureOff;
        }
        return SecureFlagPolicy.SecureOn;
    }

    public final boolean getClippingEnabled() {
        return (this.flags & 512) == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) obj;
        return this.flags == popupProperties.flags && this.inheritSecurePolicy == popupProperties.inheritSecurePolicy && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.usePlatformDefaultWidth == popupProperties.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return (((((((((this.flags * 31) + Boolean.hashCode(this.inheritSecurePolicy)) * 31) + Boolean.hashCode(this.dismissOnBackPress)) * 31) + Boolean.hashCode(this.dismissOnClickOutside)) * 31) + Boolean.hashCode(this.excludeFromSystemGesture)) * 31) + Boolean.hashCode(this.usePlatformDefaultWidth);
    }
}
