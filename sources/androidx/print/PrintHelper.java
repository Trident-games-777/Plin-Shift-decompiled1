package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.util.Log;
import java.io.FileNotFoundException;

public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = true;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = true;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode = 2;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions = null;
    final Object mLock = new Object();
    int mOrientation = 1;
    int mScaleMode = 2;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    public PrintHelper(Context context) {
        this.mContext = context;
    }

    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public void setColorMode(int i) {
        this.mColorMode = i;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public int getOrientation() {
        int i = this.mOrientation;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public void printBitmap(String str, Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap != null) {
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            if (isPortrait(bitmap)) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            String str2 = str;
            printManager.print(str2, new PrintBitmapAdapter(str2, this.mScaleMode, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build());
        }
    }

    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;

        PrintBitmapAdapter(String str, int i, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.mJobName = str;
            this.mFittingMode = i;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.mAttributes = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }

        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        String str2 = str;
        PrintUriAdapter printUriAdapter = new PrintUriAdapter(str2, uri, onPrintFinishCallback, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.mColorMode);
        int i = this.mOrientation;
        if (i == 1 || i == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str2, printUriAdapter, builder.build());
    }

    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap = null;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

        PrintUriAdapter(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.mJobName = str;
            this.mImageFile = uri;
            this.mCallback = onPrintFinishCallback;
            this.mFittingMode = i;
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
            r0 = th;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onLayout(android.print.PrintAttributes r7, android.print.PrintAttributes r8, android.os.CancellationSignal r9, android.print.PrintDocumentAdapter.LayoutResultCallback r10, android.os.Bundle r11) {
            /*
                r6 = this;
                monitor-enter(r6)
                r6.mAttributes = r8     // Catch:{ all -> 0x0043 }
                monitor-exit(r6)     // Catch:{ all -> 0x0043 }
                boolean r11 = r9.isCanceled()
                if (r11 == 0) goto L_0x000e
                r10.onLayoutCancelled()
                return
            L_0x000e:
                android.graphics.Bitmap r11 = r6.mBitmap
                if (r11 == 0) goto L_0x002f
                android.print.PrintDocumentInfo$Builder r9 = new android.print.PrintDocumentInfo$Builder
                java.lang.String r11 = r6.mJobName
                r9.<init>(r11)
                r11 = 1
                android.print.PrintDocumentInfo$Builder r9 = r9.setContentType(r11)
                android.print.PrintDocumentInfo$Builder r9 = r9.setPageCount(r11)
                android.print.PrintDocumentInfo r9 = r9.build()
                boolean r7 = r8.equals(r7)
                r7 = r7 ^ r11
                r10.onLayoutFinished(r9, r7)
                return
            L_0x002f:
                androidx.print.PrintHelper$PrintUriAdapter$1 r0 = new androidx.print.PrintHelper$PrintUriAdapter$1
                r1 = r6
                r4 = r7
                r3 = r8
                r2 = r9
                r5 = r10
                r0.<init>(r2, r3, r4, r5)
                r7 = 0
                android.net.Uri[] r7 = new android.net.Uri[r7]
                android.os.AsyncTask r7 = r0.execute(r7)
                r1.mLoadBitmap = r7
                return
            L_0x0043:
                r0 = move-exception
                r1 = r6
            L_0x0045:
                r7 = r0
                monitor-exit(r6)     // Catch:{ all -> 0x0048 }
                throw r7
            L_0x0048:
                r0 = move-exception
                goto L_0x0045
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.PrintUriAdapter.onLayout(android.print.PrintAttributes, android.print.PrintAttributes, android.os.CancellationSignal, android.print.PrintDocumentAdapter$LayoutResultCallback, android.os.Bundle):void");
        }

        /* access modifiers changed from: package-private */
        public void cancelLoad() {
            synchronized (PrintHelper.this.mLock) {
                if (PrintHelper.this.mDecodeOptions != null) {
                    PrintHelper.this.mDecodeOptions = null;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.mLoadBitmap;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static boolean isPortrait(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix getMatrix(int i, int i2, RectF rectF, int i3) {
        float f;
        Matrix matrix = new Matrix();
        float f2 = (float) i;
        float width = rectF.width() / f2;
        if (i3 == 2) {
            f = Math.max(width, rectF.height() / ((float) i2));
        } else {
            f = Math.min(width, rectF.height() / ((float) i2));
        }
        matrix.postScale(f, f);
        matrix.postTranslate((rectF.width() - (f2 * f)) / 2.0f, (rectF.height() - (((float) i2) * f)) / 2.0f);
        return matrix;
    }

    /* access modifiers changed from: package-private */
    public void writeBitmap(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes printAttributes2;
        if (IS_MIN_MARGINS_HANDLING_CORRECT) {
            printAttributes2 = printAttributes;
        } else {
            printAttributes2 = copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        final PrintAttributes printAttributes3 = printAttributes;
        final int i2 = i;
        final Bitmap bitmap2 = bitmap;
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        final CancellationSignal cancellationSignal2 = cancellationSignal;
        final PrintDocumentAdapter.WriteResultCallback writeResultCallback2 = writeResultCallback;
        new AsyncTask<Void, Void, Throwable>() {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00a1 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00c1 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00d4 */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5 A[Catch:{ all -> 0x00c9, all -> 0x00dc }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5 A[Catch:{ all -> 0x00c9, all -> 0x00dc }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8 A[Catch:{ all -> 0x00c9, all -> 0x00dc }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Throwable doInBackground(java.lang.Void... r8) {
                /*
                    r7 = this;
                    android.os.CancellationSignal r8 = r4     // Catch:{ all -> 0x00dc }
                    boolean r8 = r8.isCanceled()     // Catch:{ all -> 0x00dc }
                    r0 = 0
                    if (r8 == 0) goto L_0x000a
                    return r0
                L_0x000a:
                    android.print.pdf.PrintedPdfDocument r8 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00dc }
                    androidx.print.PrintHelper r1 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00dc }
                    android.content.Context r1 = r1.mContext     // Catch:{ all -> 0x00dc }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00dc }
                    r8.<init>(r1, r2)     // Catch:{ all -> 0x00dc }
                    android.graphics.Bitmap r1 = r6     // Catch:{ all -> 0x00dc }
                    android.print.PrintAttributes r2 = r5     // Catch:{ all -> 0x00dc }
                    int r2 = r2.getColorMode()     // Catch:{ all -> 0x00dc }
                    android.graphics.Bitmap r1 = androidx.print.PrintHelper.convertBitmapForColorMode(r1, r2)     // Catch:{ all -> 0x00dc }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x00dc }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00dc }
                    if (r2 == 0) goto L_0x002a
                    return r0
                L_0x002a:
                    r2 = 1
                    android.graphics.pdf.PdfDocument$Page r3 = r8.startPage(r2)     // Catch:{ all -> 0x00c9 }
                    boolean r4 = androidx.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT     // Catch:{ all -> 0x00c9 }
                    if (r4 == 0) goto L_0x0041
                    android.graphics.RectF r2 = new android.graphics.RectF     // Catch:{ all -> 0x00c9 }
                    android.graphics.pdf.PdfDocument$PageInfo r4 = r3.getInfo()     // Catch:{ all -> 0x00c9 }
                    android.graphics.Rect r4 = r4.getContentRect()     // Catch:{ all -> 0x00c9 }
                    r2.<init>(r4)     // Catch:{ all -> 0x00c9 }
                    goto L_0x0064
                L_0x0041:
                    android.print.pdf.PrintedPdfDocument r4 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00c9 }
                    androidx.print.PrintHelper r5 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00c9 }
                    android.content.Context r5 = r5.mContext     // Catch:{ all -> 0x00c9 }
                    android.print.PrintAttributes r6 = r7     // Catch:{ all -> 0x00c9 }
                    r4.<init>(r5, r6)     // Catch:{ all -> 0x00c9 }
                    android.graphics.pdf.PdfDocument$Page r2 = r4.startPage(r2)     // Catch:{ all -> 0x00c9 }
                    android.graphics.RectF r5 = new android.graphics.RectF     // Catch:{ all -> 0x00c9 }
                    android.graphics.pdf.PdfDocument$PageInfo r6 = r2.getInfo()     // Catch:{ all -> 0x00c9 }
                    android.graphics.Rect r6 = r6.getContentRect()     // Catch:{ all -> 0x00c9 }
                    r5.<init>(r6)     // Catch:{ all -> 0x00c9 }
                    r4.finishPage(r2)     // Catch:{ all -> 0x00c9 }
                    r4.close()     // Catch:{ all -> 0x00c9 }
                    r2 = r5
                L_0x0064:
                    int r4 = r1.getWidth()     // Catch:{ all -> 0x00c9 }
                    int r5 = r1.getHeight()     // Catch:{ all -> 0x00c9 }
                    int r6 = r8     // Catch:{ all -> 0x00c9 }
                    android.graphics.Matrix r4 = androidx.print.PrintHelper.getMatrix(r4, r5, r2, r6)     // Catch:{ all -> 0x00c9 }
                    boolean r5 = androidx.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT     // Catch:{ all -> 0x00c9 }
                    if (r5 == 0) goto L_0x0077
                    goto L_0x0085
                L_0x0077:
                    float r5 = r2.left     // Catch:{ all -> 0x00c9 }
                    float r6 = r2.top     // Catch:{ all -> 0x00c9 }
                    r4.postTranslate(r5, r6)     // Catch:{ all -> 0x00c9 }
                    android.graphics.Canvas r5 = r3.getCanvas()     // Catch:{ all -> 0x00c9 }
                    r5.clipRect(r2)     // Catch:{ all -> 0x00c9 }
                L_0x0085:
                    android.graphics.Canvas r2 = r3.getCanvas()     // Catch:{ all -> 0x00c9 }
                    r2.drawBitmap(r1, r4, r0)     // Catch:{ all -> 0x00c9 }
                    r8.finishPage(r3)     // Catch:{ all -> 0x00c9 }
                    android.os.CancellationSignal r2 = r4     // Catch:{ all -> 0x00c9 }
                    boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00c9 }
                    if (r2 == 0) goto L_0x00a9
                    r8.close()     // Catch:{ all -> 0x00dc }
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ all -> 0x00dc }
                    if (r8 == 0) goto L_0x00a1
                    r8.close()     // Catch:{ IOException -> 0x00a1 }
                L_0x00a1:
                    android.graphics.Bitmap r8 = r6     // Catch:{ all -> 0x00dc }
                    if (r1 == r8) goto L_0x00a8
                    r1.recycle()     // Catch:{ all -> 0x00dc }
                L_0x00a8:
                    return r0
                L_0x00a9:
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00c9 }
                    android.os.ParcelFileDescriptor r3 = r9     // Catch:{ all -> 0x00c9 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x00c9 }
                    r2.<init>(r3)     // Catch:{ all -> 0x00c9 }
                    r8.writeTo(r2)     // Catch:{ all -> 0x00c9 }
                    r8.close()     // Catch:{ all -> 0x00dc }
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ all -> 0x00dc }
                    if (r8 == 0) goto L_0x00c1
                    r8.close()     // Catch:{ IOException -> 0x00c1 }
                L_0x00c1:
                    android.graphics.Bitmap r8 = r6     // Catch:{ all -> 0x00dc }
                    if (r1 == r8) goto L_0x00c8
                    r1.recycle()     // Catch:{ all -> 0x00dc }
                L_0x00c8:
                    return r0
                L_0x00c9:
                    r0 = move-exception
                    r8.close()     // Catch:{ all -> 0x00dc }
                    android.os.ParcelFileDescriptor r8 = r9     // Catch:{ all -> 0x00dc }
                    if (r8 == 0) goto L_0x00d4
                    r8.close()     // Catch:{ IOException -> 0x00d4 }
                L_0x00d4:
                    android.graphics.Bitmap r8 = r6     // Catch:{ all -> 0x00dc }
                    if (r1 == r8) goto L_0x00db
                    r1.recycle()     // Catch:{ all -> 0x00dc }
                L_0x00db:
                    throw r0     // Catch:{ all -> 0x00dc }
                L_0x00dc:
                    r8 = move-exception
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.AnonymousClass1.doInBackground(java.lang.Void[]):java.lang.Throwable");
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Throwable th) {
                if (cancellationSignal2.isCanceled()) {
                    writeResultCallback2.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    Log.e(PrintHelper.LOG_TAG, "Error writing printed content", th);
                    writeResultCallback2.onWriteFailed((CharSequence) null);
                }
            }
        }.execute(new Void[0]);
    }

    /* access modifiers changed from: package-private */
    public Bitmap loadConstrainedBitmap(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        loadBitmap(uri, options2);
        int i = options2.outWidth;
        int i2 = options2.outHeight;
        if (i > 0 && i2 > 0) {
            int max = Math.max(i, i2);
            int i3 = 1;
            while (max > MAX_PRINT_SIZE) {
                max >>>= 1;
                i3 <<= 1;
            }
            if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                synchronized (this.mLock) {
                    BitmapFactory.Options options3 = new BitmapFactory.Options();
                    this.mDecodeOptions = options3;
                    options3.inMutable = true;
                    this.mDecodeOptions.inSampleSize = i3;
                    options = this.mDecodeOptions;
                }
                try {
                    Bitmap loadBitmap = loadBitmap(uri, options);
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    return loadBitmap;
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0028 A[SYNTHETIC, Splitter:B:20:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap loadBitmap(android.net.Uri r5, android.graphics.BitmapFactory.Options r6) throws java.io.FileNotFoundException {
        /*
            r4 = this;
            java.lang.String r0 = "close fail "
            java.lang.String r1 = "PrintHelper"
            if (r5 == 0) goto L_0x0031
            android.content.Context r2 = r4.mContext
            if (r2 == 0) goto L_0x0031
            r3 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0025 }
            java.io.InputStream r5 = r2.openInputStream(r5)     // Catch:{ all -> 0x0025 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ all -> 0x0022 }
            if (r5 == 0) goto L_0x0021
            r5.close()     // Catch:{ IOException -> 0x001d }
            return r6
        L_0x001d:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0021:
            return r6
        L_0x0022:
            r6 = move-exception
            r3 = r5
            goto L_0x0026
        L_0x0025:
            r6 = move-exception
        L_0x0026:
            if (r3 == 0) goto L_0x0030
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0030:
            throw r6
        L_0x0031:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "bad argument to loadBitmap"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.loadBitmap(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    static Bitmap convertBitmapForColorMode(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }
}
