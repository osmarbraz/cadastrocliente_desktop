package dao;

import cliente.TestCliente;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import dao.cliente.TestRAFRegistroCliente;

@RunWith(Suite.class)
@SuiteClasses({
    TestCliente.class,
    TestDAOFactory.class,
    TestDAOConsulta.class,
    TestDAOConsultaId.class,
    TestDAOConsultaNome.class,
    TestDAOConsultaCPF.class,
    TestDAOAlteracao.class,
    TestDAOInclusao.class,
    TestDAOInclusaoChavePrimaria.class,
    TestDAOExclusao.class,
    TestRAFRegistroCliente.class})

public class TesteSuiteDAO {

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TesteSuiteDAO.class);
    }
}
