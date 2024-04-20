package workingdayscalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class WorkingDaysCalculator {
    public static void main(String[] args) {
        // Input dates
        String date1 = "01-04-2024";
        String date2 = "30-04-2024";
        
        // Convert input strings to LocalDate objects
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(date1, formatter);
        LocalDate endDate = LocalDate.parse(date2, formatter);
        
        // Set of government holidays
        Set<LocalDate> govtHolidays = new HashSet<>();
        // Add government holidays here
        
        // Weekly holidays (Saturday and Sunday)
        Set<DayOfWeek> weeklyHolidays = new HashSet<>();
        weeklyHolidays.add(DayOfWeek.SATURDAY);
        weeklyHolidays.add(DayOfWeek.FRIDAY); // Considering Friday as weekly holiday
        
        // Calculate working days
        int workingDays = 0;
        LocalDate tempDate = startDate;
        while (!tempDate.isAfter(endDate)) {
            if (!govtHolidays.contains(tempDate) && !weeklyHolidays.contains(tempDate.getDayOfWeek())) {
                workingDays++;
            }
            tempDate = tempDate.plusDays(1);
        }
        
        // Output
        System.out.println("Total " + workingDays + " working days in this period.");
    }
}
