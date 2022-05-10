package dao.cliente;

import java.io.*;

import entidade.Cliente;

/**
 * Implementa a classe do Registro do arquivo binário.
 *
 * @author osmarbraz
 */
public class RAFRegistroCliente extends Cliente {

    public RAFRegistroCliente() {
        super("0", "", "");
    }

    public RAFRegistroCliente(String codigo, String nome, String cpf) {
        super(codigo, nome, cpf);
    }

    public void escrita(RandomAccessFile arquivo) throws IOException {
        arquivo.writeInt(Integer.parseInt(getClienteId()));
        escreveString(arquivo, getNome(), 100);
        escreveString(arquivo, getCpf(), 11);
    }

    public void leitura(RandomAccessFile arquivo) throws IOException {
        setClienteId(arquivo.readInt() + "");
        setNome(lerString(arquivo, 100).trim());
        setCpf(lerString(arquivo, 11).trim());
    }

    private void escreveString(RandomAccessFile arquivo, String name, int tamanho) throws IOException {
        StringBuffer buf = null;
        if (name != null) {
            buf = new StringBuffer(name);
        } else {
            buf = new StringBuffer(tamanho);
        }
        buf.setLength(tamanho);
        arquivo.writeChars(buf.toString());
    }

    private String lerString(RandomAccessFile f, int tamanho) throws IOException {
        char name[] = new char[tamanho], temp;
        for (int i = 0; i < name.length; i++) {
            temp = f.readChar();
            name[i] = temp;
        }
        return new String(name).replace('\0', ' ');
    }

    public int getTamanho() {
        return 200 + 22 + 4;
    }
}
