package Tool;

public final class Keys {

    private static final int NUM_KEYS = 91;

    private static boolean keyState[] = new boolean[NUM_KEYS];
    private static boolean prevKeyState[] = new boolean[NUM_KEYS];

    public static void update() {
        System.arraycopy(keyState, 0, prevKeyState, 0, NUM_KEYS);
    }

    public static void keySet(int i, boolean b) {
        if (i < NUM_KEYS) {
            keyState[i] = b;
        }
    }

    public static boolean isDown(int i) {
        return keyState[i];
    }

    public static boolean isPressed(int i) {
        return keyState[i] && !prevKeyState[i];
    }
}