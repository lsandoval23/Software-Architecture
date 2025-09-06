package service.fine;

public class StandardFineCalculator implements FineCalculator {

    @Override
    public double calculate(long delayDays) {
        return delayDays * 10;
    }
}
