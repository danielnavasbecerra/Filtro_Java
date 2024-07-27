package com.navas.examen.persona.infrastructure.in;

import java.util.Scanner;

import com.navas.examen.persona.application.EliminarPersonaUseCase;

public class EliminarPersonaView {

    // Atributes
    private final EliminarPersonaUseCase eliminarPersonaUseCase;
    private final Scanner scanner;

    // Constructor
    public EliminarPersonaView(EliminarPersonaUseCase eliminarPersonaUseCase, Scanner scanner) {
        this.eliminarPersonaUseCase = eliminarPersonaUseCase;
        this.scanner = scanner;
    }
}
