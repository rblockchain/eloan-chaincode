工程开发说明
1、此工程是银行开发智能合约的基础工程，工程依赖于JDK1.8
2、银行继承MortgageChaincode类，实现setMortgageParam、getMortgageParam、estimateMortgage三个方法
3、具体示例参照Bank1Chaincode.java这个示例

智能合约打包说明：
1、TarChainCode是智能合约源码打包工具，输出文件格式是tar.gz
2、请修改TarChainCode中的文件路径
3、输出的tar.gz包，调用区块链合约发布接口进行发布

相关工具类的主明
ChainCodeUtils类
1、获取当前操作用户
CustomerEntity queryExecCustomer(ChaincodeStub stub)
返回参数中customerEntity.CustomerNo是当前操作的会员号
2、 String getTxTime(ChaincodeStub stub)
返回当前交易的时间字符串，时间格式yyyy-MM-dd HH:mm:ss

JSONUtil类
1、字符串转json
JSONObject getJSONObjectFromStr(String jsonStr)
如果字符串解错误，返回null

2、字符串转JSONArray
JSONArray getJSONArrayFromStr(String jsonStr)
如果字符串解错误，返回null
