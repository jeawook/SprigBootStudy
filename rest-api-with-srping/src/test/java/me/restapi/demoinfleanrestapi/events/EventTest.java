package me.restapi.demoinfleanrestapi.events;


import junitparams.JUnitParamsRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring").build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        //given
        String name = "Event";
        String description = "Spring";
        //when
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);
        //then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }
    @ParameterizedTest
    @MethodSource("testFreeParams")
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();
        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);

    }
    private static Object[] testFreeParams() {
        return new Object[]{
                new Object[]{0, 0, true},
                new Object[]{100, 0, false},
                new Object[]{0, 100, false}
        };
    }
    @ParameterizedTest
    @MethodSource("testOfflineParams")
    public void testOffline(String location, boolean isOffline) {
        // Given
        Event event = Event.builder()
                .location(location)
                .build();
        // When
        event.update();

        // Then
        assertThat(event.isOffline()).isEqualTo(isOffline);
    }

    private static Object[] testOfflineParams() {
        return new Object[]{
                new Object[]{"강남역 네이버 D2 스타트업 팩토리", true},
                new Object[]{null, false},
                new Object[]{"   ", false}
        };
    }


}