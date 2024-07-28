
import java.io.*;

public class MIPSConverter {
    public static void main(String[] args) {
        String entradaArq = "C:/Users/gonca/OneDrive/Área de Trabalho/🤓/Arqui/Mips/src/programa3.txt";
        String saidaArq = "C:/Users/gonca/OneDrive/Área de Trabalho/🤓/Arqui/Mips/src/output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(entradaArq));
            BufferedWriter writer = new BufferedWriter(new FileWriter(saidaArq));
            String line;

            while ((line = reader.readLine()) != null) {
                String binaryInstruction = converterToBinary(line);
                writer.write(binaryInstruction);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String converterToBinary(String instrucao) {
        String[] parts = instrucao.split("\\s+|,\\s*|\\(|\\)"); // o split separa a string e reparte cada informação
        String opcode = parts[0];
        String opcodeBinario = OpCodeMap.getOpcode(opcode);

        if (opcodeBinario == null) {
            throw new IllegalArgumentException("Opcode desconhecido!!");
        }

        switch (opcode) {

            case "add":
            case "sub":
            case "subu":
            case "xor":
            case "or":
            case "nor":
            case "slt":
            case "sltu":
            case "sra":
            case "sllv":
            case "srlv":
            case "srav":
            case "mfhi":
            case "mthi":
            case "mflo":
            case "mtlo":
            case "mult":
            case "multu":
            case "div":
            case "divu":
            case "jr":
            case "jarl":
            case "sll":
            case "srl":
                return convertRTipo(parts, opcodeBinario);
            case "lw":
            case "sw":
            case "bltzal":
            case "bgezal":
            case "beq":
            case "bne":
            case "blez":
            case "bgtz":
                return convertITipo(parts, opcodeBinario);
            case "addi":
            case "addiu":
            case "slti":
            case "sltiu":
            case "andi":
            case "ori":
            case "xori":
            case "lui":
            case "bltz":
            case "bgez":
                return convertEspeciaisITipo(parts, opcodeBinario);
            default:
                throw new IllegalArgumentException("Tipo de instrução não suportado: " + opcode);
        }
    }

    private static String convertRTipo(String[] parts, String opcodeBinary) {

        {
            String rs = RegistradorMap.getRegistrador(parts[2]);
            String rt = RegistradorMap.getRegistrador(parts[3]);
            String rd = RegistradorMap.getRegistrador(parts[1]);
            String shamt = "00000"; // Valor padrão para R-Type
            String funct = parts[0].equals("add") ? "100000" : "100010";

            if (parts[0].equals("sll") || parts[0].equals("srl")) {
                rd = RegistradorMap.getRegistrador(parts[1]);
                rt = RegistradorMap.getRegistrador(parts[2]);
                shamt = String.format("%5s", Integer.toBinaryString(Integer.parseInt(parts[3]))).replace(' ', '0');
                rs = "00000"; // RS é 0 para instrução de deslocamento
            } else if (parts[0].equals("mult")) {
                rd = "00000"; // RD é não utilizado
            }

            return opcodeBinary + rs + rt + rd + shamt + funct;

        }
    }

    private static String convertEspeciaisITipo(String[] parts, String opcodeBinary) {
        String rt = RegistradorMap.getRegistrador(parts[2]);
        String rs = RegistradorMap.getRegistrador(parts[1]);
        int imediato = Integer.parseInt(parts[3]);
        String imediatoBinario = String.format("%16s", Integer.toBinaryString(imediato)).replace(' ', '0');

        if (rs == null || rt == null) {
            throw new IllegalArgumentException("Registrador desconhecido");
        }

        return opcodeBinary + rs + rt + imediatoBinario;
    }

    private static String convertITipo(String[] parts, String opcodeBinary) {
        String rt = RegistradorMap.getRegistrador(parts[1]);
        String rs = RegistradorMap.getRegistrador(parts[3]);
        int imediato = Integer.parseInt(parts[2]);
        String imediatoBinario = String.format("%16s", Integer.toBinaryString(imediato)).replace(' ', '0');

        if (rs == null || rt == null) {
            throw new IllegalArgumentException("Registrador desconhecido");
        }

        return opcodeBinary + rs + rt + imediatoBinario;
    }
}
