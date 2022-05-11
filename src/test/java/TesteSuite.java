
import cliente.TestCliente;
import dao.TesteSuiteDAO;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import util.TestValida;

@RunWith(Suite.class)
@SuiteClasses({
    TestCliente.class,
    TesteSuiteDAO.class,
    TestValida.class})

public class TesteSuite {

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TesteSuite.class);
    }
}
