
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;

import util.TestValida;
import cliente.TestCliente;
import dao.TesteSuiteDAO;

@RunWith(Suite.class)
@SuiteClasses({
    TesteSuiteDAO.class,
    TestCliente.class,
    TestValida.class})
public class TesteSuite {

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TesteSuite.class);
    }
}
