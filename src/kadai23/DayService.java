package kadai23;

public class DayService extends TimeService {
	private static final int START_TIME = 8;
	private static final int END_TIME = 17;

	// 料金計算のための基礎情報
	private static final String SERVICE_CODE = "E1";
	private static final int BASIC_CHARGE = 200;

	// 昼トク割引対象時間かどうかを判定する
	public boolean isServiceTime(int hour) {
		if (isJoined()) {
			if((hour >= START_TIME) && (hour <= END_TIME)){
				return true;
			}
		}
		return false;
	}

	public String getServiceCode() {
		return SERVICE_CODE;
	}

	public int getDiscount() {
		return 5;
	}

	public int getBasicCharge() {
		return BASIC_CHARGE;
	}

}