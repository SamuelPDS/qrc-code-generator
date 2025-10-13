package com.samuelcharles.qrcode.generator.api.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.samuelcharles.qrcode.generator.api.DTO.QrCodeResponseDTO;
import com.samuelcharles.qrcode.generator.api.infra.S3StorageAdapter;
import com.samuelcharles.qrcode.generator.api.ports.StoragePort;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {

    private final StoragePort storagePort;

    public QrCodeGeneratorService(StoragePort port) {
        this.storagePort = port;
    }

    public QrCodeResponseDTO generateQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        byte[] pngData = outputStream.toByteArray();

        String url = storagePort.upload(pngData, UUID.randomUUID().toString(), "image/png");

        return new QrCodeResponseDTO(url);
    }
}
