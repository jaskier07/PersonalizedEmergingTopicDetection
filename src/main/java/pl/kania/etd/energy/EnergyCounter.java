package pl.kania.etd.energy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.kania.etd.periods.TimePeriod;
import pl.kania.etd.periods.TimePeriods;

import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnergyCounter {

    public static void count(int currentPeriodIndex, int previousSlotsToConsider) {
        List<TimePeriod> periods = TimePeriods.getInstance().getAllPeriods();
        TimePeriod currentPeriod = periods.get(currentPeriodIndex);

        Set<String> words = currentPeriod.getWordStatistics().keySet();
        words.forEach(word -> {
            double wordEnergy = 0.;
            double currentNutrition = currentPeriod.getWordStatistics().get(word).getNutrition();

            for (int periodIndex = currentPeriodIndex - 1; periodIndex >= currentPeriodIndex - previousSlotsToConsider; periodIndex--) {
                TimePeriod period = periods.get(periodIndex);
                double nutrition = period.getWordStatistics().get(word).getNutrition();
                wordEnergy += (Math.pow(currentNutrition, 2) - Math.pow(nutrition, 2)) / (currentPeriodIndex - periodIndex);
            }

            currentPeriod.getWordStatistics().get(word).setEnergy(wordEnergy);
        });
    }

}