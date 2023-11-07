package medium;
import java.util.*;

class TopVotedCandidate {
    private int[] persons;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
    }

    public int q(int t) {
        //在第一票投出前
        if (t < times[0]){
            return -1;
        }
        int k = times.length;
        Map <Integer, Integer> personVoteMap = new HashMap();
        for (int i=0; i<times.length; i++){
            if (t < times[i]){
                k = i;
                break;
            }
        }
        int maxVote = 0;
        int maxPerson = 0;

        for (int i=0; i < k; i++){
            if (personVoteMap.containsKey(this.persons[i])){
                int currentVote = personVoteMap.get(this.persons[i])+1;
                personVoteMap.put(this.persons[i], currentVote);
                if (currentVote >= maxVote){
                    maxPerson = this.persons[i];
                    maxVote = currentVote;
                }
            }
            else{
                personVoteMap.put(this.persons[i],1);
                if (1 >= maxVote){
                    maxPerson = this.persons[i];
                    maxVote = 1;
                }
            }
        }
        return maxPerson;
    }

    public static void main(String[] args) {
        int[] person = {0,1,1,0,0,1,0};
        int[] times = {0,5,10,15,20,25,30};
        TopVotedCandidate case1 = new TopVotedCandidate(person,times);
        System.out.println(case1.q(25));
    }
}

