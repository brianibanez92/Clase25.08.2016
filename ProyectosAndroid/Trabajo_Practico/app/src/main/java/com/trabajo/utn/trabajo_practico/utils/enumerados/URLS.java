package com.trabajo.utn.trabajo_practico.utils.enumerados;

/**
 * Created by julian.moreno on 11/27/2016.
 */

public enum URLS {
    CATEGORIAS("http://lkdml.myq-see.com/categorias"),
    LOGIN("http://lkdml.myq-see.com/login"),
    REGISTRO("http://lkdml.myq-see.com/register");


    private final String value;
    private URLS(String value) {
        this.value = value;
    }

    public String getURL() {
        return value;
    }
}
