import java.util.*;

class TaskManager {
    private static class Task {
        int priority;
        int taskId;
        int userId;
        Task(int priority, int taskId, int userId) {
            this.priority = priority;
            this.taskId = taskId;
            this.userId = userId;
        }
    }

    // Max-heap: priority desc, then taskId desc
    private PriorityQueue<Task> maxHeap;
    // taskId -> [userId, priority]
    private Map<Integer, int[]> taskInfo;

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        taskInfo = new HashMap<>();

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            maxHeap.offer(new Task(priority, taskId, userId));
            taskInfo.put(taskId, new int[]{userId, priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        // taskId guaranteed not present currently
        maxHeap.offer(new Task(priority, taskId, userId));
        taskInfo.put(taskId, new int[]{userId, priority});
    }

    public void edit(int taskId, int newPriority) {
        if (!taskInfo.containsKey(taskId)) return;
        int userId = taskInfo.get(taskId)[0];
        taskInfo.put(taskId, new int[]{userId, newPriority});
        maxHeap.offer(new Task(newPriority, taskId, userId)); // lazy update
    }

    public void rmv(int taskId) {
        taskInfo.remove(taskId); // lazy deletion (heap entries remain)
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.peek();
            int tid = top.taskId;
            if (!taskInfo.containsKey(tid)) {
                // fully removed, discard
                maxHeap.poll();
                continue;
            }
            int[] cur = taskInfo.get(tid);
            int curUser = cur[0], curPriority = cur[1];
            // Validate both userId AND priority match current mapping
            if (curUser != top.userId || curPriority != top.priority) {
                maxHeap.poll(); // outdated entry
                continue;
            }
            // valid top
            maxHeap.poll();
            taskInfo.remove(tid);
            return top.userId;
        }
        return -1;
    }
}
