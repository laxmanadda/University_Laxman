package com.laxman.project.service;

import java.util.List;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.user;
import com.laxman.project.entity.start_end;

public interface admin_service {
	public List<user> check_login(user user);

	public List<Programs_Offered> get_programs_offered();

	public List<Programs_scheduled> get_programs_scheduled();

	public void save_program_offered(Programs_Offered program);

	public Programs_Offered get_program_offered(String program_name);

	public void delete_program_offered(String program_name);

	public void save_program_scheduled(Programs_scheduled program);

	public Programs_scheduled get_program_scheduled(int schedule_id);

	public void delete_program_scheduled(int schedule_id);

	public List<start_end> get_start_end();

	public void save_start_end(start_end process);

	public String validate_program_offered(Programs_Offered program);

}
