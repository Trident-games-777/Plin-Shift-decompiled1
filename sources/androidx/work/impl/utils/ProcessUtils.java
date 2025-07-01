package androidx.work.impl.utils;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;

public class ProcessUtils {
    private static final String TAG = Logger.tagWithPrefix("ProcessUtils");

    private ProcessUtils() {
    }

    public static boolean isDefaultProcess(Context context, Configuration configuration) {
        String processName = getProcessName(context);
        if (!TextUtils.isEmpty(configuration.getDefaultProcessName())) {
            return TextUtils.equals(processName, configuration.getDefaultProcessName());
        }
        return TextUtils.equals(processName, context.getApplicationInfo().processName);
    }

    public static String getProcessName(Context context) {
        return Application.getProcessName();
    }
}
