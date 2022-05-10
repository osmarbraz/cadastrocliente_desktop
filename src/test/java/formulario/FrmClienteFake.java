package formulario;

import javax.swing.JTextField;

public class FrmClienteFake extends FrmCliente {

    public FrmClienteFake() {
        inicializar();
    }

    private void inicializar() {
        jTClienteId = new JTextField();
        jTNome = new JTextField();
        jTCpf = new JTextField();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println("Mensagem:" + mensagem);
    }
}
