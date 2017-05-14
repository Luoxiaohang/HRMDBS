package com.hrmdbs.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.archive.bean.PositionName;
import com.hrmdbs.archive.bean.PositionSorted;
import com.hrmdbs.archive.bean.ProfessionalTitle;
import com.hrmdbs.archive.bean.SecondOrganization;
import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.archive.bean.TopOrganization;
import com.hrmdbs.dao.PositionDao;
import com.hrmdbs.salary.bean.Bonus;

public class OrganizationService {

	/**
	 * �������е�ְλ����
	 * 
	 * @return
	 */
	public static HashMap<String, PositionName> findAllPositionName() {

		return PositionDao.findAllPositionName();
	}

	/**
	 * �������е�ְλ����
	 * 
	 * @return
	 */
	public static HashMap<String, PositionSorted> findAllPositionSorted() {
		return PositionDao.findAllPositionSorted();
	}

	/**
	 * �������е�ְ��
	 * 
	 * @return
	 */
	public static HashMap<String, ProfessionalTitle> findAllProfessionalTitle() {
		return PositionDao.findAllProfessionalTitle();
	}

	/**
	 * �������е�һ���ṹ
	 * 
	 * @return
	 */
	public static HashMap<String, TopOrganization> findAllTopOrganization() {
		return PositionDao.findAllTopOrganization();
	}

	/**
	 * �������еĶ����ṹ
	 * 
	 * @return
	 */
	public static HashMap<String, SecondOrganization> findAllSecondOrganization() {
		return PositionDao.findAllSecondOrganization();
	}

	/**
	 * �������е������ṹ
	 * 
	 * @return
	 */
	public static HashMap<String, ThirdOrganization> findAllThirdOrganization() {
		return PositionDao.findAllThirdOrganization();
	}

	public static void main(String[] args) {
	}

	/**
	 * ������Ӧ���������µ�����
	 * 
	 * @return
	 */
	public static HashMap<ThirdOrganization, ArrayList<Employee>> findEmployees() {
		HashMap<ThirdOrganization, ArrayList<Employee>> toes = new HashMap<ThirdOrganization, ArrayList<Employee>>();
		HashMap<String, ThirdOrganization> tos = findAllThirdOrganization();
		for (ThirdOrganization to : tos.values()) {
			ArrayList<Employee> es = EmployeeService.findEmpInThirdOrgaById(to
					.getId());
			toes.put(to, es);
		}
		return toes;
	}

	public static HashMap<ThirdOrganization, ArrayList<Bonus>> findSalaryUnCheckedEmployees() {
		HashMap<ThirdOrganization, ArrayList<Bonus>> toes = new HashMap<ThirdOrganization, ArrayList<Bonus>>();
		HashMap<String, ThirdOrganization> tos = findAllThirdOrganization();
		for (ThirdOrganization to : tos.values()) {
			ArrayList<Bonus> es = EmployeeService
					.findSalaryUnCheckedEmployees(to.getId());
			if (null != es && es.size() != 0) {
				toes.put(to, es);
			}
		}
		return toes;
	}

	public static boolean addTopPosition(String sb) {
		return PositionDao.addTopPosition(sb);
	}

	public static boolean addSecondOgnize(SecondOrganization so) {
		return PositionDao.addSecondOgnize(so);
	}

	public static boolean addThirdOrganization(ThirdOrganization so) {
		return PositionDao.addThirdOrganization(so);
	}

	public static boolean addPositionName(PositionName positionName) {
		return PositionDao.addPositionName(positionName);
	}

	public static boolean addProfessionanTitle(
			ProfessionalTitle professionalTitle) {
		return PositionDao.addProfessionanTitle(professionalTitle);
	}

	public static boolean addTopPositionSorted(PositionSorted positionSorted) {
		return PositionDao.addTopPositionSorted(positionSorted);
	}
}
