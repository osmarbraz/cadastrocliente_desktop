
import cliente.TestCliente;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import dao.TestDAOInclusao;
import dao.TestDAOExclusao;
import dao.TestDAOAlteracao;
import dao.TestDAOConsultaCPF;
import dao.TestDAOConsultaId;
import dao.TestDAOConsultaNome;
import dao.TestDAOFactory;
import dao.cliente.TestRAFRegistroCliente;
import util.TestValida;

@RunWith(Suite.class)
@SuiteClasses({
    TestCliente.class,
    TestDAOFactory.class,
    TestDAOConsultaId.class,
    TestDAOConsultaNome.class,
    TestDAOConsultaCPF.class,
    TestDAOAlteracao.class,
    TestDAOInclusao.class,
    TestDAOExclusao.class,
    TestValida.class,
    TestRAFRegistroCliente.class})

public class TesteSuite {

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TesteSuite.class);
    }
}
