package com.cucumber.pojo;

public class ContractAddress{
    private String contract_address;
    private Platform platform;
	public String getContract_address() {
		return contract_address;
	}
	public void setContract_address(String contract_address) {
		this.contract_address = contract_address;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
