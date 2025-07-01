package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0015\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0013\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0018J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"J\n\u0010#\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0013\u0010(\u001a\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u0012J\u0015\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", "", "string", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "dataAvailable", "", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeByte", "", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeFloat", "", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeInt", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeString", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidClipboardManager.android.kt */
public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel obtain = Parcel.obtain();
        this.parcel = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle = new MutableSpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16383, (DefaultConstructorMarker) null);
        while (this.parcel.dataAvail() > 1) {
            byte decodeByte = decodeByte();
            if (decodeByte != 1) {
                if (decodeByte != 2) {
                    if (decodeByte != 3) {
                        if (decodeByte != 4) {
                            if (decodeByte != 5) {
                                if (decodeByte != 6) {
                                    if (decodeByte != 7) {
                                        if (decodeByte != 8) {
                                            if (decodeByte != 9) {
                                                if (decodeByte != 10) {
                                                    if (decodeByte != 11) {
                                                        if (decodeByte == 12) {
                                                            if (dataAvailable() < 20) {
                                                                break;
                                                            }
                                                            mutableSpanStyle.setShadow(decodeShadow());
                                                        } else {
                                                            continue;
                                                        }
                                                    } else if (dataAvailable() < 4) {
                                                        break;
                                                    } else {
                                                        mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                                    }
                                                } else if (dataAvailable() < 8) {
                                                    break;
                                                } else {
                                                    mutableSpanStyle.m6302setBackground8_81llA(m6265decodeColor0d7_KjU());
                                                }
                                            } else if (dataAvailable() < 8) {
                                                break;
                                            } else {
                                                mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                            }
                                        } else if (dataAvailable() < 4) {
                                            break;
                                        } else {
                                            mutableSpanStyle.m6303setBaselineShift_isdbwI(BaselineShift.m6869boximpl(m6263decodeBaselineShifty9eOQZs()));
                                        }
                                    } else if (dataAvailable() < 5) {
                                        break;
                                    } else {
                                        mutableSpanStyle.m6308setLetterSpacingR2X_6o(m6268decodeTextUnitXSAIIZE());
                                    }
                                } else {
                                    mutableSpanStyle.setFontFeatureSettings(decodeString());
                                }
                            } else if (dataAvailable() < 1) {
                                break;
                            } else {
                                mutableSpanStyle.m6307setFontSynthesistDdu0R4(FontSynthesis.m6686boximpl(m6267decodeFontSynthesisGVVA2EU()));
                            }
                        } else if (dataAvailable() < 1) {
                            break;
                        } else {
                            mutableSpanStyle.m6306setFontStylemLjRB2g(FontStyle.m6675boximpl(m6266decodeFontStyle_LCdwA()));
                        }
                    } else if (dataAvailable() < 4) {
                        break;
                    } else {
                        mutableSpanStyle.setFontWeight(decodeFontWeight());
                    }
                } else if (dataAvailable() < 5) {
                    break;
                } else {
                    mutableSpanStyle.m6305setFontSizeR2X_6o(m6268decodeTextUnitXSAIIZE());
                }
            } else if (dataAvailable() < 8) {
                break;
            } else {
                mutableSpanStyle.m6304setColor8_81llA(m6265decodeColor0d7_KjU());
            }
        }
        return mutableSpanStyle.toSpanStyle();
    }

    /* renamed from: decodeColor-0d7_KjU  reason: not valid java name */
    public final long m6265decodeColor0d7_KjU() {
        return Color.m4235constructorimpl(m6264decodeULongsVKNKU());
    }

    /* renamed from: decodeTextUnit-XSAIIZE  reason: not valid java name */
    public final long m6268decodeTextUnitXSAIIZE() {
        long j;
        byte decodeByte = decodeByte();
        if (decodeByte == 1) {
            j = TextUnitType.Companion.m7339getSpUIouoOA();
        } else if (decodeByte == 2) {
            j = TextUnitType.Companion.m7338getEmUIouoOA();
        } else {
            j = TextUnitType.Companion.m7340getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m7334equalsimpl0(j, TextUnitType.Companion.m7340getUnspecifiedUIouoOA())) {
            return TextUnit.Companion.m7317getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m7318TextUnitanM5pPY(decodeFloat(), j);
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* renamed from: decodeFontStyle-_-LCdwA  reason: not valid java name */
    public final int m6266decodeFontStyle_LCdwA() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontStyle.Companion.m6685getNormal_LCdwA();
        }
        if (decodeByte == 1) {
            return FontStyle.Companion.m6684getItalic_LCdwA();
        }
        return FontStyle.Companion.m6685getNormal_LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU  reason: not valid java name */
    public final int m6267decodeFontSynthesisGVVA2EU() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontSynthesis.Companion.m6696getNoneGVVA2EU();
        }
        if (decodeByte == 1) {
            return FontSynthesis.Companion.m6695getAllGVVA2EU();
        }
        if (decodeByte == 3) {
            return FontSynthesis.Companion.m6697getStyleGVVA2EU();
        }
        if (decodeByte == 2) {
            return FontSynthesis.Companion.m6698getWeightGVVA2EU();
        }
        return FontSynthesis.Companion.m6696getNoneGVVA2EU();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs  reason: not valid java name */
    private final float m6263decodeBaselineShifty9eOQZs() {
        return BaselineShift.m6870constructorimpl(decodeFloat());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        int decodeInt = decodeInt();
        boolean z = (TextDecoration.Companion.getLineThrough().getMask() & decodeInt) != 0;
        boolean z2 = (decodeInt & TextDecoration.Companion.getUnderline().getMask()) != 0;
        if (z && z2) {
            return TextDecoration.Companion.combine(CollectionsKt.listOf(TextDecoration.Companion.getLineThrough(), TextDecoration.Companion.getUnderline()));
        } else if (z) {
            return TextDecoration.Companion.getLineThrough();
        } else {
            if (z2) {
                return TextDecoration.Companion.getUnderline();
            }
            return TextDecoration.Companion.getNone();
        }
    }

    private final Shadow decodeShadow() {
        return new Shadow(m6265decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), (DefaultConstructorMarker) null);
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    /* renamed from: decodeULong-s-VKNKU  reason: not valid java name */
    private final long m6264decodeULongsVKNKU() {
        return ULong.m7997constructorimpl(this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }
}
