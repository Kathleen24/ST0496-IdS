package it.unicam.ids.backend.util;

import it.unicam.ids.backend.entity.*;

import java.util.regex.Pattern;

public interface EntityValidator<E> {
    public void validateEntity(E entity);
}
