package com.plinkofortune.cash.winspin.rounds;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/plinkofortune/cash/winspin/rounds/RoundModel;", "", "num", "", "stars", "unlocked", "", "<init>", "(IIZ)V", "getNum", "()I", "getStars", "getUnlocked", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RoundModel.kt */
public final class RoundModel {
    public static final int $stable = 0;
    private final int num;
    private final int stars;
    private final boolean unlocked;

    public static /* synthetic */ RoundModel copy$default(RoundModel roundModel, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = roundModel.num;
        }
        if ((i3 & 2) != 0) {
            i2 = roundModel.stars;
        }
        if ((i3 & 4) != 0) {
            z = roundModel.unlocked;
        }
        return roundModel.copy(i, i2, z);
    }

    public final int component1() {
        return this.num;
    }

    public final int component2() {
        return this.stars;
    }

    public final boolean component3() {
        return this.unlocked;
    }

    public final RoundModel copy(int i, int i2, boolean z) {
        return new RoundModel(i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundModel)) {
            return false;
        }
        RoundModel roundModel = (RoundModel) obj;
        return this.num == roundModel.num && this.stars == roundModel.stars && this.unlocked == roundModel.unlocked;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.num) * 31) + Integer.hashCode(this.stars)) * 31) + Boolean.hashCode(this.unlocked);
    }

    public String toString() {
        int i = this.num;
        int i2 = this.stars;
        return "RoundModel(num=" + i + ", stars=" + i2 + ", unlocked=" + this.unlocked + ")";
    }

    public RoundModel(int i, int i2, boolean z) {
        this.num = i;
        this.stars = i2;
        this.unlocked = z;
    }

    public final int getNum() {
        return this.num;
    }

    public final int getStars() {
        return this.stars;
    }

    public final boolean getUnlocked() {
        return this.unlocked;
    }
}
