package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaov {
    public static X509Certificate[][] zza(String str) throws zzaor, SecurityException, IOException {
        ByteBuffer byteBuffer;
        int limit;
        int position;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair zzc = zzaow.zzc(randomAccessFile);
            if (zzc != null) {
                ByteBuffer byteBuffer2 = (ByteBuffer) zzc.first;
                long longValue = ((Long) zzc.second).longValue();
                long j = longValue - 20;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new zzaor("ZIP64 APK not supported");
                    }
                }
                long zza = zzaow.zza(byteBuffer2);
                if (zza >= longValue) {
                    throw new zzaor("ZIP Central Directory offset out of range: " + zza + ". ZIP End of Central Directory offset: " + longValue);
                } else if (zzaow.zzb(byteBuffer2) + zza != longValue) {
                    throw new zzaor("ZIP Central Directory is not immediately followed by End of Central Directory");
                } else if (zza >= 32) {
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(zza - ((long) allocate.capacity()));
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                        int i = 0;
                        long j2 = allocate.getLong(0);
                        if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                            throw new zzaor("APK Signing Block size out of range: " + j2);
                        }
                        int i2 = (int) (8 + j2);
                        long j3 = zza - ((long) i2);
                        if (j3 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                            allocate2.order(ByteOrder.LITTLE_ENDIAN);
                            randomAccessFile.seek(j3);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j4 = allocate2.getLong(0);
                            if (j4 == j2) {
                                Pair create = Pair.create(allocate2, Long.valueOf(j3));
                                byteBuffer = (ByteBuffer) create.first;
                                long longValue2 = ((Long) create.second).longValue();
                                if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                                    int capacity = byteBuffer.capacity() - 24;
                                    if (capacity >= 8) {
                                        int capacity2 = byteBuffer.capacity();
                                        if (capacity <= byteBuffer.capacity()) {
                                            limit = byteBuffer.limit();
                                            position = byteBuffer.position();
                                            byteBuffer.position(0);
                                            byteBuffer.limit(capacity);
                                            byteBuffer.position(8);
                                            ByteBuffer slice = byteBuffer.slice();
                                            slice.order(byteBuffer.order());
                                            byteBuffer.position(0);
                                            byteBuffer.limit(limit);
                                            byteBuffer.position(position);
                                            while (slice.hasRemaining()) {
                                                i++;
                                                if (slice.remaining() >= 8) {
                                                    long j5 = slice.getLong();
                                                    if (j5 < 4 || j5 > 2147483647L) {
                                                        throw new zzaor("APK Signing Block entry #" + i + " size out of range: " + j5);
                                                    }
                                                    int i3 = (int) j5;
                                                    int position2 = slice.position() + i3;
                                                    if (i3 > slice.remaining()) {
                                                        throw new zzaor("APK Signing Block entry #" + i + " size out of range: " + i3 + ", available: " + slice.remaining());
                                                    } else if (slice.getInt() == 1896449818) {
                                                        X509Certificate[][] zzl = zzl(randomAccessFile.getChannel(), new zzaoq(zze(slice, i3 - 4), longValue2, zza, longValue, byteBuffer2, (zzaou) null));
                                                        randomAccessFile.close();
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (IOException unused) {
                                                        }
                                                        return zzl;
                                                    } else {
                                                        long j6 = zza;
                                                        long j7 = longValue;
                                                        slice.position(position2);
                                                        longValue = j7;
                                                        zza = j6;
                                                    }
                                                } else {
                                                    throw new zzaor("Insufficient data to read size of APK Signing Block entry #" + i);
                                                }
                                            }
                                            throw new zzaor("No APK Signature Scheme v2 block in APK Signing Block");
                                        }
                                        throw new IllegalArgumentException("end > capacity: " + capacity + " > " + capacity2);
                                    }
                                    throw new IllegalArgumentException("end < start: " + capacity + " < 8");
                                }
                                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                            }
                            throw new zzaor("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                        }
                        throw new zzaor("APK Signing Block offset out of range: " + j3);
                    }
                    throw new zzaor("No APK Signing Block before ZIP Central Directory");
                } else {
                    throw new zzaor("APK too small for APK Signing Block. ZIP Central Directory offset: " + zza);
                }
            } else {
                throw new zzaor("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    private static int zzb(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static int zzc(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case InputDeviceCompat.SOURCE_KEYBOARD:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i))));
        }
    }

    private static String zzd(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static ByteBuffer zze(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static ByteBuffer zzf(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return zze(byteBuffer, i);
            } else {
                int remaining = byteBuffer.remaining();
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + remaining);
            }
        } else {
            int remaining2 = byteBuffer.remaining();
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + remaining2);
        }
    }

    private static void zzg(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    private static void zzh(Map map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            FileChannel fileChannel2 = fileChannel;
            long j4 = j;
            zzaop zzaop = new zzaop(fileChannel2, 0, j4);
            zzaop zzaop2 = new zzaop(fileChannel2, j2, j3 - j2);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            zzaow.zzd(duplicate, j4);
            zzaon zzaon = new zzaon(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            int i2 = 0;
            for (Integer intValue : map.keySet()) {
                iArr[i2] = intValue.intValue();
                i2++;
            }
            try {
                byte[][] zzk = zzk(iArr, new zzaoo[]{zzaop, zzaop2, zzaon});
                while (i < size) {
                    int i3 = iArr[i];
                    if (MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i3)), zzk[i])) {
                        i++;
                    } else {
                        throw new SecurityException(zzd(i3).concat(" digest of contents did not verify"));
                    }
                }
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    private static byte[] zzi(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            int remaining = byteBuffer.remaining();
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + remaining);
        }
    }

    private static X509Certificate[] zzj(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        String str;
        Pair pair;
        ByteBuffer zzf = zzf(byteBuffer);
        ByteBuffer zzf2 = zzf(byteBuffer);
        byte[] zzi = zzi(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i = -1;
        int i2 = 0;
        while (zzf2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer zzf3 = zzf(zzf2);
                if (zzf3.remaining() >= 8) {
                    int i3 = zzf3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (!(i3 == 513 || i3 == 514 || i3 == 769)) {
                        switch (i3) {
                            case InputDeviceCompat.SOURCE_KEYBOARD:
                            case 258:
                            case 259:
                            case 260:
                                break;
                            default:
                                continue;
                        }
                    }
                    if (i != -1) {
                        int zzc = zzc(i3);
                        int zzc2 = zzc(i);
                        if (zzc != 1) {
                            if (zzc2 != 1) {
                            }
                        }
                    }
                    bArr2 = zzi(zzf3);
                    i = i3;
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #" + i2, e);
            }
        }
        if (i != -1) {
            if (i == 513 || i == 514) {
                str = "EC";
            } else if (i != 769) {
                switch (i) {
                    case InputDeviceCompat.SOURCE_KEYBOARD:
                    case 258:
                    case 259:
                    case 260:
                        str = "RSA";
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i))));
                }
            } else {
                str = "DSA";
            }
            if (i == 513) {
                pair = Pair.create("SHA256withECDSA", (Object) null);
            } else if (i == 514) {
                pair = Pair.create("SHA512withECDSA", (Object) null);
            } else if (i != 769) {
                switch (i) {
                    case InputDeviceCompat.SOURCE_KEYBOARD:
                        pair = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                        break;
                    case 258:
                        pair = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                        break;
                    case 259:
                        pair = Pair.create("SHA256withRSA", (Object) null);
                        break;
                    case 260:
                        pair = Pair.create("SHA512withRSA", (Object) null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i))));
                }
            } else {
                pair = Pair.create("SHA256withDSA", (Object) null);
            }
            String str2 = (String) pair.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(zzi));
                Signature instance = Signature.getInstance(str2);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(zzf);
                if (instance.verify(bArr2)) {
                    zzf.clear();
                    ByteBuffer zzf4 = zzf(zzf);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (zzf4.hasRemaining()) {
                        i4++;
                        try {
                            ByteBuffer zzf5 = zzf(zzf4);
                            if (zzf5.remaining() >= 8) {
                                int i5 = zzf5.getInt();
                                arrayList2.add(Integer.valueOf(i5));
                                if (i5 == i) {
                                    bArr = zzi(zzf5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e2) {
                            throw new IOException("Failed to parse digest record #" + i4, e2);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        int zzc3 = zzc(i);
                        byte[] bArr3 = (byte[]) map.put(Integer.valueOf(zzc3), bArr);
                        if (bArr3 == null || MessageDigest.isEqual(bArr3, bArr)) {
                            ByteBuffer zzf6 = zzf(zzf);
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = 0;
                            while (zzf6.hasRemaining()) {
                                i6++;
                                byte[] zzi2 = zzi(zzf6);
                                try {
                                    arrayList3.add(new zzaos((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(zzi2)), zzi2));
                                } catch (CertificateException e3) {
                                    throw new SecurityException("Failed to decode certificate #" + i6, e3);
                                }
                            }
                            if (arrayList3.isEmpty()) {
                                throw new SecurityException("No certificates listed");
                            } else if (Arrays.equals(zzi, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            } else {
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                        } else {
                            throw new SecurityException(zzd(zzc3).concat(" contents digest does not match the digest specified by a preceding signer"));
                        }
                    } else {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                } else {
                    throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                throw new SecurityException("Failed to verify " + str2 + " signature", e4);
            }
        } else if (i2 == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    private static byte[][] zzk(int[] iArr, zzaoo[] zzaooArr) throws DigestException {
        long j;
        int i;
        int length;
        char c;
        int i2;
        String str;
        int[] iArr2 = iArr;
        int i3 = 0;
        int i4 = 0;
        long j2 = 0;
        while (true) {
            j = 1048576;
            i = 3;
            if (i4 >= 3) {
                break;
            }
            j2 += (zzaooArr[i4].zza() + 1048575) / 1048576;
            i4++;
        }
        if (j2 < 2097151) {
            byte[][] bArr = new byte[iArr2.length][];
            int i5 = 0;
            while (true) {
                length = iArr2.length;
                c = 5;
                i2 = 1;
                if (i5 >= length) {
                    break;
                }
                int i6 = (int) j2;
                byte[] bArr2 = new byte[((zzb(iArr2[i5]) * i6) + 5)];
                bArr2[0] = 90;
                zzg(i6, bArr2, 1);
                bArr[i5] = bArr2;
                i5++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i7 = 0;
            while (true) {
                str = " digest not supported";
                if (i7 >= iArr2.length) {
                    break;
                }
                String zzd = zzd(iArr2[i7]);
                try {
                    messageDigestArr[i7] = MessageDigest.getInstance(zzd);
                    i7++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(zzd.concat(str), e);
                }
            }
            int i8 = 0;
            int i9 = 0;
            while (i8 < i) {
                zzaoo zzaoo = zzaooArr[i8];
                int i10 = i8;
                long zza = zzaoo.zza();
                byte[][] bArr4 = bArr;
                long j3 = 0;
                while (zza > 0) {
                    int i11 = i9;
                    String str2 = str;
                    int min = (int) Math.min(zza, j);
                    zzg(min, bArr3, i2);
                    for (int i12 = 0; i12 < length; i12++) {
                        messageDigestArr[i12].update(bArr3);
                    }
                    try {
                        zzaoo.zzb(messageDigestArr, j3, min);
                        int i13 = 0;
                        while (i13 < iArr2.length) {
                            int i14 = iArr2[i13];
                            byte[] bArr5 = bArr4[i13];
                            int zzb = zzb(i14);
                            char c2 = c;
                            MessageDigest messageDigest = messageDigestArr[i13];
                            int digest = messageDigest.digest(bArr5, (i11 * zzb) + 5, zzb);
                            if (digest == zzb) {
                                i13++;
                                c = c2;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        char c3 = c;
                        long j4 = (long) min;
                        j3 += j4;
                        zza -= j4;
                        i9 = i11 + 1;
                        str = str2;
                        j = 1048576;
                        i2 = 1;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i11 + " of section #" + i3, e2);
                    }
                }
                char c4 = c;
                String str3 = str;
                i3++;
                i8 = i10 + 1;
                bArr = bArr4;
                j = 1048576;
                i = 3;
                i2 = 1;
            }
            byte[][] bArr6 = bArr;
            String str4 = str;
            byte[][] bArr7 = new byte[iArr2.length][];
            int i15 = 0;
            while (i15 < iArr2.length) {
                int i16 = iArr2[i15];
                byte[] bArr8 = bArr6[i15];
                String zzd2 = zzd(i16);
                try {
                    bArr7[i15] = MessageDigest.getInstance(zzd2).digest(bArr8);
                    i15++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(zzd2.concat(str4), e3);
                }
            }
            return bArr7;
        }
        throw new DigestException("Too many chunks: " + j2);
    }

    private static X509Certificate[][] zzl(FileChannel fileChannel, zzaoq zzaoq) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer zzf = zzf(zzaoq.zza);
                int i = 0;
                while (zzf.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(zzj(zzf(zzf), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        Throwable th = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", th);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    zzh(hashMap, fileChannel, zzaoq.zzb, zzaoq.zzc, zzaoq.zzd, zzaoq.zze);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }
}
