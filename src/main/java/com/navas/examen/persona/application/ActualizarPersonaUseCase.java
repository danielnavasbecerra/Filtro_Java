package com.navas.examen.persona.application;

import com.navas.examen.persona.domain.service.PersonaService;

public class ActualizarPersonaUseCase {

    // atributos
    private final PersonaService personaService;

    // constructor
    public ActualizarPersonaUseCase(PersonaService personaService) {
        this.personaService = personaService;
    }

    // metodo
    public String actualizarPersona(int id) {
        return personaService.actualizarPersona(id);
    }
}
