class Solution {
    private static int timeSkill = 1;
    private static int timeNow = 1;
    private static final int DEAD = -1;
    private static int MAX;
    
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        MAX = health;
        for (int [] attack: attacks){
            while (timeNow <= attack[0]){
                if (timeNow < attack[0]){
                    health = healing(bandage, health);
                } else if (timeNow == attack[0]){
                    health = attack(attack[1], health);
                }
                if (isDead(health)){
                    return DEAD;
                }
                process();
            }
        }
        if (isDead(health)){
            return DEAD;
        }
        return health;
    }
    
    private boolean isDead(int health){
        if (health <= 0){
            return true;
        }
        return false;
    }
    
    private int attack(int damage, int health){
        timeSkill=0;
        return health - damage;
    }
    
    private int healing(int[] bandage, int health){
        if (bandage[0] == timeSkill){
            health += bandage[2];
            timeSkill=0;
        }
        return health + bandage[1] <= MAX? health + bandage[1] : MAX;
    }
    
    private void process(){
        timeNow++;
        timeSkill++;
    }
    
}
    