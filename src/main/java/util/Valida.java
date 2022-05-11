package util;


import java.util.InputMismatchException;

/**
 * Classe utilitaria para conter operações de validação
 *
 * @author osmarbraz
 */
public class Valida {

    /**
     * Construtor sem argumentos.
     */
    public Valida() {
    }
   
   /**
     * Valida os digitos verificadores de um CPF.
     *
     * @param cpf Um literal com um cpf de cliente.
     */
    public boolean validaCPF(String cpf) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
//        if (cpf.equals("00000000000") || cpf.equals("11111111111")
//                || cpf.equals("22222222222") || cpf.equals("33333333333")
//                || cpf.equals("44444444444") || cpf.equals("55555555555")
//                || cpf.equals("66666666666") || cpf.equals("77777777777")
//                || cpf.equals("88888888888") || cpf.equals("99999999999")
//                || (cpf.length() != 11)) {
//            return (false);
//        }

        char dig10, dig11;
        int soma, resto, numero, peso;

        // "try" - protege o código para eventuais erros de conversão de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            soma = 0;
            peso = 10;
            for (int i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (resto + 48); // converte no respectivo caractere numerico
            }
            
            // Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (resto + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
