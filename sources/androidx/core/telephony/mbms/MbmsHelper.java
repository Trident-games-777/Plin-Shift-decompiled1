package androidx.core.telephony.mbms;

import android.content.Context;
import android.telephony.mbms.ServiceInfo;
import java.util.Locale;
import java.util.Set;

public final class MbmsHelper {
    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
        return Api28Impl.getBestNameForService(context, serviceInfo);
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
            Set<Locale> namedContentLocales = serviceInfo.getNamedContentLocales();
            if (namedContentLocales.isEmpty()) {
                return null;
            }
            String[] strArr = new String[namedContentLocales.size()];
            int i = 0;
            for (Locale languageTag : serviceInfo.getNamedContentLocales()) {
                strArr[i] = languageTag.toLanguageTag();
                i++;
            }
            Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
            if (firstMatch == null) {
                return null;
            }
            return serviceInfo.getNameForLocale(firstMatch);
        }
    }
}
