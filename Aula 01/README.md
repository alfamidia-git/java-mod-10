# Introdução ao Apache Maven
O Apache Maven é uma ferramenta poderosa de gerenciamento e compreensão de projetos de software. Em projetos web, especialmente em Java, Maven é amplamente utilizado para facilitar a construção, documentação e dependência do projeto. Nesta aula, focaremos na estrutura do Maven, especificamente no arquivo pom.xml, e como ele é utilizado em aplicações web.

## O que é Apache Maven?
O Apache Maven é uma ferramenta de automação de build utilizada principalmente para projetos Java. Ele usa uma abordagem de configuração declarativa para gerenciar dependências do projeto, ciclos de vida de build, e outros aspectos.

## Estrutura do pom.xml
O pom.xml é o coração de qualquer projeto Maven. Ele contém informações cruciais como configurações do projeto, dependências, plugins, versões e mais.

### Elementos-chave do pom.xml
**modelVersion**: Especifica a versão do modelo de objeto POM que está sendo usado.
**groupId**: Identifica o grupo ou organização que o projeto pertence.
**artifactId**: Nome do artefato (geralmente o nome do projeto).
**version**: Versão do artefato.
**dependencies**: Lista de dependências necessárias para o projeto.
**build**: Configurações de build, incluindo plugins.
**parent**: Permite herdar configurações de um projeto Maven pai.

## Dependências
No Maven, as dependências são gerenciadas no elemento **dependencies**. Cada dependência é definida por seu groupId, artifactId e version.
```xml
<dependencies>
    <dependency>
        <groupId>[group-id]</groupId>
        <artifactId>[artifact-id]</artifactId>
        <version>[version]</version>
    </dependency>
    <!-- Mais dependências aqui -->
</dependencies>
```

## Adicionando dependência do MySQL
```xml
<dependencies>
    <!-- Dependência do MySQL Connector/J -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>[inserir-versão-aqui]</version>
    </dependency>

    <!-- Outras dependências, se necessário -->
</dependencies>

```

# Exercício
1. Crie um projeto Maven WebApp.
2. Adicione a dependência do MySQL
3. Copie a estrutura do projeto do módulo anterior