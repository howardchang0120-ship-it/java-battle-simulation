package a;

public class Warrior extends ROLE {

    public Warrior(String name) {
        super(name, 400, 100);
    }

    public void NewMoon(ROLE target) {
        if (magic < 10) {
            System.out.println(name + " 的魔力不足，無法發動新月劍法！");
            return;
        }

        magic -= 10;

        int damage;

        if (target instanceof Warrior) {
            damage = 25;
        }
        else if (target instanceof Witch) {
            damage = 40;
        }
        else {
            damage = 30; // 牧師
        }

        target.takeDamage(damage);

        System.out.println(
            name + " 對 " + target.getName()
            + " 發動【新月劍法】，造成 " + damage + " 點傷害。"
        );

        if (target.isDead()) {
            System.out.println(
                ">>> 死亡判定：" + target.getName() + " 已經陣亡！"
            );
        }
    }

    @Override
    public void attack(ROLE target) {
        NewMoon(target);
    }

    @Override
    public String toString() {
        return "Warrior [Name=" + name
            + ", Life=" + life + ", Magic=" + magic + "]";
    }
}

