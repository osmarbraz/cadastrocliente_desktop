package formulario;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 * Classe que implementa a interface principal do sistema.
 *
 * @author osmarbraz
 */
@SuppressWarnings("serial")
public class FrmCliente extends JFrame {

    private JPanel contentPaneFrmCliente;

    private JLabel jLClienteId;
    private JTextField jTClienteId;
    private JLabel jLNome;
    private JTextField jTNome;
    private JLabel jLCpf;
    private JTextField jTCpf;

    private JButton jBIncluir;
    private JButton jBAlterar;
    private JButton jBExcluir;
    private JButton jBConsultar;
    private JButton jBLimpar;
    private JButton jBFechar;

    /**
     * Construtor sem argumentos.
     */
    public FrmCliente() {
        inicializar();
    }

    public JTextField getjTClienteId() {
        return jTClienteId;
    }

    public void setjTClienteId(JTextField jTClienteId) {
        this.jTClienteId = jTClienteId;
    }

    public JTextField getjTNome() {
        return jTNome;
    }

    public void setjTNome(JTextField jTNome) {
        this.jTNome = jTNome;
    }

    public JTextField getjTCpf() {
        return jTCpf;
    }

    public void setjTCpf(JTextField jTCpf) {
        this.jTCpf = jTCpf;
    }

    public JLabel getjLClienteId() {
        return jLClienteId;
    }

    public void setjLClienteId(JLabel jLClienteId) {
        this.jLClienteId = jLClienteId;
    }

    public JLabel getjLNome() {
        return jLNome;
    }

    public void setjLNome(JLabel jLNome) {
        this.jLNome = jLNome;
    }

    public JLabel getjLCpf() {
        return jLCpf;
    }

    public void setjLCpf(JLabel jLCpf) {
        this.jLCpf = jLCpf;
    }

    public JButton getjBIncluir() {
        return jBIncluir;
    }

    public void setjBIncluir(JButton jBIncluir) {
        this.jBIncluir = jBIncluir;
    }

    public JButton getjBAlterar() {
        return jBAlterar;
    }

    public void setjBAlterar(JButton jBAlterar) {
        this.jBAlterar = jBAlterar;
    }

    public JButton getjBExcluir() {
        return jBExcluir;
    }

    public void setjBExcluir(JButton jBExcluir) {
        this.jBExcluir = jBExcluir;
    }

    public JButton getjBConsultar() {
        return jBConsultar;
    }

    public void setjBConsultar(JButton jBConsultar) {
        this.jBConsultar = jBConsultar;
    }

    public JButton getjBLimpar() {
        return jBLimpar;
    }

    public void setjBLimpar(JButton jBLimpar) {
        this.jBLimpar = jBLimpar;
    }

    public JButton getjBFechar() {
        return jBFechar;
    }

    public void setjBFechar(JButton jBFechar) {
        this.jBFechar = jBFechar;
    }
    
    

    public JPanel getContentPaneFrmCliente() {
        return contentPaneFrmCliente;
    }

    public void setContentPaneFrmCliente(JPanel contentPane) {
        this.contentPaneFrmCliente = contentPane;
    }

    /**
     * Inicializa os componentes da janela.
     */
    private void inicializar() {
        setContentPaneFrmCliente((JPanel) this.getContentPane());

        jLClienteId = new JLabel();
        jTClienteId = new JTextField();
        jLNome = new JLabel();
        jTNome = new JTextField();
        jLCpf = new JLabel();
        jTCpf = new JTextField();

        jBIncluir = new JButton();
        jBAlterar = new JButton();
        jBConsultar = new JButton();
        jBExcluir = new JButton();
        jBLimpar = new JButton();
        jBFechar = new JButton();

        getContentPaneFrmCliente().setLayout(null);

        this.setSize(new Dimension(310, 230));
        this.setTitle("Cadastro de Cliente");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jLClienteId.setBounds(new Rectangle(11, 11, 60, 17));
        jTClienteId.setBounds(new Rectangle(11, 28, 70, 21));
        jLClienteId.setText("ClienteId");

        jLNome.setBounds(new Rectangle(11, 60, 60, 17));
        jTNome.setBounds(new Rectangle(11, 75, 180, 21));
        jLNome.setText("Nome");

        jLCpf.setBounds(new Rectangle(11, 109, 170, 17));
        jTCpf.setBounds(new Rectangle(11, 124, 120, 21));
        jLCpf.setText("CPF (Somente números)");

        jBIncluir.setBounds(new Rectangle(200, 9, 90, 27));
        jBIncluir.setText("Incluir");

        jBAlterar.setBounds(new Rectangle(200, 39, 90, 27));
        jBAlterar.setText("Alterar");

        jBExcluir.setBounds(new Rectangle(200, 69, 90, 27));
        jBExcluir.setText("Excluir");

        jBConsultar.setBounds(new Rectangle(200, 99, 90, 27));
        jBConsultar.setText("Consultar");

        jBLimpar.setBounds(new Rectangle(200, 129, 90, 27));
        jBLimpar.setText("Limpar");

        jBFechar.setBounds(new Rectangle(200, 159, 90, 27));
        jBFechar.setText("Fechar");

        getContentPaneFrmCliente().add(jLClienteId, null);
        getContentPaneFrmCliente().add(jTClienteId, null);
        getContentPaneFrmCliente().add(jLNome, null);
        getContentPaneFrmCliente().add(jTNome, null);
        getContentPaneFrmCliente().add(jLCpf, null);
        getContentPaneFrmCliente().add(jTCpf, null);

        getContentPaneFrmCliente().add(jBIncluir, null);
        getContentPaneFrmCliente().add(jBAlterar, null);
        getContentPaneFrmCliente().add(jBExcluir, null);
        getContentPaneFrmCliente().add(jBConsultar, null);
        getContentPaneFrmCliente().add(jBLimpar, null);
        getContentPaneFrmCliente().add(jBFechar, null);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Processa os eventos da janela.
     *
     * @param e Eventos da janela.
     */
    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}
