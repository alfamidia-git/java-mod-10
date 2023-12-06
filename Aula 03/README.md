# Criando a entidade Professor
Nesta aula criaremos toda nossa entidade professor com o uso do JPA

```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String disciplina;
    // Getters e setters
}
```

## Criando a classe ProfessorRepository
```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProfessorRepository implements Crud<Professor>{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");

    @Override
    public void create(Professor professor) {
    	EntityManager em = factory.createEntityManager();

    	em.getTransaction().begin();

    	em.persist(professor);
    	em.getTransaction().commit();

    	em.close();
    }

    @Override
    public void update(Professor professorAtualizado) {
    	EntityManager em = factory.createEntityManager();
    	
    	try {
    		Professor velhoProfessor = em.find(Professor.class, professorAtualizado.getId());
    		
    		em.getTransaction().begin();
    		
    		velhoAluno.setDisciplina(professorAtualizado.getDisciplina());
    		velhoAluno.setNome(professorAtualizado.getNome());
   
    		em.getTransaction().commit();
    		
    	}finally {
    		em.close();
    	}
    }

    @Override
    public void delete(int id) {
    	EntityManager em = factory.createEntityManager();
    	
    	try {
    		Professor professor = em.find(Professor.class, id);
    		
    		em.getTransaction().begin();
    		
    		em.remove(professor);
    		
    		em.getTransaction().commit();
    	}finally {
    		em.close();
    	}
    }

    @Override
    public List<Professor> readAll() {
    	EntityManager em = factory.createEntityManager();
    	List<Professor> resultado = null;
    	
    	try {
    		String jpql = "SELECT p FROM Professor p";
    		
    		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
    		
    		resultado = query.getResultList();
    	}finally {
    		em.close();
    	}
    	
    	return resultado;
    }

    @Override
    public Professor readById(int id) {
    	EntityManager em = factory.createEntityManager();
    	
    	try {
    		return em.find(Professor.class, id);
    	}finally {
    		em.close();
    	}
    	
    }
```



# Exercício
Crie um servlet para o professor e suas views (assim como temos dos alunos), podendo listar, editar e excluir