package dataProvider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DataProviderComputersAndNetworksAccessoriesSection implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                        "videocard",
                        "cpu" ,
                        "motherboard" ,
                        "dram" ,
                        "fan" ,
                        "ssd" ,
                        "hdd" ,
                        "chassis" ,
                        "powersupply" ,
                        "soundcard?type_soundcard%5B0%5D=internal&type_soundcard%5Boperation%5D=union" ,
                        "networkadapter" ,
                        "optical" ,
                        "tvtuner?execution_tvtune%5B0%5D=in&execution_tvtune%5Boperation%5D=union" ).map(Arguments::of);
    }
}
