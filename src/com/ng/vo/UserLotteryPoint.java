package com.ng.vo;

public class UserLotteryPoint {
	
	//�û�ID
	String userId = "";
	
	//�û�Name
	String userName = "";
	
	//�û�����
	String userPoint = "";
	
	//�û�������ID
	String prizeGroupId = "";
	
	//����ID
	String lotteryId = "";
	
	//���㽱��
	String premium = "";
	
	//��׼����
	String basePremium = "";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(String userPoint) {
		this.userPoint = userPoint;
	}

	public String getPrizeGroupId() {
		return prizeGroupId;
	}

	public void setPrizeGroupId(String prizeGroupId) {
		this.prizeGroupId = prizeGroupId;
	}

	public String getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(String basePremium) {
		this.basePremium = basePremium;
	}
	
}
