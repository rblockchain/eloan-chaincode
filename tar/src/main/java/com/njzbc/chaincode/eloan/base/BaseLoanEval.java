package com.njzbc.chaincode.eloan.base;

import org.hyperledger.fabric.shim.ChaincodeStub;

import com.rongzer.chaincode.base.RBCChaincodeBase;

public abstract class BaseLoanEval extends RBCChaincodeBase{
	
	/**
	 * 按揭贷款合约执行的入口方法
	 */
	@Override
	public Response run(ChaincodeStub stub, String function, String[] args) {

		switch (function) {
			case "init":
				return newSuccessResponse("init success");
			case "setEvalParam":			
				if (args.length<1){
					return newErrorResponse(String.format("%s args length <1",function));
				}
				return setEvalParam(stub, args);
			case "setBankOffice":			
				if (args.length<1){
					return newErrorResponse(String.format("%s args length <1",function));
				}
				return setBankOffice(stub, args);
			case "delBankOffice":			
				if (args.length<1){
					return newErrorResponse(String.format("%s args length <1",function));
				}
				return delBankOffice(stub, args);				
			case "evalLoan":
				if (args.length<1){
					return newErrorResponse("evalLoan args length <1");
				}
				return evalLoan(stub, args);
		}
		return newErrorResponse(String.format("function %s is not found",function));

	}
	
	/**
	 * 按揭贷款合约查询的入口方法
	 */	
	@Override
	public Response query(ChaincodeStub stub, String function, String[] args){
		switch (function) {

			case "getEvalParam":
				if (args.length<1){
					return newErrorResponse(String.format("%s args length <1",function));
				}				
				return getEvalParam(stub, args);
			case "getBankOfficeList":
				if (args.length<1){
					return newErrorResponse(String.format("%s args length <1",function));
				}				
				return getBankOfficeList(stub, args);


		}	
		
		return newErrorResponse(String.format("function %s is not found",function));
	}


	@Override
	public String getChaincodeID() {
		return this.getId();
	}
	
	
	/**
	 * 设置按揭贷款的参数
	 * @param stub
	 * @param args
	 * @return
	 */
	public abstract Response setEvalParam(ChaincodeStub stub, String[] args);
	
	/**
	 * 获取按揭贷款的参数
	 * @param stub
	 * @param args
	 * @return
	 */
	public abstract Response getEvalParam(ChaincodeStub stub, String[] args);

	/**
	 * 设置网点
	 * @param stub
	 * @param args
	 * @return
	 */
	public abstract Response setBankOffice(ChaincodeStub stub, String[] args);
	
	/**
	 * 删除网点
	 * @param stub
	 * @param args
	 * @return
	 */
	public abstract Response delBankOffice(ChaincodeStub stub, String[] args);
	
	/**
	 * 删除网点
	 * @param stub
	 * @param args
	 * @return
	 */
	public abstract Response getBankOfficeList(ChaincodeStub stub, String[] args);
	
	/**
	 * 预评估执行
	 * @param stub
	 * @param args
	 * @return
	 */
	public abstract Response evalLoan(ChaincodeStub stub, String[] args);

}
