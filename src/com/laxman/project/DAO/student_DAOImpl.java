package com.laxman.project.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.user;


@Repository
public class student_DAOImpl implements student_DAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Programs_scheduled> get_programs_scheduled_student_not_applied(int id) {
		Session session=sessionFactory.getCurrentSession();
		
		DetachedCriteria subquery = DetachedCriteria.forClass(Application.class)
			    .add(Restrictions.eq("user_id",id))
			    .setProjection(Projections.property("schedule_program_id"));

		Criteria criteria = session.createCriteria(Programs_scheduled.class).add(Subqueries.propertyNotIn("scheduled_program_id", subquery));
		
		return criteria.list();
		
	}

	@Override
	@Transactional
	public List<Programs_scheduled> get_programs_scheduled_student_interview_approval_waiting(int id) {
		Session session=sessionFactory.getCurrentSession();
		
		DetachedCriteria subquery = DetachedCriteria.forClass(Application.class)
			    .add(Restrictions.eq("user_id",id))
			    .add(Restrictions.eq("status","fresh"))
			    .setProjection(Projections.property("schedule_program_id"));

		Criteria criteria = session.createCriteria(Programs_scheduled.class).add(Subqueries.propertyIn("scheduled_program_id", subquery));
		
		return criteria.list();
	}

	@Override
	@Transactional
	public List<Programs_scheduled> get_programs_scheduled_student_confirmation_waiting(int id) {
		Session session=sessionFactory.getCurrentSession();
		DetachedCriteria subquery = DetachedCriteria.forClass(Application.class)
			    .add(Restrictions.eq("user_id",id))
			    .add(Restrictions.eq("status","interview"))
			    .setProjection(Projections.property("schedule_program_id"));

		Criteria criteria = session.createCriteria(Programs_scheduled.class).add(Subqueries.propertyIn("scheduled_program_id", subquery));
		
		return criteria.list();
	}

	@Override
	@Transactional
	public List<Programs_scheduled> get_programs_scheduled_student_confirmed(int id) {
		Session session=sessionFactory.getCurrentSession();
		DetachedCriteria subquery = DetachedCriteria.forClass(Application.class)
			    .add(Restrictions.eq("user_id",id))
			    .add(Restrictions.eq("status","confirmed"))
			    .setProjection(Projections.property("schedule_program_id"));

		Criteria criteria = session.createCriteria(Programs_scheduled.class).add(Subqueries.propertyIn("scheduled_program_id", subquery));
		
		return criteria.list();
	}

	@Override
	@Transactional
	public List<Programs_scheduled> get_programs_scheduled_student_rejected(int id) {
		Session session=sessionFactory.getCurrentSession();
		DetachedCriteria subquery = DetachedCriteria.forClass(Application.class)
			    .add(Restrictions.eq("user_id",id))
			    .add(Restrictions.eq("status","rejected"))
			    .setProjection(Projections.property("schedule_program_id"));

		Criteria criteria = session.createCriteria(Programs_scheduled.class).add(Subqueries.propertyIn("scheduled_program_id", subquery));
		
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void save_new_student(user student) {
		Session session=sessionFactory.getCurrentSession();
		student.setRole("student");
		session.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public void save_application(Application app) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(app);
	}

	@Override
	@Transactional
	public String[] get_students_email() {
		Session session=sessionFactory.getCurrentSession();
		List<user> users= session.createQuery("from user", user.class).list();
		String[] emails= {};
		for(user u:users) {
			emails[emails.length]=u.getEmail();
			System.out.println(emails[emails.length]);
		}
		return emails;
	}

	@Override
	@Transactional
	public List<Application> get_student(int app_id) {
		Session session=sessionFactory.getCurrentSession();
		List<Application> applications= session.createQuery("from application a where a.application_id=:id", Application.class).list();
		return applications;
	}

	@Override
	@Transactional
	public List<Programs_scheduled> get_program_name(int app_id) {
		Session session=sessionFactory.getCurrentSession();
		DetachedCriteria subquery = DetachedCriteria.forClass(Application.class)
			    .add(Restrictions.eq("application_id",app_id))
			    .setProjection(Projections.property("schedule_program_id"));

		Criteria criteria = session.createCriteria(Programs_scheduled.class).add(Subqueries.propertyIn("scheduled_program_id", subquery));
		return criteria.list();
		
	}

	@Override
	@Transactional
	public List<user> get_student_id(String user_name) {
		Session session=sessionFactory.getCurrentSession();
		List<user> student= session.createQuery("from user a where a.user_name=:name", user.class).setParameter("name", user_name).list();
		return student;
	}

}
