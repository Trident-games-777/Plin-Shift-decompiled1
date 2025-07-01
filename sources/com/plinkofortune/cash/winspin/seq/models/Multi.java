package com.plinkofortune.cash.winspin.seq.models;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/plinkofortune/cash/winspin/seq/models/Multi;", "", "row", "", "score", "fallingDown", "", "<init>", "(IIZ)V", "getRow", "()I", "getScore", "getFallingDown", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Multi.kt */
public final class Multi {
    public static final int $stable = 0;
    private final boolean fallingDown;
    private final int row;
    private final int score;

    public static /* synthetic */ Multi copy$default(Multi multi, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = multi.row;
        }
        if ((i3 & 2) != 0) {
            i2 = multi.score;
        }
        if ((i3 & 4) != 0) {
            z = multi.fallingDown;
        }
        return multi.copy(i, i2, z);
    }

    public final int component1() {
        return this.row;
    }

    public final int component2() {
        return this.score;
    }

    public final boolean component3() {
        return this.fallingDown;
    }

    public final Multi copy(int i, int i2, boolean z) {
        return new Multi(i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Multi)) {
            return false;
        }
        Multi multi = (Multi) obj;
        return this.row == multi.row && this.score == multi.score && this.fallingDown == multi.fallingDown;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.row) * 31) + Integer.hashCode(this.score)) * 31) + Boolean.hashCode(this.fallingDown);
    }

    public String toString() {
        int i = this.row;
        int i2 = this.score;
        return "Multi(row=" + i + ", score=" + i2 + ", fallingDown=" + this.fallingDown + ")";
    }

    public Multi(int i, int i2, boolean z) {
        this.row = i;
        this.score = i2;
        this.fallingDown = z;
    }

    public final int getRow() {
        return this.row;
    }

    public final int getScore() {
        return this.score;
    }

    public final boolean getFallingDown() {
        return this.fallingDown;
    }
}
