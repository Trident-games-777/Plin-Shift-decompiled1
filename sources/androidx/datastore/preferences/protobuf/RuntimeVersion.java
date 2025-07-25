package androidx.datastore.preferences.protobuf;

import java.util.logging.Logger;

public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN;
    public static final int MAJOR = 4;
    public static final int MINOR = 28;
    public static final RuntimeDomain OSS_DOMAIN;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 28;
    public static final int OSS_PATCH = 2;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 2;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING = versionString(4, 28, 2, "");
    private static final Logger logger = Logger.getLogger(RuntimeVersion.class.getName());

    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = runtimeDomain;
        DOMAIN = runtimeDomain;
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain runtimeDomain, int i, int i2, int i3, String str, String str2) {
        if (!checkDisabled()) {
            validateProtobufGencodeVersionImpl(runtimeDomain, i, i2, i3, str, str2);
        }
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain runtimeDomain, int i, int i2, int i3, String str, String str2) {
        if (!checkDisabled()) {
            String versionString = versionString(i, i2, i3, str);
            if (i < 0 || i2 < 0 || i3 < 0) {
                throw new ProtobufRuntimeVersionException("Invalid gencode version: " + versionString);
            }
            RuntimeDomain runtimeDomain2 = DOMAIN;
            if (runtimeDomain == runtimeDomain2) {
                if (i != 4) {
                    if (i == 3) {
                        logger.warning(String.format(" Protobuf gencode version %s is exactly one major version older than the runtime version %s at %s. Please update the gencode to avoid compatibility violations in the next runtime release.", new Object[]{versionString, VERSION_STRING, str2}));
                    } else {
                        throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime major versions when loading %s: gencode %s, runtime %s. Same major version is required.", new Object[]{str2, versionString, VERSION_STRING}));
                    }
                }
                if (28 < i2 || (i2 == 28 && 2 < i3)) {
                    throw new ProtobufRuntimeVersionException(String.format("Detected incompatible Protobuf Gencode/Runtime versions when loading %s: gencode %s, runtime %s. Runtime version cannot be older than the linked gencode version.", new Object[]{str2, versionString, VERSION_STRING}));
                }
                if (28 > i2 || 2 > i3) {
                    logger.warning(String.format(" Protobuf gencode version %s is older than the runtime version %s at %s. Please avoid checked-in Protobuf gencode that can be obsolete.", new Object[]{versionString, VERSION_STRING, str2}));
                }
                if (!str.equals("")) {
                    throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading %s: gencode %s, runtime %s. Version suffixes must be the same.", new Object[]{str2, versionString, VERSION_STRING}));
                }
                return;
            }
            throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime domains when loading %s: gencode %s, runtime %s. Cross-domain usage of Protobuf is not supported.", new Object[]{str2, runtimeDomain, runtimeDomain2}));
        }
    }

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String str) {
            super(str);
        }
    }

    private static String versionString(int i, int i2, int i3, String str) {
        return String.format("%d.%d.%d%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
    }

    private static boolean checkDisabled() {
        String str = System.getenv("TEMORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        return str != null && str.equals("true");
    }

    private RuntimeVersion() {
    }
}
