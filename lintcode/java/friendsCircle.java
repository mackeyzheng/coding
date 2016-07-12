static int friendCircles(String[] friends) {
    if (friends == null || friends.length == 0) return 0;

    int circles = 0;
    int N = friends.length;
    // queue and visited flag for BFS
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N];

    // visit the first friend
    queue.offer(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
        int cur = queue.poll();
        char[] friendsOfCur = friends[cur].toCharArray();
        for (int i = 0; i < N; i++) {
            if (friendsOfCur[i] == 'Y' && i != cur && !visited[i]) {
                queue.offer(i);
                visited[i] = true;
            }
        }

        if (queue.isEmpty()) {
            circles++;
            for (int i = 0; i < N; i++) {
                if (visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                    break;
                }
            }
        }
    }

    return circles;
}
