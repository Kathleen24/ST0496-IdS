package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Coupon;
import it.unicam.ids.backend.repository.AziendaRepository;
import it.unicam.ids.backend.repository.ClienteRepository;
import it.unicam.ids.backend.repository.CouponRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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


    public List<Coupon> getAllCoupon() {
        return couponRepository.findAll();
    }

    public Coupon getCoupon(Integer id) {
        return couponRepository.findById(id).orElse(null);
    }

    public Coupon addCoupon(Integer aziendaID, Integer tessera, Integer valore, LocalDate dataScadenza) {
        Coupon coupon = new Coupon(
                aziendaRepository.findById(aziendaID).orElseThrow(),
                clienteRepository.findById(tessera).orElse(null),
                valore, dataScadenza
        );
        return couponRepository.save(coupon);
    }

    public Coupon updateCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public void deleteCoupon(Integer id) {
        couponRepository.deleteById(id);
    }

    @Scheduled(cron = "@daily")
    private void expireCoupon() {
        couponRepository.findAll().stream()
                .filter(coupon -> coupon.getDataScadenza().isBefore(LocalDate.now()))
                .forEach(coupon -> {
                    coupon.setUsato(true);
                    updateCoupon(coupon);
                });
    }
}
