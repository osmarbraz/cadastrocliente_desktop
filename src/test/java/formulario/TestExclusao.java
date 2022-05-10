package formulario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controle.CtrCliente;
import static org.junit.Assert.assertEquals;

public class TestExclusao {

    private static CtrCliente controle = null;
    private static FrmClienteFake frmCliente = null;

    @Before
    public void setUp() {
        frmCliente = new FrmClienteFake();
        controle = new CtrCliente();
        controle.setFrmCliente(frmCliente);
    }

    @Test
    public void testExclusao() {
        String idTeste = "1";
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

        assertEquals(controle.getFrmCliente().jTNome.getText(), "");
    }

    @After
    public void tearDown() {
        controle = null;
        frmCliente = null;
    }
}
