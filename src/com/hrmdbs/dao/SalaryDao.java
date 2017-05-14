package com.hrmdbs.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrmdbs.salary.bean.Bonus;
import com.hrmdbs.salary.bean.SalaryItem;
import com.hrmdbs.salary.bean.SalaryRegistInfo;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.utils.HibernateUtil;

public class SalaryDao {

	public static ArrayList<SalaryItem> getAllSalaryItem() {
		ArrayList<SalaryItem> salaryItems = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			String hql = "from SalaryItem";
			Query query = session.createQuery(hql);
			salaryItems = (ArrayList<SalaryItem>) query.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return salaryItems;
	}

	public static boolean addSalaryStand(SalaryStand ss) {
		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(ss);
			t.commit();
			success = true;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	public static ArrayList<SalaryStand> getSlaryStand(String salaryStandName) {
		ArrayList<SalaryStand> sss = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from SalaryRegistInfo  where salaryStandName=(?) and reChecked=(?)";
			Query query = session.createQuery(hql);
			query.setString(0, salaryStandName.trim());
			query.setBoolean(1, true);
			SalaryRegistInfo sri = (SalaryRegistInfo) query.uniqueResult();
			if (null != sri) {
				int sriId = sri.getId();
				hql = "select en from SalaryStand en where salaryRegistInfo.id=? ";
				query = session.createQuery(hql);
				query.setInteger(0, sriId);
				sss = (ArrayList<SalaryStand>) query.list();
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
		return sss;
	}

	public static ArrayList<SalaryStand> getAllSalaryStand() {
		ArrayList<SalaryStand> salaryItems = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			String hql = "from SalaryStand";
			Query query = session.createQuery(hql);
			salaryItems = (ArrayList<SalaryStand>) query.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return salaryItems;
	}

	public static boolean updateSalaryStand(int id) {
		SalaryRegistInfo sri = null;
		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			sri = (SalaryRegistInfo) session.get(SalaryRegistInfo.class, id);
			sri.setReChecked(true);
			session.update(sri);
			transaction.commit();
			success = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return success;
	}

	public static ArrayList<SalaryStand> querySalaryStandById(int salaryStandId) {
		ArrayList<SalaryStand> sss = new ArrayList<SalaryStand>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from SalaryStand where salaryRegistInfo=?";
			Query query = session.createQuery(hql);
			query.setInteger(0, salaryStandId);
			sss = (ArrayList<SalaryStand>) query.list();
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
		return sss;
	}

	public static ArrayList<SalaryRegistInfo> getAllSalaryRegistInfo() {
		ArrayList<SalaryRegistInfo> sss = new ArrayList<SalaryRegistInfo>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from SalaryRegistInfo";
			Query query = session.createQuery(hql);
			sss = (ArrayList<SalaryRegistInfo>) query.list();
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
		return sss;
	}

	public static boolean saveBonus(ArrayList<Bonus> bonuss) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			for (int i = 0; i < bonuss.size(); i++) {
				session.save(bonuss.get(i));
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

	public static boolean updateBonus(ArrayList<Bonus> bonuss) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			for (int i = 0; i < bonuss.size(); i++) {
				session.saveOrUpdate(bonuss.get(i));
				System.out.println(bonuss.get(i).isRechecked());
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

	public static ArrayList<SalaryRegistInfo> getUncheckedSlaryRegistInfo() {
		ArrayList<SalaryRegistInfo> sss = new ArrayList<SalaryRegistInfo>();
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from SalaryRegistInfo where reChecked=(?)";
			Query query = session.createQuery(hql);
			query.setBoolean(0, false);
			sss = (ArrayList<SalaryRegistInfo>) query.list();
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
		return sss;
	}

	public static boolean addSalaryStand(ArrayList<SalaryStand> sss) {
		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			for (SalaryStand ss : sss) {
				session.save(ss);
			}
			t.commit();
			success = true;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	public static ArrayList<SalaryStand> getUncheckSlaryStand(
			String salaryStandName) {
		ArrayList<SalaryStand> sss = null;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			String hql = "from SalaryRegistInfo  where salaryStandName=(?) and reChecked=(?)";
			Query query = session.createQuery(hql);
			query.setString(0, salaryStandName.trim());
			query.setBoolean(1, false);
			SalaryRegistInfo sri = (SalaryRegistInfo) query.uniqueResult();
			if (null != sri) {
				int sriId = sri.getId();
				hql = "select en from SalaryStand en where salaryRegistInfo.id=? ";
				query = session.createQuery(hql);
				query.setInteger(0, sriId);
				sss = (ArrayList<SalaryStand>) query.list();
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		}
		return sss;
	}

	public static boolean addSalaryItem(SalaryItem si) {
		boolean success = false;
		Session session = HibernateUtil.getSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.save(si);
			t.commit();
			success = true;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			success = false;
		}
		return success;
	}
}
