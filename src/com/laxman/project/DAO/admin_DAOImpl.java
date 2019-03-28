package com.laxman.project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.user;
import com.laxman.project.entity.start_end;

@Repository
public class admin_DAOImpl implements admin_DAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<user> check_login(user user) {
		Session session=sessionFactory.getCurrentSession();
		String role="";
		
		String query = "from User u where u.user_name = :name and u.password= :pass";
		List<user> result = session.createQuery(query).setParameter("name", user.getUser_name()).setParameter("pass",user.getPassword()).list();
		if(!result.isEmpty()) {
			role=result.get(0).getRole();
		}
		return result;
	}

	@Override
	@Transactional
	public List<Programs_Offered> get_programs_offered() {
		Session session=sessionFactory.getCurrentSession();
		List<Programs_Offered> l=session.createQuery("from Programs_Offered", Programs_Offered.class).list();
		return l;
	}

	@Override
	@Transactional
	public List<Programs_scheduled> get_programs_scheduled() {
		Session session=sessionFactory.getCurrentSession();
		List<Programs_scheduled> l=session.createQuery("from Programs_scheduled", Programs_scheduled.class).list();
		return l;
	}

	@Override
	@Transactional
	public void save_program_offered(Programs_Offered program) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(program);
	}

	@Override
	@Transactional
	public Programs_Offered get_program_offered(String program_name) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Programs_Offered.class,program_name );
	}

	@Override
	@Transactional
	public void delete_program_offered(String program_name) {
		Session session=sessionFactory.getCurrentSession();
		Programs_Offered program_offered=session.get(Programs_Offered.class,program_name);
		session.delete(program_offered);
	}

	@Override
	@Transactional
	public void save_program_scheduled(Programs_scheduled program) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(program);
	}

	@Override
	public Programs_scheduled get_program_scheduled(int schedule_id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Programs_scheduled.class,schedule_id );
	}

	@Override
	@Transactional
	public void delete_program_scheduled(int schedule_id) {
		Session session=sessionFactory.getCurrentSession();
		Programs_scheduled program_scheduled=session.get(Programs_scheduled.class,schedule_id);
		session.delete(program_scheduled);
	}

	@Override
	@Transactional
	public List<start_end> get_start_end() {
		Session session=sessionFactory.getCurrentSession();
		List<start_end> list=session.createQuery("from start_end", start_end.class).list();
		return list;
	}

	@Override
	@Transactional
	public void save_start_end(start_end process) {
		Session session=sessionFactory.getCurrentSession();
		session.save(process);
		
	}

}
