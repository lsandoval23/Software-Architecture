package service.fine;

public class StudentFineCalculator implements FineCalculator{
    @Override
    public double calculate(long delayDays) {
        return delayDays * 5;
    }
}
