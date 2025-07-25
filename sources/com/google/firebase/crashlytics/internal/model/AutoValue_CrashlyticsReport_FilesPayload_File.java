package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;

final class AutoValue_CrashlyticsReport_FilesPayload_File extends CrashlyticsReport.FilesPayload.File {
    private final byte[] contents;
    private final String filename;

    private AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr) {
        this.filename = str;
        this.contents = bArr;
    }

    public String getFilename() {
        return this.filename;
    }

    public byte[] getContents() {
        return this.contents;
    }

    public String toString() {
        return "File{filename=" + this.filename + ", contents=" + Arrays.toString(this.contents) + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.FilesPayload.File) {
            CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
            if (this.filename.equals(file.getFilename())) {
                if (Arrays.equals(this.contents, file instanceof AutoValue_CrashlyticsReport_FilesPayload_File ? ((AutoValue_CrashlyticsReport_FilesPayload_File) file).contents : file.getContents())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.filename.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.contents);
    }

    static final class Builder extends CrashlyticsReport.FilesPayload.File.Builder {
        private byte[] contents;
        private String filename;

        Builder() {
        }

        public CrashlyticsReport.FilesPayload.File.Builder setFilename(String str) {
            if (str != null) {
                this.filename = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }

        public CrashlyticsReport.FilesPayload.File.Builder setContents(byte[] bArr) {
            if (bArr != null) {
                this.contents = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        public CrashlyticsReport.FilesPayload.File build() {
            if (this.filename != null && this.contents != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(this.filename, this.contents);
            }
            StringBuilder sb = new StringBuilder();
            if (this.filename == null) {
                sb.append(" filename");
            }
            if (this.contents == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }
    }
}
