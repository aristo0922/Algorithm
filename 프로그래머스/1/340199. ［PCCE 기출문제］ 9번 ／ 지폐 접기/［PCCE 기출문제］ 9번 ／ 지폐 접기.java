class Solution {
    static int walletA, walletB;
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지폐가 긴 쪽을 반으로 접는다.
        // 길이는 무조건 자연수. 소수점 이하는 버린다.
        // 지갑에 지폐를 넣는다.
        // 지갑 가로세로, 지폐의 가로세로
        System.out.println(bill[0] + " "+bill[1]);
        walletA = wallet[0];
        walletB = wallet[1];
        
        while(canHold(bill) != true){
            foldBill(bill);
            answer++;
            System.out.println(bill[0] + " "+bill[1]);
        }
        
        return answer;
    }
    
    private static void foldBill(int[] bill){
        if(bill[0] > bill[1]){
            bill[0] /= 2;
            return;
        }
        bill[1] /=2;
        
    }
    
    private static boolean canHold(int[] bill){
        if(walletA >= bill[0] && walletB >= bill[1])
            return true;
        if(walletB >= bill[0] && walletA >= bill[1])
            return true;
        
        return false;
    }
}