package kadai23;

public class DayService {

	private boolean joined = false;
	int START_TIME = 8;
	int END_TIME = 17;
	String SERVICE_CODE = "E1";
	int BASIC_CHARGE = 200;

	// サービスに加入しているかをチェック
	public void checkService(Record record) {
		if (record.getServiceCode().equals(SERVICE_CODE)) {
			joined = true;
		}
	}

	public int calcBasicCharge(int initialBasicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を200円増し
			return initialBasicCharge + getBasicCharge();
		}
		return initialBasicCharge;
	}

	// 単価を計算する
	public int calcUnitPrice(Record record, int initialCallUnitPrice) {

		if (!isJoind()) {
			// サービスに加入していなければ値引きなし
			return initialCallUnitPrice;
		}

		if (isServiceTime(record.getStartHour())) {
			// 通話開始時間がサービス対象時間ならば5円引き
			return initialCallUnitPrice - getDiscount();
		}

		return initialCallUnitPrice;
	}

	public void clear() {
		joined = false;
	}

	public void joind() {
		joined = true;
	}

	public boolean isJoind() {
		return joined;
	}

	public boolean isServiceTime(int hour) {
		if (START_TIME <= hour && hour <= END_TIME){
			return true;
		}
			return false;
	}

	public String getServiceCord() {
		return SERVICE_CODE;
	}

	public int getDiscount() {
		return 5;
	}

	public int getBasicCharge() {
		return BASIC_CHARGE;
	}

}