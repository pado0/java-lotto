package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또에 숫자가 몇 개 포함되었는지 카운트한다.")
    @Test
    void getHits() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> other = Arrays.asList(1, 2, 3, 10, 11, 12);
        Lotto lotto = new Lotto(numbers);
        Lotto otherLotto = new Lotto(other);
        Assertions.assertThat(lotto.countHits(otherLotto)).isEqualTo(3);
    }

    @DisplayName("로또에 2등 보너스볼이 포함되어있는지 확인한다.")
    @Test
    void matchBonus() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        Integer bonusNumber = 6;
        Assertions.assertThat(lotto.matchBonus(bonusNumber)).isTrue();
    }

    @DisplayName("로또가 7자리 이상이면 오류이다.")
    @Test
    void lengthExceedException() {

        assertThatThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 중복되는 숫자가 있으면 오류이다.")
    @Test
    void duplicatedExceltion() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 7)));
    }
}