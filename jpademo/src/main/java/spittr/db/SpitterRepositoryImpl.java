package spittr.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import spittr.domain.Spitter;

public class SpitterRepositoryImpl implements SpitterExtentionRepository{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Spitter getSpitterByGmail(String gMail) {
		String sql="select spitter from Spitter as spitter where spitter.email=?1";
		Query query=em.createQuery(sql);
		query.setParameter(1, gMail);
		return (Spitter) query.getSingleResult();
	}

}
