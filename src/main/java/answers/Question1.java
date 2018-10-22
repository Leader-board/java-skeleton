package answers;

public class Question1 {
    // front to back and not other way round.
	public static int bestMergedPortfolio(int[] portfolios) {
        int[][] main = new int[100][];
        for (int i = 0; i < portfolios.length; i++) {
            for (int j = 0; (j / portfolios[i] / 2 ^ j) >= 1; j++) {
                main[i][j] = portfolios[i] % (2 ^ j);
            }
        }
        int newvalue = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i < j) {
                    int fin[] = new int[16];
                    for (int k = 0; k < 16; k++) {
                        if (main[i][k] != main[j][k]) {
                            fin[k] = 1;
                        } else
                            fin[k] = 0;
                    }
                    int value = 0;
                    for (int l = 0; l < 16; i++) // inefficient
                    {
                        value = value + 2 ^ (l) * fin[l];
                    }
                    if (value > newvalue)
                        newvalue = value;

                }
            }
        }
        return newvalue;
	}

}
