import java.util.*;
import java.lang.Math;

class Solution {
    static int[][] currency; 
    static int[] gives, receives;
    static Map<String, Integer> indexes = new HashMap<>();
    static int[] bonus;

    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        init(friends);
        setGift(gifts);
        answer = getMostGiver(friends.length);
        
        return answer;
    }
    public int getMostGiver(int size){
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                if(compare(i, j) == true){
                    bonus[i]++;
                    continue;
                }
                if(compare(j, i) == true){
                    bonus[j]++;                        
                    continue;
                }
                if(currency[i][j] == currency[j][i]){
                    int aRate = gives[i]-receives[i];
                    int bRate = gives[j]-receives[j];
                    if(aRate > bRate) {
                       bonus[i]++;
                    }    
                    if(aRate < bRate){
                        bonus[j]++;
                    }
                }
            }
        }
     
        return getAnswer(size);
    }
    
    public int getAnswer(int size){
        int answer = 0;
        answer = bonus[0];
        for(int i = 1; i < size-1; i++){
            System.out.println(bonus[i+1]);
            answer = Math.max(answer, bonus[i+1]);
        }
        return answer;
    }
    
    public boolean compare(int A, int B){
        if(currency[A][B] > currency[B][A]){
            return true;
        }
               
        return false;
    }
    
    public void setGift(String[] gifts){
        StringTokenizer st;
        for(String gift : gifts){
            st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            
            addTotalGifts(from, to);
            currency[indexes.get(from)][indexes.get(to)]++;
        }
    }
    
    public void addTotalGifts(String giver, String receiver){
        gives[indexes.get(giver)]++;
        receives[indexes.get(receiver)]++;
    }
    
    public void init(String[] friends){
        int size = friends.length;
        
        currency = new int[size][size];
        gives = new int[size];
        receives=new int[size];
        bonus = new int[size];
        
        for(int i=0; i<size; i++){
            indexes.put(friends[i], i);
        }
    }
}