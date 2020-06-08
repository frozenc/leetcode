package leetcode.Array;
import java.util.*;

//字符串接龙
public class Hard_132 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        //如果词典中不含该单词，直接返回空
        if (!wordList.contains(endWord)) {
            return res;
        }
        bfs(beginWord, endWord, wordList, res);
        return res;
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> res) {
        Queue<List<String>> queue = new LinkedList<>();
        //搜索路径
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        //词典，去除重复
        HashSet<String> dict = new HashSet<>(wordList);
        //已经访问过的单词
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashSet<String> subVisited = new HashSet<>();
            //搜索队列中的每一条路径
            for (int i=0; i<size; i++) {
                List<String> p = queue.poll();
                String tail = p.get(p.size() - 1);
                ArrayList<String> neighbours = getNetghbours(tail, dict);
                //搜索每一个邻近节点
                for (String neighbour:neighbours) {
                    //只访问没访问过的
                    if (!visited.contains(neighbour)) {
                        if (neighbour.equals(endWord)) {
                            isFound = true;
                            p.add(neighbour);
                            res.add(new ArrayList<>(p));
                            p.remove(p.size() - 1);
                        }
                        p.add(neighbour);
                        queue.offer(new ArrayList<>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(neighbour);
                    }
                }
            }
            visited.addAll(subVisited);
            //bfs搜索，只要一找到，剩下的路径都会比现在长，直接break退出
            if(isFound) {
                break;
            }
        }
    }

    //找到所有的邻近节点
    public ArrayList<String> getNetghbours(String tail, HashSet<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = tail.toCharArray();
        for (char c = 'a'; c<='z'; c++) {
            for (int i=0; i<chs.length; i++) {
                if (chs[i] == c) {
                    continue;
                }
                char old_c = chs[i];
                chs[i] = c;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_c;
            }
        }
        return res;
    }
}
