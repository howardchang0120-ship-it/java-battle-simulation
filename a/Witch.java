package a;

public class Witch extends ROLE {

    public Witch(String name) {
        super(name, 280, 200);
    }

    public void SmallFire(ROLE target) {
        if (magic < 25) {
            System.out.println(name + " 的魔力不足，無法施放小火球！");
            return;
        }

        magic -= 25;

        int damage;

        if (target instanceof Warrior) {
            damage = 40;
        }
        else if (target instanceof Witch) {
            damage = 60;
        }
        else {
            damage = 50; // 牧師
        }

        target.takeDamage(damage);

        System.out.println(
            name + " 對 " + target.getName()
            + " 施放【小火球】，造成 " + damage + " 點傷害。"
        );

        if (target.isDead()) {
            System.out.println(
                ">>> 死亡判定：" + target.getName() + " 已經陣亡！"
            );
        }
    }

    @Override
    public void attack(ROLE target) {
        SmallFire(target);
    }

    @Override
    public String toString() {
        return "Witch [Name=" + name
            + ", Life=" + life + ", Magic=" + magic + "]";
    }
}

