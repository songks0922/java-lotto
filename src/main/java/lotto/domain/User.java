package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;
    private int lottoCount;
    private int rewardMoney;

    private List<Lotto> lottos = new ArrayList<>();
    //TODO: 당첨 결과 리스트 추가, 로또금액 1000원 상수화
    private User(int money) {
        this.money = money;
        this.lottoCount = money / 1000;
    }

    public static User initUserLotto(int money) {
        User user = new User(money);

        for (int i = 0; i < user.getLottoCount(); i++) {
            user.addUserLotto();
        }

        return user;
    }

    public void addUserLotto() {
        lottos.add(Lotto.generateLottoNumber());
    }

    //validate check
    public void checkMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
    }
    
    //getter and setter
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(int rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
