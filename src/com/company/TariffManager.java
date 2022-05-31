package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class TariffManager {
    private SimpleHashMap<String, Tariff> tariffMap = new SimpleHashMap<>(50);

    public String getCallInfo(String number, int seconds) {
        Tariff tariff = getTariff(number);
        if (tariff == null) {
            return "No such phone code";
        }
        int minutes = secondsToMinutes(seconds);
        return "Call to " + number + " for " + seconds + " seconds (" + minutes + " minutes) to "
                + tariff.getDestination() + " costs " + tariff.getPricePerMinute() * minutes;
    }

    public void editTariff(String prefix, String newDestination) {
        try {
            tariffMap.get(prefix).setDestination(newDestination);
        }
        catch (NullPointerException ignored)
        {}
    }

    public void editTariff(String prefix, int newPrice) {
        try {
            tariffMap.get(prefix).setPricePerMinute(newPrice);
        }
        catch (NullPointerException ignored)
        {}
    }

    public void delete(String prefix) {
        try {
            tariffMap.remove(prefix);
        }
        catch (NullPointerException ignored)
        {}
    }

    public void add(String prefix, String destination, int price) {
        tariffMap.put(prefix, new Tariff(destination, price));
    }

    private Tariff getTariff(String number) {
        Tariff tariff = null;
        for (int n = 0; n < number.length(); n++) {
            String prefix = number.substring(0, n);
            if (tariffMap.get(prefix) != null) {
                tariff = tariffMap.get(prefix);
            }
        }
        return tariff;
    }

    private int secondsToMinutes(int seconds) {
        if (seconds < 6) return 0;
        return (int) Math.ceil(seconds / 60.0);
    }

    public void fromString(String string) {
        Scanner scannerOuter = new Scanner(string);
        scannerOuter.useDelimiter("\\n");
        while (scannerOuter.hasNext()) {
            String[] data = scannerOuter.next().split(",");
            tariffMap.put(data[0], new Tariff(data[1], Integer.parseInt(data[2])));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Tariff> entry : tariffMap.entrySet()) {
            builder.append(entry.getKey()).append(",").append(entry.getValue().getDestination())
                    .append(",").append(entry.getValue().getPricePerMinute()).append("\n");
        }
        return builder.toString();
    }
}
