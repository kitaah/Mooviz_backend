package com.mroussy.mooviz_back.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) { super("La catégorie possédant l'id" + id + "n'a pas été trouvée.");}
}
