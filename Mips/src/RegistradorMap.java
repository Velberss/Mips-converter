import java.util.HashMap;
import java.util.Map;

public class RegistradorMap {
    private static final Map<String, String> REGISTRADORES = new HashMap<>();
    // Todos os Registradores necessarios
    static {
        REGISTRADORES.put("$zero", "00000");
        REGISTRADORES.put("$t0", "01000");
        REGISTRADORES.put("$t1", "01001");
        REGISTRADORES.put("$t2", "01010");
        REGISTRADORES.put("$t3", "01011");
        REGISTRADORES.put("$t4", "01100");
        REGISTRADORES.put("$t5", "01101");
        REGISTRADORES.put("$t6", "01110");
        REGISTRADORES.put("$t7", "01111");
        REGISTRADORES.put("$s0", "10000");
        REGISTRADORES.put("$s1", "10001");
        REGISTRADORES.put("$s2", "10010");
        REGISTRADORES.put("$s3", "10011");
        REGISTRADORES.put("$s4", "10100");
        REGISTRADORES.put("$s5", "10101");
        REGISTRADORES.put("$s6", "10110");
        REGISTRADORES.put("$s7", "10111");

    }

    public static String getRegistrador(String register) {
        // Return o registrador requerido
        return REGISTRADORES.get(register);
    }
}