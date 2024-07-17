package com.usg.apirest.dominio.usuarios;

import java.security.SecureRandom;

public record DatosAutenticacionUsuario(String login, String clave) {
}
