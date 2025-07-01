package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002JU\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016J\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J¢\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0016\u0010&\u001a\u00020\u000e*\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\nH&J\f\u0010'\u001a\u00020\u000e*\u00020\u000eH\u0007J(\u0010'\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\b*\u0010+R\u0018\u0010\u0003\u001a\u00020\u0004X \u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001,\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "()V", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "getAnchorType-Mg6Rgbw$material3_release", "()Ljava/lang/String;", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "matchTextFieldWidth", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "exposedDropdownSize", "menuAnchor", "type", "enabled", "menuAnchor-fsE2BvY", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public /* synthetic */ ExposedDropdownMenuBoxScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    /* renamed from: getAnchorType-Mg6Rgbw$material3_release  reason: not valid java name */
    public abstract String m2053getAnchorTypeMg6Rgbw$material3_release();

    /* renamed from: menuAnchor-fsE2BvY  reason: not valid java name */
    public abstract Modifier m2054menuAnchorfsE2BvY(Modifier modifier, String str, boolean z);

    private ExposedDropdownMenuBoxScope() {
    }

    /* renamed from: menuAnchor-fsE2BvY$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2050menuAnchorfsE2BvY$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.m2054menuAnchorfsE2BvY(modifier, str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-fsE2BvY");
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011d  */
    /* renamed from: ExposedDropdownMenu-vNxi1II  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2052ExposedDropdownMenuvNxi1II(boolean r37, kotlin.jvm.functions.Function0<kotlin.Unit> r38, androidx.compose.ui.Modifier r39, androidx.compose.foundation.ScrollState r40, boolean r41, androidx.compose.ui.graphics.Shape r42, long r43, float r45, float r46, androidx.compose.foundation.BorderStroke r47, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, int r50, int r51, int r52) {
        /*
            r36 = this;
            r2 = r37
            r14 = r50
            r0 = r52
            r1 = 720925481(0x2af87329, float:4.4133558E-13)
            r3 = r49
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r1)
            java.lang.String r4 = "C(ExposedDropdownMenu)P(3,6,5,7,4,9,1:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp)336@15550L21,338@15654L5,339@15706L14,347@16155L53,348@16238L7,349@16281L7,350@16332L10,357@16596L42,361@16795L51,363@16903L486,377@17583L27,378@17626L587,374@17403L810:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r0 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r14 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r14 & 6
            if (r4 != 0) goto L_0x002a
            boolean r4 = r3.changed((boolean) r2)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r14
            goto L_0x002b
        L_0x002a:
            r4 = r14
        L_0x002b:
            r7 = r0 & 2
            if (r7 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r14 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r38
            boolean r10 = r3.changedInstance(r7)
            if (r10 == 0) goto L_0x0041
            r10 = 32
            goto L_0x0043
        L_0x0041:
            r10 = 16
        L_0x0043:
            r4 = r4 | r10
            goto L_0x0047
        L_0x0045:
            r7 = r38
        L_0x0047:
            r10 = r0 & 4
            if (r10 == 0) goto L_0x004e
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r11 = r14 & 384(0x180, float:5.38E-43)
            if (r11 != 0) goto L_0x0061
            r11 = r39
            boolean r12 = r3.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x005d
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r12 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r4 = r4 | r12
            goto L_0x0063
        L_0x0061:
            r11 = r39
        L_0x0063:
            r12 = r14 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007c
            r12 = r0 & 8
            if (r12 != 0) goto L_0x0076
            r12 = r40
            boolean r13 = r3.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0078
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r12 = r40
        L_0x0078:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r13
            goto L_0x007e
        L_0x007c:
            r12 = r40
        L_0x007e:
            r13 = r0 & 16
            if (r13 == 0) goto L_0x0085
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0085:
            r15 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x0099
            r15 = r41
            boolean r16 = r3.changed((boolean) r15)
            if (r16 == 0) goto L_0x0094
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r4 = r4 | r16
            goto L_0x009b
        L_0x0099:
            r15 = r41
        L_0x009b:
            r16 = 196608(0x30000, float:2.75506E-40)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00b5
            r16 = r0 & 32
            r5 = r42
            if (r16 != 0) goto L_0x00b0
            boolean r16 = r3.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x00b0
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r4 = r4 | r16
            goto L_0x00b7
        L_0x00b5:
            r5 = r42
        L_0x00b7:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00d1
            r16 = r0 & 64
            r8 = r43
            if (r16 != 0) goto L_0x00cc
            boolean r17 = r3.changed((long) r8)
            if (r17 == 0) goto L_0x00cc
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r4 = r4 | r17
            goto L_0x00d3
        L_0x00d1:
            r8 = r43
        L_0x00d3:
            r6 = r0 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r6 == 0) goto L_0x00de
            r4 = r4 | r18
            r1 = r45
            goto L_0x00f1
        L_0x00de:
            r18 = r14 & r18
            r1 = r45
            if (r18 != 0) goto L_0x00f1
            boolean r19 = r3.changed((float) r1)
            if (r19 == 0) goto L_0x00ed
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r4 = r4 | r19
        L_0x00f1:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x00fa
            r4 = r4 | r19
            goto L_0x0110
        L_0x00fa:
            r19 = r14 & r19
            if (r19 != 0) goto L_0x0110
            r19 = r1
            r1 = r46
            boolean r20 = r3.changed((float) r1)
            if (r20 == 0) goto L_0x010b
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x010b:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r4 = r4 | r20
            goto L_0x0114
        L_0x0110:
            r19 = r1
            r1 = r46
        L_0x0114:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x011d
            r4 = r4 | r20
            goto L_0x0133
        L_0x011d:
            r20 = r14 & r20
            if (r20 != 0) goto L_0x0133
            r20 = r1
            r1 = r47
            boolean r21 = r3.changed((java.lang.Object) r1)
            if (r21 == 0) goto L_0x012e
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0130
        L_0x012e:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0130:
            r4 = r4 | r21
            goto L_0x0137
        L_0x0133:
            r20 = r1
            r1 = r47
        L_0x0137:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0142
            r1 = r51 | 6
            r21 = r1
            r1 = r48
            goto L_0x015a
        L_0x0142:
            r1 = r51 & 6
            if (r1 != 0) goto L_0x0156
            r1 = r48
            boolean r21 = r3.changedInstance(r1)
            if (r21 == 0) goto L_0x0151
            r21 = 4
            goto L_0x0153
        L_0x0151:
            r21 = 2
        L_0x0153:
            r21 = r51 | r21
            goto L_0x015a
        L_0x0156:
            r1 = r48
            r21 = r51
        L_0x015a:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0161
            r21 = r21 | 48
            goto L_0x0175
        L_0x0161:
            r1 = r51 & 48
            if (r1 != 0) goto L_0x0175
            r1 = r36
            boolean r22 = r3.changed((java.lang.Object) r1)
            if (r22 == 0) goto L_0x0170
            r16 = 32
            goto L_0x0172
        L_0x0170:
            r16 = 16
        L_0x0172:
            r21 = r21 | r16
            goto L_0x0177
        L_0x0175:
            r1 = r36
        L_0x0177:
            r0 = r21
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r4 & r16
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x01a0
            r1 = r0 & 19
            r2 = 18
            if (r1 != r2) goto L_0x01a0
            boolean r1 = r3.getSkipping()
            if (r1 != 0) goto L_0x0190
            goto L_0x01a0
        L_0x0190:
            r3.skipToGroupEnd()
            r10 = r45
            r0 = r3
            r7 = r5
            r4 = r11
            r5 = r12
            r6 = r15
            r11 = r46
            r12 = r47
            goto L_0x0403
        L_0x01a0:
            r3.startDefaults()
            r1 = r14 & 1
            r2 = 1
            if (r1 == 0) goto L_0x01da
            boolean r1 = r3.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01af
            goto L_0x01da
        L_0x01af:
            r3.skipToGroupEnd()
            r1 = r52 & 8
            if (r1 == 0) goto L_0x01b8
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x01b8:
            r1 = r52 & 32
            if (r1 == 0) goto L_0x01c0
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r1
        L_0x01c0:
            r1 = r52 & 64
            if (r1 == 0) goto L_0x01c8
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r1
        L_0x01c8:
            r31 = r45
            r32 = r46
            r33 = r47
            r28 = r5
            r29 = r8
            r23 = r11
            r27 = r12
        L_0x01d6:
            r24 = r15
            goto L_0x0249
        L_0x01da:
            if (r10 == 0) goto L_0x01e1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01e2
        L_0x01e1:
            r1 = r11
        L_0x01e2:
            r10 = r52 & 8
            if (r10 == 0) goto L_0x01ee
            r10 = 0
            androidx.compose.foundation.ScrollState r11 = androidx.compose.foundation.ScrollKt.rememberScrollState(r10, r3, r10, r2)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01ef
        L_0x01ee:
            r11 = r12
        L_0x01ef:
            if (r13 == 0) goto L_0x01f2
            r15 = r2
        L_0x01f2:
            r10 = r52 & 32
            if (r10 == 0) goto L_0x0202
            androidx.compose.material3.MenuDefaults r5 = androidx.compose.material3.MenuDefaults.INSTANCE
            r10 = 6
            androidx.compose.ui.graphics.Shape r5 = r5.getShape(r3, r10)
            r12 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r12
            goto L_0x0203
        L_0x0202:
            r10 = 6
        L_0x0203:
            r12 = r52 & 64
            if (r12 == 0) goto L_0x0211
            androidx.compose.material3.MenuDefaults r8 = androidx.compose.material3.MenuDefaults.INSTANCE
            long r8 = r8.getContainerColor(r3, r10)
            r10 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r10
        L_0x0211:
            if (r6 == 0) goto L_0x021a
            androidx.compose.material3.MenuDefaults r6 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r6 = r6.m2203getTonalElevationD9Ej5fM()
            goto L_0x021c
        L_0x021a:
            r6 = r45
        L_0x021c:
            if (r19 == 0) goto L_0x0225
            androidx.compose.material3.MenuDefaults r10 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r10 = r10.m2202getShadowElevationD9Ej5fM()
            goto L_0x0227
        L_0x0225:
            r10 = r46
        L_0x0227:
            if (r20 == 0) goto L_0x023a
            r23 = r1
            r28 = r5
            r31 = r6
            r29 = r8
            r32 = r10
            r27 = r11
            r24 = r15
            r33 = 0
            goto L_0x0249
        L_0x023a:
            r33 = r47
            r23 = r1
            r28 = r5
            r31 = r6
            r29 = r8
            r32 = r10
            r27 = r11
            goto L_0x01d6
        L_0x0249:
            r3.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x025a
            java.lang.String r1 = "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:344)"
            r5 = 720925481(0x2af87329, float:4.4133558E-13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r4, r0, r1)
        L_0x025a:
            r0 = 321492941(0x132997cd, float:2.1405642E-27)
            java.lang.String r1 = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            java.lang.Object r0 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x027b
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            androidx.compose.runtime.SnapshotMutationPolicy r5 = androidx.compose.runtime.SnapshotStateKt.neverEqualPolicy()
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateOf(r0, r5)
            r3.updateRememberedValue(r0)
        L_0x027b:
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r8)
            java.lang.Object r5 = r3.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            android.view.View r5 = (android.view.View) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r9)
            java.lang.Object r6 = r3.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.foundation.layout.WindowInsets$Companion r8 = androidx.compose.foundation.layout.WindowInsets.Companion
            r10 = 6
            androidx.compose.foundation.layout.WindowInsets r8 = androidx.compose.foundation.layout.WindowInsets_androidKt.getStatusBars(r8, r3, r10)
            int r8 = r8.getTop(r6)
            r9 = 321499814(0x1329b2a6, float:2.141888E-27)
            r3.startReplaceGroup(r9)
            java.lang.String r9 = "353@16432L36,353@16396L72"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r9)
            if (r37 == 0) goto L_0x02ec
            r9 = 321501788(0x1329ba5c, float:2.1422681E-27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r1)
            java.lang.Object r9 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x02e2
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1$1 r9 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1$1
            r9.<init>(r0)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r3.updateRememberedValue(r9)
        L_0x02e2:
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r10 = 384(0x180, float:5.38E-43)
            androidx.compose.material3.ExposedDropdownMenu_androidKt.SoftKeyboardListener(r5, r6, r9, r3, r10)
        L_0x02ec:
            r3.endReplaceGroup()
            r5 = 321507042(0x1329cee2, float:2.14328E-27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r5, r1)
            java.lang.Object r5 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r5 != r9) goto L_0x030f
            androidx.compose.animation.core.MutableTransitionState r5 = new androidx.compose.animation.core.MutableTransitionState
            r16 = 0
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r16)
            r5.<init>(r9)
            r3.updateRememberedValue(r5)
        L_0x030f:
            androidx.compose.animation.core.MutableTransitionState r5 = (androidx.compose.animation.core.MutableTransitionState) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r37)
            r5.setTargetState$animation_core_release(r9)
            java.lang.Object r9 = r5.getCurrentState()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0337
            java.lang.Object r9 = r5.getTargetState()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0334
            goto L_0x0337
        L_0x0334:
            r0 = r3
            goto L_0x03ea
        L_0x0337:
            r9 = 321513419(0x1329e7cb, float:2.1445082E-27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r1)
            java.lang.Object r9 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x035c
            androidx.compose.ui.graphics.TransformOrigin$Companion r9 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r9 = r9.m4673getCenterSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r9 = androidx.compose.ui.graphics.TransformOrigin.m4660boximpl(r9)
            r10 = 0
            r11 = 2
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r9, r10, r11, r10)
            r3.updateRememberedValue(r9)
        L_0x035c:
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r10 = 321517310(0x1329f6fe, float:2.1452575E-27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r10, r1)
            boolean r1 = r3.changed((java.lang.Object) r6)
            boolean r10 = r3.changed((int) r8)
            r1 = r1 | r10
            java.lang.Object r10 = r3.rememberedValue()
            if (r1 != 0) goto L_0x037e
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r10 != r1) goto L_0x03a5
        L_0x037e:
            androidx.compose.material3.ExposedDropdownMenuPositionProvider r1 = new androidx.compose.material3.ExposedDropdownMenuPositionProvider
            androidx.compose.runtime.State r0 = (androidx.compose.runtime.State) r0
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1 r10 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
            r10.<init>(r9)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 8
            r12 = 0
            r13 = 0
            r42 = r0
            r39 = r1
            r40 = r6
            r41 = r8
            r44 = r10
            r45 = r11
            r46 = r12
            r43 = r13
            r39.<init>(r40, r41, r42, r43, r44, r45, r46)
            r10 = r39
            r3.updateRememberedValue(r10)
        L_0x03a5:
            androidx.compose.material3.ExposedDropdownMenuPositionProvider r10 = (androidx.compose.material3.ExposedDropdownMenuPositionProvider) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.material3.ExposedDropdownMenuDefaults r0 = androidx.compose.material3.ExposedDropdownMenuDefaults.INSTANCE
            java.lang.String r1 = r36.m2053getAnchorTypeMg6Rgbw$material3_release()
            r6 = 48
            androidx.compose.ui.window.PopupProperties r0 = r0.m2058popupPropertiespR6Bxps$material3_release(r1, r3, r6)
            androidx.compose.ui.window.PopupPositionProvider r10 = (androidx.compose.ui.window.PopupPositionProvider) r10
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2 r21 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
            r22 = r36
            r34 = r48
            r25 = r5
            r26 = r9
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34)
            r1 = r21
            r5 = 54
            r6 = -1082380263(0xffffffffbf7c3019, float:-0.9851089)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r2, r1, r3, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r4 = 0
            r41 = r0
            r42 = r1
            r44 = r2
            r43 = r3
            r45 = r4
            r40 = r7
            r39 = r10
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r39, r40, r41, r42, r43, r44, r45)
            r0 = r43
        L_0x03ea:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03f3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03f3:
            r4 = r23
            r6 = r24
            r5 = r27
            r7 = r28
            r8 = r29
            r10 = r31
            r11 = r32
            r12 = r33
        L_0x0403:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x0424
            r1 = r0
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$3 r0 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$3
            r2 = r37
            r3 = r38
            r13 = r48
            r15 = r51
            r16 = r52
            r35 = r1
            r1 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x0424:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m2052ExposedDropdownMenuvNxi1II(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes MenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(expression = "menuAnchor(type, enabled)", imports = {}))
    public final Modifier menuAnchor(Modifier modifier) {
        return m2050menuAnchorfsE2BvY$default(this, modifier, MenuAnchorType.Companion.m2200getPrimaryNotEditableMg6Rgbw(), false, 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0129  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper MenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    /* renamed from: ExposedDropdownMenu-kbRbctU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2051ExposedDropdownMenukbRbctU(boolean r35, kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.ScrollState r38, boolean r39, boolean r40, androidx.compose.ui.graphics.Shape r41, long r42, float r44, float r45, androidx.compose.foundation.BorderStroke r46, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r34 = this;
            r15 = r49
            r0 = r50
            r1 = r51
            r2 = 366140493(0x15d2dc4d, float:8.51659E-26)
            r3 = r48
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(ExposedDropdownMenu)P(3,7,6,8,4,5,10,1:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp)414@19050L21,417@19189L5,418@19241L14,424@19482L463:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r1 & 1
            if (r4 == 0) goto L_0x001e
            r4 = r15 | 6
            r7 = r4
            r4 = r35
            goto L_0x0032
        L_0x001e:
            r4 = r15 & 6
            if (r4 != 0) goto L_0x002f
            r4 = r35
            boolean r7 = r3.changed((boolean) r4)
            if (r7 == 0) goto L_0x002c
            r7 = 4
            goto L_0x002d
        L_0x002c:
            r7 = 2
        L_0x002d:
            r7 = r7 | r15
            goto L_0x0032
        L_0x002f:
            r4 = r35
            r7 = r15
        L_0x0032:
            r8 = r1 & 2
            if (r8 == 0) goto L_0x0039
            r7 = r7 | 48
            goto L_0x004c
        L_0x0039:
            r8 = r15 & 48
            if (r8 != 0) goto L_0x004c
            r8 = r36
            boolean r11 = r3.changedInstance(r8)
            if (r11 == 0) goto L_0x0048
            r11 = 32
            goto L_0x004a
        L_0x0048:
            r11 = 16
        L_0x004a:
            r7 = r7 | r11
            goto L_0x004e
        L_0x004c:
            r8 = r36
        L_0x004e:
            r11 = r1 & 4
            if (r11 == 0) goto L_0x0055
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0055:
            r14 = r15 & 384(0x180, float:5.38E-43)
            if (r14 != 0) goto L_0x0069
            r14 = r37
            boolean r16 = r3.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x0064
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r7 = r7 | r16
            goto L_0x006b
        L_0x0069:
            r14 = r37
        L_0x006b:
            r5 = r15 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x0085
            r5 = r1 & 8
            if (r5 != 0) goto L_0x007e
            r5 = r38
            boolean r16 = r3.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x0080
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x007e:
            r5 = r38
        L_0x0080:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r7 = r7 | r16
            goto L_0x0087
        L_0x0085:
            r5 = r38
        L_0x0087:
            r16 = r1 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x0092
            r7 = r7 | r17
            r6 = r40
            goto L_0x00a5
        L_0x0092:
            r17 = r15 & r17
            r6 = r40
            if (r17 != 0) goto L_0x00a5
            boolean r18 = r3.changed((boolean) r6)
            if (r18 == 0) goto L_0x00a1
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a3
        L_0x00a1:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00a3:
            r7 = r7 | r18
        L_0x00a5:
            r18 = 1572864(0x180000, float:2.204052E-39)
            r18 = r15 & r18
            if (r18 != 0) goto L_0x00bf
            r18 = r1 & 64
            r9 = r41
            if (r18 != 0) goto L_0x00ba
            boolean r19 = r3.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x00ba
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bc
        L_0x00ba:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00bc:
            r7 = r7 | r19
            goto L_0x00c1
        L_0x00bf:
            r9 = r41
        L_0x00c1:
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = r15 & r19
            if (r19 != 0) goto L_0x00db
            r10 = r1 & 128(0x80, float:1.794E-43)
            r12 = r42
            if (r10 != 0) goto L_0x00d6
            boolean r21 = r3.changed((long) r12)
            if (r21 == 0) goto L_0x00d6
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00d8
        L_0x00d6:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00d8:
            r7 = r7 | r21
            goto L_0x00dd
        L_0x00db:
            r12 = r42
        L_0x00dd:
            r10 = r1 & 256(0x100, float:3.59E-43)
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            if (r10 == 0) goto L_0x00e8
            r7 = r7 | r22
            r2 = r44
            goto L_0x00fb
        L_0x00e8:
            r22 = r15 & r22
            r2 = r44
            if (r22 != 0) goto L_0x00fb
            boolean r23 = r3.changed((float) r2)
            if (r23 == 0) goto L_0x00f7
            r23 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00f9
        L_0x00f7:
            r23 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00f9:
            r7 = r7 | r23
        L_0x00fb:
            r2 = r1 & 512(0x200, float:7.175E-43)
            r23 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0104
            r7 = r7 | r23
            goto L_0x011a
        L_0x0104:
            r23 = r15 & r23
            if (r23 != 0) goto L_0x011a
            r23 = r2
            r2 = r45
            boolean r24 = r3.changed((float) r2)
            if (r24 == 0) goto L_0x0115
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0117
        L_0x0115:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0117:
            r7 = r7 | r24
            goto L_0x011e
        L_0x011a:
            r23 = r2
            r2 = r45
        L_0x011e:
            r2 = r1 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0129
            r17 = r0 | 6
            r24 = r2
            r2 = r46
            goto L_0x0145
        L_0x0129:
            r24 = r0 & 6
            if (r24 != 0) goto L_0x013f
            r24 = r2
            r2 = r46
            boolean r25 = r3.changed((java.lang.Object) r2)
            if (r25 == 0) goto L_0x013a
            r17 = 4
            goto L_0x013c
        L_0x013a:
            r17 = 2
        L_0x013c:
            r17 = r0 | r17
            goto L_0x0145
        L_0x013f:
            r24 = r2
            r2 = r46
            r17 = r0
        L_0x0145:
            r2 = r1 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x014c
            r17 = r17 | 48
            goto L_0x0162
        L_0x014c:
            r2 = r0 & 48
            if (r2 != 0) goto L_0x0160
            r2 = r47
            boolean r25 = r3.changedInstance(r2)
            if (r25 == 0) goto L_0x015b
            r18 = 32
            goto L_0x015d
        L_0x015b:
            r18 = 16
        L_0x015d:
            r17 = r17 | r18
            goto L_0x0162
        L_0x0160:
            r2 = r47
        L_0x0162:
            r2 = r17
            r4 = r1 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x016b
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x017f
        L_0x016b:
            r4 = r0 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x017f
            r4 = r34
            boolean r17 = r3.changed((java.lang.Object) r4)
            if (r17 == 0) goto L_0x017a
            r20 = 256(0x100, float:3.59E-43)
            goto L_0x017c
        L_0x017a:
            r20 = 128(0x80, float:1.794E-43)
        L_0x017c:
            r2 = r2 | r20
            goto L_0x0181
        L_0x017f:
            r4 = r34
        L_0x0181:
            r17 = 306775187(0x12490493, float:6.3430055E-28)
            r0 = r7 & r17
            r4 = 306775186(0x12490492, float:6.343005E-28)
            if (r0 != r4) goto L_0x01ab
            r0 = r2 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r0 != r4) goto L_0x01ab
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x0198
            goto L_0x01ab
        L_0x0198:
            r3.skipToGroupEnd()
            r11 = r44
            r29 = r3
            r7 = r6
            r8 = r9
            r9 = r12
            r4 = r14
            r6 = r39
            r12 = r45
            r13 = r46
            goto L_0x02be
        L_0x01ab:
            r3.startDefaults()
            r0 = r15 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x01ea
            boolean r0 = r3.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01bf
            goto L_0x01ea
        L_0x01bf:
            r3.skipToGroupEnd()
            r0 = r1 & 8
            if (r0 == 0) goto L_0x01c8
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x01c8:
            r0 = r1 & 64
            if (r0 == 0) goto L_0x01ce
            r7 = r7 & r17
        L_0x01ce:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01d3
            r7 = r7 & r4
        L_0x01d3:
            r25 = r44
            r26 = r45
            r27 = r46
            r20 = r5
            r21 = r6
            r22 = r9
            r23 = r12
            r19 = r14
            r0 = 366140493(0x15d2dc4d, float:8.51659E-26)
            r5 = r39
            goto L_0x0263
        L_0x01ea:
            if (r11 == 0) goto L_0x01f1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r14 = r0
        L_0x01f1:
            r0 = r1 & 8
            r11 = 1
            if (r0 == 0) goto L_0x01fe
            r0 = 0
            androidx.compose.foundation.ScrollState r0 = androidx.compose.foundation.ScrollKt.rememberScrollState(r0, r3, r0, r11)
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01ff
        L_0x01fe:
            r0 = r5
        L_0x01ff:
            r5 = r1 & 16
            if (r5 == 0) goto L_0x0205
            r5 = r11
            goto L_0x0207
        L_0x0205:
            r5 = r39
        L_0x0207:
            if (r16 == 0) goto L_0x020a
            r6 = r11
        L_0x020a:
            r11 = r1 & 64
            r48 = r4
            r4 = 6
            if (r11 == 0) goto L_0x0219
            androidx.compose.material3.MenuDefaults r9 = androidx.compose.material3.MenuDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r9 = r9.getShape(r3, r4)
            r7 = r7 & r17
        L_0x0219:
            r11 = r1 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0227
            androidx.compose.material3.MenuDefaults r11 = androidx.compose.material3.MenuDefaults.INSTANCE
            long r11 = r11.getContainerColor(r3, r4)
            r4 = r7 & r48
            r7 = r4
            goto L_0x0228
        L_0x0227:
            r11 = r12
        L_0x0228:
            if (r10 == 0) goto L_0x0231
            androidx.compose.material3.MenuDefaults r4 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r4 = r4.m2203getTonalElevationD9Ej5fM()
            goto L_0x0233
        L_0x0231:
            r4 = r44
        L_0x0233:
            if (r23 == 0) goto L_0x023c
            androidx.compose.material3.MenuDefaults r10 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r10 = r10.m2202getShadowElevationD9Ej5fM()
            goto L_0x023e
        L_0x023c:
            r10 = r45
        L_0x023e:
            if (r24 == 0) goto L_0x0250
            r13 = 0
            r20 = r0
            r25 = r4
            r21 = r6
            r22 = r9
            r26 = r10
            r23 = r11
            r27 = r13
            goto L_0x025e
        L_0x0250:
            r27 = r46
            r20 = r0
            r25 = r4
            r21 = r6
            r22 = r9
            r26 = r10
            r23 = r11
        L_0x025e:
            r19 = r14
            r0 = 366140493(0x15d2dc4d, float:8.51659E-26)
        L_0x0263:
            r3.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0271
            java.lang.String r4 = "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:424)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r2, r4)
        L_0x0271:
            r0 = r7 & 8190(0x1ffe, float:1.1477E-41)
            int r4 = r7 >> 3
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r6
            r0 = r0 | r4
            int r4 = r2 << 27
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r6
            r30 = r0 | r4
            int r0 = r2 >> 3
            r31 = r0 & 126(0x7e, float:1.77E-43)
            r32 = 0
            r16 = r34
            r17 = r35
            r28 = r47
            r29 = r3
            r18 = r8
            r16.m2052ExposedDropdownMenuvNxi1II(r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02ad
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ad:
            r6 = r5
            r4 = r19
            r5 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r11 = r25
            r12 = r26
            r13 = r27
        L_0x02be:
            androidx.compose.runtime.ScopeUpdateScope r0 = r29.endRestartGroup()
            if (r0 == 0) goto L_0x02df
            r2 = r0
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$4 r0 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$4
            r3 = r36
            r14 = r47
            r16 = r50
            r17 = r1
            r33 = r2
            r1 = r34
            r2 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = r33
            r2.updateScope(r0)
        L_0x02df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m2051ExposedDropdownMenukbRbctU(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void ExposedDropdownMenu(boolean r26, kotlin.jvm.functions.Function0 r27, androidx.compose.ui.Modifier r28, androidx.compose.foundation.ScrollState r29, kotlin.jvm.functions.Function3 r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r25 = this;
            r7 = r32
            r0 = 1729549851(0x6716d61b, float:7.123045E23)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ExposedDropdownMenu)P(1,3,2,4)449@20337L21,458@20677L5,459@20726L14,452@20429L498:ExposedDropdownMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r33 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r7 | 6
            r9 = r26
            goto L_0x002b
        L_0x0019:
            r2 = r7 & 6
            r9 = r26
            if (r2 != 0) goto L_0x002a
            boolean r2 = r1.changed((boolean) r9)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r7
            goto L_0x002b
        L_0x002a:
            r2 = r7
        L_0x002b:
            r3 = r33 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            r10 = r27
            goto L_0x0046
        L_0x0034:
            r3 = r7 & 48
            r10 = r27
            if (r3 != 0) goto L_0x0046
            boolean r3 = r1.changedInstance(r10)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r33 & 4
            if (r3 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r4 = r7 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0060
            r4 = r28
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r5
            goto L_0x0062
        L_0x0060:
            r4 = r28
        L_0x0062:
            r5 = r7 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007b
            r5 = r33 & 8
            if (r5 != 0) goto L_0x0075
            r5 = r29
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0077
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r5 = r29
        L_0x0077:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r6
            goto L_0x007d
        L_0x007b:
            r5 = r29
        L_0x007d:
            r6 = r33 & 16
            if (r6 == 0) goto L_0x0084
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r6 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x0097
            r6 = r30
            boolean r8 = r1.changedInstance(r6)
            if (r8 == 0) goto L_0x0093
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r2 = r2 | r8
            goto L_0x0099
        L_0x0097:
            r6 = r30
        L_0x0099:
            r8 = r33 & 32
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a1
            r2 = r2 | r11
            goto L_0x00b4
        L_0x00a1:
            r8 = r7 & r11
            if (r8 != 0) goto L_0x00b4
            r8 = r25
            boolean r11 = r1.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x00b0
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r11
            goto L_0x00b6
        L_0x00b4:
            r8 = r25
        L_0x00b6:
            r11 = 74899(0x12493, float:1.04956E-40)
            r11 = r11 & r2
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r12) goto L_0x00cd
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x00c6
            goto L_0x00cd
        L_0x00c6:
            r1.skipToGroupEnd()
            r21 = r1
            goto L_0x0152
        L_0x00cd:
            r1.startDefaults()
            r11 = r7 & 1
            if (r11 == 0) goto L_0x00e6
            boolean r11 = r1.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00db
            goto L_0x00e6
        L_0x00db:
            r1.skipToGroupEnd()
            r3 = r33 & 8
            if (r3 == 0) goto L_0x00e4
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00e4:
            r11 = r4
            goto L_0x00fe
        L_0x00e6:
            if (r3 == 0) goto L_0x00ed
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00ee
        L_0x00ed:
            r3 = r4
        L_0x00ee:
            r4 = r33 & 8
            if (r4 == 0) goto L_0x00fd
            r4 = 0
            r5 = 1
            androidx.compose.foundation.ScrollState r4 = androidx.compose.foundation.ScrollKt.rememberScrollState(r4, r1, r4, r5)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r11 = r3
            r12 = r4
            goto L_0x00ff
        L_0x00fd:
            r11 = r3
        L_0x00fe:
            r12 = r5
        L_0x00ff:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x010e
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:452)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x010e:
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            r3 = 6
            androidx.compose.ui.graphics.Shape r14 = r0.getShape(r1, r3)
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            long r15 = r0.getContainerColor(r1, r3)
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r17 = r0.m2203getTonalElevationD9Ej5fM()
            androidx.compose.material3.MenuDefaults r0 = androidx.compose.material3.MenuDefaults.INSTANCE
            float r18 = r0.m2202getShadowElevationD9Ej5fM()
            r0 = r2 & 14
            r3 = 918577152(0x36c06000, float:5.7332218E-6)
            r0 = r0 | r3
            r3 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r22 = r0 | r3
            int r0 = r2 >> 12
            r23 = r0 & 126(0x7e, float:1.77E-43)
            r24 = 0
            r13 = 1
            r19 = 0
            r21 = r1
            r20 = r6
            r8.m2052ExposedDropdownMenuvNxi1II(r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0150
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0150:
            r4 = r11
            r5 = r12
        L_0x0152:
            androidx.compose.runtime.ScopeUpdateScope r9 = r21.endRestartGroup()
            if (r9 == 0) goto L_0x016c
            androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$5 r0 = new androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$5
            r1 = r25
            r2 = r26
            r3 = r27
            r6 = r30
            r8 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
