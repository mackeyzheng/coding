class SnakeGame {

    private final int width;
    private final int height;
    private final Snake snake;
    private final int[][] food;
    private int foodPos;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snake = new Snake(0);
        this.food = food;
        foodPos = 0;
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        // snake is dead, game over
        if (!snake.isLive) {
            return -1;
        }

        int[] next = getNextPosition(snake.head(), direction);
        if (next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width) {
            // out of board, snake is dead
            snake.isLive = false;
        } else {
            boolean flag = isFood(next);
            if (flag) {
                foodPos++;
            }
            snake.move(convert(next[0], next[1]), flag);
        }

        return snake.isLive ? snake.length()-1 : -1;
    }

    boolean isFood(int[] pos) {
        return foodPos < food.length && Arrays.equals(pos, food[foodPos]);
    }

    private int convert(int x, int y) {
        return x * width + y;
    }

    private int[] parse(int pos) {
        int[] res = new int[2];
        res[0] = pos / width;
        res[1] = pos % width;
        return res;
    }

    private int[] getNextPosition(int pos, String direction) {
        int[] res = parse(pos);
        switch (direction) {
            case "U":
                res[0]--;
                break;
            case "D":
                res[0]++;
                break;
            case "L":
                res[1]--;
                break;
            case "R":
                res[1]++;
                break;
        }
        return res;
    }

    class Snake {
        Deque<Integer> position;
        Set<Integer> body;
        boolean isLive;

        Snake(int pos) {
            position = new ArrayDeque<>();
            body = new HashSet<>();
            position.addFirst(pos);
            body.add(pos);
            isLive = true;
        }

        void move(int pos, boolean isFood) {
            // remove tail first
            int tail = position.removeLast();
            body.remove(tail);

            // touch itself
            if (body.contains(pos)) {
                isLive = false;
                return;
            }

            // eat air or food at position
            position.addFirst(pos);
            body.add(pos);

            // if eats a food, put previous tail back to increas body length
            if (isFood) {
                position.addLast(tail);
                body.add(tail);
            }
        }

        int length() {
            return position.size();
        }

        int head() {
            return position.getFirst();
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
