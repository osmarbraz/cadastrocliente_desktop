package formulario;

import controle.CtrCliente;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestInclusao {

    private static CtrCliente controle = null;
    private static FrmClienteFake frmCliente = null;
    //private static FrmCliente clienteFake = null;

    @Before
    public void inicializa() {
        frmCliente = new FrmClienteFake();
        //clienteFake = new FrmCliente();
        controle = new CtrCliente();
        controle.setFrmCliente(frmCliente);
    }

    @Test
    public void testIncluir() {
        String idTeste = "121";
        String nomeTeste = "Carlos";
        String cpfTeste = "11111111111";

        frmCliente.jTClienteId.setText(idTeste);
        frmCliente.jTNome.setText(nomeTeste);
        frmCliente.jTCpf.setText(cpfTeste);
        controle.jBIncluir_actionPerformed(null);

        controle.jBLimpar_actionPerformed(null);
        frmCliente.jTClienteId.setText(idTeste);
        controle.jBConsultar_actionPerformed(null);

        assertEquals(controle.getFrmCliente().jTNome.getText(), nomeTeste);
    }

    @After
    public void Finaliza() {
        //Apaga o dado inserido
        String idTeste = "121";
        String nomeTeste = "Carlos";
        String cpfTeste = "11111111111";

        frmCliente.jTClienteId.setText(idTeste);
        frmCliente.jTNome.setText(nomeTeste);
        frmCliente.jTCpf.setText(cpfTeste);
        controle.jBIncluir_actionPerformed(null);

        controle.jBLimpar_actionPerformed(null);
        frmCliente.jTClienteId.setText(idTeste);
        controle.jBExcluir_actionPerformed(null);
        controle.jBConsultar_actionPerformed(null);

        controle = null;
        frmCliente = null;
    }
}
