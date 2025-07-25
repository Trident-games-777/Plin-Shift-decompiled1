package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public abstract class ApiFeature implements ConditionallySupportedFeature {
    private static final Set<ApiFeature> sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public abstract boolean isSupportedByFramework();

    ApiFeature(String str, String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    public boolean isSupported() {
        return isSupportedByFramework() || isSupportedByWebView();
    }

    public boolean isSupportedByWebView() {
        return BoundaryInterfaceReflectionUtil.containsFeature((Collection<String>) LAZY_HOLDER.WEBVIEW_APK_FEATURES, this.mInternalFeatureValue);
    }

    public static Set<ApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    public static Set<String> getWebViewApkFeaturesForTesting() {
        return LAZY_HOLDER.WEBVIEW_APK_FEATURES;
    }

    private static class LAZY_HOLDER {
        static final Set<String> WEBVIEW_APK_FEATURES = new HashSet(Arrays.asList(WebViewGlueCommunicator.getFactory().getWebViewFeatures()));

        private LAZY_HOLDER() {
        }
    }

    public static class NoFramework extends ApiFeature {
        public final boolean isSupportedByFramework() {
            return false;
        }

        NoFramework(String str, String str2) {
            super(str, str2);
        }
    }

    public static class M extends ApiFeature {
        public final boolean isSupportedByFramework() {
            return true;
        }

        M(String str, String str2) {
            super(str, str2);
        }
    }

    public static class N extends ApiFeature {
        public final boolean isSupportedByFramework() {
            return true;
        }

        N(String str, String str2) {
            super(str, str2);
        }
    }

    public static class O extends ApiFeature {
        public final boolean isSupportedByFramework() {
            return true;
        }

        O(String str, String str2) {
            super(str, str2);
        }
    }

    public static class O_MR1 extends ApiFeature {
        public final boolean isSupportedByFramework() {
            return true;
        }

        O_MR1(String str, String str2) {
            super(str, str2);
        }
    }

    public static class P extends ApiFeature {
        public final boolean isSupportedByFramework() {
            return true;
        }

        P(String str, String str2) {
            super(str, str2);
        }
    }

    public static class Q extends ApiFeature {
        Q(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    public static class T extends ApiFeature {
        T(String str, String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }
}
