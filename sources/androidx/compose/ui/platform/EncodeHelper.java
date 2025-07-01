package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import com.google.common.base.Ascii;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidClipboardManager.android.kt */
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(SpanStyle spanStyle) {
        if (!Color.m4240equalsimpl0(spanStyle.m6514getColor0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m6280encode8_81llA(spanStyle.m6514getColor0d7_KjU());
        }
        if (!TextUnit.m7303equalsimpl0(spanStyle.m6515getFontSizeXSAIIZE(), TextUnit.Companion.m7317getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m6277encodeR2X_6o(spanStyle.m6515getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle r0 = spanStyle.m6516getFontStyle4Lr2A7w();
        if (r0 != null) {
            int r02 = r0.m6681unboximpl();
            encode((byte) 4);
            m6282encodenzbMABs(r02);
        }
        FontSynthesis r03 = spanStyle.m6517getFontSynthesisZQGJjVo();
        if (r03 != null) {
            int r04 = r03.m6694unboximpl();
            encode((byte) 5);
            m6279encode6p3vJLY(r04);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m7303equalsimpl0(spanStyle.m6518getLetterSpacingXSAIIZE(), TextUnit.Companion.m7317getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m6277encodeR2X_6o(spanStyle.m6518getLetterSpacingXSAIIZE());
        }
        BaselineShift r05 = spanStyle.m6513getBaselineShift5SSeXJ0();
        if (r05 != null) {
            float r06 = r05.m6875unboximpl();
            encode((byte) 8);
            m6278encode4Dl_Bck(r06);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m4240equalsimpl0(spanStyle.m6512getBackground0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m6280encode8_81llA(spanStyle.m6512getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) Ascii.VT);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) Ascii.FF);
            encode(shadow);
        }
    }

    /* renamed from: encode-8_81llA  reason: not valid java name */
    public final void m6280encode8_81llA(long j) {
        m6281encodeVKZWuLQ(j);
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m6277encodeR2X_6o(long j) {
        long r0 = TextUnit.m7305getTypeUIouoOA(j);
        byte b = 0;
        if (!TextUnitType.m7334equalsimpl0(r0, TextUnitType.Companion.m7340getUnspecifiedUIouoOA())) {
            if (TextUnitType.m7334equalsimpl0(r0, TextUnitType.Companion.m7339getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m7334equalsimpl0(r0, TextUnitType.Companion.m7338getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (!TextUnitType.m7334equalsimpl0(TextUnit.m7305getTypeUIouoOA(j), TextUnitType.Companion.m7340getUnspecifiedUIouoOA())) {
            encode(TextUnit.m7306getValueimpl(j));
        }
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m6282encodenzbMABs(int i) {
        byte b = 0;
        if (!FontStyle.m6678equalsimpl0(i, FontStyle.Companion.m6685getNormal_LCdwA()) && FontStyle.m6678equalsimpl0(i, FontStyle.Companion.m6684getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m6279encode6p3vJLY(int i) {
        byte b = 0;
        if (!FontSynthesis.m6689equalsimpl0(i, FontSynthesis.Companion.m6696getNoneGVVA2EU())) {
            if (FontSynthesis.m6689equalsimpl0(i, FontSynthesis.Companion.m6695getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m6689equalsimpl0(i, FontSynthesis.Companion.m6698getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m6689equalsimpl0(i, FontSynthesis.Companion.m6697getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m6278encode4Dl_Bck(float f) {
        encode(f);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m6280encode8_81llA(shadow.m4603getColor0d7_KjU());
        encode(Offset.m3987getXimpl(shadow.m4604getOffsetF1C5BW0()));
        encode(Offset.m3988getYimpl(shadow.m4604getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* renamed from: encode-VKZWuLQ  reason: not valid java name */
    public final void m6281encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(String str) {
        this.parcel.writeString(str);
    }
}
