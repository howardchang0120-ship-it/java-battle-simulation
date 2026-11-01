package a;

public class Main5 {

    public static void main(String[] args) {

        ROLE[] roles = new ROLE[6];

        roles[0] = new Warrior("戰士1");
        roles[1] = new Warrior("戰士2");
        roles[2] = new Witch("女巫1");
        roles[3] = new Witch("女巫2");
        roles[4] = new Priest("牧師1");
        roles[5] = new Priest("牧師2");

        System.out.println("--- 異質陣列大亂鬥開始 ---");

        int round = 1;

        while (true) {
            System.out.println("\n【第 " + round + " 回合】");

            // 隨機選出攻擊者
            int attackerIndex =
                (int) (Math.random() * roles.length);

            // 隨機選出不同的攻擊目標
            int targetIndex;

            do {
                targetIndex =
                    (int) (Math.random() * roles.length);
            } while (attackerIndex == targetIndex);

            ROLE attacker = roles[attackerIndex];
            ROLE target = roles[targetIndex];

            attacker.checkDrug();
            target.checkDrug();

            attacker.attack(target);

            if (target.isDead()) {
                break;
            }

            round++;
        }

        System.out.println(
            "\n--- 戰鬥結束，列出所有角色最終狀態 ---"
        );

        for (ROLE r : roles) {
            System.out.println(r);
        }
    }
}
