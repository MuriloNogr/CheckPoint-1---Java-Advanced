package jacp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Servidor {
    private static final int PORTA = 9600;
    private static final String UNIDADE_PERSISTENCIA = "ProdutoPU";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORTA);
            System.out.println("Servidor iniciado na porta " + PORTA);

            while (true) {
                Socket socketCliente = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String idProduto = ConexaoTCP.receber(socketCliente);
                            String produto = buscarProdutoPorId(idProduto);
                            if (produto != null) {
                                ConexaoTCP.enviar(socketCliente, produto.toString());
                            } else {
                                ConexaoTCP.enviar(socketCliente, "Produto não encontrado.");
                            }
                            socketCliente.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String buscarProdutoPorId(String idProduto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIDADE_PERSISTENCIA);
        EntityManager em = emf.createEntityManager();
        Produto produto = null;
        String resultado = "";
        try {
            // Limpeza e validação do ID do produto
            idProduto = idProduto.trim();
            if (!idProduto.matches("\\d+")) {
                System.err.println("ID do produto inválido: " + idProduto);
                resultado = "ID do produto inválido.";
                return resultado; // Retorna imediatamente se o ID não for válido
            }

            produto = em.find(Produto.class, Integer.parseInt(idProduto));
            if (produto != null) {
                resultado = produto.toString();
            } else {
                resultado = "Produto não encontrado.";
            }
        } catch (NumberFormatException e) {
            System.err.println("ID do produto inválido: " + idProduto);
            e.printStackTrace();
            resultado = "ID do produto inválido.";
        } catch (Exception e) {
            System.err.println("Erro ao buscar produto por ID: " + idProduto);
            e.printStackTrace();
            resultado = "Erro ao buscar produto.";
        } finally {
            em.close();
            emf.close();
        }
        return resultado;
    }

}