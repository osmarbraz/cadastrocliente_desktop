package cliente;

import entidade.Cliente;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestCliente {

    @Test
    public void testCliente() {
        Cliente instancia = new Cliente();
        assertTrue("".equals(instancia.getClienteId()) && "".equals(instancia.getNome()) && "".equals(instancia.getCpf()));
    }

    @Test
    public void testClienteIdInt() {
        Cliente instancia = new Cliente();
        instancia.setClienteId(1);
        assertTrue("1".equals(instancia.getClienteId()) && "".equals(instancia.getNome()) && "".equals(instancia.getCpf()));
    }

//    @Test
//    public void testClienteParaString() {
//        Cliente instancia = new Cliente();
//        System.out.println("instancia:" + instancia.paraString());
//        assertTrue("clienteId: - Nome : - CPF :".equals(instancia.paraString()));
//    }
}
