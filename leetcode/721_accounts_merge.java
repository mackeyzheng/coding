class Solution {
    // union-find
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Account> map = new HashMap<>(); // email, parent group
        List<Account> allAccounts = new ArrayList<>();
        for (List<String> accountInfo : accounts) {
            Account account = new Account(accountInfo.get(0));
            allAccounts.add(account);
            for (int i = 1; i < accountInfo.size(); i++) {
                String email = accountInfo.get(i);
                if (!map.containsKey(email)) {
                    // not in this graph
                    map.put(email, account);
                    account.emails.add(email);

                } else {
                    // already in this graph
                    // do union merge
                    Account parentRoot = find(map.get(email));
                    Account curRoot = find(account);
                    parentRoot.parent = curRoot;
                }
            }
        }

        for (Account account : allAccounts) {
            if (account.parent != account) {
                Account root = find(account);
                root.emails.addAll(account.emails);
            }
        }

        List<List<String>> ret = new ArrayList<>();
        for (Account account : allAccounts) {
            if (account.parent == account) {
                List<String> tmp = new ArrayList<>(account.emails);
                Collections.sort(tmp);
                tmp.add(0, account.name);
                ret.add(tmp);
            }
        }

        return ret;
    }

    private Account find(Account account) {
        // find root
        Account root = account;
        while (root.parent != root) {
            root = root.parent;
        }
        // compress path
        Account cur = account;
        while (cur.parent != root) {
            Account next = cur.parent;
            cur.parent = root;
            cur = next;
        }
        return root;
    }

    class Account {
        String name;
        List<String> emails;
        Account parent;
        Account(String name) {
            this.name = name;
            emails = new ArrayList<>();
            parent = this;
        }
    }

    // Build graph + DFS
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>(); // email, list of neighbors
        Map<String, String> names = new HashMap<>(); // email, account name
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                names.putIfAbsent(account.get(i), name);
                if (i > 1) {
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }

        // the graph looks like 0-1-2-3-4, 5-6
        // thus use dfs
        Set<String> visited = new HashSet<>();
        for (String email : names.keySet()) {
            if (!visited.contains(email)) {
                List<String> entry = new ArrayList<>();
                dfs(email, graph, visited, entry);
                Collections.sort(entry);
                entry.add(0, names.get(email));
                ret.add(entry);
            }
        }
        return ret;
    }

    private void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> entry) {
        if (visited.contains(email)) {
            return;
        }
        visited.add(email);
        entry.add(email);
        if (graph.containsKey(email)) {
            for (String next : graph.get(email)) {
                dfs(next, graph, visited, entry);
            }
        }
    }
}
