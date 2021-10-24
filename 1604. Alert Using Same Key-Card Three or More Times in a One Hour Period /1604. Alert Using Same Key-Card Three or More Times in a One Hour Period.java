class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> alerts = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<String> vals;
            if (map.containsKey(keyName[i])) {
                vals = map.get(keyName[i]);
            } else {
                vals = new ArrayList<>();
            }
            vals.add(keyTime[i]);
            Collections.sort(vals);
            map.put(keyName[i], vals);
        }
        for (String key : map.keySet()) {
            List<String> vals = map.get(key);
            if (vals.size() > 2) {
                for (int i = 0; i < vals.size() - 2; i++) {
                    if (timeDiffGreaterThanAnHour(vals.get(i), vals.get(i + 1)) && timeDiffGreaterThanAnHour(vals.get(i), vals.get(i + 2))) {
                        alerts.add(key);
                    }
                }
            }
        }
        List<String> results = new ArrayList<String>(alerts);
        Collections.sort(results);
        return results;

    }

    private boolean timeDiffGreaterThanAnHour(String prev, String latest) {
        Time prevT = getTimeFromStr(prev);
        Time latestT = getTimeFromStr(latest);
        int diff = timeDiff(prevT, latestT);
        return diff <= 60 && diff >= 0;
    }

    private Time getTimeFromStr(String t) {
        String[] values = t.split(":");
        return new Time(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
    }

    private int timeDiff(Time t1, Time t2) {
        int hDiff = t2.hours - t1.hours;
        int mDiff = t2.mins - t1.mins;
        return hDiff * 60 + mDiff;
    }

    class Time {
        private int hours;
        private int mins;

        public Time(int h, int m) {
            hours = h;
            mins = m;
        }
    }
}