package com.navas.examen.persona.application;

import com.navas.examen.persona.domain.entity.Persona;
import com.navas.examen.persona.domain.service.PersonaService;

public class RegistrarPersonaUseCase {

    // atributos
    private final PersonaService personaService;

    // constructor
    public RegistrarPersonaUseCase(PersonaService personaService) {
        this.personaService = personaService;
    }

    // metodo
    public String registrarPersona(Persona persona) {
        return personaService.registrarPersona(persona);
    }
}
