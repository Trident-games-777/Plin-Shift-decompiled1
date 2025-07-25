package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

final class AutoValue_BackendResponse extends BackendResponse {
    private final long nextRequestWaitMillis;
    private final BackendResponse.Status status;

    AutoValue_BackendResponse(BackendResponse.Status status2, long j) {
        if (status2 != null) {
            this.status = status2;
            this.nextRequestWaitMillis = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public BackendResponse.Status getStatus() {
        return this.status;
    }

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public String toString() {
        return "BackendResponse{status=" + this.status + ", nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BackendResponse) {
            BackendResponse backendResponse = (BackendResponse) obj;
            return this.status.equals(backendResponse.getStatus()) && this.nextRequestWaitMillis == backendResponse.getNextRequestWaitMillis();
        }
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((this.status.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
