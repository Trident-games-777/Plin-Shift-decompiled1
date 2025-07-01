package com.plinkofortune.cash.winspin.leader;

import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/plinkofortune/cash/winspin/leader/LeaderModel;", "", "num", "", "name", "", "score", "<init>", "(ILjava/lang/String;I)V", "getNum", "()I", "getName", "()Ljava/lang/String;", "getScore", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LeaderModel.kt */
public final class LeaderModel {
    public static final int $stable = 0;
    private final String name;
    private final int num;
    private final int score;

    public static /* synthetic */ LeaderModel copy$default(LeaderModel leaderModel, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = leaderModel.num;
        }
        if ((i3 & 2) != 0) {
            str = leaderModel.name;
        }
        if ((i3 & 4) != 0) {
            i2 = leaderModel.score;
        }
        return leaderModel.copy(i, str, i2);
    }

    public final int component1() {
        return this.num;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.score;
    }

    public final LeaderModel copy(int i, String str, int i2) {
        Intrinsics.checkNotNullParameter(str, StringFog.decrypt(new byte[]{-110, -61, 82, 120}, new byte[]{-4, -94, Utf8.REPLACEMENT_BYTE, Ascii.GS, 71, -83, -127, 44}));
        return new LeaderModel(i, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeaderModel)) {
            return false;
        }
        LeaderModel leaderModel = (LeaderModel) obj;
        return this.num == leaderModel.num && Intrinsics.areEqual((Object) this.name, (Object) leaderModel.name) && this.score == leaderModel.score;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.num) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.score);
    }

    public String toString() {
        int i = this.num;
        String str = this.name;
        return "LeaderModel(num=" + i + ", name=" + str + ", score=" + this.score + ")";
    }

    public LeaderModel(int i, String str, int i2) {
        Intrinsics.checkNotNullParameter(str, StringFog.decrypt(new byte[]{107, 105, -75, -97}, new byte[]{5, 8, -40, -6, -89, 48, -21, 101}));
        this.num = i;
        this.name = str;
        this.score = i2;
    }

    public final int getNum() {
        return this.num;
    }

    public final String getName() {
        return this.name;
    }

    public final int getScore() {
        return this.score;
    }
}
