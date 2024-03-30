Classe Servidor
Esta classe é responsável por iniciar um servidor TCP que escuta conexões na porta especificada. Ela tem um loop infinito que aceita conexões de clientes e cria uma nova thread para cada conexão, permitindo que o servidor lide com múltiplas conexões simultaneamente.

Método main: Inicia o servidor na porta especificada e entra em um loop infinito para aceitar conexões de clientes.
Método buscarProdutoPorId: Este método é responsável por buscar um produto no banco de dados pelo seu ID. Ele cria uma instância do EntityManagerFactory e EntityManager para interagir com o banco de dados. Tenta encontrar um produto pelo ID fornecido e retorna uma string representando o produto ou uma mensagem de erro.
Classe ConexaoTCP
Esta classe fornece métodos estáticos para enviar e receber dados através de uma conexão TCP.

Método receber: Recebe dados de um Socket e retorna uma string. Ele lê os bytes recebidos e os converte em uma string.
Método enviar: Envia uma string para um Socket. Ele converte a string em bytes e os escreve no OutputStream do Socket.
Classe Produto
Esta classe representa uma entidade de produto no banco de dados. Ela é mapeada para uma tabela no banco de dados usando anotações JPA.

Anotações JPA: A classe usa anotações como @Entity, @Table, @Id, e @Column para mapear a entidade para uma tabela no banco de dados.
Atributos: Representam as colunas da tabela no banco de dados. Cada atributo tem um getter e um setter correspondente.
Método toString: Sobrescreve o método toString para fornecer uma representação em string do produto, que é usada para enviar os detalhes do produto de volta ao cliente.
Configuração do JPA
O arquivo persistence.xml define a unidade de persistência e as propriedades de conexão com o banco de dados. Ele especifica o provedor de persistência (neste caso, Hibernate), a URL de conexão, o nome de usuário e a senha, e outras configurações específicas do Hibernate.

Dependências do Projeto
O arquivo pom.xml define as dependências do projeto, incluindo o driver JDBC para Oracle, o Hibernate, e o Log4j para logging. Essas dependências são necessárias para o funcionamento do JPA e da conexão com o banco de dados.

Criação da Tabela Produtos
CREATE TABLE TDS_TB_PRODUTOCS 
(
  ID_PRODUTO INTEGER 
, NM_PRODUTO VARCHAR2(100) 
, VL_PRODUTO FLOAT 
, DT_VALIDADE DATE 
, TM_PRODUTO FLOAT 
, DS_PRODUTO VARCHAR2(200) 
);

Resumo
O código define um servidor TCP simples que aceita conexões de clientes, recebe um ID de produto, busca o produto correspondente no banco de dados usando JPA, e envia os detalhes do produto de volta ao cliente. A classe Produto representa a entidade de produto no banco de dados, e a classe ConexaoTCP fornece funcionalidades para enviar e receber dados através de uma conexão TCP. A configuração do JPA é definida em persistence.xml, e as dependências do projeto são gerenciadas em pom.xml.



