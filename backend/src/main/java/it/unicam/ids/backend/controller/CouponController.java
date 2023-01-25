package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Coupon;
import it.unicam.ids.backend.service.CouponService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;


    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }


    @PostMapping("/add")
    public void addCoupon(
            @RequestParam Integer aziendaID,
            @RequestParam(defaultValue = "-1") Integer tessera,
            @RequestParam Integer valore, @RequestParam Date dataScadenza
    ) {
        Coupon coupon = couponService.addCoupon(aziendaID, tessera, valore, dataScadenza);
    }
}
