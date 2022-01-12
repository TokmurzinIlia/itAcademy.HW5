package dataProvider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DaraProviderCheckComputersAndNetworksSections implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                "Ноутбуки, компьютеры, мониторы",
                "Комплектующие",
                "Техника для печати и дизайна",
                "Манипуляторы и устройства ввода",
                "Хранение данных",
                "Мультимедиа периферия",
                "Сетевое оборудование",
                "Аксессуары к ноутбукам и компьютерам",
                "Электропитание",
                "Игры и программное обеспечение").map(Arguments::of);
    }
}
