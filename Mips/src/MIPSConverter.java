import java.util.Scanner;

public class MIPSConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma instrução MIPS:"); // Entrada da instrução
        String instrucao = sc.nextLine();
        sc.close();

        String instrucaoBinario = convertToBinary(instrucao);
        System.out.println("Instrução em binário: " + instrucaoBinario);
    }

    private static String convertToBinary(String instrucao) {
        String[] parts = instrucao.split("\\s+|,\\s*|\\(|\\)"); // o split separa a string e reparte cada informação
        String opcode = parts[0];
        String opcodeBinario = OpCodeMap.getOpcode(opcode);

        if (opcodeBinario == null) {
            throw new IllegalArgumentException("Opcode desconhecido: " + opcode);
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
            case "sll":
            case "srl":
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
                return convertRTipo(parts, opcodeBinario);
            case "lw":
            case "sw":
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
            case "bltzal":
            case "bgezal":
            case "beq":
            case "bne":
            case "blez":
            case "bgtz":
                return convertITipo(parts, opcodeBinario);
            default:
                throw new IllegalArgumentException("Tipo de instrução não suportado: " + opcode);
        }
    }

    private static String convertRTipo(String[] parts, String opcodeBinary) {
        String rs = RegistradorMap.getRegistrador(parts[2]);
        String rt = RegistradorMap.getRegistrador(parts[3]);
        String rd = RegistradorMap.getRegistrador(parts[1]);
        String shamt = "00000"; // Valor padrão para R-Type
        String funct = parts[0].equals("add") ? "100000" : "100010"; 

        return opcodeBinary + rs + rt + rd + shamt + funct;
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
