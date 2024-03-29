package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Coupon;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.ClienteService;
import it.unicam.ids.backend.service.CouponService;
import it.unicam.ids.backend.util.EntityValidator;
import it.unicam.ids.backend.util.QRCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements EntityValidator<Coupon> {

    private final CouponService couponService;
    private final AziendaService aziendaService;
    private final ClienteService clienteService;
    private final QRCodeService qrCodeService;


    public CouponController(
            CouponService couponService,
            AziendaService aziendaService,
            ClienteService clienteService,
            QRCodeService qrCodeService
    ) {
        this.couponService = couponService;
        this.aziendaService = aziendaService;
        this.clienteService = clienteService;
        this.qrCodeService = qrCodeService;
    }


    @Override
    public void validateEntity(Coupon coupon) {
        if (coupon == null)
            throw new NullPointerException("L'oggetto coupon è nullo");
        if (coupon.getValore() <= 0)
            throw new IllegalArgumentException("Il valore del coupon non può essere minore uguale a 0");

        if (aziendaService.getAzienda(coupon.getAzienda().getId()) == null)
            throw new IllegalArgumentException("L'azienda inserita non è esistente");
        if (clienteService.getCliente(coupon.getCliente().getTessera()) == null)
            throw new IllegalArgumentException("Il cliente inserito non è esistente");
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
            @RequestParam Integer valore,
            @RequestParam LocalDate dataScadenza
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

    /**
     * Questo metodo genera un QRCode contente l'id dell'coupon.
     *
     * @param id l'id del coupon
     * @return il QRCode in formato PNG (250x250)
     *
     * @throws Exception Eccezioni generiche
     */
    @GetMapping("/{id}/qrcode")
    public ResponseEntity<BufferedImage> generateQrCode(@PathVariable String id) throws Exception {
        return qrCodeService.qrCodeGenerator(id);
    }
}
