package dataProvider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DaraProviderCheckComputersAndNetworksSectionsElement implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                "notebook",
                "videocard",
                "printers",
                "mouse",
                "ssd",
                "sound",
                "wrouter",
                "notebookcase?bag_purpose%5B0%5D=type3&bag_purpose%5Boperation%5D=union",
                "ups",
                "pcgames").map(Arguments::of);
    }
}
