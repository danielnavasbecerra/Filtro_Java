package com.navas.examen.persona.application;

import com.navas.examen.persona.domain.service.PersonaService;

public class EliminarPersonaUseCase {

    // atributos
    private final PersonaService personaService;

    // constructor
    public EliminarPersonaUseCase(PersonaService personaService) {
        this.personaService = personaService;
    }

    // metodo
    public String eliminarPersona(int id) {
        return personaService.eliminarPersona(id);
    }
}
