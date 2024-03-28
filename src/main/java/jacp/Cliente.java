package jacp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public void comunicarComServidor() throws Exception {
        String textoRequisicao = "Conexao estabelecida";
        String textoRecebido = "";
        Socket socket = new Socket("localhost", 9600);

        Scanner input = new Scanner(System.in);
        System.out.print("\nDigite o ID do produto: ");
        textoRequisicao = input.nextLine();
        
        ConexaoTCP.enviar(socket, textoRequisicao);

        textoRecebido = ConexaoTCP.receber(socket);

        System.out.println("Servidor enviou: " + textoRecebido);
    }

    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            cliente.comunicarComServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
}
