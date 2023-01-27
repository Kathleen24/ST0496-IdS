package it.unicam.ids.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class PianoTariffario {
    @Id
    @GeneratedValue
    private Integer id;
    private Double costo;
    private Boolean newsLetterService;
    private Boolean emailService;
    private Boolean calendarService;
    private Boolean smsService;

    //region Costruttori
    public PianoTariffario() {
    }

    public PianoTariffario(Integer id, Double costo, Boolean newsLetterService,
                           Boolean emailService, Boolean calendarService, Boolean smsService) {
        this.id = id;
        this.costo = costo;
        this.newsLetterService = newsLetterService;
        this.emailService = emailService;
        this.calendarService = calendarService;
        this.smsService = smsService;
    }

    public PianoTariffario(PianoTariffario pianoTariffario) {
        this.id = getId();
        this.costo = getCosto();
        this.newsLetterService = getNewsLetterService();
        this.emailService = getEmailService();
        this.calendarService = getCalendarService();
        this.smsService = getSmsService();
    }
    //endregion

    //region Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Boolean getNewsLetterService() {
        return newsLetterService;
    }

    public void setNewsLetterService(Boolean newsLetterService) {
        this.newsLetterService = newsLetterService;
    }

    public Boolean getEmailService() {
        return emailService;
    }

    public void setEmailService(Boolean emailService) {
        this.emailService = emailService;
    }

    public Boolean getCalendarService() {
        return calendarService;
    }

    public void setCalendarService(Boolean calendarService) {
        this.calendarService = calendarService;
    }

    public Boolean getSmsService() {
        return smsService;
    }

    public void setSmsService(Boolean smsService) {
        this.smsService = smsService;
    }

    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PianoTariffario that = (PianoTariffario) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(costo, that.costo)) return false;
        if (!Objects.equals(newsLetterService, that.newsLetterService))
            return false;
        if (!Objects.equals(emailService, that.emailService)) return false;
        if (!Objects.equals(calendarService, that.calendarService))
            return false;
        return Objects.equals(smsService, that.smsService);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (costo != null ? costo.hashCode() : 0);
        result = 31 * result + (newsLetterService != null ? newsLetterService.hashCode() : 0);
        result = 31 * result + (emailService != null ? emailService.hashCode() : 0);
        result = 31 * result + (calendarService != null ? calendarService.hashCode() : 0);
        result = 31 * result + (smsService != null ? smsService.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PianoTariffario:" +
                " ID=" + id +
                ", costo=" + costo +
                ", newsLetterService=" + newsLetterService +
                ", emailService=" + emailService +
                ", calendarService=" + calendarService +
                ", smsService=" + smsService +
                '.';
    }
}
