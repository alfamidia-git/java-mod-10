# Conhecendo o Lombok
O Lombok é uma biblioteca Java que foi criada para reduzir a verbosidade do código, automatizando a geração de código repetitivo, como getters, setters, construtores, métodos equals, hashCode e toString. Ela funciona por meio de anotações que são adicionadas nas classes Java, e durante a compilação, o Lombok gera automaticamente o código associado às anotações. Isso torna o código mais limpo, legível e fácil de manter.

## Principais anotações
1. **@Data**: A anotação @Data é usada em classes e gera automaticamente os métodos equals, hashCode, toString, bem como os métodos getters e setters para todos os campos da classe. É uma das anotações mais utilizadas e ajuda a eliminar uma grande quantidade de código repetitivo.
2. **@Getter e @Setter**: As anotações @Getter e @Setter são usadas para gerar automaticamente apenas os métodos getters ou setters, respectivamente, para os campos da classe em que são aplicadas. Isso permite que você escolha quais campos devem ter esses métodos gerados.
3. **@NoArgsConstructor, @RequiredArgsConstructor e @AllArgsConstructor**: Essas anotações geram automaticamente construtores vazios (@NoArgsConstructor), construtores que aceitam argumentos para todos os campos (@AllArgsConstructor) e construtores que aceitam argumentos apenas para campos marcados como final ou @NonNull 
4. **@EqualsAndHashCode**: A anotação @EqualsAndHashCode gera os métodos equals e hashCode para a classe com base nos campos marcados. Isso é útil para garantir que objetos da classe possam ser comparados e usados em coleções, como conjuntos (sets) e mapas (maps).
5. **@ToString**: A anotação @ToString gera automaticamente o método toString para a classe, que retorna uma representação de string do objeto, exibindo os valores de seus campos. Isso é útil para depuração e registro.
6. **@Builder**: A anotação @Builder cria um padrão de construção fluente para a classe, permitindo que você crie objetos complexos com uma sintaxe mais legível e intuitiva. Isso é especialmente útil para criar objetos imutáveis.

O Lombok é amplamente utilizado na comunidade Java para tornar o desenvolvimento mais eficiente e reduzir a quantidade de código "boilerplate" (código repetitivo) que os desenvolvedores precisam escrever. Ele simplifica a criação de classes de modelo, entidades JPA e outras estruturas de dados, tornando o código mais conciso e fácil de manter

## Adicionando a dependência
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version> <!-- Use a versão mais recente -->
    <scope>provided</scope>
</dependency>
```

```java
@Entity
@Data
public class Professor {
	//atributos
```

```java
@Entity
@Data
public class Aluno {
	//atributos
```

# Exercício
Remova os getters e setters de suas classes e substitua pelo Lombok.