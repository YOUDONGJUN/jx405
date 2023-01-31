package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bitcomputer_hw {

    static final String ELIMINATED = "eliminated";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int numOfCandidates = Integer.parseInt(br.readLine());

        String[] candidates = new String[numOfCandidates];
        for (int i = 0; i < numOfCandidates; i++)
            candidates[i] = br.readLine();


        ArrayList<int[]> votes = new ArrayList<int[]>();
        String line;
        while (true) {
            line = br.readLine();
            if (line == null || line.equals(""))
                break;

            int[] vote = new int[numOfCandidates];
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < numOfCandidates; i++)
                vote[i] = Integer.parseInt(st.nextToken()) - 1;

            votes.add(vote);
        }

        //출력
        String winner = getWinner(votes.toArray(new int[votes.size()][]), candidates);
        System.out.println(winner);
    }

    private static String getWinner(int[][] votes, String[] candidates) {
        int[] score = new int[candidates.length];

        while (true) {
            int[] voteResult = getVoteResult(score, votes, candidates);
            int Midx = voteResult[0];
            int midx = voteResult[1];
            int totalVotes = votes.length;

            if (score[Midx] == score[midx]) {
                ArrayList<String> names = new ArrayList<String>();

                for (int i = 0; i < candidates.length; i++)
                    if (candidates[i].equals(ELIMINATED))
                        names.add(candidates[i]);

                return names.toString();

            } else if (score[Midx] * 2 >= totalVotes) {
                return candidates[Midx];
            }

            for (int i = 0; i < candidates.length; i++)
                if (score[i] == score[midx])
                    candidates[i] = ELIMINATED;
        }
    }

    private static int[] getVoteResult(int[] score, int[][] votes, String[] candidates) {
        resetScore(score);
        for (int i = 0; i < votes.length; i++) {
            score[getIdx(votes[i], candidates)] += 1;
        }

        int Midx = 0;
        int midx = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (!candidates[i].equals(ELIMINATED)) {
                if (score[i] > score[Midx])
                    Midx = i;
                else if (score[i] < score[midx])
                    midx = i;
            }
        }
        return new int[]{Midx, midx};
    }

    private static void resetScore(int[] score) {
        for (int i = 0; i < score.length; i++)
            score[i] = 0;
    }

    //탈락되지 않은 후보자들 중
    //투표자의 1순위 후보 인덱스 추출
    private static int getIdx(int[] vote, String[] candidates) {
        for (int i = 0; i < vote.length; i++) {
            if (!candidates[vote[i]].equals(ELIMINATED))
                return vote[i];
        }
        return -1;
    }
}

