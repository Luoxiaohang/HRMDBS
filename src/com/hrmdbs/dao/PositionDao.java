package com.hrmdbs.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrmdbs.archive.bean.Employee;
import com.hrmdbs.archive.bean.PositionName;
import com.hrmdbs.archive.bean.PositionSorted;
import com.hrmdbs.archive.bean.ProfessionalTitle;
import com.hrmdbs.archive.bean.SecondOrganization;
import com.hrmdbs.archive.bean.ThirdOrganization;
import com.hrmdbs.archive.bean.TopOrganization;
import com.hrmdbs.utils.HibernateUtil;

public class PositionDao {
	/**
	 * 添加职位
	 */
	public static void addPosition() {
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
	}

	public static Employee findPositionById(Integer id) {
		Employee Employee = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			Employee = (Employee) session.get(Employee.class, id);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return Employee;
	}

	/**
	 * 返回所有的职位名称
	 * 
	 * @return
	 */
	public static HashMap<String, PositionName> findAllPositionName() {
		HashMap<String, PositionName> positionNames = new HashMap<String, PositionName>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from PositionName";
			Query query = session.createQuery(hql);
			ArrayList<PositionName> ems = (ArrayList<PositionName>) query
					.list();
			t.commit();
			for (PositionName to : ems) {
				positionNames.put(to.getPositionName(), to);
			}
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return positionNames;
	}

	/**
	 * 返回所有的职位分类
	 * 
	 * @return
	 */
	public static HashMap<String, PositionSorted> findAllPositionSorted() {
		HashMap<String, PositionSorted> positionSorteds = new HashMap<String, PositionSorted>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from PositionSorted";
			Query query = session.createQuery(hql);
			ArrayList<PositionSorted> ems = (ArrayList<PositionSorted>) query
					.list();
			t.commit();
			for (PositionSorted to : ems) {
				positionSorteds.put(to.getPositionSortedName(), to);
			}
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return positionSorteds;
		} finally {
			HibernateUtil.closeSession();
		}
		return positionSorteds;
	}

	/**
	 * 返回所有的职称
	 * 
	 * @return
	 */
	public static HashMap<String, ProfessionalTitle> findAllProfessionalTitle() {
		HashMap<String, ProfessionalTitle> professionalTitles = new HashMap<String, ProfessionalTitle>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from ProfessionalTitle";
			Query query = session.createQuery(hql);
			ArrayList<ProfessionalTitle> ems = (ArrayList<ProfessionalTitle>) query
					.list();
			t.commit();
			for (ProfessionalTitle to : ems) {
				professionalTitles.put(to.getProfessionalTitle(), to);
			}
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return professionalTitles;
		} finally {
			HibernateUtil.closeSession();
		}
		return professionalTitles;
	}

	/**
	 * 返回所有的一级结构
	 * 
	 * @return
	 */
	public static HashMap<String, TopOrganization> findAllTopOrganization() {
		HashMap<String, TopOrganization> topOrganizations = new HashMap<String, TopOrganization>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from TopOrganization";
			Query query = session.createQuery(hql);
			ArrayList<TopOrganization> ems = (ArrayList<TopOrganization>) query
					.list();
			t.commit();
			for (TopOrganization to : ems) {
				topOrganizations.put(to.getTopOrganizationName(), to);
			}
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return topOrganizations;
		} finally {
			HibernateUtil.closeSession();
		}
		return topOrganizations;
	}

	/**
	 * 返回所有的一级结构
	 * 
	 * @return
	 */
	public static HashMap<String, SecondOrganization> findAllSecondOrganization() {
		HashMap<String, SecondOrganization> secondOrganizations = new HashMap<String, SecondOrganization>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from SecondOrganization";
			Query query = session.createQuery(hql);
			ArrayList<SecondOrganization> ems = (ArrayList<SecondOrganization>) query
					.list();
			t.commit();
			for (SecondOrganization to : ems) {
				secondOrganizations.put(to.getSecondOrganizationName(), to);
			}
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return secondOrganizations;
		} finally {
			HibernateUtil.closeSession();
		}
		return secondOrganizations;
	}

	/**
	 * 返回所有的一级结构
	 * 
	 * @return
	 */
	public static HashMap<String, ThirdOrganization> findAllThirdOrganization() {
		HashMap<String, ThirdOrganization> thirdOrganizations = new HashMap<String, ThirdOrganization>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from ThirdOrganization";
			Query query = session.createQuery(hql);
			ArrayList<ThirdOrganization> ems = (ArrayList<ThirdOrganization>) query
					.list();
			t.commit();
			for (ThirdOrganization to : ems) {
				thirdOrganizations.put(to.getThirdOrganizationName(), to);
			}
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return thirdOrganizations;
		} finally {
			HibernateUtil.closeSession();
		}
		return thirdOrganizations;
	}

	public static boolean addTopPosition(String sb) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			TopOrganization to = new TopOrganization();
			to.setTopOrganizationName(sb);
			session.save(to);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public static boolean addSecondOgnize(SecondOrganization so) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(so);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public static boolean addThirdOrganization(ThirdOrganization so) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(so);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public static boolean addPositionName(PositionName positionName) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(positionName);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public static boolean addProfessionanTitle(
			ProfessionalTitle professionalTitle) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(professionalTitle);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public static boolean addTopPositionSorted(PositionSorted positionSorted) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(positionSorted);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
