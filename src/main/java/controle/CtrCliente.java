package controle;

import java.awt.event.ActionEvent;

import formulario.FrmCliente;
import entidade.Cliente;
import util.Valida;

/**
 * Classe que realiza a interação entre a interface e a entidade do sistema.
 *
 * @author osmarbraz
 */
public class CtrCliente {

    private FrmCliente frmCliente;

    /**
     * Construtor sem argumentos.
     */
    public CtrCliente() {

        // Instancia a janela
        setFrmCliente(new FrmCliente());

        // Associa os eventos aos componentes
        getFrmCliente().jBIncluir.addActionListener(this::jBIncluir_actionPerformed);

        getFrmCliente().jBAlterar.addActionListener(this::jBAlterar_actionPerformed);

        getFrmCliente().jBConsultar.addActionListener(this::jBConsultar_actionPerformed);

        getFrmCliente().jBExcluir.addActionListener(this::jBExcluir_actionPerformed);

        getFrmCliente().jBLimpar.addActionListener(this::jBLimpar_actionPerformed);

        getFrmCliente().jBFechar.addActionListener(this::jBFechar_actionPerformed);
    }

    /**
     * Operação que inicia a sequência de interações da manutenção de cliente.
     */
    public void executar() {
        getFrmCliente().setVisible(true);
    }

    /**
     * Inclui um cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBIncluir_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().getjTClienteId().getText());
        cliente.setNome(getFrmCliente().getjTNome().getText());
        cliente.setCpf(getFrmCliente().getjTCpf().getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido == true) {
            boolean resultado = cliente.inserir();
            if (resultado == true) {
                getFrmCliente().mostrarMensagem("Inclusão realizada com sucesso!");
            } else {
                getFrmCliente().mostrarMensagem("Inclusão não realizada!");
            }
        } else {
            getFrmCliente().mostrarMensagem("CPF Inválido!");
        }
    }

    /**
     * Altera um cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBAlterar_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().getjTClienteId().getText());
        cliente.setNome(getFrmCliente().getjTNome().getText());
        cliente.setCpf(getFrmCliente().getjTCpf().getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido == true) {
            int resultado = cliente.alterar();
            if (resultado != 0) {
                getFrmCliente().mostrarMensagem("Alteração realizada com sucesso!");
            } else {
                getFrmCliente().mostrarMensagem("Alteração não realizada!");
            }
        } else {
            getFrmCliente().mostrarMensagem("CPF Inválido!");
        }
    }

    /**
     * Consulta um cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBConsultar_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().getjTClienteId().getText());
        boolean resultado = cliente.abrir();
        if (resultado == true) {
            getFrmCliente().getjTNome().setText(cliente.getNome());
            getFrmCliente().getjTCpf().setText(cliente.getCpf());
            getFrmCliente().mostrarMensagem("Cliente encontrado!");
        } else {
            getFrmCliente().mostrarMensagem("Cliente não encontrado!");
        }
    }

    /**
     * Excluí o cliente.
     *
     * @param e Objeto do evento.
     */
    public void jBExcluir_actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().getjTClienteId().getText());
        int resultado = cliente.excluir();
        if (resultado != 0) {
            getFrmCliente().mostrarMensagem("Exclusão realizada com sucesso!");
        } else {
            getFrmCliente().mostrarMensagem("Exclusão não realizada!");
        }
    }

    /**
     * Limpa as caixas de texto.
     *
     * @param e Objeto do evento.
     */
    public void jBLimpar_actionPerformed(ActionEvent e) {
        getFrmCliente().getjTClienteId().setText("");
        getFrmCliente().getjTNome().setText("");
        getFrmCliente().getjTCpf().setText("");
    }

    /**
     * Fecha o sistema.
     *
     * @param e Objeto do evento.
     */
    public void jBFechar_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * Retorna o formulário utilizado por este controle.
     *
     * @return Um formulário.
     */
    public FrmCliente getFrmCliente() {
        return frmCliente;
    }

    /**
     * Modifica o formulário utilizando por este controle.
     *
     * @param frmCliente Um formulário do tipo FrmCliente.
     */
    public void setFrmCliente(FrmCliente frmCliente) {
        this.frmCliente = frmCliente;
    }
}
