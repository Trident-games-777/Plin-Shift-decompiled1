package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@CheckReturnValue
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema2;
        this.hasExtensions = extensionSchema2.hasExtensions(messageLite);
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema2, extensionSchema2, messageLite);
    }

    public T newInstance() {
        MessageLite messageLite = this.defaultInstance;
        if (messageLite instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) messageLite).newMutableInstance();
        }
        return messageLite.newBuilderForType().buildPartial();
    }

    public boolean equals(T t, T t2) {
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    public int hashCode(T t) {
        int hashCode = this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode() : hashCode;
    }

    public void mergeFrom(T t, T t2) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    public void writeTo(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.extensionSchema.getExtensions(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof LazyField.LazyEntry) {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) next).getField().toByteString());
            } else {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), next.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, t, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t, Writer writer) throws IOException {
        unknownFieldSchema2.writeAsMessageSetTo(unknownFieldSchema2.getFromMessage(t), writer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeFrom(T r11, byte[] r12, int r13, int r14, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L_0x0011
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.newInstance()
            r0.unknownFields = r1
        L_0x0011:
            r6 = r1
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            androidx.datastore.preferences.protobuf.FieldSet r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r1 = r0
        L_0x001a:
            if (r13 >= r14) goto L_0x00dd
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r12, r13, r15)
            int r2 = r15.int1
            int r13 = androidx.datastore.preferences.protobuf.WireFormat.MESSAGE_SET_ITEM_TAG
            r3 = 2
            if (r2 == r13) goto L_0x006b
            int r13 = androidx.datastore.preferences.protobuf.WireFormat.getTagWireType(r2)
            if (r13 != r3) goto L_0x0064
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r13 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = r15.extensionRegistry
            androidx.datastore.preferences.protobuf.MessageLite r3 = r10.defaultInstance
            int r5 = androidx.datastore.preferences.protobuf.WireFormat.getTagFieldNumber(r2)
            java.lang.Object r13 = r13.findExtensionByNumber(r1, r3, r5)
            r1 = r13
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r1 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r1
            if (r1 == 0) goto L_0x005c
            androidx.datastore.preferences.protobuf.Protobuf r13 = androidx.datastore.preferences.protobuf.Protobuf.getInstance()
            androidx.datastore.preferences.protobuf.MessageLite r2 = r1.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            androidx.datastore.preferences.protobuf.Schema r13 = r13.schemaFor(r2)
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeMessageField(r13, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r1.descriptor
            java.lang.Object r3 = r15.object1
            r11.setField(r2, r3)
            goto L_0x001a
        L_0x005c:
            r3 = r12
            r5 = r14
            r7 = r15
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeUnknownField(r2, r3, r4, r5, r6, r7)
            goto L_0x001a
        L_0x0064:
            r5 = r14
            r7 = r15
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.skipField(r2, r12, r4, r5, r7)
            goto L_0x001a
        L_0x006b:
            r5 = r14
            r7 = r15
            r13 = 0
            r14 = r0
        L_0x006f:
            if (r4 >= r5) goto L_0x00ce
            int r15 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r7)
            int r2 = r7.int1
            int r4 = androidx.datastore.preferences.protobuf.WireFormat.getTagFieldNumber(r2)
            int r8 = androidx.datastore.preferences.protobuf.WireFormat.getTagWireType(r2)
            if (r4 == r3) goto L_0x00ae
            r9 = 3
            if (r4 == r9) goto L_0x0085
            goto L_0x00c4
        L_0x0085:
            if (r1 == 0) goto L_0x00a3
            androidx.datastore.preferences.protobuf.Protobuf r2 = androidx.datastore.preferences.protobuf.Protobuf.getInstance()
            androidx.datastore.preferences.protobuf.MessageLite r4 = r1.getMessageDefaultInstance()
            java.lang.Class r4 = r4.getClass()
            androidx.datastore.preferences.protobuf.Schema r2 = r2.schemaFor(r4)
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeMessageField(r2, r12, r15, r5, r7)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r15 = r1.descriptor
            java.lang.Object r2 = r7.object1
            r11.setField(r15, r2)
            goto L_0x006f
        L_0x00a3:
            if (r8 != r3) goto L_0x00c4
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeBytes(r12, r15, r7)
            java.lang.Object r14 = r7.object1
            androidx.datastore.preferences.protobuf.ByteString r14 = (androidx.datastore.preferences.protobuf.ByteString) r14
            goto L_0x006f
        L_0x00ae:
            if (r8 != 0) goto L_0x00c4
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r12, r15, r7)
            int r13 = r7.int1
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r15 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = r7.extensionRegistry
            androidx.datastore.preferences.protobuf.MessageLite r2 = r10.defaultInstance
            java.lang.Object r15 = r15.findExtensionByNumber(r1, r2, r13)
            r1 = r15
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r1 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r1
            goto L_0x006f
        L_0x00c4:
            int r4 = androidx.datastore.preferences.protobuf.WireFormat.MESSAGE_SET_ITEM_END_TAG
            if (r2 != r4) goto L_0x00c9
            goto L_0x00cf
        L_0x00c9:
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.skipField(r2, r12, r15, r5, r7)
            goto L_0x006f
        L_0x00ce:
            r15 = r4
        L_0x00cf:
            if (r14 == 0) goto L_0x00d8
            int r13 = androidx.datastore.preferences.protobuf.WireFormat.makeTag(r13, r3)
            r6.storeField(r13, r14)
        L_0x00d8:
            r13 = r15
            r14 = r5
            r15 = r7
            goto L_0x001a
        L_0x00dd:
            r5 = r14
            if (r13 != r5) goto L_0x00e1
            return
        L_0x00e1:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):void");
    }

    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, ExtensionSchema<ET> extensionSchema2, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UnknownFieldSchema<UT, UB> unknownFieldSchema3;
        UB builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t);
        FieldSet<ET> mutableExtensions = extensionSchema2.getMutableExtensions(t);
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            try {
                unknownFieldSchema3 = unknownFieldSchema2;
                ExtensionSchema<ET> extensionSchema3 = extensionSchema2;
                Reader reader2 = reader;
                ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
                try {
                    if (parseMessageSetItemOrUnknownField(reader2, extensionRegistryLite2, extensionSchema3, mutableExtensions, unknownFieldSchema3, builderFromMessage)) {
                        reader = reader2;
                        extensionRegistryLite = extensionRegistryLite2;
                        extensionSchema2 = extensionSchema3;
                        unknownFieldSchema2 = unknownFieldSchema3;
                    } else {
                        unknownFieldSchema3.setBuilderToMessage(t, builderFromMessage);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    unknownFieldSchema3.setBuilderToMessage(t, builderFromMessage);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                unknownFieldSchema3 = unknownFieldSchema2;
                Throwable th22 = th;
                unknownFieldSchema3.setBuilderToMessage(t, builderFromMessage);
                throw th22;
            }
        }
        unknownFieldSchema2.setBuilderToMessage(t, builderFromMessage);
    }

    public void makeImmutable(T t) {
        this.unknownFieldSchema.makeImmutable(t);
        this.extensionSchema.makeImmutable(t);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema2, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema2, UB ub) throws IOException {
        int tag = reader.getTag();
        int i = 0;
        if (tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
            Object obj = null;
            ByteString byteString = null;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = reader.getTag();
                if (tag2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    i = reader.readUInt32();
                    obj = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, i);
                } else if (tag2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (obj != null) {
                        extensionSchema2.parseLengthPrefixedMessageSetItem(reader, obj, extensionRegistryLite, fieldSet);
                    } else {
                        byteString = reader.readBytes();
                    }
                } else if (!reader.skipField()) {
                    break;
                }
            }
            if (reader.getTag() == WireFormat.MESSAGE_SET_ITEM_END_TAG) {
                if (byteString != null) {
                    if (obj != null) {
                        extensionSchema2.parseMessageSetItem(byteString, obj, extensionRegistryLite, fieldSet);
                    } else {
                        unknownFieldSchema2.addLengthDelimited(ub, i, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (WireFormat.getTagWireType(tag) != 2) {
            return reader.skipField();
        } else {
            Object findExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
            if (findExtensionByNumber == null) {
                return unknownFieldSchema2.mergeOneFieldFrom(ub, reader, 0);
            }
            extensionSchema2.parseLengthPrefixedMessageSetItem(reader, findExtensionByNumber, extensionRegistryLite, fieldSet);
            return true;
        }
    }

    public final boolean isInitialized(T t) {
        return this.extensionSchema.getExtensions(t).isInitialized();
    }

    public int getSerializedSize(T t) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t) {
        return unknownFieldSchema2.getSerializedSizeAsMessageSet(unknownFieldSchema2.getFromMessage(t));
    }
}
