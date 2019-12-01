package com.org.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.models.Employee;
import com.org.models.Skill;
import com.org.repositories.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepo;
	
	public List<Skill> addSkill(Employee emp,Set<Skill> skills) {
		List<Skill> list = new ArrayList<Skill>();
		for (Skill s : skills) {
			Skill skill = new Skill();
			skill.setName(s.getName());
			skill.setEmployee(emp);
			list.add(skill);
		}
		return this.skillRepo.saveAll(list);
	}
}
