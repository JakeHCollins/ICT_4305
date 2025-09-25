package main;

public class MyDate {
    private int julianNumber;
    
    /* Defaults to zero-epoch date if not provided a date */
    public MyDate() {
        this.julianNumber = toJulianNumber(1, 1, 1970);
    }

    public MyDate(MyDate date) {
        this.julianNumber = date.julianNumber;
    }
    
    /* Creates a new MyDate from a day, month, and year */
    public MyDate(int day, int month, int year) {
        this.julianNumber = toJulianNumber(day, month, year);
    }
    
    /* Returns the day of the month for this MyDate */
    public int getDay() {
        int[] date = fromJulianNumber();
        return date[0];
    }
    
    /* Returns the month of the year for this MyDate */
    public int getMonth() {
        int[] date = fromJulianNumber();
        return date[1];
    }
    
    /* Returns the year for this MyDate */
    public int getYear() {
        int[] date = fromJulianNumber();
        return date[2];
    }
    
    /* Returns true if this MyDate represents a date in a leap year */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
    
    /* Returns the last day of the specified month and year */
    public static int getLastDayOfMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 1; // Needs error, not 1.
        }
    }

    /**
     * Converts gregorian 3-value (day/month/year) date to julian.
     * 
     * @param day   The day of the month (1-31)
     * @param month The month of the year (1-12)  
     * @param year  The year
     * @return Julian date as an integer
     * @see <a href="https://aa.usno.navy.mil/faq/JD_formula">USNO Julian Date Formula</a>
     */
    private static int toJulianNumber(int day, int month, int year) {
        int jd = day - 32075 + 1461 * (year + 4800 + (month - 14) / 12) / 4 +
                 367 * (month - 2 - (month - 14) / 12 * 12) / 12 -
                 3 * ((year + 4900 + (month - 14) / 12) / 100) / 4;
        return jd;
    }

    /**
     * Utilizes the class' julian number to convert to gregorian date.
     * 
     * @return int array containing {day, month, year} in that order
     * @see <a href="https://aa.usno.navy.mil/faq/JD_formula">USNO Julian Date Formula</a>
     */
    private int[] fromJulianNumber() {
        int JD = this.julianNumber;
        int L = JD + 68569;
        int N = 4 * L / 146097;
        L = L - (146097 * N + 3) / 4;
        int I = 4000 * (L + 1) / 1461001;
        L = L - 1461 * I / 4 + 31;
        int J = 80 * L / 2447;
        int K = L - 2447 * J / 80;
        L = J / 11;
        J = J + 2 - 12 * L;
        I = 100 * (N - 49) + I + L;
        return new int[]{K, J, I};
    }
}
