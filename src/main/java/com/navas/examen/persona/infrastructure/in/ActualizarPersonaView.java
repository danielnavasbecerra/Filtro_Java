package com.navas.examen.persona.infrastructure.in;

import java.util.Scanner;

import com.navas.examen.persona.application.ActualizarPersonaUseCase;

public class ActualizarPersonaView {

    // Atributes
    private final ActualizarPersonaUseCase actualizarPersonaUseCase;
    private final Scanner scanner;

    // Constructor
    public ActualizarPersonaView(ActualizarPersonaUseCase actualizarPersonaUseCase, Scanner scanner) {
        this.actualizarPersonaUseCase = actualizarPersonaUseCase;
        this.scanner = scanner;
    }
}
