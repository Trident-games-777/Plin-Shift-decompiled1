package com.plinkofortune.cash.winspin.seq;

import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.seq.models.BallInScreen;
import com.plinkofortune.cash.winspin.seq.models.Multi;
import com.plinkofortune.cash.winspin.seq.models.SeqBall;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001cJr\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/plinkofortune/cash/winspin/seq/SeqState;", "", "round", "", "time", "stars", "score", "ballsInScreen", "", "Lcom/plinkofortune/cash/winspin/seq/models/BallInScreen;", "multis", "Lcom/plinkofortune/cash/winspin/seq/models/Multi;", "seqBalls", "Lcom/plinkofortune/cash/winspin/seq/models/SeqBall;", "win", "", "<init>", "(IIIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getRound", "()I", "getTime", "getStars", "getScore", "getBallsInScreen", "()Ljava/util/List;", "getMultis", "getSeqBalls", "getWin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IIIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/plinkofortune/cash/winspin/seq/SeqState;", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqState.kt */
public final class SeqState {
    public static final int $stable = 8;
    private final List<BallInScreen> ballsInScreen;
    private final List<Multi> multis;
    private final int round;
    private final int score;
    private final List<SeqBall> seqBalls;
    private final int stars;
    private final int time;
    private final Boolean win;

    public static /* synthetic */ SeqState copy$default(SeqState seqState, int i, int i2, int i3, int i4, List<BallInScreen> list, List<Multi> list2, List<SeqBall> list3, Boolean bool, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = seqState.round;
        }
        if ((i5 & 2) != 0) {
            i2 = seqState.time;
        }
        if ((i5 & 4) != 0) {
            i3 = seqState.stars;
        }
        if ((i5 & 8) != 0) {
            i4 = seqState.score;
        }
        if ((i5 & 16) != 0) {
            list = seqState.ballsInScreen;
        }
        if ((i5 & 32) != 0) {
            list2 = seqState.multis;
        }
        if ((i5 & 64) != 0) {
            list3 = seqState.seqBalls;
        }
        if ((i5 & 128) != 0) {
            bool = seqState.win;
        }
        List<SeqBall> list4 = list3;
        Boolean bool2 = bool;
        List<BallInScreen> list5 = list;
        List<Multi> list6 = list2;
        int i6 = i4;
        int i7 = i2;
        return seqState.copy(i, i7, i3, i6, list5, list6, list4, bool2);
    }

    public final int component1() {
        return this.round;
    }

    public final int component2() {
        return this.time;
    }

    public final int component3() {
        return this.stars;
    }

    public final int component4() {
        return this.score;
    }

    public final List<BallInScreen> component5() {
        return this.ballsInScreen;
    }

    public final List<Multi> component6() {
        return this.multis;
    }

    public final List<SeqBall> component7() {
        return this.seqBalls;
    }

    public final Boolean component8() {
        return this.win;
    }

    public final SeqState copy(int i, int i2, int i3, int i4, List<BallInScreen> list, List<Multi> list2, List<SeqBall> list3, Boolean bool) {
        List<BallInScreen> list4 = list;
        Intrinsics.checkNotNullParameter(list4, StringFog.decrypt(new byte[]{107, 45, -95, -108, -101, -38, 2, -111, 106, 62, -88, -99, -122}, new byte[]{9, 76, -51, -8, -24, -109, 108, -62}));
        List<Multi> list5 = list2;
        Intrinsics.checkNotNullParameter(list5, StringFog.decrypt(new byte[]{-10, -31, -80, -4, 48, Ascii.SI}, new byte[]{-101, -108, -36, -120, 89, 124, -81, 44}));
        List<SeqBall> list6 = list3;
        Intrinsics.checkNotNullParameter(list6, StringFog.decrypt(new byte[]{117, -68, -110, 40, -79, -11, 32, -59}, new byte[]{6, -39, -29, 106, -48, -103, 76, -74}));
        return new SeqState(i, i2, i3, i4, list4, list5, list6, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeqState)) {
            return false;
        }
        SeqState seqState = (SeqState) obj;
        return this.round == seqState.round && this.time == seqState.time && this.stars == seqState.stars && this.score == seqState.score && Intrinsics.areEqual((Object) this.ballsInScreen, (Object) seqState.ballsInScreen) && Intrinsics.areEqual((Object) this.multis, (Object) seqState.multis) && Intrinsics.areEqual((Object) this.seqBalls, (Object) seqState.seqBalls) && Intrinsics.areEqual((Object) this.win, (Object) seqState.win);
    }

    public int hashCode() {
        int hashCode = ((((((((((((Integer.hashCode(this.round) * 31) + Integer.hashCode(this.time)) * 31) + Integer.hashCode(this.stars)) * 31) + Integer.hashCode(this.score)) * 31) + this.ballsInScreen.hashCode()) * 31) + this.multis.hashCode()) * 31) + this.seqBalls.hashCode()) * 31;
        Boolean bool = this.win;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        int i = this.round;
        int i2 = this.time;
        int i3 = this.stars;
        int i4 = this.score;
        List<BallInScreen> list = this.ballsInScreen;
        List<Multi> list2 = this.multis;
        List<SeqBall> list3 = this.seqBalls;
        return "SeqState(round=" + i + ", time=" + i2 + ", stars=" + i3 + ", score=" + i4 + ", ballsInScreen=" + list + ", multis=" + list2 + ", seqBalls=" + list3 + ", win=" + this.win + ")";
    }

    public SeqState(int i, int i2, int i3, int i4, List<BallInScreen> list, List<Multi> list2, List<SeqBall> list3, Boolean bool) {
        Intrinsics.checkNotNullParameter(list, StringFog.decrypt(new byte[]{-16, -65, -63, 52, 101, -30, Utf8.REPLACEMENT_BYTE, -10, -15, -84, -56, Base64.padSymbol, 120}, new byte[]{-110, -34, -83, 88, Ascii.SYN, -85, 81, -91}));
        Intrinsics.checkNotNullParameter(list2, StringFog.decrypt(new byte[]{118, 110, -91, -15, -91, Ascii.NAK}, new byte[]{Ascii.ESC, Ascii.ESC, -55, -123, -52, 102, 85, -20}));
        Intrinsics.checkNotNullParameter(list3, StringFog.decrypt(new byte[]{Ascii.SYN, -59, -101, 113, -126, 49, 7, 42}, new byte[]{101, -96, -22, 51, -29, 93, 107, 89}));
        this.round = i;
        this.time = i2;
        this.stars = i3;
        this.score = i4;
        this.ballsInScreen = list;
        this.multis = list2;
        this.seqBalls = list3;
        this.win = bool;
    }

    public final int getRound() {
        return this.round;
    }

    public final int getTime() {
        return this.time;
    }

    public final int getStars() {
        return this.stars;
    }

    public final int getScore() {
        return this.score;
    }

    public final List<BallInScreen> getBallsInScreen() {
        return this.ballsInScreen;
    }

    public final List<Multi> getMultis() {
        return this.multis;
    }

    public final List<SeqBall> getSeqBalls() {
        return this.seqBalls;
    }

    public final Boolean getWin() {
        return this.win;
    }
}
