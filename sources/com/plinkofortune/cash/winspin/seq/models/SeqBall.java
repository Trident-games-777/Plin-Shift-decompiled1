package com.plinkofortune.cash.winspin.seq.models;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/plinkofortune/cash/winspin/seq/models/SeqBall;", "", "resource", "", "catch", "", "<init>", "(IZ)V", "getResource", "()I", "getCatch", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqBall.kt */
public final class SeqBall {
    public static final int $stable = 0;

    /* renamed from: catch  reason: not valid java name */
    private final boolean f72catch;
    private final int resource;

    public static /* synthetic */ SeqBall copy$default(SeqBall seqBall, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = seqBall.resource;
        }
        if ((i2 & 2) != 0) {
            z = seqBall.f72catch;
        }
        return seqBall.copy(i, z);
    }

    public final int component1() {
        return this.resource;
    }

    public final boolean component2() {
        return this.f72catch;
    }

    public final SeqBall copy(int i, boolean z) {
        return new SeqBall(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeqBall)) {
            return false;
        }
        SeqBall seqBall = (SeqBall) obj;
        return this.resource == seqBall.resource && this.f72catch == seqBall.f72catch;
    }

    public int hashCode() {
        return (Integer.hashCode(this.resource) * 31) + Boolean.hashCode(this.f72catch);
    }

    public String toString() {
        int i = this.resource;
        return "SeqBall(resource=" + i + ", catch=" + this.f72catch + ")";
    }

    public SeqBall(int i, boolean z) {
        this.resource = i;
        this.f72catch = z;
    }

    public final int getResource() {
        return this.resource;
    }

    public final boolean getCatch() {
        return this.f72catch;
    }
}
