package leetcode.BFSDFS;

import java.util.*;

/**
 * leetcode
 * 2020/8/28 15:36
 * 重新安排机票行程
 *
 * @author Chan
 * @since
 **/
public class Medium_332 {
    Map<String, List<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> temp = null;
        for(List<String> ticket:tickets) {
            temp = map.getOrDefault(ticket.get(0), new ArrayList<String>());
            temp.add(ticket.get(1));
            map.put(ticket.get(0), temp);
        }

        for (List<String> list:map.values()) {
            list.sort(String::compareTo);
        }

        dfs("JFK");
        return res;
    }

    public void dfs(String start) {
        List<String> dest = map.get(start);
        while(dest != null && dest.size() != 0) {
            String next = dest.get(0);
            dest.remove(0);
            dfs(next);
        }
        res.add(0, start);
    }
}
