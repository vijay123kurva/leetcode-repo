class Solution {
    public int alternateDigitSum(int n) {
        int evenSum = 0;
        int oddSum = 0;
        String s = n+"";
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                evenSum+=s.charAt(i)-'0';
            }else{
                oddSum +=s.charAt(i)-'0';
            }
        }
        return evenSum-oddSum;
        
    }
}