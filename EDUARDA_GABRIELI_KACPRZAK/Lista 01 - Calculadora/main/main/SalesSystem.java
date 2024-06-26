package main;

import java.util.HashMap;
import java.util.Map;

class SalesSystem {
    private Map<String, Map<Integer, Double>> sales;

    public SalesSystem(){
        sales = new HashMap<>();
    }

    public void AddSales(String month, int day, double value) {
        sales.putIfAbsent(month, new HashMap<>());
        sales.get(month).put(day, value);
    }

    public double getTotalMonthSales(String month){
        if(sales.containsKey(month)) {
            double total = 0;
            for (double value : sales.get(month).values()) {
                total += value;
            }
            return total;
        } else {
            return 0;
        }
    }

    public double getTotalDaySales(String month, int day) {
        if (sales.containsKey(month) && sales.get(month).containsKey(day)) {
            return sales.get(month).get(day);
        } else {
            return 0;
        }
    }
} 