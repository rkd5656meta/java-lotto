package edu.nextstep.camp.lotto;

import edu.nextstep.camp.lotto.controller.LottoController;
import edu.nextstep.camp.lotto.domain.AutoLottoFactory;
import edu.nextstep.camp.lotto.domain.LastWinLotto;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.view.ConsoleLottoOutputView;
import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new AutoLottoFactory(), new ConsoleLottoOutputView());

        try {
            OutputView.print("구입금액을 입력해 주세요.");
            Lottos lottos = controller.buyLottos(InputView.input());

            OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
            String[] lastWinLotto = InputView.input().split(",");

            OutputView.print("보너스 번호를 입력해 주세요");
            controller.analysisLotto(lottos, LastWinLotto.of(InputView.input(), lastWinLotto));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
