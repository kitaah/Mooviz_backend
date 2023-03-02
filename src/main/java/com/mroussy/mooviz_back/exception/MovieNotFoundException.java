package com.mroussy.mooviz_back.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) { super("Le film possédant l'id" + id + "n'a pas été trouvé.");}
}
