package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¹\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aJ\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\"\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0000\u001a\u0014\u0010&\u001a\u00020$*\u00020'2\u0006\u0010(\u001a\u00020$H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)²\u0006\u0015\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetDialog", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalBottomSheetProperties;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "", "Landroid/view/View;", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
public final class ModalBottomSheet_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.window.SecureFlagPolicy[] r0 = androidx.compose.ui.window.SecureFlagPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.window.SecureFlagPolicy r1 = androidx.compose.ui.window.SecureFlagPolicy.SecureOff     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.window.SecureFlagPolicy r1 = androidx.compose.ui.window.SecureFlagPolicy.SecureOn     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.window.SecureFlagPolicy r1 = androidx.compose.ui.window.SecureFlagPolicy.Inherit     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011d  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use constructor with contentWindowInsets parameter.", replaceWith = @kotlin.ReplaceWith(expression = "ModalBottomSheet(onDismissRequest,modifier,sheetState,sheetMaxWidth,shape,containerColor,contentColor,tonalElevation,scrimColor,dragHandle,{ windowInsets },properties,content,)", imports = {}))
    /* renamed from: ModalBottomSheet-dYc4hso  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2224ModalBottomSheetdYc4hso(kotlin.jvm.functions.Function0 r30, androidx.compose.ui.Modifier r31, androidx.compose.material3.SheetState r32, float r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, float r39, long r40, kotlin.jvm.functions.Function2 r42, androidx.compose.foundation.layout.WindowInsets r43, androidx.compose.material3.ModalBottomSheetProperties r44, kotlin.jvm.functions.Function3 r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r0 = r47
            r1 = r48
            r2 = r49
            r3 = 944867294(0x385187de, float:4.995602E-5)
            r4 = r46
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(ModalBottomSheet)P(5,4,10,9:c#ui.unit.Dp,8,0:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.unit.Dp,7:c#ui.graphics.Color,3,12,6)235@10240L31,237@10371L13,238@10434L14,239@10476L31,241@10584L10,243@10731L12,247@10884L485:ModalBottomSheet.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r2 & 1
            if (r5 == 0) goto L_0x001e
            r5 = r0 | 6
            r8 = r5
            r5 = r30
            goto L_0x0032
        L_0x001e:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x002f
            r5 = r30
            boolean r8 = r4.changedInstance(r5)
            if (r8 == 0) goto L_0x002c
            r8 = 4
            goto L_0x002d
        L_0x002c:
            r8 = 2
        L_0x002d:
            r8 = r8 | r0
            goto L_0x0032
        L_0x002f:
            r5 = r30
            r8 = r0
        L_0x0032:
            r9 = r2 & 2
            if (r9 == 0) goto L_0x0039
            r8 = r8 | 48
            goto L_0x004c
        L_0x0039:
            r12 = r0 & 48
            if (r12 != 0) goto L_0x004c
            r12 = r31
            boolean r13 = r4.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0048
            r13 = 32
            goto L_0x004a
        L_0x0048:
            r13 = 16
        L_0x004a:
            r8 = r8 | r13
            goto L_0x004e
        L_0x004c:
            r12 = r31
        L_0x004e:
            r13 = r0 & 384(0x180, float:5.38E-43)
            if (r13 != 0) goto L_0x0068
            r13 = r2 & 4
            if (r13 != 0) goto L_0x0061
            r13 = r32
            boolean r16 = r4.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0063
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0061:
            r13 = r32
        L_0x0063:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r8 = r8 | r16
            goto L_0x006a
        L_0x0068:
            r13 = r32
        L_0x006a:
            r16 = r2 & 8
            if (r16 == 0) goto L_0x0071
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0071:
            r6 = r0 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0085
            r6 = r33
            boolean r17 = r4.changed((float) r6)
            if (r17 == 0) goto L_0x0080
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r8 = r8 | r17
            goto L_0x0087
        L_0x0085:
            r6 = r33
        L_0x0087:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00a1
            r7 = r2 & 16
            if (r7 != 0) goto L_0x009a
            r7 = r34
            boolean r18 = r4.changed((java.lang.Object) r7)
            if (r18 == 0) goto L_0x009c
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009a:
            r7 = r34
        L_0x009c:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r8 = r8 | r18
            goto L_0x00a3
        L_0x00a1:
            r7 = r34
        L_0x00a3:
            r18 = 196608(0x30000, float:2.75506E-40)
            r18 = r0 & r18
            if (r18 != 0) goto L_0x00bd
            r18 = r2 & 32
            r10 = r35
            if (r18 != 0) goto L_0x00b8
            boolean r20 = r4.changed((long) r10)
            if (r20 == 0) goto L_0x00b8
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r8 = r8 | r20
            goto L_0x00bf
        L_0x00bd:
            r10 = r35
        L_0x00bf:
            r20 = 1572864(0x180000, float:2.204052E-39)
            r20 = r0 & r20
            if (r20 != 0) goto L_0x00d9
            r20 = r2 & 64
            r14 = r37
            if (r20 != 0) goto L_0x00d4
            boolean r22 = r4.changed((long) r14)
            if (r22 == 0) goto L_0x00d4
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r8 = r8 | r22
            goto L_0x00db
        L_0x00d9:
            r14 = r37
        L_0x00db:
            r3 = r2 & 128(0x80, float:1.794E-43)
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            if (r3 == 0) goto L_0x00e6
            r8 = r8 | r23
            r0 = r39
            goto L_0x00f9
        L_0x00e6:
            r23 = r0 & r23
            r0 = r39
            if (r23 != 0) goto L_0x00f9
            boolean r23 = r4.changed((float) r0)
            if (r23 == 0) goto L_0x00f5
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f5:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r8 = r8 | r23
        L_0x00f9:
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r23 = r47 & r23
            if (r23 != 0) goto L_0x0112
            r0 = r2 & 256(0x100, float:3.59E-43)
            r5 = r40
            if (r0 != 0) goto L_0x010e
            boolean r0 = r4.changed((long) r5)
            if (r0 == 0) goto L_0x010e
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0110
        L_0x010e:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0110:
            r8 = r8 | r0
            goto L_0x0114
        L_0x0112:
            r5 = r40
        L_0x0114:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r23 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011d
            r8 = r8 | r23
            goto L_0x0133
        L_0x011d:
            r23 = r47 & r23
            if (r23 != 0) goto L_0x0133
            r23 = r0
            r0 = r42
            boolean r24 = r4.changedInstance(r0)
            if (r24 == 0) goto L_0x012e
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0130
        L_0x012e:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0130:
            r8 = r8 | r24
            goto L_0x0137
        L_0x0133:
            r23 = r0
            r0 = r42
        L_0x0137:
            r24 = r1 & 6
            if (r24 != 0) goto L_0x0151
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x014a
            r0 = r43
            boolean r24 = r4.changed((java.lang.Object) r0)
            if (r24 == 0) goto L_0x014c
            r17 = 4
            goto L_0x014e
        L_0x014a:
            r0 = r43
        L_0x014c:
            r17 = 2
        L_0x014e:
            r17 = r1 | r17
            goto L_0x0155
        L_0x0151:
            r0 = r43
            r17 = r1
        L_0x0155:
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x015e
            r17 = r17 | 48
            r24 = r0
            goto L_0x0178
        L_0x015e:
            r24 = r1 & 48
            if (r24 != 0) goto L_0x0174
            r24 = r0
            r0 = r44
            boolean r25 = r4.changed((java.lang.Object) r0)
            if (r25 == 0) goto L_0x016f
            r18 = 32
            goto L_0x0171
        L_0x016f:
            r18 = 16
        L_0x0171:
            r17 = r17 | r18
            goto L_0x0178
        L_0x0174:
            r24 = r0
            r0 = r44
        L_0x0178:
            r0 = r17
            r17 = r3
            r3 = r2 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0183
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0197
        L_0x0183:
            r3 = r1 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0197
            r3 = r45
            boolean r18 = r4.changedInstance(r3)
            if (r18 == 0) goto L_0x0192
            r20 = 256(0x100, float:3.59E-43)
            goto L_0x0194
        L_0x0192:
            r20 = 128(0x80, float:1.794E-43)
        L_0x0194:
            r0 = r0 | r20
            goto L_0x0199
        L_0x0197:
            r3 = r45
        L_0x0199:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r8 & r18
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r3) goto L_0x01ca
            r1 = r0 & 147(0x93, float:2.06E-43)
            r3 = 146(0x92, float:2.05E-43)
            if (r1 != r3) goto L_0x01ca
            boolean r1 = r4.getSkipping()
            if (r1 != 0) goto L_0x01b0
            goto L_0x01ca
        L_0x01b0:
            r4.skipToGroupEnd()
            r20 = r4
            r2 = r12
            r3 = r13
            r8 = r14
            r4 = r33
            r13 = r42
            r14 = r43
            r15 = r44
            r27 = r10
            r10 = r39
            r11 = r5
            r5 = r7
            r6 = r27
            goto L_0x0309
        L_0x01ca:
            r4.startDefaults()
            r1 = r47 & 1
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0223
            boolean r1 = r4.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01e1
            goto L_0x0223
        L_0x01e1:
            r4.skipToGroupEnd()
            r1 = r2 & 4
            if (r1 == 0) goto L_0x01ea
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x01ea:
            r1 = r2 & 16
            if (r1 == 0) goto L_0x01f0
            r8 = r8 & r19
        L_0x01f0:
            r1 = r2 & 32
            if (r1 == 0) goto L_0x01f6
            r8 = r8 & r18
        L_0x01f6:
            r1 = r2 & 64
            if (r1 == 0) goto L_0x01fb
            r8 = r8 & r3
        L_0x01fb:
            r1 = r2 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0203
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r8 = r8 & r1
        L_0x0203:
            r1 = r2 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0209
            r0 = r0 & -15
        L_0x0209:
            r16 = r42
            r18 = r44
            r1 = r0
            r3 = r8
            r9 = r10
            r0 = r43
            r8 = r7
            r7 = r33
            r27 = r13
            r13 = r39
            r28 = r5
            r5 = r12
            r6 = r27
            r11 = r14
            r14 = r28
            goto L_0x02c2
        L_0x0223:
            if (r9 == 0) goto L_0x022a
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r12 = r1
        L_0x022a:
            r1 = r2 & 4
            r9 = 0
            if (r1 == 0) goto L_0x0238
            r1 = 0
            r13 = 3
            androidx.compose.material3.SheetState r1 = androidx.compose.material3.ModalBottomSheetKt.rememberModalBottomSheetState(r9, r1, r4, r9, r13)
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
            r13 = r1
        L_0x0238:
            if (r16 == 0) goto L_0x0241
            androidx.compose.material3.BottomSheetDefaults r1 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r1 = r1.m1744getSheetMaxWidthD9Ej5fM()
            goto L_0x0243
        L_0x0241:
            r1 = r33
        L_0x0243:
            r16 = r2 & 16
            r46 = r3
            r3 = 6
            if (r16 == 0) goto L_0x0252
            androidx.compose.material3.BottomSheetDefaults r7 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r7 = r7.getExpandedShape(r4, r3)
            r8 = r8 & r19
        L_0x0252:
            r16 = r2 & 32
            if (r16 == 0) goto L_0x025e
            androidx.compose.material3.BottomSheetDefaults r10 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r10 = r10.getContainerColor(r4, r3)
            r8 = r8 & r18
        L_0x025e:
            r16 = r2 & 64
            if (r16 == 0) goto L_0x026c
            int r14 = r8 >> 15
            r14 = r14 & 14
            long r14 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r10, r4, r14)
            r8 = r8 & r46
        L_0x026c:
            if (r17 == 0) goto L_0x0274
            float r9 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r9)
            goto L_0x0276
        L_0x0274:
            r9 = r39
        L_0x0276:
            r3 = r2 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0287
            androidx.compose.material3.BottomSheetDefaults r3 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r5 = 6
            long r16 = r3.getScrimColor(r4, r5)
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r8
            r8 = r3
            goto L_0x0289
        L_0x0287:
            r16 = r5
        L_0x0289:
            if (r23 == 0) goto L_0x0292
            androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt r3 = androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1929getLambda1$material3_release()
            goto L_0x0294
        L_0x0292:
            r3 = r42
        L_0x0294:
            r5 = r2 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x02a2
            androidx.compose.material3.BottomSheetDefaults r5 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r6 = 6
            androidx.compose.foundation.layout.WindowInsets r5 = r5.getWindowInsets(r4, r6)
            r0 = r0 & -15
            goto L_0x02a4
        L_0x02a2:
            r5 = r43
        L_0x02a4:
            if (r24 == 0) goto L_0x02af
            androidx.compose.material3.ModalBottomSheetDefaults r6 = androidx.compose.material3.ModalBottomSheetDefaults.INSTANCE
            androidx.compose.material3.ModalBottomSheetProperties r6 = r6.getProperties()
            r18 = r6
            goto L_0x02b1
        L_0x02af:
            r18 = r44
        L_0x02b1:
            r6 = r13
            r13 = r9
            r9 = r10
            r27 = r1
            r1 = r0
            r0 = r5
            r5 = r12
            r11 = r14
            r14 = r16
            r16 = r3
            r3 = r8
            r8 = r7
            r7 = r27
        L_0x02c2:
            r4.endDefaults()
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x02d6
            java.lang.String r2 = "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:247)"
            r20 = r4
            r4 = 944867294(0x385187de, float:4.995602E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r1, r2)
            goto L_0x02d8
        L_0x02d6:
            r20 = r4
        L_0x02d8:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1 r2 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1
            r2.<init>(r0)
            r17 = r2
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            r2 = 2147483646(0x7ffffffe, float:NaN)
            r21 = r3 & r2
            r1 = r1 & 1008(0x3f0, float:1.413E-42)
            r23 = 0
            r4 = r30
            r19 = r45
            r22 = r1
            androidx.compose.material3.ModalBottomSheetKt.m2218ModalBottomSheetdYc4hso(r4, r5, r6, r7, r8, r9, r11, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02fc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02fc:
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r8
            r6 = r9
            r8 = r11
            r10 = r13
            r11 = r14
            r13 = r16
            r15 = r18
            r14 = r0
        L_0x0309:
            androidx.compose.runtime.ScopeUpdateScope r0 = r20.endRestartGroup()
            if (r0 == 0) goto L_0x0328
            r1 = r0
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2 r0 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2
            r16 = r45
            r17 = r47
            r18 = r48
            r19 = r49
            r26 = r1
            r1 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r26
            r1.updateScope(r0)
        L_0x0328:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m2224ModalBottomSheetdYc4hso(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.ModalBottomSheetProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void ModalBottomSheetDialog(Function0<Unit> function0, ModalBottomSheetProperties modalBottomSheetProperties, Animatable<Float, AnimationVector1D> animatable, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer composer2;
        int i3;
        boolean z;
        LayoutDirection layoutDirection;
        Function0<Unit> function02 = function0;
        ModalBottomSheetProperties modalBottomSheetProperties2 = modalBottomSheetProperties;
        Animatable<Float, AnimationVector1D> animatable2 = animatable;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(1254951810);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheetDialog)P(1,3,2)273@11822L7,274@11861L7,275@11916L7,276@11946L28,277@12001L29,278@12050L38,279@12105L24,280@12157L21,282@12204L697,305@12932L129,305@12907L154,314@13078L182,314@13067L193:ModalBottomSheet.android.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) modalBottomSheetProperties2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i2 |= (i4 & 512) == 0 ? startRestartGroup.changed((Object) animatable2) : startRestartGroup.changedInstance(animatable2) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1254951810, i2, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:272)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume3;
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function22, startRestartGroup, (i2 >> 9) & 14);
            Composer composer3 = startRestartGroup;
            Density density = (Density) consume2;
            CompositionContext compositionContext = rememberCompositionContext;
            State<T> state = rememberUpdatedState;
            composer2 = composer3;
            UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialogId$1.INSTANCE, composer3, 3072, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer2, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            boolean isSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1981517173, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean changed = composer2.changed((Object) view) | composer2.changed((Object) density);
            Object rememberedValue2 = composer2.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                UUID uuid2 = uuid;
                CoroutineScope coroutineScope2 = coroutineScope;
                z = false;
                i3 = i2;
                Density density2 = density;
                layoutDirection = layoutDirection2;
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = new ModalBottomSheetDialogWrapper(function02, modalBottomSheetProperties2, view, layoutDirection, density2, uuid2, animatable, coroutineScope2, isSystemInDarkTheme);
                modalBottomSheetDialogWrapper.setContent(compositionContext, ComposableLambdaKt.composableLambdaInstance(-1560960657, true, new ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1(state)));
                composer2.updateRememberedValue(modalBottomSheetDialogWrapper);
                rememberedValue2 = modalBottomSheetDialogWrapper;
            } else {
                i3 = i2;
                layoutDirection = layoutDirection2;
                z = false;
            }
            ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper2 = (ModalBottomSheetDialogWrapper) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1981494445, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean changedInstance = composer2.changedInstance(modalBottomSheetDialogWrapper2);
            Object rememberedValue3 = composer2.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new ModalBottomSheet_androidKt$ModalBottomSheetDialog$1$1(modalBottomSheetDialogWrapper2);
                composer2.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.DisposableEffect((Object) modalBottomSheetDialogWrapper2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue3, composer2, z ? 1 : 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1981489720, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean changedInstance2 = composer2.changedInstance(modalBottomSheetDialogWrapper2) | ((i3 & 14) == 4 ? true : z) | ((i3 & 112) == 32 ? true : z) | composer2.changed((Object) layoutDirection);
            Object rememberedValue4 = composer2.rememberedValue();
            if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new ModalBottomSheet_androidKt$ModalBottomSheetDialog$2$1(modalBottomSheetDialogWrapper2, function02, modalBottomSheetProperties2, layoutDirection);
                composer2.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.SideEffect((Function0) rememberedValue4, composer2, z);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheetDialog$3(function02, modalBottomSheetProperties2, animatable, function2, i4));
        }
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetDialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
