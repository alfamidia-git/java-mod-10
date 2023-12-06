# Introdução ao JPA com Hibernate
O Java Persistence API (JPA) é um padrão da plataforma Java EE para mapeamento objeto-relacional (ORM). Ele facilita o gerenciamento de dados persistentes em aplicações Java, principalmente em bases de dados. Nesta aula, exploraremos os conceitos básicos do JPA, usando Hibernate como provedor, incluindo configuração de entidades, EntityManager e outras coisas.

## O que é JPA?
JPA é uma especificação Java para acessar, persistir e gerenciar dados entre objetos Java e um banco de dados relacional. Hibernate é um dos provedores ORM mais populares que implementam JPA.

## Configurando o Hibernate com JPA no pom.xml
Para usar o Hibernate como provedor JPA, você precisa adicionar suas dependências no arquivo pom.xml do Maven. A dependência principal é o hibernate-core, junto com o hibernate-entitymanager para integração JPA.


### Dependências no pom.xml
```xml
<dependencies>
    <!-- Hibernate Core -->
    <dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-core</artifactId>
		<version>6.4.0.Final</version>
	</dependency>

    <!-- Outras dependências necessárias -->
</dependencies>
```

## Estrutura de um Projeto JPA
* **Entidades**: Classes Java anotadas com @Entity, representando tabelas no banco de dados.
* **persistence.xml**: Arquivo de configuração do JPA, localizado em src/main/resources/META-INF.

## Configurando persistence.xml
```xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">

    <persistence-unit name="escola">
        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/escola" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="" />

            <!-- Configurações específicas do Hibernate -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
        </properties>
    </persistence-unit>
</persistence>
```
## Mapeando nossa Entidade
1. Crie uma classe Java com a anotação @Entity
2. Defina os campos que representam as colunas da tabela.

```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
    @Id
    private Integer id;
    private String nome;
    private Integer idade;
    // Getters e setters
}
```

## EntityManager
O **EntityManager** é a interface principal do JPA para acessar o contexto de persistência.

## Uso do EntityManager
1. Crie um **EntityManagerFactory**.
```java
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");
```
2. Crie e utilize um **EntityManager** para operações de banco de dados.
```java
import javax.persistence.EntityManager;

EntityManager em = factory.createEntityManager();
```

3. Aqui está um exemplo de como inserir um novo aluno usando o EntityManager:
```java
Aluno novoAluno = new Aluno();
novoAluno.setNome("João");
novoAluno.setIdade(20);

// Iniciando uma transação
em.getTransaction().begin();

// Persistindo o objeto aluno
em.persist(novoAluno);

// Commitando a transação
em.getTransaction().commit();

// Fechando o EntityManager
em.close();
```

## Benefícios de Usar JPA com Hibernate
1. **Abstração de Acesso a Dados:** Simplifica a interação com o banco de dados.
2. **Mapeamento Objeto-Relacional:** Facilita o mapeamento de objetos Java para tabelas de banco de dados.
3. **Portabilidade:** Permite mudar de banco de dados com poucas ou nenhuma alteração no código. 

# Exercício
Altere a estrutura do seu projeto de JDBC para JPA