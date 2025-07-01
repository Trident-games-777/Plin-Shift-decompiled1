package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "headerId", "", "dataSize", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ZipFiles.kt */
final class ZipFilesKt$readCentralDirectoryZipEntry$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref.LongRef $compressedSize;
    final /* synthetic */ Ref.BooleanRef $hasZip64Extra;
    final /* synthetic */ Ref.ObjectRef<Long> $ntfsCreatedAtFiletime;
    final /* synthetic */ Ref.ObjectRef<Long> $ntfsLastAccessedAtFiletime;
    final /* synthetic */ Ref.ObjectRef<Long> $ntfsLastModifiedAtFiletime;
    final /* synthetic */ Ref.LongRef $offset;
    final /* synthetic */ long $requiredZip64ExtraSize;
    final /* synthetic */ Ref.LongRef $size;
    final /* synthetic */ BufferedSource $this_readCentralDirectoryZipEntry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZipFilesKt$readCentralDirectoryZipEntry$1(Ref.BooleanRef booleanRef, long j, Ref.LongRef longRef, BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3, Ref.ObjectRef<Long> objectRef, Ref.ObjectRef<Long> objectRef2, Ref.ObjectRef<Long> objectRef3) {
        super(2);
        this.$hasZip64Extra = booleanRef;
        this.$requiredZip64ExtraSize = j;
        this.$size = longRef;
        this.$this_readCentralDirectoryZipEntry = bufferedSource;
        this.$compressedSize = longRef2;
        this.$offset = longRef3;
        this.$ntfsLastModifiedAtFiletime = objectRef;
        this.$ntfsLastAccessedAtFiletime = objectRef2;
        this.$ntfsCreatedAtFiletime = objectRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, long j) {
        if (i != 1) {
            if (i == 10) {
                if (j >= 4) {
                    this.$this_readCentralDirectoryZipEntry.skip(4);
                    final Ref.ObjectRef<Long> objectRef = this.$ntfsLastModifiedAtFiletime;
                    final BufferedSource bufferedSource = this.$this_readCentralDirectoryZipEntry;
                    final Ref.ObjectRef<Long> objectRef2 = this.$ntfsLastAccessedAtFiletime;
                    final Ref.ObjectRef<Long> objectRef3 = this.$ntfsCreatedAtFiletime;
                    ZipFilesKt.readExtra(this.$this_readCentralDirectoryZipEntry, (int) (j - 4), new Function2<Integer, Long, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i, long j) {
                            if (i != 1) {
                                return;
                            }
                            if (objectRef.element != null) {
                                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                            } else if (j == 24) {
                                objectRef.element = Long.valueOf(bufferedSource.readLongLe());
                                objectRef2.element = Long.valueOf(bufferedSource.readLongLe());
                                objectRef3.element = Long.valueOf(bufferedSource.readLongLe());
                            } else {
                                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                            }
                        }
                    });
                    return;
                }
                throw new IOException("bad zip: NTFS extra too short");
            }
        } else if (!this.$hasZip64Extra.element) {
            this.$hasZip64Extra.element = true;
            if (j >= this.$requiredZip64ExtraSize) {
                Ref.LongRef longRef = this.$size;
                longRef.element = longRef.element == 4294967295L ? this.$this_readCentralDirectoryZipEntry.readLongLe() : this.$size.element;
                Ref.LongRef longRef2 = this.$compressedSize;
                long j2 = 0;
                longRef2.element = longRef2.element == 4294967295L ? this.$this_readCentralDirectoryZipEntry.readLongLe() : 0;
                Ref.LongRef longRef3 = this.$offset;
                if (longRef3.element == 4294967295L) {
                    j2 = this.$this_readCentralDirectoryZipEntry.readLongLe();
                }
                longRef3.element = j2;
                return;
            }
            throw new IOException("bad zip: zip64 extra too short");
        } else {
            throw new IOException("bad zip: zip64 extra repeated");
        }
    }
}
