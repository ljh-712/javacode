package ORM;
public class Salary {
	private String empId;
	private String empName;
	private int basic;
	private int reward;
	private int deduction;
	private int allowance;
	private int yfSalary;
	private int sfSalary;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getYfSalary() {
		return yfSalary;
	}
	public void setYfSalary(int yfSalary) {
		this.yfSalary = yfSalary;
	}
	public int getSfSalary() {
		return sfSalary;
	}
	public void setSfSalary(int sfSalary) {
		this.sfSalary = sfSalary;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public int getDeduction() {
		return deduction;
	}
	public void setDeduction(int deduction) {
		this.deduction = deduction;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
}
