package com.plinkofortune.cash.winspin.nav;

import android.content.SharedPreferences;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import kotlin.text.StringsKt;
import okio.Utf8;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/plinkofortune/cash/winspin/nav/DMM;", "", "<init>", "()V", "mDarkMode", "", "Ljava/lang/Integer;", "init", "", "activity", "Landroidx/activity/ComponentActivity;", "lightTheme", "darkLightTheme", "getAbValue", "", "applyDarkModeTo", "webView", "Landroid/webkit/WebView;", "applySettings", "dark", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: DMM.kt */
public final class DMM {
    public static final int $stable = 8;
    public static final DMM INSTANCE = new DMM();
    private static volatile Integer mDarkMode;

    private DMM() {
    }

    @JvmStatic
    public static final void init(ComponentActivity componentActivity, int i, int i2) {
        ComponentActivity componentActivity2 = componentActivity;
        Intrinsics.checkNotNullParameter(componentActivity2, StringFog.decrypt(new byte[]{-97, -32, -1, 74, 124, -39, -86, -118}, new byte[]{-2, -125, -117, 35, 10, -80, -34, -13}));
        String packageName = componentActivity2.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, StringFog.decrypt(new byte[]{-109, 44, -59, 52, -100, -23, 56, -9, -109, 44, -1, 5, -112, -17, 123, -72, -38, 103, -104}, new byte[]{-12, 73, -79, 100, -3, -118, 83, -106}));
        String replace$default = StringsKt.replace$default(StringsKt.reversed((CharSequence) packageName).toString(), StringFog.decrypt(new byte[]{-35}, new byte[]{-13, -89, -35, 101, -107, -26, -81, Base64.padSymbol}), StringFog.decrypt(new byte[]{93}, new byte[]{2, 98, Ascii.ESC, -66, 76, -61, Ascii.ETB, -52}), false, 4, (Object) null);
        String replace$default2 = StringsKt.replace$default(replace$default, StringFog.decrypt(new byte[]{-54}, new byte[]{-28, -62, -65, -38, 46, 57, -15, -36}), "", false, 4, (Object) null);
        SharedPreferences sharedPreferences = componentActivity2.getSharedPreferences(replace$default, 0);
        mDarkMode = Integer.valueOf(sharedPreferences.getInt(replace$default2, -1));
        Integer num = mDarkMode;
        if (num != null && num.intValue() == -1) {
            mDarkMode = Integer.valueOf(RandomKt.Random(System.currentTimeMillis()).nextInt(0, 2));
            Intrinsics.checkNotNull(sharedPreferences);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Integer num2 = mDarkMode;
            if (num2 != null) {
                edit.putInt(replace$default2, num2.intValue());
                edit.apply();
            } else {
                throw new IllegalArgumentException(StringFog.decrypt(new byte[]{-57, Ascii.RS, -54, -30, -30, -70, -24, -7, -75, Ascii.CR, -38, -5, -2, -83, -83, -22, -12, 8, -101, -7, -2, -92, -31, -77}, new byte[]{-107, 123, -69, -105, -117, -56, -115, -99}).toString());
            }
        }
        Integer num3 = mDarkMode;
        Intrinsics.checkNotNull(num3);
        if (num3.intValue() == 1) {
            componentActivity2.setTheme(i2);
        } else {
            componentActivity.setTheme(i);
        }
    }

    @JvmStatic
    public static final String getAbValue() {
        Integer num = mDarkMode;
        if (num != null && num.intValue() == 0) {
            return StringFog.decrypt(new byte[]{57, -36, -117, 44}, new byte[]{87, -77, -27, 73, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 82, -41});
        }
        if (num != null && num.intValue() == 1) {
            return StringFog.decrypt(new byte[]{-27, 121, -107, 100}, new byte[]{-127, Ascii.CAN, -25, Ascii.SI, 102, 83, 37, -75});
        }
        throw new IllegalStateException(("Unknown value: " + mDarkMode).toString());
    }

    @JvmStatic
    public static final void applyDarkModeTo(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, StringFog.decrypt(new byte[]{55, -52, -116, 32, 58, 113, 66}, new byte[]{SignedBytes.MAX_POWER_OF_TWO, -87, -18, 118, 83, Ascii.DC4, 53, Ascii.US}));
        Integer num = mDarkMode;
        if (num == null || num.intValue() != 0) {
            boolean z = false;
            boolean z2 = (webView.getContext().getResources().getConfiguration().uiMode & 48) == 32;
            Integer num2 = mDarkMode;
            if (num2 != null && num2.intValue() == 1 && z2) {
                z = true;
            }
            INSTANCE.applySettings(webView, z);
        }
    }

    private final void applySettings(WebView webView, boolean z) {
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, StringFog.decrypt(new byte[]{-123, 123, 47, -121, 53, -106, 40, -96, -116, 121, 40, -4, 126, -52, 114, -32}, new byte[]{-30, Ascii.RS, 91, -44, 80, -30, 92, -55}));
        try {
            if (WebViewFeature.isFeatureSupported(StringFog.decrypt(new byte[]{117, -35, 102, 39, Ascii.CAN, 41, 113, -47, 97, -39}, new byte[]{51, -110, 52, 100, 93, 118, 53, -112})) && WebViewFeature.isFeatureSupported(StringFog.decrypt(new byte[]{98, -3, 36, 42, 74, -11, 43, 10, 118, -7, 41, 58, 91, -8, 46, Ascii.US, 97, -11, 47}, new byte[]{36, -78, 118, 105, Ascii.SI, -86, 111, 75}))) {
                WebSettingsCompat.setForceDarkStrategy(settings, 1);
                WebSettingsCompat.setForceDark(settings, z ? 2 : 0);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
