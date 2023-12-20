package repository;

import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AlunoRepository implements Crud<Aluno>{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");

    @Override
    public void create(Aluno aluno) {
    	EntityManager em = factory.createEntityManager();

    	em.getTransaction().begin();

    	em.persist(aluno);
    	em.getTransaction().commit();

    	em.close();
    }

    @Override
    public void update(Aluno alunoAtualizado) {
    	EntityManager em = factory.createEntityManager();
    	
    	try {
    		Aluno velhoAluno = em.find(Aluno.class, alunoAtualizado.getId());
    		
    		em.getTransaction().begin();
    		
    		velhoAluno.setIdade(alunoAtualizado.getIdade());
    		velhoAluno.setNome(alunoAtualizado.getNome());
   
    		em.getTransaction().commit();
    		
    	}finally {
    		em.close();
    	}
    }

    @Override
    public void delete(int id) {
    	EntityManager em = factory.createEntityManager();
    	
    	try {
    		Aluno aluno = em.find(Aluno.class, id);
    		
    		em.getTransaction().begin();
    		
    		em.remove(aluno);
    		
    		em.getTransaction().commit();
    	}finally {
    		em.close();
    	}
    }

    @Override
    public List<Aluno> readAll() {
    	EntityManager em = factory.createEntityManager();
    	List<Aluno> resultado = null;
    	
    	try {
    		String jpql = "SELECT a FROM Aluno a";
    		
    		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
    		
    		resultado = query.getResultList();
    	}finally {
    		em.close();
    	}
    	
    	return resultado;
    }

    @Override
    public Aluno readById(int id) {
    	EntityManager em = factory.createEntityManager();
    	
    	try {
    		return em.find(Aluno.class, id);
    	}finally {
    		em.close();
    	}
    	
    }
}
 