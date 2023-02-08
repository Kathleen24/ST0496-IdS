package it.unicam.ids.backend.util;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@Service
public class QRCodeService {

    public ResponseEntity<BufferedImage> qrCodeGenerator(@RequestParam("qrcode") String qrcode) throws Exception{
        return ResponseEntity.ok(QRCodeGenerator.generateQRCodeImage(qrcode));
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
}