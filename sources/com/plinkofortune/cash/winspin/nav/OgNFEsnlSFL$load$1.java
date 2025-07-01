package com.plinkofortune.cash.winspin.nav;

import android.webkit.WebView;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: OgNFEsnlSFL.kt */
/* synthetic */ class OgNFEsnlSFL$load$1 extends FunctionReferenceImpl implements Function2<Boolean, Function1<? super WebView, ? extends Unit>, Unit> {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    OgNFEsnlSFL$load$1(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Class<com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL> r3 = com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL.class
            r0 = 10
            byte[] r0 = new byte[r0]
            r0 = {122, 59, -79, 37, -51, -48, 84, -97, 116, 41} // fill-array
            r1 = 8
            byte[] r2 = new byte[r1]
            r2 = {21, 75, -44, 75, -125, -75, 35, -53} // fill-array
            java.lang.String r4 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r2)
            r0 = 46
            byte[] r0 = new byte[r0]
            r0 = {72, -5, -33, -59, -40, 23, 92, 10, 70, -23, -110, -15, -38, 25, 68, 42, 75, -30, -44, -124, -4, 4, 70, 113, 65, -2, -44, -56, -30, 27, 68, 48, 84, -92, -4, -34, -8, 17, 95, 55, 72, -27, -117, -112, -65, 36} // fill-array
            byte[] r1 = new byte[r1]
            r1 = {39, -117, -70, -85, -106, 114, 43, 94} // fill-array
            java.lang.String r5 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r6 = 0
            r1 = 2
            r0 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL$load$1.<init>(java.lang.Object):void");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), (Function1<? super WebView, Unit>) (Function1) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, Function1<? super WebView, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, StringFog.decrypt(new byte[]{-35, 19}, new byte[]{-83, 34, 108, 124, -41, -26, -77, -78}));
        ((OgNFEsnlSFL) this.receiver).openNewTab(z, function1);
    }
}
