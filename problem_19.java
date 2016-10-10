/* You are given the following information, but you may prefer to do some
research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century
        unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century
(1 Jan 1901 to 31 Dec 2000)?
*/

public class problem_19 {
  public static void main(String args[]) {
    int year = 1901, month = 1, day = 3;
    int noOfSundays = 0;

    for(int i = year; i < 2001; i++) {
      for(int j = month; j < 13; j++) {
        day = ((getNoOfDays(i, j)%7)+day)%7;
        if(day == 0)  noOfSundays++;
      }
    }

    System.out.println(
    "The number of Sundays falling on the first of the month during the 20th century is: "
          +noOfSundays);
  }

  //Algorithm to check if the current year is a leap year:
  private static boolean isLeapYear(int year) {
    if (year % 4 != 0) { return false; }
      else if (year % 100 != 0) { return true;  }
        else if (year % 400 != 0) { return false; }
          else {  return true;  }
  }

  private static int getNoOfDays(int year, int month) {
    if(month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }
    else if(month == 2) {
      return (isLeapYear(year)? 29:28);
    }
    else {
      return 31;
    }
  }
}
