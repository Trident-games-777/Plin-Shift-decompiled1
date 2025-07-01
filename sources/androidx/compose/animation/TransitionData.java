package androidx.compose.animation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "scale", "Landroidx/compose/animation/Scale;", "hold", "", "effectsMap", "", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;ZLjava/util/Map;)V", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getEffectsMap", "()Ljava/util/Map;", "getFade", "()Landroidx/compose/animation/Fade;", "getHold", "()Z", "getScale", "()Landroidx/compose/animation/Scale;", "getSlide", "()Landroidx/compose/animation/Slide;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
public final class TransitionData {
    public static final int $stable = 0;
    private final ChangeSize changeSize;
    private final Map<TransitionEffectKey<?>, TransitionEffect> effectsMap;
    private final Fade fade;
    private final boolean hold;
    private final Scale scale;
    private final Slide slide;

    public TransitionData() {
        this((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, false, (Map) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TransitionData copy$default(TransitionData transitionData, Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, boolean z, Map<TransitionEffectKey<?>, TransitionEffect> map, int i, Object obj) {
        if ((i & 1) != 0) {
            fade2 = transitionData.fade;
        }
        if ((i & 2) != 0) {
            slide2 = transitionData.slide;
        }
        if ((i & 4) != 0) {
            changeSize2 = transitionData.changeSize;
        }
        if ((i & 8) != 0) {
            scale2 = transitionData.scale;
        }
        if ((i & 16) != 0) {
            z = transitionData.hold;
        }
        if ((i & 32) != 0) {
            map = transitionData.effectsMap;
        }
        boolean z2 = z;
        Map<TransitionEffectKey<?>, TransitionEffect> map2 = map;
        Scale scale3 = scale2;
        Slide slide3 = slide2;
        return transitionData.copy(fade2, slide3, changeSize2, scale3, z2, map2);
    }

    public final Fade component1() {
        return this.fade;
    }

    public final Slide component2() {
        return this.slide;
    }

    public final ChangeSize component3() {
        return this.changeSize;
    }

    public final Scale component4() {
        return this.scale;
    }

    public final boolean component5() {
        return this.hold;
    }

    public final Map<TransitionEffectKey<?>, TransitionEffect> component6() {
        return this.effectsMap;
    }

    public final TransitionData copy(Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, boolean z, Map<TransitionEffectKey<?>, ? extends TransitionEffect> map) {
        return new TransitionData(fade2, slide2, changeSize2, scale2, z, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransitionData)) {
            return false;
        }
        TransitionData transitionData = (TransitionData) obj;
        return Intrinsics.areEqual((Object) this.fade, (Object) transitionData.fade) && Intrinsics.areEqual((Object) this.slide, (Object) transitionData.slide) && Intrinsics.areEqual((Object) this.changeSize, (Object) transitionData.changeSize) && Intrinsics.areEqual((Object) this.scale, (Object) transitionData.scale) && this.hold == transitionData.hold && Intrinsics.areEqual((Object) this.effectsMap, (Object) transitionData.effectsMap);
    }

    public int hashCode() {
        Fade fade2 = this.fade;
        int i = 0;
        int hashCode = (fade2 == null ? 0 : fade2.hashCode()) * 31;
        Slide slide2 = this.slide;
        int hashCode2 = (hashCode + (slide2 == null ? 0 : slide2.hashCode())) * 31;
        ChangeSize changeSize2 = this.changeSize;
        int hashCode3 = (hashCode2 + (changeSize2 == null ? 0 : changeSize2.hashCode())) * 31;
        Scale scale2 = this.scale;
        if (scale2 != null) {
            i = scale2.hashCode();
        }
        return ((((hashCode3 + i) * 31) + Boolean.hashCode(this.hold)) * 31) + this.effectsMap.hashCode();
    }

    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + ')';
    }

    public TransitionData(Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, boolean z, Map<TransitionEffectKey<?>, ? extends TransitionEffect> map) {
        this.fade = fade2;
        this.slide = slide2;
        this.changeSize = changeSize2;
        this.scale = scale2;
        this.hold = z;
        this.effectsMap = map;
    }

    public final Fade getFade() {
        return this.fade;
    }

    public final Slide getSlide() {
        return this.slide;
    }

    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final boolean getHold() {
        return this.hold;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TransitionData(androidx.compose.animation.Fade r2, androidx.compose.animation.Slide r3, androidx.compose.animation.ChangeSize r4, androidx.compose.animation.Scale r5, boolean r6, java.util.Map r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            r0 = 0
            if (r9 == 0) goto L_0x0006
            r2 = r0
        L_0x0006:
            r9 = r8 & 2
            if (r9 == 0) goto L_0x000b
            r3 = r0
        L_0x000b:
            r9 = r8 & 4
            if (r9 == 0) goto L_0x0010
            r4 = r0
        L_0x0010:
            r9 = r8 & 8
            if (r9 == 0) goto L_0x0015
            r5 = r0
        L_0x0015:
            r9 = r8 & 16
            if (r9 == 0) goto L_0x001a
            r6 = 0
        L_0x001a:
            r8 = r8 & 32
            if (r8 == 0) goto L_0x0022
            java.util.Map r7 = kotlin.collections.MapsKt.emptyMap()
        L_0x0022:
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.TransitionData.<init>(androidx.compose.animation.Fade, androidx.compose.animation.Slide, androidx.compose.animation.ChangeSize, androidx.compose.animation.Scale, boolean, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<TransitionEffectKey<?>, TransitionEffect> getEffectsMap() {
        return this.effectsMap;
    }
}
