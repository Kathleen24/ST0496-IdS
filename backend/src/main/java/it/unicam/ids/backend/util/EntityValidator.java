package it.unicam.ids.backend.util;

/**
 * Le classi che implementano questa interfaccia sono in grado di determinare
 * la validità di un'istanza di una classe
 *
 * @param <E> il tipo di oggetto che può essere validato
 */
public interface EntityValidator<E> {

    /**
     * Valida un oggetto, se il controllo fallisce viene lanciata un'eccezione appropriata
     *
     * @param entity l'oggetto da controllare
     */
    void validateEntity(E entity);
}
