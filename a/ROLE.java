package a;

public abstract class ROLE {
    protected String name;
    protected int life;
    protected int magic;

    public ROLE(String name, int life, int magic) {
        this.name = name;
        this.life = life;
        this.magic = magic;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getMagic() {
        return magic;
    }

    public void takeDamage(int damage) {
        this.life -= damage;
    }

    public boolean isDead() {
        return this.life <= 0;
    }

    public abstract void attack(ROLE target);

    // 統一處理紅藥水和藍藥水
    public void Drink(Drug D) {
        if (D instanceof RedDrug) {
            RedDrug R = (RedDrug) D;

            life += R.getAddLife();

            System.out.println(
                name + " 喝了 " + R.getSize()
                + " 紅藥水，生命增加 " + R.getAddLife()
                + "，目前生命：" + life
            );
        }
        else if (D instanceof BlueDrug) {
            BlueDrug B = (BlueDrug) D;

            magic += B.getAddMagic();

            System.out.println(
                name + " 喝了 " + B.getSize()
                + " 藍藥水，魔力增加 " + B.getAddMagic()
                + "，目前魔力：" + magic
            );
        }
    }
    private String randomSize() {
        int n = (int) (Math.random() * 100);

        if (n < 10) {
            return "Large";       // 10%
        }
        else if (n < 40) {
            return "Medium";      // 30%
        }
        else if (n < 80) {
            return "Small";       // 40%
        }
        else {
            return null;         // 20%，沒有藥水
        }
    }
    public void checkDrug() {
        if (isDead()) {
            return;
        }

        if (life < 100) {
            String size = randomSize();

            if (size != null) {
                Drink(new RedDrug(size));
            }
            else {
                System.out.println(name + " 沒有紅藥水！");
            }
        }

        if (magic < 70) {
            String size = randomSize();

            if (size != null) {
                Drink(new BlueDrug(size));
            }
            else {
                System.out.println(name + " 沒有藍藥水！");
            }
        }
    }
}
