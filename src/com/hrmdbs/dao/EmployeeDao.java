package com.hrmdbs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.archive.bean.Manager;
import com.hrmdbs.salary.bean.Bonus;
import com.hrmdbs.utils.HibernateUtil;

public class EmployeeDao {

	public static boolean addEmployee(Employee em) {
		boolean added = false;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(em);
			t.commit();
			added = true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			added = false;
		} finally {
			HibernateUtil.closeSession();
		}
		return added;
	}

	public static boolean addManager(Manager manager) {
		boolean added = false;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(manager);
			t.commit();
			added = true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return added;
	}

	/**
	 * 返回管理者的类别
	 * 
	 * @param em
	 * @return
	 */
	public static int queryManager(int id) {

		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return -1;
	}

	/**
	 * 返回管理者的类别
	 * 
	 * @param em
	 * @return
	 */
	public static int login(String userName, String password) {
		int caregory = 0;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Manager m where m.userName=? and m.password=?";
			Query query = session.createQuery(hql);
			query.setString(0, userName);
			query.setString(1, password);
			Manager manager = (Manager) query.uniqueResult();
			if (manager == null) {
				return -1;
			}
			caregory = manager.getEmployee().getProfessionalTitle().getId();
			t.commit();
			return caregory;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return -1;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public static boolean addAllEmployee(ArrayList<Employee> ems) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			for (int i = 0; i < ems.size(); i++) {
				session.save(ems.get(i));
				if (i % 25 == 0) {
					t.commit();
					session.clear();
					t.begin();
				}
			}
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}

	public static Employee findEffectiveEmployeeByHrid(String hrid) {
		Employee employee = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee e where e.hrid=(?) and e.checked=(?) and e.deleted=(?) ";
			Query query = session.createQuery(hql);
			query.setString(0, hrid);
			query.setBoolean(1, true);
			query.setBoolean(2, false);
			employee = (Employee) query.uniqueResult();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return employee;
	}

	/**
	 * 返回没有复核的人员信息
	 * 
	 * @return
	 */
	public static List<Employee> findUnChecked() {
		List<Employee> ems = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee  u where u.checked=?";
			Query query = session.createQuery(hql);
			query.setBoolean(0, false);
			ems = (List<Employee>) query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return ems;
		} finally {
			HibernateUtil.closeSession();
		}
		return ems;
	}

	/**
	 * 返回所有的员工信息
	 * 
	 * @return
	 */
	public static ArrayList<Employee> findAllEmployee() {
		ArrayList<Employee> ems = new ArrayList<Employee>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee";
			Query query = session.createQuery(hql);
			ems = (ArrayList<Employee>) query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return ems;
		} finally {
			HibernateUtil.closeSession();
		}
		return ems;
	}

	/**
	 * 返回所有的有效的员工信息(不包含删除后的，以及未审核的)
	 * 
	 * @return
	 */
	public static ArrayList<Employee> findAllEffectiveEmployee() {
		ArrayList<Employee> ems = new ArrayList<Employee>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee e where e.checked=(?) and e.deleted=(?)";
			Query query = session.createQuery(hql);
			query.setBoolean(0, true);
			query.setBoolean(1, false);
			ems = (ArrayList<Employee>) query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return ems;
		} finally {
			HibernateUtil.closeSession();
		}
		return ems;
	}

	public static Employee findEmployeeBy() {
		Employee Employee = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee h where h.name=? and h.age=?";
			Query query = session.createQuery(hql);
			query.setString(0, "name");
			query.setInteger(1, 10);
			Employee = (Employee) query.uniqueResult();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return Employee;
		} finally {
			HibernateUtil.closeSession();
		}
		return Employee;
	}

	public static Employee updateEmployeeById(Integer id) {
		Employee Employee = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			//
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return Employee;
	}

	public static Employee deleteEmployeeById(Integer id) {
		Employee employee = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			employee = (Employee) session.get(Employee.class, id);
			employee.setDeleted(true);
			session.update(employee);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return employee;
	}

	public static boolean updateEmployee(Employee em) {
		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.update(em);
			t.commit();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			success = false;
		} finally {
			HibernateUtil.closeSession();
		}
		return success;
	}

	public static ArrayList<Employee> findEmployee(Employee employee) {
		ArrayList<Employee> employees = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee h where h.topOrganization=(?) and h.secondOrganization=(?) and h.thirdOrganization=(?)and h.positionSorted=(?)and h.positionName=(?) and h.deleted=(?) and h.checked=(?)";
			Query query = session.createQuery(hql);
			query.setInteger(0, employee.getTopOrganization().getId());
			query.setInteger(1, employee.getSecondOrganization().getId());
			query.setInteger(2, employee.getThirdOrganization().getId());
			query.setInteger(3, employee.getPositionSorted().getId());
			query.setInteger(4, employee.getPositionName().getId());
			query.setBoolean(5, false);
			query.setBoolean(6, true);
			employees = (ArrayList<Employee>) query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return employees;
		} finally {
			HibernateUtil.closeSession();
		}
		return employees;

	}

	public static boolean recoverEmployee(int id) {
		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			Employee employee = (Employee) session.get(Employee.class, id);
			employee.setDeleted(false);
			session.update(employee);
			t.commit();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			success = false;
		} finally {
			HibernateUtil.closeSession();
		}
		return success;
	}

	public static ArrayList<Employee> getAllDeletedEmployee() {
		ArrayList<Employee> employees = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee h where h.deleted=(?) ";
			Query query = session.createQuery(hql);
			query.setBoolean(0, true);
			employees = (ArrayList<Employee>) query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return employees;
		} finally {
			HibernateUtil.closeSession();
		}
		return employees;

	}

	public static ArrayList<Employee> findEmpInThirdOrgaById(int id) {
		ArrayList<Employee> employees = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Employee h where h.thirdOrganization.id=(?) ";
			Query query = session.createQuery(hql);
			query.setInteger(0, id);
			employees = (ArrayList<Employee>) query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return employees;
		} finally {
			HibernateUtil.closeSession();
		}
		return employees;

	}

	public static ArrayList<Bonus> findSalaryUnCheckedEmployees(int id) {
		ArrayList<Bonus> employees = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from Bonus b where b.rechecked=(?) and b.employee.thirdOrganization=(?)";
			Query query = session.createQuery(hql);
			query.setBoolean(0, false);
			query.setInteger(1, id);
			employees = (ArrayList<Bonus>) query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return employees;
		} finally {
			HibernateUtil.closeSession();
		}
		return employees;

	}
}
