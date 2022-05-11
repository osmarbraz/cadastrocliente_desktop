
import cliente.TestCliente;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import dao.TestDAOInclusao;
import dao.TestDAOExclusao;
import dao.TestClienteDAOHashMap;
import dao.TestDAOFactory;
import util.TestValida;

@RunWith(Suite.class)
@SuiteClasses({
    TestCliente.class,
    TestDAOFactory.class,
    TestClienteDAOHashMap.class,
    TestDAOInclusao.class,
    TestDAOExclusao.class,
    TestValida.class})

public class TesteSuite {

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TesteSuite.class);
    }
}
