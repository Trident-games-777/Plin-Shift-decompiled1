package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0006H\u0001¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidBlendMode.android.kt */
public final class AndroidBlendMode_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidBlendMode.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|61) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0118 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                android.graphics.BlendMode[] r0 = android.graphics.BlendMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.BlendMode r1 = android.graphics.BlendMode.CLEAR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SRC     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SRC_OVER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DST_OVER     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SRC_IN     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DST_IN     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SRC_OUT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DST_OUT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SRC_ATOP     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DST_ATOP     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.XOR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.PLUS     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.MODULATE     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SCREEN     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.OVERLAY     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DARKEN     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.LIGHTEN     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.COLOR_DODGE     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.COLOR_BURN     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.HARD_LIGHT     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SOFT_LIGHT     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.DIFFERENCE     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.EXCLUSION     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.MULTIPLY     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.HUE     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.SATURATION     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.COLOR     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                android.graphics.BlendMode r1 = android.graphics.BlendMode.LUMINOSITY     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidBlendMode_androidKt.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m4078isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4170getSrcOver0nO6VwU()) || m4080toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m4080toPorterDuffModes9anfk8(int i) {
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4143getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4166getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4149getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4170getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4153getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4168getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4151getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4169getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4152getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4167getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4150getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4171getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4162getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4164getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4161getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4147getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4157getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4159getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final BlendMode m4079toAndroidBlendModes9anfk8(int i) {
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4143getClear0nO6VwU())) {
            return BlendMode.CLEAR;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4166getSrc0nO6VwU())) {
            return BlendMode.SRC;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4149getDst0nO6VwU())) {
            return BlendMode.DST;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4170getSrcOver0nO6VwU())) {
            return BlendMode.SRC_OVER;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4153getDstOver0nO6VwU())) {
            return BlendMode.DST_OVER;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4168getSrcIn0nO6VwU())) {
            return BlendMode.SRC_IN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4151getDstIn0nO6VwU())) {
            return BlendMode.DST_IN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4169getSrcOut0nO6VwU())) {
            return BlendMode.SRC_OUT;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4152getDstOut0nO6VwU())) {
            return BlendMode.DST_OUT;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4167getSrcAtop0nO6VwU())) {
            return BlendMode.SRC_ATOP;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4150getDstAtop0nO6VwU())) {
            return BlendMode.DST_ATOP;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4171getXor0nO6VwU())) {
            return BlendMode.XOR;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4162getPlus0nO6VwU())) {
            return BlendMode.PLUS;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4159getModulate0nO6VwU())) {
            return BlendMode.MODULATE;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4164getScreen0nO6VwU())) {
            return BlendMode.SCREEN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4161getOverlay0nO6VwU())) {
            return BlendMode.OVERLAY;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4147getDarken0nO6VwU())) {
            return BlendMode.DARKEN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4157getLighten0nO6VwU())) {
            return BlendMode.LIGHTEN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4146getColorDodge0nO6VwU())) {
            return BlendMode.COLOR_DODGE;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4145getColorBurn0nO6VwU())) {
            return BlendMode.COLOR_BURN;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4155getHardlight0nO6VwU())) {
            return BlendMode.HARD_LIGHT;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4165getSoftlight0nO6VwU())) {
            return BlendMode.SOFT_LIGHT;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4148getDifference0nO6VwU())) {
            return BlendMode.DIFFERENCE;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4154getExclusion0nO6VwU())) {
            return BlendMode.EXCLUSION;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4160getMultiply0nO6VwU())) {
            return BlendMode.MULTIPLY;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4156getHue0nO6VwU())) {
            return BlendMode.HUE;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4163getSaturation0nO6VwU())) {
            return BlendMode.SATURATION;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4144getColor0nO6VwU())) {
            return BlendMode.COLOR;
        }
        if (BlendMode.m4139equalsimpl0(i, BlendMode.Companion.m4158getLuminosity0nO6VwU())) {
            return BlendMode.LUMINOSITY;
        }
        return BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.Companion.m4143getClear0nO6VwU();
            case 2:
                return BlendMode.Companion.m4166getSrc0nO6VwU();
            case 3:
                return BlendMode.Companion.m4149getDst0nO6VwU();
            case 4:
                return BlendMode.Companion.m4170getSrcOver0nO6VwU();
            case 5:
                return BlendMode.Companion.m4153getDstOver0nO6VwU();
            case 6:
                return BlendMode.Companion.m4168getSrcIn0nO6VwU();
            case 7:
                return BlendMode.Companion.m4151getDstIn0nO6VwU();
            case 8:
                return BlendMode.Companion.m4169getSrcOut0nO6VwU();
            case 9:
                return BlendMode.Companion.m4152getDstOut0nO6VwU();
            case 10:
                return BlendMode.Companion.m4167getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.Companion.m4150getDstAtop0nO6VwU();
            case 12:
                return BlendMode.Companion.m4171getXor0nO6VwU();
            case 13:
                return BlendMode.Companion.m4162getPlus0nO6VwU();
            case 14:
                return BlendMode.Companion.m4159getModulate0nO6VwU();
            case 15:
                return BlendMode.Companion.m4164getScreen0nO6VwU();
            case 16:
                return BlendMode.Companion.m4161getOverlay0nO6VwU();
            case 17:
                return BlendMode.Companion.m4147getDarken0nO6VwU();
            case 18:
                return BlendMode.Companion.m4157getLighten0nO6VwU();
            case 19:
                return BlendMode.Companion.m4146getColorDodge0nO6VwU();
            case 20:
                return BlendMode.Companion.m4145getColorBurn0nO6VwU();
            case 21:
                return BlendMode.Companion.m4155getHardlight0nO6VwU();
            case 22:
                return BlendMode.Companion.m4165getSoftlight0nO6VwU();
            case 23:
                return BlendMode.Companion.m4148getDifference0nO6VwU();
            case 24:
                return BlendMode.Companion.m4154getExclusion0nO6VwU();
            case 25:
                return BlendMode.Companion.m4160getMultiply0nO6VwU();
            case 26:
                return BlendMode.Companion.m4156getHue0nO6VwU();
            case 27:
                return BlendMode.Companion.m4163getSaturation0nO6VwU();
            case 28:
                return BlendMode.Companion.m4144getColor0nO6VwU();
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /*29*/:
                return BlendMode.Companion.m4158getLuminosity0nO6VwU();
            default:
                return BlendMode.Companion.m4170getSrcOver0nO6VwU();
        }
    }
}
