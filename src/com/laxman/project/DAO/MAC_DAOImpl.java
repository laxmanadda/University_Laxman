package com.laxman.project.DAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.controller.Main_Controller;;

@Repository
public class MAC_DAOImpl implements MAC_DAO{
	
	// Keeping same interviews per day for all programs
	public int interviews_PerDay=10;
	
	//Keeping Gap between end_date and first interview date as 7days
	public int gap=7;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Application> get_applications_for_mac(String program_name, String status) {
		Session session=sessionFactory.getCurrentSession();
		
		DetachedCriteria subquery = DetachedCriteria.forClass(Programs_scheduled.class)
			    .add(Restrictions.eq("ProgramName",program_name))
			    .setProjection(Projections.property("scheduled_program_id"));

		Criteria criteria = session.createCriteria(Application.class).add(Subqueries.propertyIn("schedule_program_id", subquery));
		
		return criteria.list();
	}
	
	@Override
	@Transactional
	public int get_no_applications(int schedule_id) {
		Session session=sessionFactory.getCurrentSession();
		String query = "from Application a where a.schedule_program_id= :id";
		List<Application> applications = session.createQuery(query).setParameter("id",schedule_id).list();
		return applications.size();
	}

	@Override
	@Transactional
	public void approve_fresh_app(int app_id,int schedule_id) {
		Session session=sessionFactory.getCurrentSession();
		
		int no_applications= get_no_applications(schedule_id);
		
		//change System.currentTimeMillis() to end_date in the below step
		
		long interview_date=System.currentTimeMillis() + TimeUnit.DAYS.toMillis(gap+ no_applications/interviews_PerDay);
		Date date=new Date(interview_date);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String text = df.format(date);
		String query = "update Application a set a.status='interview', a.date_of_interview= :date where a.application_id= :id";
		int result=session.createQuery(query).setParameter("date",text).setParameter("id", app_id).executeUpdate();
	}

	@Override
	@Transactional
	public void reject_app(int app_id) {
		Session session=sessionFactory.getCurrentSession();
		String query = "update Application a set a.status='rejected' where a.application_id= :id";
		session.createQuery(query).setParameter("id", "app_id").executeUpdate();
	}

	@Override
	@Transactional
	public void approve_interview_app(int app_id) {
		Session session=sessionFactory.getCurrentSession();
		String query = "update Application a set a.status='confirmed' where a.application_id= :id";
		session.createQuery(query).setParameter("id", "app_id").executeUpdate();
	}

}
