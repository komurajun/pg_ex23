package kadai23;

public class FamilyService implements Service{

	private boolean joined = false;
	int TEL_NUMBER = 2;
	String SERVICE_CODE = "C1";
	int BASIC_CHARGE = 100;
	String[] telNumbers = new String[TEL_NUMBER];
	int telNumberCount = 0;

	// サービスに加入しているかをチェック
	public void checkService(Record record) {
		if (record.getServiceCode().equals(SERVICE_CODE)) {
			joined = true;
			appendFamilyTelNumber(record.getServiceOption());
		}

	}

	public int calcBasicCharge(int initialBasicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を100円増し
			return initialBasicCharge + BASIC_CHARGE;
		}
		return initialBasicCharge;
	}

	// 単価を計算する
	public int calcUnitPrice(Record record, int initialCallUnitPrice) {

		if (!isJoined()) {
			// サービスに加入していなければ値引きなし
			return initialCallUnitPrice;
		}

		//登録されている番号か判断
		if(isFamilyTelNumber(record.getCallNumber())){
			return initialCallUnitPrice/2;
		}
		return initialCallUnitPrice;
	}

	public void clear() {
		joined = false;
		telNumberCount = 0;
	}

	public void joind() {
		joined = true;
	}

	public boolean isJoined() {
		return joined;
	}

	public String getServiceCord() {
		return SERVICE_CODE;
	}

	public int getDiscount() {
		return 5;
	}

	public void appendFamilyTelNumber(String record){
		telNumbers[telNumberCount] = record;
		//System.out.println(telNumbers[telNumberCount]);
		telNumberCount++;

	}

	public boolean isFamilyTelNumber(String telNumber) {
		for(int i=0;i<telNumberCount;i++){
			System.out.println(telNumbers[i]);
			if(telNumber.equals(telNumbers[i])){
				return true;
			}
		}
		return false;
	}

}
