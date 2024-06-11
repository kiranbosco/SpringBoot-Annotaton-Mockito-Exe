package com.annotations.Spring.boot.annotations.lazyOrEgger;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoading {
    public LazyLoading(){
        System.out.println("LazyLoading obect is created..!");
    }
}
