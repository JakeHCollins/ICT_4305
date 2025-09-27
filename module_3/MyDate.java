
public class MyDate {

    private int julianNumber;

    public MyDate() {
        this.julianNumber = toJulianNumber(1, 1, 1970);
    }

    /* Creates a new MyDate from an existing MyDate */
    public MyDate(MyDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        this.julianNumber = date.julianNumber;
    }

    /**
     * Creates a new MyDate with day, month, year, validating input.
     */
    public MyDate(int day, int month, int year) {
        validateDate(day, month, year);
        this.julianNumber = toJulianNumber(day, month, year);
    }

    /**
     * Returns the day of month for this date.
     */
    public int getDay() {
        int[] date = fromJulianNumber();
        return date[0];
    }

    /**
     * Returns the month for this date.
     */
    public int getMonth() {
        int[] date = fromJulianNumber();
        return date[1];
    }

    /**
     * Returns the year for this date.
     */
    public int getYear() {
        int[] date = fromJulianNumber();
        return date[2];
    }

    /**
     * Returns true if this MyDate represents a date in a leap year 
     */
    public static boolean isLeapYear(int year) {
        //Input validation for year
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year for leap check: " + year + ". Use 1 to 9999.");
        }

        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Returns last valid day for a given month/year, or throws if month
     * invalid.
     */
    public static int getLastDayOfMonth(int month, int year) {
        //Input validaion for year
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year: " + year + ". Year must be 1 to 9999");
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month: " + month + ". Must be 1 to 12.");
        }
    }

    /**
     * Converts gregorian 3-value (day/month/year) date to julian.
     *
     * @param day The day of the month (1-31)
     * @param month The month of the year (1-12)
     * @param year The year
     * @return Julian date as an integer
     */
    private static int toJulianNumber(int day, int month, int year) {
        int jd = ((1461 * (year + 4800 + (month - 14) / 12)) / 4)
                + ((367 * (month - 2 - 12 * ((month - 14) / 12))) / 12)
                - ((3 * ((year + 4900 + (month - 14) / 12) / 100)) / 4)
                + day - 32075;

        return jd;
    }

    /**
     * Converts this object's julianNumber to [day, month, year].
     */
    private int[] fromJulianNumber() {
        // Julian Day Number to convert
        int jd = this.julianNumber;

        int l = jd + 68569;
        int n = 4 * l / 146097;
        l = l - (146097 * n + 3) / 4;
        int i = (4000 * (l + 1)) / 1461001;
        l = l - (1461 * i) / 4 + 31;
        int j = (80 * l) / 2447;
        int day = l - (2447 * j) / 80;
        l = j / 11;
        int month = j + 2 - (12 * l);
        int year = 100 * (n - 49) + i + l;

        return new int[]{day, month, year};
    }

    /**
     * Validates day, month, and year
     */
    private static void validateDate(int day, int month, int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Year out of range: " + year);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month out of range: " + month);
        }
        int lastDay = getLastDayOfMonth(month, year);
        if (day < 1 || day > lastDay) {
            throw new IllegalArgumentException("Day out of range: " + day
                    + " for month " + month + " in year " + year);
        }
    }
}
