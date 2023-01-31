package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Abbonamento;
import it.unicam.ids.backend.entity.Coupon;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.ClienteService;
import it.unicam.ids.backend.service.CouponService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements EntityValidator<Coupon> {

    private final CouponService couponService;
    private AziendaService aziendaService;
    private ClienteService clienteService;


    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }


    public void validateEntity(Coupon coupon) {
        if (coupon==null)
            throw new NullPointerException("L'oggetto coupon è nullo");
        if(aziendaService.getAzienda(coupon.getAzienda().getId())==null)
            throw new IllegalArgumentException("L'azienda inserita non è esistente");
        if(clienteService.getCliente(coupon.getCliente().getTessera())==null)
            throw new IllegalArgumentException("Il cliente inserito non è esistente");
        if(coupon.getValore()<=0)
            throw new IllegalArgumentException("Il valore del coupon non può essere minore uguale a 0");
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

    public void updateCoupon(Coupon coupon) {
        couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Integer id) {
        couponService.deleteCoupon(id);
    }
}
