package com.samuelcharles.qrcode.generator.api.controller;

import com.samuelcharles.qrcode.generator.api.DTO.QrCodeRequestDTO;
import com.samuelcharles.qrcode.generator.api.DTO.QrCodeResponseDTO;
import com.samuelcharles.qrcode.generator.api.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {
    private final QrCodeGeneratorService service;

    public QrCodeController(QrCodeGeneratorService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<QrCodeResponseDTO> generate(@RequestBody QrCodeRequestDTO dto) {
        try {
            QrCodeResponseDTO response = service.generateQrCode(dto.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
