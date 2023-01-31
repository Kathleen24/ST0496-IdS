package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Coupon;
import it.unicam.ids.backend.service.CouponService;
import it.unicam.ids.backend.util.QRCodeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.awt.image.BufferedImage;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;
    private final QRCodeService qrCodeService;

    public CouponController(CouponService couponService, QRCodeService qrCodeService) {
        this.couponService = couponService;
        this.qrCodeService = qrCodeService;
    }


    @GetMapping("/all")
    public List<Coupon> getAllCoupon() {
        return couponService.getAllCoupon();
    }

    @GetMapping("/{id}")
    public Coupon getCoupon(@PathVariable Integer id) {
        return couponService.getCoupon(id);
    }

    @PostMapping("/add")
    public void addCoupon(
            @RequestParam Integer aziendaID,
            @RequestParam(defaultValue = "-1") Integer tessera,
            @RequestParam Integer valore, @RequestParam Date dataScadenza
    ) {
        Coupon coupon = couponService.addCoupon(aziendaID, tessera, valore, dataScadenza);
    }

    @PostMapping("/update")
    public void updateCoupon(Coupon coupon) {
        couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Integer id) {
        couponService.deleteCoupon(id);
    }

    /**
     * Questo metodo genera un QRCode contente l' id dell'coupon.
     * @param id - l' id del coupon.
     * @return - il QRCode in formato PNG (250x250).
     * @throws Exception - Eccezioni generiche
     */
    @GetMapping("/qrcode/{id}")
    public ResponseEntity<BufferedImage> qrCodeGenerate(@RequestParam ("id") String id) throws Exception {
        return qrCodeService.qrCodeGenerator(id);
    }
}