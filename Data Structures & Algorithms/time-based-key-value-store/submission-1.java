class TimeMap {
    private HashMap<String,List<Entry>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Entry> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<Entry> list, int timestamp) {
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            }
            else if(list.get(mid).timestamp < timestamp)
            {
                left =  mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return right < 0 ? "" : list.get(right).value;
    }

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
