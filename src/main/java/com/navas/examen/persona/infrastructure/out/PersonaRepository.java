package com.navas.examen.persona.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.navas.examen.config.DatabaseConfig;
import com.navas.examen.persona.domain.entity.Persona;
import com.navas.examen.persona.domain.service.PersonaService;

public class PersonaRepository implements PersonaService {

    // Atributes
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;
    String response = null;

    @Override
    public String registrarPersona(Persona persona) {
        String sql = "INSERT INTO sgpzf.persons (name, lastname, idcity, address, age, email, idgender) VALUES (?,?,?,?,?,?,?)";

        try {
            // Connect to database
            connection = DatabaseConfig.getConnection();
            if (connection != null) {
                System.out.println("\n╔─────────────────────────────────────╗");
                System.out.println("│   Successful Database Connection!   │");
                System.out.println("╚─────────────────────────────────────╝");
            }
            // Prepare the call statement
            callableStatement = connection.prepareCall(sql);

            // Set parameters
            callableStatement.setString(1, persona.getName());
            callableStatement.setString(2, persona.getLastname());
            callableStatement.setInt(3, persona.getCity());
            callableStatement.setString(4, persona.getAddress());
            callableStatement.setInt(5, persona.getAge());
            callableStatement.setString(6, persona.getEmail());
            callableStatement.setInt(7, persona.getGender());

            // Execute the call
            callableStatement.execute();

        } catch (SQLException e) {
            response = "Error al registrar la persona: " + e.getMessage();
        } finally {
            closeResources();
        }
        return response;
    }

    @Override
    public String actualizarPersona(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPersona'");
    }

    @Override
    public String eliminarPersona(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPersona'");
    }

    // Otros Metodos...
    private void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
