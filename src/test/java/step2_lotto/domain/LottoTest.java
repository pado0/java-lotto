package step2_lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @DisplayName("로또에 숫자가 몇 개 포함되었는지 카운트한다.")
    @Test
    void compareCount() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> other = List.of(1, 2, 3, 7, 7, 7);
        Lotto lotto = new Lotto(numbers);
        Lotto otherLotto = new Lotto(other);
        Assertions.assertThat(lotto.compareCount(otherLotto)).isEqualTo(3);
    }
}