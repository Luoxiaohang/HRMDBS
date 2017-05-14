package com.hrmdbs.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.hrmdbs.dao.SalaryDao;
import com.hrmdbs.salary.bean.Bonus;
import com.hrmdbs.salary.bean.SalaryItem;
import com.hrmdbs.salary.bean.SalaryRegistInfo;
import com.hrmdbs.salary.bean.SalaryStand;
import com.hrmdbs.salary.bean.SalaryStandQueryBean;

public class SalaryService {

	public static ArrayList<SalaryItem> getAllSalaryItem() {
		return SalaryDao.getAllSalaryItem();
	}

	public static boolean addSalaryStand(SalaryStand sri) {
		return SalaryDao.addSalaryStand(sri);
	}

	public static ArrayList<SalaryStand> getSlaryStand(String salaryStandName) {
		return SalaryDao.getSlaryStand(salaryStandName);
	}

	public static ArrayList<SalaryStand> getAllSalaryStand() {
		// TODO Auto-generated method stub
		return SalaryDao.getAllSalaryStand();
	}

	public static boolean updateSalaryStand(ArrayList<SalaryStand> salaryStand) {
		// TODO Auto-generated method stub
		boolean success = false;
		try {
			SalaryDao.updateSalaryStand(salaryStand.get(0)
					.getSalaryRegistInfo().getId());
			success = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	public static HashMap<Integer, ArrayList<SalaryStand>> querySalaryStand(
			SalaryStandQueryBean ssqb) {
		HashMap<Integer, ArrayList<SalaryStand>> sss = null;
		// 先获取Id根据Id查询
		if (ssqb.getSalaryStandId() != -1) {
			sss = new HashMap<Integer, ArrayList<SalaryStand>>();
			sss.put(ssqb.getSalaryStandId(),
					SalaryDao.querySalaryStandById(ssqb.getSalaryStandId()));
		}
		if (null == sss) {
			return null;
		} else
			return sss;
	}

	public static HashMap<String, SalaryRegistInfo> getAllSalaryRegistInfo() {
		HashMap<String, SalaryRegistInfo> sss = new HashMap<String, SalaryRegistInfo>();
		ArrayList<SalaryRegistInfo> sris = SalaryDao.getAllSalaryRegistInfo();
		// 先获取Id根据Id查询
		for (SalaryRegistInfo sri : sris) {
			sss.put(sri.getSalaryStandName(), sri);
		}
		return sss;
	}

	public static boolean saveBonus(ArrayList<Bonus> bonuss) {
		// TODO Auto-generated method stub
		return SalaryDao.saveBonus(bonuss);
	}

	public static boolean updateBonus(ArrayList<Bonus> bonuss) {
		return SalaryDao.updateBonus(bonuss);
	}

	public static HashMap<SalaryRegistInfo, ArrayList<SalaryStand>> getUncheckedSlaryRegistInfo() {
		HashMap<SalaryRegistInfo, ArrayList<SalaryStand>> sss = new HashMap<SalaryRegistInfo, ArrayList<SalaryStand>>();
		ArrayList<SalaryRegistInfo> sris = SalaryDao
				.getUncheckedSlaryRegistInfo();
		// 先获取Id根据Id查询
		for (SalaryRegistInfo sri : sris) {
			sss.put(sri, getUncheckSlaryStand(sri.getSalaryStandName()));
		}
		return sss;
	}

	private static ArrayList<SalaryStand> getUncheckSlaryStand(
			String salaryStandName) {
		return SalaryDao.getUncheckSlaryStand(salaryStandName);
	}

	public static boolean addSalaryStand(ArrayList<SalaryStand> sss) {

		return SalaryDao.addSalaryStand(sss);
	}

	public static boolean addSalaryItem(SalaryItem si) {
		// TODO Auto-generated method stub
		return SalaryDao.addSalaryItem(si);
	}
}
