package br.com.ufjf.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.ufjf.modelo.User;

@Stateless
@LocalBean
public class UserRepository implements GenericRepository<User, Integer> {

	private static final Class<User> User = null;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Class<User> getObjectClass() {

		return User;
	}

	@Override
	public User salvar(User object) {
		this.manager.persist(object);
		return object;
	}

	@Override
	public User pesquisarPorId(Integer id) {
		return this.manager.find(User.class, id);
	}

	@Override
	public User atualizar(User object) {
		this.manager.merge(object);
		return object;
	}

	@Override
	public void excluir(User object) {
		object = manager.merge(object);
		manager.remove(object);

	}

	@Override
	public List<User> todos() {
		TypedQuery<User> query = this.manager.createQuery(
				"select x from User x", User.class);
		return query.getResultList();
	}

	/*
	 * metodos em que crio um consulta hql atraves da estring query paasando os
	 * parametros
	 */

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listPesqParam(String query, Map<String, Object> params) {
		Query q = manager.createQuery(query);
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));
		}
		ArrayList<User> resultado = ((ArrayList<User>) q.getResultList());
		return resultado;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listPesqParam(String query, Map<String, Object> params,
			int maximo, int atual) {
		Query q = manager.createQuery(query).setMaxResults(maximo)
				.setFirstResult(atual);

		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		ArrayList<User> resultado = ((ArrayList<User>) q.getResultList());
		return resultado;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listPesq(String query) {
		Query q = manager.createQuery(query);
		ArrayList<User> resultado = ((ArrayList<User>) q.getResultList());
		return resultado;
	}

	@Override
	public User Pesq(String query) {
		Query q = manager.createQuery(query);
		User User = ((User) q.getSingleResult());
		return User;
	}

	@Override
	public User pesqParam(String query, Map<String, Object> params) {
		Query q = manager.createQuery(query);
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		try {
			User User = ((User) q.getSingleResult());
			return User;
		} catch (NoResultException nre) {
			return null;
		}
	}

}
