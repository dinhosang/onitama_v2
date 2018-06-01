package helpers.factories;

import constants.GameMode;
import helpers.IContainer;
import helpers.ICreate;

public class NonConcurrentCardFactory implements ICreate {

    public static void createItems(Enum requestType, IContainer container) {



        if(requestType.equals(GameMode.STANDARD)){
            setupStandardModeCardCreation()
        }
    }

    private static Boolean check
}
