import java.util.HashMap;
import java.util.Map;

public class OpCodeMap {
    private static final Map<String, String> OPCODES = new HashMap<>();
    //Todos os Opcodes
    static {
        OPCODES.put("add", "000000");
        OPCODES.put("sub", "000000");
        OPCODES.put("lw", "100011");
        OPCODES.put("sw", "101011");
        OPCODES.put("sh", "101001");
        OPCODES.put("swl", "101010");
        OPCODES.put("swr", "101110");
        OPCODES.put("lbu", "100100");
        OPCODES.put("lwr", "100110");
        OPCODES.put("addi", "001000");
        OPCODES.put("addiu", "001001");
        OPCODES.put("slti", "0010010");
        OPCODES.put("ori", "001101");
        OPCODES.put("xori", "001110");
        OPCODES.put("lui", "001111");
        OPCODES.put("bltz", "000001");
        OPCODES.put("bgez", "000001");

        OPCODES.put("beq", "000100");
        OPCODES.put("bne", "000101");
        OPCODES.put("blez", "000110");
        OPCODES.put("bgtz", "000111");

        OPCODES.put("bltzal", "1");
        OPCODES.put("bgezal", "1");

        OPCODES.put("subu", "100011");
        OPCODES.put("and", "100100");
        OPCODES.put("or", "100101");
        OPCODES.put("xor", "100110");
        OPCODES.put("nor", "100111");
        OPCODES.put("slt", "101010");
        OPCODES.put("sltu", "101011");

        OPCODES.put("sllv", "000110");
    }

    public static String getOpcode(String instruction) {
        return OPCODES.get(instruction);
    }
}