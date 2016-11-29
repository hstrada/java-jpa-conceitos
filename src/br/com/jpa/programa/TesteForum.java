package br.com.jpa.programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.entity.Forum;
import br.com.jpa.entity.Usuario;
import br.com.jpa.helper.ForumHelper;

public class TesteForum {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		
		ForumHelper dao = new ForumHelper(em);
		/* 
		Forum forum = new Forum();
		forum.setAssunto("JDBC");
		forum.setDescricao("JDBC Conceitos");
		System.out.println(dao.salvar(forum));
		
		Usuario usuario = new Usuario();
		usuario.setNome("Julio");
		usuario.setEmail("julio@fiap.com.br");
		System.out.println(dao.adicionarUsuario(forum.getId(), usuario));
		*/
		
		// Objeto Forum
		Forum forum = new Forum();
		forum.setAssunto("HIBERNATE");
		forum.setDescricao("HIBERNATE Conceitos");
		
		// Objetos Usuarios
		Usuario u1 = new Usuario();
		u1.setNome("Vinicius");
		u1.setEmail("vinicius@fiap.com.br");
		u1.setForum(forum);
		
		Usuario u2 = new Usuario();
		u2.setNome("Diego");
		u2.setEmail("diego@fiap.com.br");
		u2.setForum(forum);
		
		Usuario u3 = new Usuario();
		u3.setNome("Michel");
		u3.setEmail("michel@fiap.com.br");
		u3.setForum(forum);
		
		// Incluindo cada usuário na lista de usuários do forum
		forum.getUsuarios().add(u1);
		forum.getUsuarios().add(u2);
		forum.getUsuarios().add(u3);
		
		System.out.println(dao.salvar(forum));
		
	}
}