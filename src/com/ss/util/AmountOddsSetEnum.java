package com.ss.util;

public enum AmountOddsSetEnum {
	AOS_MINA("minAmount", 2),
	AOS_MAXA("maxAmount", 99),
	AOS_AS1("amountSeparate1", 29),
	AOS_AS2("amountSeparate2", 59),
	AOS_OP1("oddsPercents1", 85),
	AOS_OP2("oddsPercents2", 10),
	AOS_OP3("oddsPercents3", 5),
    AOS_TA("totalAmount", 100000);
	
	private String en;
    private Integer cn;
    AmountOddsSetEnum(String en, Integer cn) {
        this.en = en;
        this.cn = cn;
    }

    public String en() {
        return this.en;
    }

    public Integer cn() {
        return this.cn;
    }

    public static Integer getCn(String name) {
        for (AmountOddsSetEnum item : AmountOddsSetEnum.values()) {
            if (item.name().equals(name)) {
                return item.cn;
            }
        }
        return null;
    }

    public static String getEn(String name) {
        for (AmountOddsSetEnum item : AmountOddsSetEnum.values()) {
            if (item.name().equals(name)) {
                return item.en;
            }
        }
        return name;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
