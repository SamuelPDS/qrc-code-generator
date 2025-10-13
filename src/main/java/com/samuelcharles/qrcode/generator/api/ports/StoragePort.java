package com.samuelcharles.qrcode.generator.api.ports;

public interface StoragePort {
    String upload(byte[] data, String extension, String contentType);
}
