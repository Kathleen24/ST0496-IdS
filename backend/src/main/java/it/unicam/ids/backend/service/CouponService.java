package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Coupon;
import it.unicam.ids.backend.repository.AziendaRepository;
import it.unicam.ids.backend.repository.ClienteRepository;
import it.unicam.ids.backend.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CouponService {

    private final CouponRepository couponRepository;
    private final AziendaRepository aziendaRepository;
    private final ClienteRepository clienteRepository;


    public CouponService(
            CouponRepository couponRepository,
            AziendaRepository aziendaRepository,
            ClienteRepository clienteRepository
    ) {
        this.couponRepository = couponRepository;
        this.aziendaRepository = aziendaRepository;
        this.clienteRepository = clienteRepository;
    }


    public Coupon addCoupon(Integer aziendaID, Integer tessera, Integer valore, Date dataScadenza) {
        Coupon coupon = new Coupon(
                aziendaRepository.findById(aziendaID).orElseThrow(),
                clienteRepository.findById(tessera).orElse(null),
                valore, dataScadenza
        );
        return couponRepository.save(coupon);
    }
}
