package androidx.datastore.preferences.protobuf;

import java.io.IOException;

@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* access modifiers changed from: package-private */
    public abstract void addFixed32(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void addFixed64(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void addGroup(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void addLengthDelimited(B b, int i, ByteString byteString);

    /* access modifiers changed from: package-private */
    public abstract void addVarint(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract B getBuilderFromMessage(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T getFromMessage(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int getSerializedSize(T t);

    /* access modifiers changed from: package-private */
    public abstract int getSerializedSizeAsMessageSet(T t);

    /* access modifiers changed from: package-private */
    public abstract void makeImmutable(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T merge(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract B newBuilder();

    /* access modifiers changed from: package-private */
    public abstract void setBuilderToMessage(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract void setToMessage(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    /* access modifiers changed from: package-private */
    public abstract T toImmutable(B b);

    /* access modifiers changed from: package-private */
    public abstract void writeAsMessageSetTo(T t, Writer writer) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeTo(T t, Writer writer) throws IOException;

    UnknownFieldSchema() {
    }

    /* access modifiers changed from: package-private */
    public final boolean mergeOneFieldFrom(B b, Reader reader, int i) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b, tagFieldNumber, reader.readInt64());
            return true;
        } else if (tagWireType == 1) {
            addFixed64(b, tagFieldNumber, reader.readFixed64());
            return true;
        } else if (tagWireType == 2) {
            addLengthDelimited(b, tagFieldNumber, reader.readBytes());
            return true;
        } else if (tagWireType == 3) {
            Object newBuilder = newBuilder();
            int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
            int i2 = i + 1;
            if (i2 < recursionLimit) {
                mergeFrom(newBuilder, reader, i2);
                if (makeTag == reader.getTag()) {
                    addGroup(b, tagFieldNumber, toImmutable(newBuilder));
                    return true;
                }
                throw InvalidProtocolBufferException.invalidEndTag();
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                addFixed32(b, tagFieldNumber, reader.readFixed32());
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void mergeFrom(B r3, androidx.datastore.preferences.protobuf.Reader r4, int r5) throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.getFieldNumber()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.mergeOneFieldFrom(r3, r4, r5)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.UnknownFieldSchema.mergeFrom(java.lang.Object, androidx.datastore.preferences.protobuf.Reader, int):void");
    }

    public void setRecursionLimit(int i) {
        recursionLimit = i;
    }
}
