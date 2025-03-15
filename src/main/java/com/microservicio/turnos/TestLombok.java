package com.microservicio.turnos;

import com.microservicio.turnos.model.Turno;

import java.lang.reflect.Method;

public class TestLombok {
    public static void main(String[] args) {
        System.out.println("Métodos generados en Turno:");
        for (Method method : Turno.class.getMethods()) {
            System.out.println(method.getName());
        }
    }
}
