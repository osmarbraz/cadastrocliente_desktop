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
        getFrmCliente().jBIncluir.addActionListener(this::jButtonIncluirActionPerformed);

        getFrmCliente().jBAlterar.addActionListener(this::jButtonAlterarActionPerformed);

        getFrmCliente().jBConsultar.addActionListener(this::jButtonConsultarActionPerformed);

        getFrmCliente().jBExcluir.addActionListener(this::jButtonExcluirActionPerformed);

        getFrmCliente().jBLimpar.addActionListener(this::jButtonLimparActionPerformed);

        getFrmCliente().jBFechar.addActionListener(this::jButtonFecharActionPerformed);
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
    public void jButtonIncluirActionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().getjTClienteId().getText());
        cliente.setNome(getFrmCliente().getjTNome().getText());
        cliente.setCpf(getFrmCliente().getjTCpf().getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido) {
            boolean resultado = cliente.inserir();
            if (resultado) {
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
    public void jButtonAlterarActionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().getjTClienteId().getText());
        cliente.setNome(getFrmCliente().getjTNome().getText());
        cliente.setCpf(getFrmCliente().getjTCpf().getText());
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido) {
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
    public void jButtonConsultarActionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(getFrmCliente().getjTClienteId().getText());
        boolean resultado = cliente.abrir();
        if (resultado) {
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
    public void jButtonExcluirActionPerformed(ActionEvent e) {
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
    public void jButtonLimparActionPerformed(ActionEvent e) {
        getFrmCliente().getjTClienteId().setText("");
        getFrmCliente().getjTNome().setText("");
        getFrmCliente().getjTCpf().setText("");
    }

    /**
     * Fecha o sistema.
     *
     * @param e Objeto do evento.
     */
    public void jButtonFecharActionPerformed(ActionEvent e) {
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
