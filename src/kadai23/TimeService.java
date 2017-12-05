package kadai23;

abstract class TimeService implements Service {

	private boolean joined = false;

	public void clear() {
		joined = false;
	}

	public void joined() {
		joined = true;
	}

	public boolean isJoined() {
		return joined;
	}

	public void checkService(Record record) {
		if (getServiceCode().equals(record.getServiceCode())) {
			joined();
		}
	}

	public abstract String getServiceCode();
	public abstract boolean isServiceTime(int hour);
	public abstract int getBasicCharge();


	public int calcUnitPrice(Record record, int unitPrice) {
		int hour = record.getStartHour();
		if (isServiceTime(hour)) {
			unitPrice -= getDiscount();
		}
		return unitPrice;
	}

	public abstract int getDiscount();


	public int calcBasicCharge(int basicCharge) {
		if (isJoined()) {
			basicCharge += getBasicCharge();
		}
		return basicCharge;
	}



}