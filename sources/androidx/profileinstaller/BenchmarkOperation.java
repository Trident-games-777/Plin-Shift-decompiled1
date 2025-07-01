package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class BenchmarkOperation {
    private BenchmarkOperation() {
    }

    static void dropShaderCache(Context context, ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        File file;
        if (Build.VERSION.SDK_INT >= 34) {
            file = Api24ContextHelper.createDeviceProtectedStorageContext(context).getCacheDir();
        } else {
            file = Api21ContextHelper.getCodeCacheDir(Api24ContextHelper.createDeviceProtectedStorageContext(context));
        }
        if (deleteFilesRecursively(file)) {
            resultDiagnostics.onResultReceived(14, (Object) null);
        } else {
            resultDiagnostics.onResultReceived(15, (Object) null);
        }
    }

    static boolean deleteFilesRecursively(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            int length = listFiles.length;
            boolean z = true;
            for (int i = 0; i < length; i++) {
                z = deleteFilesRecursively(listFiles[i]) && z;
            }
            return z;
        }
        file.delete();
        return true;
    }

    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }
}
