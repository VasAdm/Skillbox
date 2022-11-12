public class Hospital {
    private static final float MIN_TEMPERATURE = 36.2f;
    private static final float MAX_TEMPERATURE = 36.9f;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] temperatures =  new float[patientsCount];
        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = 32 + (float) (Math.random() * 8);
        }

        return temperatures;
    }

    public static String getReport(float[] temperatureData) {
        String allTemperatures = "";
        float midTemp = 0f;
        int amountOfHealthy = 0;

        for (float temp : temperatureData) {
            allTemperatures = allTemperatures.concat((float) (Math.round(temp * 10)) / 10 + " ");
            midTemp += temp;
            amountOfHealthy += (temp >= MIN_TEMPERATURE && temp <= MAX_TEMPERATURE) ? 1 : 0;
        }

        midTemp /= temperatureData.length;

        return "Температуры пациентов: " + allTemperatures.trim() +
                "\nСредняя температура: " + (float) Math.round(midTemp * 100) / 100 +
                "\nКоличество здоровых: " + amountOfHealthy;
    }
}
