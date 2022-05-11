package dao.cliente;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dao.HashMapDAOFactory;
import entidade.Cliente;
import java.util.Collections;

/**
 * Implementa a persitência para cliente utilizando HashMap.
 *
 * @author osmarbraz
 */
public class HashMapClienteDAO extends HashMapDAOFactory implements ClienteDAO {

    private static Map<String, Cliente> mapa;

    /**
     * Construtor sem argumentos.
     */
    public HashMapClienteDAO() {
        //Se o mapa estiver nulo instancia para armazenar os clientes
        if (mapa == null) {
            mapa = new HashMap<>();
        }
    }

    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getClienteId());
            if (!tem) {
                mapa.put(cliente.getClienteId(), cliente);
                return true;
            }
        }
        return false;
    }

    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getClienteId());
            if (tem) {
                Cliente c = (Cliente) mapa.get(cliente.getClienteId());
                c.setNome(cliente.getNome());
                c.setCpf(cliente.getCpf());
                return 1;
            }
        }
        return 0;
    }

    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getClienteId());
            if (tem) {
                mapa.remove(cliente.getClienteId());
                return 1;
            }
        }
        return 0;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List getLista() {
        List<Cliente> lista = new LinkedList();
        Iterator it = mapa.values().iterator();
        while (it.hasNext()) { //Avança enquanto tiver objetos
            Cliente c = (Cliente) it.next();
            lista.add(c);
        }
        return lista;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            List<Cliente> lista = new LinkedList();
            Iterator it = mapa.values().iterator();

            //Filtro para clienteId
            if (!"0".equals(cliente.getClienteId())) {
                while (it.hasNext()) { //Avança enquanto tiver objetos
                    Cliente c = (Cliente) it.next();
                    if (c.getClienteId().equalsIgnoreCase(cliente.getClienteId())) {
                        lista.add(c);
                    }
                }
            }

            //Filtro para nome
            if (!"".equals(cliente.getNome())) {
                it = mapa.values().iterator();
                while (it.hasNext()) { //Avança enquanto tiver objetos
                    Cliente c = (Cliente) it.next();
                    if (c.getNome().equalsIgnoreCase(cliente.getNome())) {
                        lista.add(c);
                    }
                }
            }

            //Filtro para CPF
            if (!"".equals(cliente.getCpf())) {
                it = mapa.values().iterator();
                while (it.hasNext()) { //Avança enquanto tiver objetos
                    Cliente c = (Cliente) it.next();
                    if (c.getCpf().equalsIgnoreCase(cliente.getCpf())) {
                        lista.add(c);
                    }
                }
            }

            return lista;
        } else {
            return Collections.emptyList();
        }
    }
}
