package com.njzbc.chaincode.tools;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class TarChainCode {

	public static void main(String[] args) {
		//String filePath = "C:/GOPATH/fsj/fabric-sdk-java/src/test/fixture/sdkintegration/javacc/";
		//请设置到此工任的tar路径
		String filePath = "D:/eloan.BankChaincode/tar";
		String chainCodeName = "Bank1Chaincode";
		
		File chainFile = new File(filePath+chainCodeName);
		try {
			byte[] data = Utils.generateTarGz(chainFile, "src");
			File writeFile = new File(filePath+chainCodeName+".tar.gz");
	        if (writeFile.exists())
	        {
	        	writeFile.delete();
	        }
	        FileOutputStream out = new FileOutputStream(writeFile);
	        out.write(data);
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}

}
