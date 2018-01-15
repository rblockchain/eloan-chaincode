package com.njzbc.chaincode.eloan.base;

import net.sf.json.JSONObject;

import org.hyperledger.fabric.shim.ChaincodeStub;

import com.rongzer.chaincode.entity.CustomerEntity;
import com.rongzer.chaincode.utils.ChainCodeUtils;
import com.rongzer.chaincode.utils.JSONUtil;

public class LoanEval_XXXX extends BaseLoanEval{

	/**
	 * 设置参数
	 */
	@Override
	public Response setEvalParam(ChaincodeStub stub, String[] args) {
		CustomerEntity customerEntity = ChainCodeUtils.queryExecCustomer(stub);
		//判断用户是否合法
		if (customerEntity == null || customerEntity.getCustomerNo().equals("Bank1")){
			return newErrorResponse("invoke chaincode user is error");
		}
		stub.putState("PARAM1", args[0]);
		if (args[0].length()<1){
			return newErrorResponse("param is empty");
		}
		
		return newSuccessResponse("成功设置参数".getBytes());
	}
	
	/**
	 * 获取参数
	 */
	@Override
	public Response getEvalParam(ChaincodeStub stub, String[] args) {
		CustomerEntity customerEntity = ChainCodeUtils.queryExecCustomer(stub);
		//判断用户是否合法
		if (customerEntity == null || customerEntity.getCustomerNo().equals("Bank1")){
			return newErrorResponse("invoke chaincode user is error");
		}
		
		String param1 = stub.getStringState("PARAM1");
		if (param1 == null){
			param1 = "";
		}

		return newSuccessResponse(param1.getBytes());
	}
	
	/**
	 * 按揭评估，返回按揭评估的结果
	 */
	@Override
	public Response evalLoan(ChaincodeStub stub, String[] args) {
		JSONObject jData = JSONUtil.getJSONObjectFromStr(args[0]);
		if (jData == null){
			return newErrorResponse("estimateMortgage param parse json error");
		}
		
		JSONObject jReturn = new JSONObject();
		jReturn.put("acceptOrNot", "1");
		
		return newSuccessResponse(jReturn.toString().getBytes());
	}

	@Override
	public Response setBankOffice(ChaincodeStub stub, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delBankOffice(ChaincodeStub stub, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getBankOfficeList(ChaincodeStub stub, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 合约启动的main方法
	 * @param args
	 */
	public static void main(String[] args) {
		//注意此类名与自身一致
		new LoanEval_XXXX().start(args);
	}


}
