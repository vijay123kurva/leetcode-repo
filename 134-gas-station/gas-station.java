class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0,totalCost = 0;
        for(int g: gas){
            totalGas +=g;
        }
        for(int c :cost){
            totalCost +=c;
        }
        if(totalGas<totalCost) return -1;
        int start = 0;
        int currGas = 0;
        for(int i=0;i<gas.length;i++){
            currGas+=gas[i]-cost[i];
            if(currGas<0){
                currGas = 0;
                start = i+1;
            }
        }
        return start;

    }
}