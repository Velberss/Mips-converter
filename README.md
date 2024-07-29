# Conversor de MIPS

## Visão Geral

Este projeto é um conversor de código de montagem MIPS (MIPS Instruction Set) para código binário. O conversor suporta vários tipos de instruções MIPS, incluindo R-type, I-type e J-type.

## Características

- Suporta conversão de código de montagem MIPS para código binário
- Manipula instruções R-type, I-type e J-type
- Inclui um conjunto abrangente de instruções MIPS, incluindo aritméticas, lógicas e de controle de fluxo
- Fornece uma interface de linha de comando simples e intuitiva para converter arquivos MIPS

## Uso

1. Compile o código Java usando:
   ```bash
   javac MIPSConverter.java
2. Execute o conversor usando:
   ```bash
   java MIPSConverter <arquivo_entrada> <arquivo_saida>
Onde <arquivo_entrada> é o arquivo de código de montagem MIPS e <arquivo_saida> é o arquivo de saída binário.

##Exemplo de Uso
Suponha que você tenha um arquivo de código de montagem MIPS programa.mips contendo o seguinte código:
 ```mips
add $t0, $t1, $t2
lw $t3, 4($t4)
j label
```
Para converter esse código para binário, execute o conversor usando o seguinte comando:
   ```bash
   java MIPSConverter <arquivo_entrada> <arquivo_saida>
```
O conversor gerará um arquivo binário saida.bin contendo o código binário convertido.
##Organização do Código
O projeto consiste em um único arquivo Java MIPSConverter.java, que contém a implementação do conversor. O código é organizado em vários métodos, cada um responsável por manipular um tipo específico de instrução MIPS.

##Requisitos
-Java Development Kit (JDK) 8 ou posterior
-Um arquivo de código de montagem MIPS para converter

##Limitações Conhecidas
-O conversor suporta apenas um subconjunto de instruções MIPS. Instruções adicionais podem precisar ser adicionadas para compatibilidade total.
-O conversor supõe que o código de montagem MIPS de entrada seja válido e não executa nenhuma verificação de erros.

##Desenvolvimento Futuro
-Adicionar suporte para instruções MIPS adicionais
-Implementar verificação de erros e tratamento para código de montagem MIPS inválido
-Melhorar o desempenho e a eficiência do conversor

##Licença
Este projeto é licenciado sob a Licença MIT. Consulte o arquivo LICENSE para detalhes.

##Agradecimentos
Este projeto foi desenvolvido como parte de um curso de arquitetura de computadores. O autor gostaria de agradecer aos instrutores e assistentes do curso por sua orientação e apoio.

