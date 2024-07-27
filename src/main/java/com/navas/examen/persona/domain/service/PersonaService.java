package com.navas.examen.persona.domain.service;

import com.navas.examen.persona.domain.entity.Persona;

public interface PersonaService {

    String registrarPersona(Persona persona);

    String actualizarPersona(int id);

    String eliminarPersona(int id);
}
