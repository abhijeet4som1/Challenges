package com.challenges.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberOfGlass {

    /* arrival map */
    private Map<Date, Integer> arr;
    /* departure map */
    private Map<Date, Integer> dep;

    public NumberOfGlass() {
        arr = new HashMap<>();
        dep = new HashMap<>();
    }

    public void addArrTiming(Date inTime) {
        if (dep.containsKey(inTime)) {
            Integer value = dep.get(inTime);
            if (-1 == value) {
                dep.remove(inTime);
            } else {
                dep.put(inTime, --value);
            }
        } else {
            Integer value = arr.get(inTime);
            arr.put(inTime, null == value ? 1 : value + 1);
        }
    }

    public void addDepTiming(Date outTime) {
        if (arr.containsKey(outTime)) {
            Integer value = arr.get(outTime);
            if (1 == value) {
                arr.remove(outTime);
            } else {
                arr.put(outTime, --value);
            }
        } else {
            Integer value = dep.get(outTime);
            dep.put(outTime, null == value ? -1 : --value);
        }
    }

    public int getNumberOfGlass() {
        int glassNeeded = 0, currMax = 0;
        // sorting maps
        Iterator<Entry<Date, Integer>> arrEnt = new TreeMap<>(arr).entrySet().iterator();
        Entry<Date, Integer> arrent = arrEnt.next();
        dep = new TreeMap<>(dep);
        // getting number of glasses
        for (Entry<Date, Integer> depEntry : dep.entrySet()) {
            while (arrent.getKey().before(depEntry.getKey())) {
                currMax += arrent.getValue();
                if (currMax > glassNeeded)
                    glassNeeded = currMax;
                if (arrEnt.hasNext())
                    arrent = arrEnt.next();
                else
                    return glassNeeded;
            }
            currMax += depEntry.getValue();
        }
        return glassNeeded;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // get number of entry
        int entry = in.nextInt();
        if (entry > 0) {
            in.nextLine();
            NumberOfGlass t = new NumberOfGlass();
            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
            try {
                while (entry > 0) {
                    String[] timespan = in.nextLine().split("#");
                    // adding timing
                    t.addArrTiming(sf.parse(timespan[0]));
                    t.addDepTiming(sf.parse(timespan[1]));
                    entry--;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
            System.out.println(t.getNumberOfGlass());
        } else {
            System.out.println(0);
        }
    }
}
