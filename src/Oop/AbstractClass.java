package Oop;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class AbstractClass {

    public static void main(String[] args) {
        // 给一个有工资收入和稿费收入的小伙伴算税:
        IncomeAbstract[] incomeAbstracts = new IncomeAbstract[] { new SalaryIncomeAbstract(7500), new RoyaltyIncomeAbstract(12000) };
        double total = 0;
        for (IncomeAbstract incomeAbstract : incomeAbstracts) {
            total += incomeAbstract.getTax();

            System.out.println(total);
        }
        System.out.println(total);
    }

}

abstract class IncomeAbstract {

    protected double income;

    public IncomeAbstract(double income) {
        this.income = income;
    }

    public abstract  double getTax();
}

class SalaryIncomeAbstract extends IncomeAbstract {

    public SalaryIncomeAbstract(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

/**
 * 稿费收入税率是20%
 */
class RoyaltyIncomeAbstract extends IncomeAbstract {
    public RoyaltyIncomeAbstract(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return this.income * 0.2;
    }
}