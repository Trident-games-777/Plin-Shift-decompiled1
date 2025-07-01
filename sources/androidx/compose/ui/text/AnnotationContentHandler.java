package androidx.compose.ui.text;

import android.text.Editable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0001J&\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010\u0014\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0001J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J)\u0010\u0019\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0001J)\u0010\u001a\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0001J\u0019\u0010\u001b\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u001c0\u001cH\u0001J\u0019\u0010\u001d\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0001J\t\u0010\u001e\u001a\u00020\u0007H\u0001J0\u0010\u001f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016J)\u0010!\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/AnnotationContentHandler;", "Lorg/xml/sax/ContentHandler;", "contentHandler", "output", "Landroid/text/Editable;", "(Lorg/xml/sax/ContentHandler;Landroid/text/Editable;)V", "characters", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "p2", "endDocument", "endElement", "uri", "", "localName", "qName", "endPrefixMapping", "handleAnnotationEnd", "handleAnnotationStart", "attributes", "Lorg/xml/sax/Attributes;", "ignorableWhitespace", "processingInstruction", "setDocumentLocator", "Lorg/xml/sax/Locator;", "skippedEntity", "startDocument", "startElement", "atts", "startPrefixMapping", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Html.android.kt */
final class AnnotationContentHandler implements ContentHandler {
    private final ContentHandler contentHandler;
    private final Editable output;

    public void characters(char[] cArr, int i, int i2) {
        this.contentHandler.characters(cArr, i, i2);
    }

    public void endDocument() {
        this.contentHandler.endDocument();
    }

    public void endPrefixMapping(String str) {
        this.contentHandler.endPrefixMapping(str);
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        this.contentHandler.ignorableWhitespace(cArr, i, i2);
    }

    public void processingInstruction(String str, String str2) {
        this.contentHandler.processingInstruction(str, str2);
    }

    public void setDocumentLocator(Locator locator) {
        this.contentHandler.setDocumentLocator(locator);
    }

    public void skippedEntity(String str) {
        this.contentHandler.skippedEntity(str);
    }

    public void startDocument() {
        this.contentHandler.startDocument();
    }

    public void startPrefixMapping(String str, String str2) {
        this.contentHandler.startPrefixMapping(str, str2);
    }

    public AnnotationContentHandler(ContentHandler contentHandler2, Editable editable) {
        this.contentHandler = contentHandler2;
        this.output = editable;
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (!Intrinsics.areEqual((Object) str2, (Object) "annotation")) {
            this.contentHandler.startElement(str, str2, str3, attributes);
        } else if (attributes != null) {
            handleAnnotationStart(attributes);
        }
    }

    public void endElement(String str, String str2, String str3) {
        if (Intrinsics.areEqual((Object) str2, (Object) "annotation")) {
            handleAnnotationEnd();
        } else {
            this.contentHandler.endElement(str, str2, str3);
        }
    }

    private final void handleAnnotationStart(Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            String localName = attributes.getLocalName(i);
            String str = "";
            if (localName == null) {
                localName = str;
            }
            String value = attributes.getValue(i);
            if (value != null) {
                str = value;
            }
            if (localName.length() > 0 && str.length() > 0) {
                int length2 = this.output.length();
                this.output.setSpan(new AnnotationSpan(localName, str), length2, length2, 17);
            }
        }
    }

    private final void handleAnnotationEnd() {
        Editable editable = this.output;
        Object[] spans = editable.getSpans(0, editable.length(), AnnotationSpan.class);
        Collection arrayList = new ArrayList();
        for (Object obj : spans) {
            if (this.output.getSpanFlags((AnnotationSpan) obj) == 17) {
                arrayList.add(obj);
            }
        }
        List list = (List) arrayList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotationSpan annotationSpan = (AnnotationSpan) list.get(i);
            int spanStart = this.output.getSpanStart(annotationSpan);
            int length = this.output.length();
            this.output.removeSpan(annotationSpan);
            if (spanStart != length) {
                this.output.setSpan(annotationSpan, spanStart, length, 33);
            }
        }
    }
}
