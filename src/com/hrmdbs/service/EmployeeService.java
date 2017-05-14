package com.hrmdbs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.archive.bean.Manager;
import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.dao.EmployeeDao;
import com.hrmdbs.salary.bean.Bonus;

public class EmployeeService {

	/**
	 * ��������û�и��˵���Ա��Ϣ�ṹ
	 * 
	 * @return
	 */
	public static List<Employee> findUnCheckedEmployee() {
		return EmployeeDao.findUnChecked();
	}

	/**
	 * ��������û�и��˵���Ա��Ϣ�ṹ
	 * 
	 * @return
	 */
	public static List<Employee> findAllCheckedEmployee() {
		return EmployeeDao.findAllEmployee();
	}

	/**
	 * ���Ա��
	 * 
	 * @param em
	 * @return
	 */
	public static boolean addEmployee(Employee em) {
		return EmployeeDao.addEmployee(em);
	}

	/**
	 * ɾ��Ա��
	 * 
	 * @param em
	 */
	public static void deleteEmployee(Employee em) {
		EmployeeDao.deleteEmployeeById(em.getId());
	}

	/**
	 * ����Ա����Ϣ
	 * 
	 * @param em
	 * @return
	 */
	public static boolean updateEmployee(Employee em) {
		return EmployeeDao.updateEmployee(em);
	}

	public static void queryEmployee(Employee em) {

	}

	/**
	 * ��¼
	 * 
	 * @param name
	 * @param password
	 * @return ְ��id
	 */
	public static int login(String name, String password) {
		return EmployeeDao.login(name, password);
	}

	public static void main(String[] args) {
	}

	/**
	 * 
	 * @param hrid
	 * @return
	 */
	public static Employee findEffectiveEmployeeByHrid(String hrid) {
		return EmployeeDao.findEffectiveEmployeeByHrid(hrid);
	}

	/**
	 * 
	 * @param employee
	 * @return
	 */
	public static ArrayList<Employee> findEmployee(Employee employee) {
		return EmployeeDao.findEmployee(employee);
	}

	/**
	 * 
	 * @param manager
	 * @return
	 */
	public static boolean registManager(Manager manager) {
		Employee employee = findEffectiveEmployeeByHrid(manager.getEmployee()
				.getHrid());
		if (employee == null) {
			return false;
		}
		manager.setEmployee(employee);
		return EmployeeDao.addManager(manager);
	}

	/**
	 * 
	 * @return
	 */
	public static ArrayList<Employee> findAllEmployee() {
		return EmployeeDao.findAllEmployee();
	}

	/**
	 * 
	 * @return
	 */
	public static ArrayList<Employee> getDeletedEmployee() {
		return EmployeeDao.getAllDeletedEmployee();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static boolean recoverEmployee(int id) {
		return EmployeeDao.recoverEmployee(id);
	}

	/**
	 * 
	 * @return
	 */
	public static ArrayList<Employee> findAllEffectiveEmployee() {
		return EmployeeDao.findAllEffectiveEmployee();
	}

	public static ArrayList<Employee> findEmpInThirdOrgaById(int id) {
		return EmployeeDao.findEmpInThirdOrgaById(id);
	}

	public static ArrayList<Bonus> findSalaryUnCheckedEmployees(int id) {
		// TODO Auto-generated method stub
		return EmployeeDao.findSalaryUnCheckedEmployees(id);
	}

}
