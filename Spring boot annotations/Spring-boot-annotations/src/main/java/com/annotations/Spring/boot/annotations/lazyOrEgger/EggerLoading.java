package com.annotations.Spring.boot.annotations.lazyOrEgger;

import org.springframework.stereotype.Component;

@Component
public class EggerLoading {

    public EggerLoading(){
        System.out.println("EggerLoading object is created..!");
    }
}
