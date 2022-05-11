package dao.cliente;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestRAFRegistroCliente {

    @Test
    public void RAFRegistroCliente() {
        RAFRegistroCliente instancia = new RAFRegistroCliente("0", "", "");
        assertTrue("0".equals(instancia.getClienteId()) && "".equals(instancia.getNome()) && "".equals(instancia.getCpf()));
    }
}
