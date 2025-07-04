package androidx.webkit;

import android.content.Context;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.webkit.internal.ApiHelperForP;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;

public class ProcessGlobalConfig {
    private static boolean sApplyCalled = false;
    private static final Object sLock = new Object();
    private static final AtomicReference<HashMap<String, Object>> sProcessGlobalConfig = new AtomicReference<>();
    String mCacheDirectoryBasePath;
    String mDataDirectoryBasePath;
    String mDataDirectorySuffix;

    public ProcessGlobalConfig setDataDirectorySuffix(Context context, String str) {
        if (!WebViewFeatureInternal.STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX.isSupported(context)) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        } else if (str.equals("")) {
            throw new IllegalArgumentException("Suffix cannot be an empty string");
        } else if (str.indexOf(File.separatorChar) < 0) {
            this.mDataDirectorySuffix = str;
            return this;
        } else {
            throw new IllegalArgumentException("Suffix " + str + " contains a path separator");
        }
    }

    public ProcessGlobalConfig setDirectoryBasePaths(Context context, File file, File file2) {
        if (!WebViewFeatureInternal.STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH.isSupported(context)) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        } else if (!file.isAbsolute()) {
            throw new IllegalArgumentException("dataDirectoryBasePath must be a non-empty absolute path");
        } else if (file2.isAbsolute()) {
            this.mDataDirectoryBasePath = file.getAbsolutePath();
            this.mCacheDirectoryBasePath = file2.getAbsolutePath();
            return this;
        } else {
            throw new IllegalArgumentException("cacheDirectoryBasePath must be a non-empty absolute path");
        }
    }

    public static void apply(ProcessGlobalConfig processGlobalConfig) {
        synchronized (sLock) {
            if (!sApplyCalled) {
                sApplyCalled = true;
            } else {
                throw new IllegalStateException("ProcessGlobalConfig#apply was called more than once, which is an illegal operation. The configuration settings provided by ProcessGlobalConfig take effect only once, when WebView is first loaded into the current process. Every process should only ever create a single instance of ProcessGlobalConfig and apply it once, before any calls to android.webkit APIs, such as during early app startup.");
            }
        }
        HashMap hashMap = new HashMap();
        if (!webViewCurrentlyLoaded()) {
            if (processGlobalConfig.mDataDirectorySuffix != null) {
                if (WebViewFeatureInternal.STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX.isSupportedByFramework()) {
                    ApiHelperForP.setDataDirectorySuffix(processGlobalConfig.mDataDirectorySuffix);
                } else {
                    hashMap.put(ProcessGlobalConfigConstants.DATA_DIRECTORY_SUFFIX, processGlobalConfig.mDataDirectorySuffix);
                }
            }
            String str = processGlobalConfig.mDataDirectoryBasePath;
            if (str != null) {
                hashMap.put(ProcessGlobalConfigConstants.DATA_DIRECTORY_BASE_PATH, str);
            }
            String str2 = processGlobalConfig.mCacheDirectoryBasePath;
            if (str2 != null) {
                hashMap.put(ProcessGlobalConfigConstants.CACHE_DIRECTORY_BASE_PATH, str2);
            }
            if (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(sProcessGlobalConfig, (Object) null, hashMap)) {
                throw new RuntimeException("Attempting to set ProcessGlobalConfig#sProcessGlobalConfig when it was already set");
            }
            return;
        }
        throw new IllegalStateException("WebView has already been loaded in the current process, so any attempt to apply the settings in ProcessGlobalConfig will have no effect. ProcessGlobalConfig#apply needs to be called before any calls to android.webkit APIs, such as during early app startup.");
    }

    private static boolean webViewCurrentlyLoaded() {
        try {
            Field declaredField = Class.forName("android.webkit.WebViewFactory").getDeclaredField("sProviderInstance");
            declaredField.setAccessible(true);
            if (declaredField.get((Object) null) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}
