package at.htl.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import at.htl.model.Student;

/**
 * DAO for Student
 */
@Stateless
public class StudentDao {
	@PersistenceContext(unitName = "micro-persistence-unit")
	private EntityManager em;

	public void create(Student entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Student entity = em.find(Student.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student update(Student entity) {
		return em.merge(entity);
	}

	public List<Student> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Student> findAllQuery = em
				.createQuery("SELECT DISTINCT s FROM Student s ORDER BY s.id",
						Student.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
