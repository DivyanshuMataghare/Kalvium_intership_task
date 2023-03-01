import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;

public class MinimumCoin {
    public static int[] CalculateMinCoins(int[] denomination,int amount){
        int[] result = new int[denomination.length];
        int remaningAmount = amount;
        for(int i= denomination.length-1;i>=0;i--){
            int currentDenomination = denomination[i];
            int numCoins = remaningAmount / currentDenomination;
            result[i] = numCoins;
            remaningAmount -= numCoins * currentDenomination;
        }
        if(remaningAmount !=0){
            throw new IllegalArgumentException("Cannot make exact change");
        }
        return result;
    }
    public static void main(String[] args) {
        int[] britishPoundDenominations = {1, 2, 5, 10, 20, 50};
        int[] usDollarDenominations = {1, 5, 10, 25};
        int[] norwegianKroneDenominations = {1, 5, 10, 20};

        int amount =43;
        int[] minConins = CalculateMinCoins(britishPoundDenominations,amount);
        System.out.println(Arrays.toString(minConins));

        amount = 67;
        minConins = CalculateMinCoins(usDollarDenominations,amount);
        System.out.println(Arrays.toString(minConins));

        amount = 27;
        minConins = CalculateMinCoins(norwegianKroneDenominations,amount);
        System.out.println(Arrays.toString(minConins));
    }
}
