package coil3.decode;

import android.content.res.AssetFileDescriptor;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import coil3.decode.ImageSource;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"toImageDecoderSourceOrNull", "Landroid/graphics/ImageDecoder$Source;", "Lcoil3/decode/ImageSource;", "options", "Lcoil3/request/Options;", "animated", "", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: StaticImageDecoder.kt */
public final class StaticImageDecoderKt {
    /* access modifiers changed from: private */
    public static final AssetFileDescriptor toImageDecoderSourceOrNull$lambda$0(AssetFileDescriptor assetFileDescriptor) {
        return assetFileDescriptor;
    }

    public static final ImageDecoder.Source toImageDecoderSourceOrNull(ImageSource imageSource, Options options, boolean z) {
        Path fileOrNull;
        if (imageSource.getFileSystem() == FileSystem.SYSTEM && (fileOrNull = imageSource.fileOrNull()) != null) {
            return ImageDecoder.createSource(fileOrNull.toFile());
        }
        ImageSource.Metadata metadata = imageSource.getMetadata();
        if (metadata instanceof AssetMetadata) {
            return ImageDecoder.createSource(options.getContext().getAssets(), ((AssetMetadata) metadata).getFilePath());
        }
        if (!(metadata instanceof ContentMetadata) || Build.VERSION.SDK_INT < 29) {
            if (metadata instanceof ResourceMetadata) {
                ResourceMetadata resourceMetadata = (ResourceMetadata) metadata;
                if (Intrinsics.areEqual((Object) resourceMetadata.getPackageName(), (Object) options.getContext().getPackageName())) {
                    return ImageDecoder.createSource(options.getContext().getResources(), resourceMetadata.getResId());
                }
            }
            if (!(metadata instanceof ByteBufferMetadata)) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30 || !z || ((ByteBufferMetadata) metadata).getByteBuffer().isDirect()) {
                return ImageDecoder.createSource(((ByteBufferMetadata) metadata).getByteBuffer());
            }
            return null;
        }
        try {
            AssetFileDescriptor assetFileDescriptor = ((ContentMetadata) metadata).getAssetFileDescriptor();
            Os.lseek(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), OsConstants.SEEK_SET);
            return ImageDecoder.createSource(new StaticImageDecoderKt$$ExternalSyntheticLambda0(assetFileDescriptor));
        } catch (ErrnoException unused) {
            return null;
        }
    }
}
