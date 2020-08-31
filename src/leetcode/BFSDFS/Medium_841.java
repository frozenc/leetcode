package leetcode.BFSDFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode
 * 2020/8/31 10:33
 * 钥匙和房间
 *
 * @author Chan
 * @since
 **/
public class Medium_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[rooms.size()];

        List<Integer> room = rooms.get(0);
        queue.offer(0);

        while(!queue.isEmpty()) {
            int key = queue.poll();
            flag[key] = true;
            room = rooms.get(key);
            while (room.size() > 0) {
                queue.add(room.remove(0));
            }
        }

        for (int i=1; i<flag.length; i++) {
            if (!flag[i]) {
                return false;
            }
        }
        return true;
    }
}
