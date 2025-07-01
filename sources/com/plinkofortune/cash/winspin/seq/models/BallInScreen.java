package com.plinkofortune.cash.winspin.seq.models;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/plinkofortune/cash/winspin/seq/models/BallInScreen;", "", "fallingDown", "", "finished", "row", "", "resource", "right", "<init>", "(ZZIIZ)V", "getFallingDown", "()Z", "getFinished", "getRow", "()I", "getResource", "getRight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: BallInScreen.kt */
public final class BallInScreen {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static String ball = StringFog.decrypt(new byte[]{-110, 88, 32, -43, 91, Ascii.SYN, -96, -54, -118, SignedBytes.MAX_POWER_OF_TWO, Base64.padSymbol, -53, 91, 68, -26, -125, -114, 2, 32, -54, 76, 77, -10, -54}, new byte[]{-6, 44, 84, -91, 40, 44, -113, -27});
    private final boolean fallingDown;
    private final boolean finished;
    private final int resource;
    private final boolean right;
    private final int row;

    public static /* synthetic */ BallInScreen copy$default(BallInScreen ballInScreen, boolean z, boolean z2, int i, int i2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = ballInScreen.fallingDown;
        }
        if ((i3 & 2) != 0) {
            z2 = ballInScreen.finished;
        }
        if ((i3 & 4) != 0) {
            i = ballInScreen.row;
        }
        if ((i3 & 8) != 0) {
            i2 = ballInScreen.resource;
        }
        if ((i3 & 16) != 0) {
            z3 = ballInScreen.right;
        }
        int i4 = i2;
        boolean z4 = z3;
        return ballInScreen.copy(z, z2, i, i4, z4);
    }

    public final boolean component1() {
        return this.fallingDown;
    }

    public final boolean component2() {
        return this.finished;
    }

    public final int component3() {
        return this.row;
    }

    public final int component4() {
        return this.resource;
    }

    public final boolean component5() {
        return this.right;
    }

    public final BallInScreen copy(boolean z, boolean z2, int i, int i2, boolean z3) {
        return new BallInScreen(z, z2, i, i2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BallInScreen)) {
            return false;
        }
        BallInScreen ballInScreen = (BallInScreen) obj;
        return this.fallingDown == ballInScreen.fallingDown && this.finished == ballInScreen.finished && this.row == ballInScreen.row && this.resource == ballInScreen.resource && this.right == ballInScreen.right;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.fallingDown) * 31) + Boolean.hashCode(this.finished)) * 31) + Integer.hashCode(this.row)) * 31) + Integer.hashCode(this.resource)) * 31) + Boolean.hashCode(this.right);
    }

    public String toString() {
        boolean z = this.fallingDown;
        boolean z2 = this.finished;
        int i = this.row;
        int i2 = this.resource;
        return "BallInScreen(fallingDown=" + z + ", finished=" + z2 + ", row=" + i + ", resource=" + i2 + ", right=" + this.right + ")";
    }

    public BallInScreen(boolean z, boolean z2, int i, int i2, boolean z3) {
        this.fallingDown = z;
        this.finished = z2;
        this.row = i;
        this.resource = i2;
        this.right = z3;
    }

    public final boolean getFallingDown() {
        return this.fallingDown;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final int getRow() {
        return this.row;
    }

    public final int getResource() {
        return this.resource;
    }

    public final boolean getRight() {
        return this.right;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/plinkofortune/cash/winspin/seq/models/BallInScreen$Companion;", "", "<init>", "()V", "ball", "", "getBall", "()Ljava/lang/String;", "setBall", "(Ljava/lang/String;)V", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BallInScreen.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getBall() {
            return BallInScreen.ball;
        }

        public final void setBall(String str) {
            Intrinsics.checkNotNullParameter(str, StringFog.decrypt(new byte[]{-35, Ascii.NAK, 19, -36, -87, 45, 74}, new byte[]{-31, 102, 118, -88, -124, Ascii.DC2, 116, -33}));
            BallInScreen.ball = str;
        }
    }
}
