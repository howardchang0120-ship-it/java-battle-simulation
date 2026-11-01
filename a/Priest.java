package a;

public class Priest extends ROLE {

    public Priest(String name) {
        super(name, 340, 160);
    }

    public void Dark(ROLE target) {
        if (magic < 20) {
            System.out.println(name + " 的魔力不足，無法施放黑暗術！");
            return;
        }

        magic -= 20;

        int damage;

        if (target instanceof Warrior) {
            damage = 30;
        }
        else if (target instanceof Witch) {
            damage = 50;
        }
        else {
            damage = 40; // 牧師
        }

        target.takeDamage(damage);

        System.out.println(
            name + " 對 " + target.getName()
            + " 施放【黑暗術】，造成 " + damage + " 點傷害。"
        );

        if (target.isDead()) {
            System.out.println(
                ">>> 死亡判定：" + target.getName() + " 已經陣亡！"
            );
        }
    }

    @Override
    public void attack(ROLE target) {
        Dark(target);
    }

    @Override
    public String toString() {
        return "Priest [Name=" + name
            + ", Life=" + life + ", Magic=" + magic + "]";
    }
}
