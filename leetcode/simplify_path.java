public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        Stack<String> dirs = new Stack<String>();

        int i = 0;
        while (i++ < path.length()) {
            String dir = "";
            if (i < path.length()) {
                int j = path.indexOf("/", i);
                dir = j == -1 ? path.substring(i) : path.substring(i, j);
                i = j == -1 ? path.length() : j;
            }

            if (!dir.isEmpty() && !dir.equals(".")) { // . or consecutive /, it should be ignored
                if (dir.equals("..")) {
                    if (!dirs.isEmpty()) {
                        dirs.pop();
                    }
                } else {
                    dirs.push(dir);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (dirs.isEmpty()) {
            sb.append("/");
        } else {
            while (!dirs.isEmpty()) {
                sb.insert(0, "/" + dirs.pop());
            }
        }

        return sb.toString();
    }
}
