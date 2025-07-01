package androidx.compose.ui.unit;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/FontScalingLinear;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontScaling.kt */
public interface FontScalingLinear {
    float getFontScale();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontScaling.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m7231toSp0xMU5do(FontScalingLinear fontScalingLinear, float f) {
            return FontScalingLinear.super.m7229toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m7230toDpGaN1DYA(FontScalingLinear fontScalingLinear, long j) {
            return FontScalingLinear.super.m7228toDpGaN1DYA(j);
        }
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m7229toSp0xMU5do(float f) {
        return TextUnitKt.getSp(f / getFontScale());
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m7228toDpGaN1DYA(long j) {
        if (TextUnitType.m7334equalsimpl0(TextUnit.m7305getTypeUIouoOA(j), TextUnitType.Companion.m7339getSpUIouoOA())) {
            return Dp.m7111constructorimpl(TextUnit.m7306getValueimpl(j) * getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }
}
