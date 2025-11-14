package leetcode;

import java.util.HashMap;

public class FrequencyTracker {

    HashMap<Integer,Integer> hash;
    HashMap<Integer, Integer> freq = new HashMap<>(); // number 的出现次数的出现次数

    public FrequencyTracker() {
        hash=new HashMap<>();
        freq=new HashMap<>();
    }

    public void add(int number) {
        hash.put(number, hash.getOrDefault(number, 0) + 1);   // 增加一个number，对应频数+1
        int f = hash.get(number);
        freq.put(f, freq.getOrDefault(f, 0) + 1);    // 新频数出现的次数+1
        freq.put(f - 1, freq.getOrDefault(f - 1, 0) - 1);    // 旧频数出现的次数-1


    }

    public void deleteOne(int number) {
        if(hash.getOrDefault(number, 0) == 0)
            return;  // 当前number的频数为0，说明number不存在，直接退出
        hash.put(number, hash.get(number) - 1);   // 减少一个number，对应频数-1
        int f = hash.get(number);
        freq.put(f, freq.getOrDefault(f, 0) + 1);    // 新频数出现的次数+1
        freq.put(f + 1, freq.getOrDefault(f + 1, 0) - 1);    // 旧频数出现的次数-1


    }

    public boolean hasFrequency(int frequency) {
        return freq.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */