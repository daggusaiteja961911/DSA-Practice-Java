package org.example.Arrays;

public class LetterTilesPossibilites {
    // LeetCode 1079
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];// Frequency array for letters A-Z
        for (char c : tiles.toCharArray()) //loop iterates over each character c in the input string tiles.
            {
            freq[c - 'A']++; //c - 'A' converts the character c to an index.freq[c - 'A']++ increments the count of that letter.
        }
        return backtrack(freq);
    }

    private int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                count += 1 + backtrack(freq);
                freq[i]++;
            }
        }
        return count;//dry run this method if not understand :)
    }
    public static void main(String[] args) {
        LetterTilesPossibilites solution = new LetterTilesPossibilites();
        String tiles = "AAB";
        int result = solution.numTilePossibilities(tiles);
        System.out.println("Number of possible sequences for tiles " + tiles + " is: " + result);
    }
}
