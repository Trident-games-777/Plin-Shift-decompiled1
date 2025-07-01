package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0();

    private FontProvider() {
    }

    static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (provider == null) {
            return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
        }
        return FontsContractCompat.FontFamilyResult.create(0, query(context, fontRequest, provider.authority, cancellationSignal));
    }

    static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(convertToByteArrayList, sByteArrayComparator);
            List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
            for (int i = 0; i < certificates.size(); i++) {
                ArrayList arrayList = new ArrayList(certificates.get(i));
                Collections.sort(arrayList, sByteArrayComparator);
                if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.provider.FontsContractCompat.FontInfo[] query(android.content.Context r18, androidx.core.provider.FontRequest r19, java.lang.String r20, android.os.CancellationSignal r21) {
        /*
            r0 = r20
            java.lang.String r1 = "result_code"
            java.lang.String r2 = "font_italic"
            java.lang.String r3 = "font_weight"
            java.lang.String r4 = "font_ttc_index"
            java.lang.String r5 = "file_id"
            java.lang.String r6 = "_id"
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri$Builder r8 = new android.net.Uri$Builder
            r8.<init>()
            java.lang.String r9 = "content"
            android.net.Uri$Builder r8 = r8.scheme(r9)
            android.net.Uri$Builder r8 = r8.authority(r0)
            android.net.Uri r11 = r8.build()
            android.net.Uri$Builder r8 = new android.net.Uri$Builder
            r8.<init>()
            android.net.Uri$Builder r8 = r8.scheme(r9)
            android.net.Uri$Builder r0 = r8.authority(r0)
            java.lang.String r8 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r8)
            android.net.Uri r0 = r0.build()
            r8 = r18
            androidx.core.provider.FontProvider$ContentQueryWrapper r10 = androidx.core.provider.FontProvider.ContentQueryWrapper.make(r8, r11)
            r8 = 7
            java.lang.String[] r12 = new java.lang.String[r8]     // Catch:{ all -> 0x00fe }
            r8 = 0
            r12[r8] = r6     // Catch:{ all -> 0x00fe }
            r13 = 1
            r12[r13] = r5     // Catch:{ all -> 0x00fe }
            r14 = 2
            r12[r14] = r4     // Catch:{ all -> 0x00fe }
            java.lang.String r14 = "font_variation_settings"
            r15 = 3
            r12[r15] = r14     // Catch:{ all -> 0x00fe }
            r14 = 4
            r12[r14] = r3     // Catch:{ all -> 0x00fe }
            r14 = 5
            r12[r14] = r2     // Catch:{ all -> 0x00fe }
            r14 = 6
            r12[r14] = r1     // Catch:{ all -> 0x00fe }
            java.lang.String r14 = "query = ?"
            r15 = r14
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ all -> 0x00fe }
            java.lang.String r16 = r19.getQuery()     // Catch:{ all -> 0x00fe }
            r14[r8] = r16     // Catch:{ all -> 0x00fe }
            r16 = r13
            r13 = r15
            r15 = 0
            r9 = r16
            r16 = r21
            android.database.Cursor r12 = r10.query(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00fe }
            if (r12 == 0) goto L_0x00ec
            int r13 = r12.getCount()     // Catch:{ all -> 0x00e9 }
            if (r13 <= 0) goto L_0x00ec
            int r1 = r12.getColumnIndex(r1)     // Catch:{ all -> 0x00e9 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00e9 }
            r7.<init>()     // Catch:{ all -> 0x00e9 }
            int r6 = r12.getColumnIndex(r6)     // Catch:{ all -> 0x00e9 }
            int r5 = r12.getColumnIndex(r5)     // Catch:{ all -> 0x00e9 }
            int r4 = r12.getColumnIndex(r4)     // Catch:{ all -> 0x00e9 }
            int r3 = r12.getColumnIndex(r3)     // Catch:{ all -> 0x00e9 }
            int r2 = r12.getColumnIndex(r2)     // Catch:{ all -> 0x00e9 }
        L_0x0099:
            boolean r13 = r12.moveToNext()     // Catch:{ all -> 0x00e9 }
            if (r13 == 0) goto L_0x00ec
            r13 = -1
            if (r1 == r13) goto L_0x00a7
            int r14 = r12.getInt(r1)     // Catch:{ all -> 0x00e9 }
            goto L_0x00a8
        L_0x00a7:
            r14 = r8
        L_0x00a8:
            if (r4 == r13) goto L_0x00af
            int r15 = r12.getInt(r4)     // Catch:{ all -> 0x00e9 }
            goto L_0x00b0
        L_0x00af:
            r15 = r8
        L_0x00b0:
            if (r5 != r13) goto L_0x00bb
            long r8 = r12.getLong(r6)     // Catch:{ all -> 0x00e9 }
            android.net.Uri r8 = android.content.ContentUris.withAppendedId(r11, r8)     // Catch:{ all -> 0x00e9 }
            goto L_0x00c3
        L_0x00bb:
            long r8 = r12.getLong(r5)     // Catch:{ all -> 0x00e9 }
            android.net.Uri r8 = android.content.ContentUris.withAppendedId(r0, r8)     // Catch:{ all -> 0x00e9 }
        L_0x00c3:
            if (r3 == r13) goto L_0x00ca
            int r9 = r12.getInt(r3)     // Catch:{ all -> 0x00e9 }
            goto L_0x00cc
        L_0x00ca:
            r9 = 400(0x190, float:5.6E-43)
        L_0x00cc:
            if (r2 == r13) goto L_0x00d9
            int r13 = r12.getInt(r2)     // Catch:{ all -> 0x00e9 }
            r17 = r0
            r0 = 1
            if (r13 != r0) goto L_0x00dc
            r13 = r0
            goto L_0x00dd
        L_0x00d9:
            r17 = r0
            r0 = 1
        L_0x00dc:
            r13 = 0
        L_0x00dd:
            androidx.core.provider.FontsContractCompat$FontInfo r8 = androidx.core.provider.FontsContractCompat.FontInfo.create(r8, r15, r9, r13, r14)     // Catch:{ all -> 0x00e9 }
            r7.add(r8)     // Catch:{ all -> 0x00e9 }
            r9 = r0
            r0 = r17
            r8 = 0
            goto L_0x0099
        L_0x00e9:
            r0 = move-exception
            r9 = r12
            goto L_0x0100
        L_0x00ec:
            if (r12 == 0) goto L_0x00f1
            r12.close()
        L_0x00f1:
            r10.close()
            r0 = 0
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = new androidx.core.provider.FontsContractCompat.FontInfo[r0]
            java.lang.Object[] r0 = r7.toArray(r0)
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = (androidx.core.provider.FontsContractCompat.FontInfo[]) r0
            return r0
        L_0x00fe:
            r0 = move-exception
            r9 = 0
        L_0x0100:
            if (r9 == 0) goto L_0x0105
            r9.close()
        L_0x0105:
            r10.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.query(android.content.Context, androidx.core.provider.FontRequest, java.lang.String, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontInfo[]");
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    static /* synthetic */ int lambda$static$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private interface ContentQueryWrapper {
        void close();

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        static ContentQueryWrapper make(Context context, Uri uri) {
            return new ContentQueryWrapperApi24Impl(context, uri);
        }
    }

    private static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }
}
