package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("ReservationDate의")
class ReservationDateTest {

    @DisplayName("추가일수가 반환되는가ㅂ")
    @Test
    void calculate_add_day() {
        //given
        final ReservationDate reservationDate = new ReservationDate(8);
        final Integer expectedAddDay = 8 - 1;

        //when
        final Integer actualAddDay = reservationDate.calculateAddDay();

        //then
        assertThat(actualAddDay).isEqualTo(expectedAddDay);
    }

    @DisplayName("날짜 검증시")
    @Nested
    class validate {

        @DisplayName("날짜가 범위가 넘어가면 예외를 던지는가")
        @Test
        void validate_date() {
            //given
            Integer date = 32;

            //when & then
            assertThatThrownBy(() -> new ReservationDate(date))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("날짜가 정상적으로 들어가면 반환되는가")
        @Test
        void normal_date() {
            //given
            Integer date = 31;

            //when & then
            assertThatNoException()
                    .isThrownBy(() -> new ReservationDate(date));
        }
    }

    @DisplayName("요일 검증시")
    @Nested
    class check_holiday {

        @DisplayName("")
        @Test
        void is_holiday() {
            //given
            final ReservationDate reservationDate = new ReservationDate(8);

            //when & then
            assertThat(reservationDate.isHoliday()).isTrue();
        }

        @DisplayName("")
        @Test
        void is_non_holiday() {
            //given
            final ReservationDate reservationDate = new ReservationDate(7);

            //when & then
            assertThat(reservationDate.isHoliday()).isFalse();
        }
    }
}