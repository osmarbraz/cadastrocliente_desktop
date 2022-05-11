package dao.cliente;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import dao.RAFDAOFactory;
import entidade.Cliente;
import java.util.logging.Logger;

/**
 * Implementa a persitência para cliente utilizando Arquivo de Acesso
 * Aleatório(RandomAcessFile).
 *
 * @author osmarbraz
 */
public class RAFClienteDAO extends RAFDAOFactory implements ClienteDAO {

    private static final Logger LOGGER = Logger.getLogger(RAFClienteDAO.class.getName());

    private RandomAccessFile arquivo;

    public RAFClienteDAO() {
        abrirArquivo();
    }

    private void abrirArquivo() {
        try {
            File NomeArquivo = new File("cliente.dat");
            arquivo = new RandomAccessFile(NomeArquivo, "rw");
        } catch (IOException e) {
            LOGGER.severe("Problema em abrir o arquivo!" + e);
        }
    }

    public void fecharArquivo() {
        try {
            arquivo.close();
        } catch (IOException e) {
            LOGGER.severe("Problema em fechar o arquivo!" + e);
        }
    }

    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            if (procurarCodigo(cliente.getClienteId() + "") == -1) {
                try {
                    RAFRegistroCliente registro = new RAFRegistroCliente();
                    registro.setClienteId(Integer.parseInt(cliente.getClienteId()));
                    registro.setNome(cliente.getNome());
                    registro.setCpf(cliente.getCpf());
                    arquivo.seek(arquivo.length());
                    registro.escrita(arquivo);
                    return true;
                } catch (IOException e) {
                    LOGGER.severe("Problema em inserir o registro!" + e);
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List getLista() {
        List lista = new LinkedList();
        RAFRegistroCliente registro = new RAFRegistroCliente();
        try {
            arquivo.seek(0);

            while (arquivo.getFilePointer() < arquivo.length()) {
                registro.leitura(arquivo);
                Cliente cli = new Cliente();
                cli.setClienteId(registro.getClienteId());
                cli.setNome(registro.getNome());
                cli.setCpf(registro.getCpf());
                lista.add(cli);
            }
        } catch (EOFException eof) {
            LOGGER.severe("Problema no fim do arquivo em geLista:" + eof);
        } catch (IOException io) {
            LOGGER.severe("Problema de io no arquivo em getLista:" + io);
        }
        return lista;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            List lista = new LinkedList();
            //Filtro para clienteId
            if (cliente.getClienteId() != null) {
                try {
                    arquivo.seek(0);
                    RAFRegistroCliente registro = new RAFRegistroCliente();

                    while (arquivo.getFilePointer() < arquivo.length()) { //Avança enquanto tiver objetos
                        registro.leitura(arquivo);
                        if (registro.getClienteId().equalsIgnoreCase(cliente.getClienteId())) {
                            Cliente cli = new Cliente();
                            cli.setClienteId(registro.getClienteId());
                            cli.setNome(registro.getNome());
                            cli.setCpf(registro.getCpf());
                            lista.add(cli);
                        }
                    }
                } catch (EOFException eof) {
                    LOGGER.severe("Problema no fim do arquivo no aplicar filtro no id:" + eof);
                } catch (IOException io) {
                    LOGGER.severe("Problema de io no arquivo em aplicar filtro no id:" + io);
                }
            } else {
                //Filtro para nome
                if (cliente.getNome() != null) {
                    try {
                        arquivo.seek(0);
                        RAFRegistroCliente registro = new RAFRegistroCliente();
                        while (arquivo.getFilePointer() < arquivo.length()) { //Avança enquanto tiver objetos
                            registro.leitura(arquivo);
                            if (registro.getNome().equalsIgnoreCase(cliente.getNome())) {
                                Cliente cli = new Cliente();
                                cli.setClienteId(registro.getClienteId());
                                cli.setNome(registro.getNome());
                                cli.setCpf(registro.getCpf());
                                lista.add(cli);
                            }
                        }
                    } catch (EOFException eof) {
                        LOGGER.severe("Problema no fim do arquivo no aplicar filtro no nome:" + eof);
                    } catch (IOException io) {
                        LOGGER.severe("Problema de io no arquivo em aplicar filtro no nome:" + io);
                    }
                } else {
                    //Filtro para CPF
                    if (cliente.getCpf() != null) {
                        try {
                            arquivo.seek(0);
                            RAFRegistroCliente registro = new RAFRegistroCliente();
                            while (arquivo.getFilePointer() < arquivo.length()) { //Avança enquanto tiver objetos
                                registro.leitura(arquivo);
                                if (registro.getCpf().equalsIgnoreCase(cliente.getCpf())) {
                                    Cliente cli = new Cliente();
                                    cli.setClienteId(registro.getClienteId());
                                    cli.setNome(registro.getNome());
                                    cli.setCpf(registro.getCpf());
                                    lista.add(cli);
                                }
                            }
                        } catch (EOFException eof) {
                            LOGGER.severe("Problema no fim do arquivo no aplicar filtro no cpf:" + eof);
                        } catch (IOException io) {
                            LOGGER.severe("Problema de io no arquivo em aplicar filtro no cpf:" + io);
                        }
                    }
                }
            }
            return lista;
        } else {
            return null;
        }
    }

    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            String chave = cliente.getClienteId() + "";
            long pos = -1;
            RAFRegistroCliente registro = new RAFRegistroCliente();
            try {
                pos = procurarCodigo(chave);
                if (pos != -1) {
                    int cont = 0;
                    arquivo.seek(pos * registro.getTamanho());
                    registro.setClienteId(cliente.getClienteId());
                    registro.setNome(cliente.getNome());
                    registro.setCpf(cliente.getCpf());
                    registro.escrita(arquivo);
                    return 1;
                } else {
                    return 0;
                }
            } catch (EOFException eof) {
                LOGGER.severe("Problema no fim do arquivo em alterar:" + eof);
            } catch (IOException io) {
                LOGGER.severe("Problema de io no arquivo em alterar:" + io);
            }
            return 1;
        }
        return 0;
    }

    private int procurarCodigo(String cod) {
        int pos = -1;
        int cont = 0;
        RAFRegistroCliente registro = new RAFRegistroCliente();
        try {
            arquivo.seek(0);
            while (arquivo.getFilePointer() < arquivo.length()) {
                registro.leitura(arquivo);
                if (registro.getClienteId().equalsIgnoreCase(cod)) {
                    pos = cont;
                }
                cont = cont + 1;
            }
        } catch (EOFException eof) {
            LOGGER.severe("Problema no fim do arquivo em procurar por código:" + eof);
        } catch (IOException io) {
            LOGGER.severe("Problema de io no arquivo em procurar por código:" + io);
        }
        return pos;
    }

    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            String chave = cliente.getClienteId() + "";
            long pos = -1;
            RAFRegistroCliente registro = new RAFRegistroCliente();
            try {
                pos = procurarCodigo(chave);
                if (pos != -1) {
                    int cont = 0;
                    arquivo.seek(pos * registro.getTamanho());
                    registro.setClienteId(-1);
                    registro.setNome("");
                    registro.setCpf("");
                    registro.escrita(arquivo);
                } else {
                    LOGGER.severe("ClienteId não encontrado!");
                }
            } catch (EOFException eof) {;} 
            catch (IOException io) {;}
            return 1;
        }
        return 0;
    }
}
