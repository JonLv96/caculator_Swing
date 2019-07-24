package service.serviceImpl;

import service.AnalysisService;

public class AnalysisServiceImpl implements AnalysisService{
	/**
	 * 
	 * @param str  ÊäÈë¿òÖ»ÄÜ
	 * @return
	 */
	public String analysis(String str) {
		if (str.contains("+")) {
			String[] num = str.toString().split("[+]");
			System.out.println(num[0]+"+"+num[1]);
			Double out = Double.parseDouble(num[0]) + Double.parseDouble(num[1]);
			return (out).toString();
		}
		if (str.contains("-")) {
			String[] num = str.toString().split("[-]");
			Double out = Double.parseDouble(num[0]) - Double.parseDouble(num[1]);
			return (out).toString();
		}
		if (str.contains("*")) {
			String[] num = str.toString().split("[*]");
			Double out = Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
			return (out).toString();
		}
		if (str.contains("/")) {
			String[] num = str.toString().split("[/]");
			Double out = Double.parseDouble(num[0]) / Double.parseDouble(num[1]);
			return (out).toString();
		}
		return null;
	}
}
