package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Coupon;
import it.unicam.ids.backend.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;


    public CouponController(CouponService couponService) {
        this.couponService = couponService;
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
    public Coupon addCoupon(
            @RequestParam Integer aziendaID,
            @RequestParam(defaultValue = "-1") Integer tessera,
            @RequestParam Integer valore, @RequestParam Date dataScadenza
    ) {
        return couponService.addCoupon(aziendaID, tessera, valore, dataScadenza);
    }

    @PostMapping("/update")
    public Coupon updateCoupon(Coupon coupon) {
        return couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Integer id) {
        couponService.deleteCoupon(id);
    }
}
