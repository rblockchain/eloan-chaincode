���̿���˵��
1���˹��������п������ܺ�Լ�Ļ������̣�����������JDK1.8
2�����м̳�MortgageChaincode�࣬ʵ��setMortgageParam��getMortgageParam��estimateMortgage��������
3������ʾ������Bank1Chaincode.java���ʾ��

���ܺ�Լ���˵����
1��TarChainCode�����ܺ�ԼԴ�������ߣ�����ļ���ʽ��tar.gz
2�����޸�TarChainCode�е��ļ�·��
3�������tar.gz����������������Լ�����ӿڽ��з���

��ع����������
ChainCodeUtils��
1����ȡ��ǰ�����û�
CustomerEntity queryExecCustomer(ChaincodeStub stub)
���ز�����customerEntity.CustomerNo�ǵ�ǰ�����Ļ�Ա��
2�� String getTxTime(ChaincodeStub stub)
���ص�ǰ���׵�ʱ���ַ�����ʱ���ʽyyyy-MM-dd HH:mm:ss

JSONUtil��
1���ַ���תjson
JSONObject getJSONObjectFromStr(String jsonStr)
����ַ�������󣬷���null

2���ַ���תJSONArray
JSONArray getJSONArrayFromStr(String jsonStr)
����ַ�������󣬷���null
