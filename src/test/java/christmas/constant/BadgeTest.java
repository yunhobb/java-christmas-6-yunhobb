package christmas.constant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Badge의")
class BadgeTest {

    @DisplayName("가격에 따라 별뱃지가 반환되는가")
    @Test
    void match_badge_star() {
        //given & when
        final Badge badge = Badge.getBadge(20_000);

        //then
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @DisplayName("가격에 따라 트리뱃지가 반환되는가")
    @Test
    void match_badge_tree() {
        //given & when
        final Badge badge = Badge.getBadge(10_000);

        //then
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @DisplayName("가격에 따라 산타뱃지가 반환되는가")
    @Test
    void match_badge_santa() {
        //given & when
        final Badge badge = Badge.getBadge(5_000);

        //then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @DisplayName("가격에 따라 반활될 뱃지가 없는가")
    @Test
    void match_badge_none() {
        //given & when
        final Badge badge = Badge.getBadge(0);

        //then
        assertThat(badge).isEqualTo(Badge.NONE);
    }
}
